package edu.ou.authsyncdataservice.common.mapper;

import edu.ou.authsyncdataservice.data.entity.AccountSettingDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface AccountSettingDocumentMapper {
    AccountSettingDocumentMapper INSTANCE = Mappers.getMapper(AccountSettingDocumentMapper.class);

    /**
     * Map Map<String, String> object to AccountSetting object
     *
     * @param map represents for AccountSettingSwitchRequest object
     * @return AccountSetting object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountId", source = "accountId", qualifiedByName = "objectToInt")
    @Mapping(target = "permissionId", source = "permissionId", qualifiedByName = "objectToInt")
    @Mapping(target = "roleId", source = "roleId", qualifiedByName = "objectToInt")
    @Mapping(target = "status", source = "status", qualifiedByName = "objectToBoolean")
    AccountSettingDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to int
     *
     * @param object object will be converted
     * @return int value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToInt")
    static int objectToInt(Object object) {
        return (int) object;
    }

    /**
     * Convert object to boolean
     *
     * @param object object will be converted
     * @return boolean value
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToBoolean")
    static boolean objectToBoolean(Object object) {
        return (boolean) object;
    }
}
