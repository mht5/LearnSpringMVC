package chapter13.util;

import org.junit.Test;
import org.mockito.Mockito;

public class MathUtilTest {

	@Test
	public void testMultiply() {
		MathHelper mathHelper = Mockito.mock(MathHelper.class);
		for (int i = 0; i < 10; i++) {
			Mockito.when (mathHelper.add(i * 8, 8)).thenReturn(i * 8 + 8);
		}
		MathUtil mathUtil = new MathUtil(mathHelper);
		mathUtil.multiply(3, 8);
		Mockito.verify(mathHelper, Mockito.times(1)).add(0, 8);
		Mockito.verify(mathHelper, Mockito.times(1)).add(8, 8);
		Mockito.verify(mathHelper, Mockito.times(1)).add(16, 8);
	}
	
}
