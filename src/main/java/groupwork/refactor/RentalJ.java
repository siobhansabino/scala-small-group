package groupwork.refactor;

class RentalJ extends DomainObjectJ
{
    public int daysRented() {
        return _daysRented;
    }
    public TapeJ tape() {
        return _tapeJ;
    }
    private TapeJ _tapeJ;
    public RentalJ(TapeJ tapeJ, int daysRented) {
        _tapeJ = tapeJ;
        _daysRented = daysRented;
    }
    private int _daysRented;
}
