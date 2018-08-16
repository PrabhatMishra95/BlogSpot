package com.niit.TestCases;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;
import com.thoughtworks.qdox.parser.ParseException;

public class blogTest {

	private static BlogDAO blogDao;
	private Blog blog;

	@BeforeClass
	public void intialise() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDao = (BlogDAO) context.getBean("blogDAO");
	}

	@Test
	public void test() {
		System.out.println("---------Config Tested-------------");

	}
@Test
	public void insertBlogTest() throws ParseException {
		blog = new Blog();
		blog.setBlogName("Sam");
		blog.setLoginname("SamSSJ");
		blog.setBlogContent("Cricket Club");
		blog.setStatus("A");
		blog.setLikes(1);
		blog.setCreateDate((java.sql.Date) new Date());
		assertEquals("Successfully added Blog ", true, blogDao.addBlog(blog));
	}

	@Ignore
	@Test
	public void updateBlogTest() throws ParseException {
		blog = new Blog();
		blog = blogDao.getBlog(1);
		blog.setBlogName("Master Blaster");
		blog.setBlogContent("Welcome To Master Club");
		assertEquals("Successfully updated blog name & content into the Table", true, blogDao.updateBlog(blog));
		System.out.println("<-----------Successfully updated blog-------->");

	}

	@Ignore
	@Test
	public void getBlogTest() {
		blog = blogDao.getBlog(1);
		assertEquals("Successfully got the blog details from the table", "Sam", blog.getBlogName());
		System.out.println("<=========Blog fetched=======>");
		System.out.println("blogID :" + blog.getBlogId());
		System.out.println("blogName :" + blog.getBlogName());
		System.out.println("blogContent :" + blog.getBlogContent());
		System.out.println("Username :" + blog.getLoginname());
		System.out.println("Status :" + blog.getStatus());
		System.out.println("Likes :" + blog.getLikes());
		System.out.println("Created Date :" + blog.getCreateDate());
		System.out.println("<-----------Successfully fetched blog-------->");

	}

	/*@Ignore*/
	@Test
	public void listBlogTest() {
		List<Blog> listBlog = blogDao.listBlog();
		assertEquals("Successfully listed the blog details from the table", blogDao.listBlog().size() > 0);
		System.out.println("<======List of Blog fetched======>");
		for (Blog blog : listBlog) {
			System.out.println("blogID :" + blog.getBlogId());
			System.out.println("blogName :" + blog.getBlogName());
			System.out.println("blogContent :" + blog.getBlogContent());
			System.out.println("Username :" + blog.getLoginname());
			System.out.println("Status :" + blog.getStatus());
			System.out.println("Likes :" + blog.getLikes());
			System.out.println("Created Date :" + blog.getCreateDate());
		}
		System.out.println("<-----------Successfully retrieved list of blog-------->");
	}

	@Ignore
	@Test
	public void approveBlogTest() {

		blog = blogDao.getBlog(1);
		String status = blog.getStatus();
		if (status.equals("NA")) {
			assertEquals("Successfully approved blog int the table", true, blogDao.approveBlog(blog));
			System.out.println("<-----------Successfully approved blog-------->");
		} else {
			System.out.println("not approved");
		}
	}

	@Ignore
	@Test
	public void rejectBlogTest() {

		blog = blogDao.getBlog(2);
		String status = blog.getStatus();
		if (status.equals("A")) {

			assertEquals("Successfully approved blog int the table", true, blogDao.approveBlog(blog));
			System.out.println("<-----------Successfully approved blog-------->");

		} else {
			System.out.println("approved");
		}
	}

	@Ignore
	@Test
	public void deleteBlogTest() {
		blog = blogDao.getBlog(2);
		assertEquals("Successfully approved blog int the table", true, blogDao.deleteBlog(blog));
		System.out.println("<-----------Successfully deleted blog-------->");

	}
	
    @Ignore
	@Test
	public void incrementLikesTest() {
		blog = blogDao.getBlog(1);
		assertEquals("Successfully incremented likes to the table", true, blogDao.incrementLike(blog));
		System.out.println("<=========Likes=========>");
		System.out.println("Likes After incrementing :" + blog.getLikes());
		System.out.println("<-----------Successfully incremented blog likes-------->");
	}
    
   
    
    
    
    
}