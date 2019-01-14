package rmil1;

import java.rmi.Naming;

/**
 * Created by zhengtengfei on 2018/11/15.
 */
public class test {
    public static void main(String[] args) {
        UserHandler userHandler = null;
        try {
            userHandler = new UserHandlerImpl();
            Naming.rebind("user", userHandler);
            System.out.println(" rmi server is ready ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
