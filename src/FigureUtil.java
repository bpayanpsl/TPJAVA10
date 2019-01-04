
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FigureUtil {

	public static Map<String, Figure> map1 = new HashMap<String, Figure>();
	static int cptFig = 0;
	private static final int LIMITE_X = 50;
	private static final int LIMITE_Y = 50;

	public static Point getRandomPoint() {
		return new Point(ThreadLocalRandom.current().nextInt(1, 99), ThreadLocalRandom.current().nextInt(1, 99));
	}

	public static Rond getRandomRond() {
		Rond rond = new Rond(getRandomPoint(), ThreadLocalRandom.current().nextInt(1, 99), Couleur.getRandom());
		map1.put(String.valueOf(cptFig), rond);
		cptFig++;
		return rond;
	}

	public static Rectangle getRandomRectangle() {
		Rectangle rectangle = new Rectangle(getRandomPoint(), ThreadLocalRandom.current().nextInt(1, 99),
				ThreadLocalRandom.current().nextInt(1, 99), Couleur.getRandom());
		map1.put(String.valueOf(cptFig), rectangle);
		cptFig++;
		return rectangle;
	}

	public static Carre getRandomCarre() {
		Carre carre = new Carre(getRandomPoint(), ThreadLocalRandom.current().nextInt(1, 99), Couleur.getRandom());
		map1.put(String.valueOf(cptFig), carre);
		cptFig++;
		return carre;
	}

	private static Figure getRandomSegment() {
		Segment segment = new Segment(getRandomPoint(), ThreadLocalRandom.current().nextInt(1, 99),
				ThreadLocalRandom.current().nextInt(1, 99) % 2 == 0 ? true : false, Couleur.getRandom());
		map1.put(String.valueOf(cptFig), segment);
		cptFig++;
		return segment;
	}

	public static Figure getRandomFigure() {
		int rdm = ThreadLocalRandom.current().nextInt(0, 4);
		switch (rdm) {
		case 1:
			return getRandomRectangle();
		case 2:
			return getRandomRond();
		case 0:
			return getRandomSegment();
		case 3:
		default:
			return getRandomCarre();
		}
	}

	public static Surfacable getRandomSurfacable() {
		int rdm = ThreadLocalRandom.current().nextInt(0, 3);
		switch (rdm) {
		case 1:
			return getRandomRectangle();
		case 2:
			return getRandomRond();
		case 0:
		default:
			return getRandomCarre();
		}
	}

	public static Collection<Point> getPoint(Figure... f) {		
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < f.length; i++) {
			points.addAll(f[i].getPoint());
		}
		return points;
	}

	public static Collection<Figure> genere(int i) {
		List<Figure> figure = new ArrayList<Figure>();
		for (int cpt = 0; cpt < i; cpt++) {
			figure.add(getRandomFigure());
		}
		return figure;
	}

	public static Figure getFigureEn(Point p1, Dessin d1) {
		
		return d1.getFigures().stream().filter(f-> f.Couvre(p1)).findFirst().orElse(null);
//		
//		for (Figure fig : d1.getFigures()) {
//			if (fig.Couvre(p1)) {
//				return fig;
//			}
//		}
//		return null;
	}

	public static Collection<Figure> trieOrigine(Dessin dessin) {
		
		return dessin.getFigures().stream().sorted().collect(Collectors.toList());
//		ArrayList<Figure> trie = new ArrayList<>(dessin.getFigures());
//		Collections.sort(trie);
//		return trie;
	}

	public static Collection<Figure> trieSurface(Dessin dessin) {
		
		return dessin.getFigures().stream().filter(f -> f instanceof Surfacable).sorted((o1,o2)->{
			Surfacable s1 = (Surfacable) o1;
			Surfacable s2 = (Surfacable) o2;
			if (s1.surface() > s2.surface()) {
				return 1;
			} else if (s1.surface() < s2.surface()) {
				return -1;
			}
			return 0;
		}).collect(Collectors.toList());
		
		
//		List<Figure> figures = new ArrayList<>(dessin.getFigures());
//		List<Figure> surfacable = new ArrayList<>();
//		for (Figure f : figures) {
//			if (f instanceof Surfacable) {
//				surfacable.add(f);
//			}
//		}
//		Collections.sort(surfacable, new Comparator<Figure>() {
//
//			@Override
//			public int compare(Figure o1, Figure o2) {
//				Surfacable s1 = (Surfacable) o1;
//				Surfacable s2 = (Surfacable) o2;
//				if (s1.surface() > s2.surface()) {
//					return 1;
//				} else if (s1.surface() < s2.surface()) {
//					return -1;
//				}
//				return 0;
//			}
//		});
//		return surfacable;

	}

	public static void clearMap() {
		map1.clear();
	}

	public static void imprime() throws ImpressionHorsLimiteException {
		for (Entry<String, Figure> entry : map1.entrySet()) {
			for (Point point : entry.getValue().getPoint()) {
				if (point.getX() < 0 || point.getX() > 200 || point.getY() < 0 || point.getY() > 200) {
					throw new ImpressionHorsLimiteException("figure hors limite : " + entry.getKey());
				}
			}
		}
	}

	public static void imprime(Dessin d) throws IOException, ImpressionHorsLimiteException {

		List<Figure> figuresAImprimer = new ArrayList<>();
		for (Figure entry : d.getFigures()) {
			boolean horsLimite = false;
			for (Point point : entry.getPoint()) {
				if (point.getX() < 0 || point.getX() > LIMITE_X || point.getY() < 0 || point.getY() > LIMITE_Y) {
					horsLimite = true;
				}
			}
			if (!horsLimite) {
				figuresAImprimer.add(entry);
			}
		}
		FileOutputStream file = new FileOutputStream("dessin.dat");
		PrintWriter sortie = new PrintWriter(new FileWriter("dessin.dat"));

		System.out.println("dessin fichier : " + figuresAImprimer.size() + "figures");
		for (Figure f : figuresAImprimer) {
			sortie.println(f.toString());
		}
		sortie.println("=================================================================================");

		char tab[][] = new char[LIMITE_X + 1][LIMITE_Y + 1];
		for (int y = 0; y < LIMITE_Y + 1; y++) {
			for (int x = 0; x < LIMITE_X + 1; x++) {
				tab[x][y] = ' ';
			}
		}

		for (Figure f : figuresAImprimer) {
			for (Point point : f.getPoint()) {
				tab[point.getX()][point.getY()] = f.getCouleur().abreviation();
			}
		}

		StringBuilder str = new StringBuilder();
		for (int y = LIMITE_Y; y > 0; y--) {
			for (int x = 0; x < LIMITE_X; x++) {

				str.append(tab[x][y]);
			}
			sortie.println(str.toString());
			str = new StringBuilder();
		}

		sortie.close();
	}
}
