package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)
    private Long id;
    private String Nname;
    private String country;
    private String phoneNumber;
    private String email;
    private String image;


    @OneToMany(mappedBy = "agency",cascade = {DETACH, MERGE, REFRESH})
    private List<House> houses;


    @ManyToMany(cascade = {DETACH, MERGE, REFRESH})
    private List<Customer> customers;
}
