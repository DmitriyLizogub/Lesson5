package com.dmitriy.lesson5;

import java.util.Arrays;

/**
 * Created by dmitriy on 7/1/14.
 */
public class Main {

    public static void main(String[] args) {

        PersonMergeHelperImpl personMergeHelper = new PersonMergeHelperImpl();
        PersonMergeHelperDelegate delegate = new PersonMergeHelperDelegate(personMergeHelper);

        Person person1 = new Person.PersonBuilder().surName("Dudov").name("John").position(Position.BA).age(33).build();
        Person person2 = new Person.PersonBuilder().position(Position.DEVELOPER).age(42).surName("Floyd").name("Dick").build();
        Person person3 = new Person.PersonBuilder().age(39).name("Mike").surName("Shultz").position(Position.DIRECTOR).build();
        Person person4 = new Person.PersonBuilder().name("Troy").surName("Caster").position(Position.QA).age(27).build();

        Person[] firstArray = new Person[]{person1,person2,person3};
        Person[] secondArray = new Person[]{person1,person4,person2};

        delegate.merge(firstArray, secondArray);

        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        System.out.println(Arrays.toString(delegate.merge(firstArray, secondArray)));

    }
}
