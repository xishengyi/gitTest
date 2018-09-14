package cn.ylcto.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ylcto.student.service.INoteService;
import junit.framework.TestCase;

public class testone {
	private static ApplicationContext ctx;
	@Resource
	private static INoteService noteserivice;
	static{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		noteserivice = ctx.getBean("NoteServiceImpl", INoteService.class);
	}
	@Test
	public void list() throws Exception {
	Map<String,Object> map = this.noteserivice.listSplit(1,2);
	System.out.println( map.get("allNote"));
	System.out.println( map.get("noteCount"));
	TestCase.assertTrue(map.size()==2);
}
}