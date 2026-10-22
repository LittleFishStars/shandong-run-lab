package com.igexin.push.f;

import android.content.ContentValues;
import android.text.TextUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.e.f.AnonymousClass25;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g implements com.igexin.push.f.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f38131a = null;
    private static String b = "Type10Task";
    private SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    public static g a() {
        if (f38131a == null) {
            synchronized (g.class) {
                if (f38131a == null) {
                    f38131a = new g();
                }
            }
        }
        return f38131a;
    }

    public static /* synthetic */ String a(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.f38001a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + ServiceManager.getInstance().initType.first;
    }

    private static String b(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.f38001a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + ServiceManager.getInstance().initType.first;
    }

    private void f() {
        if (com.igexin.push.core.e.ax == 0) {
            return;
        }
        try {
            String str = this.c.format(new Date(com.igexin.push.core.e.ax));
            String str2 = this.c.format(new Date());
            Date date = this.c.parse(str);
            Date date2 = this.c.parse(str2);
            com.igexin.c.a.c.a.b(b, " lastDateString = " + str + " ; nowDateString = " + str2);
            if (date2.after(date)) {
                d();
            }
        } catch (ParseException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.f.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.f.b.c
    public final void b() {
        if (com.igexin.push.core.e.ax != 0) {
            try {
                String str = this.c.format(new Date(com.igexin.push.core.e.ax));
                String str2 = this.c.format(new Date());
                Date date = this.c.parse(str);
                Date date2 = this.c.parse(str2);
                com.igexin.c.a.c.a.b(b, " lastDateString = " + str + " ; nowDateString = " + str2);
                if (date2.after(date)) {
                    d();
                }
            } catch (ParseException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.push.f.b.c
    public final boolean c() {
        return com.igexin.push.config.d.q;
    }

    public final void d() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(jCurrentTimeMillis));
        if (!com.igexin.push.config.d.q) {
            com.igexin.c.a.c.a.b(b, "upload type10 enable false");
            return;
        }
        int i = TextUtils.isEmpty(com.igexin.push.core.e.A) ? com.igexin.push.config.d.ag * 1000 : 0;
        com.igexin.c.a.c.a.b(b, "upload type10 delay time = ".concat(String.valueOf(i)));
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.f37984a;
        com.igexin.push.core.d.a(new com.igexin.push.f.b.f(i) { // from class: com.igexin.push.f.g.1
            @Override // com.igexin.c.a.d.a.e
            public final int c() {
                return 0;
            }

            @Override // com.igexin.push.f.b.f
            public final void h() {
                try {
                    synchronized (g.class) {
                        if (jCurrentTimeMillis - com.igexin.push.core.e.ax <= 60000) {
                            com.igexin.c.a.c.a.b(g.b, "upload type10 in 1m");
                            return;
                        }
                        com.igexin.push.core.e.ax = jCurrentTimeMillis;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass25(), false, true);
                        com.igexin.push.core.c.a.a();
                        String strA = g.a(str);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("type", (Integer) 10);
                        contentValues.put("data", strA);
                        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                        com.igexin.push.core.d.a.f37984a.i.a(com.igexin.push.core.b.af, contentValues);
                        StringBuilder sb = new StringBuilder();
                        com.igexin.push.core.c.a.a();
                        List<com.igexin.push.core.b.c> listC = com.igexin.push.core.c.a.c();
                        final ArrayList arrayList = new ArrayList();
                        for (com.igexin.push.core.b.c cVar : listC) {
                            arrayList.add(String.valueOf(cVar.f37953a));
                            sb.append(cVar.b);
                            sb.append("\n");
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        com.igexin.c.a.c.a.b(g.b, "upload type10 data = ".concat(String.valueOf(sb)));
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes()) { // from class: com.igexin.push.f.g.1.1
                            @Override // com.igexin.push.core.h.e, com.igexin.push.f.a.d
                            public final void a(byte[] bArr) throws Exception {
                                super.a(bArr);
                                com.igexin.push.core.c.a.a();
                                ArrayList arrayList2 = arrayList;
                                com.igexin.push.core.d.a.f37984a.i.a(com.igexin.push.core.b.af, new String[]{"id"}, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                            }
                        }), false, true);
                    }
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }
        });
    }
}
