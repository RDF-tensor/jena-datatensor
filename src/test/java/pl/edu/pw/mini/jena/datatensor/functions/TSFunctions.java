package pl.edu.pw.mini.jena.datatensor.functions;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.edu.pw.mini.jena.datatensor.functions.concatenators.TSConcatenators;
import pl.edu.pw.mini.jena.datatensor.functions.indexers.GetSubDTTest;
import pl.edu.pw.mini.jena.datatensor.functions.operators.TSOperators;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.TSSimilarities;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TSTransformers;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TSOperators.class,
        TSSimilarities.class,
        TSTransformers.class,
        TSConcatenators.class,
        AggregatesTest.class,
        GetSubDTTest.class,
})
public class TSFunctions extends TestSuite {
}
