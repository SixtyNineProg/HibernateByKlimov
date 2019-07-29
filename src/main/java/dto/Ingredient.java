package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "INGREDIENTS")
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "INGREDIENT_TITLE")
    private String ingredientTitle;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dish> dishes;
}
