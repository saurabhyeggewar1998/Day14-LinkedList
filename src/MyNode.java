public class MyNode <K extends Comparable> implements INode<K>{
    private K key;
    private INode next;

    public MyNode(K key){
        this.key = key;
        this.next = null;
    }
    // Getter and setter
    @Override
    public K getKey(){
        return key;
    }
    @Override
    public void setKey(K key){
        this.key = key;
    }
    @Override
    public INode<K> getNext(){
        return next;
    }
    @Override
    public void setNext(INode next){
        this.next = (MyNode<K>) next;
    }
}
