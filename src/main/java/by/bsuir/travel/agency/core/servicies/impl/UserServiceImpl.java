package by.bsuir.travel.agency.core.servicies.impl;

import by.bsuir.travel.agency.core.domains.User;
import by.bsuir.travel.agency.core.dto.UserDTO;
import by.bsuir.travel.agency.core.mappers.UserMapper;
import by.bsuir.travel.agency.core.repositories.UserRepository;
import by.bsuir.travel.agency.core.servicies.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User savedUser = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDTO(savedUser);
    }
}
