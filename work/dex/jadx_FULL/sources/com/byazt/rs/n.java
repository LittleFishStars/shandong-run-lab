package com.byazt.rs;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.nr.zb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 46})
public class n {
    public Context c;

    public n(Context context) {
        this.c = context.getApplicationContext();
    }

    public void c(final uj ujVar, final sp spVar) {
        if (ujVar != null && !TextUtils.isEmpty(ujVar.c())) {
            if (this.c == null) {
                c(spVar, ujVar, 1002, "Context is null");
                return;
            }
            String strC = ujVar.c();
            final String strVe = x.c().ve(strC);
            if (TextUtils.isEmpty(strVe)) {
                c(spVar, ujVar, 1003, "Invalid cache path");
                return;
            }
            if (!c(this.c)) {
                c(spVar, ujVar, 1004, "Insufficient disk space");
                return;
            }
            try {
                File file = new File(com.byazt.nys.tt.tt(this.c), "tt_lottie_temp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                final String strTt = com.byazt.nr.a.tt(strC);
                final File file2 = new File(file, strTt);
                com.byazt.kk.tt.c(strC, file, strTt, new com.byazt.kk.tt.c() { // from class: com.byazt.rs.n.1
                    @Override // com.byazt.kk.tt.c
                    public void c(com.byazt.va.uj ujVar2, com.byazt.hm.tt ttVar) {
                        n.this.c(ujVar, file2, strVe, strTt, spVar);
                    }

                    @Override // com.byazt.kk.tt.c
                    public void c(com.byazt.va.uj ujVar2, IOException iOException) {
                        n.this.c(spVar, ujVar, 1005, iOException != null ? iOException.getMessage() : "Unknown error");
                        n.this.c(file2);
                    }
                });
                return;
            } catch (Exception e) {
                com.byazt.kk.a.c("Download zip failed: " + e.getMessage(), e);
                c(spVar, ujVar, 1005, e.getMessage());
                return;
            }
        }
        c(spVar, ujVar, 1001, "Invalid zip config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(uj ujVar, File file, String str, String str2, sp spVar) {
        try {
            if (!file.exists()) {
                c(spVar, ujVar, 1006, "Downloaded file not found");
                return;
            }
            if (!TextUtils.isEmpty(ujVar.tt()) && !TextUtils.equals(com.byazt.nr.a.c(file), ujVar.tt())) {
                c(file);
                c(spVar, ujVar, 1007, "MD5 verification failed");
                return;
            }
            File file2 = new File(str);
            if (file2.exists()) {
                com.byazt.nr.x.ve(file2);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            zb.c(file.getAbsolutePath(), file2.getAbsolutePath());
            x.c().c(ujVar.c());
            c(file);
            c(spVar, ujVar);
        } catch (Exception e) {
            com.byazt.kk.a.c("Handle download success failed: " + e.getMessage(), e);
            c(file);
            c(spVar, ujVar, 1008, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private boolean c(Context context) {
        try {
            File fileTt = com.byazt.nys.tt.tt(context);
            if (fileTt == null) {
                return false;
            }
            StatFs statFs = new StatFs(fileTt.getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() >= 10485760;
        } catch (Exception e) {
            m.c(e);
            return true;
        }
    }

    private void c(sp spVar, uj ujVar) {
        if (spVar != null) {
            spVar.c(ujVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sp spVar, uj ujVar, int i, String str) {
        if (spVar != null) {
            spVar.c(ujVar, i, str);
        }
    }
}
