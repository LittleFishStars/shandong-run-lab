package cj.mobile.wm;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x4<T> implements v4<Integer, T> {
    public final v4<Uri, T> dexa;
    public final Resources dexb;

    public x4(Context context, v4<Uri, T> v4Var) {
        this(context.getResources(), v4Var);
    }

    public x4(Resources resources, v4<Uri, T> v4Var) {
        this.dexb = resources;
        this.dexa = v4Var;
    }

    @Override // cj.mobile.wm.v4
    public y2<T> dexa(Integer num, int i, int i2) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.dexb.getResourcePackageName(num.intValue()) + '/' + this.dexb.getResourceTypeName(num.intValue()) + '/' + this.dexb.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable(com.ipd.dsp.internal.n.t.c, 5)) {
                Log.w(com.ipd.dsp.internal.n.t.c, "Received invalid resource id: " + num, e);
            }
            uri = null;
        }
        if (uri != null) {
            return this.dexa.dexa(uri, i, i2);
        }
        return null;
    }
}
