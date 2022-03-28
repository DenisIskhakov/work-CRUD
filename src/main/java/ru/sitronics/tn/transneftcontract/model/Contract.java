package ru.sitronics.tn.transneftcontract.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long responsibleUserId;
    private long organizationId;

    @Enumerated(EnumType.STRING)
    private Status status;

//    private List<User> responsibleUser;
//
//    private List<Organization> organizations;
//
//    private List<Documents> documentsComplect;
}
