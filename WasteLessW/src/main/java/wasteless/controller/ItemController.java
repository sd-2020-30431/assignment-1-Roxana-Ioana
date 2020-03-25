package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import wasteless.model.*;
import wasteless.service.*;

import java.time.*;
import java.time.format.*;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/groceryItems", method = RequestMethod.GET)
    public String findItemsByIdList(Model model) {
        return "groceryItem";
    }

    @RequestMapping(value = "/groceryItems", method = RequestMethod.POST)
    public String insertItem( @RequestParam("idList") int idList,
                              @RequestParam("lName") String listName,
                              @RequestParam("iname") String itemName,
                             @RequestParam("quantity") int quantity,
                             @RequestParam("calories") int calories,
                             @RequestParam("pDate") String purchaseDate,
                             @RequestParam("eDate") String expDate,
                             Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        itemService.insertItem(new GroceryItem(idList, itemName, quantity, calories, LocalDate.parse(purchaseDate, formatter), LocalDate.parse(expDate, formatter)));

        model.addAttribute("idList", idList);
        model.addAttribute("lName", listName);

        return "groceryItem";
    }
}
