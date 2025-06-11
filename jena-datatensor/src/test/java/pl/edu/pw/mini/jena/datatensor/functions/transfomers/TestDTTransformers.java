package pl.edu.pw.mini.jena.datatensor.functions.transfomers;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.junit.Test;

import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.test;
import static pl.edu.pw.mini.jena.datatensor.functions.DTTestExpr.testError;

public class TestDTTransformers {

    @Test
    public void absDTTest1() {
        test("dtf:abs(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest2() {
        test("dtf:abs(\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-3.0,2.0,-3.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest3() {
        test("dtf:abs(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[-3.0,2.0,-3.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[3.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest4() {
        test("dtf:abs(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,1,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[2,1,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void absDTTest5() {
        test("dtf:abs(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-3,2,-3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest1() {
        test("dtf:cos(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest2() {
        test("dtf:cos(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.5403023058681398,0.5403023058681398,0.5403023058681398,0.5403023058681398]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest3() {
        test("dtf:cos(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest4() {
        test("dtf:cos(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void cosDTTest5() {
        test("dtf:cos(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-0.9899924966004454,-0.9899924966004454,-0.9899924966004454,-0.9899924966004454]}\"^^dt:NumericDataTensor");
    }


    @Test
    public void sinDTTest1() {
        test("dtf:sin(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest2() {
        test("dtf:sin(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,1,1,1]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.8414709848078965,0.8414709848078965,0.8414709848078965,0.8414709848078965]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest3() {
        test("dtf:sin(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest4() {
        test("dtf:sin(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void sinDTTest5() {
        test("dtf:sin(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[0.1411200080598672,0.1411200080598672,0.1411200080598672,0.1411200080598672]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest1() {
        test("dtf:log(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest2() {
        test("dtf:log(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest3() {
        test("dtf:log(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest4() {
        test("dtf:log(\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logDTTest5() {
        test("dtf:log(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1.0986122886681098,1.0986122886681098,1.0986122886681098,1.0986122886681098]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void logDTTest6() {
        testError("dtf:log(\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void logPDTTest1() {
        test("dtf:logp(2, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest2() {
        test("dtf:logp(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest3() {
        test("dtf:logp(2, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.5849625007211563,1.5849625007211563,1.5849625007211563,1.5849625007211563]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest4() {
        test("dtf:logp(2, \"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,3,3,3]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[1.5849625007211563,1.5849625007211563,1.5849625007211563,1.5849625007211563]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void logPDTTest5() {
        test("dtf:logp(2, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[4,8,16,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[2,3,4,2]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void logPDTTest6() {
        testError("dtf:logp(2, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void notDTTest1() {
        test("dtf:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,false,true,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,true,false,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest2() {
        test("dtf:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest3() {
        test("dtf:not(\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[1,2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest4() {
        test("dtf:not(\"{\\\"shape\\\":[4],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[4],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void notDTTest5() {
        test("dtf:not(\"{\\\"shape\\\":[2,2],\\\"data\\\":[true,true,true,true]}\"^^dt:BooleanDataTensor)",
                "\"{\\\"shape\\\":[2,2],\\\"data\\\":[false,false,false,false]}\"^^dt:BooleanDataTensor");
    }

    @Test
    public void polyDTTest1() {
        test("dtf:poly(2, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest2() {
        test("dtf:poly(2, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4,4,4,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest3() {
        test("dtf:poly(2, \"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,3.0,3.0,3.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[9.0,9.0,9.0,9.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest4() {
        test("dtf:poly(3, \"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[1,8,27,64]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void polyDTTest5() {
        test("dtf:poly(3, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,8,27,64]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void polyDTTest6() {
        testError("dtf:poly(-1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[0.0,0.0,0.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test(expected = ExprEvalException.class)
    public void polyDTTest7() {
        testError("dtf:poly(-1, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,2.0,3.0,0.0]}\"^^dt:NumericDataTensor)");
    }

    @Test
    public void scaleDTTest1() {
        test("dtf:scale(2.0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,1.0,1.0,1.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2.0,2.0,2.0,2.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest2() {
        test("dtf:scale(2.0, \"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[2,2,2,2]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[4.0,4.0,4.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest3() {
        test("dtf:scale(3.0, \"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[3.0,6.0,5.0,4.0]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[9.0,18.0,15.0,12.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest4() {
        test("dtf:scale(3.0, \"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[3,6,5,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[4],\\\"data\\\":[9.0,18.0,15.0,12.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void scaleDTTest5() {
        test("dtf:scale(-1.0, \"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[3,6,5,4]}\"^^dt:NumericDataTensor)",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[-3.0,-6.0,-5.0,-4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void castTransformerTest1() {
        test("dtf:cast(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"int64\")",
                "\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void castTransformerTest2() {
        test("dtf:cast(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"float64\")",
                "\"{\\\"type\\\":\\\"float64\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void castTransformerTest3() {
        test("dtf:cast(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"float32\")",
                "\"{\\\"type\\\":\\\"float32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1.0,2.0,3.0,4.0]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void castTransformerTest4() {
        test("dtf:cast(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"int16\")",
                "\"{\\\"type\\\":\\\"int16\\\",\\\"shape\\\":[4],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test
    public void castTransformerTest5() {
        test("dtf:cast(\"{\\\"type\\\":\\\"int64\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"int32\")",
                "\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor");
    }

    @Test(expected = ExprEvalException.class)
    public void castTransformerTest6() {
        testError("dtf:cast(\"{\\\"type\\\":\\\"int32\\\",\\\"shape\\\":[1,2,2],\\\"data\\\":[1,2,3,4]}\"^^dt:NumericDataTensor, \"string\")");
    }


}
