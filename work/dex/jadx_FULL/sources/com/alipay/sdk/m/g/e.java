package com.alipay.sdk.m.g;

import com.zj.adlib.bv9;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<i> f25438a;

    static {
        ArrayList arrayList = new ArrayList();
        f25438a = arrayList;
        arrayList.add(new l());
        f25438a.add(new d());
        f25438a.add(new c());
        f25438a.add(new h());
        f25438a.add(new k());
        f25438a.add(new b());
        f25438a.add(new a());
        f25438a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : f25438a) {
            if (iVar.a(com.alipay.sdk.m.h.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        org.json.alipay.a bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            bVar = new org.json.alipay.a(strTrim);
        } else {
            if (!strTrim.startsWith(bv9.b) || !strTrim.endsWith("}")) {
                return a((Object) strTrim, type);
            }
            bVar = new org.json.alipay.b(strTrim);
        }
        return a(bVar, type);
    }
}
