package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import wasteless.model.*;
import wasteless.service.*;

import java.time.*;

@Controller
@RequestMapping(value="/groceryItems")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findItemsByIdList(Model model) {
        /*List<Item> itemList = itemService.findByIdList(idList);

        for(Item item:itemList)
        {
            System.out.println(item.toString());
        }*/

        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String insertItem(Model model) {
        Item item = new Item("ciocolata", 5, 20, LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now());
        itemService.insertItem(item);

        return "main";
    }
}
