package go.java;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Filtre extends FileFilter
{	
	protected String [] lesSuffixes;
	protected String [] laDescription;
	
	public Filtre (String []lesSuffixes, String []laDescription)
	{
		this.lesSuffixes = lesSuffixes;
	    this.laDescription = laDescription;
	}
	
	public void addFiltre (JFileChooser fileChooser) //Ajoute le filtre � la fen�tre de choix des fichiers
	{
		for (int i = 0; i < lesSuffixes.length; i++)
	    {
	    	FileNameExtensionFilter Ext = new FileNameExtensionFilter(laDescription[i], lesSuffixes[i]);
	    	fileChooser.addChoosableFileFilter(Ext);
	    }
	}
	
	boolean appartient (String suffixe) //V�rifie si l'extension en param�tre fait partie du filtre 
	{
	      for (int i = 0; i < lesSuffixes.length; i++) if(suffixe.equals(lesSuffixes[i])) return true; //On compare l'extension plac�e en param�tre avec celles du filtre
	      return false;
	}
	
	public boolean accept(File f) //D�finit les extensions autoris�es
	{
		if (f.isDirectory())  return true;
		String suffixe = null;
	    String s = f.getName(); //R�cup�re le nom du fichier
	    int i = s.lastIndexOf('.'); //L'index du dernier "." du nom du fichier
	    if(i > 0 &&  i < s.length() - 1) suffixe = s.substring(i+1).toLowerCase(); //R�cup�re l'extension entr�e s'il y en a une
	    return suffixe != null && appartient(suffixe); //D�finit si l'extension r�cup�r�e est valide ou non
	}
	   
	public String getDescription() //R�cup�re la description de l'extension
	{
		return laDescription[0];
	}    
}
