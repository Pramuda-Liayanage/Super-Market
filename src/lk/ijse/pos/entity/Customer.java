package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements SuperEntity{
    private String id;
    private String type;
    private String name;
    private String address;
    private String city;
    private String province;
    private String contact;
}
