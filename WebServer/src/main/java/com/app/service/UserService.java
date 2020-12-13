package com.app.service;

import com.app.entity.UserInfo;

import java.util.Date;
import java.util.List;

public interface UserService {
    public boolean addUserInfo( int userId, String name, String gender, Date birthday) ;
    public UserInfo getUserInfo(int userId) ;
    public List<UserInfo> getRank10();
    public List<UserInfo> getRank5();
}
