package com.company;

import java.util.*;

class Person{
	private Long id;
	private String name;
	private String surname;

	public Person(long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname);
	}
}

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

class ComparatorExample implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2);  //Sort from largest to smallest

	}
}

public class Main {

    public static void main(String[] args) {
		// Object In Map
		Person p1 = new Person(12345L, "Tuba", "Saygın");
		Person p2 = new Person(12345L, "Tuba", "Saygın");
		Person p3 = new Person(12345L, "Tuba", "Saygın");

		Map<Person, String> liste = new HashMap<>();
		liste.put(p1, "TUBA");
		liste.put(p2, "TUBA");
		liste.put(p3, "TUBA");

		System.out.println(liste.size());
		System.out.println("************************************************");
		//finding the letter count of a sentence using Map:
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sentence : ");
		String sentence = scanner.nextLine();

		Map<Character, Integer> frequence = new TreeMap<>();

		for(int i = 0; i<sentence.length(); i++){
			char c = sentence.charAt(i);
			if(frequence.containsKey(c)){
				frequence.replace(c, (frequence.get(c) + 1));
			}else{
				frequence.put(c,1);
			}

		}
		//How to print map elements:
		for(Map.Entry<Character, Integer> entry : frequence.entrySet()){
			System.out.println("Character : "+entry.getKey() + " ----> " + entry.getValue());
		}


		System.out.println("************************************************");
		//Sorting list :

		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("Python");
		list.add("C++");
		list.add("Go");
		list.add("Php");

		Collections.sort(list);

		for(String s : list){
			System.out.println(s);
		}

		System.out.println("************************************************");

		List<Player> listPlayer = new ArrayList<>();
		listPlayer.add(new Player("Tuba", 5));
		listPlayer.add(new Player("Ahmet", 1));
		listPlayer.add(new Player("Gamze", 12));
		listPlayer.add(new Player("Melek", 2));

		Collections.sort(listPlayer);
		for(Player s: listPlayer){
			System.out.println(s);
		}

		System.out.println("************************************************");
		//Comparator :
		List<String> listComp = new ArrayList<>();

		listComp.add("Java");
		listComp.add("Python");
		listComp.add("C++");
		listComp.add("Go");
		listComp.add("Php");

		Collections.sort(listComp, new ComparatorExample());
		for(String s : listComp){
			System.out.println(s);
		}
	}
}
