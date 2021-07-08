package JavaBasicTwoAssignment.Shapes;

public class Triangle implements Shape {
    @Override
    public double calculateArea(double length, double height) {

       return (length*height)/2;
    }

    @Override
    public void display(double area) {
        System.out.println("the area of this triangle is "+area);
    }

    public static void main(String[] args){
        double length = 12.44;
        double height = 70.44;
        double ans;
        Triangle triangle = new Triangle();
        ans = triangle.calculateArea(length,height);
        triangle.display(ans);
    }
}
