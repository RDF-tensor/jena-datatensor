package pl.edu.pw.mini.jena.datatensor.aggregates;

import org.apache.jena.sparql.expr.Expr;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;

public class AccAvgDT extends AccumulatorBaseDT {
    public AccAvgDT(Expr expr, boolean distinct) {
        super(expr, distinct);
    }

    @Override
    protected INDArray calc() {
        return this.sum.dataType().isFPType() ? this.sum.div(count) : this.sum.castTo(DataType.DOUBLE).div(count);
    }
}
