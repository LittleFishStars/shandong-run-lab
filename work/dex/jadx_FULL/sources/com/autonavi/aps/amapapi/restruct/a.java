package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.zj.adlib.m4b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26177a;
    private File b;
    private Handler e;
    private String f;
    private boolean g;
    private boolean c = false;
    private Map<String, C0252a> d = new ConcurrentHashMap();
    private Runnable h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.c) {
                if (a.this.g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.e != null) {
                    a.this.e.postDelayed(a.this.h, 60000L);
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.autonavi.aps.amapapi.restruct.a$a, reason: collision with other inner class name */
    public static class C0252a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26180a;
        long b;
        long c;

        public C0252a(int i, long j, long j2) {
            this.f26180a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public a(Context context, String str, Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.f26177a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = com.autonavi.aps.amapapi.utils.i.l(context);
        try {
            this.b = new File(context.getFilesDir().getPath(), this.f26177a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static /* synthetic */ boolean e(a aVar) {
        aVar.g = false;
        return false;
    }

    public abstract void a(T t, long j);

    public abstract long b();

    public abstract String b(T t);

    public abstract int c(T t);

    public abstract long c();

    public abstract long d(T t);

    private void b(T t, long j) {
        if (t == null || d(t) < 0) {
            return;
        }
        String strB = b(t);
        C0252a c0252a = this.d.get(strB);
        if (c0252a == null) {
            a(t, j);
            this.d.put(strB, new C0252a(c(t), d(t), j));
            this.g = true;
            return;
        }
        c0252a.c = j;
        if (c0252a.f26180a == c(t)) {
            a(t, c0252a.b);
            return;
        }
        a(t, j);
        c0252a.f26180a = c(t);
        c0252a.b = d(t);
        this.g = true;
    }

    private void d() {
        try {
            Iterator<String> it = com.autonavi.aps.amapapi.utils.i.a(this.b).iterator();
            while (it.hasNext()) {
                try {
                    String[] strArrSplit = new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(it.next()), this.f), "UTF-8").split(",");
                    this.d.put(strArrSplit[0], new C0252a(Integer.parseInt(strArrSplit[1]), Long.parseLong(strArrSplit[2]), strArrSplit.length >= 4 ? Long.parseLong(strArrSplit[3]) : com.autonavi.aps.amapapi.utils.i.b()));
                } catch (Throwable th) {
                    if (this.b.exists()) {
                        this.b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.d.size();
            if (b() > 0) {
                long jB = com.autonavi.aps.amapapi.utils.i.b();
                Iterator<Map.Entry<String, C0252a>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (jB - this.d.get(it.next().getKey()).c > b()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.d.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(String str, String str2) {
                        return a.a(((C0252a) a.this.d.get(str2)).c, ((C0252a) a.this.d.get(str)).c);
                    }
                });
                for (int iC = (int) c(); iC < arrayList.size(); iC++) {
                    this.d.remove(arrayList.get(iC));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C0252a> entry : this.d.entrySet()) {
            try {
                sb.append(m4b.f(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue().f26180a + "," + entry.getValue().b + "," + entry.getValue().c).getBytes("UTF-8"), this.f)) + "\n");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.i.a(this.b, string);
    }

    public final void a() {
        Handler handler;
        if (!this.c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, 60000L);
        }
        this.c = true;
    }

    public final void a(boolean z) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.c = false;
    }

    public final void a(T t) {
        b(t, com.autonavi.aps.amapapi.utils.i.b());
    }

    public final void a(List<T> list) {
        long jB = com.autonavi.aps.amapapi.utils.i.b();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), jB);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || c() <= 0) {
            this.d.clear();
            for (T t : list) {
                this.d.put(b(t), new C0252a(c(t), d(t), jB));
            }
        }
    }

    public final long e(T t) {
        return (com.autonavi.aps.amapapi.utils.i.b() - d(t)) / 1000;
    }
}
