package pl.edu.pw.mini.jena.datatensor.aggregates;

import org.apache.jena.sparql.expr.Expr;
import org.nd4j.linalg.api.ndarray.INDArray;

public class AccSumDT extends AccumulatorBaseDT {
    public AccSumDT(Expr expr, boolean distinct) {
        super(expr, distinct);
    }

    @Override
    protected INDArray calc() {
        return sum;
    }
}
