package com.byazt.gxc;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTILog;
import com.bytedance.sdk.openadsdk.TTM;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2215, 13})
public class tt extends com.byazt.op.c {
    public TTILog c;
    public Object tt;

    public tt(Object obj) {
        if (obj instanceof TTILog) {
            this.c = (TTILog) obj;
        }
        this.tt = obj;
    }

    private static String c(Object obj) {
        if (obj == null) {
            return "";
        }
        TTC ttc = obj instanceof Class ? (TTC) ((Class) obj).getAnnotation(TTC.class) : (TTC) obj.getClass().getAnnotation(TTC.class);
        return ttc == null ? "" : ttc.value();
    }

    public static boolean checkType(Object obj) {
        if (obj != null) {
            try {
                if (((TTC) obj.getClass().getAnnotation(TTC.class)) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab A[RETURN] */
    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        String strStringValue = valueSet.stringValue(-8999920, "");
        String strStringValue2 = valueSet.stringValue(-8999921, "");
        Throwable th = (Throwable) valueSet.objectValue(-8999922, Throwable.class);
        switch (i) {
            case -8999924:
                T t = (T) this.tt;
                if (t != null) {
                    return t;
                }
                return null;
            case -8999923:
                Object obj = this.tt;
                if (obj != null) {
                    T t2 = (T) c(obj);
                    if (cls.isInstance(t2)) {
                        return t2;
                    }
                    return null;
                }
                return null;
            default:
                switch (i) {
                    case -8999909:
                        TTM ttm = (TTM) ((Method) valueSet.objectValue(-8999925, Method.class)).getAnnotation(TTM.class);
                        T t3 = ttm == null ? null : (T) Integer.valueOf(ttm.value());
                        if (cls.isInstance(t3)) {
                            return t3;
                        }
                        return null;
                    case -8999908:
                        TTILog tTILog = this.c;
                        if (tTILog != null) {
                            tTILog.forceLogSharding();
                        }
                        return null;
                    case -8999907:
                        TTILog tTILog2 = this.c;
                        if (tTILog2 != null) {
                            tTILog2.flush();
                        }
                        return null;
                    case -8999906:
                        TTILog tTILog3 = this.c;
                        if (tTILog3 != null) {
                            tTILog3.e(strStringValue, strStringValue2, th);
                        }
                        return null;
                    case -8999905:
                        TTILog tTILog4 = this.c;
                        if (tTILog4 != null) {
                            tTILog4.e(strStringValue, strStringValue2);
                        }
                        return null;
                    case -8999904:
                        TTILog tTILog5 = this.c;
                        if (tTILog5 != null) {
                            tTILog5.w(strStringValue, strStringValue2, th);
                        }
                        return null;
                    case -8999903:
                        TTILog tTILog6 = this.c;
                        if (tTILog6 != null) {
                            tTILog6.w(strStringValue, strStringValue2);
                        }
                        return null;
                    case -8999902:
                        TTILog tTILog7 = this.c;
                        if (tTILog7 != null) {
                            tTILog7.i(strStringValue, strStringValue2);
                        }
                        return null;
                    case -8999901:
                        TTILog tTILog8 = this.c;
                        if (tTILog8 != null) {
                            tTILog8.d(strStringValue, strStringValue2);
                        }
                        return null;
                    case -8999900:
                        TTILog tTILog9 = this.c;
                        if (tTILog9 != null) {
                            tTILog9.v(strStringValue, strStringValue2);
                        }
                        return null;
                    default:
                        return null;
                }
        }
    }

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999978, Boolean.TRUE);
        return sparseArray;
    }
}
