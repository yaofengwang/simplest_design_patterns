package simplest.observer.observers;

public interface RequestObserver {

    void preHandle(String request);

    void afterCompletion(String request,String response);

}
