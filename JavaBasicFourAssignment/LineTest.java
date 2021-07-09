package JavaBasicFourAssignment;

import org.junit.jupiter.api.*;

class Line{
    public float getSlope(float x1, float y1, float x2, float y2){
        return (y2 - y1) / (x2 - x1);
    }

    public float getDistance(float x1, float y1, float x2, float y2){
        return (float) Math.sqrt(
                Math.pow(x1 - x2, 2) +
                        Math.pow(y1 - y2, 2) );
    }

    public String parallelTo(float a1, float b1,
                             float a2,
                             float b2){
        // If slopes are equal
        if ((-(a1 / b1)) == (-(a2 / b2)))
        {
            return "yes";
        }
        else
        {
            return "no";
        }
    }

    }



public class LineTest {
    private Line line;

    @BeforeEach
    public void setUp() {
        line = new Line();
    }

    @Test
    public void testGetSlope(){
        Assertions.assertEquals(1.4285
                ,line.getSlope(12,18,5,8), 0.0001,"Regular calculation should work");
    }

    @RepeatedTest(5)
    public void testMultiplyGetSlope() {
        Assertions.assertEquals(3.6969, line.getSlope(100,300,34,56), 0.0001,"Regular calculation should work");

    }

    @Test
    public void testgetDistance(){
        Assertions.assertEquals(26.1963,line.getDistance(-7,-4,17,(float) 6.5),0.0001,"Regular calculation should work");
    }

    @RepeatedTest(5)
    public void testMultiplygetDistance() {
        Assertions.assertEquals(252.7686, line.getDistance(100,300,34,56), 0.0001,"Regular calculation should work");
    }

    @Test
    public void parallelTo(){
        Assertions.assertEquals("yes",line.parallelTo(4,2,4,2),"Regular calculation should work");
    }

    @RepeatedTest(5)
    public void testMultiplyParallelTo(){
        Assertions.assertEquals("no",line.parallelTo(1,4,2,3),"Regular calculation should work");
    }

}
