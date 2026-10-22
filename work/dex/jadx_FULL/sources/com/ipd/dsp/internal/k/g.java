package com.ipd.dsp.internal.k;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f38377a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f38377a = context;
            this.b = str;
        }

        @Override // com.ipd.dsp.internal.k.d.c
        public File a() {
            File externalCacheDir;
            File fileB = b();
            if ((fileB == null || !fileB.exists()) && (externalCacheDir = this.f38377a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
            }
            return fileB;
        }

        @Nullable
        public final File b() {
            File cacheDir = this.f38377a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public g(Context context) {
        this(context, "ipd_image_manager_disk_cache", 262144000L);
    }

    public g(Context context, long j) {
        this(context, "ipd_image_manager_disk_cache", j);
    }

    public g(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
