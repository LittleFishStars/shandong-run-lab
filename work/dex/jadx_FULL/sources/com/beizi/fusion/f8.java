package com.beizi.fusion;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f8 {
    private static f8 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f27286a = new HashMap();

    public static f8 a() {
        if (b == null) {
            synchronized (f8.class) {
                if (b == null) {
                    b = new f8();
                }
            }
        }
        return b;
    }

    public x1.b.C0333b b(String str) {
        try {
            if (!TextUtils.isEmpty(str) && this.f27286a.containsKey(str)) {
                return (x1.b.C0333b) this.f27286a.get(str);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(x1.b.C0333b c0333b, String str) {
        if (c0333b == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && this.f27286a.containsKey(str)) {
                this.f27286a.put(str, c0333b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(x1.b.C0333b c0333b, String str) {
        if (c0333b == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || this.f27286a.containsKey(str)) {
                return;
            }
            this.f27286a.put(str, c0333b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && this.f27286a.containsKey(str)) {
                this.f27286a.remove(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
