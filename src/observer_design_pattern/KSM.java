package observer_design_pattern;

public class KSM {

    public static int getValue(int c, ResultResponse resultResponse) throws Exception {
        int a=0;
        int b=10;
        try {

             if(a==0) {
                 throw new Exception("Cannot divide by zero");
             } else {
                 c = b/a;
             }
        } catch (Exception e) {
            resultResponse.setStatusCode(100);
            resultResponse.setDescription("Cannot divide by zero");
            throw new Exception(e);
        }
        return c;
    }
}
