/**
 * Test class
 *
 * @author Jan Philip Kozina, 4052980, Gruppe 11b
 * @version 30.4.2016
 */
public class Test {
    /**
     * Main method
     *
     * @param args string array
     */
    public static void main(String[] args) {
        try {
            DoubleLinkedList dl = DoubleLinkedList.importCsv();
            dl.print(dl);
            System.out.println(dl.firstPokemon());
            dl.delete(dl.firstPokemon());
            System.out.println(dl.firstPokemon());
            System.out.println(dl.length());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
