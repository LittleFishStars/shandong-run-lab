package com.byazt.et;

import android.util.Base64;
import com.byazt.iy.ve;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 426, 20})
public class c implements ve {
    @Override // com.byazt.iy.ve
    public String decrypt(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }

    @Override // com.byazt.iy.ve
    public String encrypt(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.byazt.iy.ve
    public int type() {
        return 32;
    }
}
