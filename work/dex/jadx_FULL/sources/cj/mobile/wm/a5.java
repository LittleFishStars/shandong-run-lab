package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a5<T> implements v4<Uri, T> {
    public final Context dexa;
    public final v4<n4, T> dexb;

    public a5(Context context, v4<n4, T> v4Var) {
        this.dexa = context;
        this.dexb = v4Var;
    }

    public static boolean dexa(String str) {
        return "file".equals(str) || "content".equals(str) || com.google.android.exoplayer2.upstream.c.h.equals(str);
    }

    public abstract y2<T> dexa(Context context, Uri uri);

    public abstract y2<T> dexa(Context context, String str);

    @Override // cj.mobile.wm.v4
    public final y2<T> dexa(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (dexa(scheme)) {
            if (!k4.dexa(uri)) {
                return dexa(this.dexa, uri);
            }
            return dexa(this.dexa, k4.dexb(uri));
        }
        if (this.dexb == null || !("http".equals(scheme) || "https".equals(scheme))) {
            return null;
        }
        return this.dexb.dexa(new n4(uri.toString()), i, i2);
    }
}
