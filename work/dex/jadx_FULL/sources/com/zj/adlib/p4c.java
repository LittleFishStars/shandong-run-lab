package com.zj.adlib;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p4c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseIntArray f43904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qv3 f18772a;

    public p4c() {
        this(pv3.x());
    }

    public final int a(Context context, int i) {
        return this.f43904a.get(i, -1);
    }

    public final int b(@NonNull Context context, @NonNull Api.Client client) {
        yw6.l(context);
        yw6.l(client);
        int i = 0;
        if (!client.b()) {
            return 0;
        }
        int iL = client.l();
        int iA = a(context, iL);
        if (iA == -1) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f43904a.size()) {
                    i = -1;
                    break;
                }
                int iKeyAt = this.f43904a.keyAt(i2);
                if (iKeyAt > iL && this.f43904a.get(iKeyAt) == 0) {
                    break;
                }
                i2++;
            }
            iA = i == -1 ? this.f18772a.k(context, iL) : i;
            this.f43904a.put(iL, iA);
        }
        return iA;
    }

    public final void c() {
        this.f43904a.clear();
    }

    public p4c(@NonNull qv3 qv3Var) {
        this.f43904a = new SparseIntArray();
        yw6.l(qv3Var);
        this.f18772a = qv3Var;
    }
}
