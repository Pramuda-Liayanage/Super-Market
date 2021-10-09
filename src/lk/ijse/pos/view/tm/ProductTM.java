package lk.ijse.pos.view.tm;

import lk.ijse.pos.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTM extends ProductDTO {
    private String id;
    private String name;
    private String description;
    private String specification;
    private String display_name;
    private String availability;
    private String state;
    private String available_brands;
}
