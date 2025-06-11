package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.function.FunctionRegistry;

import static pl.edu.pw.mini.jena.datatensor.vocabulary.FunctionsDT.*;

public class TransformerRegistry {
    public static void loadFunctions(FunctionRegistry registry) {
        registry.put(COSINE_TRANSFORM, CosTransform.class);
        registry.put(EXP_TRANSFORM, ExpTransform.class);
        registry.put(LOG_TRANSFORM, LogTransform.class);
        registry.put(LOGP_TRANSFORM, LogPTransform.class);
        registry.put(POLY_TRANSFORM, PolyTransform.class);
        registry.put(SCALE_TRANSFORM, ScaleTransform.class);
        registry.put(SIN_TRANSFORM, SinTransform.class);
        registry.put(ABS_TRANSFORM, AbsTransform.class);
        registry.put(NOT_TRANSFORM, NotTransform.class);
        registry.put(CAST_TRANSFORM, CastTransform.class);
    }
}
