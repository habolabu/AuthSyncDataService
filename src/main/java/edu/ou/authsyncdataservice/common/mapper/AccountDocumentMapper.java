package edu.ou.authsyncdataservice.common.mapper;

import edu.ou.authsyncdataservice.data.entity.AccountDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface AccountDocumentMapper {
    AccountDocumentMapper INSTANCE = Mappers.getMapper(AccountDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Account object
     *
     * @param map represents for AccountAddRequest object
     * @return Account object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "username", source = "username", qualifiedByName = "objectToString")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectToInt")
    AccountDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to String
     *
     * @param object object will be converted
     * @return String
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToString")
    static String objectToString(Object object) {
        return (String) object;
    }

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
}
