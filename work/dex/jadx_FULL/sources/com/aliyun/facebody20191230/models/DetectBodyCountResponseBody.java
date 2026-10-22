package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectBodyCountResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectBodyCountResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectBodyCountResponseBodyData extends TeaModel {

        @NameInMap("PersonNumber")
        public Integer personNumber;

        public static DetectBodyCountResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectBodyCountResponseBodyData) TeaModel.build(map, new DetectBodyCountResponseBodyData());
        }

        public Integer getPersonNumber() {
            return this.personNumber;
        }

        public DetectBodyCountResponseBodyData setPersonNumber(Integer num) {
            this.personNumber = num;
            return this;
        }
    }

    public static DetectBodyCountResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectBodyCountResponseBody) TeaModel.build(map, new DetectBodyCountResponseBody());
    }

    public DetectBodyCountResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectBodyCountResponseBody setData(DetectBodyCountResponseBodyData detectBodyCountResponseBodyData) {
        this.data = detectBodyCountResponseBodyData;
        return this;
    }

    public DetectBodyCountResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
