package com.zj.adlib;

import android.content.Context;
import com.huachenjie.base.module_bridge.interfaces.CollegeMethodLoader;
import com.huachenjie.college.page.lightningPlay.LightningPlayActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/zj/adlib/mn1;", "Lcom/huachenjie/base/module_bridge/interfaces/CollegeMethodLoader;", "Landroid/content/Context;", "context", "", "url", "", "a", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class mn1 implements CollegeMethodLoader {
    @Override // com.huachenjie.base.module_bridge.interfaces.CollegeMethodLoader
    public void a(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        LightningPlayActivity.INSTANCE.a(context, url);
    }
}
