package com.vinay.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction means interface or abstract classes
 * 1. High level modules should not depend on low level modules. Both should depend on abstractions
 * 2. Abstractions should not depend on details. Details should depend on abstractions
 */
public class DependencyInversionPrinciple {

    class Person{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class RelationData{
        Person parent;
        Person child;

        public RelationData(Person parent, Person child) {
            this.parent = parent;
            this.child = child;
        }

        public Person getParent() {
            return parent;
        }

        public void setParent(Person parent) {
            this.parent = parent;
        }

        public Person getChild() {
            return child;
        }

        public void setChild(Person child) {
            this.child = child;
        }
    }

//    low level module as it stores data
    class RelationShip implements RelationshipBrowser{
        List<RelationData> relationDataList = new ArrayList<>();

//        returning the whole data like this is not ideal as the data storage may change tomorrow, or grow really big in size
        public List<RelationData> getRelationShipList(){
            return relationDataList;
        }

        public void addParentChild(Person parent, Person child){
            RelationData relationData = new RelationData(parent, child);
            relationDataList.add(relationData);
        }

        @Override
        public List<Person> getChildrenOf(Person parent) {
            List<Person> result = new ArrayList<>();
            for (RelationData relationData:relationDataList){
                if (relationData.parent.name.compareToIgnoreCase(parent.name) == 0)
                    result.add(relationData.child);
            }
            return result;
        }
    }

//    high level module as it is performing some business logic
    class Research{

//        again this is wrong as it directly calls lower level module which could change
        public Research(RelationShip relationShip) {
            List<RelationData> relationShipList = relationShip.getRelationShipList();
            for (RelationData relationData:relationShipList){
                if (relationData.parent.name.compareToIgnoreCase("John") == 0)
                    System.out.println(relationData.child.name);
            }
        }

//        this is better as it depends on interface rather than implementation
        public Research(RelationshipBrowser relationshipBrowser){
            List<Person> children = relationshipBrowser.getChildrenOf(new Person("John"));
            for (Person person:children)
                System.out.println(person.name);
        }
    }

//    creating abstraction to depend on rather than depending on implementation
    interface RelationshipBrowser{
        List<Person> getChildrenOf(Person parent);
    }

    public static void main(String[] args) {
        DependencyInversionPrinciple dependencyInversionPrinciple = new DependencyInversionPrinciple();
        Person parent = dependencyInversionPrinciple.new Person("John");
        Person child1 = dependencyInversionPrinciple.new Person("ginny");
        Person child2 = dependencyInversionPrinciple.new Person("stuart");

        RelationShip relationShip = dependencyInversionPrinciple.new RelationShip();
        relationShip.addParentChild(parent, child1);
        relationShip.addParentChild(parent, child2);

        Research research = dependencyInversionPrinciple.new Research(relationShip);
    }
}
