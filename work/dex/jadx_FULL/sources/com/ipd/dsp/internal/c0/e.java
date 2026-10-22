package com.ipd.dsp.internal.c0;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.f.f;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e implements f {
    public final Object c;

    public e(@NonNull Object obj) {
        this.c = m.a(obj);
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.c.toString().getBytes(f.b));
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.c.equals(((e) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.c + '}';
    }
}
