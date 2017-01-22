package go.java;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;



public class Fenetre extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel mainLayer;
	protected MenuButton lab;
	 private JLabel statusbar;
	private int heatvalue = 0;
	private static int nutrientsvalue = 0;
	private static  int salinityvalue = 0;
	
	public Fenetre(int plargeur, int phauteur, String ptitre, boolean resizable, String background, int layer) //Constructeur avec image de fond
	{ 
		
        mainLayer = new JPanel(); //Créer le panel principal qui va accueillir les autres composants
        LayoutManager overlay = new OverlayLayout(mainLayer); //overlay permet de superposer les différents éléments
        mainLayer.setLayout (overlay);
        createMenuBar();

       GraphicsDevice device;
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
     
        //Est ce que le mode plein ecran est disponible 
        
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(this);
        } else {
            System.err.println("Le mode plein ecran n'est pas disponible");
        }
        
        lab = addMenuButton("Menu", background, -3, 0, 0, this.getWidth(), this.getHeight(), layer);
        
        
        
        this.add(mainLayer, BorderLayout.CENTER); //On ajoute le panel dans le panel principal
        
        this.setTitle(ptitre); //Définit un titre pour notre fenêtre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Termine le processus lorsqu'on clique sur la croix rouge
        
	    this.setLocationRelativeTo(null); //Positionne la fenêtre au centre de l'écran
        
	    this.setVisible(true); //Rend la fenêtre visible
	   
      /*  EventQueue.invokeLater(() -> {
            RadioMenuItem ex = new RadioMenuItem();
            ex.setVisible(true);
        });*/
        this.setResizable(resizable); //Définit si la fenêtre est redimensionable
        this.setMinimumSize(new Dimension(1300, 800));
	}
	
	public void addImage (String imgName, int layer) //Ajoute une image au pannel de la fenêtre
	{

        
        JPanel pan = new JPanel(); //Créer un nouveau panel
		JLabel lab = new JLabel(); //Créer un nouveau label
		
		pan.setLayout(new GridBagLayout()); //Définit le layout du panel 
		GridBagConstraints gbc = new GridBagConstraints(); //Propiétés du GridBagLayout
		gbc.gridx = gbc.gridy = GridBagConstraints.REMAINDER; //Signifie que le composant est le dernier de la ligne et de la colone
		gbc.anchor = GridBagConstraints.CENTER; //Ancre le composant au centre de sa case
		
		lab.setIcon(new ImageIcon(imgName)); //Charge l'image dans le label
		pan.add(lab); //Ajoute le label au panel
		pan.setOpaque(false); //Définit le panel comme non opaque
        mainLayer.add(pan, layer); //Ajoute le panel au panel principale à la profondeur définit par le layer
        this.setVisible(true); //Affiche la fenêtre
	}
	
	public void addSeveralButton (int nbBouton, int layer) //Ajoute plusieurs boutons
	{		
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets (15,15,15,15); //Définit les marges: En haut, à gauche, en bas, à droite
		gbc.anchor = GridBagConstraints.CENTER; //Ancre les composants au centre de leur case
		
		int x, y;
		for (x = 0; x < nbBouton; x++)
		{
			for (y = 0; y < nbBouton; y++)
			{
				gbc.gridx = y; //Ligne
				gbc.gridy = x; //Colone
				Bouton b = new Bouton(x, y, null, false); //Créer un nouveau bouton
				Main.arrayBouton [x][y] = b;
				pan.add(b, gbc); //Place le bouton dans le panel
			}
		}		
		pan.setOpaque(false); //Rend le panel non opaque
		mainLayer.add(pan, layer); //Ajoute le panel au panel principal
		this.setVisible(true); //Affiche le nouveau contenu
	}
	
	public OtherButton addButton (String name, int properties, int topPad, int bottomPad, int leftPad, int rightPad, int width, int height, int layer) //Ajoute un bouton
	{
		JPanel buttonPan = new JPanel(new GridBagLayout()); //Créer un nouveau panel
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(topPad, leftPad, bottomPad,rightPad);  //Ecart en haut, à gauche, en bas, à droite
		
		OtherButton button = new OtherButton(name, properties);
		
		button.setPreferredSize(new Dimension (width, height));
		button.setMinimumSize(new Dimension (width, height));
		
		buttonPan.setOpaque(false); //Rend le panel non opaque
		buttonPan.add(button, gbc); //Ajoute le panel au panel principal
		mainLayer.add(buttonPan, layer);
		this.setVisible(true); //Affiche le nouveau contenu
		return button;
	}
	
	public MenuButton addMenuButton (String name, String img, int properties, int x, int y, int width, int height, int layer)
	{
		JPanel buttonPan = new JPanel(null);
		
		MenuButton button = new MenuButton(name, img, properties);
		
		button.setBounds(x, y, width, height);
		buttonPan.setOpaque(false); //Rend le panel non opaque
		buttonPan.add(button); //Ajoute le panel au panel principal
		mainLayer.add(buttonPan, layer);
		this.setVisible(true); //Affiche le nouveau contenu
		return button;	
	}
/*Barre de Menu */ 
    private void createMenuBar() {
       
    
    	
        JMenuBar menubar = new JMenuBar();
        
        JMenu heatMenu = new JMenu("Heat");
        heatMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu nutMenu = new JMenu("Nutrients");
        nutMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenu salinityMenu = new JMenu("Salinity");
        salinityMenu.setMnemonic(KeyEvent.VK_F);
      
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newMi = new JMenuItem("New");
        JMenuItem openMi = new JMenuItem("Open");
        JMenuItem saveMi = new JMenuItem("Save");

        JMenuItem exitMi = new JMenuItem("Exit");
        exitMi.setToolTipText("Exit application");

        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });   
            
            
        
        ButtonGroup difGroup = new ButtonGroup();
        boolean heat = false;
        

        JRadioButtonMenuItem eaRMi = new JRadioButtonMenuItem("Low");
        eaRMi.setSelected(true);
        heatMenu.add(eaRMi);
      
        
        eaRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
            //   statusbar.setText("Easy");
               heatvalue = 1;
              
            }
        });
        
        JRadioButtonMenuItem meRMi = new JRadioButtonMenuItem("Medium");
        heatMenu.add(meRMi);
        

        meRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
              //  statusbar.setText("Medium");
            	heatvalue = 2;
            }
        });
        
        JRadioButtonMenuItem haRMi = new JRadioButtonMenuItem("High");
        heatMenu.add(haRMi);
        //nutMenu.add(haRMi);

        haRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
              //  statusbar.setText("Hard");
            	heatvalue = 3;
            }
        });
        
        System.out.println("coucou" + heatvalue);
        //statusbar.getText();
        
        JRadioButtonMenuItem eanutRMi = new JRadioButtonMenuItem("Low");
        eanutRMi.setSelected(true);
        nutMenu.add(eanutRMi);
        
        eanutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //statusbar.setText("Easy");
            	  nutrientsvalue = 1;
            }
        });
        

        JRadioButtonMenuItem menutRMi = new JRadioButtonMenuItem("Medium");
        nutMenu.add(menutRMi);
        
        menutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //statusbar.setText("Medium");
            	nutrientsvalue = 2;
            }
        });
        
        JRadioButtonMenuItem hanutRMi = new JRadioButtonMenuItem("High");
        nutMenu.add(hanutRMi);

       hanutRMi.addItemListener((ItemEvent e) -> {
           if (e.getStateChange() == ItemEvent.SELECTED) {
               //statusbar.setText("Hard");
        	   nutrientsvalue = 3;
           }
       });

        JRadioButtonMenuItem easaliRMi = new JRadioButtonMenuItem("Low");
        easaliRMi.setSelected(true);
        salinityMenu.add(easaliRMi);
        
        easaliRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //statusbar.setText("Easy");
            	salinityvalue = 1;
            }
        });

      
        
        JRadioButtonMenuItem mesaliRMi = new JRadioButtonMenuItem("Medium");
        salinityMenu.add(mesaliRMi);
        
        menutRMi.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                //statusbar.setText("Medium");
            	salinityvalue = 2;
            }
        });
        
        JRadioButtonMenuItem hasaliRMi = new JRadioButtonMenuItem("High");
        salinityMenu.add(hasaliRMi);

       hasaliRMi.addItemListener((ItemEvent e) -> {
           if (e.getStateChange() == ItemEvent.SELECTED) {
               //statusbar.setText("Hard");
        	   salinityvalue = 3;
           }
       });
       
        
        
  
        

        difGroup.add(eaRMi);
        difGroup.add(meRMi);
        difGroup.add(haRMi);
        
        difGroup.add(eanutRMi);
        difGroup.add(menutRMi);
        difGroup.add(hanutRMi);
        
        difGroup.add(easaliRMi);
        difGroup.add(mesaliRMi);
        difGroup.add(hasaliRMi);
        
        fileMenu.add(newMi);
        fileMenu.add(openMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);

        menubar.add(heatMenu);
        menubar.add(nutMenu);
        menubar.add(salinityMenu);
        setJMenuBar(menubar);
    }
	
 
    
	public void setBackground (String background)
	{
		lab.loadImage(background); //Charge l'image de fond dans le label
		this.setVisible(true); //Affiche le nouveau contenu
	}
	
	public Fenetre getFenetre()
	{
		return this;
	}
}