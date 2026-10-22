package com.byazt.uwt;

import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.m.y.l;
import com.byazt.bog.a;
import com.byazt.uk.sl;
import com.byazt.uq.i;
import com.byazt.uq.sp;
import com.byazt.uq.u;
import com.byazt.uq.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 54})
public class ve {
    public static final sl c = sl.c();

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(File file, String str, int i, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (!com.byazt.fdg.n.c(file.getAbsolutePath(), str, sb)) {
                    throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
                }
                stringBuffer.append("checkSignature cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
                return;
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.rl, str, i, -1L, Log.getStackTraceString(e));
                c.c(1100, -3, str, i, e);
                throw new c(e.getMessage(), e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
        stringBuffer.append("checkSignature cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(l.b);
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean da(File file, String str, int i, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (i.sp()) {
                    String strVe = com.byazt.th.ve.ve(str, i);
                    String strTt = com.byazt.th.ve.tt(str, i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(strVe);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(com.byazt.xe.tt.c(strTt));
                    String string = sb.toString();
                    if (com.byazt.xe.tt.c(strTt, strVe + str2 + com.byazt.xe.tt.c(strTt)) && com.byazt.xe.tt.c(string)) {
                        stringBuffer.append("dexOpt1 cost:");
                        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                        stringBuffer.append(l.b);
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
                return false;
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.yv, str, i, -1L, null);
                throw new c("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(File file, String str, int i, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strTt = com.byazt.th.ve.tt(str, i);
        try {
            try {
                x.c(file.getAbsolutePath(), strTt);
                stringBuffer.append("copyApk cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
                return strTt;
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.gu, str, i, -1L, null);
                c.c(1100, -6, str, i, e);
                throw new c("安装包拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> sp(File file, String str, int i, StringBuffer stringBuffer) throws c {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.uq.n<Boolean, Map<String, List<ZipEntry>>> nVarC = com.byazt.th.tt.c(file);
                boolean zBooleanValue = nVarC.c.booleanValue();
                Map<String, List<ZipEntry>> map = nVarC.tt;
                if (!zBooleanValue) {
                    throw new c(str2);
                }
                stringBuffer.append("checkMatchHostAbi cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
                return map;
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.p, str, i, -1L, null);
                c.c(1100, -5, str, i, e);
                throw new c(str2, e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
        stringBuffer.append("checkMatchHostAbi cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(l.b);
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(File file, String str, int i, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!listAsList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new c("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                    }
                }
                stringBuffer.append("checkPermissions cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.qy, str, i, -1L, null);
                c.c(1100, -4, str, i, e);
                throw new c("安装包权限校验失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME, 24})
    public static class c extends IOException {
        private c(String str) {
            super(str);
        }

        private c(String str, Throwable th) {
            super(str, th);
        }
    }

    private static void tt(String str, int i) {
        int iTt = u.c().tt(str, i, "install");
        int iTt2 = u.c().tt(str, i, TrackLoadSettingsAtom.TYPE);
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iTt > 3 || iTt2 > 3) {
            removeApkEntryFlag = 0;
        }
        u.c().c(str, i, removeApkEntryFlag);
        u.c().ve(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(String str, int i) throws c {
        try {
            if (i.a() || i.x()) {
                u.c().tt(str, i, false);
                com.byazt.xe.tt.c(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                com.byazt.xe.n.c();
            }
        } catch (Exception e) {
            c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.yv, str, i, -1L, null);
            throw new c("dexOpt2失败", e);
        }
    }

    public static boolean c(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            sl slVar = c;
            slVar.c(1000, 0, str, i, null);
            com.byazt.blh.tt ttVarC = com.byazt.blh.tt.c(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            c(com.byazt.gvs.tt.uj, com.byazt.gvs.tt.c.rh, str, i, -1L, null);
            tt(str, i);
            sp.c(com.byazt.th.ve.c(str, i));
            com.byazt.ao.c.c(false, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.ve.1
                @Override // com.byazt.ao.c.InterfaceC0347c
                public void c() throws Throwable {
                    ve.a(file, str, i, stringBuffer);
                }
            }, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.ve.2
                @Override // com.byazt.ao.c.InterfaceC0347c
                public void c() throws Throwable {
                    final Map mapSp = ve.sp(file, str, i, stringBuffer);
                    ve.x(file, str, i, stringBuffer);
                    ve.tt(ve.i(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (i.sp()) {
                        final boolean[] zArr2 = {false};
                        com.byazt.ao.c.c(false, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.ve.2.1
                            @Override // com.byazt.ao.c.InterfaceC0347c
                            public void c() throws Throwable {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                ve.tt(str, i, (Map<String, List<ZipEntry>>) mapSp, stringBuffer);
                            }
                        }, new com.byazt.ao.c.InterfaceC0347c() { // from class: com.byazt.uwt.ve.2.2
                            @Override // com.byazt.ao.c.InterfaceC0347c
                            public void c() throws Throwable {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = ve.da(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = ve.tt(str, i, zArr2[0], stringBuffer);
                    } else {
                        ve.tt(str, i, (Map<String, List<ZipEntry>>) mapSp, stringBuffer);
                        zArr[0] = ve.tt(str, i, false, stringBuffer);
                        ve.ve(str, i);
                    }
                }
            });
            sp.c(file);
            c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.my, str, i, ttVarC.c(), stringBuffer.toString());
            ttVarC.c("success");
            slVar.c(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof c) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.gt, str, i, -1L, stringBuffer.toString());
                c.c(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                u.c().c(str, i, "install");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iX = u.c().x(str, i);
        boolean z2 = (iX & 1) != 0;
        boolean z3 = (iX & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strTt = com.byazt.th.ve.tt(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zC = com.byazt.mx.tt.c(strTt, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(l.b);
        return zC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(String str, String str2, int i, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iC = new com.byazt.vnu.ve().c(new File(str), false, sb);
        stringBuffer.append(iC == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(l.b);
        if (iC == 100 || iC == 200) {
            return;
        }
        String string = sb.toString();
        c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.md, str2, i, -1L, string);
        c.c(1100, -2, str2, i, null);
        throw new c("modifyRes failed. result = " + iC + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws c {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.th.tt.c(new File(com.byazt.th.ve.tt(str, i)), new File(com.byazt.th.ve.uj(str, i)), str, map);
                stringBuffer.append("copySo cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(l.b);
            } catch (Exception e) {
                c(com.byazt.gvs.tt.n, com.byazt.gvs.tt.c.gr, str, i, -1L, com.byazt.blh.ve.c((Object) e));
                c.c(1100, -7, str, i, e);
                throw new c("安装包动态库拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(l.b);
            throw th;
        }
    }

    public static void c(String str, int i, @NonNull String str2, int i2, long j, String str3) {
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
}
