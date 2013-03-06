package com.caimingqin.app.rs;

import java.util.List;


public interface ProductQuery {

	List<Product> findProductByCondition(String condition);
}
