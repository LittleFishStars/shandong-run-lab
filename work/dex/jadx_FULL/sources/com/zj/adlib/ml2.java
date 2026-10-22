package com.zj.adlib;

import com.huachenjie.common.aliyun.base.AliyunTokenConfig;
import com.huachenjie.common.bean.OssTokenInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ml2 extends AliyunTokenConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ml2 f43326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OssTokenInfo f18246a;

    public static ml2 j() {
        if (f43326a == null) {
            synchronized (ml2.class) {
                if (f43326a == null) {
                    f43326a = new ml2();
                }
            }
        }
        return f43326a;
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public OssTokenInfo e() {
        if (this.f18246a == null) {
            this.f18246a = new OssTokenInfo();
        }
        return this.f18246a;
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public String f() {
        return "1";
    }

    @Override // com.huachenjie.common.aliyun.base.AliyunTokenConfig
    public void i(OssTokenInfo tokenInfo) {
        this.f18246a = tokenInfo;
    }
}
