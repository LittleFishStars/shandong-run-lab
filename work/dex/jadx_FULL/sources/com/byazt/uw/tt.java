package com.byazt.uw;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.ou.i;
import com.byazt.ou.rl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1715, 13})
public class tt implements i {
    public rl c;

    @Override // com.byazt.ou.i
    public void c(@NonNull Activity activity, @NonNull String[] strArr, rl rlVar) {
        this.c = rlVar;
        activity.requestPermissions(strArr, 1);
    }

    @Override // com.byazt.ou.i
    public boolean c(@Nullable Context context, @NonNull String str) {
        return (context == null || str == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }

    @Override // com.byazt.ou.i
    public void c(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        rl rlVar;
        if (iArr.length <= 0 || (rlVar = this.c) == null) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == -1) {
            rlVar.c(strArr[0]);
        } else if (i2 == 0) {
            rlVar.c();
        }
    }
}
