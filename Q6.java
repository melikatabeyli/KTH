/*
Author: Melik Atabeyli
Koden skapar en linked list som tillåter usern att addera komponenter i ascending ordning och tar bort
alla komponent som önskas av vilken plats som helst, k'th component i queuen. Listan printas direkt efter
något nytt är adderat eller borttagen.
 */
import java.util.Iterator;

public class Q6 implements Iterable{

    private Node första;
    private int listStorlek;

    //Tester för att se om koden gör det den ska
    public static void main(String[] args) {

        Q6 yolo = new Q6() ;

        yolo.adderaAscending(5) ;

        yolo.adderaAscending(3);
        yolo.adderaAscending(0) ;
        yolo.adderaAscending(-7) ;
        yolo.adderaAscending(763);
        yolo.adderaAscending(18);
        yolo.adderaAscending(-9822) ;
        yolo.radera(3) ;
        yolo.radera(6);
        yolo.radera(2);
    }

    //Skapar tom lista
    Q6(){
        this.listStorlek = 0 ;
    }

    //Adderar int komponentet till listan i ascending order
    void adderaAscending(int component) {


        if(!isEmpty()){

            Node nuvarande = this.första ;

            int plats = 1 ;

            while (nuvarande != null && nuvarande.component < component)
            {
                nuvarande = nuvarande.next;
                plats++; }

            insertcomponent(component, plats) ;
        }
        else
            insertcomponent(component,1) ;
        System.out.println("List storlek: " + getlistStorlek()) ; }

    //Adderar component på given plats
    private void insertcomponent(int component, int plats) throws java.lang.IndexOutOfBoundsException {

        if (1 > plats || plats > (this.listStorlek + 1))
            throw new java.lang.IndexOutOfBoundsException("Index " + plats + " does not exist");
        else if (1 < plats) {

            Node h = new Node(component) ;

            Node föregående = this.första;

            for (int i = 1; i < plats - 1; i++)

                föregående = föregående.next ;

            h.next = föregående.next ;
            föregående.next = h ; }
        else {

            Node y = new Node(component) ;

            y.next = this.första;
            this.första = y; }

        this.listStorlek++;
        System.out.println("Komplett lista: " + this) ; }

    //Raderar componenten som är på den givna platsen.
    private int radera(int plats) throws java.lang.IndexOutOfBoundsException {

        Node k;

        if(plats > getlistStorlek() || plats < 1)
            throw new IndexOutOfBoundsException("Index " + plats + " does not exist");

        else if (1 == plats) {

            k = this.första ;

            this.första = this.första.next ;
        }
        else{
            Node nuvarande = this.första.next ;

            Node föregående = this.första ;

            for (int i = 2; i < plats; i++)
            {
                nuvarande = nuvarande.next ;

                föregående = föregående.next ;
            }
            k = nuvarande ;

            föregående.next = nuvarande.next;
            k.next = null ; }

        this.listStorlek--;


        System.out.println("List storlek: " + getlistStorlek()) ;

        System.out.println("Raderad component: " + k.component + ", Komplett lista: " + this);

        return k.component ;
    }

    //Returnerar boolean true om listan är tom och false ifall inte
    boolean isEmpty(){

        return this.första == null ; }
    //Returnerar storleken på nuvarande lista
    int getlistStorlek(){

        return this.listStorlek ; }

    //Returnerar en string som innehåller alla komponenter av listan
    public String toString(){

        StringBuilder sb = new StringBuilder() ;

        for(Object component: this)
            sb.append(component + " ") ;

        return sb.toString() ; }

    //En node som har int i listen
    private class Node{

        private int component ;     //Class attributes
        private Node next;

        //component är den nya int varje ny node får
        private Node (int component){

            this.component = component ;

            this.next = null ;

        }}

    //Iterator som itererar genom nuvarande lista
    public Iterator<Integer> iterator() {
        return new ListIterator() ;
    }

    //iterator som gör listan itererbar
    private class ListIterator implements Iterator<Integer> {

        private Node nuvarande = första ;

        //Returnerar true om nuvarande lista inte är null
        public boolean hasNext(){

            return nuvarande != null ;
        }

        //Itererar genom listan och gör noden till nuvarande, return är komponentet av den nuvarande noden
        public Integer next() {

            Integer component = nuvarande.component ;

            nuvarande = nuvarande.next ;

            return component ;
        }}

}
