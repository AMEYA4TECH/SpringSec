package org.arpit.java2blog.springmvc.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/springmvc-dispatcher-servlet.xml")
public class HelloWorldControllerTest {
@Autowired
	private HelloWorldController heelobj;

	@Test
	public void testHello() {
		ModelMap mp=new ModelMap();
		//heelobj=new HelloWorldController();
	String str=heelobj.login(mp);
		assertEquals("logi11n",str);
		//fail("Not yet implemented");
	}

	@Test
	public void testHello1() {
		ModelMap mp=new ModelMap();
		heelobj=new HelloWorldController();
	String str=heelobj.login(mp);
		assertEquals("login",str);
		//fail("Not yet implemented");
	}
}
