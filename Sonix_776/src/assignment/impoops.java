package assignment;

 
	
	abstract class Shape {
	    
	    public abstract double calculateArea();
	}

	
	class Circle extends Shape {
	    private double radius;

	    public Circle(double radius) {
	        this.radius = radius;
	    }

	
	    @Override
	    public double calculateArea() {
	        return Math.PI * radius * radius;
	    }
	}

	
	class Rectangle extends Shape {
	    private double width;
	    private double height;

	    public Rectangle(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }

	    
	    @Override
	    public double calculateArea() {
	        return width * height;
	    }
	}

	
	class ShapeCalculator {
	    public double getArea(Shape shape) {
	        return shape.calculateArea();
	    }
	}

	interface Drawable {
	    void draw();
	}
	class Circlel implements Drawable {
	    private double radius;

	    public Circlel(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    public void draw() {
	        System.out.println("Drawing a circle with radius " + radius);
	    }
	}

	class Rectangl implements Drawable {
	    private double width;
	    private double height;

	    public Rectangl(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }

	    @Override
	    public void draw() {
	        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
	    }
	}
	public class impoops{
	    public static void main(String[] args) {
	        Circle circle = new Circle(5.0);
	        Rectangle rectangle = new Rectangle(4.0, 6.0);

	        ShapeCalculator calculator = new ShapeCalculator();
	        double circleArea = calculator.getArea(circle);
	        double rectangleArea = calculator.getArea(rectangle);

	        System.out.println("Circle Area: " + circleArea);
	        System.out.println("Rectangle Area: " + rectangleArea);

	        Drawable drawableCircle =( Drawable) new Circlel(3.0);
	        Drawable drawableRectangle= (Drawable)new Rectangl(8.0, 2.0);

	        drawableCircle.draw();
	        drawableRectangle.draw();
	    }
	}
	
	

