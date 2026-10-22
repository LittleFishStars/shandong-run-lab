package cn.hzjizhun.admin.util;

import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PermissionUtil {
    public static boolean check(Context context, String... strArr) {
        for (String str : strArr) {
            if (context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
                return false;
            }
        }
        return true;
    }
}
