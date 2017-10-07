import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.lesson6_homework.Task1;



public class Task1Test {
  @Test
  public void testEmpty() {
    try {
      int[] input = {};
      Task1.getArray(input);
      Assert.fail("getArray() with empty input should throw");
    } catch (Exception e) {
      Assert.assertTrue(e instanceof RuntimeException);
      Assert.assertTrue(e.getMessage().contains("4 expected but not found in"));
    }
  }

  @Test
  public void testFourInTheMiddle() {
    int[] input = {1, 2, 3, 4, 5, 6};
    int[] expected = {5, 6};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testWithoutFour() {
    try {
      int[] input = {1, 2};
      Task1.getArray(input);
      Assert.fail("getArray() without 4 input should throw");
    } catch (Exception e) {
      Assert.assertTrue(e instanceof RuntimeException);
      Assert.assertTrue(e.getMessage().contains("4 expected but not found in"));
    }
  }

  @Test
  public void testFourInTheBeggining() {
    int[] input = {4, 5, 6, 7, 8, 9};
    int[] expected = {5, 6, 7, 8, 9};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testFourInTheEnd() {
    int[] input = {1, 2, 3, 4};
    int[] expected = {};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testSingleFour() {
    int[] input = {4};
    int[] expected = {};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testMultipleFours() {
    int[] input = {1, 4, 2, 3, 4, 5};
    int[] expected = {5};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testOnlyFours() {
    int[] input = {4, 4, 4, 4};
    int[] expected = {};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }

  @Test
  public void testMultipleFoursInTheBeggining() {
    int[] input = {4, 4, 1, 2, 3};
    int[] expected = {1, 2, 3};
    Assert.assertArrayEquals(expected, Task1.getArray(input));
  }
}
