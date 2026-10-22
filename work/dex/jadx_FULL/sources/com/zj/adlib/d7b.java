package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.ff;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d7b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f41120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r4b f15935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15937a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15936a = "40C27E38DCAD404B5465362914090908";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g7b f15934a = new g7b("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            r4b r4bVarC = new r4b.a(str, str2, str).b(strArr).a(str3).c();
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f41120a = applicationContext;
                this.f15935a = r4bVarC;
                this.f15937a = z;
                this.f15934a.c(applicationContext, r4bVarC);
            }
        } catch (ff unused) {
        }
    }

    public final void b(String str, String str2) {
        List<r4b> listB = this.f15934a.b(this.f41120a);
        e7b e7bVar = e7b.a.f41366a;
        e7b.b(this.f41120a, str, str2, listB, this.f15937a, this.f15935a);
    }
}
