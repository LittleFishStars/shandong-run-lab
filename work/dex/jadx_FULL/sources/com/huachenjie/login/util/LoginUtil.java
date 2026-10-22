package com.huachenjie.login.util;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebStorage;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.service.AdConfigIntentService;
import com.huachenjie.common.service.CustomerServiceIntentService;
import com.huachenjie.common.service.RunConfigIntentService;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.page.info.nickname.FillNicknameActivity;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.lo7;
import com.zj.adlib.t14;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/login/util/LoginUtil;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "viewModel", "Lcom/huachenjie/login/bean/LoginResultData;", "result", "", "b", "c", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class LoginUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LoginUtil f34754a = new LoginUtil();

    public final void b(@NotNull Context context, @NotNull BaseViewModel viewModel, @NotNull LoginResultData result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(result, "result");
        lo7.e().g().n().a = result.getToken();
        lo7.e().g().n().b = result.getSatoken();
        if (!ai9.o(result.getUserType())) {
            BaseViewModelExtKt.b(viewModel, true, false, null, null, new LoginUtil$dealLogin$1(result, context, null), 14, null);
        } else {
            ai9.s(new CommonUserInfo(result.getUserId(), result.getUserType(), result.getToken(), result.getSatoken()));
            c(context, result);
        }
    }

    public final void c(Context context, LoginResultData result) {
        WebStorage.getInstance().deleteAllData();
        if (ai9.o(result.getUserType())) {
            FillNicknameActivity.INSTANCE.startActivity(context, result, true);
            ActivityLifecycleManager.l().f(VerifyCodeActivity.class);
            return;
        }
        RunConfigIntentService.INSTANCE.a(context, new Intent());
        AdConfigIntentService.INSTANCE.a(context, new Intent());
        CustomerServiceIntentService.INSTANCE.a(context, new Intent());
        t14.e(context, result.getAlertTip(), false, 0, 12, null);
        ActivityLifecycleManager.l().m().finishAffinity();
    }
}
