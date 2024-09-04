package com.example.WareHouseSpringBoot.Entity.Student;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Class extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ClassID;
    String ClassName;
    String ClassDescription;

    //cascade = CascadeType.ALL truyen thao tac xuong thuc the con
    //orphanRemoval = true Nếu một thực thể Student bị xóa khỏi danh sách studentList, nó cũng sẽ bị xóa khỏi cơ sở dữ liệu.
    @OneToMany(mappedBy = "classId")
    List<Student> studentList;
}
