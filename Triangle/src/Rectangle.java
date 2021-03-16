class Rectangle extends TwoDimensionalShape {
    int width;
    int height;
    private Color col;
    
    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }
    public Color getcolor() {
    	return col;
    }
	public boolean setcolor(Color colour) {
		col = colour;
		return true;
	}

    double calculateArea() {
        return width * height;
    }

    int calculatePerimeterLength() {
        return 2 * (width + height);
    }

    public String toString() {
        return "Rectangle of dimensions " + width + " x " + height;
    }
}