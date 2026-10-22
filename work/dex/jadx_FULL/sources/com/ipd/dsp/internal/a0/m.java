package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class m<Z> extends e<Z> {
    public static final int j = 1;
    public static final Handler k = new Handler(Looper.getMainLooper(), new a());
    public final com.ipd.dsp.internal.b.h i;

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((m) message.obj).a();
            return true;
        }
    }

    public m(com.ipd.dsp.internal.b.h hVar, int i, int i2) {
        super(i, i2);
        this.i = hVar;
    }

    public static <Z> m<Z> a(com.ipd.dsp.internal.b.h hVar, int i, int i2) {
        return new m<>(hVar, i, i2);
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onResourceReady(@NonNull Z z, @Nullable com.ipd.dsp.internal.b0.f<? super Z> fVar) {
        com.ipd.dsp.internal.z.e request = getRequest();
        if (request == null || !request.e()) {
            return;
        }
        k.obtainMessage(1, this).sendToTarget();
    }

    public void a() {
        this.i.a((p<?>) this);
    }
}
