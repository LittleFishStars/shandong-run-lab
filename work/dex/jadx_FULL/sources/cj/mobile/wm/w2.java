package cj.mobile.wm;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class w2<T> implements y2<T> {
    public final String dexa;
    public final AssetManager dexb;
    public T dexc;

    public w2(AssetManager assetManager, String str) {
        this.dexb = assetManager;
        this.dexa = str;
    }

    @Override // cj.mobile.wm.y2
    public void a() {
        T t = this.dexc;
        if (t == null) {
            return;
        }
        try {
            dexa(t);
        } catch (IOException e) {
            if (Log.isLoggable("AssetUriFetcher", 2)) {
                Log.v("AssetUriFetcher", "Failed to close data", e);
            }
        }
    }

    @Override // cj.mobile.wm.y2
    public void b() {
    }

    public abstract T dexa(AssetManager assetManager, String str);

    @Override // cj.mobile.wm.y2
    public T dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) {
        T tDexa = dexa(this.dexb, this.dexa);
        this.dexc = tDexa;
        return tDexa;
    }

    public abstract void dexa(T t);

    @Override // cj.mobile.wm.y2
    public String getId() {
        return this.dexa;
    }
}
