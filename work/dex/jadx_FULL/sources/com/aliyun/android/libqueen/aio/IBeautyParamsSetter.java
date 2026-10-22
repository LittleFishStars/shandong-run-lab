package com.aliyun.android.libqueen.aio;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public interface IBeautyParamsSetter {
    void removeMaterialParams(String str);

    void setBeautyEnable(boolean z);

    void setBeautyParams(int i, float f);

    void setBeautyType(int i, boolean z);

    void setFaceShapeParams(int i, float f);

    void setFilterParams(String str);

    void setMakeupParams(int i, String str);

    void setMaterialParams(String str);
}
