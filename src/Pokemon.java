/**
 * Class to define Pokemonobject for Double-linked-list
 * @author jan
 */
public class Pokemon implements Comparable<Pokemon>{
    private int nr;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defence;
    private int spAtk;
    private int spDef;
    private int speed;
   // private Pokemon next;
   //  private Pokemon previous;

    public Pokemon(int nr, String name, String type1, String type2, int total, int hp, int attack, int defence,
                   int spAtk, int spDef, int speed){
        this.nr = nr;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
       // this.next = null;
       // this.previous = null;
    }
    /*public Pokemon (int nr, String name, String type1, String type2, int total, int hp, int attack, int defence,
    int spAtk, int spDef, int speed, Pokemon next, Pokemon previous) {
        this.nr = nr;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.next = next;
        this.previous = previous;
    } */

    /**
     * Get-Method Nr.
     * @return Nr. of Pokemons
     */
    public Integer getNr(){
        return nr;
    }
    
    /**
     * Set-Method Nr.
     * @param nr Integer Nr. of Pokemon
     */
    public void setNr(Integer nr){
        this.nr = nr;
    }

    /**
     * Get-Method Name
     * @return Name of Pokemon
     */
    public String getName(){
        return name;
    }

    /**
     * Set-Method
     * @param name String Name of Pokemon
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get-Method type1
     * @return String first type of Pokemon
     */
    public String getType1(){
        return type1;
    }

    /**
     * Set-Method type1
     * @param type1 String first type of Pokemon
     */
    public void setType1(String type1){
        this.type1 = type1;
    }

    /**
     * Get-Method type2
     * @return String second type of Pokemon
     */
    public String getType2(){
        return type2;
    }

    /**
     * Set-Method type2
     * @param type2 String Second type of Pokemon
     */
    public void setType2(String type2){
        this.type2 = type2;
    }

    /**
     * Get-Method total
     * @return Integer total
     */
    public Integer getTotal(){
        return total;
    }

    /**
     * Set-Method total
     * @param total Integer
     */
    public void setTotal(Integer total){
        this.total = total;
    }

    /**
     * Get-Method hp
     * @return Integer hp of Pokemon
     */
    public Integer getHp(){
        return hp;
    }

    /**
     * Set-Method hp
     * @param hp Integer hp of Pokemon
     */
    public void setHp(Integer hp){
        this.hp = hp;
    }

    /**
     * Get-Method attack
     * @return Integer attack of Pokemon
     */
    public Integer getAttack(){
        return attack;
    }

    /**
     * Set-Method attack
     * @param attack Integer attack of Pokemon
     */
    public void setAttack(Integer attack){
        this.attack = attack;
    }

    /**
     * Get-Method defence
     * @return Integer defence of Pokemon
     */
    public Integer getDefence(){
        return defence;
    }

    /**
     * Set-Method defence
     * @param defence Integer Defence of Pokemon
     */
    public void setDefence(Integer defence){
        this.defence = defence;
    }

    /**
     * Get-Method spAtk
     * @return Integer spAtk of Pokemon
     */
    public Integer getSpAtk(){
        return spAtk;
    }

    /**
     * Set-Method special attack
     * @param spAtk Integer special attack of Pokemon
     */
    public void setSpAtk(Integer spAtk){
        this.spAtk = spAtk;
    }

    /**
     * Get-Method spDef
     * @return Integer spDef of Pokemon
     */
    public Integer getSpDef(){
        return spDef;
    }

    /**
     * Set-Method special defence
     * @param spDef Integer special Defence of Pokemon
     */
    public void setSpDef(Integer spDef){
        this.spDef = spDef;
    }

    /**
     * Get-Method speed
     * @return Integer speed of Pokemon
     */
    public Integer getSpeed(){
        return speed;
    }

    /**
     * Set-Method speed
     * @param speed Integer speed of Pokemon
     */
    public void setSpeed(Integer speed){
        this.speed = speed;
    }

    /**
     * Get-Method next
     * @return next Pokemon in list
     */
   /* public Pokemon getNext(){
        return next;
    }
*/
    /**
     * Set-Method next
     * @param next next Pokemon in list
     */
  /*  public void setNext(Pokemon next) {
        this.next = next;
    }
*/
    /**
     * Get-Method previous
     * @return previous Pokemon
     */
  /*  public Pokemon getPrevious(){
        return previous;
    }
*/
    /**
     * Set-Method previous
     //* @param previous previous Pokemon
     */
 /*   public void setPrevious(Pokemon previous){
        this.previous = previous;
    }
    */
   /* public String toString(){
        System.out.printf("%3d  %17s | %10s  %10s | %5d | %5d | %5d | %5d | %8d | %8d | %6d",
        nr, name, type1, type2, total, hp, attack, defence, spAtk, spDef, speed);
    }
    */

    public int compareTo(Pokemon pokemon){
        return this.getNr() < pokemon.getNr() ? -1 : this.getNr() > pokemon.getNr() ? 1 : 0;
    }

    public String toString(){
        return nr + " | " + name + " | " + type1 + " | " + type2 + " | " + total + " | " + hp + " | " + attack + " | " + defence + " | "
                + spAtk + " | " + spDef + " | " + speed;
    }
}
