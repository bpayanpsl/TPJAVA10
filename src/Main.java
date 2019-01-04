import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Long> number = new ArrayList<>();
		number.add(1L);
		number.add(14L);
		number.add(null);
		number.add(4L);
		number.add(1L);
		number.add(null);
		number.add(null);
		number.add(null);
		number.add(11L);
		number.add(122L);
		number.add(1L);
		number.add(45L);
		number.add(12L);
		number.add(751L);
		number.add(10L);
		number.add(2L);
		number.add(1L);
		System.out.println(number.stream().filter(i -> i != null).map(i -> i.toString()).reduce((n, i) -> n + ", " + i)
				.orElse("vide"));
		System.out.println(number.stream().filter(i -> i != null).collect(Collectors.toList()));

		System.out.println(number.stream().filter(i -> i != null).reduce((n, i) -> n * i).orElse(10L));

		Long res = 0L;
		boolean oneElementPresenet = false;
		for (Long i : number) {
			if (i != null) {
				if (res != 0) {
					res *= i;
				} else {
					res = i;
				}
				oneElementPresenet = true;
			}
		}
		if (oneElementPresenet) {
			System.out.println(res);
		} else {
			System.out.println(10);
		}	
		
//		System.out.println("==========================");
//		
//		//Heure actuelle
//		LocalTime time = LocalTime .now();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
//		String n = time.format(dtf);
//		System.out.println(n);
//		
//		//Date actuelle
//		LocalDate date = LocalDate.now();
//		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//		String n1 = date.format(dtf1);
//		System.out.println(n1);
//		
//		//Définir une date au 25/12/2018
//		LocalDate date1 = LocalDate.of(2018, 12, 25);
//		System.out.println(date1);
//		
//		//Définir une date ET une heure au 12/12/2018 00:00
//		LocalDateTime dateTime = LocalDateTime.of(2018, 12, 25, 00, 00);
//		System.out.println(dateTime);	
//		
//		//Définir et parser une date Et heure au 12/12/2018 23:59:59
//		LocalDateTime ldTime = LocalDateTime.parse("23:59:59 2018-12-12",  DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd"));
//		System.out.println(ldTime);
//			
//		System.out.println("==========================");
//		
//		// Creation d'un nouveau point p
//		Point p = new Point(3, 5);
//		Point p1 = new Point();
//		// Point p2 = new Point(100,102);
//
//		/*
//		 * System.out.println(p.getX()); System.out.println(p.getY());
//		 * 
//		 * System.out.println(p1.getX()); System.out.println(p1.getY());
//		 */
//
//		// Creation d'un nouveau rond r
//		Rond r = new Rond(p, 4);
//
//		System.out.println(r.toString());
//
//		// Creation d'un rectangle rec
//		Rectangle rec = new Rectangle(p, 2, 3);
//
//		System.out.println(rec.toString());
//
//		// Rond aléatoire
//		Rond rr = FigureUtil.getRandomRond();
//		rr.affiche();
//
//		// Rectangle aléatoire
//		// Rectangle rere = FigureUtil.getRandomRectangle();
//		// rere.affiche();
//
//		// Creation d'un carré
//		Carre c = new Carre(p, 5);
//		c.affiche();
//
//		System.out.println(p.equals(p1));
//
//		FigureUtil.getRandomFigure().affiche();
//
////		while (true) {
////			Surfacable s = FigureUtil.getRandomSurfacable();
////			System.out.println(s.getClass() + " " + s.surface());
////		}
//
//		Figure[] fig = new Figure[1];
//
//		for (int i = 0; i < 1; i++) {
//			fig[i] = FigureUtil.getRandomFigure();
//			System.out.println(fig[i].getType());
//		}
//
//		System.out.println(FigureUtil.getPoint(fig));
//
//		Dessin d = new Dessin();
//		List<Figure> lf = new ArrayList<>();
//		lf.addAll(FigureUtil.genere(3));
//
//		for (Figure fig1 : lf) {
//			d.addFigure(fig1);
//		}
//		
//		System.out.println("==========================");
//		System.out.println(d.getFigures());
//		System.out.println("==========================");
//		
//		//Affichage contenu de la liste de Figure lf avec un stream
//		lf.stream().sorted().forEach(System.out::println);
//		System.out.println("==========================");
//		
//
//		for (Figure figg : FigureUtil.trieOrigine(d)) {
//			System.out.println("distance orrigine : " + figg.distanceOrigine());
//		}
//
//		for (Figure figg : FigureUtil.trieSurface(d)) {
//			System.out.println("surface : " + ((Surfacable) figg).surface());
//		}
//
//		FigureUtil.clearMap();
//		FigureUtil.genere(500);
//		try {
//			FigureUtil.imprime();
//		} catch (ImpressionHorsLimiteException e) {
//			System.out.println("erreur : " + e.getMessage());
//			e.printStackTrace();
//		}
//
//		FigureUtil.clearMap();
//		d = new Dessin();
//		for (Figure fig1 : FigureUtil.genere(500)) {
//			d.addFigure(fig1);
//		}
//		try {
//			FigureUtil.imprime(d);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ImpressionHorsLimiteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
