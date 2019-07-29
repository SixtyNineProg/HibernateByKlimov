package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "COOKED_DISHES")
@NoArgsConstructor
public class CookedDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DISH_ID")
    private Dish dish;

    @Column(name = "DISH_NUMBER")
    private Integer dishNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;
}