package com.dmitriy.lesson5;

import java.util.Comparator;

public class Person implements Comparable<Person>{

    private final String name;
    private final String surName;
    private final int age;
    private final Position position;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surName = builder.surName;
        this.age = builder.age;
        this.position = builder.position;

    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Position getPosition() {
        return position;
    }

    // compare 2 Person objects by name and surname
    @Override
    public int compareTo(Person p1){
        try {if (p1 == null)
            System.out.println("Input object is null.");} catch (NullPointerException e) {e.printStackTrace();}
        int comparedAge = p1.getAge();
        return this.age - comparedAge;
    }

    public static Comparator<Person> PersonComparator
            = new Comparator<Person>() {

        public int compare(Person person1, Person person2) {

//            try {if (person1 == null || person2 == null)
//                System.out.println("One or both of input objects is null: person1 is " + person1.toString() + " person2 is " + person2.toString());}
//            catch (NullPointerException e)
//            {e.printStackTrace();}

                String personName1 = person1.getName().toUpperCase();
                String personName2 = person2.getName().toUpperCase();
                String personSurName1 = person2.getSurName().toUpperCase();
                String personSurName2 = person2.getSurName().toUpperCase();

                //ascending order
                return personName1.compareTo(personName2) + personSurName1.compareTo(personSurName2);
        }

    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        if (position != person.position) return false;
        if (!surName.equals(person.surName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surName.hashCode();
        result = 31 * result + age;
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }

    public static class PersonBuilder{

        private String name;
        private String surName;
        private int age;
        private Position position;

        public PersonBuilder(){}

        public PersonBuilder(Person pers){
            this.name = pers.name;
            this.surName = pers.surName;
            this.age = pers.age;
            this.position = pers.position;
        }

        public PersonBuilder name(String name){
        this.name = name;
        return this;
    }

    public PersonBuilder surName(String surName){
        this.surName = surName;
        return this;
    }

    public PersonBuilder age(int age){
        this.age = age;
        return this;
    }

    public PersonBuilder position(Position position){
        this.position = position;
        return this;
    }

    public Person build(){
        return new Person(this);
    }

    }
}