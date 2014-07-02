package com.dmitriy.lesson5;

import org.junit.Assert;
import org.junit.Test;

public class PersonDelegateTest {//Ctrl+Shift+T create test class

    @Test
    public void testPersonDelegate_PositiveCase (){
        //initialize variable inputs

        Person person1 = new Person.PersonBuilder().surName("Dudov").name("John").position(Position.BA).age(33).build();
        Person person2 = new Person.PersonBuilder().position(Position.DEVELOPER).age(42).surName("Floyd").name("Dick").build();
        Person person3 = new Person.PersonBuilder().age(39).name("Mike").surName("Shultz").position(Position.DIRECTOR).build();
        Person person4 = new Person.PersonBuilder().name("Troy").surName("Caster").position(Position.QA).age(27).build();

        Person[] firstArray = new Person[]{person1,person2,person3};
        Person[] secondArray = new Person[]{person1,person4,person2};
        Person[] expectedArray = {};

        //initialize mocks

        //initialize object of class to test
        PersonMergeHelperImpl personMergeHelper = new PersonMergeHelperImpl();
        PersonMergeHelperDelegate delegate = new PersonMergeHelperDelegate(personMergeHelper);

        //invoke method on class to test
        Person [] resultArray = delegate.merge(firstArray, secondArray);

        //assertion block
        Assert.assertArrayEquals("When left array is empty the method leftUnion() doesn't work right.", expectedArray, resultArray);

        //verify mocks expectations
    }

}