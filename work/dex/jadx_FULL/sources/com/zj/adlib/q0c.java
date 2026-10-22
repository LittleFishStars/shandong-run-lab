package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q0c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f44098a = Collections.synchronizedMap(new WeakHashMap());
    public final Map b = Collections.synchronizedMap(new WeakHashMap());

    public final void c(BasePendingResult basePendingResult, boolean z) {
        this.f44098a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.b(new m0c(this, basePendingResult));
    }

    public final void d(z09 z09Var, boolean z) {
        this.b.put(z09Var, Boolean.valueOf(z));
        z09Var.a().e(new o0c(this, z09Var));
    }

    public final void e(int i, @Nullable String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, a.f31233a);
    }

    public final boolean g() {
        return (this.f44098a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void h(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f44098a) {
            map = new HashMap(this.f44098a);
        }
        synchronized (this.b) {
            map2 = new HashMap(this.b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).j(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((z09) entry2.getKey()).c(new ApiException(status));
            }
        }
    }
}
