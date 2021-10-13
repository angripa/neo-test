package com.neo.saving.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.AbstractCondition;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class AppConfig {
   @Bean
   public RestTemplate restTemplate() {

      RestTemplate restTemplate = new RestTemplate();
      MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
      mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
      restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
      return restTemplate;
   }

   @Bean
   public ObjectMapper objectMapper() {
      return new ObjectMapper();
   }

   @Bean
   public ModelMapper modelMapper() {

      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration()
//              .setSkipNullEnabled(true)
              .setAmbiguityIgnored(true)
              .setPropertyCondition(isStringBlank);
      return modelMapper;
   }

   // string blank condition
   Condition<?, ?> isStringBlank = new AbstractCondition<Object, Object>() {
      @Override
      public boolean applies(MappingContext<Object, Object> context) {
         if (context.getSource() instanceof String) {
            return null != context.getSource() && !"".equals(context.getSource());
         } else {
            return context.getSource() != null;
         }
      }
   };
}
