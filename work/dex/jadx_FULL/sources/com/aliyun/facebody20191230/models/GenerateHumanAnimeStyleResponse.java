package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanAnimeStyleResponse extends TeaModel {

    @NameInMap("body")
    public GenerateHumanAnimeStyleResponseBody body;

    @NameInMap("headers")
    public Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    public static GenerateHumanAnimeStyleResponse build(Map<String, ?> map) throws Exception {
        return (GenerateHumanAnimeStyleResponse) TeaModel.build(map, new GenerateHumanAnimeStyleResponse());
    }

    public GenerateHumanAnimeStyleResponseBody getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GenerateHumanAnimeStyleResponse setBody(GenerateHumanAnimeStyleResponseBody generateHumanAnimeStyleResponseBody) {
        this.body = generateHumanAnimeStyleResponseBody;
        return this;
    }

    public GenerateHumanAnimeStyleResponse setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public GenerateHumanAnimeStyleResponse setStatusCode(Integer num) {
        this.statusCode = num;
        return this;
    }
}
