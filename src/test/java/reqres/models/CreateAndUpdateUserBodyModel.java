package reqres.models;

import lombok.Data;

@Data
public class CreateAndUpdateUserBodyModel {
    private String name, job;
}
