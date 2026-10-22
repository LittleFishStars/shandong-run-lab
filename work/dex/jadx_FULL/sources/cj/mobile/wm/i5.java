package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i5 extends l4<InputStream> implements v4 {

    public static class dexa implements w4<File, InputStream> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<File, InputStream> dexa(Context context, m4 m4Var) {
            return new i5(m4Var.dexa(Uri.class, InputStream.class));
        }
    }

    public i5(v4<Uri, InputStream> v4Var) {
        super(v4Var);
    }
}
