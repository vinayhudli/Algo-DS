package com.vinay.designpatterns;

/**
 * how to split interface into smaller interfaces
 */
public class InterfaceSegregationPrinciple {

    class Document{

    }

    /*
     * This kind of interface creates issue if some of the concrete classes don't scan or fax or both
     */
    interface Machine{
        void print(Document document);
        void scan(Document document);
        void fax(Document document);
    }

    class MultifunctionPrinter implements Machine{

        @Override
        public void print(Document document) {

        }

        @Override
        public void scan(Document document) {

        }

        @Override
        public void fax(Document document) {

        }
    }

    class OldFashionedPrinter implements Machine{

        @Override
        public void print(Document document) {

        }

        @Override
        public void scan(Document document) {
//            this is not supported in old fashioned printer, 1 way to get around is to throw exception
            throw new RuntimeException();
        }

        @Override
        public void fax(Document document) {
//
        }
    }

    /*
    Another is to split Machine interface into multiple interfaces and only have the methods that are necessary and makes sense
     */

    interface Printer{
        void print(Document d);
    }

    interface Scanner{
        void scan(Document d);
    }

    class JustAPrinter implements Printer{

        @Override
        public void print(Document d) {

        }
    }

    class Photocopier implements Printer, Scanner{

        @Override
        public void print(Document d) {

        }

        @Override
        public void scan(Document d) {

        }
    }

    /*
    one more solution is to just have an interface that extends these group of interfaces
     */

    interface Multifunction extends Printer,Scanner{}

    class MultifunctionImpl implements Multifunction{

        @Override
        public void print(Document d) {

        }

        @Override
        public void scan(Document d) {

        }
    }
}
