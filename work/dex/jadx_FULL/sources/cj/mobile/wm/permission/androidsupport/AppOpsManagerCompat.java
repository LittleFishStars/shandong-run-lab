package cj.mobile.wm.permission.androidsupport;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class AppOpsManagerCompat {
    public static final AppOpsManagerImpl IMPL = new AppOpsManager23();
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_IGNORED = 1;

    public static class AppOpsManager23 extends AppOpsManagerImpl {
        @Override // cj.mobile.wm.permission.androidsupport.AppOpsManagerCompat.AppOpsManagerImpl
        public int noteOp(Context context, String str, int i, String str2) {
            return AppOpsManagerCompat23.noteOp(context, str, i, str2);
        }

        @Override // cj.mobile.wm.permission.androidsupport.AppOpsManagerCompat.AppOpsManagerImpl
        public int noteProxyOp(Context context, String str, String str2) {
            return AppOpsManagerCompat23.noteProxyOp(context, str, str2);
        }

        @Override // cj.mobile.wm.permission.androidsupport.AppOpsManagerCompat.AppOpsManagerImpl
        public String permissionToOp(String str) {
            return AppOpsManagerCompat23.permissionToOp(str);
        }
    }

    public static class AppOpsManagerImpl {
        public int noteOp(Context context, String str, int i, String str2) {
            return 1;
        }

        public int noteProxyOp(Context context, String str, String str2) {
            return 1;
        }

        public String permissionToOp(String str) {
            return null;
        }
    }

    public static int noteOp(Context context, String str, int i, String str2) {
        return IMPL.noteOp(context, str, i, str2);
    }

    public static int noteProxyOp(Context context, String str, String str2) {
        return IMPL.noteProxyOp(context, str, str2);
    }

    public static String permissionToOp(String str) {
        return IMPL.permissionToOp(str);
    }
}
