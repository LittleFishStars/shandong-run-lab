package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
@Deprecated
public class cx4 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ConcurrentHashMap f15900a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final su3 f15899a = new su3("LibraryVersion", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static cx4 f41061a = new cx4();

    @VisibleForTesting
    public cx4() {
    }

    @NonNull
    @KeepForSdk
    public static cx4 a() {
        return f41061a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    @NonNull
    @KeepForSdk
    @Deprecated
    public String b(@NonNull String str) throws Throwable {
        ?? r3;
        String property;
        yw6.i(str, "Please provide a valid libraryName");
        if (this.f15900a.containsKey(str)) {
            return (String) this.f15900a.get(str);
        }
        Properties properties = new Properties();
        ?? r4 = 0;
        r4 = 0;
        r4 = 0;
        InputStream inputStream = null;
        try {
            try {
                InputStream resourceAsStream = cx4.class.getResourceAsStream(String.format("/%s.properties", str));
                try {
                    if (resourceAsStream != null) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        f15899a.l("LibraryVersion", str + " version is " + property);
                    } else {
                        f15899a.n("LibraryVersion", "Failed to get app version for libraryName: " + str);
                    }
                    if (resourceAsStream != null) {
                        r4 = property;
                        q44.b(resourceAsStream);
                    }
                } catch (IOException e) {
                    e = e;
                    ?? r7 = r4;
                    inputStream = resourceAsStream;
                    r3 = r7;
                    f15899a.f("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
                    if (inputStream != null) {
                        q44.b(inputStream);
                    }
                    r4 = r3;
                } catch (Throwable th) {
                    th = th;
                    r4 = resourceAsStream;
                    if (r4 != 0) {
                        q44.b(r4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            r3 = 0;
        }
        if (r4 == 0) {
            f15899a.c("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            r4 = "UNKNOWN";
        }
        this.f15900a.put(str, r4);
        return r4;
    }
}
