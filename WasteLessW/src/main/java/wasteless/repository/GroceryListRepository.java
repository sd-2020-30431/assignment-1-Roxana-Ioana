package wasteless.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import wasteless.model.*;

@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {
}
