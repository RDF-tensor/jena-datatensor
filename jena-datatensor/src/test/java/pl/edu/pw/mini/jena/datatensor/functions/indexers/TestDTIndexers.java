package pl.edu.pw.mini.jena.datatensor.functions.indexers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTIndexers {
    @Test
    public void getSubDTTest1() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3,1],\\\"data\\\":[0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest2() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3,1],\\\"data\\\":[1,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest3() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[0,1,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest4() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 3],\\\"data\\\":[0,0,1,1,0,0,0,0,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3, 3, 3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest5() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 2],\\\"data\\\":[1, 1, 0, 0, 1, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[2, 2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest6() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[8],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[0, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[3, 2]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest7() {
        testError("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1],\\\"data\\\":[1]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void getSubDTTest8() {
        testError("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3, 1],\\\"data\\\":[2,2,2]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void getSubDTTest9() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[8],\\\"data\\\":[3,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[0,1]}\"^^dt:NumericDataTensor)\n",
                "\"{\\\"type\\\":\\\"int32\\\", \\\"shape\\\":[2], \\\"data\\\":[3,2]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest10() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor,\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0,1,1,0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2],\\\"data\\\":[2,3]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest11() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[1,2,3,4,5,6,7,8]}\"^^dt:NumericDataTensor,\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1, 1],\\\"data\\\":[1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[5,6,7,8]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest12() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[1,2,3,4,5,6,7,8]}\"^^dt:NumericDataTensor,\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2, 2],\\\"data\\\":[0, 0, 1, 1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3, 4, 3, 4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest13() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"shape\\\":[2,2],\\\"data\\\":[true,false,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[3],\\\"data\\\":[3,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void getSubDTTest14() {
        test("dtf:getSubDT(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2,2],\\\"data\\\":[1,2,3,4,3,2,3,4]}\"^^dt:NumericDataTensor, \"{\\\"shape\\\":[8],\\\"data\\\":[true,false,true,false,true,false,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[1,3,3,3]}\"^^dt:NumericDataTensor");
    }

}
