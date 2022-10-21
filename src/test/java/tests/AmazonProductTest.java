package tests;

import org.example.MainPage;
import org.example.SigninEMail;
import org.example.SigninPass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AmazonProductTest extends BaseTest{
    MainPage mainPage;

    @Test(priority=1)
    public void succesfulLogin(){
        SigninEMail sendEMail = firstPage.loginEMail();
        sendEMail.setEMail("***@gmail.com");

        SigninPass signinPass =sendEMail.getSignPassPage();
        signinPass.setPass("***");
        signinPass.getMainPage();
    }

    @Test(priority=2)
    public void checkSelectedArea(){
        mainPage = new MainPage(driver);
        assertEquals(mainPage.selectCategories(), "Bilgisayarlar","Selected option is INCORRECT!");
    }
    @Test(priority = 3)
    public void checkSearchBox(){
        mainPage = new MainPage(driver);
        assertTrue(mainPage.searchBox().contains("lenovo ideapad gaming 3"),
                "you are looking for the wrong product!!!");

    }
    @Test(priority = 4)
    public void verifAllItemsIsprime(){
        mainPage = new MainPage(driver);
        assertEquals(mainPage.verifyAllItemsArePrime1().size(),
                mainPage.verifyAllItemsArePrime2().size(),"All item is NOT PRIME!!!");

    }

}
