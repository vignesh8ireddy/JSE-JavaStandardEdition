import java.util.*;


//java was introduced in 1995 in alpha and beta version
// and officially in 1996 java 1.0 was introduced as open source

//Joshua came up with an API called Collection to overcome problems with Arrays
//collection API is present in java.util package
//Collection is a set of Interfaces and Classes
//Collection framework has 7 classes (ArrayList, LinkedList, ArrayDequeue, PriorityQueue, HashSet, LinkedHashset, TreeSet)

//Every data in non generic collection is stored as Object type.

//Iterable is the parent Interface of all collection classes and interfaces
//To access collection elements we use iterator for efficiency
//When you use primitive data types in collection they are converted to Object types by autoboxing

public class C20Collections {

    public static void main(String[] args) {
    	/*

		 Java Collection is a framework that provides an architecture to store,
		 manipulate and perform all sort of operations on the group of Objects.

		 Java Collection :

		 Interfaces: (List, Set, Deque-->Queue) and (SortedMap-->Map)
		 Classes (ArrayList, LinkedList, HashSet, LinkedHashSet, TreeSet, ArrayDeque,
		 PriorityQueue) and (HashMap, LinkedHashMap, TreeMap)

		 */




        //new CArrayList().arrayListDemo();
        new CHashMap().hashMapDemo();
    }

}

class CArrayList {


	/*
	 * ArrayList Key Points:

	 > Uses Dynamic Array data structure internally (size is flexible)
	 > Stores Heterogeneous data and obviously homogeneous data
	 > maintains the insertion order internally.
	 > Indexed Based: random access is allowed
	 > It inherits the AbstractList class and implements List interface.
	 > Can contain duplicate elements.
	 > Java ArrayList class is non synchronized.
	 > Requires contiguous memory
	 > Array is more faster and efficient than ArrayList
	 > Index Based Insertion is possible in ArrayList but not recommended because of time
	   complexity issues due to shifting; Solution: LinkedList
	 > Manipulation is a little bit slower than the LinkedList in Java because a lot of
	   shifting needs to occur if any element is removed from the array list.

	 */


    public void arrayListDemo() {

        /*
         * Constructor
         *
         * ArrayList()
         * ArrayList(Collection<? extends E> c)
         * ArrayList(int capacity)




         * ArrayList Methods:
         *
         * boolean add(E e)
         * void add(int index, E element)
         * boolean addAll(Collection<? extends E> c)
         * boolean addAll(int index, Collection<? extends E> c)
         * E get(int index)
         * E set(int index, E element) : used to replace
         * boolean isEmpty()
         * void clear()
         * boolean contains(Object o)
         * int size()
         * int indexOf(Object o) : returns first occurrence index or -1
         * int lastIndexOf(Object o) : returns last occurrence index or -1
         * E remove(int index)
         * boolean remove(Object o) : removies first occurrence of o
         * boolean removeAll(Collection<?> c)
         * protected void removeRange(int fromIndex, int toIndex)
         * void sort(Comparator<? super E> c) // Collections.sort(ALObj)
         * ListIterator listIterator(int index)
         * iterator()
         * Object[] toArray()
         * <T> T[] toArray(T[] a)
         */


        ArrayList ALObj = new ArrayList();// a non-generic empty ArrayList
        ALObj.add(Integer.valueOf(12));
        ALObj.add(Double.valueOf(150.23));
        ALObj.add(Character.valueOf('O'));
        ALObj.add(Boolean.valueOf("Math"));//false
        ALObj.add("Siddhu");
        System.out.println(ALObj);//[12, 150.23, O, false, Siddhu]

        ArrayList ALObj2 = new ArrayList();

        ALObj2.add(Short.valueOf((short)81));
        ALObj2.add(Boolean.valueOf("TrUe"));
        ALObj2.add(Character.valueOf('S'));
        ALObj2.add("Sujatha");
        System.out.println(ALObj2);//[81, true, S, Sujatha]

        ALObj.addAll(ALObj2);
        System.out.println(ALObj);//[12, 150.23, O, false, Siddhu, 81, true, S, Sujatha]

        ALObj.add(ALObj2);
        System.out.println(ALObj);//[12, 150.23, O, false, Siddhu, 81, true, S, Sujatha, [81, true, S, Sujatha]]


        for(Object o:ALObj2) {//using for-each loop to traverse ArrayList
            System.out.println(o);
        }


        Iterator IterObj = ALObj.iterator();
        while(IterObj.hasNext()) {//using Iterator
            System.out.println(IterObj.next());
        }


        ListIterator LIterObj = ALObj.listIterator(ALObj.size());
        while(LIterObj.hasPrevious()) {
            System.out.println(LIterObj.previous());
        }


    }


}


class CLinkedList {

	/*
	 * LinkedList Key Points:

	 > Uses Doubly linked list data structure internally
	 > Stores Heterogeneous data and obviously homogeneous data
	 > maintains the insertion order internally.
	 > Random access is not supported, though you can get elements using index, internally gets them sequentially
	 > It inherits the AbstractSequentialList class and implements List and Deque interfaces.
	 > Can contain duplicate elements.
	 > Java LinkedList class is non synchronized.
	 > Does not require contiguous memory
	 > Can be used as list, stack and queue data structures
	 > Manipulation is a faster than the java ArrayList because no shifting needs to occur if any element
	   is removed from the array list.

	 */


    public void linkedListDemo() {

        /*
         * Constructor
         *
         * LinkedList()
         * LinkedList(Collection<? extends E> c)



         * LinkedList Methods:
         *
         * boolean add(E e)
         * void add(int index, E element)
         * boolean addAll(Collection<? extends E> c)
         * boolean addAll(int index, Collection<? extends E> c)
         * void addFirst(E e)
         * void addLast(E e)
         * E get(int index)
         * E getFirst()
         * E getLast()
         * E set(int index, E element) : used to replace
         * boolean isEmpty()
         * void clear()
         * boolean contains(Object o)
         * int size()
         * int indexOf(Object o) : returns first occurrence index or -1
         * int lastIndexOf(Object o) : returns last occurrence index or -1
         * E remove(int index)
         * E removeFirst()
         * E removeLast()
         * boolean remove(Object o) : removies first occurrence of o
         * boolean removeAll(Collection<?> c)
         * protected void removeRange(int fromIndex, int toIndex)
         * ListIterator listIterator(int index)
         * iterator()
         * Object[] toArray()
         * <T> T[] toArray(T[] a)
         */



    }

}


	/*
	 * When the rate of addition or removal rate is more than the read scenarios, then go
	   for the LinkedList. On the other hand, when the frequency of the read scenarios is
	   more than the addition or removal rate, then ArrayList takes precedence over LinkedList.
	 * Since the elements of an ArrayList are stored more compact as compared to a LinkedList;
	   therefore, the ArrayList is more cache-friendly as compared to the LinkedList. Thus, chances
	   for the cache miss are less in an ArrayList as compared to a LinkedList. Generally, it is
	   considered that a LinkedList is poor in cache-locality.
	 * Memory overhead in the LinkedList is more as compared to the ArrayList. It is because, in a
	   LinkedList, we have two extra links (next and previous) as it is required to store the address
	   of the previous and the next nodes, and these links consume extra space. Such links are not
	   present in an ArrayList.
	 * The Vector class is deprecated since Java 5.

	 */


class CHashSet {

	/*
	 * HashSet Key Points:

	 > Uses Hash table data structure internally
	 > does not maintains the insertion order, uses hashcode for insertion
	 > Contains only unique elements and can have one null value
	 > HashSet class extends AbstractSet class which implements Set interface.
	 > Best for searching (time complexity is O(1))
	 > Java HashSet class is non synchronized.
	 > The initial default capacity of HashSet is 16, and the load factor is 0.75.


	 */


    public void hashSetDemo() {

		/*
		 * Constructor
		 *
		 * HashSet()
		 * HashSet(int capacity)
		 * HashSet(int capacity, float loadFactor)
		 * HashSet(Collection<? extends E> c)



		 * HashSet Methods:
		 *
		 * boolean add(E e)
		 * boolean isEmpty()
		 * void clear()
		 * boolean contains(Object o)
		 * int size()
		 * boolean remove(Object o)
		 * boolean removeAll(Collection<?> c)
		 * iterator()
		 * Spliterator<E> spliterator() : It is used to create a late-binding and
		   fail-fast Spliterator over the elements in the set.
		 */



    }

}


class CLinkedHashSet {

	/*
	 * LinkedHashSet Key Points:

	 > Uses Hash table data structure internally
	 > Maintains the insertion order
	 > Contains only unique elements and can have one null value
	 > LinkedHashSet class extends HashSet class which extends AbstractSet class which implements Set interface.
	 > Best for searching (time complexity is O(1))
	 > Java LinkedHashSet class is non synchronized.
	 > The initial default capacity of HashSet is 16, and the load factor is 0.75.


	 */


    public void linkedHashSetDemo() {

		/*
		 * Constructor
		 *
		 * LinkedHashSet()
		 * LinkedHashSet(int capacity)
		 * LinkedHashSet(int capacity, float fillRatio)
		 * LinkedHashSet(Collection<? extends E> c)



		 * LinkedHashSet Methods:
		 *
		 * boolean add(E e)
		 * boolean isEmpty()
		 * void clear()
		 * boolean contains(Object o)
		 * int size()
		 * boolean remove(Object o)
		 * boolean removeAll(Collection<?> c)
		 * iterator()
		 * Spliterator<E> spliterator() : It is used to create a late-binding and
		   fail-fast Spliterator over the elements in the set.
		 */



    }

}

class CTreeSet {

	/*
	 * TreeSet Key Points:

	 > Uses balanced BST and Red-Black internally
	 > Does not maintain the insertion order, objects inserted are in ascending order.
	 > Contains only unique elements and cannot have one null value
	 > TreeSet class extends AbstractSet class and implements NavigableSet interface.
	 > Best for searching (time complexity is O(ogN))
	 > Java TreeSet class is non synchronized.
	 > The initial default capacity of HashSet is 16, and the load factor is 0.75.
	 > The TreeSet can only allow those generic types that are comparable. For example
	   the Comparable interface is being implemented by the StringBuffer class.

	 */


    public void treeSetDemo() {

		/*
		 * Constructor
		 *
		 * TreeSet()
		 * TreeSet(Collection<? extends E> c)
		 * TreeSet(Comparator<? super E> comparator)
		 * TreeSet(SortedSet<E> s)



		 * TreeSet Methods:
		 *
		 * boolean add(E e)
		 * boolean addAll(Collection<? extends E> c)
		 * E ceiling(E e)
		 * E floor(E e) : It returns the equal or closest least element of the
		   specified element from the set, or null there is no such element.
		 * E higher(E e)
		 * E lower(E e) : It returns the closest least element of the specified
		   element from the set, or null there is no such element.
		 * boolean isEmpty()
		 * void clear()
		 * boolean contains(Object o)
		 * int size()
		 * boolean remove(Object o)
		 * iterator()
		 * Iterator descendingIterator()
		 * Spliterator spliterator()
		 * E first()
		 * E last()
		 */



    }

}



//ArrayDeque and PriorityQueue are Pending

/*
ArrayDeque
------------------

internal datastructure used : Double ended Queue i.e Dequeue

ArrayDeque implements only one interface which is Deque--->Queue

indexed based accessing is not allowed but you can add Objects at first and last

Duplicates are allowed


PriorityQueue
----------------

Uses internally priority queue which is implemented by min heap

order of insertion is not maintained; irrespective of insertion order, it builds min heap with the Objects you inserted

always go with priority queue only when you want highest priority element in the starting position

duplicates are allowed

PriorityQueue class implements Queue interface

you cannot access using index, first, last, middle. only according to priority i.e acc. to min heap order

*/

class CHashMap {

	/*
	 * HashMap Key Points:

	 > Uses hash table internally
	 > Does not maintain the insertion order.
	 > Contains only unique keys and can have one null key and multiple null values
	 > HashMap class extends AbstractMap class and implements Map interface.
	 > Java HashMap class is non synchronized.
	 > The initial default capacity of HashSet is 16, and the load factor is 0.75.
	 > If you try to insert the duplicate key, it will replace the element of the corresponding key.


	 */


    public void hashMapDemo() {

		/*
		 * Constructor
		 *
		 * HashMap()
		 * HashMap(Map<? extends K,? extends V> m)
		 * HashMap(int capacity)
		 * HashMap(int capacity, float loadFactor)



		 * HashMap Methods:
		 *
		 * void put(Object key, Object value)
		 * void putAll(Map map)
		 * void putIfAbsent(K key, V value)
		 * V get(Object key)
		 * V getOrDefault(Object key, V defaultValue)
		 * boolean isEmpty()
		 * void clear()
		 * boolean containsKey(Object o)
		 * boolean containsValue(Object o)
		 * Set entrySet()
		 * Set keySet()
		 * Collection<V> values()
		 * int size()
		 * boolean remove(Object key) : removes key and its value
		 * iterator()

		 * Map.Entry interface contains the getKey() and getValue() methods. Call the entrySet()
		   method of Map interface to get the instance of Map.Entry.
		 */

        HashMap HMObj = new HashMap();
        HMObj.put(Integer.valueOf(101), "Kranthi");
        HMObj.put(Integer.valueOf(102), "Naveen");
        HMObj.put(Integer.valueOf(103), "Revanth");
        HMObj.put(Integer.valueOf(104), "Sagar");

        System.out.println(HMObj);//{101=Kranthi, 102=Naveen, 103=Revanth, 104=Sagar}


        Set EObj = HMObj.entrySet();
        System.out.println(EObj);//{101=Kranthi, 102=Naveen, 103=Revanth, 104=Sagar}

		/*
		for(Map.entry<Integer, String> E: HMObj.entrySet()) {
			System.out.println(E.getKey()+" : "+E.getValue());
		}//Error Code Snippet; Why? -> not type safety
		*/

        for(Object E: HMObj.entrySet()) {
            System.out.println(E);
        }

        HashMap<Integer,String> HMObj2 = new HashMap<Integer,String>();
        HMObj2.put(Integer.valueOf(101), "Sujatha");
        HMObj2.put(Integer.valueOf(102), "Srinivas");
        HMObj2.put(Integer.valueOf(103), "Siddhu");
        HMObj2.put(Integer.valueOf(104), "Vignesh");

        for(Map.Entry<Integer,String> entryObj:HMObj2.entrySet()) {
            System.out.println(entryObj.getKey()+" : "+entryObj.getValue());
        }



    }

}


class CLinkedHashMap {

	/*
	 * LinkedHashMap Key Points

	 > Uses hash table and linked list internally
	 > Maintains the insertion order.
	 > Contains only unique keys and can have one null key and multiple null values
	 > LinkedHashMap class extends HashMap->AbstractMap class and implements Map interface.
	 > Java HashMap class is non synchronized.
	 > The initial default capacity of HashSet is 16, and the load factor is 0.75.
	 > If you try to insert the duplicate key, it will replace the element of the corresponding key.


	 */


    public void hashMapDemo() {

		/*
		 * Constructor
		 *
		 * LinkedHashMap()
		 * LinkedHashMap(int capacity)
		 * LinkedHashMap(int capacity, float loadFactor)
		 * LinkedHashMap(int capacity, float loadFactor, boolean accessOrder)
		 * LinkedHashMap(Map<? extends K,? extends V> m)



		 * HashMap Methods:
		 *
		 * void put(Object key, Object value)
		 * void putAll(Map map)
		 * void putIfAbsent(K key, V value)
		 * V get(Object key)
		 * V getOrDefault(Object key, V defaultValue)
		 * boolean isEmpty()
		 * void clear()
		 * boolean containsKey(Object o)
		 * boolean containsValue(Object o)
		 * Set entrySet()
		 * Set keySet()
		 * Collection<V> values()
		 * int size()
		 * boolean remove(Object key) : removes key and its value
		 * iterator()

		 * Map.Entry interface contains the getKey() and getValue() methods. Call the entrySet()
		   method of Map interface to get the instance of Map.Entry.
		 */

    }

}

//TreeMap is pending


//descendingIterator() method of LinkedList, ArrayDeque and TreeSet

/*

	failsafe process vs failfast process
	------------------------------------

	structural modification = adding data while access data in collection ; it is not failfast
	structural modification leads to never ending loop as you are keep on adding data to collection, hasNext() never false

	use iterator in the above case to make it failfast. using iterator throws exception if you do structural modification

	CopyOnWriteArrayList class of java.util.concurrent package to make structural modification as failsafe

	failfast = doesnot allow concurrent/structural modification by throwing exception while compiling
	failsafe = does not allow concurrent/structural modification without any exception
	failsafe cannot be achived with ArrayList class; only with CopyOnWriteArrayList class


*/


/*

Vector class, Stack class and Dictionary class are called legacy classes of java which implement Enumeration interface
All the methods of these classes are synchronized: so no multi-threading here


Enumerator is same like Iterator, but to access data of legacy classes just like using Iterator for Iterable interfaces

Note : Enum is different from Enumeration in java

primitives, wrapper objects and enum are allowed in switch case statements
*/
