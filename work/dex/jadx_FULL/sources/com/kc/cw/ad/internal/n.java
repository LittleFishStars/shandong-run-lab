package com.kc.cw.ad.internal;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39046a;
    private String b;
    private String c;
    private long d;
    private String e;
    private y f;
    private Context h;
    private ArrayList<String> j;
    private com.kc.cw.ad.internal.c.d.a k;
    private boolean g = false;
    private a i = new a();

    @Keep
    public class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f39048a;
        final n b;

        private a(n nVar) {
            this.b = nVar;
            this.f39048a = 0L;
        }

        @Override // com.kc.cw.ad.internal.y.a
        public void a(boolean z) {
            this.f39048a = z ? this.f39048a + 250 : 0L;
            if (this.f39048a >= 500) {
                this.b.a();
            }
        }
    }

    private n(String str, String str2, String str3, long j, String str4, y yVar, Context context, ArrayList<String> arrayList) {
        this.f39046a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = str4;
        this.f = yVar;
        this.h = context;
        this.j = arrayList;
    }

    public static n a(String str, String str2, String str3, long j, String str4, y yVar, Context context, ArrayList<String> arrayList) {
        if (yVar == null) {
            return null;
        }
        n nVar = new n(str, str2, str3, j, str4, yVar, context, arrayList);
        yVar.a(nVar.i);
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Context context;
        synchronized (this) {
            if (!this.g && (context = this.h) != null) {
                com.kc.cw.ad.internal.b.g gVarA = com.kc.cw.ad.internal.b.g.a(context.getApplicationContext());
                if (gVarA.b(this.h)) {
                    b();
                    this.f.b(this.i);
                    this.i = null;
                } else {
                    gVarA.a(this.e, this.h);
                }
                this.g = true;
                this.j.remove(this.e);
            }
        }
    }

    private void b() {
        u uVar = new u(this.f39046a, this.b, this.c, this.d, this.e, true);
        uVar.a(new com.kc.cw.ad.internal.c.d.a(this) { // from class: com.kc.cw.ad.internal.n.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final n f39047a;

            {
                this.f39047a = this;
            }

            @Override // com.kc.cw.ad.internal.c.d.a
            public void a(int i, boolean z, String str) {
                if (this.f39047a.k != null) {
                    this.f39047a.k.a(i, z, str);
                }
            }
        });
        uVar.a();
    }

    public void a(com.kc.cw.ad.internal.c.d.a aVar) {
        this.k = aVar;
    }
}
