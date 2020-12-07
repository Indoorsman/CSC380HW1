import java.util.ArrayList;

public class hw1 {

	public static int gcd(int m, int n) {
		int r = 0;
		while(n != 0) {
		
			r = m % n;
			m = n;
			n = r;
	}
	
		return m;
	}
	
	
	public static int intCheck(int m, int n) {
		for(int i = 0; i < 100000000; i++) {
		int t = Math.min(m, n);
		int r = m % t;
		m = m / t;
		if(r == 0) {
			r = n % t;
			n = n / t;
			if(r == 0)
				return t;
			}
		t--;
		}
		
		return 0;
		
	}
	
	
	public static ArrayList<Integer> sieve(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> L = new ArrayList<Integer>();
		
		int j = 0;
		for(int i = 0; i <= n; i++) {
			primes.add(0);
		}
		
		for(int p = 2; p <= n; p++) {
			primes.set(p, p);
		}
		
		for(int p = 2; p <= ((int)(Math.sqrt(n))) ; p++) {
			if(primes.get(p) != 0) {
				j = p*p;
				while(j <= n) {
					primes.set(j, 0);
					j = j + p;
				}
			}
				
		}
		for(int i = 0; i < primes.size(); i++) {
			L.add(primes.get(i));
		}
		
		int i = 0;
		
		for(int p = 2; p <= n; p++) {
			if(primes.get(p) != 0) {
				L.set(i, primes.get(p));
				i++;
			}
		
		}
		return L;
		
		
	}
	
	public static void main(String[] args) {
		int m, n, gcd;
		m = n = gcd = 0;
		long startTime = 0L;
		long endTime = 0L;
		
		//Sieve
		int breakP = 0;
		startTime = System.nanoTime();
		ArrayList<Integer> L = (sieve(2500));
		endTime = System.nanoTime();
		
		System.out.println(endTime - startTime);
		
		for(int i = 0; i < L.size(); i++) {
			if( L.get(i) == 0) {
				breakP = i;
				break;
			}		
		}
		
		while(L.size() > breakP) {
			L.remove(breakP);
		}
		
		//System.out.println(L);
		
		
		//Euclid & Consecutive Int
		
		
		m = 99997844;
		n = 8984324;
		
		startTime = System.nanoTime();
		//gcd = gcd(m,n);
		gcd = intCheck(m,n);
		endTime = System.nanoTime();
		//System.out.println(gcd);
		//System.out.println(endTime - startTime);
		

	
	}
	
}
