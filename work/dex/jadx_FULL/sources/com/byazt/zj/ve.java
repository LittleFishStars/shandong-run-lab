package com.byazt.zj;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.log.TLogConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.dna.u;
import com.byazt.dna.zm;
import com.byazt.m.BaseException;
import com.byazt.nr.a;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.t.DownloadInfo;
import com.byazt.ukr.yp;
import com.byazt.whk.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 54})
public class ve {
    public static final String c;
    public static long i;
    public static final ve n;
    public static final HashMap<String, String> sp;
    public static final String tt;
    public static final String ve;
    public static long x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function<SparseArray<Object>, Object> f29240a;
    public FileOutputStream uj;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 2298})
    public static final class uj extends Exception {
        public final int c;

        public uj(int i, String str) {
            super(str);
            this.c = i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.zj.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 917})
    public static final class C0597ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29242a;
        public String c;
        public int da;
        public int i;
        public String n;
        public String sl;
        public boolean sp;
        public int tt;
        public String uj;
        public String ve;
        public int x;

        private C0597ve() {
        }

        public boolean c() {
            return TextUtils.equals(this.c, "com.byted.mixed");
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.c).put("version_code", this.tt).put(UserTrackConstant.SIGN, this.n).put("max_version", this.i).put("min_version", this.x).put("is_revert", this.sp).put(TKDownloadReason.KSAD_TK_MD5, this.f29242a).put("plugin_file", this.sl).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        c = sb.toString();
        tt = str + TLogConstant.RUBBISH_DIR;
        ve = str + "conf";
        n = new ve();
        sp = new HashMap<>();
    }

    private ve() {
    }

    private static File a(Context context) {
        return new File(ve(context), ve);
    }

    private static File n(Context context) {
        return new File(ve(context), c);
    }

    private static File uj(Context context) {
        return new File(ve(context), tt);
    }

    private static File ve(Context context) {
        return com.byazt.nys.tt.c(context, "tt_pangle_bykv_file", 0);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt {
        public int c;
        public int n;
        public String tt;
        public boolean uj;
        public boolean ve;

        private tt() {
            this.c = 0;
            this.tt = "";
            this.ve = false;
            this.uj = false;
            this.n = 0;
        }

        public synchronized void c(int i) {
            this.c = i;
        }

        public synchronized boolean n() {
            return this.uj;
        }

        public synchronized void tt(boolean z) {
            this.uj = z;
        }

        public synchronized boolean uj() {
            return this.ve;
        }

        public synchronized String ve() {
            return this.tt;
        }

        public synchronized void c(String str) {
            this.tt = str;
        }

        public synchronized void tt(int i) {
            this.n = i;
        }

        public synchronized void c(boolean z) {
            this.ve = z;
        }

        public synchronized int tt() {
            return this.c;
        }

        public synchronized int c() {
            return this.n;
        }
    }

    private static int n(C0597ve c0597ve) {
        int iTt;
        if (tt(c0597ve)) {
            iTt = 7611;
        } else {
            if (!x.m().cu().has(c0597ve.c)) {
                return 0;
            }
            JSONObject jSONObjectOptJSONObject = x.m().cu().optJSONObject(c0597ve.c);
            iTt = jSONObjectOptJSONObject != null ? tt(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        }
        return iTt;
    }

    private void tt(Context context) {
        FileOutputStream fileOutputStream = this.uj;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                m.c(e);
            }
        }
        File fileUj = uj(context);
        if (fileUj.exists()) {
            for (File file : fileUj.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static Pair<Boolean, Boolean> uj(C0597ve c0597ve) {
        if (tt(c0597ve)) {
            return new Pair<>(Boolean.valueOf(7611 == c0597ve.tt), Boolean.FALSE);
        }
        JSONObject jSONObjectOptJSONObject = x.m().cu().optJSONObject(c0597ve.c);
        int iTt = jSONObjectOptJSONObject != null ? tt(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        return new Pair<>(Boolean.valueOf(iTt == c0597ve.tt), Boolean.valueOf(iTt != 0));
    }

    private static boolean ve(C0597ve c0597ve) {
        int iTt;
        JSONObject jSONObjectOptJSONObject;
        if (tt(c0597ve)) {
            iTt = p.uj;
        } else {
            iTt = (!x.m().cu().has(c0597ve.c) || (jSONObjectOptJSONObject = x.m().cu().optJSONObject(c0597ve.c)) == null) ? 0 : tt(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iTt >= c0597ve.x && iTt <= c0597ve.i;
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, 24})
    public static class c {
        public int c;
        public String tt;
        public int uj;
        public boolean ve;

        public c(int i, String str, boolean z, int i2) {
            this.c = i;
            this.tt = str;
            this.ve = z;
            this.uj = i2;
        }

        public c(int i) {
            this(i, "", false, 0);
        }
    }

    public static ve c() {
        return n;
    }

    public void c(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = gt.getContext().getApplicationContext();
        n.tt(new sp("updatePlugin") { // from class: com.byazt.zj.ve.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ve.this.c(applicationContext, (List<C0597ve>) ve.ve(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<C0597ve> ve(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                C0597ve c0597ve = new C0597ve();
                c0597ve.c = c(jSONObjectOptJSONObject.optString("package_name"));
                c0597ve.tt = jSONObjectOptJSONObject.optInt("version_code");
                c0597ve.ve = jSONObjectOptJSONObject.optString("version_name");
                c0597ve.uj = jSONObjectOptJSONObject.optString("download_url");
                c0597ve.n = jSONObjectOptJSONObject.optString(UserTrackConstant.SIGN);
                c0597ve.x = tt(jSONObjectOptJSONObject.optString("min_version"));
                c0597ve.i = tt(jSONObjectOptJSONObject.optString("max_version"));
                c0597ve.da = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                arrayList.add(c0597ve);
            }
        }
        Collections.sort(arrayList, new Comparator<C0597ve>() { // from class: com.byazt.zj.ve.8
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(C0597ve c0597ve2, C0597ve c0597ve3) {
                if ("com.byted.pangle".equals(c0597ve2.c)) {
                    return -1;
                }
                return "com.byted.pangle".equals(c0597ve3.c) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    private boolean c(Context context, int i2, String str) {
        int iC = x.m().zm().c(str);
        if (x.m().bm()) {
            return c(iC);
        }
        if (i2 == -1) {
            i2 = iC;
        } else if (i2 != 1 && i2 != 2 && i2 != 3) {
            if (i2 == 4 || i2 == 5) {
                return false;
            }
            if (iC == 3) {
                i2 = 1;
            } else {
                i2 = iC;
            }
        }
        return c(i2);
    }

    private static boolean tt(C0597ve c0597ve) {
        return "com.byted.pangle".equals(c0597ve.c);
    }

    private boolean tt(C0597ve c0597ve, int i2) {
        tt(c0597ve);
        return (i2 == 21 || i2 == 18) ? false : true;
    }

    private boolean tt(String str, String str2) {
        File file = new File(str, str2 + ".temp");
        return file.exists() && file.length() > 0;
    }

    private static boolean tt(int i2) {
        File fileC = com.byazt.nys.tt.c(gt.getContext());
        if (fileC == null) {
            return false;
        }
        return new File(fileC.getParent() + "/pangle_p/com.byted.pangle/version-" + i2).exists();
    }

    private boolean c(int i2) {
        if (i2 != 1) {
            if (i2 == 3 || i2 == 4 || i2 == 5) {
                return false;
            }
        } else if (!rh.uj(gt.getContext())) {
            return false;
        }
        return true;
    }

    public void c(Function<SparseArray<Object>, Object> function) {
        this.f29240a = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context, List<C0597ve> list) throws Throwable {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                    try {
                        try {
                            if (!c(context)) {
                                tt(context);
                                return;
                            }
                            final boolean zVe = ve();
                            if (zVe && !com.byazt.nr.gt.c(context)) {
                                tt(context);
                                return;
                            }
                            list.size();
                            final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                            for (final C0597ve c0597ve : list) {
                                try {
                                    if (c(c0597ve)) {
                                        countDownLatch.countDown();
                                    } else {
                                        n.tt(new sp("pl download") { // from class: com.byazt.zj.ve.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                ve.this.c(context, c0597ve, false, zVe);
                                                countDownLatch.countDown();
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    e = e;
                                }
                            }
                            countDownLatch.await();
                            zm zmVar = (zm) com.byazt.ut.uj.getService("m_s");
                            if (zmVar != null) {
                                zmVar.setState(0, 64, false);
                            }
                            tt(context);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        tt(context);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                    tt(context);
                    throw th;
                }
                yp.c().c("", 7611, 0, "", 14, e.getMessage(), 0L, false, false, false, false, 0);
                m.tt("PluginUpdater", "Handle file error: " + e);
                tt(context);
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static String tt() {
        String str;
        String strC = com.byazt.qya.tt.c();
        if ("arm64-v8a".equals(strC)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strC)) {
            str = "@32";
        } else {
            str = "armeabi".equals(strC) ? "@armeabi" : "";
        }
        return "com.byted.live.lite" + str;
    }

    private static int tt(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(Consts.DOT, ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean ve() {
        JSONObject jSONObjectPo = gt.tt().po();
        if (jSONObjectPo == null) {
            return false;
        }
        return jSONObjectPo.optBoolean("use_downloader", false);
    }

    private boolean c(Context context) {
        try {
            File fileUj = uj(context);
            if (!fileUj.exists()) {
                fileUj.mkdirs();
            }
            File file = new File(fileUj, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                m.tt("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.uj = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            m.tt("PluginUpdater", "Acquire file lock failed");
            this.uj.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.uj;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            m.tt("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private boolean c(C0597ve c0597ve) {
        String str = c0597ve == null ? null : c0597ve.c;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("com.byted.pangle")) {
            z = com.byazt.by.ve.c().x() == 2;
            if (z) {
                m.tt("PluginUpdater", "force use bst, dont update ad pl");
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, C0597ve c0597ve, boolean z, boolean z2) {
        int i2;
        String str;
        boolean z3;
        c cVar = new c(0);
        if (!c(context, c0597ve.da, c0597ve.c)) {
            str = x.m().zm() + u15.f19942b + c0597ve.da;
            i2 = 20;
        } else {
            File fileUj = uj(context);
            if (z2) {
                cVar = c(context, fileUj, c0597ve);
            } else {
                cVar = c(context, fileUj, c0597ve, z, z2);
            }
            i2 = cVar.c;
            str = "";
        }
        String str2 = str;
        int i3 = i2;
        if (i3 == 9 || i3 == 14) {
            c(c0597ve.c, 1004);
            z3 = false;
        } else {
            z3 = true;
        }
        yp.c().c(c0597ve.c, tt(c0597ve) ? 7611 : 0, c0597ve.tt, c0597ve.uj, i3, str2, i - x, z, ((Boolean) uj(c0597ve).second).booleanValue(), cVar.ve, z2, cVar.uj);
        if (z3) {
            c(c0597ve, cVar.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(C0597ve c0597ve, int i2) {
        SparseArray<Object> sparseArrayTt;
        PluginValueSet pluginValueSetTt;
        if (this.f29240a == null || !tt(c0597ve, i2)) {
            return;
        }
        SparseArray<Object> sparseArrayTt2 = com.byazt.yxi.uj.c().c(2, c0597ve.toString()).c(3, c0597ve.c).tt();
        boolean z = i2 == 6 || i2 == 10 || i2 == 16;
        SparseArray<Object> sparseArrayTt3 = com.byazt.yxi.n.c().c(z).c(z ? 0 : 1004).c(sparseArrayTt2).tt();
        try {
            if (com.byazt.lq.uj.c(p.uj)) {
                sparseArrayTt = com.byazt.yxi.uj.c(sparseArrayTt3).c(1).c(SparseArray.class).tt();
            } else {
                sparseArrayTt = com.byazt.yxi.uj.c().c(1).c(SparseArray.class).c(-99999979, sparseArrayTt3).tt();
            }
            Object objApply = this.f29240a.apply(sparseArrayTt);
            if (objApply instanceof SparseArray) {
                pluginValueSetTt = com.byazt.rl.c.c((SparseArray<Object>) objApply).tt();
            } else {
                pluginValueSetTt = (com.byazt.lq.uj.c(p.uj) && (objApply instanceof PluginValueSet)) ? (PluginValueSet) objApply : null;
            }
            if (pluginValueSetTt != null && pluginValueSetTt.booleanValue(4) && c0597ve.sl != null) {
                HashMap<String, String> map = sp;
                map.put(c0597ve.c, new File(c0597ve.sl).getName());
                c(c0597ve.c, c0597ve.ve);
                map.values();
            }
            if (c0597ve.c.equals("com.byted.csj.ext")) {
                da.c(null);
            }
        } catch (Exception e) {
            m.ve("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
        }
    }

    private static void c(String str, String str2) {
        if (str == null) {
            return;
        }
        x.m().c(str, str2);
    }

    private c c(Context context, File file, final C0597ve c0597ve) {
        if (c0597ve != null) {
            try {
                if (!TextUtils.isEmpty(c0597ve.uj)) {
                    if (TextUtils.isEmpty(c0597ve.c)) {
                        return new c(12);
                    }
                    if (!tt(c0597ve) && !x.m().cu().has(c0597ve.c)) {
                        return new c(17);
                    }
                    final Pair<Boolean, Boolean> pairUj = uj(c0597ve);
                    if (((Boolean) pairUj.first).booleanValue()) {
                        return new c(18);
                    }
                    if (tt(c0597ve.tt)) {
                        return new c(21);
                    }
                    if (!ve(c0597ve)) {
                        return new c(19);
                    }
                    final File fileA = a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    if (tt(c0597ve) && p.uj >= c0597ve.tt) {
                        String str = c49.f40900a + a.tt(c0597ve.c) + c49.f40900a + p.uj + c49.f40900a + p.uj;
                        int i2 = p.uj;
                        c0597ve.i = i2;
                        c0597ve.x = i2;
                        c0597ve.sp = true;
                        c(new File(fileA, str + ".conf"), c0597ve);
                        return new c(10);
                    }
                    if (TextUtils.isEmpty(c0597ve.n) && !c0597ve.c()) {
                        return new c(1);
                    }
                    final String strTt = a.tt(c0597ve.c);
                    StringBuilder sb = new StringBuilder();
                    String strTt2 = a.tt(c0597ve.n);
                    if (!TextUtils.isEmpty(strTt2)) {
                        sb.append(strTt2);
                        sb.append(c49.f40900a);
                    }
                    sb.append(strTt);
                    sb.append(c49.f40900a);
                    sb.append(c0597ve.x);
                    sb.append(c49.f40900a);
                    sb.append(c0597ve.i);
                    String string = sb.toString();
                    final File fileN = n(context);
                    if (!fileN.exists()) {
                        fileN.mkdirs();
                    }
                    final File file2 = new File(fileN, string + (c0597ve.c() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0597ve.f29242a = a.c(file2);
                        c0597ve.sl = file2.getAbsolutePath();
                        return new c(16);
                    }
                    if (file2.getName().equals(sp.get(c0597ve.c))) {
                        return new c(21);
                    }
                    final int i3 = tt(c0597ve) ? 7611 : 0;
                    final File file3 = new File(file, string);
                    x = System.currentTimeMillis();
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final tt ttVar = new tt();
                    new com.byazt.zj.c(c0597ve.c, c0597ve.uj, file.getAbsolutePath(), string, c0597ve.da == 1, new com.byazt.zj.c.InterfaceC0596c() { // from class: com.byazt.zj.ve.3
                        public long t = 0;

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void c(DownloadInfo downloadInfo) {
                            ttVar.c(com.byazt.w.a.a(downloadInfo) > 0);
                            yp ypVarC = yp.c();
                            C0597ve c0597ve2 = c0597ve;
                            ypVarC.c(c0597ve2.c, i3, c0597ve2.tt, c0597ve2.uj, 7, "", 0L, false, ((Boolean) pairUj.second).booleanValue(), ttVar.uj(), true, 1);
                            C0597ve c0597ve3 = c0597ve;
                            yp.ve(c0597ve3.c, String.valueOf(c0597ve3.tt));
                        }

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void tt(DownloadInfo downloadInfo) {
                            ttVar.c(ve.this.c(file3, fileA, file2, fileN, strTt, c0597ve));
                            ttVar.tt(1);
                            if (ttVar.n()) {
                                ve.this.c(c0597ve, ttVar.tt());
                            }
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void tt(DownloadInfo downloadInfo, int i4) {
                            this.t = System.currentTimeMillis();
                            yp ypVarC = yp.c();
                            C0597ve c0597ve2 = c0597ve;
                            ypVarC.c(c0597ve2.c, i3, c0597ve2.tt, c0597ve2.uj, 7, "", 0L, false, ((Boolean) pairUj.second).booleanValue(), ttVar.uj(), true, i4);
                        }

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void c(DownloadInfo downloadInfo, BaseException baseException) {
                            long unused = ve.i = System.currentTimeMillis();
                            ttVar.c(9);
                            ttVar.tt(1);
                            tt ttVar2 = ttVar;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(baseException.getErrorCode());
                            sb2.append(" : ");
                            sb2.append(baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage());
                            ttVar2.c(sb2.toString());
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void c(DownloadInfo downloadInfo, int i4) {
                            int iC = ve.this.c(file3, fileA, file2, fileN, strTt, c0597ve);
                            yp ypVarC = yp.c();
                            C0597ve c0597ve2 = c0597ve;
                            ypVarC.c(c0597ve2.c, i3, c0597ve2.tt, c0597ve2.uj, 6, "", System.currentTimeMillis() - this.t, false, ((Boolean) pairUj.second).booleanValue(), ttVar.uj(), true, i4);
                            ve.this.c(c0597ve, iC);
                        }

                        @Override // com.byazt.zj.c.InterfaceC0596c
                        public void c(DownloadInfo downloadInfo, BaseException baseException, int i4) {
                            yp ypVarC = yp.c();
                            C0597ve c0597ve2 = c0597ve;
                            String str2 = c0597ve2.c;
                            int i5 = i3;
                            int i6 = c0597ve2.tt;
                            String str3 = c0597ve2.uj;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(baseException.getErrorCode());
                            sb2.append(" : ");
                            sb2.append(baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage());
                            ypVarC.c(str2, i5, i6, str3, 9, sb2.toString(), System.currentTimeMillis() - this.t, false, ((Boolean) pairUj.second).booleanValue(), ttVar.uj(), true, i4);
                        }
                    }).c(context);
                    try {
                        ttVar.tt(!countDownLatch.await(600L, TimeUnit.SECONDS));
                    } catch (InterruptedException e) {
                        ttVar.c(9);
                        ttVar.c("countDownLatch interrupted: " + e.getMessage());
                    }
                    if (ttVar.n()) {
                        ttVar.c(9);
                        ttVar.c("countDownLatch timeout");
                    }
                    return new c(ttVar.tt(), ttVar.ve(), ttVar.uj(), ttVar.c());
                }
            } catch (Exception e2) {
                m.tt("PluginUpdater", "Download file error: " + e2);
                String message = e2.getMessage();
                try {
                    message = Log.getStackTraceString(e2);
                } catch (Throwable th) {
                    m.c(th);
                }
                return new c(14, message, false, 0);
            }
        }
        return new c(2);
    }

    private c c(Context context, File file, C0597ve c0597ve, boolean z, boolean z2) {
        com.byazt.hm.tt ttVarC;
        String str;
        if (c0597ve != null) {
            try {
                if (!TextUtils.isEmpty(c0597ve.uj)) {
                    if (TextUtils.isEmpty(c0597ve.c)) {
                        return new c(12);
                    }
                    if (!tt(c0597ve) && !x.m().cu().has(c0597ve.c)) {
                        return new c(17);
                    }
                    Pair<Boolean, Boolean> pairUj = uj(c0597ve);
                    if (((Boolean) pairUj.first).booleanValue()) {
                        return new c(18);
                    }
                    if (tt(c0597ve.tt)) {
                        return new c(21);
                    }
                    if (!ve(c0597ve)) {
                        return new c(19);
                    }
                    File fileA = a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    if (tt(c0597ve) && p.uj >= c0597ve.tt) {
                        String str2 = c49.f40900a + a.tt(c0597ve.c) + c49.f40900a + p.uj + c49.f40900a + p.uj;
                        int i2 = p.uj;
                        c0597ve.i = i2;
                        c0597ve.x = i2;
                        c0597ve.sp = true;
                        c(new File(fileA, str2 + ".conf"), c0597ve);
                        return new c(10);
                    }
                    if (TextUtils.isEmpty(c0597ve.n) && !c0597ve.c()) {
                        return new c(1);
                    }
                    String strTt = a.tt(c0597ve.c);
                    StringBuilder sb = new StringBuilder();
                    String strTt2 = a.tt(c0597ve.n);
                    if (!TextUtils.isEmpty(strTt2)) {
                        sb.append(strTt2);
                        sb.append(c49.f40900a);
                    }
                    sb.append(strTt);
                    sb.append(c49.f40900a);
                    sb.append(c0597ve.x);
                    sb.append(c49.f40900a);
                    sb.append(c0597ve.i);
                    String string = sb.toString();
                    File fileN = n(context);
                    if (!fileN.exists()) {
                        fileN.mkdirs();
                    }
                    File file2 = new File(fileN, string + (c0597ve.c() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0597ve.f29242a = a.c(file2);
                        c0597ve.sl = file2.getAbsolutePath();
                        return new c(16);
                    }
                    if (file2.getName().equals(sp.get(c0597ve.c))) {
                        return new c(21);
                    }
                    int i3 = tt(c0597ve) ? 7611 : 0;
                    File file3 = new File(file, string);
                    x = System.currentTimeMillis();
                    String absolutePath = file.getAbsolutePath();
                    boolean zTt = tt(absolutePath, string);
                    yp.c().c(c0597ve.c, i3, c0597ve.tt, c0597ve.uj, 7, "", 0L, z, ((Boolean) pairUj.second).booleanValue(), zTt, false, 0);
                    yp.ve(c0597ve.c, String.valueOf(c0597ve.tt));
                    if (com.byazt.ogz.da.c(c0597ve.c)) {
                        ttVarC = c(com.byazt.hy.n.c().tt().c(c0597ve.uj, absolutePath, string), c0597ve.c);
                    } else {
                        com.byazt.va.tt ttVarUj = com.byazt.hy.n.c().tt().uj();
                        ttVarUj.c(c0597ve.uj);
                        ttVarUj.c(absolutePath, string);
                        ttVarC = ttVarUj.c();
                    }
                    if (ttVarC != null && ttVarC.i()) {
                        return new c(c(file3, fileA, file2, fileN, strTt, c0597ve), "", zTt, 0);
                    }
                    i = System.currentTimeMillis();
                    if (ttVarC != null) {
                        str = ttVarC.tt() + " : " + ttVarC.ve();
                    } else {
                        str = "no response";
                    }
                    return new c(9, str, zTt, 0);
                }
            } catch (Exception e) {
                m.tt("PluginUpdater", "Download file error: " + e);
                if (!z2) {
                    c(context, c0597ve);
                }
                String message = e.getMessage();
                try {
                    message = Log.getStackTraceString(e);
                } catch (Throwable th) {
                    m.c(th);
                }
                return new c(14, message, false, 0);
            }
        }
        return new c(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(File file, File file2, File file3, File file4, String str, C0597ve c0597ve) {
        i = System.currentTimeMillis();
        if (!file.exists()) {
            return 13;
        }
        c(file4, str);
        c(file2, str);
        if (!file.renameTo(file3)) {
            return 5;
        }
        File file5 = new File(file2, file.getName() + ".conf");
        c0597ve.f29242a = a.c(file3);
        c0597ve.sl = file3.getAbsolutePath();
        c0597ve.sp = c0597ve.tt < n(c0597ve);
        return c(file5, c0597ve) ? 6 : 15;
    }

    private static com.byazt.hm.tt c(final com.byazt.va.tt ttVar, final String str) throws uj {
        try {
            return (com.byazt.hm.tt) new com.byazt.qya.n.c(new Callable<com.byazt.hm.tt>() { // from class: com.byazt.zj.ve.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public com.byazt.hm.tt call() {
                    return ttVar.c();
                }
            }, new com.byazt.qya.n.tt<com.byazt.hm.tt>() { // from class: com.byazt.zj.ve.5
                @Override // com.byazt.qya.n.tt
                public boolean c(com.byazt.hm.tt ttVar2) {
                    if (((u) com.byazt.ut.uj.getService("device_info_new")).getRealNetworkType(0L) == 0 || ttVar2 == null) {
                        return false;
                    }
                    Throwable thC = ttVar2.c();
                    return thC != null ? com.byazt.qya.n.c(thC) : com.byazt.qya.n.c(ttVar2.tt());
                }

                @Override // com.byazt.qya.n.tt
                public boolean c(Exception exc) {
                    if (((u) com.byazt.ut.uj.getService("device_info_new")).getRealNetworkType(0L) == 0) {
                        return false;
                    }
                    return exc instanceof NullPointerException;
                }
            }).c(com.byazt.ogz.da.tt(str)).c().c();
        } catch (Exception e) {
            String message = e.getMessage();
            try {
                message = Log.getStackTraceString(e);
            } catch (Throwable th) {
                m.c(th);
            }
            throw new uj(14, message);
        }
    }

    private void c(final Context context, final C0597ve c0597ve) {
        if (com.byazt.ogz.da.c(c0597ve.c) && ((u) com.byazt.ut.uj.getService("device_info_new")).getRealNetworkType(0L) == 0) {
            com.byazt.qya.ve.c().c(new com.byazt.qya.ve.tt() { // from class: com.byazt.zj.ve.6
                @Override // com.byazt.qya.ve.tt
                public void c() throws Exception {
                    ve.this.c(context, c0597ve, true, false);
                }
            });
        }
    }

    private static boolean c(File file, C0597ve c0597ve) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(c0597ve.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            m.tt("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void c(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.byazt.zj.ve.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                m.tt("PluginUpdater", "Delete file: ".concat(str2));
                return false;
            }
        });
    }

    public static String c(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    public void c(String str, int i2) {
        SparseArray<Object> sparseArrayTt;
        if (this.f29240a == null) {
            return;
        }
        SparseArray<Object> sparseArrayTt2 = com.byazt.yxi.n.c().c(false).c(i2).c(com.byazt.yxi.uj.c().c(3, str).tt()).tt();
        int i3 = p.uj;
        if (i3 < 7000 && i3 >= 6800) {
            sparseArrayTt = com.byazt.yxi.uj.c(sparseArrayTt2).c(1).c(Void.class).tt();
        } else {
            sparseArrayTt = com.byazt.yxi.uj.c().c(1).c(Void.class).c(-99999979, sparseArrayTt2).tt();
        }
        this.f29240a.apply(sparseArrayTt);
    }
}
