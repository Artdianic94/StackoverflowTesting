package API.models;

import java.util.HashMap;
import java.util.Map;

public class QueryModel {

    public Map<String, String> getQueryParamsForLastTenAnswers() {
        Map<String, String> getQueryModelMap = new HashMap<>();
        getQueryModelMap.put("site", "stackoverflow");
        getQueryModelMap.put("page", "1");
        getQueryModelMap.put("pagesize", "10");
        getQueryModelMap.put("order", "desc");
        getQueryModelMap.put("sort", "activity");
        getQueryModelMap.put("filter", "default");
        return getQueryModelMap;
    }
}
