package com.aliyun.teaopenapi.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GlobalParameters extends TeaModel {

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("queries")
    public Map<String, String> queries;

    public static GlobalParameters build(Map<String, ?> map) throws Exception {
        return (GlobalParameters) TeaModel.build(map, new GlobalParameters());
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getQueries() {
        return this.queries;
    }

    public GlobalParameters setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public GlobalParameters setQueries(Map<String, String> map) {
        this.queries = map;
        return this;
    }
}
