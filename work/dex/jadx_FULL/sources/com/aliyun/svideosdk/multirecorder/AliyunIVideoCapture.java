package com.aliyun.svideosdk.multirecorder;

import android.view.View;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunIVideoCapture {
    AliyunICameraCapture addCameraCapture(AliyunLayoutParam aliyunLayoutParam);

    AliyunIViewCapture addViewCapture(AliyunLayoutParam aliyunLayoutParam, View view);
}
