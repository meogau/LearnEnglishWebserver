package com.app.DAO;

import com.app.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class UserInfoDAO {
	@Autowired
	private EntityManager entityManager;

	public boolean addUserInfo( long userId ,String name) {
		UserInfo info = new UserInfo((int)userId, name, null, null);
		entityManager.persist(info);
		return true;
	}
	
	public UserInfo getUserInfo(int userId) {
		String hql = "select U FROM UserInfo U WHERE U.userId = "+userId;
		List<UserInfo> result = entityManager.createQuery(hql,UserInfo.class).getResultList();
		if(result.size()==0) return null;
		else return result.get(0);
	}

	public List<UserInfo> getRank10(){
		String hql = "select U FROM UserInfo U ORDER BY U.score desc ";
		return entityManager.createQuery(hql,UserInfo.class).setMaxResults(10).getResultList();
	}

	public List<UserInfo> getRank5(){
		String hql = "select U FROM UserInfo U ORDER BY U.score desc ";
		return entityManager.createQuery(hql,UserInfo.class).setMaxResults(5).getResultList();
	}


	 public UserInfo updateUserInfo(int userId, String name, String gender , Date birthday){
		UserInfo userInfo = getUserInfo(userId);
		userInfo.setName(name);
		userInfo.setGender(gender);
		userInfo.setBirthday(birthday);
		entityManager.merge(userInfo);
		return  userInfo;

	 }
	 public void updatePlusPoint(int userId, int point){
		UserInfo userInfo = getUserInfo(userId);
		userInfo.setScore(userInfo.getScore()+point);
		entityManager.merge(userInfo);
		entityManager.flush();
	 }

	 public void unlockLevel(int userId){
		 UserInfo userInfo = getUserInfo(userId);
		 userInfo.setUnlockLevel(userInfo.getUnlockLevel()+1);
		 entityManager.merge(userInfo);
	 }
	public void updateUnlockLevlel(int userId,int levelUnlock){
		UserInfo userInfo = getUserInfo(userId);
		userInfo.setUnlockLevel(levelUnlock);
		entityManager.merge(userInfo);
	}

}
