
public class test {
	public static void main(String[] args) {
		int countTri = 0, countCir = 0, countRec = 0;
		TwoDimensionalShape[] arr = new TwoDimensionalShape[100];
		for(int i = 0; i < 100; i++) {
			switch ((int)(Math.random() * 3)){
				case 0: 
					arr[i] = new Triangle((int)(Math.random() * 12),(int)(Math.random() * 12),(int)(Math.random() * 12));
					countTri++;
					break;
				case 1:
					arr[i] = new Circle((int)(Math.random() * 9));
					countCir++;
					break;
				case 2:
					arr[i] = new Rectangle((int)(Math.random() * 12),(int)(Math.random() * 12));
					countRec++;
					break;
			}
			System.out.println(arr[i].toString());
		}
		System.out.println("————End————");
		System.out.println("Triangle : " + Triangle.count + "; Circle : " + countCir + "; Rectangle : " + countRec + ";");
	}
}
