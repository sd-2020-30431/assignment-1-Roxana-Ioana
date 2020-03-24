package wasteless.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import wasteless.model.*;

import java.util.*;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Item findById(int id);

    List<Item> findByIdList(int idList);
}
