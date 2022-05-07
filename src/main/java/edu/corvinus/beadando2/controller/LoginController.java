package edu.corvinus.beadando2.controller;

import edu.corvinus.beadando2.model.User;
import edu.corvinus.beadando2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam() String username, String password)
    {
        Optional<User> foundUser = userRepository.findByUsername(username);
        User user;

        if(foundUser.isPresent())
        {
            user = foundUser.get();

            StringBuilder titkos = new StringBuilder();

            for (int i = 0; i < password.length(); i++)
            {
                int ascii = password.charAt(i);
                ascii++;
                char ch = (char) ascii;
                titkos.append(ch);
            }
            password = titkos.toString();

            if(user.getPassword().equals(password))
            {
                return "welcome";
            }
            else
            {
                return "login";
            }
        }
        else
        {
            return "login";
        }
    }
}
