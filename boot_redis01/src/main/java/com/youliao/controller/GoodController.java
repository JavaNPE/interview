package com.youliao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Author Dali
 * @Date 2021/6/6 12:33
 * @Version 1.0
 * @Description
 */
@RestController
public class GoodController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buy_Goods() {
        String result = stringRedisTemplate.opsForValue().get("goods:001"); //get key === 看看库存的数量够不够
        int goodsNumber = result == null ? 0 : Integer.parseInt(result);

        if (goodsNumber > 0) {
            int realNumber = goodsNumber - 1;
            stringRedisTemplate.opsForValue().set("goods:001", realNumber + "");
            System.out.println("你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 服务器端口：" + serverPort);
            return "你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 夫区其端口：" + serverPort;
        }else {
            System.out.println("商品已经售罄/活动结束/调用超时，欢迎下次光临"+"\t 服务器端口:"+serverPort);
        }
        return "商品已经售罄/活动结束/调用超时，欢迎下次光临"+"\t 服务器端口:"+serverPort;
    }

}
