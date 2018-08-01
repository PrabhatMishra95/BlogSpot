package com.niit.TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumCommentDAO;
import com.niit.model.ForumComment;

public class forumCommentTest {
	private static ForumCommentDAO forumcommentDao;
	
	private ForumComment forumComment;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forumcommentDao = (ForumCommentDAO) context.getBean("forumCommentDAO");
	}
	
	
	
	@Ignore
	@Test
	public void testAddForumComment() {
		forumComment = new ForumComment();
		
		forumComment.setForumId(1);
		forumComment.setLoginname("Cricket");
		forumComment.setCommentDate(new Date());
		forumComment.setCommentText("Destiny forum");
		assertEquals("Successfully added the forumComment...", true, forumcommentDao.addForumComment(forumComment));
		System.out.println("<-----------Successfully added forumCommment-------->");
	}

	@Ignore
	@Test
	public void testGetForumCommment() {
		forumComment = forumcommentDao.getForumComment(1);
		assertEquals("Successfully fetched a forumComments from the table", "ShubhamRDurugkar",
				forumComment.getLoginName());
		System.out.println("<========ForumComment========>");
		System.out.println("forumID :" + forumComment.getForumId());
		System.out.println("Username :" + forumComment.getLoginName());
		System.out.println("Status :" + forumComment.getCommentId());
		System.out.println("Likes :" + forumComment.getCommentText());
		System.out.println("Created Date :" + forumComment.getCommentDate());
		System.out.println("<-----------Successfully fetched forumComment-------->");
	}

	@Ignore
	@Test
	public void testDeleteForumComment() {
		forumComment = forumcommentDao.getForumComment(4);
		assertEquals("Successfully deleted forum details from the table", true,
				forumcommentDao.deleteForumComment(forumComment));
		System.out.println("<-----------Successfully deleted forumComment-------->");
	}

	//@Ignore
	@Test
	public void testListForumComments() {
		List<ForumComment> listForumComments = forumcommentDao.listForumComments(1);
		assertTrue("Successfully fetched all forums from the table", forumcommentDao.listForumComments(1).size() > 0);
		System.out.println("<======ForumComments fetched======>");
		for (ForumComment forumComment : listForumComments) {
			System.out.println("forumID :" + forumComment.getForumId());
			System.out.println("CommentID :" + forumComment.getCommentId());
			System.out.println("Comment Text :" + forumComment.getCommentText());
			System.out.println("Username :" + forumComment.getLoginName());
			System.out.println("Comment Date : " + forumComment.getCommentDate());
		}
		System.out.println("<-----------Successfully retrieved list of forumComments-------->");
	}


}
