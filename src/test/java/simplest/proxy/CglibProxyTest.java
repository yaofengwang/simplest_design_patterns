package simplest.proxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

@Slf4j
class CglibProxyTest {

    @Test
    void intercept() {

        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/tmp/cglib");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ParserService.class);
        enhancer.setCallback(new CglibProxy());

        ParserService parserService  = (ParserService) enhancer.create();

        log.debug("{}",parserService.parse("pdf file"));

    }
}