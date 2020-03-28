package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import wasteless.model.*;
import wasteless.service.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/groceryItems", method = RequestMethod.GET)
    public String findItemsByIdList(@RequestParam("listName") String listName, @RequestParam("idList") int idList, Model model) {
        model.addAttribute("idList", idList);
        model.addAttribute("listName", listName);

        List<GroceryItem> itemsList = itemService.findByIdList(idList);
        model.addAttribute("items", itemsList);

        return "groceryItem";
    }

    @RequestMapping(value = "/groceryItems", method = RequestMethod.POST)
    public String insertItem(@RequestParam("idList") int idList,
                             @RequestParam("listName") String listName,
                             @RequestParam("iname") String itemName,
                             @RequestParam("quantity") int quantity,
                             @RequestParam("calories") int calories,
                             @RequestParam("pDate") String purchaseDate,
                             @RequestParam("eDate") String expDate,
                             Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        itemService.insertItem(new GroceryItem(idList, itemName, quantity, calories, LocalDate.parse(purchaseDate, formatter), LocalDate.parse(expDate, formatter)));

        model.addAttribute("idList", idList);
        model.addAttribute("listName", listName);

        return "groceryItem";
    }

    @Transactional
    @RequestMapping(value = "/groceryItems/donate", method = RequestMethod.POST)
    public String deleteItem(@RequestParam("idList") int idList, @RequestParam("listName") String listName, @RequestParam("idItem") int idItem, RedirectAttributes redirectAttrs)
    {
        itemService.deleteItem(idItem);

        redirectAttrs.addAttribute("idList", idList);
        redirectAttrs.addAttribute("listName", listName);

        return "redirect:/groceryItems";
    }
}
