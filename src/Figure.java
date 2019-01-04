
import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Figure implements Comparable<Figure> {

	protected Couleur color;

	protected abstract String getType();

	/**
	 * affiche l'objet de façon lisible
	 */
	public void affiche() {
		System.out.println(this.toString());
	}

	public abstract Collection<Point> getPoint();

	public abstract boolean Couvre(Point p);

	public double distanceOrigine() {
		Collection<Point> points = this.getPoint();
		List<Double> d = new ArrayList<>();
		for (Point p : points) {
			d.add(p.distanceOrigine());
		}
		return Collections.min(d);
	}

	@Override
	public int compareTo(Figure o) {
		if (this.distanceOrigine() > o.distanceOrigine()) {
			return 1;
		} else if (this.distanceOrigine() < o.distanceOrigine()) {
			return -1;
		}
		return 0;
	}

	public Couleur getCouleur() {
		return this.color;
	}

}
