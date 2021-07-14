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
