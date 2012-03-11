/*
File: Geometry.java

Description: Uses object oriented programming in order to use various geometry tools such as 
finding if two triangles intersect in a coordinate plane

Instructions: http://www.cs.utexas.edu/~mitra/csFall2011/cs312/assgn/assgn3.html

Student Name: Daniel Monroy

Student UT EID: dm35729

Course Name: CS 312

Date Created: October 30, 2011

*/

//import packages
import java.util.*;
import java.io.*; 

//create a class for a point

class Point
{
  //create attributes
  private double x;
  private double y;

  //default constructor
  public Point()
  {
    x=0.0;
    y=0.0;
  }
  
  //non-default constructor
  public Point(double x, double y)
  {
    this.x=x;
    this.y=y;
  }
   
  //accessor
  public double getX()
  {
    return x;
  }

  //accessor
  public double getY()
  {
    return y;
  }

  //mutator
  public void setX(double x)
  {
    this.x=x;
  }
  
  //mutator
  public void setY(double y)
  {
    this.y=y;
  }

  //distance to another point
  public double distance(Point P)
  {
    double distance=Math.sqrt(Math.pow((x - P.getX()),2.0) + Math.pow((y-P.getY()),2.0));
    return distance;
  }

  //string representation of a point( x and y coordinates)
  public String toString()
  {
    String s="(" + x + ", " + y + ")";
    return s;
  }

  //test for equality of two points
  public boolean equals (Point p)
  {
     double delta = 1.0e-13;
     return ((Math.abs(p.getY() - y) < delta) && (Math.abs(p.getX() - x) < delta));
  }
}

class Line
{
  // list of attributes
  private double slope;
  private double intercept;

  // default constructor (slope = 1 and intercept = 0)
  public Line ()
  {
	  this.slope=1.0;
	  this.intercept=0.0;
  }

  // non-default constructors
  public Line (double slope, double intercept)
  {
	  this.slope = slope;
	  this.intercept = intercept;
  }

  public Line (Point p, Point q)
  {
	  this.slope = (q.getY()-p.getY()) / (q.getX()-p.getX());
	  this.intercept = (q.getY() - (q.getY()-p.getY()) / (q.getX()-p.getX())*q.getX());
  }

  // accessors
  public double getSlope ()
  {
	  return slope;
  }

  public double getIntercept ()
  {
	  return intercept;
  }

  // mutators
  public void setSlope (double slope)
  {
	  this.slope = slope;
  }

  public void setIntercept (double intercept)
  {
	  this.intercept = intercept;
  }

  // determine if two lines are parallel
 public boolean isParallel (Line line)
  {
	 double delta = 1.0e-13;
	 double epsilon = 1.0e-13 * -1;
     return ((slope - line.getSlope()) < delta && (slope - line.getSlope()) > epsilon);
  }
 
  // determine the intersection point if two lines are not parallel
  public Point intersectionPoint (Line line)
  {
	  double xint;
	  double yint;
	  xint = ((intercept - line.getIntercept()) / (line.getSlope() - slope));
	  yint = (slope * xint + intercept);
	  Point result = new Point(xint, yint);
	  return result;
  }

  // determine if two lines are perpendicular to each other
  public boolean isPerpendicular (Line line)
  {
	  double delta = -1 + 1.0e-13;
	  double epsilon = -1 - 1.0e-13;
	  return ((slope * line.getSlope()) < delta && (slope * line.getSlope()) > epsilon);
  }

  // determine the perpendicular distance of a point to the line
  public double distance (Point p)
  {
	  double result;
	  result = (Math.abs(slope*p.getX() - p.getY() + intercept) / Math.sqrt(slope * slope + 1));
	  return result;
  }

  // determine if two points are on the same side of the line
  public boolean onSameSide (Point p, Point q)
  {
	  if((p.getY() > (slope * p.getX() + intercept)) && (q.getY() > (slope * q.getX() + intercept)))
	  {
		  return true;
	  }
	  else if((p.getY() < (slope * p.getX() + intercept)) && (q.getY() < (slope * q.getX() + intercept)))
	  {
		  return true;
	  }
	  return false;
  }

  // string representation of a line, i.e. the slope and intercept
  public String toString ()
  {
	  String s = new String("Slope: " + slope + ", Intercept: " + intercept);
	  return s;
  }

  // determine if two lines are equal
  public boolean equals (Line line)
  {
	  if(line.getSlope() == slope && line.getIntercept() == intercept)
	  {
		  return true;
	  }
	  return false;
  }
}

//Triangle class
class Triangle
{
  // list attributes
  private Point v1;
  private Point v2;
  private Point v3;

  // default constructor creates a triangle having
  // vertices (0, 0), (1, 0), and (0, 1).
  public Triangle ()
  {
	  this.v1 = new Point (0, 0);
	  this.v2 = new Point (1, 0);
	  this.v3 = new Point (0, 1);
  }
  
  // non-default constructors accept user defined points
  public Triangle (double x1, double y1, double x2, double y2, double x3, double y3)
  {
	  this.v1 = new Point(x1, y1);
	  this.v2 = new Point(x2, y2);
	  this.v3 = new Point(x3, y3);
  }
  
  // creates triangle object if the points form a
  // triangle or the default triangle if they do not.
  public Triangle (Point v1, Point v2, Point v3)
  {
	  Line v1v2 = new Line(v1, v2);
	  Line v2v3 = new Line(v2, v3);
	  if(!v1v2.equals(v2v3))
	  {
		  this.v1 = v1;
		  this.v2 = v2;
		  this.v3 = v3;
	  }
  }
  
  // accessors
  public Point getVertex1 ()
  {
	  return v1;
  }
  public Point getVertex2 ()
  {
	  return v2;
  }
  public Point getVertex3 ()
  {
	  return v3;
  }

  // mutators reset the vertices only if the triangle shape
  // is preserved i.e. the points do not collapse to a line
  public void setVertex1 (Point v1)
  {
	  this.v1 = v1;
  }
  public void setVertex2 (Point v2)
  {
	  this.v2 = v2;
  }
  public void setVertex3 (Point v3)
  {
	  this.v3 = v3;
  }

  public void setVertex1 (double x1, double y1)
  {
	  Point v1 = new Point(x1, y1);
	  this.v1 = v1;
  }
  public void setVertex2 (double x2, double y2)
  {
	  Point v2 = new Point(x2, y2);
	  this.v2 = v2;
  }
  public void setVertex3 (double x3, double y3)
  {
	  Point v3 = new Point(x3, y3);
	  this.v3 = v3;
  }

  // determines if three points form a triangle
  public boolean isTriangle (Point p1, Point p2, Point p3)
  {
	  double a = p1.distance(p2);
	  double b = p2.distance(p3);
	  double c = p1.distance(p3);
	  if (p1.equals(p2) || p2.equals(p3) || p1.equals(p3))
	  {
		  return false;
	  }
	  Line l1 = new Line(p1, p2);
	  Line l2 = new Line(p2, p3);
	  if(l1.equals(l2))
	  {
		  return false;
	  }
	  else if((a+b)>c || (b+c)>a || (a+c)>b)
	  {
		  return true;
	  }
	  return false;
  }
 /*
  private boolean isTriangle (double x1, double y1, double x2, double y2, double x3, double y3)
  {
	  Point p1 = new Point (x1, y1);
	  Point p2 = new Point (x2, y2);
	  Point p3 = new Point (x3, y3);
	  double a = p1.distance(p2);
	  double b = p2.distance(p3);
	  double c = p1.distance(p3);
	  
	  if((a+b)>c || (b+c)>a || (a+c)>b)
	  {
		  return true;
	  }
	  return false;
  }
*/
  // calculates area of a triangle
  public double area ()
  {
	  Line base = new Line(v1, v3);
	  double height = base.distance(v2);
	  double lengthBase = v1.distance(v3);
	  double area = (lengthBase * height / 2);
	  return area;
  }

  // calculates the perimeter
  public double perimeter ()
  {
	  double a = v1.distance(v2);
	  double b = v2.distance(v3);
	  double c = v1.distance(v3);
	  double perimeter = (a + b + c);
	  return perimeter;
  }

  // determines if a point is inside the triangle
  public boolean isInside (Point p)
  {
	  Triangle mini1 = new Triangle (v1, v2, p);
	  Triangle mini2 = new Triangle (v2, v3, p);
	  Triangle mini3 = new Triangle (v1, v3, p);
	  double miniAreas = mini1.area() + mini2.area() + mini3.area();
	  double delta = this.area() + 1.0e-13;
	  double epsilon = this.area() - 1.0e-13;
	  return (miniAreas < delta && miniAreas > epsilon);
  }

  // determines if the given triangle is completely inside
  public boolean isInside (Triangle t)
  {
	  Triangle input = new Triangle (v1, v2, v3);
	  double centroidX = (t.getVertex1().getX() + t.getVertex2().getX() + t.getVertex3().getX()) / 3;
	  double centroidY = (t.getVertex1().getY() + t.getVertex2().getY() + t.getVertex3().getY()) / 3;
	  Point centroid = new Point(centroidX, centroidY);
	  if(t.area() >= this.area())
	  {
		  return false;
	  }
	  else if(input.equals(t))
	  {
		  return true;
	  }
	  else if(input.isInside(centroid))
	  {
		  return true;
	  }
	  boolean a = input.isInside(t.getVertex1());
	  boolean b = input.isInside(t.getVertex2());
	  boolean c = input.isInside(t.getVertex3());
	  return(a && b && c);	  
  }
  // determines if the given triangle overlaps, if the given
  // triangle is completely inside it overlaps
  public boolean doesOverlap (Triangle t)
  {
	  Triangle input = new Triangle (v1, v2, v3);
	  return(input.isInside(t.getVertex1()) || input.isInside(t.getVertex2()) || input.isInside(t.getVertex3()));
  }

  // determines if a line passes through the triangle
  public boolean doesIntersect (Line line)
  {
	  Point newV1 = v1;
	  Point newV2 = v2;
	  Point newV3 = v3;
	  if(v1.getX()<=v2.getX() && v2.getX()<v3.getX())
	  {
		  newV1 = v1;
		  newV2 = v2;
		  newV3 = v3;
	  }
	  else if(v1.getX()<v3.getX() && v3.getX()<v2.getX())
	  {
		  newV1 = v1;
		  newV2 = v3;
		  newV3 = v2;
	  }
	  else if(v2.getX()<v1.getX() && v1.getX()<v3.getX())
	  {
		  newV1 = v2;
		  newV2 = v1;
		  newV3 = v3;
	  }
	  else if(v2.getX()<v3.getX() && v3.getX()<v1.getX())
	  {
		  newV1 = v2;
		  newV2 = v3;
		  newV3 = v1;
	  }
	  else if(v3.getX()<v1.getX() && v1.getX()<v2.getX())
	  {
		  newV1 = v3;
		  newV2 = v1;
		  newV3 = v2;
	  }
	  else if(v3.getX()<v2.getX() && v2.getX()<v1.getX())
	  {
		  newV1 = v3;
		  newV2 = v2;
		  newV3 = v1;
	  }
	  Line a = new Line(newV1, newV2);
	  Line b = new Line(newV2, newV3);
	  Line c = new Line(newV1, newV3);
	  Point aInt = a.intersectionPoint(line);
	  Point bInt = b.intersectionPoint(line);
	  Point cInt = c.intersectionPoint(line);
	  if(aInt.getX() >= newV1.getX() && aInt.getX() <= newV3.getX() && Math.abs(aInt.getY()) <= Math.abs(newV2.getY()))
	  {
		  return true;
	  }
	  else if(bInt.getX() >= newV1.getX() && bInt.getX() <= newV3.getX() && Math.abs(bInt.getY()) <= Math.abs(newV2.getY()))
	  {
		  return true;
	  }
	  else if(cInt.getX() >= newV1.getX() && cInt.getX() <= newV3.getX() && Math.abs(cInt.getY()) <= Math.abs(newV2.getY()))
	  {
		  return true;
	  }
	  return false;
  }
  // returns a string representation of a triangle
  // i.e. it gives the three vertices
  public String toString ()
  {
	  String j = v1.toString();
	  String k = v2.toString();
	  String l = v3.toString();
	  String result = (j + ", " + k + ", " + l);
	  return result;
  }

  // determines if two triangles are congruent, i.e. the
  // three sides of one are equal to three sides of the other
  public boolean equals (Triangle t)
  {
	  if(perimeter() == t.perimeter() && area()==t.area())
	  {
		  boolean a = v1.distance(v2) == t.getVertex1().distance(t.getVertex2());
		  boolean b = v2.distance(v3) == t.getVertex2().distance(t.getVertex3());
		  boolean c = v3.distance(v1) == t.getVertex3().distance(t.getVertex1());
		  return(a && b && c);
	  }
	  return false;
  }

}

//the main class

public class Geometry
{
  public static void main(String[] args) throws IOException
  {
    // make objects
    double pX=0.0;
    double pY=0.0;
    double qX=0.0;
    double qY=0.0;
    double aX=0.0;
    double aY=0.0;
    double bX=0.0;
    double bY=0.0;
    double gX=0.0;
    double gY=0.0;
    double hX=0.0;
    double hY=0.0;
    double rX=0.0;
    double rY=0.0;
    double sX=0.0;
    double sY=0.0;
    double tX=0.0;
    double tY=0.0;
    double jX=0.0;
    double jY=0.0;
    double kX=0.0;
    double kY=0.0;
    double lX=0.0;
    double lY=0.0;
    
    //open the file "geometry.txt" for reading
    File inFile=new File("geometry.txt");
    
    Scanner sc=new Scanner(inFile);
    
    while(sc.hasNextDouble())
     {
       pX=sc.nextDouble();
       pY=sc.nextDouble();
       sc.nextLine();
       qX=sc.nextDouble();
       qY=sc.nextDouble();
       sc.nextLine();
       aX=sc.nextDouble();
       aY=sc.nextDouble();
       sc.nextLine();
       bX=sc.nextDouble();
       bY=sc.nextDouble();
       sc.nextLine();
       gX=sc.nextDouble();
       gY=sc.nextDouble();
       sc.nextLine();
       hX=sc.nextDouble();
       hY=sc.nextDouble();
       sc.nextLine();
       rX=sc.nextDouble();
       rY=sc.nextDouble();
       sX=sc.nextDouble();
       sY=sc.nextDouble();
       tX=sc.nextDouble();
       tY=sc.nextDouble();
       sc.nextLine();
       jX=sc.nextDouble();
       jY=sc.nextDouble();
       kX=sc.nextDouble();
       kY=sc.nextDouble();
       lX=sc.nextDouble();
       lY=sc.nextDouble();
     }
     sc.close();
     Point p=new Point(pX,pY);
     Point q=new Point(qX,qY);
     Line pq = new Line(p, q);
     Point a = new Point(aX, aY);
     Point b = new Point(bX, bY);
     Line ab = new Line(a, b);
     Point g = new Point(gX, gY);
     Point h = new Point(hX, hY);
     Point r = new Point(rX, rY);
     Point s = new Point(sX, sY);
     Point t = new Point(tX, tY);
     Triangle rst = new Triangle(r, s, t);
     Point j = new Point(jX, jY);
     Point k = new Point(kX, kY);
     Point l = new Point(lX, lY);
     Triangle jkl = new Triangle(j, k, l);
     
     System.out.println("Coordinates of P: " + p);
     System.out.println("Coordinates of Q: " + q);
     System.out.println("Distance between P and Q: " + p.distance(q));
     System.out.println("Slope and Intercept of PQ: " + pq.toString());
     System.out.println("Coordinates of A: " + a);
     System.out.println("Coordinates of B: " + b);
     System.out.println("Slope and Intercept of AB: " + ab.toString());
     if(pq.isParallel(ab))
     {
    	 System.out.println("PQ is parallel to AB");
     }
     else
     {
    	 System.out.println("PQ is not parallel to AB");
     }
     if(pq.isPerpendicular(ab))
     {
    	 System.out.println("PQ is perpendicular to AB");
     }
     else
     {
    	 System.out.println("PQ is not perpendicular to AB");
     }
     if(!pq.isParallel(ab))
     {
    	 System.out.println("Coordinates of intersection point of PQ and AB: " + pq.intersectionPoint(ab).toString());
     }
     else
     {
    	 System.out.println("PQ and AB are parallel");
     }
     System.out.println("Coordinates of G: " + g);
     System.out.println("Coordinates of H: " + h);
     if(pq.onSameSide(g, h))
     {
    	 System.out.println("G and H are on the same side of PQ");
     }
     else
     {
    	 System.out.println("G and H are not on the same side of PQ");
     }
     if(ab.onSameSide(g, h))
     {
    	 System.out.println("G and H are on the same side of AB");
     }
     else
     {
    	 System.out.println("G and H are not on the same side of AB");
     }
     System.out.println("Vertices of triangle RST: " + r + ", " + s + ", " + t);
     //Check if rst is a triangle
     if(!rst.isTriangle(r, s, t))
     {
    	 System.out.println("RST is not a triangle");
    	 System.exit(0);
     }
     
    System.out.println("Perimeter of triangle RST: " + rst.perimeter());
    System.out.println("Area of triangle RST: " + rst.area());
     
     if(rst.doesIntersect(pq))
     {
    	 System.out.println("PQ does pass through triangle RST");
     }
     else
     {
    	 System.out.println("PQ does not pass through triangle RST");
     }
     if(rst.doesIntersect(ab))
     {
    	 System.out.println("AB does pass through triangle RST");
     }
     else
     {
    	 System.out.println("AB does not pass through triangle RST");
     }
     System.out.println("Vertices of triangle JKL: " + jkl.toString());
     if(!jkl.isTriangle(j, k, l))
     {
    	 System.out.println("JKL is not a triangle");
    	 System.exit(0);
     }
     if(rst.isInside(jkl))
     {
    	 System.out.println("Triangle JKL is inside triangle RST");
     }
     else
     {
    	 System.out.println("Triangle JKL is not inside triangle RST");
     }
     
     if(rst.doesOverlap(jkl))
     {
    	 System.out.println("Triangle JKL does overlap triangle RST");
     }
     else
     {
    	 System.out.println("Triangle JKL does not overlap triangle RST");
     }
     if(jkl.equals(rst))
     {
    	 System.out.println("Triangle JKL is congruent to triangle RST");
     }
     else
     {
    	 System.out.println("Triangle JKL is not congruent to triangle RST");
     }
     
  }
}
