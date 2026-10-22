package com.huachenjie.common.aliyun.base;

import com.huachenjie.common.bean.OssTokenInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface AliyunTokenCallback {
    void a(OssTokenInfo tokenInfo);

    void onFailed(int code, String message);
}
