package com.huachenjie.login.util;

import android.app.Dialog;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.RemainTimesData;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.enums.VerifyCodeType;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&Jl\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n28\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fJx\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000628\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fH\u0002J|\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u000628\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fH\u0002J\u0084\u0001\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u000628\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fH\u0002Jr\u0010 \u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n28\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/huachenjie/login/util/SendVerifyCodeUtil;", "", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "viewModel", "", AliyunLogCommon.TERMINAL_TYPE, "Lcom/huachenjie/login/enums/VerifyCodeType;", "verifyCodeType", "", VerifyCodeActivity.x, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/huachenjie/login/bean/VerifyCodeParams;", "data", "", "onSendFinish", "j", "captchaPoint", "e", "Landroid/app/Dialog;", "dialog", y6b.f, "Lcom/huachenjie/login/bean/RemainTimesData;", "remainTimesData", "i", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", c.f25231a, y6b.g, "", "a", "Ljava/util/Map;", "phoneRemainTimes", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SendVerifyCodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SendVerifyCodeUtil f34757a = new SendVerifyCodeUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Map<String, VerifyCodeParams> phoneRemainTimes = new LinkedHashMap();

    public static /* synthetic */ void k(SendVerifyCodeUtil sendVerifyCodeUtil, FragmentActivity fragmentActivity, BaseViewModel baseViewModel, String str, VerifyCodeType verifyCodeType, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            verifyCodeType = VerifyCodeType.SMS;
        }
        VerifyCodeType verifyCodeType2 = verifyCodeType;
        if ((i2 & 16) != 0) {
            i = LoginThirdType.None.getType();
        }
        sendVerifyCodeUtil.j(fragmentActivity, baseViewModel, str, verifyCodeType2, i, function2);
    }

    public final void e(FragmentActivity activity, BaseViewModel viewModel, String phone, VerifyCodeType verifyCodeType, int loginThirdType, String captchaPoint, Function2<? super Boolean, ? super VerifyCodeParams, Unit> onSendFinish) {
        Dialog dialogM = DialogUtil.m(activity);
        dialogM.show();
        VerifyCodeParams verifyCodeParams = phoneRemainTimes.get(phone);
        if (verifyCodeParams == null || verifyCodeType.getValue() != verifyCodeParams.getLastSendType() || System.currentTimeMillis() - verifyCodeParams.getLastSendTime() >= 60000) {
            Intrinsics.checkNotNullExpressionValue(dialogM, "dialog");
            g(activity, viewModel, phone, verifyCodeType, loginThirdType, dialogM, captchaPoint, onSendFinish);
        } else {
            dialogM.dismiss();
            onSendFinish.invoke(Boolean.TRUE, verifyCodeParams);
        }
    }

    public final void g(FragmentActivity activity, BaseViewModel viewModel, String phone, VerifyCodeType verifyCodeType, int loginThirdType, final Dialog dialog, String captchaPoint, final Function2<? super Boolean, ? super VerifyCodeParams, Unit> onSendFinish) {
        BaseViewModelExtKt.b(viewModel, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.util.SendVerifyCodeUtil$checkVerifyTimes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                dialog.dismiss();
                Function2<Boolean, VerifyCodeParams, Unit> function2 = onSendFinish;
                Boolean bool = Boolean.FALSE;
                function2.invoke(bool, (Object) null);
                return bool;
            }
        }, null, new SendVerifyCodeUtil$checkVerifyTimes$2(phone, verifyCodeType, dialog, activity, onSendFinish, viewModel, loginThirdType, captchaPoint, null), 10, null);
    }

    public final void h(final FragmentActivity activity, final BaseViewModel viewModel, final String phone, final VerifyCodeType verifyCodeType, final int loginThirdType, final Function2<? super Boolean, ? super VerifyCodeParams, Unit> onSendFinish, ResultException exception) {
        if (exception.getCode() == 1600) {
            CaptchaDialog.Companion aVar = CaptchaDialog.INSTANCE;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            aVar.a(supportFragmentManager, new Function1<String, Unit>() { // from class: com.huachenjie.login.util.SendVerifyCodeUtil$dealSendFail$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    SendVerifyCodeUtil sendVerifyCodeUtil = SendVerifyCodeUtil.f34757a;
                    FragmentActivity fragmentActivity = activity;
                    BaseViewModel baseViewModel = viewModel;
                    String str2 = phone;
                    VerifyCodeType verifyCodeType2 = verifyCodeType;
                    int i = loginThirdType;
                    Intrinsics.checkNotNull(str);
                    sendVerifyCodeUtil.e(fragmentActivity, baseViewModel, str2, verifyCodeType2, i, str, onSendFinish);
                }
            });
        }
        if (TextUtils.isEmpty(exception.getMessage())) {
            fv5.b("验证码获取次数超出限制");
            return;
        }
        int code = exception.getCode();
        if (code == 1514) {
            VerifyCodeParams verifyCodeParams = phoneRemainTimes.get(phone);
            if (verifyCodeParams != null) {
                verifyCodeParams.setSmsLoginRemainTimes(0);
            }
            fv5.b(exception.getMessage());
            return;
        }
        if (code == 1526) {
            VerifyCodeParams verifyCodeParams2 = phoneRemainTimes.get(phone);
            if (verifyCodeParams2 != null) {
                verifyCodeParams2.setCallLoginRemainTimes(0);
            }
            fv5.b(exception.getMessage());
            return;
        }
        switch (code) {
            case 1530:
            case 1531:
            case 1534:
            case 1535:
                ft1.z(activity, exception.getMessage(), "我知道了");
                break;
            case UserConstants.LOGIN_ERROR.f33729a /* 1532 */:
            case UserConstants.LOGIN_ERROR.b /* 1533 */:
                ft1.B(activity, activity.getString(R.string.login_too_much_device_title), exception.getMessage(), "我知道了");
                break;
            case 1536:
            case UserConstants.LOGIN_ERROR.d /* 1537 */:
                ft1.B(activity, activity.getString(R.string.login_too_much_account_login_title), exception.getMessage(), "我知道了");
                break;
            default:
                fv5.b(exception.getMessage());
                break;
        }
    }

    public final void i(final FragmentActivity activity, final BaseViewModel viewModel, final String phone, final VerifyCodeType verifyCodeType, final int loginThirdType, RemainTimesData remainTimesData, final Dialog dialog, String captchaPoint, final Function2<? super Boolean, ? super VerifyCodeParams, Unit> onSendFinish) {
        BaseViewModelExtKt.b(viewModel, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.util.SendVerifyCodeUtil$sendAuthCode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                dialog.dismiss();
                SendVerifyCodeUtil.f34757a.h(activity, viewModel, phone, verifyCodeType, loginThirdType, onSendFinish, resultException);
                onSendFinish.invoke(Boolean.FALSE, (Object) null);
                return Boolean.TRUE;
            }
        }, null, new SendVerifyCodeUtil$sendAuthCode$2(loginThirdType, phone, verifyCodeType, captchaPoint, remainTimesData, dialog, onSendFinish, null), 10, null);
    }

    public final void j(@NotNull FragmentActivity activity, @NotNull BaseViewModel viewModel, @NotNull String phone, @NotNull VerifyCodeType verifyCodeType, int loginThirdType, @NotNull Function2<? super Boolean, ? super VerifyCodeParams, Unit> onSendFinish) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(verifyCodeType, "verifyCodeType");
        Intrinsics.checkNotNullParameter(onSendFinish, "onSendFinish");
        e(activity, viewModel, phone, verifyCodeType, loginThirdType, null, onSendFinish);
    }
}
