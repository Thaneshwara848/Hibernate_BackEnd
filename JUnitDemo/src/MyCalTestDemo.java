import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyCalTestDemo {

	
	Cal c = new Cal();
	@Test()
	void addTest()
	{
		assertEquals(c.add(10, 20), 30);
	}
	
	@Test
	void subTest()
	{
		assertEquals(c.sub(10, 20), -10);
	}
}