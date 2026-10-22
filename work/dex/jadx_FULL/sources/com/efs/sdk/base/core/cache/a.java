package com.efs.sdk.base.core.cache;

import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Byte, d> f29580a = new ConcurrentHashMap<>();

    @Nullable
    public final d a(byte b) {
        if (!this.f29580a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                this.f29580a.putIfAbsent(Byte.valueOf(b), new e());
            } else if (b != 2) {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            } else {
                this.f29580a.putIfAbsent(Byte.valueOf(b), new c());
            }
        }
        return this.f29580a.get(Byte.valueOf(b));
    }
}
