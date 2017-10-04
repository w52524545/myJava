package com.qc.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class QcServiceInterceptor implements Interceptor {
	public void intercept(Invocation inv) {
		System.out.println(">>>>>>QcServiceInterceptor Before method invoking<<<<<<");
		inv.invoke();
		System.out.println(">>>>>>QcServiceInterceptor After method invoking<<<<<<");
	}

}
