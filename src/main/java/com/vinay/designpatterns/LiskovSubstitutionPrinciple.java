package com.vinay.designpatterns;

/**
 * Liskov substitution principle is you should be able to substitute a subclass for a base class
 */
public class LiskovSubstitutionPrinciple {

    static void useIt(Rectangle rc){
        int width = rc.getWidth();
        rc.setHeight(10);
//        area = width*10
        System.out.println("expected area of : "+(width*10)+" but actual area : "+rc.getArea());
    }

    public static void main(String[] args) {
        LiskovSubstitutionPrinciple liskovSubstitutionPrinciple = new LiskovSubstitutionPrinciple();
        Rectangle rc = liskovSubstitutionPrinciple.new Rectangle(2,10);
        useIt(rc);

        Rectangle sq = liskovSubstitutionPrinciple.new Square(5);
        useIt(sq);
    }

    /*
    violating LSP . One of the Solutions is not to have additional Square Class but just have isSquare method in rectangle
    to check if a rectangle is square or not
     */
class Rectangle{
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return width*height;
    }

    /*
    have this method and don't need to use Square class to prevent LSP violation
     */
    public boolean isSquare(){
        return width == height;
    }
}

class Square extends Rectangle{

    public Square(int size) {
        super(size, size);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
}
