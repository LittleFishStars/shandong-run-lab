package cj.mobile.wm;

import android.content.Context;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h5 implements v4 {
    public final String dexa;

    public static class dexa implements w4<byte[], InputStream> {
        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<byte[], InputStream> dexa(Context context, m4 m4Var) {
            return new h5();
        }
    }

    public h5() {
        this("");
    }

    @Deprecated
    public h5(String str) {
        this.dexa = str;
    }

    @Override // cj.mobile.wm.v4
    public y2<InputStream> dexa(byte[] bArr, int i, int i2) {
        return new x2(bArr, this.dexa);
    }
}
