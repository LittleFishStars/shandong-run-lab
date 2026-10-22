package com.zj.adlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.Postcard;
import com.byazt.hv.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/qx6;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroid/os/Bundle;", "savedInstanceState", "", "d", "c", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "a", "Landroid/content/Intent;", "intent", "b", "", "Ljava/lang/String;", "KEY_VERIFY", "verifyParams", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class qx6 {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String KEY_VERIFY = "verify_jump_key";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final qx6 f44321a = new qx6();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static String verifyParams = "";

    @JvmStatic
    public static final void d(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        if (savedInstanceState == null && !Intrinsics.areEqual(verifyParams, activity.getIntent().getStringExtra(KEY_VERIFY))) {
            activity.finish();
        }
    }

    public final void a(@Nullable Postcard postcard) {
        Bundle extras;
        if (postcard == null || (extras = postcard.getExtras()) == null) {
            return;
        }
        extras.putString(KEY_VERIFY, verifyParams);
    }

    public final void b(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(KEY_VERIFY, verifyParams);
    }

    public final void c() {
        verifyParams = String.valueOf(System.currentTimeMillis());
    }
}
