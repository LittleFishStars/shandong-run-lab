package com.ipd.dsp.internal.k;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f38378a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.f38378a = context;
            this.b = str;
        }

        @Override // com.ipd.dsp.internal.k.d.c
        public File a() {
            File cacheDir = this.f38378a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, "ipd_image_manager_disk_cache", 262144000L);
    }

    public h(Context context, long j) {
        this(context, "ipd_image_manager_disk_cache", j);
    }

    public h(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
