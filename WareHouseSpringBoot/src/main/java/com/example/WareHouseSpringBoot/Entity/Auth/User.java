package com.example.WareHouseSpringBoot.Entity.Auth;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Users")
public class User extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String Id;

    @Column(unique = true, nullable = false)
    String username;


    String password;


    String firstName;


    String lastName;

    // date of birth
    LocalDate dob;

    @ManyToMany(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    Set<Role> roles;

}
