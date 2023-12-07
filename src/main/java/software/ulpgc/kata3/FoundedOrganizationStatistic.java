package software.ulpgc.kata3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoundedOrganizationStatistic implements OrganizationStatistic {

    @Override
    public Map<String, Integer> calculate(List<Organization> organizations) {
        Map<String, Integer> result = new HashMap<>();
        for (Organization organization : organizations) {
            String country = organization.getCountry();
            String interval = toInterval(organization.getFounded());
            String key = country + " - " + interval;
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    private String toInterval(int founded) {
        if (founded < 1900) return "Before 1900";
        if (founded < 1910) return "1900-1910";
        if (founded < 1920) return "1900-1920";
        return "After 1920";
    }

}
