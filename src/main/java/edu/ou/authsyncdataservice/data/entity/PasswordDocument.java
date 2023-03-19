package edu.ou.authsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("Password")
public class PasswordDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String password;
    private Date createdAt;
    private int accountId;
}
