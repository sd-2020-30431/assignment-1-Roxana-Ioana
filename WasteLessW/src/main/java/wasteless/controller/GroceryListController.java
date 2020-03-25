package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import wasteless.model.*;
import wasteless.service.*;

@Controller
public class GroceryListController {

    private final GroceryListService groceryListService;

    @Autowired
    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @RequestMapping(value = "/groceryList", method = RequestMethod.GET)
    public String start(Model model)
    {
        return "groceryList";
    }

    @RequestMapping(value = "/groceryList", method = RequestMethod.POST)
    public String createNewList(@RequestParam("idUser") int idUser, @RequestParam("lname") String listName, Model model)
    {
        GroceryList groceryList = new GroceryList(idUser, listName);
        groceryListService.createNewList(groceryList);

        model.addAttribute("idList", groceryList.getIdList());
        model.addAttribute("lName", groceryList.getName());

        return "groceryItem";
    }
}
