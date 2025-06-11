package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.datatypes.xsd.impl.XSDBaseStringType;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.apache.jena.sparql.function.FunctionBase2;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;

public class CastTransform extends FunctionBase2 {

    @Override
    public NodeValue exec(NodeValue v1, NodeValue v2) {
        if (isNotNumericAndString(v1, v2))
            throw new ExprEvalException("First argument must be a numeric data tensor and the second argument must be string representing a proper numeric datatype");
        INDArray tensor = (INDArray) v1.getNode().getLiteralValue();
        String dataTypeStr = v2.getString();
        INDArray result;
        switch (dataTypeStr) {
            case "int16":
                result = tensor.castTo(DataType.INT16);
                break;
            case "int32":
                result = tensor.castTo(DataType.INT32);
                break;
            case "int64":
                result = tensor.castTo(DataType.INT64);
                break;
            case "float16":
                result = tensor.castTo(DataType.FLOAT16);
                break;
            case "float32":
                result = tensor.castTo(DataType.FLOAT);
                break;
            case "float64":
                result = tensor.castTo(DataType.DOUBLE);
                break;
            default:
                throw new ExprEvalException("Unsupported data type: " + dataTypeStr);
        }
        return NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
    }

    private boolean isNotNumericAndString(NodeValue v1, NodeValue v2) {
        if (!v1.asNode().isLiteral() || !v2.asNode().isLiteral())
            return true;
        RDFDatatype dataType = v2.asNode().getLiteralDatatype();
        return !(dataType instanceof XSDBaseStringType) || !(v1.asNode().getLiteralDatatype() instanceof NumericDataTensor);
    }

}
