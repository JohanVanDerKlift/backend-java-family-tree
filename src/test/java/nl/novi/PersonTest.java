package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;
    Person person6;
    Person person7;
    Person person8;
    Pet pet1;
    Pet pet2;

    @BeforeEach
    void setUp() {
        person1 = new Person("Peter", "van der", "Klift", "Male", 69);
        person2 = new Person("Hennie", "van der", "Klift", "Female", 65);
        person3 = new Person("Ilse", "Velvis", "Female", 47);
        person4 = new Person("Johan", "van der", "Klift", "Male", 41);
        person5 = new Person("Anne-Marie", "van der", "Klift", "Female", 37);
        person6 = new Person("Jordy", "van", "Peer", "Male", 28);
        person7 = new Person("Yara", "van der", "Klift", "Female", 9);
        person8 = new Person("Baby", "van", "Peer", "Female", 0);
        pet1 = new Pet("Hammie", 2, "Cavia");
        pet2 = new Pet("Cookie", 2, "Cavia");
    }

    @Test
    void shouldAddParentsAsMotherOrFather() {
        person4.addParents(person1);
        person4.addParents(person2);
        assertEquals("Peter", person4.getFather().getName());
        assertEquals("Hennie", person4.getMother().getName());
    }

    @Test
    void shouldAddChildren() {
        List<Person> childrenTestList = new ArrayList<>();
        person4.addChild(person7);
        person4.addChild(person8);
        childrenTestList.add(person7);
        childrenTestList.add(person8);
        assertArrayEquals(childrenTestList.toArray(), person4.getChildren().toArray());
    }

    @Test
    void shouldAddPets() {
        person7.addPet(pet1);
        person7.addPet(pet2);
        List<Pet> output = person7.getPets();

        List<Pet> expected = new ArrayList<>();
        expected.add(pet1);
        expected.add(pet2);

        assertArrayEquals(expected.toArray(), output.toArray());
    }

    @Test
    void shouldAddSiblings() {
        person4.addSiblings(person5);
        person5.addSiblings(person4);
        List<Person> output1 = person4.getSiblings();
        List<Person> output2 = person5.getSiblings();

        List<Person> expected1 = new ArrayList<>();
        List<Person> expected2 = new ArrayList<>();
        expected1.add(person5);
        expected2.add(person4);

        assertArrayEquals(expected1.toArray(), output1.toArray());
        assertArrayEquals(expected2.toArray(), output2.toArray());
    }

    @Test
    void ShouldGetGrandChildren() {
        person1.addChild(person4);
        person1.addChild(person5);
        person4.addChild(person7);
        person5.addChild(person8);
        List<Person> output = person1.getGrandChildren();

        List<Person> expected = new ArrayList<>();
        expected.add(person7);
        expected.add(person8);

        assertArrayEquals(expected.toArray(), output.toArray());
    }

    @Test
    void shouldGetPetsFromGrandChildren() {
        person1.addChild(person4);
        person1.addChild(person5);
        person4.addChild(person7);
        person5.addChild(person8);
        person7.addPet(pet1);
        person7.addPet(pet2);
        List<Pet> output = person1.getPetsFromGrandChildren();

        List<Pet> expected = new ArrayList<>();
        expected.add(pet1);
        expected.add(pet2);

        assertArrayEquals(expected.toArray(), output.toArray());
    }

    @Test
    void shouldGetNieces() {
        person7.addParents(person4);
        person7.addParents(person3);
        person4.addSiblings(person5);
        person5.addChild(person8);

        List<Person> output = person7.getNieces();

        List<Person> expected = new ArrayList<>();
        expected.add(person8);

        assertArrayEquals(expected.toArray(), output.toArray());
    }
}