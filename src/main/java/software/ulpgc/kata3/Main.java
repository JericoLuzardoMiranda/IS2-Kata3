package software.ulpgc.kata3;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Organization> organizations = TsvFileOrganizationLoader
                .with(new File("organizations.tsv"))
                .load();
        OrganizationStatistic statistic = new FoundedOrganizationStatistic();
        Map<String, Integer> map = statistic.calculate(organizations);
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }

}
