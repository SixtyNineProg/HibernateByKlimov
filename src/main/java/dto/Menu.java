package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "MENU")
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @ManyToMany(mappedBy = "menus")
    private List<Dish> dishes;
}
