package Com.Edubridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project.FutureDay;

class Option_2 {
	static FutureDay future=null;
	static int date=23;
	static int month=10;
	static int year=2000;
	static String day="Friday";
	static int findyear=2023;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		future=new FutureDay(date,month,year,day,findyear);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		future.calculate();
		String res=future.day(day);
		assertEquals("Friday",res);
	}

}
