
public class SLLSet {
    private int numElem;
    private SLLNode firstElement;

    public SLLSet(){}

    public SLLSet(int[] sortedArray){
        this.numElem = sortedArray.length;

    }

    public int getSize() {return this.numElem;}

    public SLLSet copy(){
        
        SLLSet setcpy = new SLLSet();

        return setcpy;

    }

    public boolean isIn(int v){
        return false; 
    }

    public void add(int v){
        
    }

    public void remove(int v){

    }
    public SLLSet union(SLLSet s){
        return s;
    }

    public SLLSet intersection(SLLet s){
        return s;
    }


    public SLLSet difference(SLLSet s){
        return s;
    }

    public static SLLSet union(SLLSet[] sArray){
        return null;
    }

    public String toString(){
        return "x";
    }
}   