import java.util.Arrays;

public class DoMyBidding {
	
	static boolean isEven (long n) {
		return n%2==0;
	}
	
	static boolean isPrime (long n) {
		if (n<0) {
			n=n*-1;
		}
		for (int i=2; i<= n/2;) {
			return !((n % i == 0));
		}
		return true;
	}
	
	static boolean isPalindrome (long n) {
		String num = Long.toString(n);
		String reverseLast = new StringBuilder(num).reverse().toString();
		return num.equals(reverseLast);
	}
	
	static boolean isPowerOfTwo(long n) {
		if (n%2!=0) return false;
		long powOfTwo = 2;
		while (powOfTwo<n) {
			powOfTwo = powOfTwo*2;
			if (powOfTwo == n) return true;
		}
		return false;
	}
	
	static int[] bubbleSort(int[] numArray) {
		int[] sortedArr = numArray.clone();
		sortArr(sortedArr, 0, sortedArr.length-1);
		return sortedArr;
	}
	
	  static void sortArr(int[] arr, int lo, int hi) {
	      
	      if (lo >= hi) return;  // base case, if there is only 1 elem left i.e low idx == hi idx or low idx > hi idx then return.
	      // low idx will ALWAYS be greater or equal to hi idx if there is only 1 value between lo and high idx (which is the base case)
	      
	      int middle = arr[hi];
	      int sortedIdx = partition(arr, middle, lo, hi);  // get the sortedIdx, i.e the index of elem which has been sorted
	      sortArr(arr, lo, sortedIdx - 1); // to sort the values lower than sortedIdx/middle val i.e values that are on left of sortedIdx
	      sortArr(arr, sortedIdx + 1, hi); // to sort the values higher than sortedIdx/middle val i.e values that are on right of sortedIdx
	  }
	  
	  static int partition(int[] arr, int middle, int lo, int hi) {
	      int i = lo, j = lo; // start from leftmost idx i.e. lo 
	      
	      while (i <= hi) { // continue till rightmost idx i.e. hi
	          if (arr[i] <= middle) { // if arr[i] is smaller than the (middle) value we have choosen, swap i and j and increase both by one
	              swap(arr, i, j);
	              i++;
	              j++;
	          } else { // if arr[i] is larger than the (middle) value we have choosen, then increase i
	              i++;
	          }
	      }
	      
	      return (j - 1); // return the middle idx value , i.e. the value which has been sorted in the array
	      
	    //  ------------------------------------------------|| HOW IT WORKS ||------------------------------------------------
	   
	    //   Idx    :   Value Type : 
	    // 0 to j-1 : values smaller than or equal to middle idx
	    // j to i   : values larger than middle idx
	    
	    // taking an array [9, 2, 5]
	    //  9 -> lo (i.e. leftmost idx)       5 -> middle idx (which will be sorted in this fn, it is the last value)
	    //  by default > i and j both are same val as lo
	    
	    //  loop starts -- 
	    //  since 9 > 5(mid val) => i++ i.e. arr[i]=2; arr[j] = 9
	    //      array - [9, 2, 5]
	    //  since 2 <= 5(mid val) => swap(i, j) => swap(2, 9)
	    //      array - [2, 9, 5]
	    //  i++; j++ => arr[i]=5; arr[j]=9
	    //  since 5 <= 5(mid val) => swap(i,j) => swap(5, 9)
	    //      array - [2, 5, 9]
	    //  i++; j++ => arr[i]=out of bounds; arr[j]=9
	    //    The arr this time got sorted just by partition since it wasn't complex.
	    //    The arr may or may NOT get sorted with just this fn, but what this fn does everytime is bring the middle val to its correct idx just like here
	    //  Lastly, we return (j - 1) i.e. the idx of the sorted elem
	  }
	  
	  static void swap (int[] arr, int i, int j) {  // simple fn to swap values at idx i and j
	      int temp = arr[i];
	      arr[i] = arr[j];
	      arr[j] = temp;
	  }
	
	static boolean isArmstrong(long n) {
		long total = 0;
		long last;
		String str = Long.toString(n);
		while (n!=0) {
			last = n%10;
			total += Math.pow(last, 3);
			n /= 10;
		}
		long num = Long.parseLong(str);
		return total == num;
	}
	
	static String reverse(String str) {
		String reversedStr = "";
		for (int i=str.length()-1;i>=0; i--) {
			reversedStr+=str.charAt(i);
		}
		return reversedStr;
	}
	
	static int getFibonacci(int n, int[] qb) {
		
		if (n==0 || n==1 ) return n; // if n reaches 0 or 1 print 0 or 1 respectively. BASE CASE
		
		if (qb[n] != 0) { // if the question bank already has answer, return answer
			return qb[n];
		}
		
		int lastFibonacci = getFibonacci(n - 1, qb); // get last fibonaci no.
		int secondLastFibonacci = getFibonacci(n - 2, qb); // get second last fibonacci no.
		int currentFibonacci = lastFibonacci + secondLastFibonacci; // get current fibonacci no.
		if (qb[n] == 0) qb[n]=currentFibonacci; // if question bank does not contain the solution of current fibonaci, add it.
		return currentFibonacci;
		
		// ---- FOR OPTIMIZATION ----
		// the arr qb[] stores fibonaci answer by mapping n to index including 0, so array will be of n+1 len
	}
	
	static void printFibonacci(long n) {	
		for (int i=0;i<=n;i++) { // loop from 0 to n
			int intArr[] = new int[(int) i + 1]; // create an array 1 larger than n (for optimization)
			int fibonacci = getFibonacci(i, intArr); // get fibonacci number
			System.out.println(fibonacci); // print the current fibonaci number
		}
	}
	
	static void printFibonacciPrimes(int n) {
		for (int i=0;i<=n;i++) { // loop from 0 to n
			int intArr[] = new int[(int) i + 1]; // create an array 1 larger than n (for optimization)
			int fibonacci = getFibonacci(i, intArr); // get fibonacci number
			if (isPrime(fibonacci)) System.out.println(fibonacci); // check if the current fibonacci number is prime and print only if it is
		}
	}
	
	static long factorial(int n) {
		if (n>20 || n<0) return -1; // the value must be smaller or equal to 20 because after another increment (i.e. 21), the value of 21! exceeds range of type 'long'    
		long total = 1;
		for (int i=1; i<=n; i++) {
			total *= i;
		}
		return total;
	}
	
	static void printStars(int n, int step) {
		// as added difficulty, I also added step, i.e how much difference
		// must between current line and next line's stars
		// default was 2
		// increasing
		for (int i=1; i<=n; i=i+step) {
			for (int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// decreasing
		for (int i=n-step; i>=1; i=i-step) {
			for (int j=1; j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void printStars(int n) {
		printStars(n, 2);
	}

	static void printCollatz(int n) {
        System.out.printf(n + " ");
        while (n!=1) {
            if (isEven(n)) {
                n/=2;
                System.out.printf(n + " ");
            } else {
                n=n*3+1;
                System.out.printf(n + " ");
            }
        }
        System.out.println("-----END.");
    }
    
    static void testCollatz(int n) {
        for (int i=1; i<=n; i++) {
            printCollatz(i);
        }
    }
    
    static void testCollatz() {
        testCollatz(100);
    }
	
	public static void main(String[] args) {
//		boolean a = isEven(3);
//		System.out.println(a);
		
		// boolean b = isPrime(-23);
		// System.out.println(b);
		
//		boolean c = isPalindrome(32544523);
//		System.out.println(c);
		
//		boolean d = isPowerOfTwo(1024);
//		System.out.println(d);
		
		int[] arr = {12,4,1,6,2};
//		sortArr(arr, 0, arr.length-1);
		int[] sortedArr = bubbleSort(arr);
		System.out.println(Arrays.toString(sortedArr));
				
//		boolean f = isArmstrong(153);
//		System.out.println(f);
		
//		String g = reverse("Hello");
//		System.out.println(g);
		
//	    printFibonacci(10);

//		long i = factorial(10);
//		System.out.println(i);
		
//		printStars(7, 2);
		
//		printFibonacciPrimes(20);

	}

}
