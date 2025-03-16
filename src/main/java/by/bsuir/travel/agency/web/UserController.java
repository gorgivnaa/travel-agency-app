package by.bsuir.travel.agency.web;

import by.bsuir.travel.agency.core.dto.UserDTO;
import by.bsuir.travel.agency.core.servicies.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travel/agency")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public String showAddUserForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        return "users/add";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute(value = "user") UserDTO userDTO, ModelMap modelMap) {
        UserDTO user = userService.createUser(userDTO);
        modelMap.addAttribute("userDTO", user);
        return "users/add";
    }
}
