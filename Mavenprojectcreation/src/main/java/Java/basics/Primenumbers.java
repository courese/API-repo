package Java.basics;

public class Primenumbers {
	boolean prime=false;

	public void numbers(int n) {
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				prime = true;
			}
		}
		if (prime != true) {
			System.out.println(" not a prime");
		} else {
			System.out.println(" prime");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Primenumbers sample = new Primenumbers();
		sample.numbers(11);

	}

}
