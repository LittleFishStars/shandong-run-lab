package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetRealPersonVerificationResultResponseBody extends TeaModel {

    @NameInMap("Data")
    public GetRealPersonVerificationResultResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class GetRealPersonVerificationResultResponseBodyData extends TeaModel {

        @NameInMap("Passed")
        public Boolean passed;

        public static GetRealPersonVerificationResultResponseBodyData build(Map<String, ?> map) throws Exception {
            return (GetRealPersonVerificationResultResponseBodyData) TeaModel.build(map, new GetRealPersonVerificationResultResponseBodyData());
        }

        public Boolean getPassed() {
            return this.passed;
        }

        public GetRealPersonVerificationResultResponseBodyData setPassed(Boolean bool) {
            this.passed = bool;
            return this;
        }
    }

    public static GetRealPersonVerificationResultResponseBody build(Map<String, ?> map) throws Exception {
        return (GetRealPersonVerificationResultResponseBody) TeaModel.build(map, new GetRealPersonVerificationResultResponseBody());
    }

    public GetRealPersonVerificationResultResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetRealPersonVerificationResultResponseBody setData(GetRealPersonVerificationResultResponseBodyData getRealPersonVerificationResultResponseBodyData) {
        this.data = getRealPersonVerificationResultResponseBodyData;
        return this;
    }

    public GetRealPersonVerificationResultResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
