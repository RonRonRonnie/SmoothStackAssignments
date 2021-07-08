package JavaBasicTwoAssignment.Shapes;

public class Circle implements Shape{
    @Override
    public  double calculateArea(double radius, double pi) {

        return pi*radius*radius;
    }


    @Override
    public void display(double area) {
        System.out.println("the area of this circle is "+area);

    }

    public static void main(String[] args){
        double ans ;
        double pi = 3.14;
        double radius = 5.78;
        Circle circle = new Circle();
        ans =  circle.calculateArea(radius,pi);
        circle.display(ans);
    }

}
