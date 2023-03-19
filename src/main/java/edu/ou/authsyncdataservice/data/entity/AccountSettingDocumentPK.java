package edu.ou.authsyncdataservice.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountSettingDocumentPK implements Serializable {
    private int accountId;
    private int roleId;
    private int permissionId;
}
