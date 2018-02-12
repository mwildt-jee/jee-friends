package de.hsw.jee.friends.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Trace
@Interceptor
public class TraceInterceptor {

	final Logger LOG = LoggerFactory.getLogger(TraceInterceptor.class);
	
    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        LOG.info(">> {}::{}", 
        		invocationContext.getMethod().getDeclaringClass().getName(),
        		invocationContext.getMethod().getName());
        
        final Object res =  invocationContext.proceed();

        LOG.info("<< {}::{}", 
        		invocationContext.getMethod().getDeclaringClass().getName(),
        		invocationContext.getMethod().getName());
        
        return res;
    }
	
	
}
