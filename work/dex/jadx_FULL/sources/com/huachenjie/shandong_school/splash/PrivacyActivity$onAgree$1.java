package com.huachenjie.shandong_school.splash;

import android.content.Intent;
import android.os.Handler;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.service.AdConfigIntentService;
import com.huachenjie.common.service.CustomerServiceIntentService;
import com.huachenjie.common.service.RunConfigIntentService;
import com.huachenjie.login.page.info.nickname.FillNicknameActivity;
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.huachenjie.shandong_school.service.CommonConfigIntentService;
import com.huachenjie.shandong_school.service.SyncTimeIntentService;
import com.zj.adlib.ai9;
import com.zj.adlib.t14;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PrivacyActivity$onAgree$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ PrivacyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyActivity$onAgree$1(PrivacyActivity privacyActivity) {
        super(0);
        this.this$0 = privacyActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(PrivacyActivity privacyActivity) {
        Intrinsics.checkNotNullParameter(privacyActivity, "this$0");
        if (!privacyActivity.isFinishing() && privacyActivity.getMLoadingDialog().isShowing()) {
            privacyActivity.getMLoadingDialog().dismiss();
        }
        CommonConfigIntentService.INSTANCE.a(privacyActivity, new Intent());
        SyncTimeIntentService.INSTANCE.a(privacyActivity, new Intent());
        if (!ai9.l()) {
            privacyActivity.startActivity(new Intent(privacyActivity, (Class<?>) WelcomeLoginActivity.class));
            privacyActivity.finish();
        } else if (ai9.n()) {
            FillNicknameActivity.Companion.a(FillNicknameActivity.INSTANCE, privacyActivity, null, false, 6, null);
            privacyActivity.finish();
        } else {
            RunConfigIntentService.INSTANCE.a(privacyActivity, new Intent());
            AdConfigIntentService.INSTANCE.a(privacyActivity, new Intent());
            CustomerServiceIntentService.INSTANCE.a(privacyActivity, new Intent());
            t14.e(privacyActivity, null, true, 0, 10, null);
        }
    }

    @NotNull
    public final Object invoke() {
        Handler handlerC0 = this.this$0.c0();
        final PrivacyActivity privacyActivity = this.this$0;
        return Boolean.valueOf(handlerC0.post(new Runnable() { // from class: com.huachenjie.shandong_school.splash.a
            @Override // java.lang.Runnable
            public final void run() {
                PrivacyActivity$onAgree$1.invoke$lambda$0(privacyActivity);
            }
        }));
    }
}
