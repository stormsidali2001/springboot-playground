package com.example.coreapi.config;

import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig{

    @Bean
    public XStream xStream(){
        XStream xStream = new XStream();
        //allow serialization && parssing of the coreapi classes
        xStream.allowTypesByWildcard(new String[]{
                "com.example.coreapi.**"
        });
        return  xStream;
    }
}
