package com.nagendra.cassendra.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table("user")
public class User {

    @Id
    @PrimaryKey
    private int id;
    private String name;
    private String city;
    private String state;

}
