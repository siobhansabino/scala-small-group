package groupwork.refactor;

public class MovieJ extends DomainObjectJ {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;


    private int _priceCode;

    public MovieJ(String name, int priceCode) {
        _name = name;
        _priceCode = priceCode;
    }

    public int priceCode() {
        return _priceCode;
    }

    public void persist() {
        RegistrarJ.add ("Movies", this);
    }

    public static MovieJ get(String name) {
        return (MovieJ) RegistrarJ.get ("Movies", name);
    }
}
