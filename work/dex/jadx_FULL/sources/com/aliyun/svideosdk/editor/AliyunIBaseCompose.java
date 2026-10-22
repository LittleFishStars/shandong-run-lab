package com.aliyun.svideosdk.editor;

import android.content.Context;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIBaseCompose {
    int cancelCompose();

    int compose(String str, String str2, AliyunIComposeCallBack aliyunIComposeCallBack);

    int init(Context context);

    int pauseCompose();

    void release();

    int resumeCompose();

    void setRenderCallback(AliyunIRenderCallback aliyunIRenderCallback);
}
