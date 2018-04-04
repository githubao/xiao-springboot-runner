package org.xiao.springboot.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xiao.springboot.entity.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 配置jackson
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/3 20:11
 */

@Configuration
public class JacksonConf {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);


        return mapper;
    }

    @JsonIgnore
    private String password;

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//    @JsonSerialize(a.class)
    private class Demo{}

//    类型擦除的处理方式
    private JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementsClass){
        return objectMapper().getTypeFactory().constructParametricType(collectionClass,elementsClass);
    }

    private <T> List<User> getUsers(String userArray) throws IOException {
        JavaType type = getCollectionType(List.class,User.class);
        return objectMapper().readValue(userArray,type);

    }

}
