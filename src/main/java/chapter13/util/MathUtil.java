package chapter13.util;

public class MathUtil {
	private MathHelper mathHelper;

	public MathUtil(MathHelper mathHelper) {
		super();
		this.mathHelper = mathHelper;
	}
	
	public int multiply(int a, int b) {
		int result = 0;
		for (int i = 1; i <= a; i++) {
			result = mathHelper.add(result, b);
		}
		return result;
	}
}
