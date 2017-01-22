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
	
	public static void setPassedTurn (int p_pass) //Permet de r�initailiser la valeur de "pass"
	{ 
		pass = p_pass; 
	} 
	
	
	public OtherButton (String name, int p_properties)
	{
		this.setText(name);
		properties = p_properties;
		this.addMouseListener(this); //Permet de d�tecter les actions de la souris sur le bouton
	}
	
	public File getSelectedFileWithExtension(JFileChooser fileChooser) //Ajoute l'extension du filtre s�lectionn� si l'utilisateur ne l'a pas sp�cifi�
	{
	    File file = fileChooser.getSelectedFile();
	    if (fileChooser.getFileFilter() instanceof FileNameExtensionFilter) //V�rifie que le fileChooser poss�de au moins un filtre
	    {
	        String[] exts = ((FileNameExtensionFilter) fileChooser.getFileFilter()).getExtensions();
	        String nameLower = file.getName().toLowerCase();
	        for (String ext : exts) //V�rifie s'il poss�de d�j� une extension valide
	        { 
	            if (nameLower.endsWith('.' + ext.toLowerCase())) 
	            {
	                return file; //On renvoie le fichier tel quel
	            }
	        }
	        //Sinon on lui ajoute l'extension s�lectionn�e
	        file = new File(file.toString() + '.' + exts[0]);
	    }
	    return file;
	}
	
	public void saveFile() //Fonction de sauvegarde
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choisissez l'emplacement de sauvegarde");
		Main.filtre.addFiltre(fileChooser); //On d�finit les formats de sauvegardes autoris�s
		fileChooser.setAcceptAllFileFilterUsed(false); //On emp�che la s�lection de "tous les formats" 
		int userSelection = fileChooser.showSaveDialog(null); //Affiche une nouvelle fen�tre permettant de choisir l'emplacement ainsi que le nom de la sauvegarde
		 
		
	}
	
	public void loadFile() //Fonction de chargement
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choisissez la partie � charger");
		Main.filtre.addFiltre(fileChooser); //On d�finit les formats autoris�s
		fileChooser.setAcceptAllFileFilterUsed(false); //On emp�che la s�lection de "tous les formats"
		int userSelection = fileChooser.showOpenDialog(null); //Affiche une nouvelle fen�tre permettant de choisir le fichier � charger
		
		if (userSelection == JFileChooser.APPROVE_OPTION) //L'utilisateur � cliqu� sur ouvrir
		{
		    File fileToLoad = getSelectedFileWithExtension(fileChooser); //On r�cup�re le nom du fichier
		    System.out.println("Loaded file: " + fileToLoad.getName());
		    
			try 
			{
				BufferedReader br = new BufferedReader (new FileReader (fileToLoad)); //On utilise un buffer pour lire dans le fichier
				String info;
				char couleur, turn;
	    		int x, y;
		    	for (x = 0; x < Main.taille; x++)
		    	{
		    		info = br.readLine(); //R�cup�re une ligne
		    		for (y = 0; y < Main.taille; y++) //Parcourt la ligne caract�re par caract�re et met � jour le plateau
		    		{
		    			couleur = info.charAt (y);
		    		//	if (couleur == ' ') Main.goban[x][y].setcouleur(0);
		    			/*else if (couleur == 'N') Main.runastep(-1, x, y, 0, Main.goban, Main.chaine, Main.almanac2, Main.chainefutur, OtherButton.pass);
		    			else Main.runastep(1, x, y, 0, Main.goban, Main.chaine, Main.almanac2, Main.chainefutur, OtherButton.pass);
		    			Main.arrayBouton[x][y].fillButton();*/
		    		}
		    	}
		    	info = br.readLine(); //Derni�re ligne
		    	turn = info.charAt(0); //R�cup�re le tour du jour
		    /*	if (turn == 'N') Main.setPlayerTurn(-1); //Met � jour le tour du joueur 
		    	else Main.setPlayerTurn(1); //Met � jour le tour du joueur*/
		    	br.close(); //ferme le buffer et lib�re donc l'acc�s au fichier
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
