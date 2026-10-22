package com.aliyun.svideosdk.editor.impl;

import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AliyunIBaseCompose;
import com.aliyun.svideosdk.editor.AliyunICompose;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunComposeFactory {
    public static AliyunIBaseCompose createAliyunBaseCompose() {
        return new AliyunBaseCompose();
    }

    public static AliyunICompose createAliyunCompose() {
        return new AliyunCompose();
    }

    public static AliyunVodCompose createAliyunVodCompose() {
        return new AliyunVodCompose();
    }
}
