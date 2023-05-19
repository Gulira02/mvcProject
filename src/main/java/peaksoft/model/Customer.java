package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String image;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String  phoneNumber;

    private LocalDate dateOfBirth;



    @ManyToMany( mappedBy = "customers",cascade = {DETACH, MERGE, REFRESH})
    private List<Agency> agencies=new ArrayList<>();


    @OneToMany(mappedBy = "customer",cascade = {DETACH, MERGE, REFRESH})
    private List<Booking> bookings=new ArrayList<>();
}
