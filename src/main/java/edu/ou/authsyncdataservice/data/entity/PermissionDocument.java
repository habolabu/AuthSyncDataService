package edu.ou.authsyncdataservice.data.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Permission")
public class PermissionDocument {
    @Id
    private String id;
    private int oId;
    private String name;
    private String display;
    private int parentId;
    private int childOrder;
    private String type;
    private String serviceId;
}
