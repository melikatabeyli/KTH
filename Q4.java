/*
Author: Melik Atabeyli
Vanlig itererbar circular linked list som är double linked är skapad via koden. Den tillåter usern att insert/remove
komponenter från både bak och framsidan. Den kallar på en del olika metoder. Eftersom listen är generic så kan inputten
vara basically vad som helst. Den printar ut listan efter någonting har blivit adderad eller borttagen.
 */
import java.util.Iterator;

//En vanlig double linked itererbar list
public class Q4<Item> implements Iterable<Item> {

    private Node första ;

    private Node sista ;
    private int listStorlek;

    //Hanterar alla metoder som visar dessa unit tests som säkrar att koden funkar som den ska
    public static void main(String[] args) {

        Q4<String> yolo = new Q4<>() ;

        yolo.pushFram("Too") ;

        yolo.pushFram("Had");

        yolo.pushBak("Many");

        yolo.pushBak("Beers");

        yolo.pushBak("Yesterday");

        yolo.pushBak(",GG");

        yolo.pushFram("I");

        yolo.framPop();

        yolo.framPop() ;

        yolo.bakPop();

        yolo.framPop() ;

        yolo.bakPop() ;


        yolo.framPop();

        yolo.bakPop();

        try {
            yolo.bakPop() ;

        } catch (IllegalStateException e) {
            System.out.println(e) ;
        }
    }
    //Konstruktorn som skapar en tom circular lista.
    Q4(){
        this.listStorlek = 0;
    }
    //Adderar komponent till framsidan av cirkulära listan.
    void pushFram (Item component) {

        Node h = new Node(component);

        if (isEmpty() ) {
            pushEmpty(h) ;

        }
        else
        {

            h.next = this.första ;

            h.föregående = this.sista ;
            this.första.föregående = h ;
            this.sista.next = h ;
            this.första = h ;
        }

        this.listStorlek++ ;

        System.out.println ("Efter pushFram: " + this) ;

    }
    //Addar komponent till baksidan av den cirkulära listan
    void pushBak(Item component) {

        Node h = new Node(component);

        if (isEmpty() ) {
            pushEmpty(h) ;
        }
        else
        {
            h.next = this.första ;
            h.föregående = this.sista ;

            this.första.föregående = h ;
            this.sista.next = h ;
            this.sista = h ; }

        this.listStorlek++ ;

        System.out.println("Efter pushBak: " + this) ;
    }
    //Adderar en nod till en tom lista
    private void pushEmpty(Node h) {

        h.next = h ;
        h.föregående = h ;

        this.första = h;
        this.sista = h ;

    }
    //Tar bort första item som är i listan, return är item som blir borttagen
    //Exception är när listan är tom
    Node framPop()throws java.lang.IllegalStateException {

        if (isEmpty())
            throw new IllegalStateException("Empty List") ;

        else if(1 == this.listStorlek)

            return popSista() ;
        else {
            Node h = this.första ;

            this.första = this.första.next ;
            this.första.föregående = this.sista ;
            this.sista.next = this.första;
            h.next = h ;
            h.föregående = h ;

            this.listStorlek--;

            System.out.println("Efter framPop: " + this) ;
            return h;

        } }
    //Tar bort den sista item från listan med return.
    //Återigen illegal är thrown om empty
    Node bakPop()throws java.lang.IllegalStateException {

        if (isEmpty())

            throw new IllegalStateException("Empty List");
        else if(1 == this.listStorlek)

            return popSista() ;
        else {
            Node h = this.sista ;

            this.sista = this.sista.föregående ;
            this.första.föregående = this.sista ;

            this.sista.next = this.första ;
            h.next = h;
            h.föregående = h ;

            this.listStorlek-- ;

            System.out.println("Efter bakPop: " + this) ;

            return h ;

        } }
    //Tar bort sista noden i listan med return
    private Node popSista() {
        Node h = this.första ;
        this.första = null ;

        this.sista = null ;

        this.listStorlek--;

        System.out.println("Efter popSista: " + this) ;

        return h; }
    //Kollar om listan har komponenter, true om den är tom, false tvärtom. 
    //Return tar är boolean värdet
    boolean isEmpty() {
        return this.första == null ;

    }

    //returnerar storleken på listan
    int size(){
        return this.listStorlek;
    }
    //Returnerar en string som innehåller alla komponenter av listan
    public String toString() {

        StringBuilder sb = new StringBuilder() ;

        for (Item item: this )

            sb.append(item + " ") ;
        return sb.toString() ;
    }
    //En nod med en item i cirkulära listan

    private class Node{

        private Item item ;

        private Node next ;
        private Node föregående ;

        //Class konstruktör, item är den item som varje nod får
        private Node (Item item){

            this.item = item ;

            this.next = null ;
            this.föregående = null ;

        }}

    //Returnerar en generic iterator som itererar genom listan
    public Iterator<Item> iterator()
    {
        return new ListIterator() ;

    }

    //Iterator som gör listan itererbar.
    private class ListIterator implements Iterator<Item> {

        private Node nuvarande = första ;
        private int listPos = 0 ;


        //Returnerar true om första noden i listan inte är null. False tvärtom
        public boolean hasNext() {
            return this.listPos < listStorlek ;

        }

        //Itererar genom listan och gör noden till nuvarande i queuen.
        public Item next() {

            Item item = nuvarande.item ;

            nuvarande = nuvarande.next ;
            listPos++;
            return item;
        }}

}