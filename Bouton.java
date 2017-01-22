package go.java;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import javax.imageio.*;

import java.awt.*;


public class Bouton extends JButton implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int posX, posY, fill = 0;
	protected Image img;
	protected static boolean clicked = false;
	
	public Bouton (int pposX, int pposY, Border border, boolean areaFilled) //Constructeur 
	{
		setButton (pposX, pposY); //Définit les attributs du bouton
		//loadImage ("transparent.png");
		setBorder(border); //Efface les bords du bouton
       	setContentAreaFilled(areaFilled); //Efface l'intérieur du bouton
		//this.addMouseListener(this); //Permet de détecter les actions de la souris sur le bouton
		this.setPreferredSize(new Dimension(46, 46));
		this.setMinimumSize(new Dimension(46 ,46));
	}
	
	public void setButton (int pposX, int pposY) //Définit les attributs du bouton
	{
		posX = pposX;
		posY = pposY;
	}
	
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
	}
	
	public void paintComponent(Graphics g)
	{
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	


	public static void setClicked (boolean statut)
	{
		clicked = statut;
	}
	
	public static boolean getClicked()
	{
		return clicked;
	}

		
	
	

	
	//Le joueur a cliqué sur le bouton
	/*public void mouseClicked(MouseEvent event) //On place le pion
	{
		if (fill != 1) //Empêche de remplacer un pion déjà présent sur le terrain
		{
			int playerTurn = Main.getPlayerTurn();
			if (Main.runastep(playerTurn, this.posX, this.posY, 0, Main.goban, Main.chaine, Main.almanac2, Main.chainefutur, OtherButton.pass) == true)
			{				
				if(playerTurn == -1) //Tour du noir
				{
					Main.setPlayerTurn(1); //Donne la main au joueur blanc
					//loadImage ("pion noir.png");
				}
				else  //Tour du blanc
				{
					Main.setPlayerTurn(-1); //Donne la main au joueur noir
					//loadImage ("pion blanc.png");
				}
				OtherButton.setPassedTurn (0); //On peut à nouveau passer un tour sans mettre
				//Main.runAstep(playerTurn, 0, Main.goban, this.posX, this.posY);
				fill = 1; //Signal que la case est dorénavant occupée
				Main.lastAdv = new Pion (playerTurn, this.posX, this.posY);
				//setVisible(true); //Affiche le nouveau contenu
				//repaint(); //réaffiche correctement le bouton
				Main.affichergb(Main.goban, Main.taille);
				setClicked(true);
				Main.updatePlat(Main.arrayBouton, Main.taille);
			}
		}
	}*/
		
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}