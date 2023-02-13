package com.ezen.springmvc.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AppleUtilitiesTest {
	
	// �ٸ� ������ ������ ���� ��Ű�� ���ο� �ֱ� ������ import�� �ʿ� ����.
	AppleUtilities util;
	
	@Before 
	public void beforeTest() {		
		util = new AppleUtilities();
		System.out.println("Create new apple utils.");
	}
	
	@After
	public void afterTest() {
		System.out.println("After!!");
	}
	
	@Ignore // ����θ� �ش� �׽�Ʈ skip
	@Test
	public void test1() {
		util.setBasketSize(10);
		
		// ����ϴ� ���� 6�Դϴ�.
		assertEquals("�����ߴ�", 6, util.getBasketCount(55));
	}
	
	@Test
	public void test2() {
		// ���� ���ܰ� �߻��� ���� ����ϴ� ���Դϴ�.
		assertThrows(BasketSizeTooSmallException.class, () -> {
			util.setBasketSize(-5);
		});	
	}
	
	@Test
	public void test3() {
		// �ٱ��� ũ�� ������ ���� �ʰ� ����ϴ� ��쿡 ���� ó���� �� �Ǵ��� Ȯ���ϰ� ����
		assertThrows(BasketSizeUnsetException.class, () -> {
			util.getBasketCount(99);
		});
	}
	
}