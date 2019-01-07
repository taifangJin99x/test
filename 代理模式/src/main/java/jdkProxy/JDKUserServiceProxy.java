package jdkProxy;

import java.lang.reflect.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKUserServiceProxy implements InvocationHandler {
    private Object target;
    public JDKUserServiceProxy(Object target){
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),  this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始事务");
        Object result = method.invoke(target, args);
        System.out.println("结束事务");
        return result;
    }
}
