package pl.edu.pw.mini.jena.datatensor;

import org.apache.jena.atlas.lib.StrUtils;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.core.DatasetGraph;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.engine.binding.Binding;
import org.apache.jena.sparql.expr.aggregate.AggregateRegistry;
import org.apache.jena.sparql.sse.SSE;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.aggregates.DTAggregates;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AggregatesTest {
    static String NL = System.getProperty("line.separator");
    static String PRE = StrUtils.strjoinNL(
            "PREFIX dta: <https://w3id.org/rdf-tensor/aggregates#>",
            "PREFIX dt: <https://w3id.org/rdf-tensor/datatypes#>");
    static DatasetGraph ds = SSE.parseDatasetGraph(
            "(dataset (graph (:x :p1 \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[10, 20, 30]}\"^^dt:NumericDataTensor)" +
                    " (:x :p2 \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[3],\\\"data\\\":[15.5, 25.5, 30.5]}\"^^dt:NumericDataTensor) " +
                    " (:x :p3 \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[3],\\\"data\\\":[1.55E1, 2.55E1, 3.05E1]}\"^^dt:NumericDataTensor) " +
                    " (:x :p4 \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[10, 20, 30]}\"^^dt:NumericDataTensor) " +
                    " (:x :p5 \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[10, 20, 30]}\"^^dt:NumericDataTensor) ))",
            PrefixMapping.Factory.create().setNsPrefix("dt", "https://w3id.org/rdf-tensor/datatypes#")

    );
    static DatasetGraph dsEmpty = SSE.parseDatasetGraph("(dataset)");
    static DatasetGraph ds1 = SSE.parseDatasetGraph("(dataset (graph (:x :p \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[10, 20, 30]}\"^^dt:NumericDataTensor)) )",
            PrefixMapping.Factory.create().setNsPrefix("dt", "https://w3id.org/rdf-tensor/datatypes#"));

    static INDArray sum_expected = Nd4j.create(new double[]{61, 111, 151});
    static INDArray sum_expected_no_duplicates = Nd4j.create(new double[]{25.5, 45.5, 60.5});
    static INDArray avg_expected = Nd4j.create(new double[]{12.2, 22.2, 30.2});
    static INDArray avg_expected_no_duplicates = Nd4j.create(new double[]{12.75, 22.75, 30.25});
    static INDArray var_expected = Nd4j.create(new double[]{9.075, 9.075, 0.075});
    static INDArray std_expected = Nd4j.create(new double[]{3.0124741, 3.0124741, 0.2738613});


    @Test
    public void agg_stat_registry() {
        assertTrue(AggregateRegistry.isRegistered("https://w3id.org/rdf-tensor/aggregates#avg"));
        assertTrue(AggregateRegistry.isRegistered("https://w3id.org/rdf-tensor/aggregates#var"));
        assertTrue(AggregateRegistry.isRegistered("https://w3id.org/rdf-tensor/aggregates#std"));
        assertTrue(AggregateRegistry.isRegistered("https://w3id.org/rdf-tensor/aggregates#sum"));
        assertFalse(AggregateRegistry.isRegistered("https://w3id.org/rdf-tensor/aggregates#avg2"));
    }

    @Test
    public void agg_stat_avg() {
        String qsAgg = "dta:avg(?x)";
        test(qsAgg, avg_expected);
    }

    @Test
    public void agg_stat_sum() {
        String qsAgg = "dta:sum(?x)";
        test(qsAgg, sum_expected);
    }

    @Test
    public void agg_stat_var() {
        String qsAgg = "dta:var(?x)";
        test(qsAgg, var_expected);
    }

    @Test
    public void agg_stat_std() {
        String qsAgg = "dta:std(?x)";
        test(qsAgg, std_expected);
    }

    // Empty dataset
    @Test
    public void agg_stat_avg_empty() {
        String qsAgg = "dta:avg(?x)";
        testEmpty(qsAgg, dsEmpty);
    }

    @Test
    public void agg_stat_sum_empty() {
        String qsAgg = "dta:sum(?x)";
        testEmpty(qsAgg, dsEmpty);
    }

    @Test
    public void agg_stat_var_empty() {
        String qsAgg = "dta:var(?x)";
        testEmpty(qsAgg, dsEmpty);
    }

    @Test
    public void agg_stat_std_empty() {
        String qsAgg = "dta:std(?x)";
        testEmpty(qsAgg, dsEmpty);
    }

    // Corner cases
    @Test
    public void agg_stat_var_one() {
        String qsAgg = "dta:var(?x)";
        testErr(qsAgg, ds1);
    }

    @Test
    public void agg_stat_std_one() {
        String qsAgg = "dta:std(?x)";
        testErr(qsAgg, ds1);
    }


    private static void test(String qsAgg, INDArray expected) {
        test(qsAgg, expected, ds);
    }

    private static void test(String qsAgg, INDArray expected, DatasetGraph dsg) {
        Query query = buildGroupBy(qsAgg);
        test(query, expected, dsg);
    }

    private static void test(Query query, INDArray expected, DatasetGraph dsg) {
        try (QueryExecution qExec = QueryExecutionFactory.create(query, DatasetFactory.wrap(dsg))) {
            Literal literal = qExec.execSelect().next().getLiteral("X");
            INDArray result = (INDArray) literal.getValue();
            boolean isEqual = expected.equalsWithEps(result, 0.001);
            assertTrue(isEqual);
        }
    }

    private static Query buildGroupBy(String qsAgg) {
        String NL = "\n";
        String qs = PRE + NL + "SELECT (" + qsAgg + NL + "AS ?X) WHERE {?s ?p ?x} GROUP BY ?s";
        Query query = QueryFactory.create(qs);
        return query;
    }

    private static Query buildNoGroupBy(String qsAgg) {
        String NL = "\n";
        String qs = PRE + NL + "SELECT (" + qsAgg + NL + "AS ?X) WHERE {?s ?p ?x}";
        Query query = QueryFactory.create(qs);
        return query;
    }

    // Error in calculation (e.g. 2+ needed)
    private void testErr(String qsAgg, DatasetGraph ds) {
        Query query = buildGroupBy(qsAgg);
        try (QueryExecution qExec = QueryExecutionFactory.create(query, DatasetFactory.wrap(ds))) {
            ResultSet rs = qExec.execSelect();
            assertTrue(rs.getResultVars().contains("X"));
            Binding b = rs.nextBinding();
            assertFalse(b.contains(Var.alloc("X")));
        }
    }

    // Behaviour on empty
    private void testEmpty(String qsAgg, DatasetGraph ds) {
        testEmptyNoGroupBy(qsAgg, ds);
        testEmptyGroupBy(qsAgg, ds);
    }

    // Behaviour on empty - aggregate and no GROUP BY
    private void testEmptyNoGroupBy(String qsAgg, DatasetGraph ds) {
        Query query = buildNoGroupBy(qsAgg);
        try (QueryExecution qExec = QueryExecutionFactory.create(query, DatasetFactory.wrap(ds))) {
            ResultSet rs = qExec.execSelect();
            assertTrue(rs.hasNext());
            assertTrue(rs.getResultVars().contains("X"));
            Binding b = rs.nextBinding();
            assertFalse(b.contains(Var.alloc("X")));
        }
    }

    // Behaviour on empty - GROUP BY present
    private void testEmptyGroupBy(String qsAgg, DatasetGraph ds) {
        Query query = buildGroupBy(qsAgg);
        try (QueryExecution qExec = QueryExecutionFactory.create(query, DatasetFactory.wrap(ds))) {
            ResultSet rs = qExec.execSelect();
            assertFalse(rs.hasNext());
        }
    }
}

