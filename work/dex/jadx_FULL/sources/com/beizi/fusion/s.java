package com.beizi.fusion;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class s {
    public static boolean a(Map map, String str, boolean z) {
        if (map != null) {
            Object obj = map.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return z;
    }

    public static String a(Map map, String str) {
        if (map == null) {
            return "";
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : "";
    }

    public static int a(Map map, String str, int i) {
        Object obj;
        if (map != null && (obj = map.get(str)) != null) {
            try {
                return Integer.parseInt(obj.toString());
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }
}
