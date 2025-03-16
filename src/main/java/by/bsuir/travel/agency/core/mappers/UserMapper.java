package by.bsuir.travel.agency.core.mappers;

import by.bsuir.travel.agency.core.domains.User;
import by.bsuir.travel.agency.core.dto.UserDTO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDTO userDTO) {
        return userDTO != null
                ? getBuildEntity(userDTO)
                : null;
    }

    private User getBuildEntity(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .patronymic(userDTO.getPatronymic())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(encodePassword(userDTO.getPassword()))
                .build();
    }


    public UserDTO toDTO(User user) {
        return user != null
                ? buildUserDTO(user)
                : null;
    }

    private UserDTO buildUserDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .patronymic(user.getPatronymic())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .build();
    }

    private String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
