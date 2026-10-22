package cj.mobile.wm;

import android.content.Context;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class m5 extends b5<InputStream> {

    public static class dexa implements w4<URL, InputStream> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<URL, InputStream> dexa(Context context, m4 m4Var) {
            return new m5(m4Var.dexa(n4.class, InputStream.class));
        }
    }

    public m5(v4<n4, InputStream> v4Var) {
        super(v4Var);
    }
}
