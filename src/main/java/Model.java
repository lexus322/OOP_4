import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;

@Getter
@Setter
public class Model {
    String firstName;
    String middleName;
    String lastName;
    ArrayList<Model> allUsers = new ArrayList<>();

    @SneakyThrows
    public Model(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        allUsers.add(Model.this);
    }

    public Model() {
    }
}