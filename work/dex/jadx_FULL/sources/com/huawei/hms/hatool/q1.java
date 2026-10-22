package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.UserManager;
import com.huachenjie.base.util.rich_text.RichTextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class q1 {
    private static q1 c = new q1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f37582a = false;
    private Context b = q0.i();

    private q1() {
    }

    public static q1 b() {
        return c;
    }

    @TargetApi(24)
    public boolean a() {
        if (!this.f37582a) {
            Context context = this.b;
            if (context == null) {
                return false;
            }
            UserManager userManager = (UserManager) context.getSystemService(RichTextUtils.b);
            if (userManager != null) {
                this.f37582a = userManager.isUserUnlocked();
            } else {
                this.f37582a = false;
            }
        }
        return this.f37582a;
    }
}
