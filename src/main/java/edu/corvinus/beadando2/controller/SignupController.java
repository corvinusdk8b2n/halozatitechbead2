package edu.corvinus.beadando2.controller;

import edu.corvinus.beadando2.model.User;
import edu.corvinus.beadando2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SignupController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String userRegister(@ModelAttribute User user, String username, String password)
    {
        Optional<User> foundUser = userRepository.findByUsername(username);

        if(foundUser.isPresent())
        {
            return "signup";
        }
        else
        {
            if(username.length() >= 6)
            {
                if(password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*[0-9].*"))
                {
                    StringBuilder titkos = new StringBuilder();

                    for (int i = 0; i < password.length(); i++)
                    {
                        int ascii = password.charAt(i);
                        ascii++;
                        char ch = (char) ascii;
                        titkos.append(ch);
                        System.out.println(titkos);

                        user.setPassword(titkos.toString());
                    }

                    User userInserted = userRepository.save(user);
                    System.out.println(user);
                    return "welcome";
                }
                else
                {
                    return "signup";
                }
            }
            else
            {
                return "signup";
            }
        }
    }
}
