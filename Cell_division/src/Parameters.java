
public class Parameters {
	//Attributes
	private int h, n, s;
	public static final int LEVEL1 = 3;
	public static final int LEVEL2 = 17;
	public static final int LEVEL3 = 33;
	
	//Constructor
	public Parameters(){
		this.h=LEVEL2;
		this.n=LEVEL2;
		this.s=LEVEL2;
	}
	
	//Methods
	public void ToLevel1(int param){
		if (param==this.h) this.h=LEVEL1;
		if (param==this.n) this.n=LEVEL1;
		if (param==this.s) this.s=LEVEL1;
	}
	
	public void ToLevel2(int param){
		if (param==this.h) this.h=LEVEL2;
		if (param==this.n) this.n=LEVEL2;
		if (param==this.s) this.s=LEVEL2;
	}
	
	public void ToLevel3(int param){
		if (param==this.h) this.h=LEVEL3;
		if (param==this.n) this.n=LEVEL3;
		if (param==this.s) this.s=LEVEL3;
	}
	
	public int sumparam(){
		return this.h+this.n+this.s;
	}
	
	public int getH(){
		return h;
	}
	
	public void setH(int h){
		this.h=h;
	}
	
	public int getN(){
		return n;
	}
	
	public void setN(int n){
		this.s=n;
	}
	
	public int getS(){
		return s;
	}
	
	public void setS(int s){
		this.s=s;
	}
}
