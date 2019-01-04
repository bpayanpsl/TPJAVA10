import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Segment extends Figure {

	private Point x;
	private Point y;

	/**
	 * @param debut point d'origine, bas gauche
	 * @param longueur longueur du segment
	 * @param horizontal true si horizotal, false si vertical
	 */
	public Segment(Point debut, int longueur, boolean horizontal) {
		x = debut;
		if (horizontal) {
			y = new Point(x.getX() + longueur, x.getY());
		} else {
			y = new Point(x.getX(), x.getY() + longueur);
		}
		color = Couleur.getCouleurDefaut();
	}

	public Segment(Point debut, int longueur, boolean horizontal, Couleur c) {
		this(debut, longueur, horizontal);
		color = c;
	}

	@Override
	public boolean Couvre(Point p) {
		return p.getX() >= x.getX() && p.getX() <= y.getX() && p.getY() >= x.getY() && p.getY() <= y.getY();
	}
	
	public String print() {
		return "Segment " + getCouleur() + " [debut=" + x + ", fin=" + y + "]";
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return "SEGMENT";
	}

	@Override
	public Collection<Point> getPoint() {
		List<Point> points = new ArrayList<>();

		points.add(x);
		points.add(y);

		return points;
	}

	@Override
	public String toString() {
		return "Segment [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Segment other = (Segment) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
}
