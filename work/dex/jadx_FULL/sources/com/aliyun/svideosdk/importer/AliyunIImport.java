package com.aliyun.svideosdk.importer;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.AliyunIClipConstructor;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIImport extends AliyunIClipConstructor {
    String generateProjectConfigure();

    void release();

    void setVideoParam(AliyunVideoParam aliyunVideoParam);
}
