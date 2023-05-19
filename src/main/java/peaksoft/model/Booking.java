package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "booking")
@Getter
@Setter


public class Booking {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "booking_gen")
     @SequenceGenerator(name = "booking_gen",sequenceName = "booking_seq",allocationSize = 1)
     private  Long id;

     @Transient
     private Long customer_id;
     @Transient
     private Long house_id;



     @OneToOne(cascade = {DETACH, MERGE, REFRESH})
     private House house;
     @ManyToOne(cascade = {DETACH, MERGE, REFRESH})
     private Customer customer;

}
