package com.aliyun.svideosdk.nativeload;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AlivcAudioProxy {
    public static boolean sNeedAudiTrack = false;
    public static String sPackageName;

    public static boolean registAudioInstance(String str) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            return false;
        }
        sPackageName = str.replace(Consts.DOT, WVNativeCallbackUtil.SEPERATER);
        return true;
    }
}
