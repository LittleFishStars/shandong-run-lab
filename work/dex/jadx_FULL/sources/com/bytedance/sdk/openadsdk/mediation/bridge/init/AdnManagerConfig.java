package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.byazt.bog.a;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@c(c = {0, 80, 81, 82, 83, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 84, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK})
public class AdnManagerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Function<SparseArray<Object>, Object> f29310a;
    private static volatile Function<SparseArray<Object>, Object> c;
    private static volatile Function<SparseArray<Object>, Object> n;
    private static volatile Function<SparseArray<Object>, Object> sp;
    private static volatile Function<SparseArray<Object>, Object> tt;
    private static volatile Function<SparseArray<Object>, Object> uj;
    private static volatile Function<SparseArray<Object>, Object> ve;

    /* JADX WARN: Code duplicated, block: B:33:0x0084  */
    private static boolean c(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        try {
            Object objNewInstance = Class.forName(str).newInstance();
            if (objNewInstance instanceof Function) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, 9000);
                sparseArray.put(-99999985, Object.class);
                Object objApply = ((Function) objNewInstance).apply(sparseArray);
                if (objApply instanceof Function) {
                    Function<SparseArray<Object>, Object> function = (Function) objApply;
                    switch (str2) {
                        case "ks":
                            ve = function;
                            return true;
                        case "gdt":
                            tt = function;
                            return true;
                        case "baidu":
                            c = function;
                            return true;
                        case "mintegral":
                            uj = function;
                            return true;
                        case "sigmob":
                            n = function;
                            return true;
                        case "unity":
                            f29310a = function;
                            return true;
                        case "xiaomi":
                            sp = function;
                            return true;
                        default:
                            return true;
                    }
                }
            }
        } catch (Throwable th) {
            a.c(th);
        }
        return false;
    }

    public static Function<SparseArray<Object>, Object> getAdapterManager(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "sigmob":
                return n;
            case "xiaomi":
                return sp;
            case "ks":
                return ve;
            case "gdt":
                return tt;
            case "baidu":
                return c;
            case "unity":
                return f29310a;
            case "mintegral":
                return uj;
            default:
                return null;
        }
    }

    public static boolean initAdnManager(String str, String str2) {
        return c(str, str2);
    }
}
