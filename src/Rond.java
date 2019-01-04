import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable {
	
	private Point p;
	private int r;
	
	public Rond(Point point, int rayon) {
		p = point;
		r = rayon;
		color = Couleur.getCouleurDefaut();
	}
	
	public Rond(Point point, int rayon, Couleur c) {
		this(point, rayon);
		color = c;
	}
	
	protected String getType() {
		return "ROND";
	}
	
	public String toString() {
		return "["+ getType() + " " + getCouleur() + " " + p.toString() + ", " + r + "]";
	}
	
	public int getR() {
		return r;
	}
	
	public double surface() {
		return Math.PI * Math.pow(r, 2);
	}

	@Override
	public Collection<Point> getPoint() {
			List<Point> points = new ArrayList<>();
			
			points.add(p);
			
	 		return points;
	}

	@Override
	public boolean Couvre(Point p) {
		return Math.sqrt(Math.pow((p.getX() - this.p.getX()), 2)) + Math.pow((this.p.getY() - p.getY()), 2) < r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + r;
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
		Rond other = (Rond) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (r != other.r)
			return false;
		return true;
	}

	

	/*public boolean equals(Figure fig) {
		if(this.getType() != fig.getType()) {
			return false;
		}
		
		return false;	
	}*/

}
