package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MonitorExaminationResponse extends TeaModel {

    @NameInMap("body")
    public MonitorExaminationResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static MonitorExaminationResponse build(Map<String, ?> map) throws Exception {
        return (MonitorExaminationResponse) TeaModel.build(map, new MonitorExaminationResponse());
    }

    public MonitorExaminationResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public MonitorExaminationResponse setBody(MonitorExaminationResponseBody monitorExaminationResponseBody) {
        this.body = monitorExaminationResponseBody;
        return this;
    }

    public MonitorExaminationResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public MonitorExaminationResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
