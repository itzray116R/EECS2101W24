package lab1;


import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitTest_RecursiveMethodsTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	  @Test
	    public void test_999_NoLoop() {

	        try {
	            File file = new File("src/lab1/RecursiveMethods.java");
	            Scanner myReader = new Scanner(file);
	            Pattern pattern = Pattern.compile("(for|while)\\s*\\(");
	            while (myReader.hasNextLine()) {
	                String data = myReader.nextLine();
	                Matcher matcher = pattern.matcher(data);
	                if (matcher.find()) {
	                    fail("Do NOT use any loop!");
	                }
	            }
	            myReader.close();
	        }
	        catch (Exception ex) {
	            fail("File does not exist.");
	        }
	    }

	  
	  @Test
		public void test_01_00_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(2);
			int[] exp = {1, 1};
			assertArrayEquals("fibArray method failed",exp, rest);
		}
		@Test
		public void test_01_01_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(3);
			int[] exp = {1, 1, 2};
			assertArrayEquals("fibArray method failed",exp, rest);
		}

		@Test
		public void test_01_03_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(4);
			int[] exp = {1, 1, 2, 3};
			assertArrayEquals("fibArray method failed",exp, rest);
		}
		
		@Test
		public void test_01_04_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(5);
			int[] exp = {1, 1, 2, 3, 5};
			assertArrayEquals("fibArray method failed",exp, rest);
		}
		
		@Test
		public void test_01_05_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(6);
			int[] exp = {1, 1, 2, 3, 5, 8};
			assertArrayEquals("fibArray method failed",exp, rest);
		}
		
		@Test
		public void test_01_06_FibArray() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.fibArray(12);
			int[] exp = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
			assertArrayEquals("fibArray method failed",exp, rest);
		}
		
		@Test
		public void test_02_01_isRelativelyPrime() {
			RecursiveMethods rm = new RecursiveMethods();
			
			assertTrue("isRelativelyPrime method failed",rm.isRelativelyPrime(5, 6));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(10, 6));
		}
		
		@Test
		public void test_02_02_isRelativelyPrime() {
			RecursiveMethods rm = new RecursiveMethods();
			

			assertTrue("isRelativelyPrime method failed",rm.isRelativelyPrime(17,29));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(8, 20));
		}
		
		@Test
		public void test_02_03_isRelativelyPrime() {
			RecursiveMethods rm = new RecursiveMethods();
			assertTrue("isRelativelyPrime method failed",rm.isRelativelyPrime(11, 13));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(24, 16));
			
		}
		
		@Test
		public void test_02_04_isRelativelyPrime() {
			RecursiveMethods rm = new RecursiveMethods();

			assertTrue("isRelativelyPrime method failed",rm.isRelativelyPrime(19, 3));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(50, 15));
			
		}
		@Test
		public void test_02_05_isRelativelyPrime() {
			RecursiveMethods rm = new RecursiveMethods();
			

			assertTrue("isRelativelyPrime method failed",rm.isRelativelyPrime(21, 17));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(8, 6));
			assertFalse("isRelativelyPrime method failed",rm.isRelativelyPrime(15, 25));
			
		}
		
		
		
		@Test
		public void test_03_01_IntegerToBinary() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToBinary(4);
			int[] exp = {0, 0, 1};
			assertArrayEquals("IntegerToBinary method failed",exp, rest);
			
		}
		@Test
		public void test_03_02_IntegerToBinary() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToBinary(31);
			int[] exp = {1, 1, 1, 1, 1};
			assertArrayEquals("IntegerToBinary method failed",exp, rest);
			
		}
		@Test
		public void test_03_03_IntegerToBinary() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToBinary(65535);
			int[] exp = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
			assertArrayEquals("IntegerToBinary method failed",exp, rest);
			
		}
		
		
		@Test
		public void test_04_01_complementofDecimal() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.complementofDecimal(65535);
			String  exp = "45575";
			assertTrue("complementofDecimal method failed",exp.equals(rest));
			
			
		}
		
		@Test
		public void test_04_02_complementofDecimal() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.complementofDecimal(500735);
			String  exp = "599375";
			assertTrue("complementofDecimal method failed",exp.equals(rest));
			
			
		}
		
		@Test
		public void test_04_03_complementofDecimal() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.complementofDecimal(111500);
			String  exp = "999599";
			assertTrue("complementofDecimal method failed",exp.equals(rest));
			
			
		}
		
		@Test
		public void test_05_01_numberOfFirstChar() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.numberOfFirstChar("aaaxd%fdsefg");
			int  exp = 3;
			assertTrue("numberOfFirstChar method failed", exp==rest );
			
			
		}
		
		
		@Test
		public void test_05_02_numberOfFirstChar() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.numberOfFirstChar("drfefdsefg");
			int  exp = 1;
			assertTrue( "numberOfFirstChar method failed",exp==rest );
			
			
		}
		
		@Test
		public void test_05_03_numberOfFirstChar() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.numberOfFirstChar("");
			int  exp = 0;
			assertTrue( "numberOfFirstChar method failed",exp==rest );
			
			
		}
		
		@Test
		public void test_05_04_numberOfFirstChar() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.numberOfFirstChar("bbbcfreb$b");
			int  exp = 3;
			assertTrue( "numberOfFirstChar method failed",exp==rest );
			
			
		}

		
		@Test
		public void test_06_01_compressString() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.compressString("bbbcfreb$b");
			String  exp = "b3c1f1r1e1b1$1b1";
			assertTrue("compressString method failed",exp.equals(rest));
			
			
		}
		
		
		@Test
		public void test_06_02_compressString() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.compressString("");
			String  exp = "";
			assertTrue("compressString method failed",exp.equals(rest));
			
			
		}
		
		@Test
		public void test_06_03_compressString() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.compressString("bbbcfreb$b");
			String  exp = "b3c1f1r1e1b1$1b1";
			assertTrue("compressString method failed",exp.equals(rest));
			
			
		}
		@Test
		public void test_06_04_compressString() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.compressString("bbbrrraaaaaazzzz");
			
			String  exp = "b3r3a6z4";
			assertTrue("compressString method failed",exp.equals(rest));
			
			
		}
		
		@Test
		public void test_06_05_compressString() {
			RecursiveMethods rm = new RecursiveMethods();
			String  rest = rm.compressString("bbbbbbbbrrrrrrraaaaaazzzzzzzzzzzz");
			String  exp = "b8r7a6z12";
			assertTrue("compressString method failed",exp.equals(rest));
		}
		
		
		
		@Test
		public void test_07_01_yorknacci() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.yorknacci(0);
			int  exp = 1;
			assertTrue("yorknacci method failed",exp==rest);
		}
		@Test
		public void test_07_02_yorknacci() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.yorknacci(1);
			int  exp = 1;
			assertTrue("yorknacci method failed",exp==rest);
		}
		
		@Test
		public void test_07_03_yorknacci() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.yorknacci(2);
			int  exp = 1;
			assertTrue("yorknacci method failed",exp==rest);
		}
		
		@Test
		public void test_07_04_yorknacci() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.yorknacci(4);
			int  exp = 4;
			assertTrue("yorknacci method failed",exp==rest);
		}
		
		
		@Test
		public void test_07_05_yorknacci() {
			RecursiveMethods rm = new RecursiveMethods();
			int  rest = rm.yorknacci(20);
			int  exp = 26244;
			assertTrue("yorknacci method failed",exp==rest);
		}
		
		@Test
		public void test_08_01_YorknacciList() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> rest = rm.YorknacciList(2);
			
			
			List<Integer> expl = Arrays.asList(1, 1);
			assertEquals("YorknacciList method failed",rest, expl);
		}
		
		@Test
		public void test_08_02_YorknacciList() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> rest = rm.YorknacciList(3);
					
			List<Integer> expl = Arrays.asList(1, 1, 1);
			assertEquals("YorknacciList method failed",rest, expl);
		}
		
		@Test
		public void test_08_03_YorknacciList() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> rest = rm.YorknacciList(6);
			
			
			List<Integer> expl = Arrays.asList(1, 1, 1, 3, 4, 8);
			assertEquals("YorknacciList method failed",rest, expl);
		}
		
		@Test
		public void test_08_04_YorknacciList() {
			RecursiveMethods rm = new RecursiveMethods();
			List<Integer> rest = rm.YorknacciList(8);
			
			List<Integer> expl = Arrays.asList(1, 1, 1, 3, 4, 8, 12, 24);

			assertEquals("YorknacciList method failed",rest, expl);
		}
		
		
		
		@Test
		public void test_09_01_repeatCharNTimes() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.repeatCharNTimes(4, 'e');
			String exp = "eeee" ;
			assertTrue("repeatCharNTimes method failed",exp.equals(rest));
		}
		@Test
		public void test_09_02_repeatCharNTimes() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.repeatCharNTimes(10, 'A');
			String exp = "AAAAAAAAAA" ;
			assertTrue("repeatCharNTimes method failed",exp.equals(rest));
		}
		
		@Test
		public void test_09_03_repeatCharNTimes() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.repeatCharNTimes(0, 'A');
			String exp = "" ;
			assertTrue("repeatCharNTimes method failed",exp.equals(rest));
		}
		
		@Test
		public void test_09_04_repeatCharNTimes() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.repeatCharNTimes(7, 'A');
			String exp = "AAAAAAA" ;
			assertTrue("repeatCharNTimes method failed",exp.equals(rest));
		}
		
		
		@Test
		public void test_10_01_expandCompressedString() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.expandCompressedString("A3B2");
			String exp = "AAABB" ;
			assertTrue("expandCompressedString method failed",exp.equals(rest));
		}
		@Test
		public void test_10_02_expandCompressedString() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.expandCompressedString("A2a3r4v0w1g4");
			String exp = "AAaaarrrrwgggg" ;
			assertTrue("expandCompressedString method failed",exp.equals(rest));
		}
		
		@Test
		public void test_10_03_expandCompressedString() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.expandCompressedString("A2a3v0w0g7");
			String exp = "AAaaaggggggg" ;
			assertTrue("expandCompressedString method failed",exp.equals(rest));
		}
		
		@Test
		public void test_10_04_expandCompressedString() {
			RecursiveMethods rm = new RecursiveMethods();
			String rest = rm.expandCompressedString("A5a3v1w7g9");
			String exp = "AAAAAaaavwwwwwwwggggggggg" ;
			assertTrue("expandCompressedString method failed",exp.equals(rest));
		}
		
		
		
		
		@Test
		public void test_11_01_IntegerToOctal() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToOctal(4);
			int[] exp = {4};
			assertArrayEquals("IntegerToOctal method failed",exp, rest);
			
		}
		@Test
		public void test_11_02_IntegerToOctal() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToOctal(31);
			int[] exp = {7, 3};
			assertArrayEquals("IntegerToOctal method failed",exp, rest);
			
		}
		
		
		@Test
		public void test_11_03_IntegerToOctal() {
			RecursiveMethods rm = new RecursiveMethods();
			int[] rest = rm.IntegerToOctal(65535);
			int[] exp = {7, 7, 7, 7, 7, 1};
			assertArrayEquals("IntegerToOctal method failed",exp, rest);
			
		}
		
	
	  
}
