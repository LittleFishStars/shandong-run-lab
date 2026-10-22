package com.byazt.sb;

import com.byazt.yj.rh;
import com.byazt.yj.t;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1065, 13})
public class tt {
    public static rh c() {
        return new rh() { // from class: com.byazt.sb.tt.1
            public WeakHashMap<String, String> c = new WeakHashMap<>();

            @Override // com.byazt.yj.rh
            public String c(t tVar) {
                return c(tVar.getUrl() + "#width=" + tVar.getWidth() + "#height=" + tVar.getHeight() + "#scaletype=" + tVar.getScaleType() + "#bitmapConfig=" + tVar.getBitmapConfig());
            }

            @Override // com.byazt.yj.rh
            public String tt(t tVar) {
                return c(tVar.getUrl());
            }

            private String c(String str) {
                String str2 = this.c.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strC = com.byazt.as.ve.c(str);
                this.c.put(str, strC);
                return strC;
            }
        };
    }
}
