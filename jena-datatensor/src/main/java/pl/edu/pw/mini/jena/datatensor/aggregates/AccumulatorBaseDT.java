package pl.edu.pw.mini.jena.datatensor.aggregates;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.expr.aggregate.AccumulatorExpr;
import org.apache.jena.sparql.function.FunctionEnv;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.utils.ND4JUtils;

abstract public class AccumulatorBaseDT extends AccumulatorExpr {
    protected INDArray sum = null;
    protected INDArray squaredSum = null;
    protected DataType dataType = null;
    protected long count = 0;

    public AccumulatorBaseDT(Expr expr, boolean distinct) {
        super(expr, distinct);
    }


    @Override
    protected NodeValue getAccValue() {
        if (super.errorCount != 0 || count == 0) {
            return null;
        }
        try {
            INDArray result = calc();
            return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
        } catch (ExprEvalException e) {
            return null;
        }
    }

    abstract protected INDArray calc();

    @Override
    protected void accumulate(NodeValue nodeValue, Binding binding, FunctionEnv functionEnv) {
        RDFDatatype rdfDatatype = nodeValue.asNode().getLiteralDatatype();
        if (rdfDatatype.equals(NumericDataTensor.INSTANCE)) {
            INDArray value = (INDArray) nodeValue.getNode().getLiteralValue();
            try {
                if (sum == null) {
                    sum = value.dup();
                    squaredSum = value.mul(value);
                    count = 1;
                    dataType = value.dataType();
                } else {
                    dataType = ND4JUtils.getSupportedOperationType(sum, value);
                    value = value.dataType().equals(dataType) ? value : value.castTo(dataType);
                    sum = sum.dataType().equals(dataType) ? sum : sum.castTo(dataType);
                    sum = sum.addi(value);
                    squaredSum = squaredSum.dataType().equals(dataType) ? squaredSum : squaredSum.castTo(dataType);
                    squaredSum = squaredSum.addi(value.mul(value));
                    count++;
                }
            } catch (Exception e) {
                throw new ExprEvalException("Error while accumulating: " + e.getMessage());
            }
        } else {
            throw new ExprEvalException("Invalid input: " + nodeValue);
        }
    }

    @Override
    protected void accumulateError(Binding binding, FunctionEnv functionEnv) {
    }
}
