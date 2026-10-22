package com.alibaba.sdk.android.oss.common.auth;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class OSSCustomSignerCredentialProvider implements OSSCredentialProvider {
    @Override // com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
    public OSSFederationToken getFederationToken() {
        return null;
    }

    public abstract String signContent(String str);
}
