package demo;

import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNGGroupDemo {

	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println(" This is test 1 ");
	}
	
	@Test(groups= {"smoke"})
	public void test2() {
		System.out.println(" This is test 2 ");
	}
	
	@Test(groups= {"regression"})
	public void test3() {
		System.out.println(" This is test 3 ");
	}
	
	@Test(groups= {"windows.regression"})
	public void test4() {
		System.out.println(" This is test 4 ");
	}
	
	@Test(groups= {"linux.regression"})
	public void test5() {
		System.out.println(" This is test 5 ");
	}
	@Test
	public void test6() {
		System.out.println(" This is test 6 ");
	}
	@Test
	public void test7() {
		System.out.println(" This is test 7 ");
	}
}
