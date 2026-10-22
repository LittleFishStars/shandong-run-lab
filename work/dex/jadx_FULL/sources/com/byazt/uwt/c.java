package com.byazt.uwt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.bog.a;
import com.byazt.uq.sp;
import com.byazt.uq.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.zj.adlib.u15;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 20})
public class c extends Plugin {
    public com.byazt.cda.c c;

    public c(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    private void tt() {
        List<String> listU = u.c().u(this.mPkgName);
        if (listU == null || listU.size() <= 0) {
            return;
        }
        for (String str : listU) {
            if (!TextUtils.isEmpty(str)) {
                int iC = com.byazt.cda.tt.c(str);
                if (iC != -1) {
                    u.c().c(str, iC, false);
                }
                sp.c(com.byazt.th.ve.c(str));
            }
        }
        u.c().yp(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listU)));
    }

    private void ve() {
        String strSl = u.c().sl(this.mPkgName);
        if (TextUtils.isEmpty(strSl)) {
            return;
        }
        String strC = com.byazt.th.ve.c(strSl);
        sp.c(strC);
        u.c().t(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strC)));
    }

    public void c(com.byazt.cda.c cVar) {
        this.c = cVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.byazt.th.uj.tt(Zeus.getAppApplication()) && u.c().i(this.mPkgName)) {
            u.c().x(this.mPkgName);
            String strC = com.byazt.th.ve.c(this.mPkgName);
            sp.c(strC);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strC);
            tt();
            ve();
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.byazt.cda.c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052 A[Catch: Exception -> 0x005a, all -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:20:0x0044, B:22:0x0047, B:23:0x0052), top: B:52:0x0044, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088 A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0019, B:15:0x002c, B:16:0x002e, B:18:0x0035, B:20:0x0044, B:22:0x0047, B:29:0x0070, B:31:0x0073, B:33:0x0079, B:35:0x007d, B:40:0x0088, B:42:0x008d, B:23:0x0052, B:26:0x005b, B:43:0x00cd, B:45:0x00d4, B:46:0x00d6, B:44:0x00d1), top: B:54:0x0008, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x008c  */
    @Override // com.bytedance.pangle.plugin.Plugin
    public void init() {
        boolean z;
        com.byazt.cda.c cVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.byazt.th.uj.tt(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strSl = u.c().sl(this.mPkgName);
                if (TextUtils.isEmpty(strSl)) {
                    strSl = this.mPkgName;
                }
                int iC = com.byazt.cda.tt.c(strSl);
                if (iC != -1) {
                    File[] fileArrDa = com.byazt.th.ve.da(strSl, iC);
                    File file = new File(com.byazt.th.ve.sl(strSl, iC));
                    if (fileArrDa != null) {
                        try {
                            if (fileArrDa.length > 0) {
                                this.c = com.byazt.cda.tt.c(file, (List<File>) Arrays.asList(fileArrDa));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            a.c(e);
                        }
                        if (fileArrDa == null && fileArrDa.length > 0 && file.isFile() && (cVar = this.c) != null && cVar.c()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iC);
                        } else {
                            iC = 0;
                        }
                        c(iC);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        u.c().c(this.mPkgName);
                        u.c().uj(this.mPkgName);
                        u.c().c(this.mPkgName, com.byazt.uq.tt.c(Zeus.getAppApplication()));
                        u.c().c(this.mPkgName, this.mApiVersionCode);
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (fileArrDa == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iC);
                        } else {
                            iC = 0;
                        }
                        c(iC);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        u.c().c(this.mPkgName);
                        u.c().uj(this.mPkgName);
                        u.c().c(this.mPkgName, com.byazt.uq.tt.c(Zeus.getAppApplication()));
                        u.c().c(this.mPkgName, this.mApiVersionCode);
                    }
                }
                c();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.byazt.gy.n nVar) {
        boolean zC = false;
        if (nVar != null) {
            try {
                com.byazt.cda.c cVar = nVar.ve;
                if (cVar != null) {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + cVar);
                    String strTt = cVar.tt();
                    int iVe = cVar.ve();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strTt + " plugin=" + this);
                        boolean zC2 = cVar.c();
                        if (zC2 && (zC = com.byazt.cda.tt.c(cVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strTt + " version=" + iVe);
                        }
                        synchronized (this) {
                            try {
                                if (!zC2) {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strTt + u15.f19942b + iVe);
                                } else if (this.mLifeCycle == 3) {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strTt + u15.f19942b + this.mVersionCode);
                                } else if (zC) {
                                    updateToInstalled(iVe);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strTt + u15.f19942b + iVe);
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strTt + u15.f19942b + iVe);
                                }
                                sp.c(file);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strTt + " version=" + iVe + " apkFile=" + file);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th2);
            }
        }
        return zC;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    private void c(int i) {
        if (com.byazt.th.uj.tt(Zeus.getAppApplication())) {
            tt();
            String strSl = u.c().sl(this.mPkgName);
            if (TextUtils.isEmpty(strSl)) {
                com.byazt.cda.tt.c(this.mPkgName, i);
            } else {
                com.byazt.cda.tt.c(strSl, i);
            }
        }
    }

    public void c() {
        String strC = com.byazt.th.ve.c(this.mPkgName);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        File[] fileArrListFiles = new File(strC).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strC);
            sp.c(strC);
        }
    }
}
