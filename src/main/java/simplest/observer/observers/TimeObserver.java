package simplest.observer.observers;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class TimeObserver implements RequestObserver {
    private long startTime;

    @Override
    public void preHandle(String request) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterCompletion(String request,String response) {
        long endTime = System.currentTimeMillis();
        log.info("request {}, start:{},end:{},time:{} ms",request, startTime,endTime,(endTime - startTime));

    }
}
