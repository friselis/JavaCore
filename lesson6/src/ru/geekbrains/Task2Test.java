import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.lesson6_homework.Task2;

public class Task2Test {

    @Test
    public void testOnlyOneAndFour() {
        int[] input = {1, 4, 1, 4, 4, 1, 1};
        Assert.assertTrue(Task2.checkArray(input));
    }

    @Test
    public void testNoOneAndNoFour() {
        int[] input = {3, 5, 6, 7};
        Assert.assertFalse(Task2.checkArray(input));
    }

    @Test
    public void testEmpty() {
        int[] input = {};
        Assert.assertFalse(Task2.checkArray(input));
    }

    @Test
    public void testOnlyFour() {
        int[] input = {4, 4, 4, 4, 4, 4};
        Assert.assertFalse(Task2.checkArray(input));
    }

    @Test
    public void testOnlyOne() {
        int[] input = {1, 1, 1, 1};
        Assert.assertFalse(Task2.checkArray(input));
    }
}
