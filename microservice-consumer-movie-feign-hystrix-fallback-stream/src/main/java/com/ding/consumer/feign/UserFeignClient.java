package com.ding.consumer.feign;

import com.ding.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "microservice-provider-user", fallback = FeignCientFallback.class)
public interface UserFeignClient {
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id);
}

/**
 * 回退类FeignCilentFallback需要实现UserFeignClient接口
 *
 */
@Component
class FeignCientFallback implements UserFeignClient{

  @Override
  public User findById(@PathVariable("id") Long id) {
    User user = new User();
    user.setId(-1L);
    user.setUsername("默认用户");
    return user;
  }
}