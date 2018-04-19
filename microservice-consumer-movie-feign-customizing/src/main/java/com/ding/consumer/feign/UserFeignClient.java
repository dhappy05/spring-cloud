package com.ding.consumer.feign;

import com.ding.consumer.config.FeignConfiguration;
import com.ding.consumer.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
  //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @RequestLine("GET /{id}")  //feign自带的注解,特别注意，GET与/{id}间空格，否则启动会报错
  public User findById(@Param("id") Long id);
}
