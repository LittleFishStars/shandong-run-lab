package com.google.android.odml.image;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.zj.adlib.p3d;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MlImage implements Closeable {
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;
    public static final int V = 7;
    public static final int W = 8;
    public static final int X = 9;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int a0 = 3;
    public final int K;
    public final int L;
    public final int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f31541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzg f5919a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageFormat {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StorageType {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MlImage f31542a;

        public /* synthetic */ a(MlImage mlImage, p3d p3dVar) {
            this.f31542a = mlImage;
        }

        public void a() {
            this.f31542a.p();
        }
    }

    public MlImage(zzg zzgVar, int i, Rect rect, long j, int i2, int i3) {
        this.f5919a = zzgVar;
        this.K = i;
        Rect rect2 = new Rect();
        this.f31541a = rect2;
        rect2.set(rect);
        this.L = i2;
        this.M = i3;
        this.N = 1;
    }

    public static void m(int i) {
        if (i == 0 || i == 90 || i == 180 || i == 270) {
            return;
        }
        StringBuilder sb = new StringBuilder(68);
        sb.append("Rotation value ");
        sb.append(i);
        sb.append(" is not valid. Use only 0, 90, 180 or 270.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        int i = this.N - 1;
        this.N = i;
        if (i == 0) {
            this.f5919a.zzc();
        }
    }

    @NonNull
    public List<ImageProperties> g() {
        return Collections.singletonList(this.f5919a.a());
    }

    public int getHeight() {
        return this.M;
    }

    public int getWidth() {
        return this.L;
    }

    @NonNull
    public a h() {
        return new a(this, null);
    }

    public int j() {
        return this.K;
    }

    public final zzg k() {
        return this.f5919a;
    }

    public final synchronized void p() {
        this.N++;
    }
}
