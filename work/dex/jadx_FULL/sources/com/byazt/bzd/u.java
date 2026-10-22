package com.byazt.bzd;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.zj.adlib.c49;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 67})
public final class u {
    public static Map<String, Field> c = new HashMap();

    public static boolean a(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null && (objApply = functionA.apply(com.byazt.yxi.uj.c().c(5).c(Boolean.class).c(0, str).tt())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
        }
        return false;
    }

    public static void c(String str, int i) {
        if (i > 0) {
            try {
                if (p.uj < 7500) {
                    tt(str, i);
                    return;
                }
            } catch (Throwable th) {
                m.c(th);
                return;
            }
        }
        Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
        if (functionA != null) {
            functionA.apply(com.byazt.yxi.uj.c().c(100).c(Void.class).c(0, str).c(1, Integer.valueOf(i)).tt());
        }
    }

    public static ClassLoader i(String str) {
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null) {
                return (ClassLoader) functionA.apply(com.byazt.yxi.uj.c().c(4).c(ClassLoader.class).c(0, str).tt());
            }
            return null;
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
            return null;
        }
    }

    public static int n(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? p.uj : ve(str, 102);
    }

    public static JSONObject sp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null) {
                Object objApply = functionA.apply(com.byazt.yxi.uj.c().c(13).c(JSONObject.class).c(0, str).tt());
                if (objApply instanceof JSONObject) {
                    return (JSONObject) objApply;
                }
            }
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
        }
        return null;
    }

    public static void tt(String str, int i) {
        try {
            File[] fileArrC = c(str);
            if (fileArrC != null) {
                for (File file : fileArrC) {
                    if (Integer.parseInt(file.getName().split(c49.f40900a)[1]) == i) {
                        n.tt(file);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public static List<Integer> uj(String str) {
        if (p.uj >= 7500) {
            Object objUj = uj(str, 110);
            if (objUj instanceof List) {
                return (List) objUj;
            }
            return null;
        }
        File[] fileArrC = c(str);
        ArrayList arrayList = new ArrayList();
        if (fileArrC != null) {
            for (File file : fileArrC) {
                arrayList.add(Integer.valueOf(Integer.parseInt(file.getName().split(c49.f40900a)[1])));
            }
        }
        return arrayList;
    }

    public static int ve(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7611;
        }
        return ve(str, 103);
    }

    public static boolean x(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null && (objApply = functionA.apply(com.byazt.yxi.uj.c().c(105).c(Boolean.class).c(0, str).tt())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
        }
        return false;
    }

    public static int ve(String str, int i) {
        Object objUj = uj(str, i);
        if (objUj instanceof Integer) {
            return ((Integer) objUj).intValue();
        }
        return 0;
    }

    public static int tt(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return p.uj;
        }
        return ve(str, 101);
    }

    private static Object uj(String str, int i) {
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null) {
                return functionA.apply(com.byazt.yxi.uj.c().c(i).c(Integer.class).c(0, str).tt());
            }
            return null;
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
            return null;
        }
    }

    public static File[] c(String str) {
        return new File(com.byazt.nr.sp.c(gt.getContext(), false, null).getParent() + "/pangle_p/" + str).listFiles(new FileFilter() { // from class: com.byazt.bzd.u.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
    }

    public static void c() {
        try {
            Function<SparseArray<Object>, Object> functionA = com.byazt.omf.x.m().a(4);
            if (functionA != null) {
                functionA.apply(com.byazt.yxi.uj.c().c(109).c(Boolean.class).tt());
            }
        } catch (Throwable th) {
            m.tt("ZeusUtil", th);
        }
    }
}
