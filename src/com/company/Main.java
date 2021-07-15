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

    }
}
