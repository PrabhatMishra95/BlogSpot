package com.niit.TestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.JobDetailDAO;
import com.niit.model.ApplyJob;
import com.niit.model.JobDetail;
import com.thoughtworks.qdox.parser.ParseException;

public class jobTest {
	
	private static JobDetailDAO jobDao;
	private JobDetail job;
	private ApplyJob applyJob;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDao = (JobDetailDAO) context.getBean("jobDAO");
	}

	@Ignore
	@Test
	public void insertJobTest() throws ParseException {

		job = new JobDetail();
		job.setJobDesignation("Trainee Er");
		job.setCompany("Syntel");
		job.setJobDescription("Applied for trainee engineer.");
		job.setLastDateToApply(new Date());
		job.setSalary(25000);
		job.setLocation("Mumbai");
		
		assertEquals("Successfully added job into the table", true, jobDao.addJob(job));

		System.out.println("<-----------Successfully inserted into job-------->");
	}

	@Ignore
	@Test
	public void updateJobTest() throws ParseException {
		job = jobDao.getJob(1);
		job.setJobDesignation("AssociateER");
		job.setCompany("IBM");
		job.setJobDescription("Associate engineer for core java advance java");
		assertEquals("Successfully updated job into the table", true, jobDao.updateJob(job));
		System.out.println("<-----------Successfully updated job-------->");
	}

	@Ignore
	@Test
	public void testGetJob() {
		job = jobDao.getJob(1);
		assertEquals("Successfully fetched a job details from the table", "AssociateER", job.getJobDesignation());
		System.out.println("<-----------Successfully fetched job-------->");
	}

	@Ignore
	@Test
	public void testGetAllJob() {
		assertTrue("Successfully fetched all jobs from the table", jobDao.listAllJobs().size() > 0);
		System.out.println("No of jobs:" + jobDao.listAllJobs().size());
		System.out.println("<-----------Successfully retrieved list of job-------->");
	}
	@Ignore
	@Test
	public void testDeleteJob() {
		job = jobDao.getJob(2);
		assertEquals("Successfully deleted job details from the table", true, jobDao.deleteJob(job));
		System.out.println("<-----------Successfully deleted job-------->");
	}
	
	//@Ignore
	@Test
	public void testApplyJob() {
		applyJob = new ApplyJob();
		job=jobDao.getJob(3);
		applyJob.setAppliedDate(new Date());
		applyJob.setLoginname("shubham");
		applyJob.setJobId(job.getJobId());
		assertEquals("Successfully applied for job...", true, jobDao.applyJob(applyJob));
		System.out.println("<-----------Successfully applied for job-------->");
	}
	@Ignore
	@Test
	public void listAllAppliedJobs()
	{
		List<ApplyJob> listAppliedJobs = jobDao.getAllAppliedJobDetails();
	assertTrue("Successfully fetched all applied jobs from the table", jobDao.getAllAppliedJobDetails().size() > 0);
	System.out.println("<======ForumComments fetched======>");
	for (ApplyJob appliedJobs : listAppliedJobs) {
		System.out.println("ApplicationID :" +appliedJobs.getAppliationId());
		System.out.println("JobID :" + appliedJobs.getJobId());
		System.out.println("LoginName :" + appliedJobs.getLoginName());
		System.out.println("Applied Date :" + appliedJobs.getAppliedDate());
	}
	System.out.println("<-----------Successfully retrieved list of applied jobs-------->");
	}
}


