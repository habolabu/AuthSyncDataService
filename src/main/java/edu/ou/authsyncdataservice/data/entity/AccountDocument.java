package edu.ou.authsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("Account")
public class AccountDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String username;
    private Date createdAt = new Date(System.currentTimeMillis());
    private int userId;

}
