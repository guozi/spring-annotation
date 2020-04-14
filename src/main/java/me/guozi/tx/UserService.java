package me.guozi.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenyun on 2020/4/12
 */
@Service
public class UserService {

    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void insertUser() {
        userDao.insert();
        System.out.println("插入完成...");
        int i = 10 / 0;
    }
}
