package com.app.serviceImpl;

import com.app.DAO.UserInfoDAO;
import com.app.entity.UserInfo;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public boolean addUserInfo(long userId, String username) {
        return userInfoDAO.addUserInfo(userId,username);
    }

    @Override
    public UserInfo getUserInfo(int userId) {
        return userInfoDAO.getUserInfo(userId);
    }

    @Override
    public List<UserInfo> getRank10() {
        return userInfoDAO.getRank10();
    }

    @Override
    public List<UserInfo> getRank5() {
        return userInfoDAO.getRank5();
    }

    @Override
    public UserInfo updateUserInfo(int userId, String name, String gender, Date birthday) {
        return userInfoDAO.updateUserInfo(userId,name,gender,birthday);
    }

    @Override
    public void updatePoint(int userId, int point) {
        userInfoDAO.updatePlusPoint(userId,point);
    }

    @Override
    public void unlockLevel(int userId) {
     userInfoDAO.unlockLevel(userId);
    }

    @Override
    public void updateUnlockLevlel(int userId, int levelUnlock) {
        userInfoDAO.updateUnlockLevlel(userId,levelUnlock);
    }
}
