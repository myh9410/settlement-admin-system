package system.admin.settlement.dtos.orders;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private LocalDateTime createdDate;

}
