package Com.Edubridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project.Pastday;

class Option_3 {
	static Pastday past=null;
	static int date=23;
	static int month=10;
	static int year=2023;
	static String day="Friday";
	static int findyear=2000;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		past=new Pastday(date,month,year,day,findyear);
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
		past.calculate();
		String res=past.day(day);
		assertEquals("Friday",res);
	}

}
