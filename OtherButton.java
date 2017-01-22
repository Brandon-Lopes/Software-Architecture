package go.java;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class OtherButton extends JButton implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int properties; //0 = passer, 1 = sauvegarder une partie, 2 = charger une partie, 3 = quitter la partie
	public static int pass = 0;
	
	public static int getPassedTurn () //Renvoie "pass"
	{
		return pass; 
	}
	
	public static void setPassedTurn (int p_pass) //Permet de réinitailiser la valeur de "pass"
	{ 
		pass = p_pass; 
	} 
	
	
	public OtherButton (String name, int p_properties)
	{
		this.setText(name);
		properties = p_properties;
		this.addMouseListener(this); //Permet de détecter les actions de la souris sur le bouton
	}
	
	public File getSelectedFileWithExtension(JFileChooser fileChooser) //Ajoute l'extension du filtre sélectionné si l'utilisateur ne l'a pas spécifié
	{
	    File file = fileChooser.getSelectedFile();
	    if (fileChooser.getFileFilter() instanceof FileNameExtensionFilter) //Vérifie que le fileChooser possède au moins un filtre
	    {
	        String[] exts = ((FileNameExtensionFilter) fileChooser.getFileFilter()).getExtensions();
	        String nameLower = file.getName().toLowerCase();
	        for (String ext : exts) //Vérifie s'il possède déjà une extension valide
	        { 
	            if (nameLower.endsWith('.' + ext.toLowerCase())) 
	            {
	                return file; //On renvoie le fichier tel quel
	            }
	        }
	        //Sinon on lui ajoute l'extension sélectionnée
	        file = new File(file.toString() + '.' + exts[0]);
	    }
	    return file;
	}
	
	public void saveFile() //Fonction de sauvegarde
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choisissez l'emplacement de sauvegarde");
		Main.filtre.addFiltre(fileChooser); //On définit les formats de sauvegardes autorisés
		fileChooser.setAcceptAllFileFilterUsed(false); //On empêche la sélection de "tous les formats" 
		int userSelection = fileChooser.showSaveDialog(null); //Affiche une nouvelle fenêtre permettant de choisir l'emplacement ainsi que le nom de la sauvegarde
		 
		
	}
	
	public void loadFile() //Fonction de chargement
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choisissez la partie à charger");
		Main.filtre.addFiltre(fileChooser); //On définit les formats autorisés
		fileChooser.setAcceptAllFileFilterUsed(false); //On empêche la sélection de "tous les formats"
		int userSelection = fileChooser.showOpenDialog(null); //Affiche une nouvelle fenêtre permettant de choisir le fichier à charger
		
		if (userSelection == JFileChooser.APPROVE_OPTION) //L'utilisateur à cliqué sur ouvrir
		{
		    File fileToLoad = getSelectedFileWithExtension(fileChooser); //On récupère le nom du fichier
		    System.out.println("Loaded file: " + fileToLoad.getName());
		    
			try 
			{
				BufferedReader br = new BufferedReader (new FileReader (fileToLoad)); //On utilise un buffer pour lire dans le fichier
				String info;
				char couleur, turn;
	    		int x, y;
		    	for (x = 0; x < Main.taille; x++)
		    	{
		    		info = br.readLine(); //Récupère une ligne
		    		for (y = 0; y < Main.taille; y++) //Parcourt la ligne caractère par caractère et met à jour le plateau
		    		{
		    			couleur = info.charAt (y);
		    		//	if (couleur == ' ') Main.goban[x][y].setcouleur(0);
		    			/*else if (couleur == 'N') Main.runastep(-1, x, y, 0, Main.goban, Main.chaine, Main.almanac2, Main.chainefutur, OtherButton.pass);
		    			else Main.runastep(1, x, y, 0, Main.goban, Main.chaine, Main.almanac2, Main.chainefutur, OtherButton.pass);
		    			Main.arrayBouton[x][y].fillButton();*/
		    		}
		    	}
		    	info = br.readLine(); //Dernière ligne
		    	turn = info.charAt(0); //Récupère le tour du jour
		    /*	if (turn == 'N') Main.setPlayerTurn(-1); //Met à jour le tour du joueur 
		    	else Main.setPlayerTurn(1); //Met à jour le tour du joueur*/
		    	br.close(); //ferme le buffer et libère donc l'accès au fichier
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}			    	
		}
	}

	public void mouseClicked(MouseEvent event) 
	{
		if (properties == 0) 
		{	
			if (pass == 0)
			{	
				//if (Main.getPlayerTurn() == -1) Main.setPlayerTurn (1);
				//else Main.setPlayerTurn (-1);
				OtherButton.setPassedTurn (1);
			}
			else
			{
				pass++;
			//	FDP result = new FDP (Main.goban);
				/**result.resultat(Main.goban);
				System.out.println(result.resultat);
				if (result.resultat == 1) Main.victoire.loadImage ("Victoire blanc.png");
				else if (result.resultat == 0) Main.victoire.loadImage ("Draw.png");**/
				Main.victoire.setEnabled(false);
				Main.victoire.setVisible(true);
			}
			
		}
		else if (properties == 1) saveFile();
		else if (properties == 2) loadFile();
		Bouton.setClicked(true);
	}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
}
