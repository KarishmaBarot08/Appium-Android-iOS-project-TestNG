package testCases;

import basePackage.BaseClass;
import functions.Functions;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCases extends BaseClass {
    @Test
    public void login() throws IOException {
        Functions method = new Functions(driver);
        method.login_flow();
    }

}
