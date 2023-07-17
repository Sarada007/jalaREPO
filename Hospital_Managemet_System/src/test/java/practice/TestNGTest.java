package practice;

import org.testng.annotations.Test;

public class TestNGTest {
	@Test(dependsOnMethods = "retrieve",priority = 6)
public void update() {
	System.out.println("== update ==");
}
	@Test(dependsOnMethods = "delete" , priority = 4)
public void create() {
	System.out.println("== create ==");
}
	@Test(dependsOnMethods = "update")
public void delete() {
	System.out.println("== delete ==");
}
	@Test(priority = 9)
public void retrieve() {
	System.out.println("== retrieve ==");
}
}
