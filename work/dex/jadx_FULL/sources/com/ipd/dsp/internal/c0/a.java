package com.ipd.dsp.internal.c0;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements f {
    public final int c;
    public final f d;

    public a(int i, f fVar) {
        this.c = i;
        this.d = fVar;
    }

    @NonNull
    public static f a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.b(context));
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.c == aVar.c && this.d.equals(aVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return o.a(this.d, this.c);
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.d.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
    }
}
