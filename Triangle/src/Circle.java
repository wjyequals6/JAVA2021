class Circle extends TwoDimensionalShape {
    int radius;
    private Color col;
    
    public Circle(int r) {
        radius = r;
    }

    double calculateArea() {
        return (int)Math.round(Math.PI * radius * radius);
    }
    
	public boolean setcolor(Color colour) {
		col = colour;
		return true;
	}
    public Color getcolor() {
    	return col;
    }
    int calculatePerimeterLength() {
        return (int)Math.round(Math.PI * radius * 2.0);
    }

    public String toString() {
        return "Circle with radius " + radius;
    }
}