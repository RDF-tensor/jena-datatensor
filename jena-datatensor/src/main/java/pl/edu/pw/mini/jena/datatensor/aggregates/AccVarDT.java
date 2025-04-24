package pl.edu.pw.mini.jena.datatensor.aggregates;

import org.apache.jena.sparql.expr.Expr;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;

public class AccVarDT extends AccumulatorBaseDT {
    public AccVarDT(Expr expr, boolean distinct) {
        super(expr, distinct);
    }

    @Override
    protected INDArray calc() {
        if (count < 2) {
            throw new ExprEvalException("Var requires at least 2 values");
        }
        INDArray sumCasted = this.sum.castTo(DataType.DOUBLE);
        INDArray squaredCasted = this.squaredSum.castTo(DataType.DOUBLE);
        INDArray result = squaredCasted.sub(sumCasted.mul(sumCasted.div(count)));
        return result.div(count - 1);
    }
}
