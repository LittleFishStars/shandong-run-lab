package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenRealPersonVerificationTokenRequest extends TeaModel {

    @NameInMap("CertificateName")
    public String certificateName;

    @NameInMap("CertificateNumber")
    public String certificateNumber;

    @NameInMap("MetaInfo")
    public String metaInfo;

    public static GenRealPersonVerificationTokenRequest build(Map<String, ?> map) throws Exception {
        return (GenRealPersonVerificationTokenRequest) TeaModel.build(map, new GenRealPersonVerificationTokenRequest());
    }

    public String getCertificateName() {
        return this.certificateName;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getMetaInfo() {
        return this.metaInfo;
    }

    public GenRealPersonVerificationTokenRequest setCertificateName(String str) {
        this.certificateName = str;
        return this;
    }

    public GenRealPersonVerificationTokenRequest setCertificateNumber(String str) {
        this.certificateNumber = str;
        return this;
    }

    public GenRealPersonVerificationTokenRequest setMetaInfo(String str) {
        this.metaInfo = str;
        return this;
    }
}
