package com.aliyun.svideosdk.multirecorder;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.AliyunBorderParam;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIBaseCapture {
    int captureId();

    void removeBorder();

    void setBorderParam(AliyunBorderParam aliyunBorderParam);

    int setProperty(String str, String str2);

    void updateLayout(AliyunLayoutParam aliyunLayoutParam);
}
