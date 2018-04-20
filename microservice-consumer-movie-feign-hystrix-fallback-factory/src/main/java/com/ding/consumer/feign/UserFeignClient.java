package com.ding.consumer.feign;

import com.ding.consumer.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id);
}

@Slf4j
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

  @Override
  public UserFeignClient create(Throwable throwable) {
    return new UserFeignClient() {
      @Override
      public User findById(@PathVariable("id") Long id) {
        // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
        // 否则在引用启动时，就会打印该日志。
        // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
        log.info("fallback; reason was:", throwable);
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
      }
    };
  }
}