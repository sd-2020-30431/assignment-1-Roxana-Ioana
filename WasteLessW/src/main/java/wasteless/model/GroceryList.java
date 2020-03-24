package wasteless.model;

import javax.persistence.*;

@Entity
@Table(name = "grocery_list")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idList;
    private int idUser;

    public GroceryList() {
    }

    public GroceryList(int idUser) {
        this.idUser = idUser;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
