package by.bsuir.travel.agency.core.servicies.impl;

import by.bsuir.travel.agency.core.domains.User;
import by.bsuir.travel.agency.core.dto.UserDTO;
import by.bsuir.travel.agency.core.mappers.UserMapper;
import by.bsuir.travel.agency.core.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUser_ShouldReturnUserDTO_WhenUserIsCreated() {
        UserDTO userDTO = getUserDTO();
        User user = getUser();

        when(userMapper.toEntity(userDTO)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toDTO(user)).thenReturn(userDTO);

        UserDTO result = userService.createUser(userDTO);

        assertEquals(userDTO.getFirstName(), result.getFirstName());
        assertEquals(userDTO.getLastName(), result.getLastName());
        assertEquals(userDTO.getPatronymic(), result.getPatronymic());
        assertEquals(userDTO.getEmail(), result.getEmail());
        assertEquals(userDTO.getPhoneNumber(), result.getPhoneNumber());
    }

    private User getUser() {
        return User.builder()
                .firstName("John")
                .lastName("Doe")
                .patronymic("Smith")
                .email("john.doe@example.com")
                .phoneNumber("1234567890")
                .password("hashedPassword")
                .build();
    }

    private UserDTO getUserDTO() {
        return UserDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .patronymic("Smith")
                .email("john.doe@example.com")
                .phoneNumber("1234567890")
                .password("myPassword")
                .build();
    }
}