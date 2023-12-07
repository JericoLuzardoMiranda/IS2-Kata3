package software.ulpgc.kata3;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Organization> organizations = TsvFileOrganizationLoader
                .with(new File("organizations.tsv"))
                .load();

        List<Integer> employeeNumbers = organizations.stream()
                .map(Organization::getNumberOfEmployees)
                .collect(Collectors.toList());

        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(histogram(employeeNumbers));
        mainFrame.setVisible(true);

    }

    private static Histogram histogram(List<Integer> employeeNumbers) {
        int[] employeeArray = employeeNumbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return new Histogram() {
            @Override
            public int bins() {
                return 17;
            }

            @Override
            public double[] values() {
                return Arrays.stream(employeeArray)
                        .asDoubleStream()
                        .toArray();
            }
        };

    }

}
