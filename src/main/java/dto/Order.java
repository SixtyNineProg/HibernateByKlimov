package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<CookedDish> cookedDishSet;

    @Column(name = "TABLE_NUMBER")
    private Integer tableNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;
}

