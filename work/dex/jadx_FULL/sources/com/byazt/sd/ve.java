package com.byazt.sd;

import com.byazt.c.u;
import com.byazt.gq.t;
import com.byazt.m.BaseException;
import com.byazt.ou.yp;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 54})
public class ve implements u {
    @Override // com.byazt.c.u
    public void c(DownloadInfo downloadInfo) throws BaseException {
        yp ypVarSl = t.sl();
        if (downloadInfo == null || ypVarSl == null) {
            return;
        }
        File fileC = c(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.byazt.dd.tt ttVarC = com.byazt.nn.a.c().c(downloadInfo);
        if (ttVarC != null) {
            com.byazt.hu.u.c(ttVarC.sp());
        }
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(fileC.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.byazt.c.u
    public boolean tt(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.ki.tt.c(com.byazt.k.c.c(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File c(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
