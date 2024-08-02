import java.util.Arrays;

public class FIndMaximumElementFromArray {
	public static void main(String[] args) {
		int [] a = {1,3,5,7,8,9};
		int v = Arrays.stream(a).max().getAsInt();
		System.out.println(v);
	}
}