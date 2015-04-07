package org.sample.naversmarteditor.springconfig.reslover;

import java.util.Properties;

import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

public class MyContentNegotiatingViewResolver extends ContentNegotiatingViewResolver {

	public MyContentNegotiatingViewResolver() {
		super();
		init();
	}
	
	protected void init() {
		setOrder(1);
		setContentNegotiationManager(createContentNegotiationManager());
	}

	private ContentNegotiationManager createContentNegotiationManager() {
		ContentNegotiationManagerFactoryBean bean = new ContentNegotiationManagerFactoryBean();
		
		Properties mediaTypes = new Properties();
		mediaTypes.put("json", MediaType.APPLICATION_JSON_VALUE);
		mediaTypes.put("xml", MediaType.APPLICATION_XML_VALUE);
		mediaTypes.put("rss", "application/rss+xml");
		//mediaTypes.put("pdf", "application/pdf");
		
		bean.setMediaTypes(mediaTypes);
		
		bean.setIgnoreAcceptHeader(true);
		
		//ArrayList<View> views = new ArrayList<View>();
		//views.add(new PdfInvoiceView());
		//setDefaultViews(views);
		
		try {
			bean.afterPropertiesSet();
			return bean.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
