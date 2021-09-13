/*
Author: Melik Atabeyli
A double linked iterable FIFO-queue is created. The nodes are pointing to the next and the föregående item that is in the list of it.
Elements are added to the end or said last position in the queue, later on it removes the elements that are in the first position in the queue.
 */
import java.util.Iterator ;

// A double linked FIFO Queue which is iterable
public class Q3<Item> implements Iterable<Item>  {

    private Node first ;
    private Node last ;

    private int size ;

    /*
    Here we have the unit tests that uses the method calls. Mostly where it is run to ensure that the code is working
     */
    public static void main(String[] args) {

        Q3 <String> yolo = new Q3<>();

        System.out.println("Nämen nu kör vi hej och hå skål!\n");
        try {
            System.out.println("Dequeue item: " + yolo.dequeue().item);
        }catch (IllegalStateException e){
            System.out.println(e);
        }

        System.out.println("Empty test: " + yolo.isEmpty()) ;
        System.out.println("Storlek: " + yolo.size()) ;

        System.out.println();

        yolo.enqueue("[Första]");
        System.out.println("Empty test: " + yolo.isEmpty()) ;
        System.out.println("Storlek: " + yolo.size()) ;
        System.out.println("Första item: " + yolo.first.item) ;
        System.out.println("Sista item: " + yolo.last.item) ;

        System.out.println();

        yolo.enqueue("[Andra]");
        System.out.println("Empty test: " + yolo.isEmpty()) ;
        System.out.println("Storlek: " + yolo.size()) ;
        System.out.println("Första item: " + yolo.first.item) ;
        System.out.println ("Sista item: " + yolo.last.item) ;
        System.out.println("Första item next: " + yolo.first.next.item) ;
        System.out.println ("Sista item föregående: " + yolo.last.föregående.item);

        System.out.println();

        yolo.enqueue("[Tredje]");
        System.out.println("Empty test: " + yolo.isEmpty()) ;
        System.out.println("Storlek: " + yolo.size());
        System.out.println ("Första item: " + yolo.first.item);
        System.out.println("Sista item: " + yolo.last.item);
        System.out.println ("Första item next: " + yolo.first.next.item) ;
        System.out.println("Sista item föregående: " + yolo.last.föregående.item) ;


        System.out.println();

        System.out.println("Dequeue item: " + yolo.dequeue().item);
        System.out.println ("Storlek: " + yolo.size()) ;
        System.out.println("Första item: " + yolo.first.item) ;
        System.out.println ("Sista item: " + yolo.last.item);
        System.out.println("Första item next: " + yolo.first.next.item) ;
        System.out.println("Sista item föregående: " + yolo.last.föregående.item);


        System.out.println();

        System.out.println("Dequeue item: " + yolo.dequeue().item);
        System.out.println("Storlek: " + yolo.size()) ;
        System.out.println ("Första item: " + yolo.first.item) ;
        System.out.println("Sista item: " + yolo.last.item);

        System.out.println();

        System.out.println("Dequeue item: " + yolo.dequeue().item) ;
        System.out.println("Storlek: " + yolo.size()) ;
        System.out.println("empty test: " + yolo.isEmpty()) ;

        try{
            System.out.println("Dequeue item: " + yolo.dequeue()) ;
        }
        catch (IllegalStateException e ){

            System.out.println(e) ;

        } }

    // Empty queue constructor
    Q3(){
        this.size = 0;
    }
    // A new item is being added to the last position of the queue, component is the item here
    void enqueue (Item component ) {

        Node t = new Node(component) ;

        if (isEmpty()) {

            this.first = t ;
            this.last = t ;
        }
        else
        {
            this.last.next = t ;

            t.föregående = this.last ;
            this.last = t ;
        }

        System.out.println("Efter Enqueue: " + this.toString()) ;
        this.size++;
    }

    // The Första item that was added from the queue is removed via the return statement. Exception is if queue is empty
    Node dequeue()throws java.lang.IllegalStateException{

        if (isEmpty())
            throw new java.lang.IllegalStateException("The queue is empty");
        else if (1 == this.size){

            Node t = this.first ;

            this.first = null ;

            this.size-- ;
            System.out.println("Efter Dequeue: " + this.toString());

            return t;
        }
        else {
            Node t = this.first;

            this.first = this.first.next;
            this.first.föregående = null;

            t.next = null;
            t.föregående = null;

            this.size--;
            System.out.println("Efter Dequeue: " + this.toString());

            return t;
        } }
    //String containing all the components of the queue is returned
    public String toString(){

        StringBuilder sb = new StringBuilder() ;

        for(Item item: this)

            sb.append(item + " ") ;

        return sb.toString() ;
    }
    //Sees if queue has components. True is returned if there is none and False vice versa.
    //The boolean value is stored in the return parameter
    boolean isEmpty(){
        return this.first == null ;
    }

    //Size of the nuvarande queue where return determines the size
    int size(){
        return this.size ;
    }
    //This is a node having an item of the FIFO-queue.
    private class Node{

        private Item item ;

        private Node next ;

        private Node föregående;
        //constructor of Class where items is the item that is given to a new/each node.
        private Node (Item item){

            this.item = item ;

            this.next = null ;
            this.föregående = null ;
        }}
    //Basic iterator that does its job which is iterating through the queue.
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    //This makes the queue iterable
    private class ListIterator implements Iterator<Item> {

        private Node nuvarande = first;
        //True if the list that contains the first node is not null.
        //It gives false if the node is empty and doesnt have 1 or 2 nodes
        public boolean hasNext(){
            return this.nuvarande != null;
        }

        //This is where it makes the next coming node the nuvarande one of the
        //queue where return represents the item of the nuvarande node
        public Item next() {

            Item item = nuvarande.item ;

            nuvarande = nuvarande.next ;

            return item;
        }}
}