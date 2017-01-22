

public class Cell implements Cloneable {
	 // Attributes
	 private int id;
	 private int posx, posy;
	 private boolean duplication;
	 
	 //Constructor
	 public Cell(){
		 this.id=1;
		 this.duplication=false;
	 }
	 
	 public Cell(int x, int y){
		 this.posx=x;
		 this.posy=y;
		 this.id=0;
	 }
	
	 // Methods
	 public Cell clone(){
		 try {
		 return (Cell) super.clone();
		 }
		 catch (CloneNotSupportedException e){
		 throw new InternalError();
		 }
	 }
	 
	 public boolean getduplication(){
		 return duplication;
	 }
	 
	 public void setduplication(boolean duplication){
		 this.duplication=duplication;
	 }
	 
	 public int getid(){
		 return id;
	 }
	 
	 public void setid(int id){
		 this.id = id;
	 }
	 
	 public int getx(){
		 return posx;
	 }
	 
	 public void setx(int x){
		 this.posx = x;
	 }
	 
	 public int gety(){
		 return posy;
	 }
	 
	 public void sety(int y){
		 this.posy = y;
	 }
	
	 public void afficher(){
		 System.out.println(id);
	 }
}
