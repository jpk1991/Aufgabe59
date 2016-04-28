/**
 *
 * @author jan
 */
public class DoubleLinkedList implements List {
    private Pokemon data;
    private DoubleLinkedList next;
    private DoubleLinkedList previous;

    /**
     * Create new empty double linked list
     *
     */
    public DoubleLinkedList(){
        data = null;
        next = null;
        previous = null;
    }

    public Pokemon getPokemon(){
        return data;
    }

    public DoubleLinkedList getNext(){
        return next;
    }

    public DoubleLinkedList getPrevious(){
        return previous;
    }

    @Override
    public boolean isEmpty() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return next == null;
    }

    @Override
    public int length() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()){
            return 0;
        } else
            return 1 + next.length();
    }

    @Override
    public Pokemon firstPokemon() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty()){
            return null;
        } else
            return next.data;
    }

    @Override
    public void insert(Pokemon p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (isEmpty() || p.compareTo(getNext().getPokemon()) <= 0) {
            DoubleLinkedList l = new DoubleLinkedList();
            l.data = p;
            l.next = next;
            l.previous = this;
            next = l;
        } else
            getNext().insert(p);
    }

    @Override
    public void delete(Pokemon p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DoubleLinkedList l; //= find(p);
        if (l != null) {
            l.next = l.next.next;
        }
    }
}
