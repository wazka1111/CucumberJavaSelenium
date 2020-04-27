package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Test {
    private static Logger log = LogManager.getLogger();

    @Given("user wants to add the following numbers:")
    public void user_wants_to_add_the_following_numbers(List<Integer> numbers) {
        for (int num : numbers) {
            log.info(num);
        }
    }

    @Then("correct result is {string}")
    public void correct_result_is(String result) {
        log.info("result is: " + result);
    }

    @Then("correct result is {int}")
    public void correct_result_is(Integer sum) {
        log.info("result is: " + sum);
    }

    @When("user perform add method from calculator function")
    public void user_perform_add_method_from_calculator_function() {

    }

    //------------------------Scenario outline------------------

    @Given("New student is going to join to school")
    public void new_student_is_going_to_join_to_school() {
        log.info("New student is going to join to school...");
    }

    @When("Student details are added to the system: {string}, {string}, {string}, {string}")
    public void student_details_are_added_to_the_system(String name, String surname, String date, String country) {
        log.info("New student: Name: "+ name+ " surname: " + surname +
                " date of birth: " + date +" country: "+country);
    }

    @Then("Student id {int} is assigned to new student")
    public void student_id_is_assigned_to_new_student(Integer id) {
        log.info("Student id: " + id);
    }
}
