package homework1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class Homework1Test {

	Random r = new Random();

	@Test
	public void testLibs() throws IOException {
		Files.walk(Paths.get(System.getProperty("user.dir")))
		.filter(file->{ 
			return file.endsWith("homework1.java");
		})
		.forEach(file ->{
			try {
				BufferedReader b = new BufferedReader(new FileReader(file.toFile()));

				String readLine = "";

				while ((readLine = b.readLine()) != null) {
					readLine = readLine.toLowerCase().replaceAll("\\s+", "");

					//readLine = readLine.substring(0, readLine.indexOf("//"));

					if(readLine.contains("importjava.util") || readLine.contains("importjava.*")) {
						throw new Exception("Code from the java.util library detected. You are not allowed to use any resources from the Java.util package");
					}

					if(readLine.startsWith("import") && !readLine.startsWith("importjava.")) {
						System.out.print(readLine);
						throw new Exception("Code from the 3rd party library detected.You are not allowed to use any resources from 3rd party libraries");
					}
				}

				b.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		});
	}

	@Test
	public void findMinMaxTest_1() {

		final int[] ARRAY = new int[]{ 1, 2, 3};
		final int MIN = 0;
		final int MAX = 2;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest() {

		final int[] ARRAY = new int[]{ -1, -2, -3};
		final int MIN = 2;
		final int MAX = 0;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_2() {

		final int[] ARRAY = new int[]{ 1, -2, 5, 1, 7, -2, -4, 2};
		final int MIN = 1;
		final int MAX = 4;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_3() {

		final int[] ARRAY = new int[]{ 1, -2, 5, 1, 7, -2, -4, 2};
		final int MIN = 1;
		final int MAX = 4;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_4() {

		final int[] ARRAY = new int[]{ 4, 2, -5, 8, -7, -2, 4, 12};
		final int MIN = 5;
		final int MAX = 7;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_5() {

		final int[] ARRAY = new int[]{ 0, 7, -9, 0, -1, 6, 4, -2};
		final int MIN = 4;
		final int MAX = 6;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertTrue("Dance Counter - The max index does not match", result[1] == 6 || result[1] == 1);
	}

	@Test
	public void findMinMaxTest_6() {

		final int[] ARRAY = new int[]{ 0, 0, 0, 0, 0, 0};
		final int MIN = 0;
		final int MAX = 0;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_7() {

		final int[] ARRAY = new int[]{1};
		final int MIN = 0;
		final int MAX = 0;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void findMinMaxTest_8() {

		final int[] ARRAY = new int[]{-1};
		final int MIN = 0;
		final int MAX = 0;


		int[] result = Homework1.findMinMax(ARRAY);

		Assert.assertEquals("Dance Counter - The min index does not match", MIN, result[0]);
		Assert.assertEquals("Dance Counter - The max index does not match", MAX, result[1]);
	}

	@Test
	public void removeDupTest_1() {

		final int[] INPUT = new int[]{1, 2, 5, 1, 7, 2, 4, 2};
		final int[] OUTPUT = new int[]{1, 2, 5, 7, 4};

		int[] result = Homework1.removeDup(INPUT);
		System.out.println("......................");
		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_2() {

		final int[] INPUT = new int[]{7, 2, 5, 5, 7, 2, 2, 2};
		final int[] OUTPUT = new int[]{7, 2, 5};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_3() {

		final int[] INPUT = new int[]{7, 2, 5};
		final int[] OUTPUT = new int[]{7, 2, 5};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_4() {

		final int[] INPUT = new int[]{7};
		final int[] OUTPUT = new int[]{7};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_5() {

		final int[] INPUT = new int[]{7, 7, 7, 7, 7, 7};
		final int[] OUTPUT = new int[]{7};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_6() {

		final int[] INPUT = new int[]{6, 7, 7, 7, 7, 7};
		final int[] OUTPUT = new int[]{6, 7};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void removeDupTest_7() {

		final int[] INPUT = new int[]{5, 7, 7, 7, 7, 5};
		final int[] OUTPUT = new int[]{5, 7};

		int[] result = Homework1.removeDup(INPUT);

		Assert.assertArrayEquals("Clean the Data - The resulting array does not match expected value", OUTPUT, result);
	}


	@Test
	public void createMirrorTest_1() {
		final String INPUT = "fy";
		final int OUTPUT = 1;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_2() {
		final String INPUT = "cdvi";
		final int OUTPUT = 3;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_3() {
		final String INPUT = "qswwbi";
		final int OUTPUT = 4;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_4() {
		final String INPUT = "yqzhxdua";
		final int OUTPUT = 7;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_5() {
		final String INPUT = "bzwigvswlk";
		final int OUTPUT = 7;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_6() {
		final String INPUT = "unokalwxsexg";
		final int OUTPUT = 9;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_7() {
		final String INPUT = "rpwkagtngbrsjy";
		final int OUTPUT = 9;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}

	@Test
	public void createMirrorTest_8() {
		final String INPUT = "hbheibwjwskvezvi";
		final int OUTPUT = 11;
		int result = Homework1.createMirror(INPUT);
		Assert.assertEquals("Create Mirror Test - The resulting array does not match expected value", OUTPUT, result);
	}


	@Test
	public void minVisitsTest_1() {
		final int mechanics = 1;
		final int houses = 20;
		final int OUTPUT = 20;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_2() {
		final int mechanics = 7;
		final int houses = 26;
		final int OUTPUT = 5;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_3() {
		final int mechanics = 3;
		final int houses = 39;
		final int OUTPUT = 6;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_4() {
		final int mechanics = 7;
		final int houses = 96;
		final int OUTPUT = 7;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_5() {
		final int mechanics = 3;
		final int houses = 49;
		final int OUTPUT = 7;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_6() {
		final int mechanics = 8;
		final int houses = 65;
		final int OUTPUT = 7;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_7() {
		final int mechanics = 10;
		final int houses = 60;
		final int OUTPUT = 6;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_8() {
		final int mechanics = 2;
		final int houses = 93;
		final int OUTPUT = 14;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_9() {
		final int mechanics = 3;
		final int houses = 95;
		final int OUTPUT = 9;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}

	@Test
	public void minVisitsTest_10() {
		final int mechanics = 2;
		final int houses = 77;
		final int OUTPUT = 12;
		int result = Homework1.minVisits(mechanics, houses);
		Assert.assertEquals("Power Company Problem - The resulting number of visits does not match expected value", OUTPUT, result);
	}


}
