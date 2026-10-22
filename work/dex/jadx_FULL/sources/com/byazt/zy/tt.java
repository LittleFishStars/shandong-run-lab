package com.byazt.zy;

import android.graphics.Path;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 13})
public class tt {
    public final List<rl> c = new ArrayList();

    public void c(rl rlVar) {
        this.c.add(rlVar);
    }

    public void c(Path path) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            com.byazt.kk.da.c(path, this.c.get(size));
        }
    }
}
