package cj.mobile.wm;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class d4 extends b4 {

    public class dexa implements b4.dexa {
        public final /* synthetic */ Context dexa;
        public final /* synthetic */ String dexb;

        public dexa(Context context, String str) {
            this.dexa = context;
            this.dexb = str;
        }

        @Override // cj.mobile.wm.b4.dexa
        public File a() {
            File cacheDir = this.dexa.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.dexb;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }
    }

    public d4(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000);
    }

    public d4(Context context, String str, int i) {
        super(new dexa(context, str), i);
    }
}
