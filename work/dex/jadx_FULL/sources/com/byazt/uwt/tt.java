package com.byazt.uwt;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.byazt.bog.a;
import com.byazt.uq.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 13})
public class tt implements Runnable {
    public File c;
    public final String tt;

    public tt(String str, File file) {
        this.c = file;
        this.tt = str;
    }

    private File c(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private void tt() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.c.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                sp.tt(this.c.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.c;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File fileC = c(file2);
                if (fileC != null && fileC.exists() && fileC.isFile()) {
                    this.c = fileC;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                a.c(e);
            }
        }
    }

    private com.byazt.gy.n ve() {
        com.byazt.cda.c cVarC;
        if (this.c == null) {
            return null;
        }
        try {
            File file = new File(this.c.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                sp.c(file);
                file.mkdirs();
            }
            sp.tt(this.c.getAbsolutePath(), file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            sp.c(this.c);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.c);
            this.c = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (cVarC = com.byazt.cda.tt.c(file2, linkedList)) != null) {
                return new com.byazt.gy.n(cVarC);
            }
        } catch (Exception e) {
            a.c(e);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        c();
    }

    private static void c(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.blh.ve.c(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.blh.ve.c(str2));
            jSONObject.putOpt("version_code", com.byazt.blh.ve.c(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.byazt.blh.ve.tt(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.blh.ve.c(str3));
        } catch (JSONException e) {
            a.c(e);
        }
        com.byazt.gvs.tt.c().c(str, jSONObject, jSONObject3, jSONObject2);
    }

    public boolean c() {
        com.byazt.gy.n nVarC;
        File file = this.c;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            nVarC = ve();
            if (nVarC != null) {
                c(com.byazt.gvs.tt.sp, com.byazt.gvs.tt.c.my, this.tt, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (sp.tt(this.c)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                tt();
                c(com.byazt.gvs.tt.sp, com.byazt.gvs.tt.c.or, this.tt, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            nVarC = com.byazt.gy.uj.c(this.c);
        }
        if (nVarC == null) {
            ZeusPluginStateListener.postStateChange(this.tt, 7, " read local file package info failed !!! pluginPkg = " + this.tt + " mApkFile.exists = " + this.c.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.tt);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(nVarC.c);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.tt, 7, " plugin == null !!! pluginPkg = " + this.tt);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + nVarC.c);
            return false;
        }
        boolean zInstall = plugin.install(this.c, nVarC);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(nVarC.c, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(nVarC.c, 7, "Internal error.");
        }
        return zInstall;
    }
}
