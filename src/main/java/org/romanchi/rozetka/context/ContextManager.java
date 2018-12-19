package org.romanchi.rozetka.context;

import java.util.HashMap;
import java.util.Map;

public class ContextManager {
    private static ContextManager instance = getInstance();
    static Map<String, Context> contextMap = new HashMap<>();
    static {
        contextMap.put("buy", new BuyContext());
    }
    private ContextManager(){}
    public static ContextManager getInstance(){
        if(instance == null){
            return new ContextManager();
        }else{
            return instance;
        }
    }
    public static Context getContext(String contextName){
        return contextMap.get(contextName);
    }
}
