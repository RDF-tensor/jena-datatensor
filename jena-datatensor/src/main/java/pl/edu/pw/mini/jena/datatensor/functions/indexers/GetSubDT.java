package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.datatypes.RDFDatatype;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.sparql.expr.NodeValue;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.BooleanDataTensor;
import pl.edu.pw.mini.jena.datatensor.datatypes.implementations.NumericDataTensor;
import pl.edu.pw.mini.jena.datatensor.functions.GenericDT2FunctionBase;

public class GetSubDT extends GenericDT2FunctionBase {

    public GetSubDT() {
        super(false);
    }

    @Override
    public NodeValue calc(INDArray v1, INDArray v2) {
        INDArray result;
        if (v2.dataType() == DataType.BOOL) result = booleanIndexing(v1, v2);
        else result = v1.get(v2);

        NodeValue nv;
        if (v1.dataType().isNumerical())
            nv = NodeValue.makeNode(NodeFactory.createLiteralByValue(result, NumericDataTensor.INSTANCE));
        else if (v1.dataType() == DataType.BOOL)
            nv = NodeValue.makeNode(NodeFactory.createLiteralByValue(result, BooleanDataTensor.INSTANCE));
        else
            throw new IllegalArgumentException("Unsupported data type for GetSubDT operation");
        return nv;
    }

    public static INDArray booleanIndexing(INDArray data, INDArray mask) {
        data = data.ravel();
        mask = mask.ravel();

        int count = mask.sumNumber().intValue();

        INDArray result = Nd4j.create(count);

        int index = 0;
        for (int i = 0; i < data.length(); i++) {
            if (mask.getInt(i) == 1) {
                result.putScalar(index++, data.getDouble(i));
            }
        }

        return result.castTo(data.dataType());
    }

}
