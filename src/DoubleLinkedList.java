import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author jan
 */
class DoubleLinkedList implements List {
    private Pokemon data;
    private DoubleLinkedList next;
    private DoubleLinkedList previous;

    /**
     * Create new empty double linked list
     *
     */
    private DoubleLinkedList(){
        data = null;
        next = null;
        previous = null;
    }

    private Pokemon getPokemon(){
        return data;
    }

    private DoubleLinkedList getNext(){
        return next;
    }

    public DoubleLinkedList getPrevious(){
        return previous;
    }

    @Override
    public boolean isEmpty() {
        return next == null;
    }

    @Override
    public int length() {
        if (isEmpty()){
            return 0;
        } else
            return 1 + next.length();
    }

    @Override
    public Pokemon firstPokemon() {
        if (isEmpty()){
            return null;
        } else
            return next.data;
    }

    @Override
    public void insert(Pokemon p) {
        if (isEmpty() || p.compareTo(getNext().getPokemon()) <= 0) {
            DoubleLinkedList l = new DoubleLinkedList();
            l.data = p;
            l.next = next;
            l.previous = this;
            next = l;
        } else
            getNext().insert(p);
    }

    private DoubleLinkedList find(Pokemon p) {
        if (isEmpty()){
            return null;
        } else if(firstPokemon().equals(p)) {
            return this;
        } else{
            return next.find(p);
        }
    }

    @Override
    public void delete(Pokemon p) {
        DoubleLinkedList l = find(p);
        if (l != null) {
            l.next = l.next.next;
            l.next.previous = l;
        }
    }

    public void readCsv() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get("Pokedex.csv"));
        String line = null;
        while ((line = br.readLine()) != null) {

        }
    }
}
