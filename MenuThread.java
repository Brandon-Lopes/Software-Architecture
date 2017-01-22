package go.java;

public class MenuThread extends Thread
{
	private Fenetre mfenetre;
	
	public MenuThread (Fenetre fenetre)
	{
		mfenetre = fenetre;
	}

	public void animSelect(MenuButton button, String n_image)
	{
		button.loadImage(n_image);
		
	}
	
	public void animGrossi(MenuButton button) //Animation de grossissement et de maigrissement
	{
		int i = 0, j; //Des compteurs
		int X = button.getX(), Y = button.getY(), width = button.getWidth(), height = button.getHeight(), temp = height; 

		for (j = width; j <= width+100; j+=2) //Grossissement
		{
			button.setBounds(X-i, Y-i, j, height);
			height++;
			i++;
			if (MenuButton.mouse == 0)
			{
				button.setBounds(X, Y, width, temp);
				return;
			}
			
		}
		
		for (j = j-2; j >= width; j-=2) //Maigrissement
		{
			button.setBounds(X-i, Y-i, j, height);
			if (MenuButton.mouse == 0)
			{
				button.setBounds(X, Y, width, temp);
				return;
			}
		
		}
	}
	
	public void run() //Ce que fait le thread
	{
		/*Sound player = new Sound("song.wav");
	    ByteArrayInputStream stream = new ByteArrayInputStream(player.getSamples()); 
	    */
	//	MenuButton hVIA = mfenetre.addMenuButton("Human Vs IA", "", -1, (mfenetre.getWidth()/2)-200, 200, 400, 150, 0);
	//	MenuButton hVH = mfenetre.addMenuButton("Human Vs Human", "Human VS Human.png", -2, (mfenetre.getWidth()/2)-200, 400, 400, 150, 0);
		
	/*	while (Bouton.getClicked() != true)
		{
			if (MenuButton.mouse == 1) animGrossi (MenuButton.button);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        int i = 1;
		for (int x = (mfenetre.getWidth()/2)-200; x > -200; x = x-30)
		{
			
			//hVIA.setLocation(x, hVIA.getY());
		//	hVH.setLocation(x+(i*60), hVH.getY());
			mfenetre.repaint();
			i++;
			try {
				sleep(0, 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		 int i = 1;
		Bouton.setClicked(false);
		//hVIA.setVisible(false);
		//hVH.setVisible(false);

			
		MenuButton hVIB = mfenetre.addMenuButton("Nouvelle partie", "Nouvelle partie.png", 5, (mfenetre.getWidth()/2)-200, 200, 400, 150, 0);
		MenuButton hVHB = mfenetre.addMenuButton("Charger partie", "Charger partie.png", 4, (mfenetre.getWidth()/2)-200, 400, 400, 150, 0);
		
		
		while (Bouton.getClicked() != true)
		{
			if (MenuButton.mouse == 1) animGrossi (MenuButton.button);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int x = (mfenetre.getWidth()/2)-200; x > -200; x = x-30)
		{
			
		//	hVIB.setLocation(x, hVIA.getY());
			//hVHB.setLocation(x+(i*60), hVH.getY());
			mfenetre.repaint();
			i++;
			try {
				sleep(0, 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Bouton.setClicked(false);
		hVIB.setVisible(false);
		hVHB.setVisible(false);
		hVIB.setEnabled(false);
		hVHB.setEnabled(false);
		
		if (Main.mode == 1)
		{
		//	MenuButton hasard = mfenetre.addMenuButton("Hasard", "Hasard.png", 0, -300, mfenetre.getHeight()/2, 170, 50, 0);
			//MenuButton facile = mfenetre.addMenuButton("Facile", "Facile.png", 1, 500, -50, 170, 50, 0);			
			//MenuButton moyen = mfenetre.addMenuButton("Normal", "Normal.png", 2, 700, 780, 170, 50, 0);
			//MenuButton difficile = mfenetre.addMenuButton("Difficile", "Difficile.png",3, mfenetre.getWidth(), mfenetre.getHeight()/2, 170, 50, 0);
	//	MenuButton info = mfenetre.addMenuButton("Choisissez le niveau de difficulté de l'IA", "Choix.png",-3, 400, -75, 550, 75, 0);
			
			/*for (int x = -300; x <= 300; x = x+30)
			{
				hasard.setLocation(x, mfenetre.getHeight()/2);
				try {
					sleep(0, 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			i = 0;
		/*	for (int y = -50; y <= mfenetre.getHeight()/2; y = y+5)
			{
				facile.setLocation(500, y+5);
				moyen.setLocation(700, mfenetre.getHeight()+48-(5*i));
				i++;
				try {
					sleep(0, 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		/*	try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*
			for (int x = 1500; x >= 900; x = x-30)
			{
				difficile.setLocation(x, mfenetre.getHeight()/2);
				try {
					sleep(0, 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		/*	for (int y = -75; y <= mfenetre.getHeight()/2-100; y = y+5)
			{
				info.setBounds(400, y, 550, 75);
				i++;
				try {
					sleep(0, 1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			info.setEnabled(false);
			*/
		String infoimg, img = "";
			while (Bouton.getClicked() != true)
			{
				if (MenuButton.mouse == 1)
				{
					infoimg = MenuButton.nameimg;
					int id = infoimg.lastIndexOf(".");
					for (i = 0; i < id; i++)
					{
						img += infoimg.charAt(i); 
					}
					img += " selected.png";
					System.out.println (img);
					animSelect(MenuButton.button, img);
					img = "";
				}
				else MenuButton.button.loadImage(MenuButton.button.getImgname());
				try {
					sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Bouton.setClicked(false);
			//hasard.setVisible(false);
			
			//difficile.setVisible(false)
			//info.setVisible(false);
		} 
	}
}



