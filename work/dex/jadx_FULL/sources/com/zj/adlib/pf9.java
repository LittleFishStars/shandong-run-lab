package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class pf9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f43973a;

    @KeepForSdk
    public pf9(@NonNull String str) throws MalformedURLException {
        this.f43973a = new URL(str);
    }

    @NonNull
    @KeepForSdk
    public URLConnection a() throws IOException {
        return this.f43973a.openConnection();
    }
}
