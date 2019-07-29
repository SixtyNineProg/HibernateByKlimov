package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "DISHES")
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String dishTitle;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "WEIGHT")
    private Double weight;

    @ManyToMany
    @JoinTable(name = "DISH_INGREDIENT",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "DISH_MENU",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "MENU_ID"))
    private List<Menu> menus;

    @OneToMany(mappedBy = "dish", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CookedDish> cookedDishes;
}