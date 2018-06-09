package chapter08.listener;

import javax.el.ELContextEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.jsp.JspFactory;

/**
 * 使用监听器导入类型
 * @author mohan
 *
 */
@WebListener
public class ELImportListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		JspFactory.getDefaultFactory().getJspApplicationContext(event.getServletContext())
			.addELContextListener(
				(ELContextEvent e) -> {
//					e.getELContext().getImportHandler().importPackage("java.time");
//					e.getELContext().getImportHandler().importPackage("java.util");
				});
	}
	
}
