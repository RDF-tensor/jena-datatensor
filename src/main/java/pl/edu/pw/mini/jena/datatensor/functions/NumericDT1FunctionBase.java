package pl.edu.pw.mini.jena.datatensor.functions;

import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase1;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

abstract public class NumericDT1FunctionBase extends FunctionBase1 {

    public NumericDT1FunctionBase() {
        super();
    }

    public NodeValue exec(NodeValue nodeValue) {
        if (isInvalidInput(nodeValue))
            throw new ExprEvalException("Argument must be the NumericDataTensor datatype");

        try {
            INDArray t1 = (INDArray) (nodeValue.getNode().getLiteralValue());
            INDArray t1Transformed = calc(t1);
            NodeValue result = t1Transformed.isScalar() ? NodeValue.makeDouble(t1Transformed.getDouble(0)) : NodeValue.makeNode(NodeFactory.createLiteralByValue(t1Transformed, NumericDataTensor.INSTANCE));
            return result;
        } catch (Exception ex) {
            throw new ExprEvalException(ex.getMessage(), ex);
        }
    }

    abstract public INDArray calc(INDArray v1);

    public boolean isInvalidInput(NodeValue v1) {
        return !v1.asNode().isLiteral() || !v1.asNode().getLiteralDatatype().equals(NumericDataTensor.INSTANCE);
    }
}
