package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String specification;
    private String display_name;
    private String availability;
    private String state;
    private String available_brands;
}
