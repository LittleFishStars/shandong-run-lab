package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetRealPersonVerificationResultRequest extends TeaModel {

    @NameInMap("VerificationToken")
    public String verificationToken;

    public static GetRealPersonVerificationResultRequest build(Map<String, ?> map) throws Exception {
        return (GetRealPersonVerificationResultRequest) TeaModel.build(map, new GetRealPersonVerificationResultRequest());
    }

    public String getVerificationToken() {
        return this.verificationToken;
    }

    public GetRealPersonVerificationResultRequest setVerificationToken(String str) {
        this.verificationToken = str;
        return this;
    }
}
