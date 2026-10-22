package com.gyf.immersionbar;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NavigationBarType f32549a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6812a = false;
        public boolean b = false;

        public String toString() {
            return "GestureBean{isGesture=" + this.f6812a + ", checkNavigation=" + this.b + ", type=" + this.f32549a + '}';
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[PHI: r1 r2
      0x0079: PHI (r1v15 com.gyf.immersionbar.NavigationBarType) = (r1v13 com.gyf.immersionbar.NavigationBarType), (r1v26 com.gyf.immersionbar.NavigationBarType) binds: [B:66:0x00d2, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r2v14 int) = (r2v13 int), (r2v27 int) binds: [B:66:0x00d2, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x00ef A[PHI: r1 r2
      0x00ef: PHI (r1v4 com.gyf.immersionbar.NavigationBarType) = 
      (r1v2 com.gyf.immersionbar.NavigationBarType)
      (r1v13 com.gyf.immersionbar.NavigationBarType)
      (r1v16 com.gyf.immersionbar.NavigationBarType)
      (r1v17 com.gyf.immersionbar.NavigationBarType)
      (r1v19 com.gyf.immersionbar.NavigationBarType)
      (r1v21 com.gyf.immersionbar.NavigationBarType)
      (r1v26 com.gyf.immersionbar.NavigationBarType)
     binds: [B:75:0x00ed, B:66:0x00d2, B:60:0x00ba, B:58:0x00b5, B:53:0x00a5, B:44:0x008a, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x00ef: PHI (r2v5 int) = (r2v3 int), (r2v13 int), (r2v18 int), (r2v18 int), (r2v22 int), (r2v29 int), (r2v27 int) binds: [B:75:0x00ed, B:66:0x00d2, B:60:0x00ba, B:58:0x00b5, B:53:0x00a5, B:44:0x008a, B:38:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x010d  */
    public static a a(Context context) {
        int i;
        boolean z;
        boolean z2;
        a aVar = new a();
        if (context != null && context.getContentResolver() != null) {
            ContentResolver contentResolver = context.getContentResolver();
            NavigationBarType navigationBarType = NavigationBarType.UNKNOWN;
            boolean z3 = false;
            boolean z4 = true;
            if (OSUtils.isHuaWei() || OSUtils.isEMUI()) {
                i = !OSUtils.isEMUI3_x() ? Settings.Global.getInt(contentResolver, b.f6808g, -1) : Settings.System.getInt(contentResolver, b.f6808g, -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isXiaoMi() || OSUtils.isMIUI()) {
                i = Settings.Global.getInt(contentResolver, b.f6806e, -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1) {
                    navigationBarType = NavigationBarType.GESTURES;
                    if (Settings.Global.getInt(contentResolver, b.f6807f, -1) != 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isVivo() || OSUtils.isFuntouchOrOriginOs()) {
                i = Settings.Secure.getInt(contentResolver, b.f6809h, -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else {
                    if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES_THREE_STAGE;
                    } else if (i == 2) {
                        navigationBarType = NavigationBarType.GESTURES;
                    }
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isOppo() || OSUtils.isColorOs()) {
                i = Settings.Secure.getInt(contentResolver, b.i, -1);
                if (i == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i == 1 || i == 2 || i == 3) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z = false;
                    z2 = true;
                }
                z = false;
                z2 = false;
            } else if (OSUtils.isSamsung()) {
                i = Settings.Global.getInt(contentResolver, b.j, -1);
                if (i != -1) {
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = Settings.Global.getInt(contentResolver, b.k, 1) == 1 ? NavigationBarType.GESTURES : NavigationBarType.GESTURES_THREE_STAGE;
                        if (Settings.Global.getInt(contentResolver, b.l, 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                } else {
                    i = Settings.Global.getInt(contentResolver, b.m, -1);
                    if (i == 0) {
                        navigationBarType = NavigationBarType.CLASSIC;
                    } else if (i == 1) {
                        navigationBarType = NavigationBarType.GESTURES;
                        z = false;
                        z2 = true;
                    }
                    z = false;
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
                i = -1;
            }
            if (i != -1) {
                z4 = z;
                z3 = z2;
            } else {
                int i2 = Settings.Secure.getInt(contentResolver, b.n, -1);
                if (i2 == 0) {
                    navigationBarType = NavigationBarType.CLASSIC;
                } else if (i2 == 1) {
                    navigationBarType = NavigationBarType.DOUBLE;
                } else if (i2 == 2) {
                    navigationBarType = NavigationBarType.GESTURES;
                    z3 = true;
                } else {
                    z4 = z;
                    z3 = z2;
                }
                z4 = z;
            }
            aVar.f6812a = z3;
            aVar.b = z4;
            aVar.f32549a = navigationBarType;
        }
        return aVar;
    }
}
