package com.byazt.iyp;

import android.R;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.MainThread;
import com.zj.adlib.aq6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 91})
public final class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28678a;
    public static final Set<String> c;
    public static final Set<String> da;
    public static final WeakHashMap<Activity, c> i;
    public static boolean n;
    public static volatile int sl;
    public static String sp;
    public static final Map<String, Boolean> t;
    public static final Map<String, Boolean> tt;
    public static String uj;
    public static List<String> ve;
    public static WeakReference<Activity> x;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 180})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28679a;
        public String c;
        public Runnable da;
        public long i;
        public long n;
        public Runnable sl;
        public int sp;
        public Runnable t;
        public long tt;
        public long uj;
        public long ve;
        public boolean x;

        public c(String str) {
            this.c = str;
        }
    }

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        c = keySetViewNewKeySet;
        keySetViewNewKeySet.addAll(Arrays.asList("d22096b358acef645e49e08ad7de4bb6", "ff4b9977c134ab22a2d3618b51a36045", "7e2d432c1679374070821b28b7145c19", "b9304799be85d7222baa15927a7e3cd1", "6edca895469b266a9e12387b11115808", "8d432dfb8327eab8ced7b97f00221d4f", "2e934727248ee0cd7787256613245ba6", "07c1627688f39f4b050d7180bab92f34", "149a05b3da0f19e3ce840afe6f6c67f3", "529bd4093e440a920d7c99c8ba781a4d", "cbd09814ff5652055c2af0bb0f9d4314"));
        tt = new ConcurrentHashMap();
        ve = null;
        i = new WeakHashMap<>();
        da = Collections.newSetFromMap(new ConcurrentHashMap());
        sl = -1;
        t = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static boolean da(Activity activity) {
        String strTt = tt();
        return (TextUtils.isEmpty(strTt) || strTt.equals(my(activity))) ? false : true;
    }

    private static View gt(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            if (activity.getWindow() != null) {
                return activity.getWindow().getDecorView();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @MainThread
    private static void i(final Activity activity) {
        if (activity == null) {
            return;
        }
        final c cVarVe = ve(activity, my(activity));
        int i2 = cVarVe.sp + 1;
        if (i2 > 2) {
            activity.hashCode();
            if (m(activity)) {
                c(activity, cVarVe.c);
                return;
            }
            return;
        }
        cVarVe.sp = i2;
        long j = ((long) i2) * 3000;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.iyp.sp.3
            @Override // java.lang.Runnable
            public void run() {
                cVarVe.sl = null;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || activity2.isFinishing()) {
                    activity.hashCode();
                } else if (sp.rh(activity) && !sp.a(sp.my(activity2))) {
                    activity.hashCode();
                    sp.tt(activity2, 5, true);
                }
            }
        };
        cVarVe.sl = runnable;
        View viewGt = gt(activity);
        if (viewGt != null) {
            viewGt.postDelayed(runnable, j);
        } else {
            activity.hashCode();
            cVarVe.sl = null;
        }
    }

    private static boolean m(Activity activity) {
        View decorView;
        if (activity == null) {
            return false;
        }
        try {
            Window window = activity.getWindow();
            if (window != null && (decorView = window.getDecorView()) != null && decorView.getWidth() != 0 && decorView.getHeight() != 0) {
                View viewFindViewById = decorView.findViewById(R.id.content);
                return !(viewFindViewById instanceof ViewGroup) || ((ViewGroup) viewFindViewById).getChildCount() > 0;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String my(Activity activity) {
        if (activity == null) {
            return "";
        }
        try {
            Object objC = sl.c(activity);
            return objC == null ? activity.getClass().getName() : objC.getClass().getName();
        } catch (Throwable unused) {
            return activity.getClass().getName();
        }
    }

    @MainThread
    private static void nu(Activity activity) {
        if (activity == null) {
            return;
        }
        i.remove(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean rh(Activity activity) {
        if (ve.uj() != 1) {
            return false;
        }
        if (sl == -1 && activity != null) {
            com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
            if (veVarC == null) {
                return true;
            }
            try {
                if (veVarC.get("no_tab_global", false)) {
                    long j = veVarC.get("no_tab_global_version", -1L);
                    long jU = u(activity);
                    if (jU <= 0 || j <= 0 || j == jU) {
                        sl = 0;
                    } else {
                        veVarC.put("no_tab_global", false);
                        veVarC.put("no_tab_global_class_count", 0);
                        sl = 1;
                    }
                } else {
                    sl = 1;
                }
            } catch (Throwable unused) {
                sl = 1;
            }
        }
        return sl != 0;
    }

    private static void rl(Activity activity) {
        c cVar = i.get(activity);
        if (cVar == null) {
            return;
        }
        View viewGt = gt(activity);
        if (viewGt != null) {
            Runnable runnable = cVar.da;
            if (runnable != null) {
                viewGt.removeCallbacks(runnable);
            }
            Runnable runnable2 = cVar.sl;
            if (runnable2 != null) {
                viewGt.removeCallbacks(runnable2);
            }
            Runnable runnable3 = cVar.t;
            if (runnable3 != null) {
                viewGt.removeCallbacks(runnable3);
            }
        }
        cVar.da = null;
        cVar.sl = null;
        cVar.t = null;
        cVar.x = false;
    }

    @MainThread
    private static boolean sl(Activity activity) {
        String strTt = tt();
        return !TextUtils.isEmpty(strTt) && strTt.equals(my(activity));
    }

    @MainThread
    private static boolean t(Activity activity) {
        return activity != null && n && activity.hashCode() == f28678a && my(activity).equals(sp);
    }

    @MainThread
    public static void tt(Activity activity) {
        if (activity != null && rh(activity)) {
            String strMy = my(activity);
            if (tt(activity, strMy)) {
                return;
            }
            if (sl(activity)) {
                uj.uj();
            }
            if (ve(activity, 2, true)) {
                return;
            }
            if (a(strMy)) {
                nu(activity);
                return;
            }
            c cVarVe = ve(activity, strMy);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (cVarVe.tt == 0) {
                cVarVe.tt = jCurrentTimeMillis;
            }
            cVarVe.ve = jCurrentTimeMillis;
            cVarVe.f28679a = activity.isTaskRoot();
            activity.hashCode();
            n();
            if (!uj(strMy) || (!activity.isTaskRoot() && !n())) {
                x(activity);
                return;
            }
            activity.isTaskRoot();
            n();
            tt(activity, 3, true);
        }
    }

    private static long u(Activity activity) {
        PackageInfo packageInfo;
        if (activity == null) {
            return -1L;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0)) == null) {
                return -1L;
            }
            return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static Iterable<String> uj() {
        Set<String> setLx;
        com.byazt.ogz.sl slVarTt = gt.tt();
        if (slVarTt != null && (setLx = slVarTt.lx()) != null && !setLx.isEmpty()) {
            return setLx;
        }
        if (ve == null) {
            ArrayList arrayList = new ArrayList();
            ve = arrayList;
            arrayList.add(c(new byte[]{aq6.f40585a, 117, 113, 102, aq6.f40585a, 109}));
            ve.add(c(new byte[]{108, 122, 110, 105, 106}));
            ve.add(c(new byte[]{124, 106, 113, 104, 116, 114, 106}));
            ve.add(c(new byte[]{110, 115, 121, 106, 119, aq6.f40585a, 121, 110, 121, 110, 102, 113}));
            ve.add(c(new byte[]{119, 116, 122, 121, 106, 119}));
            ve.add(c(new byte[]{119, 116, 122, 121, 106}));
            ve.add(c(new byte[]{121, 119, 102, 115, aq6.f40585a, 110, 121, 110, 116, 115}));
            ve.add(c(new byte[]{119, 106, 124, 102, 119, 105}));
        }
        return ve;
    }

    @MainThread
    public static void ve(Activity activity) {
        c cVar;
        if (activity == null) {
            return;
        }
        rl(activity);
        if (rh(activity)) {
            if (sl(activity)) {
                uj.n();
            }
            if (ve(activity, 6, false) || (cVar = i.get(activity)) == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            cVar.uj = jCurrentTimeMillis;
            long j = cVar.ve;
            if (j <= 0 || jCurrentTimeMillis - j >= 1200) {
                activity.hashCode();
            } else {
                activity.hashCode();
                nu(activity);
            }
        }
    }

    @MainThread
    private static void x(final Activity activity) {
        if (activity == null) {
            return;
        }
        final c cVarVe = ve(activity, my(activity));
        if (cVarVe.x) {
            activity.hashCode();
            return;
        }
        cVarVe.x = true;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.iyp.sp.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cVarVe.t = null;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null && !activity2.isFinishing()) {
                        if (!sp.rh(activity)) {
                            c cVar = cVarVe;
                            cVar.x = false;
                            cVar.t = null;
                            return;
                        }
                        if (sp.da(activity2)) {
                            sp.my(activity2);
                            sp.tt();
                            c cVar2 = cVarVe;
                            cVar2.x = false;
                            cVar2.t = null;
                            return;
                        }
                        if (sp.a(sp.my(activity2))) {
                            sp.my(activity2);
                            c cVar3 = cVarVe;
                            cVar3.x = false;
                            cVar3.t = null;
                            return;
                        }
                        c cVar4 = cVarVe;
                        long j = cVar4.ve;
                        long j2 = cVar4.uj;
                        long j3 = cVar4.n;
                        if (j > 0 && j2 < j && j3 <= 0) {
                            if (System.currentTimeMillis() - j >= 3000) {
                                sp.tt(activity2, 4, true);
                            }
                            c cVar5 = cVarVe;
                            cVar5.x = false;
                            cVar5.t = null;
                            return;
                        }
                        cVar4.x = false;
                        cVar4.t = null;
                        return;
                    }
                    activity.hashCode();
                    c cVar6 = cVarVe;
                    cVar6.x = false;
                    cVar6.t = null;
                } catch (Throwable th) {
                    c cVar7 = cVarVe;
                    cVar7.x = false;
                    cVar7.t = null;
                    throw th;
                }
            }
        };
        cVarVe.t = runnable;
        View viewGt = gt(activity);
        if (viewGt != null) {
            viewGt.postDelayed(runnable, 4500L);
            return;
        }
        activity.hashCode();
        cVarVe.x = false;
        cVarVe.t = null;
    }

    private static boolean yp(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (activity.getResources() != null && activity.getResources().getConfiguration() != null && activity.getResources().getConfiguration().orientation == 2) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            return (activity.getWindow() == null || activity.getWindow().getAttributes() == null || (activity.getWindow().getAttributes().flags & 1024) == 0) ? false : true;
        } catch (Throwable unused2) {
        }
    }

    private static boolean z(Activity activity) {
        if (activity == null) {
            return false;
        }
        String name = activity.getClass().getName();
        if (name.contains("UnityPlayerActivity") || name.contains("Cocos2dxActivity") || name.contains("NativeActivity") || name.contains("GameActivity")) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            return applicationInfo != null && (applicationInfo.category == 0 || (applicationInfo.flags & 33554432) != 0);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0026 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0028 A[RETURN] */
    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : uj()) {
            if (lowerCase.contains(str2)) {
                if (str2 != null) {
                    return true;
                }
                return false;
            }
        }
        str2 = null;
        if (str2 != null) {
            return true;
        }
        return false;
    }

    private static boolean n(String str) {
        try {
            String strC = com.byazt.as.ve.c(str.toLowerCase());
            return strC != null && c.contains(strC);
        } catch (Exception unused) {
        }
    }

    private static String sp(String str) {
        if (str == null) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : str;
    }

    private static String c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] - 5);
        }
        return new String(bArr2);
    }

    private static boolean n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        for (c cVar : i.values()) {
            if (cVar != null) {
                long j = cVar.ve;
                if (j > 0 && cVar.n == 0 && cVar.uj < j && jCurrentTimeMillis - j < 86400000) {
                    i2++;
                }
            }
        }
        return i2 <= 2;
    }

    @MainThread
    public static void c(Activity activity) {
        if (activity != null && rh(activity)) {
            String strMy = my(activity);
            if (tt(activity, strMy) || ve(activity, 1, true) || a(strMy)) {
                return;
            }
            c cVarVe = ve(activity, strMy);
            cVarVe.tt = System.currentTimeMillis();
            cVarVe.f28679a = activity.isTaskRoot();
            activity.hashCode();
        }
    }

    @MainThread
    private static boolean ve(Activity activity, int i2, boolean z) {
        String strTt = tt();
        if (TextUtils.isEmpty(strTt)) {
            return false;
        }
        if (!strTt.equals(my(activity))) {
            return true;
        }
        if (!t(activity)) {
            if (z) {
                activity.hashCode();
                tt(activity, i2, false);
            } else {
                activity.hashCode();
            }
            return true;
        }
        if (!n.c()) {
            activity.hashCode();
            uj.c();
            n = false;
            f28678a = -1;
            sp = "";
            tt(activity, i2, false);
            return true;
        }
        activity.hashCode();
        return true;
    }

    @MainThread
    public static void uj(Activity activity) {
        if (activity == null) {
            return;
        }
        rl(activity);
        if (rh(activity)) {
            if (t(activity)) {
                my(activity);
                activity.hashCode();
                n.tt();
                uj.sp();
                n = false;
                f28678a = -1;
                sp = "";
                x = null;
                return;
            }
            if (ve(activity, 7, false)) {
                return;
            }
            c cVar = i.get(activity);
            if (cVar == null) {
                my(activity);
                activity.hashCode();
                nu(activity);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            cVar.n = jCurrentTimeMillis;
            long j = cVar.tt;
            if (j > 0 && jCurrentTimeMillis - j < 1200) {
                activity.hashCode();
                nu(activity);
            } else {
                activity.hashCode();
                nu(activity);
            }
        }
    }

    @MainThread
    public static Activity c() {
        WeakReference<Activity> weakReference = x;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void c(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Boolean> map = t;
        Boolean bool = Boolean.TRUE;
        map.put(str, bool);
        if (da.add(str)) {
            try {
                com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
                if (veVarC == null) {
                    return;
                }
                long jU = u(activity);
                long j = veVarC.get("no_tab_fail_version_".concat(String.valueOf(str)), -1L);
                int i2 = veVarC.get("no_tab_fail_count_".concat(String.valueOf(str)), 0);
                if (jU > 0 && j > 0 && j != jU) {
                    i2 = 0;
                }
                int i3 = i2 + 1;
                if (i3 >= 3) {
                    veVarC.put("no_tab_arch_".concat(String.valueOf(str)), true);
                    veVarC.put("no_tab_app_version_".concat(String.valueOf(str)), jU);
                    map.put(str, bool);
                    int i4 = veVarC.get("no_tab_global_class_count", 0) + 1;
                    veVarC.put("no_tab_global_class_count", i4);
                    if (uj(str) || i4 >= 4) {
                        veVarC.put("no_tab_global", true);
                        veVarC.put("no_tab_global_version", jU);
                        sl = 0;
                        return;
                    }
                    return;
                }
                veVarC.put("no_tab_fail_count_".concat(String.valueOf(str)), i3);
                veVarC.put("no_tab_fail_version_".concat(String.valueOf(str)), jU);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static void tt(Activity activity, final int i2, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        String strMy = my(activity);
        if (!yp(activity) && !z(activity)) {
            if (tt(activity, strMy)) {
                activity.hashCode();
                return;
            }
            if (t(activity)) {
                activity.hashCode();
                return;
            }
            final c cVarVe = ve(activity, strMy);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                long j = cVarVe.i;
                if (j > 0 && jCurrentTimeMillis - j < 2000) {
                    return;
                }
            }
            cVarVe.i = jCurrentTimeMillis;
            activity.hashCode();
            final WeakReference weakReference = new WeakReference(activity);
            final int iHashCode = activity.hashCode();
            Runnable runnable = new Runnable() { // from class: com.byazt.iyp.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    cVarVe.da = null;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 == null || activity2.isFinishing()) {
                        return;
                    }
                    sp.tt(activity2, sp.my(activity2), activity2.hashCode(), i2);
                }
            };
            cVarVe.da = runnable;
            View viewGt = gt(activity);
            if (viewGt != null) {
                viewGt.post(runnable);
                return;
            } else {
                cVarVe.da = null;
                return;
            }
        }
        activity.hashCode();
    }

    public static int ve() {
        if (sl != -1) {
            return sl == 0 ? 0 : -1;
        }
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        if (veVarC == null) {
            return -1;
        }
        try {
            return veVarC.get("no_tab_global", false) ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static void ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
            if (veVarC == null) {
                return;
            }
            veVarC.put("no_tab_arch_".concat(String.valueOf(str)), false);
            veVarC.put("no_tab_fail_count_".concat(String.valueOf(str)), 0);
            veVarC.put("no_tab_fail_version_".concat(String.valueOf(str)), 0L);
            veVarC.put("no_tab_app_version_".concat(String.valueOf(str)), 0L);
            t.put(str, Boolean.FALSE);
            if (sl == 0 || veVarC.get("no_tab_global", false)) {
                veVarC.put("no_tab_global", false);
                veVarC.put("no_tab_global_class_count", 0);
                sl = 1;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean uj(String str) {
        Set<String> setXl;
        String strSp = sp(str);
        boolean zN = false;
        if (TextUtils.isEmpty(strSp)) {
            return false;
        }
        Map<String, Boolean> map = tt;
        Boolean bool = map.get(strSp);
        if (bool != null) {
            bool.booleanValue();
            return bool.booleanValue();
        }
        com.byazt.ogz.sl slVarTt = gt.tt();
        if (slVarTt != null && (setXl = slVarTt.xl()) != null && setXl.contains(strSp)) {
            zN = true;
        }
        if (!zN) {
            zN = n(strSp);
        }
        map.put(strSp, Boolean.valueOf(zN));
        return zN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public static void tt(Activity activity, String str, int i2, int i3) {
        List<n.C0442n> list;
        if (activity == null || activity.isFinishing() || t(activity)) {
            return;
        }
        n.tt ttVarC = n.c(activity);
        if (!((ttVarC == null || (list = ttVarC.uj) == null || list.isEmpty()) ? false : true)) {
            sl(activity);
            uj(str);
            if (i3 == 2 || i3 == 1 || i3 == 4 || i3 == 3 || i3 == 5) {
                i(activity);
                return;
            }
            return;
        }
        ve(str);
        if (TextUtils.isEmpty(tt())) {
            tt(str);
        }
        n = true;
        f28678a = i2;
        sp = str;
        x = new WeakReference<>(activity);
        i.clear();
        ttVarC.uj.size();
    }

    @MainThread
    private static c ve(Activity activity, String str) {
        WeakHashMap<Activity, c> weakHashMap = i;
        c cVar = weakHashMap.get(activity);
        if (cVar == null) {
            c cVar2 = new c(str);
            weakHashMap.put(activity, cVar2);
            return cVar2;
        }
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        cVar.c = str;
        return cVar;
    }

    @MainThread
    public static String tt() {
        if (!TextUtils.isEmpty(uj)) {
            return uj;
        }
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        if (veVarC == null) {
            return "";
        }
        String str = veVarC.get("mc_c_name", "");
        long j = veVarC.get("mc_c_name_cache_time", 0L);
        if (!TextUtils.isEmpty(str) && System.currentTimeMillis() - j > 604800000) {
            veVarC.put("mc_c_name", "");
            veVarC.put("mc_c_name_cache_time", 0L);
            return "";
        }
        uj = str;
        return str;
    }

    @MainThread
    private static void tt(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        uj = str;
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        if (veVarC != null) {
            veVarC.put("mc_c_name", str);
            veVarC.put("mc_c_name_cache_time", System.currentTimeMillis());
        }
    }

    private static boolean tt(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            Map<String, Boolean> map = t;
            Boolean bool = map.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
            if (veVarC == null) {
                return false;
            }
            try {
                if (!veVarC.get("no_tab_arch_".concat(String.valueOf(str)), false)) {
                    map.put(str, Boolean.FALSE);
                    return false;
                }
                long j = veVarC.get("no_tab_app_version_".concat(String.valueOf(str)), -1L);
                long jU = u(activity);
                if (jU > 0 && j > 0 && j != jU) {
                    ve(str);
                    return false;
                }
                map.put(str, Boolean.TRUE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
