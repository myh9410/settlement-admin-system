package system.admin.settlement.dtos.storeowners;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreOwnerRequest {

    @NotBlank
    private String name;
}
