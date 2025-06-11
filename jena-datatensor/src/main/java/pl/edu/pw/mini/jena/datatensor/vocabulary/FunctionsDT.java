package pl.edu.pw.mini.jena.datatensor.vocabulary;

public class FunctionsDT {
    public static final String NS = "https://w3id.org/rdf-tensor/functions#";

    public static String getURI() {
        return NS;
    }

    // Similarities
    public static final String COSINE_SIMILARITY = FunctionsDT.getURI() + "cosineSimilarity";
    public static final String EUCLIDEAN_DISTANCE = FunctionsDT.getURI() + "euclideanDistance";

    // Transformers
    public static final String COSINE_TRANSFORM = FunctionsDT.getURI() + "cos";
    public static final String EXP_TRANSFORM = FunctionsDT.getURI() + "exp";
    public static final String LOG_TRANSFORM = FunctionsDT.getURI() + "log";
    public static final String LOGP_TRANSFORM = FunctionsDT.getURI() + "logp";
    public static final String POLY_TRANSFORM = FunctionsDT.getURI() + "poly";
    public static final String SCALE_TRANSFORM = FunctionsDT.getURI() + "scale";
    public static final String SIN_TRANSFORM = FunctionsDT.getURI() + "sin";
    public static final String ABS_TRANSFORM = FunctionsDT.getURI() + "abs";
    public static final String NOT_TRANSFORM = FunctionsDT.getURI() + "not";
    public static final String CAST_TRANSFORM = FunctionsDT.getURI() + "cast";

    // Operators
    public static final String ADD = FunctionsDT.getURI() + "add";
    public static final String SUBTRACT = FunctionsDT.getURI() + "subtract";
    public static final String MULTIPLY = FunctionsDT.getURI() + "multiply";
    public static final String DIVIDE = FunctionsDT.getURI() + "divide";
    public static final String EQ = FunctionsDT.getURI() + "eq";
    public static final String NEQ = FunctionsDT.getURI() + "neq";
    public static final String AND = FunctionsDT.getURI() + "and";
    public static final String OR = FunctionsDT.getURI() + "or";
    public static final String GT = FunctionsDT.getURI() + "gt";
    public static final String LT = FunctionsDT.getURI() + "lt";

    // Indexers
    public static final String GET_SUB_DT = FunctionsDT.getURI() + "getSubDT";

    // Concatenators
    public static final String CONCAT = FunctionsDT.getURI() + "concat";
    public static final String HSTACK = FunctionsDT.getURI() + "hstack";
    public static final String VSTACK = FunctionsDT.getURI() + "vstack";

    // Reductions
    public static final String ALL = FunctionsDT.getURI() + "all";
    public static final String ANY = FunctionsDT.getURI() + "any";
    public static final String AVG = FunctionsDT.getURI() + "avg";
    public static final String SUM = FunctionsDT.getURI() + "sum";
    public static final String MAX = FunctionsDT.getURI() + "max";
    public static final String MED = FunctionsDT.getURI() + "median";
    public static final String MIN = FunctionsDT.getURI() + "min";
    public static final String STD = FunctionsDT.getURI() + "std";
    public static final String VAR = FunctionsDT.getURI() + "var";
    public static final String NORM1 = FunctionsDT.getURI() + "norm1";
    public static final String NORM2 = FunctionsDT.getURI() + "norm2";
}
