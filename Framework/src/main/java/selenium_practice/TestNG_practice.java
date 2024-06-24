package selenium_practice;

import org.testng.annotations.Test;

public class TestNG_practice {
	
	@Test(priority=0)
	public void session1()
	{
		System.out.println("sample");
		//throw new ArithmeticException("failed");
		
	}
	
	@Test(priority=1,dependsOnMethods = "session1",invocationCount = 3,invocationTimeOut = 60)
	public void session2()
	{
		System.out.println("2nd ");	}

	@Test(priority=2, enabled=false)
	public void session3()
	{
		System.out.println("3rd ");	}
}
