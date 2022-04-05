package com.zyapaar.api.repo;

import com.zyapaar.api.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {


}
