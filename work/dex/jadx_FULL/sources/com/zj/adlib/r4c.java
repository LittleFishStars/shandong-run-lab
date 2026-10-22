package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r4c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44371a;
    public final ArrayMap b = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z09 f19233a = new z09();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19234a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayMap f19232a = new ArrayMap();

    public r4c(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f19232a.put(((HasApiKey) it.next()).d(), null);
        }
        this.f44371a = this.f19232a.keySet().size();
    }

    public final Task a() {
        return this.f19233a.a();
    }

    public final Set b() {
        return this.f19232a.keySet();
    }

    public final void c(c90 c90Var, ConnectionResult connectionResult, @Nullable String str) {
        this.f19232a.put(c90Var, connectionResult);
        this.b.put(c90Var, str);
        this.f44371a--;
        if (!connectionResult.isSuccess()) {
            this.f19234a = true;
        }
        if (this.f44371a == 0) {
            if (!this.f19234a) {
                this.f19233a.setResult(this.b);
            } else {
                this.f19233a.b(new AvailabilityException(this.f19232a));
            }
        }
    }
}
