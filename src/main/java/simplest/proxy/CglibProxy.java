package simplest.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.debug("CglibProxy intercept start");
        Object obj = methodProxy.invokeSuper(o, objects);
        log.debug("CglibProxy intercept end");
        return  obj;
    }
}
