package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class bb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f27102a;
    protected final Context b;

    public class a extends b1 {
        public a() {
        }

        @Override // com.beizi.fusion.sa
        public void a(nc ncVar) {
        }

        @Override // com.beizi.fusion.b1
        public void a(ra raVar) {
            if (raVar == null || TextUtils.isEmpty(raVar.b())) {
                return;
            }
            bb.this.a(raVar.b());
        }
    }

    public bb(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f27102a = str;
    }

    public abstract void a(String str);

    @Override // java.lang.Runnable
    public void run() {
        v vVarA = ((g) h.a().b(this.b)).a();
        if (vVarA != null) {
            ((u9) o0.a().b(this.b)).a(this.f27102a + "?id=" + f3.b(vVarA.e()), new a());
        }
    }
}
