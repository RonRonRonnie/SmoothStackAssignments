package JavaBasicTwoAssignment.Shapes;

public class Rectangle implements Shape{
    @Override
    public double calculateArea(double length, double width) {
        return length * width;

    }
    @Override
    public void display(double area) {
        System.out.println("the area of this rectangle is "+area);

    }

    public static void main(String[] args){
        int length = 3;
        int width = 4;
        double area;
        Rectangle rectangle = new Rectangle();
        area = rectangle.calculateArea(length,width);
        rectangle.display(area);

    }
}
