import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * Operations to use a double linked list as pokedex
 *
 * @author Jan Philip Kozina, 4052980, Gruppe 11b
 * @version 30.4.2016
 */
final class DoubleLinkedList implements List {
    private Pokemon data;
    private DoubleLinkedList next;
    private DoubleLinkedList previous;

    /**
     * Create new empty double linked list
     */
    private DoubleLinkedList() {
        data = null;
        next = null;
        previous = null;
    }

    /**
     * Get-method to retrieve pokemon
     * @return pokemon object
     */
    private Pokemon getPokemon() {
        return data;
    }

    /**
     * Get-method to get next node in list
     * @return next entry in list
     */
    private DoubleLinkedList getNext() {
        return next;
    }

    /**
     * Get-method to get previous node in list
     * @return previous entry in list
     */
    private DoubleLinkedList getPrevious() {
        return previous;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return next == null;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + next.length();
        }
    }

    /**
     * Retrieves, but does not remove, the first Pokemon of this list, or returns null if this list is empty.
     * @return the first Pokemon of this list, or null if this list is empty
     */
    @Override
    public Pokemon firstPokemon() {
        if (isEmpty()) {
            return null;
        } else {
            return next.data;
        }
    }

    /**
     * Inserts the specified Pokemon in this list.
     * @param p Pokemon to be inserted
     */
    @Override
    public void insert(Pokemon p) {
        if (isEmpty() || p.compareTo(getNext().getPokemon()) <= 0) {
            DoubleLinkedList dl = new DoubleLinkedList();
            dl.data = p;
            dl.next = next;
            dl.previous = this;
            next = dl;
        } else {
            getNext().insert(p);
        }
    }

    /**
     * Method to find the pokemon in list
     * @param p pokemon
     * @return node which contains the specified pokemon, null if it is not in the list
     */
    private DoubleLinkedList find(Pokemon p) {
        if (isEmpty()) {
            return null;
        } else if (firstPokemon().equals(p)) {
            return this;
        } else {
            return next.find(p);
        }
    }

    /**
     * Removes the first occurrence of the Pokemon from this list, if it is present.
     * @param p Pokemon to be removed from this list, if present
     */
    @Override
    public void delete(Pokemon p) {
        DoubleLinkedList dl = find(p);
        if (dl != null) {
            dl.next = dl.next.next;
            dl.next.previous = dl;
        }
    }

    /**
     * Import of the csv in a double linked list
     *
     * @return double linked list if successful, Else Null.
     * @throws IOException error with reading file
     */
    static DoubleLinkedList importCsv() throws IOException {
        try {
            DoubleLinkedList dl = new DoubleLinkedList();
            BufferedReader br = Files.newBufferedReader(Paths.get("Pokedex.csv"));
            String line = null;
            br.readLine(); //skip headline of csv
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                if (st.countTokens() == 11) {
                    Integer nr = Integer.parseInt(st.nextToken());
                    String name = st.nextToken();
                    String type1 = st.nextToken();
                    String type2 = st.nextToken();
                    Integer total = Integer.parseInt(st.nextToken());
                    Integer hp = Integer.parseInt(st.nextToken());
                    Integer atk = Integer.parseInt(st.nextToken());
                    Integer def = Integer.parseInt(st.nextToken());
                    Integer spAtk = Integer.parseInt(st.nextToken());
                    Integer spDef = Integer.parseInt(st.nextToken());
                    Integer speed = Integer.parseInt(st.nextToken());

                    Pokemon p = new Pokemon(nr, name, type1, type2, total, hp, atk, def, spAtk, spDef, speed);

                    dl.insert(p);
                } else if (st.countTokens() == 10) {
                    Integer nr = Integer.parseInt(st.nextToken());
                    String name = st.nextToken();
                    String type1 = st.nextToken();
                    String type2 = "";
                    Integer total = Integer.parseInt(st.nextToken());
                    Integer hp = Integer.parseInt(st.nextToken());
                    Integer atk = Integer.parseInt(st.nextToken());
                    Integer def = Integer.parseInt(st.nextToken());
                    Integer spAtk = Integer.parseInt(st.nextToken());
                    Integer spDef = Integer.parseInt(st.nextToken());
                    Integer speed = Integer.parseInt(st.nextToken());

                    Pokemon p = new Pokemon(nr, name, type1, type2, total, hp, atk, def, spAtk, spDef, speed);

                    dl.insert(p);
                } else if (st.countTokens() == 0) {
                    continue; //skip empty lines, normally unnecessary but empty blocks are not allowed by checkstyle
                }
            }
            br.close();
            return dl;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * The method creates and prints a table of the attributes of the pokemon in the double linked list.
     *
     * @param dl Double linked list to print
     */
    void print(DoubleLinkedList dl) {
        System.out.printf("%3s |%17s |%10s |%10s |%5s |%5s |%5s |%5s |%8s |%8s |%7s \n",
                "Nr", "Name", "Type 1", "Type 2", "Total", "HP", "Atk", "Def", "Sp Atk", "Sp Def", "Speed");
        //Fill line with dashes
        for (int i = 1; i <= 104; i++) {
            System.out.print("-");
        }
        System.out.print("\n");

        //print attributes
        for (int i = 1; i < dl.length(); i++) {
            Pokemon p = dl.getNext().getPokemon();
            /* variant 1

            System.out.printf("%3d |%17s |%10s |%10s |%5d |%5d |%5d |%5d |%8d |%8d |%7d \n", p.getNr(), p.getName(),
                    p.getType1(), p.getType2(), p.getTotal(), p.getHp(), p.getAttack(), p.getDefence(), p.getSpAtk(),
                    p.getSpDef(), p.getSpeed());
            */
            //variant 2
            System.out.println(p.toString());
            dl = dl.getNext();

        }
    }
}
