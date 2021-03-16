import java.lang.Math;
abstract class TwoDimensionalShape {
	private Color col;
	
    public TwoDimensionalShape() {
    }
    abstract Color getcolor();
    abstract boolean setcolor(Color colour);
    abstract double calculateArea();
    abstract int calculatePerimeterLength();

}