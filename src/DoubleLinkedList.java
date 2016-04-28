/**
 *
 * @author jan
 */
public class DoubleLinkedList implements List {
    DoubleLinkedList next;
    DoubleLinkedList previous;
    /**
     * Create new empty double linked list
     *
     */
    public DoubleLinkedList(){
        DoubleLinkedList pokemon = null;
        DoubleLinkedList previous = null;
        DoubleLinkedList next = null;
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
            return pokemon.next;
    }

    @Override
    public void insert(Pokemon p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DoubleLinkedList l = new DoubleLinkedList();
        l.pokemon = p;
        l.next = next;
        next = l;
    }

    @Override
    public void delete(Pokemon p) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DoubleLinkedList l = find(p);
        if (l != null) {
            l.next = l.next.next;
        }
    }
}
