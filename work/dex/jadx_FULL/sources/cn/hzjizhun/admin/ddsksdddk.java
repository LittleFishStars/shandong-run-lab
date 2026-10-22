package cn.hzjizhun.admin;

import cn.hzjizhun.admin.view.RootTouchViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ddsksdddk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f22714a = new HashMap();

    public static void a(String str) {
        try {
            f22714a.remove(str);
        } catch (Throwable unused) {
        }
    }

    public static RootTouchViewGroup b(String str) {
        try {
            return (RootTouchViewGroup) f22714a.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(String str, RootTouchViewGroup rootTouchViewGroup) {
        try {
            f22714a.put(str, rootTouchViewGroup);
        } catch (Throwable unused) {
        }
    }
}
