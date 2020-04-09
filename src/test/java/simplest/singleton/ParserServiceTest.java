package simplest.singleton;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class ParserServiceTest {

    private final Supplier<ParserService> getInstanceSupplier = ()->{
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
        }
        return ParserService.getInstance();
    };

    @Test
    void getInstance() {
        ParserService parserService = ParserService.getInstance();
        String parseResult = parserService.parse("<title><title><body>name <p>lisa</p></body>");
        log.debug(parseResult);
        assertTrue(parserService instanceof ParserService);
    }

    /*
     * 测试在同一线程中的多次调用返回结果是相同的
     */
    @Test
    @DisplayName("同一线程中的多次调用 getInstance")
    void testMultipleCallsReturnSameObjectInSameThread(){
        ParserService ps1 = getInstanceSupplier.get();
        ParserService ps2 = getInstanceSupplier.get();
        ParserService ps3 = getInstanceSupplier.get();
        assertSame(ps1,ps2);
        assertSame(ps1,ps3);
    }

    @Test
    @DisplayName("多线程调用 getInstance")
    public void testMultipleCallsReturnSameObjectInMultipleThread() throws Exception{
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "50");

        int taskNum = 5000;
        CompletableFuture[] xs = new CompletableFuture[taskNum];
        for(int i=0;i<taskNum;i++){
            xs[i] = CompletableFuture.supplyAsync(getInstanceSupplier);
        }

        CompletableFuture.allOf(xs).join();

        ParserService expectedInstance = getInstanceSupplier.get();

        for(int i=0;i<taskNum;i++){
            assertSame(expectedInstance, xs[i].get());
        }


    }
}