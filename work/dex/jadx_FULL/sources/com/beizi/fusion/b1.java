package com.beizi.fusion;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b1 implements sa {
    @Override // com.beizi.fusion.sa
    public final void a(int i, InputStream inputStream) {
        String strA;
        if (inputStream != null) {
            try {
                strA = zd.a(inputStream, "UTF-8");
            } catch (IOException e) {
                om.a(e);
                strA = "";
            }
        } else {
            strA = "";
        }
        a(new l9(i, strA));
    }

    public abstract void a(ra raVar);
}
