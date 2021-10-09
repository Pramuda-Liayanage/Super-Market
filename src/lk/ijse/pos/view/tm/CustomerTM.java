package lk.ijse.pos.view.tm;

import lk.ijse.pos.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTM extends CustomerDTO {
    private String id;
    private String type;
    private String name;
    private String address;
    private String city;
    private String province;
    private String contact;
}
