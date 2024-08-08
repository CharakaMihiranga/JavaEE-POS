package lk.ijse.gdse.javaee.posbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private String code;
    private String name;
    private int qty;
    private double unitPrice;
}
