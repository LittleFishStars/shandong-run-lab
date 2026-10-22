package com.ipd.dsp.internal.z;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.ipd.dsp.internal.f.m;
import com.ipd.dsp.internal.q.q;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i extends a<i> {

    @Nullable
    public static i a0;

    @Nullable
    public static i b0;

    @Nullable
    public static i c0;

    @Nullable
    public static i d0;

    @Nullable
    public static i e0;

    @Nullable
    public static i f0;

    @Nullable
    public static i g0;

    @Nullable
    public static i h0;

    @NonNull
    @CheckResult
    public static i T() {
        if (e0 == null) {
            e0 = new i().b().a();
        }
        return e0;
    }

    @NonNull
    @CheckResult
    public static i U() {
        if (d0 == null) {
            d0 = new i().c().a();
        }
        return d0;
    }

    @NonNull
    @CheckResult
    public static i V() {
        if (f0 == null) {
            f0 = new i().d().a();
        }
        return f0;
    }

    @NonNull
    @CheckResult
    public static i W() {
        if (c0 == null) {
            c0 = new i().h().a();
        }
        return c0;
    }

    @NonNull
    @CheckResult
    public static i X() {
        if (h0 == null) {
            h0 = new i().f().a();
        }
        return h0;
    }

    @NonNull
    @CheckResult
    public static i Y() {
        if (g0 == null) {
            g0 = new i().g().a();
        }
        return g0;
    }

    @NonNull
    @CheckResult
    public static i b(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return new i().a(f);
    }

    @NonNull
    @CheckResult
    public static i c(int i, int i2) {
        return new i().b(i, i2);
    }

    @NonNull
    @CheckResult
    public static i e(@Nullable Drawable drawable) {
        return new i().b(drawable);
    }

    @NonNull
    @CheckResult
    public static i f(@Nullable Drawable drawable) {
        return new i().d(drawable);
    }

    @NonNull
    @CheckResult
    public static i h(@IntRange(from = 0, to = 100) int i) {
        return new i().a(i);
    }

    @NonNull
    @CheckResult
    public static i i(@DrawableRes int i) {
        return new i().b(i);
    }

    @NonNull
    @CheckResult
    public static i j(int i) {
        return c(i, i);
    }

    @NonNull
    @CheckResult
    public static i k(@DrawableRes int i) {
        return new i().f(i);
    }

    @NonNull
    @CheckResult
    public static i l(@IntRange(from = 0) int i) {
        return new i().g(i);
    }

    @Override // com.ipd.dsp.internal.z.a
    public boolean equals(Object obj) {
        return (obj instanceof i) && super.equals(obj);
    }

    @Override // com.ipd.dsp.internal.z.a
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull com.ipd.dsp.internal.i.j jVar) {
        return new i().a(jVar);
    }

    @NonNull
    @CheckResult
    public static i c(@NonNull m<Bitmap> mVar) {
        return new i().b(mVar);
    }

    @NonNull
    @CheckResult
    public static i e(boolean z) {
        if (z) {
            if (a0 == null) {
                a0 = new i().b(true).a();
            }
            return a0;
        }
        if (b0 == null) {
            b0 = new i().b(false).a();
        }
        return b0;
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull com.ipd.dsp.internal.b.e eVar) {
        return new i().a(eVar);
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull com.ipd.dsp.internal.f.f fVar) {
        return new i().a(fVar);
    }

    @NonNull
    @CheckResult
    public static <T> i b(@NonNull com.ipd.dsp.internal.f.h<T> hVar, @NonNull T t) {
        return new i().a(hVar, t);
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull Class<?> cls) {
        return new i().a(cls);
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull com.ipd.dsp.internal.f.b bVar) {
        return new i().a(bVar);
    }

    @NonNull
    @CheckResult
    public static i b(@IntRange(from = 0) long j) {
        return new i().a(j);
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull q qVar) {
        return new i().a(qVar);
    }

    @NonNull
    @CheckResult
    public static i b(@NonNull Bitmap.CompressFormat compressFormat) {
        return new i().a(compressFormat);
    }
}
