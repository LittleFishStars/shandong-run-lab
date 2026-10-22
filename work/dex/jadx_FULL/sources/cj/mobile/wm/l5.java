package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l5 extends a5<InputStream> implements v4 {

    public static class dexa implements w4<Uri, InputStream> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<Uri, InputStream> dexa(Context context, m4 m4Var) {
            return new l5(context, m4Var.dexa(n4.class, InputStream.class));
        }
    }

    public l5(Context context, v4<n4, InputStream> v4Var) {
        super(context, v4Var);
    }

    @Override // cj.mobile.wm.a5
    public y2<InputStream> dexa(Context context, Uri uri) {
        return new e3(context, uri);
    }

    @Override // cj.mobile.wm.a5
    public y2<InputStream> dexa(Context context, String str) {
        return new d3(de.dexb(context), str);
    }
}
