package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements SuperEntity {
    private String id;
    private String name;
    private String description;
    private String specification;
    private String display_name;
    private String availability;
    private String state;
    private String available_brands;
}
