package pl.edu.pw.mini.jena.datatensor.aggregates;

import org.apache.jena.sparql.expr.aggregate.AccumulatorFactory;
import org.apache.jena.sparql.expr.aggregate.AggregateRegistry;
import pl.edu.pw.mini.jena.datatensor.vocabulary.AggregatesDT;

public class DTAggregates {

    public static void register() {
        AccumulatorFactory f_avg = (agg, distinct) -> new AccAvgDT(agg.getExpr(), false);
        AccumulatorFactory f_sum = (agg, distinct) -> new AccSumDT(agg.getExpr(), false);
        AccumulatorFactory f_var_pop = (agg, distinct) -> new AccVarDT(agg.getExpr(), false);
        AccumulatorFactory f_std_pop = (agg, distinct) -> new AccStdDevDT(agg.getExpr(), false);

        AggregateRegistry.register(AggregatesDT.AVG, f_avg, null);
        AggregateRegistry.register(AggregatesDT.SUM, f_sum, null);
        AggregateRegistry.register(AggregatesDT.VAR, f_var_pop, null);
        AggregateRegistry.register(AggregatesDT.STD, f_std_pop, null);
    }
}
