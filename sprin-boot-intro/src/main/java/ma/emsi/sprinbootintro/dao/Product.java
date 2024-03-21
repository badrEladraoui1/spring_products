package ma.emsi.sprinbootintro.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data // @Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity // pour la création de cette class en table
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) // automatically generating an id fot the objects
    private Long id;
    private String name;
    private String ref;
    private Integer code ;
    private Date profDate;
    private  Float price;
    @Temporal(TemporalType.DATE)
    private Date prodDate;
}
