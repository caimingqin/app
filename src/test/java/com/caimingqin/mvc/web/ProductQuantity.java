package com.caimingqin.mvc.web;
import java.math.BigDecimal;


public class ProductQuantity {

	    private String code;
		private BigDecimal quantity;
		
		public ProductQuantity() {
		}

		public ProductQuantity(BigDecimal quantity, String code) {
			this.quantity = quantity;
			this.code = code;
		}

		public BigDecimal getQuantity() {
			return quantity;
		}

		public String getCode() {
			return code;
		}
		
		
	}