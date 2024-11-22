package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name="salles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @OneToMany(mappedBy = "salle",fetch=FetchType.EAGER)
    private List<Machine> machines;

}
