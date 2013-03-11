package com.caimingqin.app.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import com.caimingqin.app.query.AppQuery;

public class AnnotationIocTest {

	@Test
	public void ann(){
		AnnotationConfigApplicationContext ann = new AnnotationConfigApplicationContext();
		ann.scan("com.caimingqin.app.query.jdbc");
		AppQuery bean = ann.getBean(AppQuery.class);
		System.out.println(bean);
	}
	
	private static final String                  PATH           = "classpath*:com/alibaba/javalab/t*/**/*.class"; 
	private static final ResourcePatternResolver RESOLVER       = new PathMatchingResourcePatternResolver(); 
	private static final MetadataReaderFactory   READER_FACTORY = new SimpleMetadataReaderFactory(); 
//	@Test
//	public void ann2(){
//		   /* ��Դ·�� */ 
//	      /* ��Դ������ */ 
//	     /* Meta��ϢReader Factory.���ڴ���MetaReader */ 
//	         //����������ʽ,�õ���Դ�б� 
//	         Resource[] resources = RESOLVER.getResources(PATH); 
//	         for (Resource res : resources) { 
//	             //ͨ�� MetadataReader�õ�ClassMeta��Ϣ,��ӡ���� 
//	             MetadataReader meta = READER_FACTORY.getMetadataReader(res); 
//	             System.out.println(meta.getClassMetadata().getClassName()); 
//	     } 
//	}
}
