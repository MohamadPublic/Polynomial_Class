//Class Polynomial contains a data field "terms" that is of type LinkedList<Term>.
//We assume that all exponents and coefficients are of type double.
//We store the exponents and coefficeints of each term in an instance of class Term
//We assume that the user inputs in a string to represent a polynomial in order of decreasing degree.
//The string is in inputted the following format:
//3.5x^2;12x^1;6x^0

//We will design the following functionality in the polynomial class
    //A method add: takes in 2 strings representing polynomials, adds them, returns the result as a string.

import java.util.LinkedList;
import java.util.Iterator;

public class Polynomial{
    //we first make our inner class, Term.
    private class Term{
        //instance variables
        double coef;
        double exp;

        //constructor
        private Term(double coef, double exp){
            this.coef = coef;
            this.exp = exp;
        }
    }

    //instance varaibles for class Polynomial
    private LinkedList<Term> terms;

    //constructors
    //1 of 2: the user has a polynomial in mind. The string gets parsed into a Linked List of terms.
    public Polynomial(String representation){
        terms = parsePoly(representation);
    }
    
    //2 of 2: the user doesn't have a polynomial in mind.
    public Polynomial(){
        terms = new LinkedList<>();
    }

    //This is our method which turns strings into a linked list of terms
    private LinkedList<Term> parsePoly(String representation){
        LinkedList<Term> result = new LinkedList<>();
        String[] termReps = representation.split(";");

        for (int i =0; i<termReps.length; i++){
            String current = termReps[i];
            String[] components = current.split("x\\^"); //require 2 escape symbols

            double coef = Double.parseDouble(components[0]);
            double exp = Double.parseDouble(components[1]);

            result.add(new Term(coef, exp));
        }

        return result;
    }

    //we design a method which states the degree of the polynomial
    public double getDegree(){
        Iterator<Term> it = terms.iterator();
        if (!it.hasNext()){
            return 0;
        }
        return terms.getFirst().exp;
    }

    //we design a method which allows the user to add another term of higher degree to the polynomial
    public void addHigherOrderTerm(String newTerm){
        String[] components = newTerm.split("x\\^");
        double newDegree = Double.parseDouble(components[1]);
        if (this.getDegree()>newDegree){
            System.out.println("ERROR: New Term Must be of a Higher Degree! Try again.");
        }

        else{
        terms.addFirst(parsePoly(newTerm).getFirst());
        }
    }

    //we design a method which takes a polynomial and turns it into a string of the correct format
    public String toString(){

        String result = "Polynomial of degree " + getDegree() +": ";
        Iterator<Term> it = terms.iterator();

        Term term;
        while(it.hasNext()){
            term = it.next();
            result = result + Double.toString(term.coef);
            result = result + "x^";
            result = result + Double.toString(term.exp);
            result = result +';';
        }

        result = result.substring(0, result.length()-1);
        return result;
    }

    //we design the add method which is needed in the addPoly method
    private void add(Term newTerm){
        this.terms.add(newTerm);
    }
    
    public String addPoly(String rep1, String rep2){
        //make sure they actually entered in 2 strings
        if (rep1 =="" || rep2=="" || rep1 == null || rep2==null){
            System.out.println("Make sure to enter 2 NON-EMPTY polynomials in format as follows:");
            System.out.println("3x^2;8x^1;1x^0");
            return "Try Again.";
        }

        //Turn the strings into linked lists
        LinkedList<Term> poly1 = parsePoly(rep1);
        LinkedList<Term> poly2 = parsePoly(rep2);

        //initalize the result
        Polynomial result = new Polynomial();

        //setup iterators
        Iterator<Term> it1 = poly1.iterator();
        Iterator<Term> it2 = poly2.iterator();

        //initialize with first terms of each(first check that they're not empty)
        if (!it1.hasNext() || !it2.hasNext()){ 
            return "Make sure to enter 2 NON-EMPTY polynomials";
        }
        Term term1 = it1.next();
        Term term2 = it2.next();

        //traversal
        //we will traverse both polynomials at the same time
        //since we do not know which one is longer (using linked lists),
        //we must stop traversing as soon as we reach the end of either one of the polynomials
        while (term1 != null && term2 != null){
            //case 1: term 1 order greater than term 2
            if (term1.exp > term2.exp){
                result.add(term1);
                if (it1.hasNext()){
                    term1 = it1.next();
                }
                else{
                    term1 = null;
                    result.add(term2);
                    while (it2.hasNext()){
                        term2 = it2.next();
                        result.add(term2); //must not forget about the remaining terms
                    }
                }
            }

            //case 2: term 2 order greater than term 1
            else if (term2.exp > term1.exp){
                result.add(term2);
                if (it2.hasNext()){
                    term2 = it2.next();
                }
                else{
                    term2 = null;
                    result.add(term1);
                    while (it1.hasNext()){
                        term1 = it1.next();
                        result.add(term1); //must not forget about the remaining terms
                    }
                }
            }

            //case 3: equal exponenets
            else{
                double newCoef = term1.coef + term2.coef;
                //there is a chance that the coeffectient cancel
                if (newCoef != 0){
                    result.add(new Term(newCoef, term1.exp));
                }
                if (!it1.hasNext()){
                    term1 = null;
                    while (it2.hasNext()){
                        term2 = it2.next();
                        result.add(term2); //must not forget about the remaining terms
                    }
                    //we have finished
                }

                else if (!it2.hasNext()){
                    term2 = null;
                    while (it1.hasNext()){
                        term1 = it1.next();
                        result.add(term1); //must not forget about the remaining terms
                    }
                }
                else{
                    term1 = it1.next();
                    term2 = it2.next();
                }
            }
        }
        this.terms = result.terms;
        return result.toString();
    }
}