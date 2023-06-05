package Com.Edubridge;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project.CurrentDay;
import junit.framework.Assert;
import junit.framework.TestCase;

class Option_1{
	static CurrentDay current=null;
	static int date=13;
	static int month=10;
	static int year=2023;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		current=new CurrentDay(date,month,year);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	protected void setUp() throws Exception {
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	@Test
	void test() {
		current.calculate();
		String res=current.day();
		assertEquals("Friday",res);
	}

}
