package com.aliyun.svideosdk.common.callback.recorder;

import android.hardware.Camera;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface OnChoosePictureSizeCallback {
    Camera.Size onChoosePictureSize(List<Camera.Size> list);

    Size onChoosePictureSize(SortedSet<Size> sortedSet);
}
