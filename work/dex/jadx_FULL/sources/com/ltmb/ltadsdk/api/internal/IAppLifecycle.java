package com.ltmb.ltadsdk.api.internal;

import android.app.Activity;
import android.content.Intent;
import com.byazt.hv.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IAppLifecycle;", "", "", "count", "", "onAppForeground", "", "duration", "onAppBackground", "Landroid/content/Intent;", "intent", "onMiniProgramResp", "onAdLPageStarted", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "onActivityStarted", "onActivityDestroyed", "Wrapper", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface IAppLifecycle {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IAppLifecycle$Wrapper;", "Lcom/ltmb/ltadsdk/api/internal/IAppLifecycle;", "", "count", "", "onAppForeground", "", "duration", "onAppBackground", "Landroid/content/Intent;", "intent", "onMiniProgramResp", "onAdLPageStarted", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "onActivityStarted", "onActivityDestroyed", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static abstract class Wrapper implements IAppLifecycle {
        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        }

        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onAdLPageStarted() {
        }

        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onAppBackground(int count, long duration) {
        }

        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onAppForeground(int count) {
        }

        @Override // com.ltmb.ltadsdk.api.internal.IAppLifecycle
        public void onMiniProgramResp(@Nullable Intent intent) {
        }
    }

    void onActivityDestroyed(@NotNull Activity activity);

    void onActivityStarted(@NotNull Activity activity);

    void onAdLPageStarted();

    void onAppBackground(int count, long duration);

    void onAppForeground(int count);

    void onMiniProgramResp(@Nullable Intent intent);
}
