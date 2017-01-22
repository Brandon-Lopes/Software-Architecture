
public class Field {
	//Attributes
	public final int NO_OF_ROWS = 25;
    public final int NO_OF_COLUMNS = 25;
	private int x, y;
	public Cell[][] field;
	
	//Constructor
	public Field(){
		this.field = new Cell[NO_OF_ROWS][NO_OF_COLUMNS];
	}
	
	//Methods
	public void print() {
        for (int row = 0; row < NO_OF_ROWS; row++) {
            for (int col = 0; col < NO_OF_COLUMNS; col++) {
            	if(field[row][col]==null) System.out.print("0");
            	else System.out.print(field[row][col].getid());
            }
            System.out.println();
        }
    }
	
	public void addCell(int posx, int posy, Cell cell){
		this.field[posy][posx]=cell;
	}
	
	public boolean isempty(int posx, int posy){
		if(posx>=0 && posx<NO_OF_ROWS && posy>=0 && posy<NO_OF_COLUMNS && field[posx][posy]==null) return true;
		else return false;	
	}
	
	public boolean full(){
		for (int row = 0; row < NO_OF_ROWS; row++) {
            for (int col = 0; col < NO_OF_COLUMNS; col++) {
            	if(field[row][col]==null) return false;
            }
        }
		return true;
	}
	
	public int getx(){
		return x;
	}
	
	public void setx(int x){
		this.x=x;
	}
	
	public int gety(){
		return y;
	}
	
	public void sety(int y){
		this.y=y;
	}
}
