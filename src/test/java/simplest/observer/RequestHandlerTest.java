package simplest.observer;

import org.junit.jupiter.api.Test;
import simplest.observer.observers.TimeObserver;

import static org.junit.jupiter.api.Assertions.*;

class RequestHandlerTest {

    @Test
    void addObserver() throws  Exception {
        RequestHandler requestHandler = new RequestHandler();
        requestHandler.addObserver(new TimeObserver());

        requestHandler.receiveRequest("req A");
        Thread.sleep(400);
        requestHandler.completeRequest();

        requestHandler.receiveRequest("req B");
        Thread.sleep(800);
        requestHandler.completeRequest();

    }
}