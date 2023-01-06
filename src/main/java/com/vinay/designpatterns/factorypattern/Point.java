package com.vinay.designpatterns.factorypattern;

public class Point {

    enum CoordinateSystem{
        CARTESIAN,
        POLAR
    }

        private double x;
        private double y;

//        it's a simple example, but as can be seen not an ideal way to write constructor as it has logic on different scenarios to construct. it's a little ugly
        /*
        public Point(double x, double y, CoordinateSystem cs) {
            switch (cs){
                case POLAR:
                    this.x = x*Math.cos(y);
                    this.y = x*Math.sin(y);
                    break;
                case CARTESIAN:
                    this.x = x;
                    this.y = y;
                    break;
            }

        }
        */


        /*
        the below method is not allowed in java
         */
        /*
        public Point(double rho, double theta) {
            this.x = rho*Math.cos(theta);
            this.y = rho*Math.sin(theta);
        }

         */

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        //        instead just have different static methods that build the object
        public static class Factory {
            public static Point newCartesianPoint(double x, double y){
                return new Point(x, y);
            }

            public static Point newPolarPoint(double rho, double theta){
                return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
            }
        }

}
