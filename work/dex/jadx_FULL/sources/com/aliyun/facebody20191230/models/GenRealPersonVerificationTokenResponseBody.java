package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenRealPersonVerificationTokenResponseBody extends TeaModel {

    @NameInMap("Data")
    public GenRealPersonVerificationTokenResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class GenRealPersonVerificationTokenResponseBodyData extends TeaModel {

        @NameInMap("VerificationToken")
        public String verificationToken;

        public static GenRealPersonVerificationTokenResponseBodyData build(Map<String, ?> map) throws Exception {
            return (GenRealPersonVerificationTokenResponseBodyData) TeaModel.build(map, new GenRealPersonVerificationTokenResponseBodyData());
        }

        public String getVerificationToken() {
            return this.verificationToken;
        }

        public GenRealPersonVerificationTokenResponseBodyData setVerificationToken(String str) {
            this.verificationToken = str;
            return this;
        }
    }

    public static GenRealPersonVerificationTokenResponseBody build(Map<String, ?> map) throws Exception {
        return (GenRealPersonVerificationTokenResponseBody) TeaModel.build(map, new GenRealPersonVerificationTokenResponseBody());
    }

    public GenRealPersonVerificationTokenResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GenRealPersonVerificationTokenResponseBody setData(GenRealPersonVerificationTokenResponseBodyData genRealPersonVerificationTokenResponseBodyData) {
        this.data = genRealPersonVerificationTokenResponseBodyData;
        return this;
    }

    public GenRealPersonVerificationTokenResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}
