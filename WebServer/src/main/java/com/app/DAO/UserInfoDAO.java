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

	public boolean addUserInfo( long userId) {
		UserInfo info = new UserInfo((int)userId, null, null, null);
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

}
