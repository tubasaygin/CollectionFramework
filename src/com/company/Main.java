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

class Patient implements Comparable<Patient>{

	private String name;
	private String disease;
	private int priority;

	public Patient(String name, String disease) {
		this.name = name;
		this.disease = disease;
		if(this.disease.equals("appendicitis")){
			this.priority = 3;
		}else if(this.disease.equals("burn")){
			this.priority = 2;
		}else{
			this.priority = 1;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public int compareTo(Patient o) {
		if(this.priority>o.priority){
			return -1;
		}else if(this.priority < o.priority){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Patient{" +
				"name='" + name + '\'' +
				", disease='" + disease + '\'' +
				", priority=" + priority +
				'}';
	}
}

class IterableClass implements Iterable<String> {
	private ArrayList<String> channel_list = new ArrayList<>();

	public IterableClass(String[] channels){
		for(String channel : channels){
			System.out.println(channel);
		}
	}

	private int index = 0;

	@Override
	public Iterator<String> iterator() {
		return new IteratorRadio();
	}

	public class IteratorRadio implements java.util.Iterator<String>{

		@Override
		public boolean hasNext() {
			if(index<channel_list.size()){
				return true;
			}else{
				return false;
			}
		}

		@Override
		public String next() {
			String value = channel_list.get(index);
			index++;
			return value;
		}
	}
}


public class Main {

    public static void main(String[] args) throws InterruptedException {
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

		System.out.println("************************************************");
		//Vector:
		Vector<String> vect = new Vector<>();
		vect.add("Java");
		vect.add("Python");
		vect.add("Python");
		vect.add("C++");
		vect.add("Go");
		vect.add("Php");

		for(String s : vect){
			System.out.println(s);
		}
		//How else can we navigate the vector
		/*
		ListIterator<String> iterator = vect.listIterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		*/
		//How else can we navigate the vector 2
		/*
		Enumeration<String> enumeration = vect.elements();
		while (enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
	    */

		System.out.println("************************************************");
		//Stack:
		Stack<String> stack = new Stack<>();
		stack.push("Java");
		stack.push("Python");
		stack.push("C++");
		stack.push("Php");

		Enumeration<String> enumeration = stack.elements();
		while (enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
		System.out.println("Last element of stack : " + stack.peek()); // last element of stack
		System.out.println("Last element being deleted.. "+ stack.pop()); //remove last element

		for(String s : stack){
			System.out.println(s);
		}
		System.out.println("************************************************");
		//Polindrome word check program with using Stack.

		Stack<Character> word = new Stack<>();
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Please, input the word : ");
		String wordInput = scanner1.nextLine();

		for(int i = 0; i<wordInput.length(); i++){
			word.push(wordInput.charAt(i));
		}
		String wordCheck = "";

		while(word.size()>0){
			wordCheck  += word.pop();

		}
		if(wordInput.equals(wordCheck)){
			System.out.println("This word is a Polindrome.");
		}else{
			System.out.println("This word is not a Polindrome");
		}

		System.out.println("************************************************");
		//Queue :
		Queue<String> queue = new LinkedList<>();
		queue.offer("Java");
		queue.offer("Python");
		queue.offer("Php");
		queue.offer("C++");

		System.out.println("The first element of the queue : "+ queue.peek());

		for(String s: queue){
			System.out.println(s);
		}

		System.out.println("Element is removing .. " + queue.poll());
		//FIFO : First in First out.
		for(String s: queue){
			System.out.println(s);
		}

		System.out.println("************************************************");
		//Ramadan pita queue program using Queue
		Queue<String> pitaQueue = new LinkedList<>();
		pitaQueue.offer("Oliver");
		pitaQueue.offer("Jack");
		pitaQueue.offer("Harry");
		pitaQueue.offer("Jacob");
		pitaQueue.offer("Charlie");
		pitaQueue.offer("Thomas");
		pitaQueue.offer("George");
		pitaQueue.offer("Oscar");
		pitaQueue.offer("James");
		pitaQueue.offer("William");

		//Random number : [1-10]
		Random random = new Random();
		int number = random.nextInt(10) + 1;
		System.out.println("Pitas are being prepared...");
		Thread.sleep(3000);
		System.out.println("Pitas prepared ... : "+ number);
		while(number != 0){
			System.out.println(pitaQueue.poll() + " take a pita");
			number--;
			Thread.sleep(1000);
		}

		System.out.println("Pitas is finished.");


		System.out.println("************************************************");
		//PriorityQueue:
		Queue<Integer> pqueue = new PriorityQueue<>();

		pqueue.offer(200);
		pqueue.offer(4);
		pqueue.offer(1);
		pqueue.offer(10);
		pqueue.offer(0);

		for (Integer i : pqueue){
			System.out.println(i);
		}

		while (!pqueue.isEmpty()){
			System.out.println("Element is removing... "+ pqueue.poll());
		}

		//Object with priorityqueue:
		Queue<Player> playerpqueue = new PriorityQueue<>();
		playerpqueue.offer(new Player("Jack", 10));
		playerpqueue.offer(new Player("Oliver", 1));
		playerpqueue.offer(new Player("Jhonson", 200));
		playerpqueue.offer(new Player("Harry" , 2));

		while(!playerpqueue.isEmpty()){
			System.out.println("Element is removing ... : "+ playerpqueue.poll());
		}

		//Emergency service application with Comparable Interface
		/*
		appendicitis : highest priority
		burn : medium priority
		headache : lowest priority
		 */
		Queue<Patient> patientQueue = new PriorityQueue<>();
		patientQueue.offer(new Patient("Jack Glory" , "appendicitis"));
		patientQueue.offer(new Patient("Harry P." , "burn"));
		patientQueue.offer(new Patient("Oliver" , "headache"));
		patientQueue.offer(new Patient("Mary" , "appendicitis"));
		patientQueue.offer(new Patient("Allison" , "headache"));
		patientQueue.offer(new Patient("Jackson" , "burn"));
		patientQueue.offer(new Patient("Jim" , "appendicitis"));

		int i = 1;
		while(!patientQueue.isEmpty()){
			System.out.println(i + ". patient : " + patientQueue.poll());
			i++;
		}

		System.out.println("************************************************");
		//Creating our own iterable class:
		String[] channels = {"Radio Viva","Radio Fenomen", "Radyo Kral", "Kral Pop"};

		IterableClass radio = new IterableClass(channels);
		for(String s: radio) {
			System.out.println(s);
		}

	}
}
