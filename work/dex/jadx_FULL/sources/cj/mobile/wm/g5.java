package cj.mobile.wm;

import android.content.Context;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g5 implements v4 {
    public final u4<n4, n4> dexa;

    public static class dexa implements w4<n4, InputStream> {
        public final u4<n4, n4> dexa = new u4<>(500);

        @Override // cj.mobile.wm.w4
        public void a() {
        }

        @Override // cj.mobile.wm.w4
        public v4<n4, InputStream> dexa(Context context, m4 m4Var) {
            return new g5(this.dexa);
        }
    }

    public g5(u4<n4, n4> u4Var) {
        this.dexa = u4Var;
    }

    @Override // cj.mobile.wm.v4
    public y2<InputStream> dexa(n4 n4Var, int i, int i2) {
        u4<n4, n4> u4Var = this.dexa;
        if (u4Var != null) {
            n4 n4VarDexa = u4Var.dexa(n4Var, 0, 0);
            if (n4VarDexa == null) {
                this.dexa.dexa(n4Var, 0, 0, n4Var);
            } else {
                n4Var = n4VarDexa;
            }
        }
        return new b3(n4Var);
    }
}
