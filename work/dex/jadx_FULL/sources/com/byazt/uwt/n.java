package com.byazt.uwt;

import android.text.TextUtils;
import com.byazt.uq.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 46})
public class n implements Runnable {
    private void c(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.byazt.uwt.n.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (file2.getName().endsWith(".apk") || sp.tt(file2) || file2.getName().endsWith(".7z.zip") || file2.getName().endsWith(".jar") || file2.getName().endsWith(".dex.zip")) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                }
                if ((file2.getAbsolutePath().endsWith(".temp") || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                } else {
                    sp.c(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                }
                return false;
            }
        });
    }

    @Override // java.lang.Runnable
    public void run() {
        c(new File(com.byazt.th.ve.tt()));
        String strUj = com.byazt.th.ve.uj();
        if (TextUtils.isEmpty(strUj)) {
            return;
        }
        c(new File(strUj));
    }
}
