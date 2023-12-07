package software.ulpgc.kata3;

public class Organization {

    private final String id;
    private final String name;
    private final String website;
    private final String country;
    private final String description;
    private final int founded;
    private final String industry;
    private final int numberOfEmployees;

    public Organization(String id, String name, String website, String country, String description, int founded, String industry, int numberOfEmployees) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.country = country;
        this.description = description;
        this.founded = founded;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public int getFounded() {
        return founded;
    }

    public String getIndustry() {
        return industry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", founded=" + founded +
                ", industry='" + industry + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }
}
