package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

@Service
public class GroceryListService {

    private final UserRepository userRepository;

    @Autowired
    public GroceryListService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsernameAndPassword(String username, String password)
    {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
