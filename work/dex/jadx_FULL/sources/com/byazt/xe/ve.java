package com.byazt.xe;

import androidx.annotation.NonNull;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 54})
public class ve implements n.c {
    private static boolean tt(@NonNull String str, @NonNull String str2) {
        try {
            return c.c(tt.c(str, str2, tt.tt));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.byazt.xe.n.c
    public boolean c(String str, int i) {
        String strTt = com.byazt.th.ve.tt(str, i);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(strTt)));
        String strVe = com.byazt.th.ve.ve(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append(strVe);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(tt.tt(strTt));
        String string = sb.toString();
        String str3 = strVe + str2 + tt.c(strTt);
        if (!tt(strTt, string)) {
            return false;
        }
        c(string, str3);
        boolean zC = tt.c(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(zC)));
        return zC;
    }

    private void c(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
        }
        File file2 = new File(str.replace(".odex", ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str2.replace(".odex", ".vdex")));
        }
    }
}
