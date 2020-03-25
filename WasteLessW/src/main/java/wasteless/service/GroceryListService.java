package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

@Service
public class GroceryListService {

    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public GroceryList createNewList(GroceryList groceryList)
    {
        return groceryListRepository.save(groceryList);
    }
}
