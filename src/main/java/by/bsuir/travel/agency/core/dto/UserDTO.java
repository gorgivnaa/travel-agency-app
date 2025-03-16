package by.bsuir.travel.agency.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String phoneNumber;
    private String password;
}
