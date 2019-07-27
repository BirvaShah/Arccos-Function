import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArccosTest {
	
	ArccosFunction arccos=new ArccosFunction();
	
	@Test
	void domainTest	() {
		System.out.println("Test1");
		assertEquals(9999, arccos.CalculateArccos(2));
		assertEquals(9999, arccos.CalculateArccos(-2));
		assertEquals(9999, arccos.CalculateArccos(1.00589));
		assertEquals(9999, arccos.CalculateArccos(-1.00589));
	}
	
	@Test
	void precisionTest	() {
		System.out.println("Test2");
		assertEquals(1.0472, arccos.CalculateArccos(0.5));
	}

}
