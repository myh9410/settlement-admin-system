package system.admin.settlement.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATE TABLE `settlement`.`store_owners` (
 *   `id` INT NOT NULL AUTO_INCREMENT,
 *   `name` VARCHAR(45) NOT NULL,
 *   PRIMARY KEY (`id`));
 */

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "store_owners")
public class StoreOwners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "storeOwners", cascade = CascadeType.ALL)
    private List<Orders> ordersList;

}
