package cj.mobile.wm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.zj.adlib.bv9;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex14 {
    public static String dexa(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return TypedValues.Custom.S_FLOAT;
            case 4:
                return TypedValues.Custom.S_STRING;
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return bv9.b;
            case 13:
                return "}";
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return u15.f19942b;
            case 18:
                return "ident";
            case 19:
            default:
                return "Unknown";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
        }
    }
}
