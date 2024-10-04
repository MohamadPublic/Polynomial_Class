public class Main{
    public static void main(String[] args){

        //Example 1
        System.out.println("Example 1");
        System.out.println();

        Polynomial poly1 = new Polynomial();
        poly1.addHigherOrderTerm("3x^2");
        System.out.println(poly1);

        System.out.println("--------------------");

        //Example 2
        System.out.println("Example 2");
        System.out.println();
        Polynomial poly2 = new Polynomial();
        poly2.addHigherOrderTerm("2x^5");
        poly2.addHigherOrderTerm("7x^3");

        System.out.println("Degree: " + poly2.getDegree());
        System.out.println(poly2);

        System.out.println("--------------------");

        //Example 3
        System.out.println("Example 3");
        System.out.println();
        Polynomial poly3 = new Polynomial("4x^3;9x^2;2x^1;6x^0");
        System.out.println("Degree: " + poly3.getDegree());
        poly3.addHigherOrderTerm("7x^4");
        System.out.println("Degree: " + poly3.getDegree());
        System.out.println(poly3);

        System.out.println("--------------------");

        //Example 4
        System.out.println("Example 4");
        System.out.println();
        Polynomial poly4 = new Polynomial("4x^3;9x^2;2x^1;6x^0");
        System.out.println("Degree: " + poly4.getDegree());
        poly3.addHigherOrderTerm("7x^3");
        System.out.println("Degree: " + poly4.getDegree());
        System.out.println(poly4);

        System.out.println("--------------------");

        //Example 5
        System.out.println("Example 5");
        System.out.println();

        Polynomial poly5 = new Polynomial();
        String result = poly5.addPoly("1x^2", "3x^1;8x^0");

        System.out.println(result);
        System.out.println("--------------------");

        //Example 6
        System.out.println("Example 6");
        System.out.println();

        Polynomial poly6 = new Polynomial();
        String result1 = poly6.addPoly("3x^6;4x^2", "4x^2");

        System.out.println(result1); //print using a string

        System.out.println("--------------------");
        //Example 7
        System.out.println("Example 7");
        System.out.println();

        Polynomial poly7 = new Polynomial();
        poly7.addPoly("4x^7;3x^5", "3x^7;2x^5;1x^0");

        System.out.println(poly7); //print using toString()

        System.out.println("--------------------");
        //Example 8
        System.out.println("Example 8");
        System.out.println();

        Polynomial poly8 = new Polynomial("4x^4");
        poly8.addPoly("3x^4;2x^3", "1x^4;1x^3;2x^2;1x^1"); //overide the polynomial currently stored with the result of the addition

        System.out.println(poly8); 

        System.out.println("--------------------");

        //Example 9
        System.out.println("Example 9");
        System.out.println();

        Polynomial poly9 = new Polynomial();

        String result3 = poly9.addPoly("3x^3;7x^0", "-3x^3;-2x^0"); //the cubic terms will cancel

        System.out.println(result3);

        System.out.println("--------------------");
        //Example 10
        System.out.println("Example 10");
        System.out.println();

        Polynomial poly10 = new Polynomial();

        poly10.addPoly("", "3x^1");

        System.out.println(poly10);

        System.out.println("--------------------");
        //Example 11
        System.out.println("Example 11");
        System.out.println();

        Polynomial poly11 = new Polynomial();

        poly11.addPoly("2x^2", null);

        System.out.println(poly11);

        System.out.println("--------------------");
        //Example 12
        System.out.println("Example 12");
        System.out.println();

        Polynomial poly12 = new Polynomial();

        poly12.addPoly("3x^3", "0x^0");

        System.out.println(poly12);

    }
}