package groupwork.refactor;

import java.util.Enumeration;
import java.util.Vector;

// todo: refactor
class CustomerJ extends DomainObjectJ
{
    public CustomerJ(String name) {
        _name = name;
    }
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + name() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            RentalJ each = (RentalJ) rentals.nextElement();

            //determine amounts for each line
            switch (each.tape().movie().priceCode()) {
                case MovieJ.REGULAR:
                    thisAmount += 2;
                    if (each.daysRented() > 2)
                        thisAmount += (each.daysRented() - 2) * 1.5;
                    break;
                case MovieJ.NEW_RELEASE:
                    thisAmount += each.daysRented() * 3;
                    break;
                case MovieJ.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.daysRented() > 3)
                        thisAmount += (each.daysRented() - 3) * 1.5;
                    break;

            }
            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.tape().movie().priceCode() == MovieJ.NEW_RELEASE) && each.daysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.tape().movie().name()+ "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }
    public void addRental(RentalJ arg) {
        _rentals.addElement(arg);
    }
    public static CustomerJ get(String name) {
        return (CustomerJ) RegistrarJ.get("Customers", name);
    }
    public void persist() {
        RegistrarJ.add("Customers", this);
    }
    private Vector _rentals = new Vector();
}
