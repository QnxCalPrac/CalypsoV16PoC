import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
public static void main(String[] args) {
Result result = JUnitCore.runClasses(TestJUnit.class);
System.out.println("Test run successfully");

for(Failure failure : result.getFailures()) {
System.out.println(failure.toString());
}
System.out.println(result.wasSuccessful());

}
}