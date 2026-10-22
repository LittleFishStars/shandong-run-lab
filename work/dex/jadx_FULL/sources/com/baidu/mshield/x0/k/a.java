package com.baidu.mshield.x0.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.mshield.x0.c.c;
import com.baidu.mshield.x0.d.b;
import com.baidu.mshield.x0.d.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: com.baidu.mshield.x0.k.a$a, reason: collision with other inner class name */
    public static class C0285a implements com.baidu.mshield.x0.j.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26752a;

        public C0285a(Context context) {
            this.f26752a = context;
        }

        @Override // com.baidu.mshield.x0.j.a.b
        public void a(int i) {
            b.a(this.f26752a, (com.baidu.mshield.x0.l.a) null);
            com.baidu.mshield.x0.c.a.a(this.f26752a);
        }
    }

    public static void a(Context context, Intent intent) {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    public static void a(Context context, String str) {
        byte b;
        if (str == null) {
            return;
        }
        try {
            com.baidu.mshield.b.c.a.b("secac=" + str);
            int iHashCode = str.hashCode();
            if (iHashCode != 1083937949) {
                if (iHashCode == 1278732294 && str.equals("com.baidu.mshield.x0.detect.app.fr")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("com.baidu.mshield.x0.timer.pp.action")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0) {
                a(context);
            } else {
                if (b != 1) {
                    return;
                }
                c.a(context);
                b.c(context);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void a(Context context) {
        try {
            com.baidu.mshield.x0.j.a.a(context).a((com.baidu.mshield.x0.j.a.b) new C0285a(context), true);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
