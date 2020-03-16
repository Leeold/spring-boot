package com.company.project.service;
import com.company.project.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/26.
 */

public interface UserService {
    List<User> selectList ();
}
