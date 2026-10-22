package com.huachenjie.login.page.verify_code;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.view.VerifyCodeEditText;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.bean.VerifyCodeParams;
import com.huachenjie.login.databinding.LoginActivityVerifyCodeBinding;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.enums.VerifyCodeType;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.huachenjie.login.util.CountDownTimerHelper;
import com.huachenjie.login.util.LoginUtil;
import com.huachenjie.login.util.SendVerifyCodeUtil;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fm8;
import com.zj.adlib.ft1;
import com.zj.adlib.qa4;
import com.zj.adlib.y6b;
import com.zj.adlib.zk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0002/4\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002;\u0010B\u0007¢\u0006\u0004\b9\u0010:J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\"\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010!R\u001b\u0010(\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010!R\u001b\u0010+\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010!R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0017\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityVerifyCodeBinding;", "Lcom/huachenjie/login/page/verify_code/VerifyCodeVM;", "", "", "", "V", "getLayoutResID", "", "initData", "initView", "W", "onDestroy", "r0", "", "a", "J", "mTotalCountdown", "d", "mCountdownInterval", "Lcom/huachenjie/login/bean/VerifyCodeParams;", "b", "Lkotlin/Lazy;", bo.g, "()Lcom/huachenjie/login/bean/VerifyCodeParams;", VerifyCodeActivity.t, "c", "k0", "()I", VerifyCodeActivity.x, "", "o0", "()Ljava/lang/String;", VerifyCodeActivity.y, "e", "l0", "schoolCode", "f", "n0", "studentNumber", y6b.f, "j0", "bindKey", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "com/huachenjie/login/page/verify_code/VerifyCodeActivity$smsCountDown$2$a", y6b.g, "m0", "()Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity$smsCountDown$2$a;", "smsCountDown", "com/huachenjie/login/page/verify_code/VerifyCodeActivity$voiceCountDown$2$a", "i", "q0", "()Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity$voiceCountDown$2$a;", "voiceCountDown", "<init>", "()V", "ClickProxy", "login_release"}, k = 1, mv = {1, 8, 0})
public final class VerifyCodeActivity extends BaseMVVMActivity<LoginActivityVerifyCodeBinding, VerifyCodeVM> {

    @NotNull
    public static final String A = "studentNumber";

    @NotNull
    public static final String B = "bindKey";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "verifyCodeParams";

    @NotNull
    public static final String x = "loginThirdType";

    @NotNull
    public static final String y = "thirdKey";

    @NotNull
    public static final String z = "schoolCode";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long mTotalCountdown = 60000;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long mCountdownInterval = 1000;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy verifyCodeParams = LazyKt.lazy(new Function0<VerifyCodeParams>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$verifyCodeParams$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final VerifyCodeParams m460invoke() {
            Intent intent = this.this$0.getIntent();
            VerifyCodeParams verifyCodeParams = intent != null ? (VerifyCodeParams) intent.getParcelableExtra(VerifyCodeActivity.t) : null;
            return verifyCodeParams == null ? new VerifyCodeParams(0, 0, 0L, null, 0, 0, null, 127, null) : verifyCodeParams;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy loginThirdType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$loginThirdType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m455invoke() {
            Intent intent = this.this$0.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra(VerifyCodeActivity.x, 0) : 0);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy thirdKey = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$thirdKey$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(VerifyCodeActivity.y)) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy schoolCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$schoolCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("schoolCode")) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy studentNumber = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$studentNumber$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("studentNumber")) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy bindKey = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$bindKey$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("bindKey")) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy smsCountDown = LazyKt.lazy(new Function0<VerifyCodeActivity$smsCountDown$2.a>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$smsCountDown$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/login/page/verify_code/VerifyCodeActivity$smsCountDown$2$a", "Lcom/huachenjie/login/util/CountDownTimerHelper;", "", "millisUntilFinished", "", y6b.f, "f", "login_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends CountDownTimerHelper {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VerifyCodeActivity f34747a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(VerifyCodeActivity verifyCodeActivity, Handler handler) {
                super(handler);
                this.f34747a = verifyCodeActivity;
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void f() {
                VerifyCodeActivity.f0(this.f34747a).p().setValue(this.f34747a.getString(R.string.login_request_verify_code));
                VerifyCodeActivity.f0(this.f34747a).o().setValue(Boolean.TRUE);
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void g(long millisUntilFinished) {
                VerifyCodeActivity.f0(this.f34747a).p().setValue(this.f34747a.getString(R.string.login_verify_code_cool_down, Long.valueOf(millisUntilFinished / ((long) 1000))));
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final a m457invoke() {
            return new a(this.this$0, this.this$0.handler);
        }
    });

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final Lazy voiceCountDown = LazyKt.lazy(new Function0<VerifyCodeActivity$voiceCountDown$2.a>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$voiceCountDown$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/login/page/verify_code/VerifyCodeActivity$voiceCountDown$2$a", "Lcom/huachenjie/login/util/CountDownTimerHelper;", "", "millisUntilFinished", "", y6b.f, "f", "login_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends CountDownTimerHelper {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VerifyCodeActivity f34748a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(VerifyCodeActivity verifyCodeActivity, Handler handler) {
                super(handler);
                this.f34748a = verifyCodeActivity;
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void f() {
                VerifyCodeActivity.f0(this.f34748a).r().setValue(this.f34748a.getString(R.string.login_request_voice_code_again));
                VerifyCodeActivity.f0(this.f34748a).q().setValue(Boolean.TRUE);
            }

            @Override // com.huachenjie.login.util.CountDownTimerHelper
            public void g(long millisUntilFinished) {
                VerifyCodeActivity.f0(this.f34748a).r().setValue(this.f34748a.getString(R.string.login_voice_code_cool_down, Long.valueOf(millisUntilFinished / ((long) 1000))));
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final a m461invoke() {
            return new a(this.this$0, this.this$0.handler);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "c", "d", "<init>", "(Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public static final void e(final VerifyCodeActivity verifyCodeActivity, View view) {
            Intrinsics.checkNotNullParameter(verifyCodeActivity, "this$0");
            VerifyCodeActivity.f0(verifyCodeActivity).q().setValue(Boolean.FALSE);
            SendVerifyCodeUtil.f34757a.j(verifyCodeActivity, VerifyCodeActivity.f0(verifyCodeActivity), verifyCodeActivity.p0().getPhone(), VerifyCodeType.VOICE, verifyCodeActivity.k0(), new Function2<Boolean, VerifyCodeParams, Unit>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$ClickProxy$clickVoiceCode$1$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), (VerifyCodeParams) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, @Nullable VerifyCodeParams verifyCodeParams) {
                    if (!z) {
                        VerifyCodeActivity.f0(verifyCodeActivity).q().setValue(Boolean.TRUE);
                        return;
                    }
                    if (verifyCodeParams != null) {
                        VerifyCodeActivity.f0(verifyCodeActivity).j().setValue(verifyCodeParams.getLastSendTicket());
                    }
                    verifyCodeActivity.q0().h(verifyCodeActivity.mTotalCountdown, verifyCodeActivity.mCountdownInterval);
                }
            });
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VerifyCodeActivity.this.finish();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VerifyCodeActivity.f0(VerifyCodeActivity.this).o().setValue(Boolean.FALSE);
            SendVerifyCodeUtil sendVerifyCodeUtil = SendVerifyCodeUtil.f34757a;
            VerifyCodeActivity verifyCodeActivity = VerifyCodeActivity.this;
            VerifyCodeVM verifyCodeVMF0 = VerifyCodeActivity.f0(verifyCodeActivity);
            String phone = VerifyCodeActivity.this.p0().getPhone();
            VerifyCodeType verifyCodeType = VerifyCodeType.SMS;
            int iK0 = VerifyCodeActivity.this.k0();
            final VerifyCodeActivity verifyCodeActivity2 = VerifyCodeActivity.this;
            sendVerifyCodeUtil.j(verifyCodeActivity, verifyCodeVMF0, phone, verifyCodeType, iK0, new Function2<Boolean, VerifyCodeParams, Unit>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$ClickProxy$clickSmsCode$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), (VerifyCodeParams) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, @Nullable VerifyCodeParams verifyCodeParams) {
                    if (!z) {
                        VerifyCodeActivity.f0(verifyCodeActivity2).o().setValue(Boolean.TRUE);
                        return;
                    }
                    if (verifyCodeParams != null) {
                        VerifyCodeActivity.f0(verifyCodeActivity2).j().setValue(verifyCodeParams.getLastSendTicket());
                    }
                    verifyCodeActivity2.m0().h(verifyCodeActivity2.mTotalCountdown, verifyCodeActivity2.mCountdownInterval);
                }
            });
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            String string = VerifyCodeActivity.this.getString(R.string.login_request_voice_code_dialog);
            String string2 = VerifyCodeActivity.this.getString(R.string.login_request_verify_code);
            final VerifyCodeActivity verifyCodeActivity = VerifyCodeActivity.this;
            ft1.u(context, string, string2, new View.OnClickListener() { // from class: com.zj.adlib.im9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VerifyCodeActivity.ClickProxy.e(verifyCodeActivity, view2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.login.page.verify_code.VerifyCodeActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JH\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/login/page/verify_code/VerifyCodeActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/login/bean/VerifyCodeParams;", VerifyCodeActivity.t, "Lcom/huachenjie/login/enums/LoginThirdType;", VerifyCodeActivity.x, "", VerifyCodeActivity.y, "schoolCode", "studentNumber", "bindKey", "", "a", "BIND_KEY", "Ljava/lang/String;", "LOGIN_THIRD_TYPE", "SCHOOL_CODE", "STUDENT_NUMBER", "THIRD_KEY", "VERIFY_CODE_PARAMS", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull VerifyCodeParams verifyCodeParams, @NotNull LoginThirdType loginThirdType, @NotNull String thirdKey, @NotNull String schoolCode, @NotNull String studentNumber, @NotNull String bindKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(verifyCodeParams, VerifyCodeActivity.t);
            Intrinsics.checkNotNullParameter(loginThirdType, VerifyCodeActivity.x);
            Intrinsics.checkNotNullParameter(thirdKey, VerifyCodeActivity.y);
            Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
            Intrinsics.checkNotNullParameter(studentNumber, "studentNumber");
            Intrinsics.checkNotNullParameter(bindKey, "bindKey");
            Intent intent = new Intent(context, (Class<?>) VerifyCodeActivity.class);
            intent.putExtra(VerifyCodeActivity.t, verifyCodeParams);
            intent.putExtra(VerifyCodeActivity.x, loginThirdType.getType());
            intent.putExtra(VerifyCodeActivity.y, thirdKey);
            intent.putExtra("schoolCode", schoolCode);
            intent.putExtra("studentNumber", studentNumber);
            intent.putExtra("bindKey", bindKey);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34746a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34746a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34746a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34746a.invoke(obj);
        }
    }

    public static final /* synthetic */ VerifyCodeVM f0(VerifyCodeActivity verifyCodeActivity) {
        return verifyCodeActivity.getMViewModel();
    }

    public static final void s0(VerifyCodeActivity verifyCodeActivity, String str) {
        Intrinsics.checkNotNullParameter(verifyCodeActivity, "this$0");
        VerifyCodeVM mViewModel = verifyCodeActivity.getMViewModel();
        Intrinsics.checkNotNullExpressionValue(str, "code");
        mViewModel.u(str);
        LoginActivityVerifyCodeBinding mBinding = verifyCodeActivity.getMBinding();
        qa4.b(mBinding != null ? mBinding.f34670a : null);
    }

    public static final void t0(VerifyCodeActivity verifyCodeActivity) {
        Intrinsics.checkNotNullParameter(verifyCodeActivity, "this$0");
        verifyCodeActivity.getMBinding().f34670a.showCursor();
        qa4.c(verifyCodeActivity.getMBinding().f34670a);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new b(new Function1<LoginResultData, Unit>() { // from class: com.huachenjie.login.page.verify_code.VerifyCodeActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LoginResultData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LoginResultData loginResultData) {
                LoginUtil loginUtil = LoginUtil.f34754a;
                VerifyCodeActivity verifyCodeActivity = this.this$0;
                VerifyCodeVM verifyCodeVMF0 = VerifyCodeActivity.f0(verifyCodeActivity);
                Intrinsics.checkNotNullExpressionValue(loginResultData, o.f);
                loginUtil.b(verifyCodeActivity, verifyCodeVMF0, loginResultData);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_verify_code;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().k().setValue(p0().getPhone());
        getMViewModel().j().setValue(p0().getLastSendTicket());
        getMViewModel().m().setValue(Integer.valueOf(k0()));
        getMViewModel().t().setValue(o0());
        getMViewModel().n().setValue(l0());
        getMViewModel().s().setValue(n0());
        getMViewModel().i().setValue(j0());
        int lastSendType = p0().getLastSendType();
        if (lastSendType == VerifyCodeType.SMS.getValue()) {
            getMViewModel().o().setValue(Boolean.FALSE);
            m0().h(this.mTotalCountdown, this.mCountdownInterval);
            int i = R.string.login_request_voice_code_tip;
            getMViewModel().r().setValue(fm8.f(getString(i)).c(getString(i)).p(Color.parseColor("#191F20")).i().c(getString(R.string.login_voice_code)).p(Color.parseColor("#00B6DE")).i().b());
            getMViewModel().q().setValue(Boolean.TRUE);
            return;
        }
        if (lastSendType == VerifyCodeType.VOICE.getValue()) {
            getMViewModel().q().setValue(Boolean.FALSE);
            q0().h(this.mTotalCountdown, this.mCountdownInterval);
            getMViewModel().p().setValue(getString(R.string.login_request_verify_code));
            getMViewModel().o().setValue(Boolean.TRUE);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getMBinding().f34670a.postDelayed(new Runnable() { // from class: com.zj.adlib.hm9
            @Override // java.lang.Runnable
            public final void run() {
                VerifyCodeActivity.t0(this.f42160a);
            }
        }, 500L);
        r0();
    }

    public final String j0() {
        return (String) this.bindKey.getValue();
    }

    public final int k0() {
        return ((Number) this.loginThirdType.getValue()).intValue();
    }

    public final String l0() {
        return (String) this.schoolCode.getValue();
    }

    public final VerifyCodeActivity$smsCountDown$2.a m0() {
        return (VerifyCodeActivity$smsCountDown$2.a) this.smsCountDown.getValue();
    }

    public final String n0() {
        return (String) this.studentNumber.getValue();
    }

    public final String o0() {
        return (String) this.thirdKey.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m0().d();
        q0().d();
        super.onDestroy();
    }

    public final VerifyCodeParams p0() {
        return (VerifyCodeParams) this.verifyCodeParams.getValue();
    }

    public final VerifyCodeActivity$voiceCountDown$2.a q0() {
        return (VerifyCodeActivity$voiceCountDown$2.a) this.voiceCountDown.getValue();
    }

    public final void r0() {
        VerifyCodeEditText verifyCodeEditText;
        LoginActivityVerifyCodeBinding mBinding = getMBinding();
        if (mBinding == null || (verifyCodeEditText = mBinding.f34670a) == null) {
            return;
        }
        verifyCodeEditText.setCompleteListener(new VerifyCodeEditText.OnInputCompleteListener() { // from class: com.zj.adlib.gm9
            @Override // com.huachenjie.base.view.VerifyCodeEditText.OnInputCompleteListener
            public final void onComplete(String str) {
                VerifyCodeActivity.s0(this.f41939a, str);
            }
        });
    }
}
