package lab1;

import java.util.*;
//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : Rayhaan Yaser Mohammed
//Yorku Email : ray116@my.yorku.ca
//Date : 14/01/2024
//Authenticity Declaration : 
//I declare this submission is the result of my own work and has not been
//shared with any other student or 3rd party content provider.This submitted
//piece of work is entirely of my own creation.
//////////////////////////////

/**
 * You are required to implement all methods recursively. <strong>You receive a
 * zero if there is any occurrence of a loop (e.g., for, while) or methods that use regular
 * expressions</strong>
 * 
 * <p>
 * <strong> Do not use a loop. Use only recursion. Solutions using loop will not
 * receive credit.</strong>
 * </p>
 * <p>
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 * </p>
 * <p>
 * Hint: For some of the public recursive methods in
 * <code>RecursiveMethods</code> class you may consider adding private recursive
 * helper methods.
 * </p>
 * 
 * 
 */

public final class RecursiveMethods {


	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
	    if (n == 0) {
	        return new int[]{1};
	    } else if (n == 1) {
	        return new int[]{1, 1};
	    } else {
	        int[] fibaNminus1 = fibArray(n - 1);
	        int[] res = new int[n];

	        res[0] = 1;
	        res[1] = 1;

	        fillFibArray(res, fibaNminus1, 2, n);

	        return res;
	    }
	}

	private void fillFibArray(int[] res, int[] fibaNminus1, int i, int n) {
	    if (i < n) {
	        res[i] = fibaNminus1[i - 1] + fibaNminus1[i - 2];
	        fillFibArray(res, fibaNminus1, i + 1, n);
	    }
	}


	/**
	 * <p>
	 * <strong> This method determine if p and q are relatively prime.</strong>
	 * </p>
	 * 
	 * <p>
	 * Two integers p and q are said to be relatively Prime if the Greatest Common
	 * Divisor of them is 1.
	 * </p>
	 * Hints:
	 * <p>
	 * A <em> positive integer </em> {@code n > 1} is called <strong> prime</strong>
	 * if the only positive factors of {@code n} are {@code  1} and {@code  n} . A
	 * positive integer that is greater than one and is not prime is called <strong>
	 * composite</strong>.
	 * </p>
	 * <p>
	 * An integer {@code  n} is <strong> composite </strong> if and only if there
	 * exists an integer {@code a} such that <strong> <em> {@code a} divides
	 * {@code n} </em></strong> and {@code 1 < a < n}.
	 * </p>
	 * 
	 * <p>
	 * <strong> Hint: 1 is neither prime nor composite. It forms its own special
	 * category as a "unit".</strong>
	 * </p>
	 * 
	 * <p>
	 * This method checks the two positive integers are relatively prime or not.
	 * </p>
	 * 
	 * <pre>
	 *  Example:
	 *  
	 *  
	 *  isRelativelyPrime (8, 6) returns false
	 *  isRelativelyPrime (15, 25) returns false
	 *  isRelativelyPrime (7, 2) returns true 
	 *  isRelativelyPrime (19, 3) returns true 
	 *  isRelativelyPrime (11, 13) returns true 
	 *  isRelativelyPrime (21, 17) returns true 
	 *  isRelativelyPrime (17, 29) returns true
	 * </pre>
	 * 
	 * @param p positive integer
	 * @param q positive integer
	 * @return true if p and q are relatively prime, else false 
	 * @pre. {@code p > 0 }
	 *         and {@code q > 0 }
	 */
	public boolean isRelativelyPrime(int p, int q) {
		int a = euclidRecursiveCheck(p, q);
		if (a == 1) {
			return true;
		}
		return false;
	}
	
	private int euclidRecursiveCheck(int a, int b) {
		if(b == 0) {
			return a;
		}
		if(a<b) {
			return euclidRecursiveCheck(b, a);
		}
		return euclidRecursiveCheck(b,a% b);
		
	}

	/**
	 * 
	 * <p>
	 * Write a recursive function convert any decimal number {@code n > 0 } and
	 * {@code n <= 65535} into a binary number, return an array represents the
	 * binary number
	 * </p>
	 * 
	 * <p>
	 * a binary (base-2) number. A binary number is made up of one or more binary
	 * digits called bits. A bit has a value that is equal to either 0 or 1.
	 * </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  
	 * IntegerToBinary (4)  return [0, 0, 1], where (0*1)+(0*2)+(1*4) = 4 
	 * IntegerToBinary (9)  return [1, 0, 0, 1], where (1*1)+(0*2)+(0*4)+(1*8) = 9
	 * IntegerToBinary (31)  return [1, 1, 1, 1, 1], where (1*1)+(1*2)+(1*4)+(1*8)+(1*16) =31
	 * </pre>
	 * 
	 * @param n positive integer
	 * @return array represents the binary number
	 * 
	 * @pre. {@code n > 0 }
	 */
    


	// public int[] IntegerToBinary(int n) {
	// 	if (num == 0) {
	// 		return new int[0]; // Base case: when num is 0, return an array containing only 0
	// 	} else {
	// 		int[] bp = IntegerToBinary(num / 2); // Recursive call for the quotient
	// 		int remainder = num % 2;
	
	// 		// Concatenate the remainder with the binary prefix in reverse order
	// 		int[] res = new int[bp.length + 1];
	// 		System.arraycopy(bp,0,res,0,bp.length);
	// 		res[bp.length] = remainder;
	// 		Collections.reverse(Arrays.asList(res));
	
	// 		return res;
	// 	}
	// }
	// public int[] IntegerToBinary(int n) {
    //     if (n == 0) {
    //         return new int[0];
    //     }
        
    //     int[] binary = IntegerToBinary(n / 2);
        
    //     if (n % 2 == 0) {
    //         binary = Arrays.copyOf(binary, binary.length + 1);
    //         binary[binary.length - 1] = 0;
    //     } else {
    //         binary = Arrays.copyOf(binary, binary.length + 1);
    //         binary[binary.length - 1] = 1;
    //     }
        
    //     return binary;
    // }
	public int[] IntegerToBinary(int n){
		String ex = "";
		ex = sHelp(n,"");
		int[] arr = new int[ex.length()];
		int i = 0;
		return arrHelp(ex,arr,i);
	}
	private String sHelp(int x , String e){
		if(x>0){
			e=e+x%2;
			return sHelp(x/2,e);
		}else{
			return e;
		}
	}
	private int[] arrHelp(String e,int a[],int i){
		if (i<e.length()) {
			a[i] = Integer.parseInt(e.charAt(i)+"");
			return arrHelp(e,a,i+1);
		}else{
			return a;
		}
	}	
		
	/**
	 * <p>
	 * Write a recursive function returns the complement of decimal integer n, as a
	 * String.The complement of integer n is defined as follows: (1) a 0 in n's
	 * decimal representation is replaced by 9 . (2) a digit {@code d > 0} in n's
	 * decimal representation is replaced by 10-d.
	 * 
	 * <pre>
	 *  Example:
	 *  for n = 43, return "67" and for n = 10203, return "99897"
	 * </pre>
	 * 
	 * @param n integer
	 * @return string complement of the decimal integer as defined above
	 * 
	 *        @pre. {@code n > 0 }
	 *
	 */

	public String complementofDecimal(int n) {
		if (n == 0) {
			return "9";
		} else {
			return complementOfDecimalHelper(n, "");
		}
	}
	private String complementOfDecimalHelper(int n, String result) {
		if (n == 0) {
			return result;
		} else {
			int digit = n % 10;
			if (digit == 0) {
				result = "9" + result;
			} else {
				result = Integer.toString(10 - digit) + result;
			}
			return complementOfDecimalHelper(n / 10, result);
		}
	}

	/**
	 * 
	 * <p>
	 * Write a recursive function numberOfFirstChar returns the number of times the
	 * first char of string {@code str} appears at the beginning of string
	 * {@code str}.
	 * </p>
	 * 
	 * 
	 * 
	 * <p>
	 * Hint: You can String functions such as charAt, length, and substring.
	 * </p>
	 * 	
	 * <pre>
	 *  Example:
	 *  numberOfFirstChar("")  return 0 , empty string 
	 *  numberOfFirstChar("bbbcfreb$b") return  3
	 *  numberOfFirstChar("beqecb$bbb") return  1
	 * 
	 * </pre>
	 * 
	 * @param str is not null String
	 * 
	 * @return the number of times the first char of string str appears at the
	 *         beginning of string str.
	 * 
	 * 
	 *         @pre. {@code str } is not null String
	 */
	public int numberOfFirstChar(String str) {
		if (str.length() <= 1) {
			return str.length();
		} else if (str.charAt(0) == str.charAt(1)) {
			return 1 + numberOfFirstChar(str.substring(1));
		} else {
			return 1;
		}
	}	

	/**
	 * <p>
	 * Write a recursive function compressString that compression long String
	 * {@code str} that contain many adjacent equal characters (but no digits).
	 * 
	 * <pre>
	 *  Example:
	 *  compressString("")  return "" , empty string 
	 *  compressString("bbbcfreb$b") return  "b3c1f1r1e1b1$1b1"
	 *  compressString("bbbrrraaaaaazzzz") return  "b3r3a6z4"
	 * 
	 * </pre>
	 * 
	 * 
	 * @param str : string to be compressed, {@code str} is not null @pre.
	 *            Precondition: s does not contain a digit in '0'.. '9'.
	 * @return the compressed version of long string as explained above
	 * 
	 * 
	 * 
	 *         @pre. {@code str } is not null String and {@code str } does not
	 *         contain a digit in '0'.. '9'.
	 */
	public static String compressString(String str) {
        if (str.isEmpty()) {
            return "";
        }

        return compressHelper(str, str.charAt(0), 1, 1);
    }

    private static String compressHelper(String str, char currentChar, int count, int index) {
        if (index == str.length()) {
            return "" + currentChar + count;
        }

        char nextChar = str.charAt(index);

        if (currentChar == nextChar) {
            return compressHelper(str, currentChar, count + 1, index + 1);
        } else {
            return currentChar + Integer.toString(count) + compressHelper(str, nextChar, 1, index + 1);
        }
    }

	/**
	 * <p>
	 * Write a recursive function returns Yorknacci number y(n).
	 * </p>
	 * 
	 * <p>
	 * Recall the Fibonacci numbers: Fibonacci number an is defined as the sum of
	 * the 2 previous Fibonacci numbers: a(n) = a(n-1)+a(n-2), with a(0) =0, a(1) =
	 * a(2) = 1.. Based on Fibonacci numbers, we define the Yorknacci numbers as the
	 * list of numbers where Yorknacci number y(n) is defined as <strong> the sum of
	 * the previous 3 Yorknacci numbers if n is odd and the sum of the previous 2
	 * Yorknacci numbers if n is even.</strong> The first three Yorknacci numbers
	 * y(0), y(1), and y(2) are 1. {@code y(0)=y(1)=y(2)=1}
	 * 
	 * <pre>
	 *  Example:
	 *  yorknacci(0)  return 1 
	 *  yorknacci(1)  return 1
	 *  yorknacci(2)  return 1
	 *  yorknacci(3)  return 3
	 *  yorknacci(4)  return 4    
	 *  yorknacci(5)  return 8
	 * 
	 * 
	 * </pre>
	 * 
	 * 
	 * @param n : integer value for Yorknacci, {@code n>=0 }
	 * 
	 * @return Return Yorknacci number y(n).
	 * 
	 *         @pre. {@code n>=0}
	 */
	public int yorknacci(int n) {
		if (n==1 ||n==2||n==0){
			return 1;
		} else if(n%2==0){
			return yorknacci(n - 2) + yorknacci(n-1);
		}else{
			return yorknacci(n - 3) + yorknacci(n-2)+yorknacci(n-1);
		}
	}

	/**
	 * <p>
	 * Write a recursive function returns a list storing the first {@code n }
	 * numbers in a Yorknacci sequence.
	 * </p>
	 * 
	 * <p>
	 * <strong> The Yorknacci number is defined above. ( check the API of yorknacci
	 * method)</strong>
	 * </p>
	 * 
	 * <p>
	 * You can assume that n is {@code n>1}. e.g., YorknacciList(5) returns a list
	 * {y(0), y(1), y(2), y(3) , y(4)}= {1, 1, 1, 3, 4}.
	 * 
	 * <pre>
	 *  Example:
	 *  YorknacciList(2)  return {1, 1} 
	 *  YorknacciList(3)  return {1, 1, 1}
	 *  YorknacciList(5)  return {1, 1, 1, 3, 4}
	 * 
	 * 
	 * 
	 * </pre>
	 * 
	 * @param n the first {@code n} Yorknacci numbers
	 * 
	 * @return a list representing the first n Yorknacci numbers
	 * 
	 * 
	 * 
	 *         @pre. {@code n>1}
	 */
	public List<Integer> YorknacciList(int n) {
		List<Integer> res = new ArrayList<>();
		YorknacciListHelper(n,res);

		return res;
	}
	private void YorknacciListHelper(int n, List<Integer> res){
		if(n>0){
			YorknacciListHelper(n-1, res);
			res.add(yorknacci(n-1));
		}
	}

	/**
	 * <p>
	 * Write a recursive function returns a String containing {@code n} occurrences
	 * of character {@code c} .
	 * </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  repeatCharNTimes(2, 'd')  return  "dd"
	 *  repeatCharNTimes(3, 'c')  return  "ccc"
	 *  repeatCharNTimes(5, 'a')  return  "aaaaa"
	 * 
	 * </pre>
	 * 
	 * @param n  : Number of occurrence
	 * @param c: Char to be repeated
	 * 
	 * @return return String containing {@code n} occurrences of character
	 *         {@code c}.
	 * 
	 *         @pre. {@code n >= 0}.
	 */
	public String repeatCharNTimes(int n, char c) {
		if(n==0){
			return "";
		}else{
			return String.valueOf(c) + repeatCharNTimes(n-1, c);
		}
	}

	/**
	 * <p>
	 * Write a recursive function returns String s but with each pair "ci" of
	 * characters, where i is a digit, replaced by i occurrences of c.
	 * </p>
	 * 
	 * <pre>
	 *  Example:
	 *  expandCompressedString("d2")  return  "dd"
	 *  expandCompressedString("c3d2")  return  "cccdd"
	 *  expandCompressedString("a5x4f1")  return  "aaaaaxxxxf"
	 *  expandCompressedString("a5x0f1")  return  "aaaaaf"
	 * </pre>
	 * 
	 * 
	 * 
	 * @param str input compressed String
	 * 
	 * 
	 * 
	 * 
	 * @return a String Expansion of compressed string
	 * 
	 *         @pre. str contains an even number of characters, and the first of
	 *         each pair is a char and the second is a digit.
	 */
	public String expandCompressedString(String str) {

        if (str == null || str.length() <= 1) {
            return str;
        }

        return expandCompressedStringHelper(str, 0);
    }

    private String expandCompressedStringHelper(String str, int index) {
        if (index >= str.length()) {
            return "";
        }

        char currentChar = str.charAt(index);

        if (index + 1 < str.length() && Character.isDigit(str.charAt(index + 1))) {
            int count = Character.getNumericValue(str.charAt(index + 1));

            String expandedSubstring = expandCompressedStringHelper(str, index + 2);


            return repeatChar(currentChar, count) + expandedSubstring;
        } else {

            return currentChar + expandCompressedStringHelper(str, index + 1);
        }
    }

    private String repeatChar(char c, int count) {
        if (count <= 0) {
            return "";
        }
        return String.valueOf(c) + repeatChar(c, count - 1);
    }

	/**
	 * 
	 * <p>
	 * Write a recursive function convert any decimal number {@code n > 0 } and
	 * {@code n <= 65535} into a octal number, return an array represents the octal
	 * number
	 * </p>
	 * 
	 * <p>
	 * A octal (base-8) number. A octal number is made up of one or more octal
	 * digits {0, 1, 2, 3, 4, 5, 6, 7}.
	 * 
	 * </p>
	 * 
	 * 
	 * <pre>
	 *  Example:
	 *  
	 * IntegerToOctal (4)  return [4], where (4*1) = 4 
	 * IntegerToOctal (9)  return [1, 1], where (1*1)+(1*8) = 9
	 * IntegerToOctal (31)  return [7, 3], where (7*1)+(3*8) =31
	 * 
	 * IntegerToOctal (65535)  return [7, 7, 7, 7, 7, 1], 
	 * 		where (7*1)+(7*8)+ (7*64)+ (7*512)+(7*4096)+ (1*32768) =65535
	 * </pre>
	 * 
	 * @param n positive integer
	 * @return array represents the octal number
	 * 
	 *         @pre. {@code n > 0 }
	 */
	public int[] IntegerToOctal(int n) {
		String ex = "";
		ex = sOctHelp(n, "");
		int[] arr = new int[ex.length()];
		int i = 0;
		return arrOctHelp(ex, arr, i);
	}
	
	private String sOctHelp(int x, String e) {
		if (x > 0) {
			e += x % 8 ;
			return sOctHelp(x / 8, e);
		} else {
			return e;
		}
	}
	
	private int[] arrOctHelp(String e, int a[], int i) {
		if (i < e.length()) {
			a[i] = Integer.parseInt(e.charAt(i) + "");
			return arrOctHelp(e, a, i + 1);
		} else {
			return a;
		}
	}
}
