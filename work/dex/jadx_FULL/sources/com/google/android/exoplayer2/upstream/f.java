package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f implements LoadErrorHandlingPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31147a = 60000;

    @Deprecated
    public static final long b = 60000;
    public static final long c = 300000;
    public static final int d = 3;
    public static final int e = 6;
    public static final int f = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f5223c;

    public f() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    @Nullable
    public LoadErrorHandlingPolicy.b a(LoadErrorHandlingPolicy.a aVar, LoadErrorHandlingPolicy.c cVar) {
        if (!isEligibleForFallback(cVar.f5046a)) {
            return null;
        }
        if (aVar.a(1)) {
            return new LoadErrorHandlingPolicy.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new LoadErrorHandlingPolicy.b(2, 60000L);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public long b(LoadErrorHandlingPolicy.c cVar) {
        IOException iOException = cVar.f5046a;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.f31115a - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy
    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.f5223c;
        if (i2 == -1) {
            return i == 7 ? 6 : 3;
        }
        return i2;
    }

    public boolean isEligibleForFallback(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        return i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503;
    }

    public f(int i) {
        this.f5223c = i;
    }
}
