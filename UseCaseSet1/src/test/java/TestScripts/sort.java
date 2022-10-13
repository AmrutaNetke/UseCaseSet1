package TestScripts;

public class sort {

	public static void main(String[] args) {
		System.out.println("Hello World");
		int a[] = { 1, 2, 3, 2, 4, 4, 5, 1 };
		int temp[] = new int[a.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			int count = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j] && i != j) {
					count++;
				}
			}
			if (count != 0) {
				temp[k] = a[i];
				k++;
			}

		}
		for (int each : temp) {
			System.out.println(each);

		}
	}

}
