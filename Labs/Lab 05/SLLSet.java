

public class SLLSet {
    private int numElem;
    private SLLNode fNode;

    public SLLSet(){ numElem = 0; fNode = null;}

    public SLLSet(int[] sortedArray){
        if (sortedArray == null){ // checks to make sure that the array isnt empty
            this.numElem = 0; 
            this.fNode = null;
            return; 
        }
        this.numElem = sortedArray.length;
        this.fNode = new SLLNode(sortedArray[0], null); // makes the first node in the list
        SLLNode currentNode = this.fNode; // sets the current node to be the first one 

        for (int i = 1; i< sortedArray.length; i++){ // cycles thru the sortedArray list 
            currentNode.next = new SLLNode(sortedArray[i], null);
            currentNode = currentNode.next;
        }   
    }

    public int getSize() {return this.numElem;}
    
    public SLLSet copy(){
        
        SLLSet setcpy = new SLLSet();
        setcpy.numElem = this.numElem;

        SLLNode currentNode = this.fNode; // sets the currentnode to be the firstnode
        SLLNode cpyNode =  new SLLNode(currentNode.value, null);
        setcpy.fNode = cpyNode;
        
        for (int i = 1; i< setcpy.numElem; i++){ // cycles thru the sortedArray list 
            currentNode = currentNode.next; 
            cpyNode.next = new SLLNode(currentNode.value, null); // sets the copied next node as the value of the current
            cpyNode = cpyNode.next;
            
        }   
        
        return setcpy;

    }

    public boolean isIn(int v){
        SLLNode currentNode = this.fNode;
        while (currentNode.next != null){
            if (v == currentNode.value){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void add(int v){
        SLLNode current = this.fNode;

        if (this.isIn(v) == true){
            System.out.println("Value already exists");
            return;
        }
        /*
        if (v < this.fNode.value){ // check if the value is smaller than the firstNode 
            this.fNode = new SLLNode(v, this.fNode);
            this.numElem++;
            return; 
        }
        while (current != null){
            if (v >= current.value){
                current.next = new SLLNode(v, current.next);
                this.numElem++;
                return;
            }
        }
        */
        return;
    }

    public void remove(int v){

        SLLNode current = fNode; 
        if (this.isIn(v) == false){ // check if value doesnt exist
            System.out.println("Value doesn't exist");
            return;
        }

        if (v == this.fNode.value){ // checks if the first node is equal to the removed value
            this.fNode = this.fNode.next;
            this.numElem--;
            return; 
        }
        while (this.fNode != null){

        }
    }
    public SLLSet union(SLLSet s){
        SLLSet unionSet = copy(this);
    }

    public SLLSet intersection(SLLSet s){
        return s;
    }


    public SLLSet difference(SLLSet s){
        return s;
    }

    public static SLLSet union(SLLSet[] sArray){
        return null;
    }

    public String toString(){
            String list = "";
            SLLNode currentNode = this.fNode;
            if (currentNode == null){
                return list;
            }

            while(currentNode != null){
                list += currentNode.value + " ";
                currentNode = currentNode.next;
            }
            // list += currentNode.value;
            return list;
}
    }
   