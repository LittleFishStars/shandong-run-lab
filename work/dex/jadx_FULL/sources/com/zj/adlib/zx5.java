package com.zj.adlib;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieFetchResult;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class zx5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieNetworkFetcher f46362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final yx5 f21123a;

    public zx5(@NonNull yx5 yx5Var, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.f21123a = yx5Var;
        this.f46362a = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    public final k35 a(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> pairB;
        if (str2 == null || (pairB = this.f21123a.b(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairB.first;
        InputStream inputStream = (InputStream) pairB.second;
        f45<k35> f45VarL = fileExtension == FileExtension.ZIP ? x35.L(new ZipInputStream(inputStream), str) : x35.u(inputStream, str);
        if (f45VarL.b() != null) {
            return f45VarL.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    public final f45<k35> b(@NonNull String str, @Nullable String str2) {
        g25.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult lottieFetchResultA = this.f46362a.a(str);
                if (!lottieFetchResultA.isSuccessful()) {
                    f45<k35> f45Var = new f45<>(new IllegalArgumentException(lottieFetchResultA.X()));
                    try {
                        lottieFetchResultA.close();
                    } catch (IOException e) {
                        g25.f("LottieFetchResult close failed ", e);
                    }
                    return f45Var;
                }
                f45<k35> f45VarD = d(str, lottieFetchResultA.K0(), lottieFetchResultA.x0(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(f45VarD.b() != null);
                g25.a(sb.toString());
                try {
                    lottieFetchResultA.close();
                } catch (IOException e2) {
                    g25.f("LottieFetchResult close failed ", e2);
                }
                return f45VarD;
            } catch (Exception e3) {
                f45<k35> f45Var2 = new f45<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        g25.f("LottieFetchResult close failed ", e4);
                    }
                }
                return f45Var2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    g25.f("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    public f45<k35> c(@NonNull String str, @Nullable String str2) {
        k35 k35VarA = a(str, str2);
        if (k35VarA != null) {
            return new f45<>(k35VarA);
        }
        g25.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }

    @NonNull
    public final f45<k35> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        f45<k35> f45VarF;
        if (str2 == null) {
            str2 = ze1.g;
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            g25.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            f45VarF = f(str, inputStream, str3);
        } else {
            g25.a("Received json response.");
            fileExtension = FileExtension.JSON;
            f45VarF = e(str, inputStream, str3);
        }
        if (str3 != null && f45VarF.b() != null) {
            this.f21123a.f(str, fileExtension);
        }
        return f45VarF;
    }

    @NonNull
    public final f45<k35> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? x35.u(inputStream, null) : x35.u(new FileInputStream(this.f21123a.g(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    public final f45<k35> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? x35.L(new ZipInputStream(inputStream), null) : x35.L(new ZipInputStream(new FileInputStream(this.f21123a.g(str, inputStream, FileExtension.ZIP))), str);
    }
}
