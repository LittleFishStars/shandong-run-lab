package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j5 extends x4<InputStream> implements v4 {

    public static class dexa implements w4<Integer, InputStream> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<Integer, InputStream> dexa(Context context, m4 m4Var) {
            return new j5(context, m4Var.dexa(Uri.class, InputStream.class));
        }
    }

    public j5(Context context, v4<Uri, InputStream> v4Var) {
        super(context, v4Var);
    }
}
