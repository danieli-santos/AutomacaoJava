package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests  extends BaseTests {

    @Test
    public void testFileUploadFile(){

        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/bi004523/Documents/testeAutomationJava/resources/chromedriver");

        assertEquals(uploadPage.getUploadedFiles(), "chromedriver", "Uploaded files incorrect");
    }
}
