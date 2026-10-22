package com.baidu.mapsdkplatform.comapi.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordTrans {
    public static LatLng baiduToGcj(LatLng latLng) {
        double[] dArrBaiduToGcj;
        if (latLng == null || (dArrBaiduToGcj = JNITools.baiduToGcj(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(dArrBaiduToGcj[0], dArrBaiduToGcj[1]);
    }

    public static LatLng gcjToBaidu(LatLng latLng) {
        double[] dArrGcjToBaidu;
        if (latLng == null || (dArrGcjToBaidu = JNITools.gcjToBaidu(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(dArrGcjToBaidu[0], dArrGcjToBaidu[1]);
    }

    public static LatLng wgsToBaidu(LatLng latLng) {
        double[] dArrWgsToBaidu;
        if (latLng == null || (dArrWgsToBaidu = JNITools.wgsToBaidu(latLng.latitude, latLng.longitude)) == null) {
            return null;
        }
        return new LatLng(dArrWgsToBaidu[0], dArrWgsToBaidu[1]);
    }
}
