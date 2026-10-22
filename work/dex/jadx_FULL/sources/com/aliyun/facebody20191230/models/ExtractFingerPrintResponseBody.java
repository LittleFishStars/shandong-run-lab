package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractFingerPrintResponseBody extends TeaModel {

    @NameInMap("Data")
    public ExtractFingerPrintResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class ExtractFingerPrintResponseBodyData extends TeaModel {

        @NameInMap("FingerPrint")
        public String fingerPrint;

        public static ExtractFingerPrintResponseBodyData build(Map<String, ?> map) throws Exception {
            return (ExtractFingerPrintResponseBodyData) TeaModel.build(map, new ExtractFingerPrintResponseBodyData());
        }

        public String getFingerPrint() {
            return this.fingerPrint;
        }

        public ExtractFingerPrintResponseBodyData setFingerPrint(String str) {
            this.fingerPrint = str;
            return this;
        }
    }

    public static ExtractFingerPrintResponseBody build(Map<String, ?> map) throws Exception {
        return (ExtractFingerPrintResponseBody) TeaModel.build(map, new ExtractFingerPrintResponseBody());
    }

    public ExtractFingerPrintResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ExtractFingerPrintResponseBody setData(ExtractFingerPrintResponseBodyData extractFingerPrintResponseBodyData) {
        this.data = extractFingerPrintResponseBodyData;
        return this;
    }

    public ExtractFingerPrintResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
