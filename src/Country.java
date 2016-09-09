import java.util.List;

/**
 * Created by Zach on 9/9/16.
 */
public class Country {
    private String name;
    private String abbreviation;

    public Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return name;
    }
}
