package edu.ou.authsyncdataservice.common.mapper;

import edu.ou.authsyncdataservice.data.entity.PasswordDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.Map;

@Mapper
public interface PasswordDocumentMapper {
    PasswordDocumentMapper INSTANCE = Mappers.getMapper(PasswordDocumentMapper.class);

    /**
     * Map HashMap<String, String> object to Password object
     *
     * @param map represents for PasswordAddRequest object
     * @return Password object
     * @author Nguyen Trung Kien - OU
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "OId", source = "id", qualifiedByName = "objectToInt")
    @Mapping(target = "password", source = "password", qualifiedByName = "objectToString")
    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "objectToDate")
    @Mapping(target = "accountId", source = "accountId", qualifiedByName = "objectToInt")
    PasswordDocument fromMap(Map<String, Object> map);

    /**
     * Convert object to Date
     *
     * @param object object will be converted
     * @return Date object
     * @author Nguyen Trung Kien - OU
     */
    @Named("objectToDate")
    static Date objectToDate(Object object) {
        return new Date((long) object);
    }

    /**
     * Convert object to String
     *
     * @param object object will be converted
     * @return String object
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
