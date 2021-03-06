
public class SLLSet {
    private int numElem;
    private SLLNode fNode;

    public SLLSet() {
        numElem = 0;
        fNode = null;
    }

    public SLLSet(int[] sortedArray) {

        if (sortedArray == null) { // checks to make sure that the array isnt empty
            this.numElem = 0;
            this.fNode = null;
            return;
        }

        this.numElem = sortedArray.length;
        this.fNode = new SLLNode(sortedArray[0], null); // makes the first node in the list

        SLLNode currentNode = this.fNode; // sets the current node to be the first one

        for (int i = 1; i < sortedArray.length; i++) { // cycles thru the sortedArray list
            currentNode.next = new SLLNode(sortedArray[i], null);
            currentNode = currentNode.next;
        }
    }

    public int getSize() {
        return this.numElem;
    }

    public SLLSet copy() {

        SLLSet setcpy = new SLLSet();
        setcpy.numElem = this.numElem;

        SLLNode currentNode = this.fNode; // sets the currentnode to be the fNode
        SLLNode cpyNode = new SLLNode(currentNode.value, null);
        setcpy.fNode = cpyNode;

        for (int i = 1; i < setcpy.numElem; i++) { // cycles thru the sortedArray list
            currentNode = currentNode.next;
            cpyNode.next = new SLLNode(currentNode.value, null); // sets the copied next node as the value of the
                                                                 // current
            cpyNode = cpyNode.next;

        }

        return setcpy;

    }

    public boolean isIn(int v) {
        SLLNode currentNode = this.fNode;
        while (currentNode != null) {
            if (v == currentNode.value) {
                return true;
            }
            else if (v < currentNode.value) {
                return false;
            }
            currentNode = currentNode.next;
        }
        
        return false;
    }

    public void add(int v) {

        if (this.numElem == 0) { // if the list is empty, create the first node
            SLLNode nNode = new SLLNode(v, null);
            this.numElem++;
            this.fNode = nNode;
            return;
        }

        SLLNode current = this.fNode;

        if (this.isIn(v) == true) { // check that node with that value already exists
            return;
        }

        else {

            if (v < current.value) { // check if the value is smaller than the fNode
                this.fNode = new SLLNode(v, this.fNode);
                this.numElem++;
                return;
            }

            while (current.next != null) {
                if (v > current.value && v < current.next.value) { // check that the value v is greater than the
                                                                   // previous and less than the next
                    current.next = new SLLNode(v, current.next);
                    this.numElem++;
                    return;
                }
                current = current.next;
            }

            // very last node that can only be called when the v is greater than all values. 
            
            current.next = new SLLNode(v, null);
            this.numElem++;
            return;

        }
    }

    public void remove(int v){

        SLLNode currentNode = this.fNode; 
        SLLNode prevNode = new SLLNode(0,null);

        if (this.isIn(v) == false){ // check if value doesnt exist
            return;
        }

        if (v == currentNode.value){ // checks if the first node is equal to the removed value
            this.fNode = currentNode.next;
            this.numElem--;
            return; 
        }


        while (currentNode != null){
            if (v == currentNode.value){ // check next node
                prevNode.next = currentNode.next; // skips the middle node that is getting removed (currentNode)
                this.numElem--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

    }

    public SLLSet union(SLLSet s) {

        if (s.fNode == null) { // if the SLLSet s is empty, return this
            SLLSet union = this.copy();
            return union;
        }

        if (this.fNode == null) {
            SLLSet union = s.copy();
            return union;
        }

        SLLSet union = s.copy(); // copies the original 

        
        SLLNode s1 = this.fNode;
        SLLNode s2 = s.fNode; 

        for (int i = 0; i < this.numElem; i++) { // doesn't need to check if isIn because it uses the add function 

            union.add(s1.value); // take union and add s1
            s1 = s1.next;
        }

        return union;
    }

    public SLLSet intersection(SLLSet s) {
        SLLSet intersect = new SLLSet();

        if (this.fNode == null || s.fNode == null) {
            return intersect;
        }

        SLLNode current = this.fNode;

        for (int i = 0; i < this.numElem; i++) {
            if (s.isIn(current.value)) {
                intersect.add(current.value);
            }
            current = current.next;
        }

        return intersect;
    }

    public SLLSet difference(SLLSet s) {

        SLLSet diff = new SLLSet();
        if (this.fNode == null) { // check that fNode is a null to return empty set
            return diff;
        }

        if (s.fNode == null) {
            diff = this.copy();
            return diff;
        }

        SLLNode s1 = this.fNode;
        SLLNode s2 = s.fNode;



        if (this.numElem >= s.getSize()) { // check which set has the larger amount numbers
            for (int i = 0; i < this.numElem; i++) {
                if (s.isIn(s1.value) == false) { // check that the SLLSet 'this' is in the set 
                    diff.add(s1.value);
                }
                s1 = s1.next;
            }

        } else {
            for (int i = 0; i < s.numElem; i++) {
                if (this.isIn(s2.value) == false) {
                    diff.add(s2.value);
                }
                s2 = s2.next;
            }
        }
        return diff;
    }

    public static SLLSet union(SLLSet[] sArray) {

        SLLSet unionSet = new SLLSet();

        for (int i = 0; i < sArray.length; i++) {
            unionSet = unionSet.union(sArray[i]);

        }
        return unionSet;

    }

    public String toString() {
        String list = "";
        SLLNode currentNode = this.fNode;
        if (currentNode == null) {
            return list;
        }

        while (currentNode != null) {
            list += currentNode.value + " ";
            currentNode = currentNode.next;
        }
        // list += currentNode.value;
        return list;
    }
}
