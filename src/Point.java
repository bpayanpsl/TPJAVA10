
public class Point {

	private int x; // Abscisse
	private int y; // Ordonnée
	private final int INIT_X = 25;
	private final int INIT_Y = 25;

	public Point() {
		x = INIT_X;
		y = INIT_Y;
	}

	// Constructeur
	public Point(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public double distance(Point p) {
		return Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
	}

	public double distanceOrigine() {
		return Math.sqrt(Math.pow(x - this.INIT_X, 2) + Math.pow(y - this.INIT_Y, 2));
	}

	// Affichage
	public void affiche() {
		System.out.println("[" + x + ";" + y + "]");
	}

	// Getter de x
	public int getX() {
		return x;
	}

	// Getter de y
	public int getY() {
		return y;
	}

	public String toString() {
		return "[" + x + ";" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
