import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Model {
    String firstName;
    String middleName;
    String lastName;
    ArrayList<Model> allUsers = new ArrayList<>();

    public Model() {
    }
}
