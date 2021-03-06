package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.niit.model.BlogComment;



	@Service
	@Repository("blogCommentDAO")
	public class BlogCommentDAOImpl implements BlogCommentDAO {

		@Autowired
		SessionFactory sessionfactory;

		@Transactional
		public boolean addBlogComment(BlogComment blogComment) {
			try {
				sessionfactory.getCurrentSession().saveOrUpdate(blogComment);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		@Transactional
		public boolean removeBlogComment(BlogComment blogComment) {
			try {
				sessionfactory.getCurrentSession().delete(blogComment);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		@Transactional
		public BlogComment getBlogComment(int commentId) {
			try {
				Session session = sessionfactory.openSession();
				BlogComment blogComment = session.get(BlogComment.class,commentId);
				return blogComment;
			} catch (Exception e) {
				return null;
			}	
		}

		@Transactional
		public List<BlogComment> listBlogComment(int blogId) {
			Session session=sessionfactory.openSession();
			Query query=session.createQuery("from BlogComment where blogId=:blogId");
			query.setParameter("blogId", new Integer(blogId));
			@SuppressWarnings("unchecked")
			List<BlogComment> listBlogComments=query.list();
			return listBlogComments;
		}

		@Transactional
		public boolean deleteBlogComment(BlogComment blogComment) {
			try {
				sessionfactory.getCurrentSession().delete(blogComment);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

}
