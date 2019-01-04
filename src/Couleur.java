import java.util.concurrent.ThreadLocalRandom;

public enum Couleur {
	ROUGE('R'), VERT('V'), BLEU('B'), JAUNE('J'), NOIR('N');

	private char abrege;

	private Couleur(char c) {
		this.abrege = c;
	}

	public char abreviation() {
		return abrege;
	}

	public static Couleur getCouleurDefaut() {
		return Couleur.NOIR;
	}

	public static Couleur getRandom() {
		return values()[ThreadLocalRandom.current().nextInt(values().length)];
	}
}
