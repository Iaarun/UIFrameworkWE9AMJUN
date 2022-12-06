package stepDefinition;

import java.util.List;

import org.junit.Assert;

import com.factory.BaseDriver;
import com.pages.LoginPage;
import com.pages.MyAccount;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcommerceLoginSteps {
	
	LoginPage loginPage = new LoginPage(BaseDriver.getDriver());
	MyAccount myaccount = new MyAccount(BaseDriver.getDriver());

	@Given("user is at the login page")
	public void user_is_at_the_login_page() {
		BaseDriver.getDriver().get("http://live.techpanda.org/index.php/customer/account/login/");
	}

	@When("user provide {string} and {string}")
	public void user_provide_and(String username, String password) {
	    loginPage.sendUserName(username);
	    loginPage.sendPassword(password);
	}

	@When("click on Login button")
	public void click_on_login_button() {
	   loginPage.clickOnloginBtn();
	}

	@Then("user should be navigated to Account page")
	public void user_should_be_navigated_to_account_page(DataTable dataTable) {
	 List<List<String>> uname=	dataTable.asLists();
	    String name= myaccount.getUsername();
	    String s1 = uname.get(0).get(0);
	    System.out.println(s1+"\n"+name);
	    Assert.assertTrue(name.contains(uname.get(0).get(0)));
	    
	}

}
