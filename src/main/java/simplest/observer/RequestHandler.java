package simplest.observer;

import lombok.extern.slf4j.Slf4j;
import simplest.observer.observers.RequestObserver;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RequestHandler {

    private  String request;
    private  String response;


    private List<RequestObserver> requestObserverList = new ArrayList<RequestObserver>();

    public void addObserver(RequestObserver observer){
        requestObserverList.add(observer);
    }

    public void receiveRequest(String request){
        this.request =  request;
        log.debug("receive a request:{}", request);
        this.receiveRequestNotify();
    }

    public void completeRequest(){
        this.response =  this.request + " completed";
        log.debug("completed a request:{}, response:{}", request,response);
        this.completeRequestNotify();
    }

    private  void receiveRequestNotify(){
        requestObserverList.stream().forEach((requestObserver)->requestObserver.preHandle(this.request));
    }


    private  void completeRequestNotify(){
        requestObserverList.stream().forEach((requestObserver)->requestObserver.afterCompletion(this.request,this.response));
    }
}
