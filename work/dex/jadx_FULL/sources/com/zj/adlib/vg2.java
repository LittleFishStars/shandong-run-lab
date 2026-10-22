package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.network.LottieFetchResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class vg2 implements LottieFetchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final HttpURLConnection f45344a;

    public vg2(@NonNull HttpURLConnection httpURLConnection) {
        this.f45344a = httpURLConnection;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @NonNull
    public InputStream K0() throws IOException {
        return this.f45344a.getInputStream();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @Nullable
    public String X() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f45344a.getURL() + ". Failed with " + this.f45344a.getResponseCode() + "\n" + a(this.f45344a);
        } catch (IOException e) {
            g25.f("get error failed ", e);
            return e.getMessage();
        }
    }

    public final String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f45344a.disconnect();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        try {
            return this.f45344a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @Nullable
    public String x0() {
        return this.f45344a.getContentType();
    }
}
