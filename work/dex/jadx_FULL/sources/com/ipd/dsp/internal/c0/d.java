package com.ipd.dsp.internal.c0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements f {

    @NonNull
    public final String c;
    public final long d;
    public final int e;

    public d(@Nullable String str, long j, int i) {
        this.c = str == null ? "" : str;
        this.d = j;
        this.e = i;
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.d).putInt(this.e).array());
        messageDigest.update(this.c.getBytes(f.b));
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.d == dVar.d && this.e == dVar.e && this.c.equals(dVar.c);
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        int iHashCode = this.c.hashCode() * 31;
        long j = this.d;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.e;
    }
}
