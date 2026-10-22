package com.aliyun.common.network;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AlivcHttpResponse {
    private String body;
    private Map<String, List<String>> responseHeaderMap;
    private int statusCode;
    private String statusMessage;
    private String[] responseHeaderKeyArray = null;
    protected final AlivcHttpMetrics metrics = new AlivcHttpMetrics();

    public AlivcHttpResponse(int i, String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    private void initResponseHeaderKeyArray() {
        if (this.responseHeaderMap == null || this.responseHeaderKeyArray != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.responseHeaderMap.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        this.responseHeaderKeyArray = (String[]) arrayList.toArray(new String[0]);
    }

    public String getBody() {
        return this.body;
    }

    public AlivcHttpMetrics getMetrics() {
        return this.metrics;
    }

    public String getResponseHeaderKey(int i) {
        initResponseHeaderKeyArray();
        return (this.responseHeaderKeyArray == null || i < 0 || i >= getResponseHeaderSize()) ? "" : this.responseHeaderKeyArray[i];
    }

    public int getResponseHeaderSize() {
        initResponseHeaderKeyArray();
        String[] strArr = this.responseHeaderKeyArray;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public String getResponseHeaderValue(int i) {
        List<String> list;
        String responseHeaderKey = getResponseHeaderKey(i);
        return (TextUtils.isEmpty(responseHeaderKey) || (list = this.responseHeaderMap.get(responseHeaderKey)) == null || list.isEmpty()) ? "" : list.get(0);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setResponseHeaders(Map<String, List<String>> map) {
        this.responseHeaderMap = map;
        this.responseHeaderKeyArray = null;
    }
}
