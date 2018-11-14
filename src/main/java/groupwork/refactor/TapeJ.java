package groupwork.refactor;

class TapeJ extends DomainObjectJ
{
    public MovieJ movie() {
        return _movieJ;
    }
    public TapeJ(String serialNumber, MovieJ movieJ) {
        _serialNumber = serialNumber;
        _movieJ = movieJ;
    }
    private String _serialNumber;
    private MovieJ _movieJ;
}
