package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f37495a;
    private final int b;
    private final Intent c;

    public DialogRedirectImpl(Intent intent, Activity activity, int i) {
        this.c = intent;
        this.f37495a = activity;
        this.b = i;
    }

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Activity activity;
        Intent intent = this.c;
        if (intent == null || (activity = this.f37495a) == null) {
            return;
        }
        activity.startActivityForResult(intent, this.b);
    }
}
