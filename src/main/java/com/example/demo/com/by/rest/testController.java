package com.example.demo.com.by.rest;

import com.example.demo.com.by.domain.MongoUser;
import com.example.demo.com.by.domain.User;
import com.example.demo.com.by.repository.RedisServiceImpl;
import com.example.demo.com.by.repository.UserRepostory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//控制器注解
@RestController
public class testController {
    private final UserRepostory userRepostory;
    private RedisServiceImpl redisRepostry;
    private final MongoRepository mongoRepository;

    public testController(UserRepostory userRepostory,
                          RedisServiceImpl redisRepostry,
                          MongoRepository mongoRepository){
        this.userRepostory = userRepostory;
        this.redisRepostry = redisRepostry;
        this.mongoRepository = mongoRepository;
    }

    /**
     *      获得mysql用户列表
     */
    @GetMapping("/getUsers")
    @Transactional
    public User hello() {
        User user = new User();
        user.setId(2);
        int a = 5/0;
        userRepostory.save(user);
        return user;
    }

    /**
     *      添加mysql一个用户
     */
    @PostMapping("addUser")
    public User addUser(@RequestParam User u){
        User user = new User();
        user.setId(u.getId());
        user.setName(u.getName());
        user.setAge(u.getAge());
        userRepostory.save(user);
        return user;
    }

    /**
     *          存入redis一个字符串
     */
    @GetMapping("addRedis/{key}/{value}")
    public String addRedis(@PathVariable String key,
                           @PathVariable String value){
        redisRepostry.add(key,value);
        return value;
    }

    /**
     *      取出redis一个字符串
     */
    @GetMapping("getRedis-by-key/{key}")
    public String getKey(@PathVariable String key){
       return redisRepostry.get(key);
    }

    /**
     *      取出mongo所有所有用户
     */
    @GetMapping("get-mongo-users")
    public List<MongoUser> getMongoUser() {
        List<MongoUser> user = mongoRepository.findAll();
        return user;
    }

    /**
     *     添加MongoDB一个用户
     */
    @GetMapping("add-mongo-user/{id}/{name}/{age}")
    public Integer getMongoUser(@PathVariable String id,
                                @PathVariable String name,
                                @PathVariable String age) {
        MongoUser mongoUser = new MongoUser();
        mongoUser.setId(Integer.parseInt(id));
        mongoUser.setAge(Integer.parseInt(age));
        mongoUser.setName(name);
        mongoRepository.save(mongoUser);
        return 200;
    }
}
