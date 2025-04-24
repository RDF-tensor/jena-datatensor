package pl.edu.pw.mini.jena.datatensor;

import org.apache.jena.atlas.logging.LogCtlJUL;
import org.apache.jena.datatypes.TypeMapper;
import org.apache.jena.sparql.function.FunctionRegistry;
import org.apache.jena.sys.JenaSubsystemLifecycle;
import org.apache.jena.sys.JenaSystem;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.aggregates.DTAggregates;
import pl.edu.pw.mini.jena.datatensor.datatypes.BaseDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.concatenators.ConcatenaterRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.indexers.IndexerRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.operators.OperatorRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.reductors.ReductionRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.similarities.SimilarityRegistry;
import pl.edu.pw.mini.jena.datatensor.functions.transfomers.TransformerRegistry;

public class InitDataTensor implements JenaSubsystemLifecycle {
    private static volatile boolean initalized = false;
    private static final Object initLock = new Object();

    @Override
    public void start() {
        init();
    }

    public static void init() {
        if (initalized)
            return;
        synchronized (initLock) {
            if (initalized) {
                JenaSystem.logLifecycle("InitTensSPARQL - skipped (initalized)");
                return;
            }
            initalized = true;

            LogCtlJUL.routeJULtoSLF4J();
            JenaSystem.logLifecycle("InitTensSPARQL - start");
            TypeMapper tm = TypeMapper.getInstance();
            BaseDataTensor.registerDataTensorDatatypes(tm);
            JenaSystem.logLifecycle("InitTensSPARQL - registered datatype");
            FunctionRegistry functionRegistry = FunctionRegistry.get();
            SimilarityRegistry.loadFunctions(functionRegistry);
            TransformerRegistry.loadFunctions(functionRegistry);
            OperatorRegistry.loadFunctions(functionRegistry);
            IndexerRegistry.loadFunctions(functionRegistry);
            ConcatenaterRegistry.loadFunctions(functionRegistry);
            ReductionRegistry.loadFunctions(functionRegistry);
            DTAggregates.register();
            JenaSystem.logLifecycle("InitTensSPARQL - registered function");
            JenaSystem.logLifecycle("InitTensSPARQL - finish");
        }


    }


    @Override
    public void stop() {
        Nd4j.getWorkspaceManager().destroyAllWorkspacesForCurrentThread();
        Nd4j.getMemoryManager().purgeCaches();
        JenaSystem.logLifecycle("InitTensSPARQL - stop");
    }

    @Override
    public int level() {
        return 501;
    }

}
