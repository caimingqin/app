package com.caimingqin.app.rs;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caimingqin.app.defaults.DefualtDomainEventPublisherObserve;


@Controller
@RequestMapping("base")
public class BaseController implements ApplicationContextAware {

	@Autowired
	private ProductQuery productQuery;
	private BeanFactory beanFactory;
	@ResponseBody
	@RequestMapping(value="/product/{condition}")
	public List<Product> find(@PathVariable String condition){
		System.out.println("this.beanFactory"+beanFactory.getBean("CommonEventHaldler"));
		System.out.println("this.beanFactory"+beanFactory.getBean(DefualtDomainEventPublisherObserve.class));
		return productQuery.findProductByCondition(condition);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext "+applicationContext);
        this.beanFactory=applicationContext;		
	}
}
