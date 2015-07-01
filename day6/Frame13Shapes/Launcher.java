package day6.Frame13Shapes;

/**
 * Created by julia on 22.06.2015.
 */
public class Launcher {
    public static void main(String[] args) {

        Circle c =new Circle(50,50,100);
        Triangle t= new Triangle(new int[]{100,150,200}, new int[]{250,150,250});
        Rectangle r=new Rectangle(200,50,150,50);
        Square s=new Square(250,150,50);

        System.out.println(c.toString());
        System.out.println(t.toString());
        System.out.println(r.toString());


        Drawable[] shapes =new Drawable[4];
        shapes[0]=c;
        shapes[1]=t;
        shapes[2]=r;
        shapes[3]=s;

        ShapesTemplate shapeTemplate =new ShapesTemplate(shapes);
    }
}
