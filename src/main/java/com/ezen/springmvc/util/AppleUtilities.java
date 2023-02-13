package com.ezen.springmvc.util;

public class AppleUtilities {
	
	Integer basketSize;
	
	public void setBasketSize(int basket_size) throws BasketSizeTooSmallException {
		if (basket_size <= 0) {
			throw new BasketSizeTooSmallException("Basket size is too small.");
		}
		
		this.basketSize = basket_size;
	}
	
	public int getBasketCount(int apple) {
		if (basketSize == null) {
			throw new BasketSizeUnsetException("basket size not initialized.");
		}
		
		return apple % basketSize == 0 ? 
				apple / basketSize : apple / basketSize + 1;
	}

}
