/**
 * Generisk klasse som lagrer en mengde elementer av typen angitt av <code>&lt;E&gt;</code>
 * @author Adrian &Oslash;deby Helvik
 */
public class Mengde<E> {
    

    // Private properties

    private Node first;
    

    // Constructors
    
    /**
     * Oppretter en ny tom mengde
     */
    public Mengde () { }
    
    /**
     * Lag en mengde med ett element av typen <code>E</code>
     * @param e Elementet som legges til
     */
    public Mengde (E e) {
        // Add first
        this.first = new Node(e);
    }


    // Private methods
    
    /**
     * Prints out Objects passed to it
     * @param args Takes a variable number of objects
     */
    private static void sopl(Object... args) {
        if (args.length == 0) System.out.println();
        else for (Object o : args) System.out.println(o);
    }

    // Public methods
    
    /**
     * Sjekker om Mengden er tom
     * @return Om mengden er tom
     */
    public boolean tom() {
        return first == null;
    }
    
    /**
     * Legger til et element i mengden dersom
     * mengden ikke allerede inneholder elementet
     *
     * @param e Elementet som skal legges til
     * @return Om elementet ble lagt til
     */
    public boolean leggTil(E e) {
        
        // Ikke legg til hvis elementet finnes fra foer
        if (inneholder(e)) return false;
        
        // Legg til elementet
        Node elem = new Node(e);
        Node tmp = first;
        first = elem;
        first.next = tmp;
        
        return true;
    }
    
    /**
     * Fjern det eldste elementet i mengden
     * @return Elementet som ble fjernet
     */
    public E fjernEldste() {
        sopl("Fjerner eldste...");
        
        // If no element
        if (first == null) return null;
        
        // If only one element
        if (first.next == null) {
            E data = first.data;
            first = null;
            return data;
        }
        
        // Store first for iteration
        Node n = first;
        
        // Go to second last element
        while (n.next.next != null) n = n.next;
        
        // Fetch data
        E data = n.next.data;
        
        // Remove
        n.next = null;
        
        return data;
    }
    
    /**
     * Fjern det nyeste elementet i mengden
     * @return Elementet som ble fjernet
     */
    public E fjernNyeste() {
        
        // If nothing at all in list return null
        if (first == null) return null;
        
        // Otherwise we will need the data
        E data = first.data;
        
        if (first.next == null) {
            first = null;
            return data;
        }

        else {
            first = first.next;
            return data;
        }
    }
    
    /**
     * Tester ved pekerlikhet om mengden inneholder et gitt element
     * @param e Elementet som sjekkes om mengden inneholder
     * @return Om mengden inneholder elementet
     */
    public boolean inneholder(E e) {
        Node n = first;
        while (n != null) {
            // Test if element is within node
            if (e == n.data) return true;
            // Go to next element;
            n = n.next;
        }
        return false;
    }
    
    // Supplementary public method:
    //
    // Because inneholder() checks if two
    // pointers point to the same instance
    // and not wether one element equals
    // the other, I decided to make a
    // method called inneholderTilsvarende

    /**
     * Tester ved om mengden inneholder et likt element
     * (ikke n&oslash;dvendigvis med den samme pekeren)
     *
     * @param e Elementet som sjekkes om mengden inneholder
     * @return Om mengden inneholder elementet
     */
    public boolean inneholderTilsvarende(E e) {
        Node n = first;
        while (n != null) {
            // Test if element is within node
            if (e.equals(n.data)) return true;
            // Go to next element;
            n = n.next;
        }
        return false;
    }


    // Private classes
    
    private class Node {
        Node next;
        E data;

        Node(E e) {
            data = e;
        }
    }
}
