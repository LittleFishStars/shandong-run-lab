package com.huachenjie.college.page.hw_health;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class HWHealthActivity$sportDetailLauncher$2 extends Lambda implements Function0<ActivityResultLauncher<Intent>> {
    final /* synthetic */ HWHealthActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWHealthActivity$sportDetailLauncher$2(HWHealthActivity hWHealthActivity) {
        super(0);
        this.this$0 = hWHealthActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(HWHealthActivity hWHealthActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(hWHealthActivity, "this$0");
        if (activityResult.getResultCode() != -1) {
            return;
        }
        Intent data = activityResult.getData();
        HWHealthSportDetailActivity.Companion companion = HWHealthSportDetailActivity.INSTANCE;
        if (companion.c(data)) {
            hWHealthActivity.m0(companion.b(data));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ActivityResultLauncher<Intent> m331invoke() {
        HWHealthActivity hWHealthActivity = this.this$0;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        final HWHealthActivity hWHealthActivity2 = this.this$0;
        return hWHealthActivity.registerForActivityResult(startActivityForResult, new ActivityResultCallback() { // from class: com.huachenjie.college.page.hw_health.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HWHealthActivity$sportDetailLauncher$2.invoke$lambda$0(hWHealthActivity2, (ActivityResult) obj);
            }
        });
    }
}
