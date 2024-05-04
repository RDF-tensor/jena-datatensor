package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;
import pl.edu.pw.mini.jena.datatensor.functions.NumericDTNumericFunctionBase;

public class LogPTransform extends NumericDTNumericFunctionBase {

    @Override
    public INDArray calc(Double v1, INDArray v2) {
        INDArray casted = v2.dataType().isIntType() ? v2.castTo(DataType.DOUBLE) : v2;
        if (casted.lte(0).any())
            throw new ExprEvalException("Logarithm of non-positive number is undefined");
        return Transforms.log(casted, v1);
    }
}
