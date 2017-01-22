package go.java;

import java.util.LinkedList;
import java.util.List;

public class Main {
	protected static int playerTurn = -1;
	protected static int taille = 50;

	protected static String[] suffixes = { "txt" };
	protected static String[] descriptions = { "Fichiers texte (.txt)" };
	public static Filtre filtre = new Filtre(suffixes, descriptions);
	public static Bouton[][] arrayBouton = new Bouton[taille][taille];
	@SuppressWarnings("rawtypes")
	public static List test;
	@SuppressWarnings("rawtypes")
	public static List chaine = new LinkedList();
	@SuppressWarnings("rawtypes")
	public static List chainefutur = new LinkedList();
	
	public static int mode = 0, IAlevel = -1;

	public static MenuButton victoire;
/*

	@SuppressWarnings("deprecation")*/
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
	//	intialiser(goban, taille);
		//intialiser(almanac2, taille);

		/*---------------------------------////////////////////---------------------------------*/
		/*---------------------------------//Partie Graphique//---------------------------------*/
		/*---------------------------------////////////////////---------------------------------*/
		//Fenetre menufond = new Fenetre(1366, 730, "Cellular divisiono", true, "menu.jpg", 0);
		//Fenetre fenetre = new Fenetre(1300, 800, "Cellular division", true, "menu.jpeg", 0);
     	Fenetre fenetre = new Fenetre(1300, 800, "Cellular division", true, "Background.png", 0);
     /* Bug du menu pas fini d'être réparé */
		/*Thread menu = new MenuThread(fenetre);
		menu.start();
		*/
		Thread playWave  =new SoundThread("song.wav");
		playWave.start();
	/*	while (menu.isAlive()) {
			System.out.print("");
		}*/
		
		
		fenetre.setBackground("Background.png");
		

		
		/*if (mode == 1) {
			//Thread principalThread = new UnThread();
			principalThread.start();
			playWave.stop();
		}*/		
	/*	else
		{
			HVHThread humanThread = new HVHThread();
			humanThread.start();
		}*/
		
	
	}
}
