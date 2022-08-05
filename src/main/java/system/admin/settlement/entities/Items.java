package system.admin.settlement.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Orders order;
}
