package dojo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		int result = age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == other.age)
			return true;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("HashMap Examples:");
		System.out.println();
		HashMap<Integer, Person> personMap = new HashMap<>();
		personMap.put(1, new Person("Bela", 30));
		personMap.put(2, new Person("Jozsi", 20));
		personMap.put(3, new Person("Adorjan", 25));
		personMap.put(4, new Person("Elek", 27));
		personMap.put(5, new Person("Ond", 27));
		for (int i = 1; i <= personMap.size(); i++) {
			System.out.println(personMap.get(i));
		}
		System.out.println();
		System.out.println("Set Examples:");
		System.out.println();
		Set<Person> personSet = new HashSet<>();
		personSet.add(new Person("Bela", 30));
		personSet.add(new Person("Jozsi", 20));
		personSet.add(new Person("Adorjan", 25));
		personSet.add(new Person("Elek", 27));
		personSet.add(new Person("Ond", 27));
		personSet.add(new Person("Ond", 28));
		for (Person person : personSet) {
			System.out.println(person);
		}
	}

	@Override
	public String toString() {
		return name + " age:" + age;
	}
}
