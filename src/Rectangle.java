import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfacable {

	private Point pointHautDroit;
	private Point pointBasDroit;
	private Point pointHautGauche;
	private Point pointBasGauche;

	public Rectangle(Point point, int w, int h) {
		pointBasGauche = point;
		pointBasDroit = new Point(point.getX() + w, point.getY());
		pointHautGauche = new Point(point.getX(), point.getY() + h);
		pointHautDroit = new Point(point.getX() + w, point.getY() + h);
		color = Couleur.getCouleurDefaut();
	}
	
	public Rectangle(Point point, int w, int h, Couleur c) {
		this(point, w, h);
		color = c;		
	}

	public Point getPointHautDroit() {
		return pointHautDroit;
	}

	public Point getPointBasDroit() {
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		return pointHautGauche;
	}

	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public void setPointHautGauche(Point pointHautGauche) {
		this.pointHautGauche = pointHautGauche;
	}

	@Override
	public String toString() {
		return getType() +  " " + color + " [pointHautDroit=" + pointHautDroit + ", pointBasDroit=" + pointBasDroit
				+ ", pointHautGauche=" + pointHautGauche + ", pointBasGauche=" + pointBasGauche + "]";
	}

	protected String getType() {
		return "RECT";
	}

	public double surface() {
		return Math.abs(pointBasDroit.getX() - pointBasGauche.getX())
				* Math.abs(pointHautDroit.getY() - pointBasDroit.getY());
	}

	@Override
	public Collection<Point> getPoint() {
		List<Point> points = new ArrayList<>();

		points.add(pointHautDroit);
		points.add(pointHautGauche);
		points.add(pointBasDroit);
		points.add(pointBasGauche);

		return points;
	}

	@Override
	public boolean Couvre(Point p) {
		return (p.getX() >= pointBasGauche.getX() && p.getX() <= pointBasDroit.getX()
				&& p.getY() >= pointBasGauche.getY() && p.getY() <= pointHautGauche.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointBasDroit == null) ? 0 : pointBasDroit.hashCode());
		result = prime * result + ((pointBasGauche == null) ? 0 : pointBasGauche.hashCode());
		result = prime * result + ((pointHautDroit == null) ? 0 : pointHautDroit.hashCode());
		result = prime * result + ((pointHautGauche == null) ? 0 : pointHautGauche.hashCode());
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
		Rectangle other = (Rectangle) obj;
		if (pointBasDroit == null) {
			if (other.pointBasDroit != null)
				return false;
		} else if (!pointBasDroit.equals(other.pointBasDroit))
			return false;
		if (pointBasGauche == null) {
			if (other.pointBasGauche != null)
				return false;
		} else if (!pointBasGauche.equals(other.pointBasGauche))
			return false;
		if (pointHautDroit == null) {
			if (other.pointHautDroit != null)
				return false;
		} else if (!pointHautDroit.equals(other.pointHautDroit))
			return false;
		if (pointHautGauche == null) {
			if (other.pointHautGauche != null)
				return false;
		} else if (!pointHautGauche.equals(other.pointHautGauche))
			return false;
		return true;
	}
}
