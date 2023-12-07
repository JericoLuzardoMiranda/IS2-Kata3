package software.ulpgc.kata3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TsvFileOrganizationLoader implements OrganizationLoader {

    private final File file;

    private TsvFileOrganizationLoader(File file) {
        this.file = file;
    }

    public static OrganizationLoader with(File file) {
        return new TsvFileOrganizationLoader(file);
    }

    @Override
    public List<Organization> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return load(reader);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Organization> load(BufferedReader reader) throws IOException {
        List<Organization> result = new ArrayList<>();
        reader.readLine();
        while (true) {
            String line = reader.readLine();
            if (line == null) return result;
            result.add(toOrganization(line));
        }
    }

    private Organization toOrganization(String line) {
        return toOrganization(line.split("\t"));
    }

    private Organization toOrganization(String[] fields) {
        return new Organization(
            fields[0],
            fields[1],
            fields[2],
            fields[3],
            fields[4],
            Integer.parseInt(fields[5]),
            fields[6],
            Integer.parseInt(fields[7])
        );
    }
}
