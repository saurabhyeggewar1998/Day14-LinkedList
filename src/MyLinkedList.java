import java.lang.Comparable;

public class MyLinkedList {
    public INode head;
    public INode tail;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode){
        if (this.tail == null){
            this.tail = newNode;
        }
        if (this.head == null){
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);    // 30 points to 70 (Tail)  
        }
    }
    public void append(INode newNode){
        if (this.head == null){
            this.head = newNode;
        }
        if (this.tail == null){
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            this.tail = newNode;        // 56 points to 30 (Tail)  
        }
    }
    // New node inserted after previous node
    public void insert(INode prevNode,INode newNode){
        {
            INode tempNode = prevNode.getNext(); // get pointer to next
            prevNode.setNext(newNode);
            newNode.setNext(tempNode); // newnode should point to element which was
            // pointed to by prevnode earlier.
        }
    }
    // Pop the first element of the linked list 
    public INode pop(){
        INode tempNode = this.head;
        this.head  = head.getNext();//
        return tempNode;
    }

    // Pop the last element of the linked list 
    public INode popLast(){
        INode tempNode = this.head;
        // get the element just before the last element
        while (!tempNode.getNext().equals(tail)){
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }
    // Delete the given element of the linked list 
    public void delete(INode deleteNode){
        INode tempNode = this.head;
        // If the element to be deleted is either the first or the last element
        if ( deleteNode.equals(this.head)) pop();
        if ( deleteNode.equals(this.tail)) popLast();
        // search for the element to be deleted
        while (!(tempNode.getNext().equals(tail))){
            if (tempNode.getNext().getKey().equals(deleteNode.getKey())){
                INode tempNode1 = tempNode.getNext().getNext();
                tempNode.setNext(tempNode1);
                break;
            }
            tempNode = tempNode.getNext();
        }
    }
    //size of the linked list
    public int findSize(){
        int size_lnk_lst;
        INode tempNode = this.head;
        INode tempNode1 = this.tail;
        if (tempNode.equals(tempNode1)){   // If 1 element
            size_lnk_lst = 1;
        } else if (tempNode.getNext().equals(tempNode1)){   // If 2 elements
            size_lnk_lst = 2;
        } else{ // If minimum 2 elements
            size_lnk_lst = 2;
            while (!tempNode.getNext().equals(tempNode1)){
                size_lnk_lst++;
                tempNode = tempNode.getNext();
            }
        }
        return size_lnk_lst;
    }
    // Search for a given element in the linked list
    public INode search(INode srchNode){
        INode tempNode = this.head;
        int count = 0 ;
        Boolean elem_found = false;
        while (tempNode.getNext()!= null && (elem_found.equals(false))){
            if (tempNode.getKey().equals(srchNode.getKey())){
                elem_found = true;
                break;
            }
            tempNode = tempNode.getNext();
            count++;
        }
        if (elem_found.equals(false)){
            count = -1;
        }
        return tempNode;
    }
    // Add new element in such position that linked list is in ascending order
    public  void addSorted(INode newNode){
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else  {
            INode tempNode = this.head;
            // If element smaller than head
            if ((tempNode.getKey()).compareTo(newNode.getKey()) >0){
                this.head = newNode;
                newNode.setNext(tempNode);
            }
            // If element greater than tail
            INode tempNodeT = this.tail;
            if ((tempNodeT.getKey()).compareTo(newNode.getKey()) <0){
                tempNodeT.setNext(newNode);
                this.tail = newNode;
            }
            // In remaining cases
            while(tempNode.getNext() != null){
                // temp<new and tempnext>new
                if (((tempNode.getKey()).compareTo(newNode.getKey()) <0)&&
                        (tempNode.getNext().getKey().compareTo(newNode.getKey()) >0)){
                    INode tempNode1 = tempNode.getNext();
                    tempNode.setNext(newNode);
                    newNode.setNext(tempNode1);
                }
                tempNode = tempNode.getNext();
            }
        }
    }
    // Print the nodes
    public void printMyNodes(){
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }
}