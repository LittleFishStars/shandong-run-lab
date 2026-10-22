package cj.mobile.wm;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class c3<T> implements y2<T> {
    public final Uri dexa;
    public final Context dexb;
    public T dexc;

    public c3(Context context, Uri uri) {
        this.dexb = context.getApplicationContext();
        this.dexa = uri;
    }

    @Override // cj.mobile.wm.y2
    public void a() {
        T t = this.dexc;
        if (t != null) {
            try {
                dexa(t);
            } catch (IOException e) {
                if (Log.isLoggable(com.ipd.dsp.internal.g.i.i, 2)) {
                    Log.v(com.ipd.dsp.internal.g.i.i, "failed to close data", e);
                }
            }
        }
    }

    @Override // cj.mobile.wm.y2
    public void b() {
    }

    public abstract T dexa(Uri uri, ContentResolver contentResolver);

    @Override // cj.mobile.wm.y2
    public final T dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) {
        T tDexa = dexa(this.dexa, this.dexb.getContentResolver());
        this.dexc = tDexa;
        return tDexa;
    }

    public abstract void dexa(T t);

    @Override // cj.mobile.wm.y2
    public String getId() {
        return this.dexa.toString();
    }
}
