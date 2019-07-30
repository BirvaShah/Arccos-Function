import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArccosTest {
	
	ArccosFunction arccos=new ArccosFunction();
	
	@Test
	void rangeTest() {
		System.out.println("Range Test");
		assertEquals(9999, arccos.calculateArccos(2));
		assertEquals(0.5236505809337995, arccos.calculateArccos(0.8660));
		assertEquals(0, arccos.calculateArccos(1.0000));
		assertEquals(9999, arccos.calculateArccos(-1.00589));
	}
	
	@Test
	void domainTest() {
		System.out.println("Domain Test");
		assertTrue(arccos.checkDomain(1));
		assertTrue(arccos.checkDomain(-1));
		assertFalse(arccos.checkDomain(-1.89898989));
		assertFalse(arccos.checkDomain(5698789));
	}
	
	@Test
	void factorialTest() {
		System.out.println("Factorial Test");
		assertEquals(Double.POSITIVE_INFINITY, arccos.calculateFactorial(1234567895));
		assertEquals(1.0, arccos.calculateFactorial(-1234567895));		
	}
	
	@Test
	void powerTest() {
		System.out.println("Power Test");
		assertEquals(1.0, arccos.calculatePower(Double.POSITIVE_INFINITY, 0));
		assertEquals(16, arccos.calculatePower(2, 4));
		assertEquals(1.0, arccos.calculatePower(2.1236589, -4));
	}
	
	@Test
	void infinityTest() {
		System.out.println("Infinity Test");
		assertEquals(9999, arccos.calculateArccos(Double.POSITIVE_INFINITY));
	}
	
	@Test
	void convertToDegreeTest() {
		System.out.println("Convert To Degree Test");
		assertEquals(180, arccos.convertToDegree(3.141594653593692));
	}

}
