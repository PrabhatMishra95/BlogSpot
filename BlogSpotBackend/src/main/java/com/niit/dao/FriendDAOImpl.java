package com.niit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.model.Friend;
import com.niit.model.UserDetail;

@Service
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Transactional
	public boolean sendFriendRequest(Friend friend) {

		try {
			System.out.println("Into Send Friend Request");
			friend.setStatus("P");
			sessionfactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	
	@Transactional
	public boolean deleteFriendRequest(int friendId) {
		System.out.println("Into Deleting FriendRequest");
		try {
			Session session = sessionfactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);

			if (friend.getStatus() == "P") {
				sessionfactory.getCurrentSession().delete(friend);
				session.close();
				System.out.println("Deleted Friend Request is:" + friendId);
			} else {

				System.out.println("Friend Request is already Accepted");
			}

			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public boolean acceptFriendRequest(int friendId) {
		try {
			Session session = sessionfactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);
			friend.setStatus("A");
			sessionfactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean unFriendRequest(int friendId) {
		try {
			Session session = sessionfactory.openSession();
			Friend friend = (Friend) session.get(Friend.class, friendId);
			friend.setStatus("NA");
			sessionfactory.getCurrentSession().update(friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Transactional
	public List<UserDetail> showSuggestedFriend(String loginName) {
	Session session = sessionfactory.openSession();
	SQLQuery query = session.createSQLQuery(
			"select loginName from userdetail where loginName not in (select friendloginname from friend where loginName='"
					+ loginName + "')and loginName!='" + loginName + "'");
	List<Object> suggestedFriendName = (List<Object>) query.list();
	List<UserDetail> suggestFriendList = new ArrayList<UserDetail>();
	int i = 0;
	while (i < suggestedFriendName.size()) {
		UserDetail userDetail = session.get(UserDetail.class, (String) suggestedFriendName.get(i));
		suggestFriendList.add(userDetail);
		i++;
		}
	return suggestFriendList;
		
	}
	
	@Transactional
	public List<Friend> showAllFriends(String loginName) {
	
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Friend where loginName =:currentuser and status='A'");
		query.setParameter("currentuser", loginName);
		List<Friend> listFriends = (List<Friend>) query.list();
		return listFriends;
	}

	@Transactional
	public List<Friend> showPendingFriendRequest(String loginName) {
		
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Friend where loginName =:currentuser and status='P'");
		query.setParameter("currentuser", loginName);
		List<Friend> listFriends = (List<Friend>) query.list();
		return listFriends;
	}

}
