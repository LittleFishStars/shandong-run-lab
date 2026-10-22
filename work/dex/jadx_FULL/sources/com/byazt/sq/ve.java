package com.byazt.sq;

import android.util.SparseArray;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTILog;
import com.bytedance.sdk.openadsdk.TTM;
import java.lang.reflect.Method;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 54})
public class ve {

    public interface c {
        void c();

        void c(String str, String str2);

        void c(String str, String str2, Throwable th);

        void c(String str, Throwable th);

        void n(String str, String str2);

        void tt(String str, String str2);

        void tt(String str, String str2, Throwable th);

        void uj(String str, String str2);

        void ve(String str, String str2);
    }

    public static void c(Object obj) {
        try {
            if (!tt(obj)) {
                if (obj != null) {
                    c(null, obj, uj(obj), false);
                    return;
                }
                return;
            }
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -8999924);
            sparseArray.put(-99999985, Object.class);
            Object objApply = function.apply(sparseArray);
            if (objApply != null) {
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(-99999987, -8999923);
                sparseArray2.put(-99999985, String.class);
                c(function, objApply, (String) function.apply(sparseArray2), true);
            }
        } catch (Throwable th) {
            m.tt("HookObject", "register object  " + obj + " failed for: " + th.getMessage());
        }
    }

    public static boolean tt(Object obj) {
        Boolean bool;
        if (obj == null || !(obj instanceof Function)) {
            return false;
        }
        try {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -99999986);
            sparseArray.put(-99999985, SparseArray.class);
            SparseArray sparseArray2 = (SparseArray) ((Function) obj).apply(sparseArray);
            return (sparseArray2 == null || (bool = (Boolean) sparseArray2.get(-99999978)) == null || !bool.booleanValue()) ? false : true;
        } catch (Exception e) {
            m.c(e);
        }
        return false;
    }

    private static String uj(Object obj) {
        if (obj == null) {
            return "";
        }
        TTC ttc = obj instanceof Class ? (TTC) ((Class) obj).getAnnotation(TTC.class) : (TTC) obj.getClass().getAnnotation(TTC.class);
        return ttc == null ? "" : ttc.value();
    }

    public static void ve(Object obj) {
        String strUj = "";
        try {
            if (tt(obj)) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999923);
                sparseArray.put(-99999985, String.class);
                strUj = (String) ((Function) obj).apply(sparseArray);
            } else {
                TTC ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
                if (ttc != null) {
                    strUj = uj(ttc);
                }
            }
        } catch (Throwable unused) {
        }
        strUj.hashCode();
        if (strUj.equals("net")) {
            com.byazt.tb.ve.c = null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 900, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt implements c {
        public Object c;
        public Function tt;

        public tt(Object obj) {
            this.c = obj;
        }

        @Override // com.byazt.sq.ve.c
        public void c(String str, String str2) {
            if (this.tt != null) {
                c(-8999900, str, str2, null);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).v(str, str2);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void n(String str, String str2) {
            if (this.tt != null) {
                c(-8999905, str, str2, null);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).e(str, str2);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void tt(String str, String str2) {
            if (this.tt != null) {
                c(-8999901, str, str2, null);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).d(str, str2);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void uj(String str, String str2) {
            if (this.tt != null) {
                c(-8999903, str, str2, null);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).w(str, str2);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void ve(String str, String str2) {
            if (this.tt != null) {
                c(-8999902, str, str2, null);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).i(str, str2);
            }
        }

        public tt(Function<SparseArray<Object>, Object> function) {
            this.tt = function;
        }

        @Override // com.byazt.sq.ve.c
        public void c(String str, String str2, Throwable th) {
            if (this.tt != null) {
                c(-8999903, str, str2, th);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).w(str, str2, th);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void tt(String str, String str2, Throwable th) {
            if (this.tt != null) {
                c(-8999905, str, str2, th);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).e(str, str2, th);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void c(String str, Throwable th) {
            if (this.tt != null) {
                c(-8999905, str, null, th);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).e(str, th);
            }
        }

        @Override // com.byazt.sq.ve.c
        public void c() {
            if (this.tt != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, -8999907);
                sparseArray.put(-99999985, Void.class);
                this.tt.apply(sparseArray);
            }
            Object obj = this.c;
            if (obj != null) {
                ((TTILog) obj).flush();
            }
        }

        private void c(int i, String str, String str2, Throwable th) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, Integer.valueOf(i));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(-8999920, str);
            sparseArray.put(-8999921, str2);
            sparseArray.put(-8999922, th);
            this.tt.apply(sparseArray);
        }
    }

    private static void tt(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        if (m.ve()) {
            com.byazt.tb.ve veVar = new com.byazt.tb.ve();
            com.byazt.tb.ve.c = veVar;
            try {
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    if (z) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, -8999909);
                        sparseArray.put(-99999985, Integer.class);
                        sparseArray.put(-8999925, method);
                        Integer num = (Integer) function.apply(sparseArray);
                        if (num != null) {
                            method.setAccessible(true);
                            veVar.c(num.intValue(), method);
                        }
                    } else {
                        TTM ttm = (TTM) method.getAnnotation(TTM.class);
                        if (ttm != null) {
                            method.setAccessible(true);
                            veVar.c(ttm.value(), method);
                        }
                    }
                }
            } catch (Throwable th) {
                m.c(th);
            }
            veVar.c(obj);
        }
    }

    private static void c(Function<SparseArray<Object>, Object> function, Object obj, String str, boolean z) {
        if (obj == null) {
            return;
        }
        str.hashCode();
        if (str.equals("log")) {
            c(function, obj, z);
        } else if (str.equals("net")) {
            tt(function, obj, z);
        }
        m.tt("HookObject", "register object  " + obj + " successed~ ");
    }

    private static void c(Function<SparseArray<Object>, Object> function, Object obj, boolean z) {
        try {
            if (z) {
                com.byazt.zlb.tt.c((c) new tt(function), true);
            } else if (obj instanceof TTILog) {
                com.byazt.zlb.tt.c((c) new tt(obj), true);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static com.byazt.tb.tt c(String str) {
        str.hashCode();
        if (str.equals("net")) {
            return com.byazt.tb.ve.c;
        }
        return null;
    }
}
