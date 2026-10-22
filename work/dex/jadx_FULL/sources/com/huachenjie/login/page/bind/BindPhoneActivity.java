package com.huachenjie.login.page.bind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.databinding.LoginActivityBindPhoneBinding;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.huachenjie.login.util.SendVerifyCodeUtil;
import com.zj.adlib.fv5;
import com.zj.adlib.o38;
import com.zj.adlib.zk0;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\b\n*\u0001\u0019\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002! B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016R\u001b\u0010\r\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/huachenjie/login/page/bind/BindPhoneActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityBindPhoneBinding;", "Lcom/huachenjie/login/page/bind/BindPhoneVM;", "", "", "", "V", "getLayoutResID", "b", "Lkotlin/Lazy;", "g0", "()I", VerifyCodeActivity.x, "", "c", "h0", "()Ljava/lang/String;", "schoolCode", "d", "i0", "studentNumber", "e", "e0", "bindKey", "com/huachenjie/login/page/bind/BindPhoneActivity$finishBroadcast$2$1", "f", "f0", "()Lcom/huachenjie/login/page/bind/BindPhoneActivity$finishBroadcast$2$1;", "finishBroadcast", "<init>", "()V", "a", "ClickProxy", "login_release"}, k = 1, mv = {1, 8, 0})
public final class BindPhoneActivity extends BaseMVVMActivity<LoginActivityBindPhoneBinding, BindPhoneVM> {

    @NotNull
    public static final String A = "bindKey";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "third_type";

    @NotNull
    public static final String x = "third_key";

    @NotNull
    public static final String y = "schoolCode";

    @NotNull
    public static final String z = "studentNumber";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy loginThirdType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$loginThirdType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m445invoke() {
            Bundle extras = this.this$0.getIntent().getExtras();
            Serializable serializable = extras != null ? extras.getSerializable(BindPhoneActivity.t) : null;
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.huachenjie.login.enums.LoginThirdType");
            return Integer.valueOf(((LoginThirdType) serializable).getType());
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy schoolCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$schoolCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra("schoolCode");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy studentNumber = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$studentNumber$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra("studentNumber");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy bindKey = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$bindKey$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return intent.getStringExtra("bindKey");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy finishBroadcast = LazyKt.lazy(new Function0<BindPhoneActivity$finishBroadcast$2.AnonymousClass1>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$finishBroadcast$2
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.login.page.bind.BindPhoneActivity$finishBroadcast$2$1] */
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnonymousClass1 m444invoke() {
            final BindPhoneActivity bindPhoneActivity = this.this$0;
            return new BroadcastReceiver() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$finishBroadcast$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    bindPhoneActivity.finish();
                }
            };
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/login/page/bind/BindPhoneActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/login/page/bind/BindPhoneActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Run.o).navigation();
        }

        public final void b(@NotNull final View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            String value = BindPhoneActivity.b0(BindPhoneActivity.this).i().getValue();
            if (!o38.a(value)) {
                fv5.a(R.string.phone_valid_error);
                return;
            }
            final Bundle extras = BindPhoneActivity.this.getIntent().getExtras();
            if (extras != null) {
                final BindPhoneActivity bindPhoneActivity = BindPhoneActivity.this;
                SendVerifyCodeUtil sendVerifyCodeUtil = SendVerifyCodeUtil.f34757a;
                BindPhoneVM bindPhoneVMB0 = BindPhoneActivity.b0(bindPhoneActivity);
                Intrinsics.checkNotNull(value);
                SendVerifyCodeUtil.k(sendVerifyCodeUtil, bindPhoneActivity, bindPhoneVMB0, value, null, bindPhoneActivity.g0(), new Function2<Boolean, VerifyCodeParams, Unit>() { // from class: com.huachenjie.login.page.bind.BindPhoneActivity$ClickProxy$onNext$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Boolean) obj).booleanValue(), (VerifyCodeParams) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z, @Nullable VerifyCodeParams verifyCodeParams) {
                        if (!z || verifyCodeParams == null) {
                            return;
                        }
                        View view = v;
                        Bundle bundle = extras;
                        BindPhoneActivity bindPhoneActivity2 = bindPhoneActivity;
                        VerifyCodeActivity.Companion companion = VerifyCodeActivity.INSTANCE;
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "v.context");
                        Serializable serializable = bundle.getSerializable(BindPhoneActivity.t);
                        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.huachenjie.login.enums.LoginThirdType");
                        LoginThirdType loginThirdType = (LoginThirdType) serializable;
                        String string = bundle.getString(BindPhoneActivity.x, "");
                        Intrinsics.checkNotNullExpressionValue(string, "getString(THIRD_KEY_KEY, \"\")");
                        String strH0 = bindPhoneActivity2.h0();
                        String str = strH0 == null ? "" : strH0;
                        Intrinsics.checkNotNullExpressionValue(str, "schoolCode ?: \"\"");
                        String strI0 = bindPhoneActivity2.i0();
                        String str2 = strI0 == null ? "" : strI0;
                        Intrinsics.checkNotNullExpressionValue(str2, "studentNumber ?: \"\"");
                        String strE0 = bindPhoneActivity2.e0();
                        String str3 = strE0 == null ? "" : strE0;
                        Intrinsics.checkNotNullExpressionValue(str3, "bindKey ?: \"\"");
                        companion.a(context, verifyCodeParams, loginThirdType, string, str, str2, str3);
                    }
                }, 8, null);
            }
        }
    }

    public static final /* synthetic */ BindPhoneVM b0(BindPhoneActivity bindPhoneActivity) {
        return bindPhoneActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new ClickProxy())});
    }

    public final String e0() {
        return (String) this.bindKey.getValue();
    }

    public final BindPhoneActivity$finishBroadcast$2.AnonymousClass1 f0() {
        return (BindPhoneActivity$finishBroadcast$2.AnonymousClass1) this.finishBroadcast.getValue();
    }

    public final int g0() {
        return ((Number) this.loginThirdType.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_bind_phone;
    }

    public final String h0() {
        return (String) this.schoolCode.getValue();
    }

    public final String i0() {
        return (String) this.studentNumber.getValue();
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.bind.BindPhoneActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/login/page/bind/BindPhoneActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/login/enums/LoginThirdType;", "thirdType", "", VerifyCodeActivity.y, "", PerfId.startActivity, "schoolCode", "studentNumber", "bindKey", "BIND_KEY", "Ljava/lang/String;", "SCHOOL_CODE", "STUDENT_NUMBER", "THIRD_KEY_KEY", "THIRD_TYPE_KEY", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull LoginThirdType thirdType, @NotNull String thirdKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(thirdType, "thirdType");
            Intrinsics.checkNotNullParameter(thirdKey, VerifyCodeActivity.y);
            Intent intent = new Intent(context, (Class<?>) BindPhoneActivity.class);
            intent.putExtra(BindPhoneActivity.t, thirdType);
            intent.putExtra(BindPhoneActivity.x, thirdKey);
            context.startActivity(intent);
        }

        public final void startActivity(@NotNull Context context, @NotNull String schoolCode, @NotNull String studentNumber, @NotNull String bindKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
            Intrinsics.checkNotNullParameter(studentNumber, "studentNumber");
            Intrinsics.checkNotNullParameter(bindKey, "bindKey");
            Intent intent = new Intent(context, (Class<?>) BindPhoneActivity.class);
            intent.putExtra(BindPhoneActivity.t, LoginThirdType.School);
            intent.putExtra("schoolCode", schoolCode);
            intent.putExtra("studentNumber", studentNumber);
            intent.putExtra("bindKey", bindKey);
            context.startActivity(intent);
        }
    }
}
