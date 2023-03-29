package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private Person partner;

    // Constructors
    public Person(String name, String lastName, String sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, String sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    // Methods
    public void addParents(Person person) {
        if (person.getSex().equals("Male")) {
            this.father = person;
        } else {
            this.mother = person;
        }
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSiblings(Person sibling) {
        siblings.add(sibling);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<>();
        for (Person child : this.getChildren()) {
            grandChildren.addAll(child.getChildren());
        }
        return grandChildren;
    }

    public List<Pet> getPetsFromGrandChildren() {
        List<Pet> pets = new ArrayList<>();
        for (Person child : this.getChildren()) {
            for (Person grandChild : child.getChildren()) {
                pets.addAll(grandChild.getPets());
            }
        }
        return pets;
    }

    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        for (Person sibling : this.father.getSiblings()) {
            for (Person child : sibling.getChildren()) {
                if (child.getSex().equals("Female")) {
                    nieces.add(child);
                }
            }
        }
        for (Person sibling : this.mother.getSiblings()) {
            for (Person child : sibling.getChildren()) {
                if (child.getSex().equals("Female")) {
                    nieces.add(child);
                }
            }
        }
        return nieces;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }
}
