import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class Controller {
	
	public static boolean randomDuplucation(int percentage){
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1); 
		if(randomNum<percentage)return true;
		else return false;
	 }
	
	public static int random(){
		int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1); 
		return randomNum;
	 }
	
	public static void clearScreen() {  
		for(int i = 0; i < 50; i++)
		{
		    System.out.println(" ");
		} 
	   } 
	
	
	public static void main(String args[]){
		//Init
		int posx=0, posy=0, random=0;
		boolean exit=false;
		//Init field
		Field board= new Field();
		//Init parameters level2
		Parameters p=new Parameters();
		p.ToLevel2(p.getH());
		p.ToLevel2(p.getS());
		p.ToLevel2(p.getN());
		//First cell
		Cell x = new Cell();
		//Add the first cell in the middle of field
		board.addCell(board.NO_OF_ROWS/2, board.NO_OF_COLUMNS/2, x);
		
		clearScreen();
		board.print();
		//Start
		do{
		for (int row = 0; row < board.NO_OF_ROWS; row++) {
            for (int col = 0; col < board.NO_OF_COLUMNS; col++) {
            	if(board.field[row][col]!=null) { //find a cell
            		if(randomDuplucation(p.sumparam())==true){
            			if (board.isempty(row-1, col)==true || board.isempty(row, col-1)==true || board.isempty(row+1, col)==true || board.isempty(row, col+1)==true){
	            			exit=false;
            				while(exit!=true){
            					random=random();
	            				if(board.isempty(row-1, col)==true && random==1){
		                			posx=col;
		                			posy=row-1;
		                			exit=true;
		                		}
		            			if(board.isempty(row, col-1)==true && random==2){
		                			posx=col-1;
		                			posy=row;
		                			exit=true;
		                		}
		            			if(board.isempty(row+1, col)==true && random==3){
		                			posx=col;
		                			posy=row+1;
		                			exit=true;
		                		}
		            			if(board.isempty(row, col+1)==true && random==4){
		                			posx=col+1;
		                			posy=row;
		                			exit=true;
		                		}
		            			board.addCell(posx, posy, ((Cell) x.clone()));
            				}
            			}
            		}
            	}
            }
        }
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearScreen();
		board.print();
		}while(!board.full());
	 }
}