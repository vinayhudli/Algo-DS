package com.vinay.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OCP
 */
public class Product {

    enum Color{
        RED,GREEN,BLUE
    }

    enum Size{
        SMALL, MEDIUM, LARGE
    }

    private String name;
    private Color color;
    private Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    /**
     * bad code as for each filter we have to keep adding additional methods
     */
    class ProductFilter{

        public List<Product> filter(List<Product> products, Color color){
            return products.stream().filter(p -> p.color == color).collect(Collectors.toList());
        }

        public List<Product> filter(List<Product> products, Size size){
            return products.stream().filter(p -> p.size == size).collect(Collectors.toList());
        }

        public List<Product> filter(List<Product> products, Color color, Size size){
            return products.stream().filter(p -> p.color == color && p.size == size).collect(Collectors.toList());
        }
    }

    /**
     * better way to do using specification
     */
    interface Specification<T>{
        boolean isSatisfied(T item);
    }

    interface Filter<T>{
        List<T> filter(List<T> items, Specification<T> spec);
    }

    class ColorSpecification implements Specification<Product>{

        private Color color;

        public ColorSpecification(Color color) {
            this.color = color;
        }

        @Override
        public boolean isSatisfied(Product item) {
            return item.color == color;
        }
    }

    class SizeSpecification implements Specification<Product>{

        private Size size;

        public SizeSpecification(Size size) {
            this.size = size;
        }

        @Override
        public boolean isSatisfied(Product item) {
            return item.size == size;
        }
    }

    class CombinationSpecification<T> implements Specification<T>{

        List<Specification<T>> specifications = new ArrayList<>();

        public CombinationSpecification(List<Specification<T>> specifications) {
            this.specifications = specifications;
        }

        @Override
        public boolean isSatisfied(T item) {
            boolean result = true;
            for (Specification<T> spec: specifications)
                result = result && spec.isSatisfied(item);

            return result;
        }
    }

    class BetterFilter implements Filter<Product>{

        @Override
        public List<Product> filter(List<Product> items, Specification<Product> spec) {
            List<Product> result = new ArrayList<>();
            for (Product product:items){
                if (spec.isSatisfied(product))
                    result.add(product);
            }
            return result;
        }
    }

}
