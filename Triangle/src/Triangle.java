class Triangle extends TwoDimensionalShape implements MultiVariantShape{
	int a, b, c;
	private Color col;
	static int count;
	TriangleVariant triVar;
	
	public Triangle(int x, int y, int z) {
		a = x;
		b = y;
		c = z;
		if(a <= 0 || b <= 0 || c <= 0) triVar = TriangleVariant.ILLEGAL;
		else if(a + b < c || b + c < a || a + c < b) triVar = TriangleVariant.IMPOSSIBLE;
		else {
			if(a == b && b == c) triVar = TriangleVariant.EQUILATERAL;//等边
			if((a == b && a != c)|| (b == c && b!= a) || (a == c && a != b)) triVar = TriangleVariant.ISOSCELES;//等腰
			if(c != b && b != a && a != c) triVar = TriangleVariant.SCALENE;//不等边
			if(a*a + b*b == c*c || b*b + c*c == a*a || a*a + c*c == b*b) triVar = TriangleVariant.RIGHT;
			if(a + b == c || b + c == a || a + c == b) triVar = TriangleVariant.FLAT;
		}
		//System.out.println("triVar : " + triVar);
		Triangle.count++;
	}
	public TriangleVariant getVariant() {
		return triVar;
	}
	
	Color getcolor() {
    	return col;
    }
	
	public boolean setcolor(Color colour) {
		col = colour;
		return true;
	}
	
	public double calculateArea() {
		double s;
		s = (a + b + c) / 2;
	    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	public int calculatePerimeterLength() {
	    return -1;
	}
	
	public int getLongestSide() {
		int l = a;
		if (l < b) l = b;
		if (l < c) l = c;
		return l;
	}
	
	public String toString() {
		String s;
		s = Integer.toString(a) + ", "+ Integer.toString(b) + ", " + Integer.toString(c);
		return "This is a Triangle with sides of length " + s;
	}
	
	public int getPopulation() {
		return Triangle.count;
	}
	
}
