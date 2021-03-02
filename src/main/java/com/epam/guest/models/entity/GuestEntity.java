package com.epam.guest.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GUEST_TABLE")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MOBILE")
    private Integer mobile;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "buildingName", column = @Column(name = "BUILDING_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "STATE")),
            @AttributeOverride(name = "country", column = @Column(name = "COUNTRY")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "POSTAL_CODE"))
    })
    private AddressEntity address;

}
