package com.byazt.xky;

import android.widget.ImageView;
import com.byazt.aas.qp;
import com.byazt.ete.zb;
import com.byazt.ut.uj;
import com.byazt.yj.qy;
import com.byazt.yj.yp;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 169, 13})
public class tt {
    public static com.byazt.dyf.c c() {
        return new com.byazt.dyf.c() { // from class: com.byazt.xky.tt.1
            @Override // com.byazt.dyf.c
            public void c(ImageView imageView, String str) {
                tt.c(com.byazt.fh.ve.c(str)).to(imageView);
            }
        };
    }

    public static qy tt() {
        return (qy) uj.getService("img_service");
    }

    public static yp c(String str) {
        return c(tt().from(str));
    }

    public static yp c(zb zbVar) {
        return c(tt().from(zbVar.c()).width(zbVar.tt()).height(zbVar.ve()).key(zbVar.sp()));
    }

    public static InputStream c(String str, String str2) {
        return tt().getCacheStream(str, str2);
    }

    private static yp c(yp ypVar) {
        return qp.c() ? ypVar.track(new ve()) : ypVar;
    }
}
