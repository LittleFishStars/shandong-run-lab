package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.zj.adlib.az4;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface LoadErrorHandlingPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31112a = 1;
    public static final int b = 2;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FallbackType {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31113a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3, int i4) {
            this.f31113a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(int i) {
            if (i == 1) {
                if (this.f31113a - this.b <= 1) {
                    return false;
                }
            } else if (this.c - this.d <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31114a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f5043a;

        public b(int i, long j) {
            sb0.a(j >= 0);
            this.f31114a = i;
            this.f5043a = j;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31115a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final az4 f5044a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final oh5 f5045a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final IOException f5046a;

        public c(az4 az4Var, oh5 oh5Var, IOException iOException, int i) {
            this.f5044a = az4Var;
            this.f5045a = oh5Var;
            this.f5046a = iOException;
            this.f31115a = i;
        }
    }

    @Nullable
    b a(a aVar, c cVar);

    long b(c cVar);

    int getMinimumLoadableRetryCount(int i);

    default void onLoadTaskConcluded(long j) {
    }
}
