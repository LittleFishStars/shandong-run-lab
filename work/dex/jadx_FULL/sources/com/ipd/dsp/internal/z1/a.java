package com.ipd.dsp.internal.z1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.ipd.dsp.internal.c2.m;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final String e = "https://api-dsp.8ziben.com/";
    public static final long f = 20251218;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedList<String> f38628a;
    public SharedPreferences b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.z1.a$a, reason: collision with other inner class name */
    public static class C0932a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38629a = new a();
    }

    public a() {
        LinkedList<String> linkedList = new LinkedList<>();
        this.f38628a = linkedList;
        linkedList.add(e);
        try {
            Context context = com.ipd.dsp.internal.l1.a.a().getContext();
            if (context == null) {
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("ipd_dsp_api", 0);
            this.b = sharedPreferences;
            this.d = m.a(sharedPreferences, NotificationCompat.CATEGORY_ERROR, 0);
            this.c = m.a(this.b, "index", 0);
        } catch (Throwable unused) {
            this.b = null;
        }
    }

    public static a a() {
        return C0932a.f38629a;
    }

    public void a(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        LinkedList<String> linkedList2 = this.f38628a;
        if (linkedList2 != null) {
            linkedList2.clear();
        }
        this.f38628a = linkedList;
    }

    public synchronized String a(String str) {
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            LinkedList<String> linkedList = this.f38628a;
            sb.append(linkedList.get(this.c % linkedList.size()));
            sb.append(str);
        } catch (Throwable unused) {
            return e + str;
        }
        return sb.toString();
    }

    public synchronized void a(int i) {
        if (i >= 500) {
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 % 3 == 0) {
                this.d = 0;
                int i3 = this.c + 1;
                this.c = i3;
                if (i3 >= this.f38628a.size()) {
                    this.c = 0;
                }
            }
            if (this.b != null) {
                HashMap map = new HashMap();
                map.put(NotificationCompat.CATEGORY_ERROR, Integer.valueOf(this.d));
                map.put("index", Integer.valueOf(this.c));
                m.a(this.b, (HashMap<String, Object>) map);
            }
        }
    }
}
