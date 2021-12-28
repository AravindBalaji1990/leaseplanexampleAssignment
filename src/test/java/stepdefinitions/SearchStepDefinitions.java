package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import utility.Utils;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;


public class SearchStepDefinitions {
    Utils utils = new Utils();
    @Steps
    public CarsAPI carsAPI;

    @When("^he calls endpoint (.*) with (.*) from (.*)$")
    public void heCallsEndpoint(String url, String productdata, String path) {
        String pathretrieved = utils.readFromProperties(System.getProperty("user.dir") + path, url);
        System.out.println("the data from properties file : " + pathretrieved);
        String response = SerenityRest.given().pathParam("product", productdata).get(pathretrieved, "product").asString();
        System.out.println(response);

    }

    @Then("^he sees the results displayed for (.*)$")
    public void heSeesTheResultsDisplayedForApple(String data) {
        restAssuredThat(response -> response.statusCode(200));
//        restAssuredThat(response -> response.body("title", contains(data)));
        restAssuredThat(response -> response.extract().jsonPath().getJsonObject("title").toString().equalsIgnoreCase(data));
    }

    @Then("^he does not see the results (.*)$")
    public void he_Does_Not_See_The_Results(String result) {
        restAssuredThat(response -> response.statusCode(404));
        restAssuredThat(response -> response.extract().jsonPath().getJsonObject("detail.error").toString().equalsIgnoreCase(result));

    }
}
