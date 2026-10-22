package com.ipd.dsp.internal.k;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public final class f extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f38376a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f38376a = context;
            this.b = str;
        }

        @Override // com.ipd.dsp.internal.k.d.c
        public File a() {
            File externalCacheDir = this.f38376a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, "ipd_image_manager_disk_cache", 262144000);
    }

    public f(Context context, int i) {
        this(context, "ipd_image_manager_disk_cache", i);
    }

    public f(Context context, String str, int i) {
        super(new a(context, str), i);
    }
}
