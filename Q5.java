/*
Author: Melik Atabeyli
Koden skapar en linked queue som tillåter usern att addera ett komponent på första index i queuen och ta bort
komponent från vilken plats som helst i queuen. Listan genereras eller så kallad printas efter någon komponent
har blivit adderad eller borttagen.
 */
import java.util.Iterator;

//adderar komponenter i index 1 dvs. framför queuen
public class Q5<Item> implements Iterable<Item>{

    private Node första;
    private int queueStorlek;

    //hanterar alla metoder som kallas på och säkerställer att koden fungerar som den ska. 
    //args innehåller commandline argumenten som en array med String objekt
    public static void main(String[] args) {

        Q5<Integer> yolo = new Q5<>();

        yolo.Addera(43);
        yolo.Addera(-17);
        yolo.Addera(9);
        yolo.Addera(-5);
        yolo.Addera(101);
        yolo.Addera(2);
        yolo.Radera(1);
        yolo.Radera(5);
        yolo.Radera(4);
        yolo.Radera(2);
        yolo.Radera(1);
        yolo.Radera(1);

        try{
            yolo.Radera(3) ;
        } catch (IndexOutOfBoundsException b){

            System.out.println(b);
        }

        try{
            yolo.Radera(-16) ;

        } catch (IndexOutOfBoundsException b){
            System.out.println(b) ;

        } }

    //skapar empty queue
    Q5() {

        this.queueStorlek = 0 ;
    }

    //Adderar komponent dvs. item i fronten av queuen.
    void Addera(Item component) {

        Node i = new Node (component) ;

        if (isEmpty())
            this.första = i ;

        else {
            i.next = this.första ;

            this.första = i ; }
        this.queueStorlek++ ;

        System.out.println("Addera item: " + this) ;

    }

    //Raderar komponentet som är i plats av queuen
    private Item Radera(int plats) throws java.lang.IndexOutOfBoundsException {

        Node j;

        if(plats > getqueueStorlek() || plats < 1)
            throw new IndexOutOfBoundsException("Index " + plats + " existerar inte");
        else if (1 == plats){

            j = this.första;
            this.första = this.första.next;

            this.queueStorlek--;

            System.out.println("Radera item: " + this);
        }
        else{
            Node nuvarande = this.första.next ;

            Node föregående = this.första ;

            for (int i = 2; i < plats; i++) {

                nuvarande = nuvarande.next ;

                föregående = föregående.next ;

            }

            j = nuvarande;

            föregående.next = nuvarande.next ;

            j.next = null ;

            this.queueStorlek-- ;

            System.out.println("Radera item: " + this) ;        }
        return j.item; }

    //Checkar ifall queuen har något i sig, returnerar boolean true om den är tom, False om inte.
    boolean isEmpty(){
        return this.första == null ;
    }
    //returnerar storlek på queuen.
    int getqueueStorlek() {

        return this.queueStorlek ;

    }
    //Returnerar en string som innehåller alla komponenter av listan.
    public String toString(){

        StringBuilder sb = new StringBuilder() ;

        for(Item item: this)
            sb.append(item + " ") ;

        return sb.toString() ; }

    //En node som har en item i queuen.
    private class Node{

        private Item item;
        private Node next;

        //Item är den item varje node är given.
        private Node (Item item){

            this.item = item ;
            this.next = null ;
        }
    }
    //Returnerar en generic iterator som itererar genom nuvarande queue.
    public Iterator<Item> iterator() {

        return new ListIterator() ;
    }

    //Gör queuen itererbar
    private class ListIterator implements Iterator<Item> {

        private Node nuvarande = första ;


        public boolean hasNext() {

            return nuvarande != null;
        }
        //Itererar genom queuen och gör noden till nuvarande node
        public Item next()  {

            Item item = nuvarande.item ;

            nuvarande = nuvarande.next ;

            return item;

        }}
}