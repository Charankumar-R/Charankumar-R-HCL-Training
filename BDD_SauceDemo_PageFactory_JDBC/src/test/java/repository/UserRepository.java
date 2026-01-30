package repository;

import java.util.Map;
import model.UserData;
import utils.DBUtils;

public class UserRepository {

    public static UserData getUser(String username) {

        Map<String, String> row =
                DBUtils.getRowAsMap("SELECT * FROM test_data WHERE username='" + username + "'");

        if (row == null) return null;

        UserData user = new UserData();
        user.setUsername(row.get("username"));
        user.setPassword(row.get("password"));
        user.setFirstname(row.get("firstname"));
        user.setLastname(row.get("lastname"));
        user.setZipcode(row.get("zipcode"));
        user.setActive("1".equals(row.get("is_active")));

        return user;
    }
}
