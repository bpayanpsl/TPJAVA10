import java.util.Collection;
import java.util.ArrayList;

public class Dessin {
	
	Collection<Figure> listeF;
	
	public Dessin() {
		this.listeF = new ArrayList<Figure>();		
	}
	
	public boolean addFigure(Figure f) {
		return this.listeF.add(f);
	}
	
	public Collection<Figure> getFigures() {
		return this.listeF;
	}
}
