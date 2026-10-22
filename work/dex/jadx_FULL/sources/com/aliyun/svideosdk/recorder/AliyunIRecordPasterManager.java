package com.aliyun.svideosdk.recorder;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController;
import com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController;
import com.aliyun.svideosdk.recorder.impl.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Visible
public interface AliyunIRecordPasterManager {
    AliyunRecordPasterController addFacePaster(Source source);

    AliyunRecordWaterMarkController addImage(Source source);

    AliyunRecordPasterController addPaster(Source source);

    void remove(a aVar);
}
