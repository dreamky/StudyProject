package com.dreamky.thread.bank;

import java.math.BigDecimal;

/**
 * 
 * @author Administrator 模拟银行取钱的问题<br>
 * 
 *         1.定义一个Account类<br>
 *         1）该Account类封装了账户编号（String）和余额（double）两个属性<br>
 *         2）设置相应属性的getter和setter方法<br>
 *         3）提供无参和有两个参数的构造器<br>
 *         4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写<br>
 *         2.提供一个取钱的线程类<br>
 *         1）提供了Account类的account属性和double类的取款额的属性<br>
 *         2）提供带线程名的构造方法<br>
 *         3）run()方法中提供取钱的操作<br>
 *         3.在主类中创建线程进行测试。考虑线程安全问题。<br>
 * 
 */
public class Bank {

	public static void main(String[] args) {}

}
