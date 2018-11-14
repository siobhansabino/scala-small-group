package groupwork.refactor;

public class DomainObjectJ {

    public DomainObjectJ(String name)	{
        _name = name;
    };

    public DomainObjectJ()	{};

    public String name ()	{
        return _name;
    };

    public String toString() {
        return _name;
    };

    protected String _name = "no name";
}
