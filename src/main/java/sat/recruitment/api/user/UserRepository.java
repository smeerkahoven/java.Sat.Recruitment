package sat.recruitment.api.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import sat.recruitment.api.user.model.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Value(value = "${users.path}")
    private String filepath;

    public List<User> read() {
        final List<User> users = new ArrayList<>();
        final InputStream fstream;
        try {
            fstream = getClass().getResourceAsStream(filepath);
            final BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                final String[] line = strLine.split(",");
                final User user = new User(line);
                users.add(user);
            }
            fstream.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
