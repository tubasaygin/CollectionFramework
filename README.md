# CollectionFramework
The Collection in Java is a framework that provides an architecture to store and manipulate the group of objects.


What is hasCode() and equals() ? 

First, let's examine the code below: 

    Person p1 = new Person(12345L, "Tuba", "Saygın");
    Person p2 = new Person(12345L, "Tuba", "Saygın");
    Person p3 = new Person(12345L, "Tuba", "Saygın");
    
    Map<Person, String> liste = new HashMap<>();
    liste.put(p1, "TUBA");
    liste.put(p2, "TUBA");
    liste.put(p3, "TUBA");
    
    System.out.println(liste.size());

When the above line of code is run, its size will appear as 3. Because, hashCode() is not defined. Now, let's define hashCode() and equals() method in the Person class.

     @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()){
             return false;
         }
         Person person = (Person) o;
         return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
     }
    
     @Override
     public int hashCode() {
         return id.hashCode();
     }

When the above line of code is run, its size will appear as 1. So, we don't add the same values. 

In summary, when we create a hashMap, if we send values such as String, Integer, Java understands this. But when we send an object, we need to override the hashCode() and equals() methods back to our class.

---

Note: We can also create these two functions in a short way using Generate.

---

Note: If we don't write the equals function but only the hashCode function, our code will still work incorrectly.

---

```
//How to print map elements:
for(Map.Entry<Character, Integer> entry : frequence.entrySet()){
	System.out.println("Character : "+entry.getKey() + " ----> " + entry.getValue());
}
```

The Comparable Interface:

The Comparable interface defines the compareTo method used to compare objects. If a class implements the Comparable interface, objects created from that class can be sorted using Java's sorting algorithms

In order for our object lists  to be sorted, that is, to use the Collections.sort() method, we need to implement the Comparable:

    class Player implements Comparable<Player>{
    	private String name;
    	private int id;
    
    	public Player(String name, int id) {
    		this.name = name;
    		this.id = id;
    	}
    
    	@Override
    	public String toString() {
    		return "Player{" +
    				"name='" + name + '\'' +
    				", id=" + id +
    				'}';
    	}
    
    	@Override
    	public int compareTo(Player o) {
    		if(this.id < o.id){
    			return -1;
    		}else if(this.id > o.id){
    			return 1;
    		}
    		return 0;
    
    	}
    }
    

Note : If we want to get data sorted without using Comparable, we can use TreeSet.

TreeSet:

- TreeSet cannot contain duplicate
- The elements in a TreeSet are sorted based on their natural order, or based on a custom Comparator that is supplied at the time of creation of the TreeSet.
- TreeSet cannot contain null value.
- TreeSet internally uses a TreeMap to store elements.
- TreeSet class is not thread-safe. You must explicitly synchronize concurrent access to a TreeSet in a multi-threaded environment.

Comparator Interface:

Unlike Comparable, Comparator is external to the element type we are comparing. It’s a separate class. We create multiple separate classes (that implement Comparator) to compare by different members.

Collections class has a second sort() method and it takes Comparator. The sort() method invokes the compare() to sort objects.

To compare movies by Rating, we need to do 3 things : 

1. Create a class that implements Comparator (and thus the compare() method that does the work previously done by compareTo()).
2. Make an instance of the Comparator class.
3. Call the overloaded sort() method, giving it both the list and the instance of the class that implements Comparator.

Vector:

Vector is like the dynamic array which can grow or shrink its size. Unlike array, we can store n-number of elements in it as there is no size limit. It is a part of Java Collection framework since Java 1.2. It is found in the java.util package and implements the List interface, so we can use all the methods of List interface here.

It is recommended to use the Vector class in the thread-safe implementation only. If you don't need to use the thread-safe implementation, you should use the ArrayList, the ArrayList will perform better in such case.

The Iterators returned by the Vector class are fail-fast. In case of concurrent modification, it fails and throws the ConcurrentModificationException.

Ways to navigate on vector

    //simple method:
    for(String s : vect){
       System.out.println(s);
    }
    
    //How else can we navigate the vector
    ListIterator<String> iterator = vect.listIterator();
    while (iterator.hasNext()){
       System.out.println(iterator.next());
    }
    
    //How else can we navigate the vector 2
    Enumeration<String> enumeration = vect.elements();
    while (enumeration.hasMoreElements()){
       System.out.println(enumeration.nextElement());
    }



Stack:

- The vector class is a superclass of the stack class. 
- Stack data is a data type represented by the LIFO(Last in First Out) structure.
- empty() Checks if the Stack is empty.
- search() The location of the value given as a parameter by the method * (with reference to the starting point from top to bottom) is returned as *integer.
- pop() It takes the value at the top of the stack and returns it.
- peek() reads at the top of the stack but does not retrieve it from the stack.


