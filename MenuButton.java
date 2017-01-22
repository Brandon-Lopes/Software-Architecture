package go.java;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuButton extends JButton implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int IAlevel; //0 = hasard, 1 = facile, 2 = moyen, 3 = difficile, -1 = VS IA, -2 = VS Human
	public static int mouse = 0;
	public static MenuButton button;
	public static String nameimg;
	protected Image img; 
	protected String imgname;
	public static int loaded = 0;
	
	public void loadImage (String imgName) //Charge l'image
	{
		try 
		{
			img = ImageIO.read(new File(imgName));
		} 
		catch (IOException e) //Image introuvable
		{
			e.printStackTrace();
		}
		repaint();
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
	
	public void loadFile() //Fonction de chargement
	{
		JFileChooser fileChooser = new JFileChooser();
		
		fileChooser.setDialogTitle("Choisissez la partie à charger");
		Main.filtre.addFiltre(fileChooser); //On définit les formats autorisés
		fileChooser.setAcceptAllFileFilterUsed(false); //On empêche la sélection de "tous les formats"
		int userSelection = fileChooser.showOpenDialog(null); //Affiche une nouvelle fenêtre permettant de choisir le fichier à charger
		
		
		    
		
	}

	public String getImgname ()
	{
		return imgname;
	}
	
	public void paintComponent(Graphics g)
	{
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public MenuButton (String name, String imag, int p_IAlevel)
	{
		this.setBorderPainted(false);
		this.setContentAreaFilled(false); //Efface l'intérieur du bouton
		this.setText(name);
		IAlevel = p_IAlevel;
		loadImage(imag);
		imgname = imag;
		this.addMouseListener(this); //Permet de détecter les actions de la souris sur le bouton
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (IAlevel == 0) Main.IAlevel = 0;
		else if (IAlevel == 1) Main.IAlevel = 1;
		else if (IAlevel == 2) Main.IAlevel = 2;
		else if (IAlevel == 3) Main.IAlevel = 3;
		else if (IAlevel == -1) Main.mode = 1;
		else if (IAlevel == -2) Main.mode = 2;
		else if (IAlevel == 4) loaded = 1;
		Bouton.setClicked(true);
		//if (IAlevel == -3) Bouton.setClicked(false);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		if (IAlevel != -3) 
		{
			mouse = 1;
			button = this;
			nameimg = imgname;
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouse = 0;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
