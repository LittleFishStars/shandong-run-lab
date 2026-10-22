package com.huachenjie.compat.page.student;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.base.widget.dialog.OnViewCreateListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.compat.databinding.CompatActivityUserFaceBinding;
import com.huachenjie.compat.page.student.UserFaceActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.kuaishou.weapon.p0.t;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import com.zj.adlib.wk0;
import com.zj.adlib.ws1;
import com.zj.adlib.y6b;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/compat/page/student/UserFaceActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/compat/databinding/CompatActivityUserFaceBinding;", "Lcom/huachenjie/compat/page/student/UserFaceVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "<init>", "()V", "a", "ClickProxy", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class UserFaceActivity extends BaseMVVMActivity<CompatActivityUserFaceBinding, UserFaceVM> {
    public static final int K = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "user_face_bean";

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J@\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0002J*\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\"\u001a\n  *\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006%"}, d2 = {"Lcom/huachenjie/compat/page/student/UserFaceActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "i", "", "fullText", "", "highlightTexts", "Landroid/text/SpannableString;", "m", "Landroid/content/Context;", "context", "", "content", "cancelText", "confirmText", "", "countdownSeconds", "Lkotlin/Function0;", "onConfirm", "n", "contentView", "Landroid/os/CountDownTimer;", "j", "Landroid/widget/TextView;", "confirmView", "remainSeconds", y6b.f, y6b.g, "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "k", t.d, "<init>", "(Lcom/huachenjie/compat/page/student/UserFaceActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nUserFaceActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserFaceActivity.kt\ncom/huachenjie/compat/page/student/UserFaceActivity$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n1855#2,2:220\n1#3:222\n*S KotlinDebug\n*F\n+ 1 UserFaceActivity.kt\ncom/huachenjie/compat/page/student/UserFaceActivity$ClickProxy\n*L\n107#1:220,2\n*E\n"})
    public final class ClickProxy {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/compat/page/student/UserFaceActivity$ClickProxy$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", "onTick", "onFinish", "compat_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Context f34180a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ TextView f9255a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f9257a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(TextView textView, Context context, String str, long j) {
                super(j, 1000L);
                this.f9255a = textView;
                this.f34180a = context;
                this.f9257a = str;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ClickProxy.this.h(this.f9255a, this.f34180a, this.f9257a);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                ClickProxy.this.g(this.f9255a, this.f34180a, this.f9257a, (int) ((millisUntilFinished + 999) / 1000));
            }
        }

        public ClickProxy() {
        }

        public static /* synthetic */ void o(ClickProxy clickProxy, Context context, CharSequence charSequence, String str, String str2, int i, Function0 function0, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                i = 0;
            }
            clickProxy.n(context, charSequence, str, str2, i, function0);
        }

        public static final void p(View view) {
        }

        public static final void q(Function0 function0, View view) {
            Intrinsics.checkNotNullParameter(function0, "$onConfirm");
            function0.invoke();
        }

        public static final void r(Ref.ObjectRef objectRef, ClickProxy clickProxy, Context context, String str, int i, View view) {
            Intrinsics.checkNotNullParameter(objectRef, "$countDownTimer");
            Intrinsics.checkNotNullParameter(clickProxy, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(str, "$confirmText");
            Intrinsics.checkNotNullExpressionValue(view, "contentView");
            objectRef.element = clickProxy.j(view, context, str, i);
        }

        public static final void s(Ref.ObjectRef objectRef, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(objectRef, "$countDownTimer");
            CountDownTimer countDownTimer = (CountDownTimer) objectRef.element;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }

        public final void g(TextView confirmView, Context context, String confirmText, int remainSeconds) {
            confirmView.setEnabled(false);
            confirmView.setText(confirmText + '(' + remainSeconds + "s)");
            confirmView.setTextSize(14.0f);
            confirmView.setBackground(k(context));
        }

        public final void h(TextView confirmView, Context context, String confirmText) {
            confirmView.setEnabled(true);
            confirmView.setText(confirmText);
            confirmView.setTextSize(16.0f);
            confirmView.setBackground(l(context));
        }

        public final void i(@NotNull final View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SpannableString spannableStringM = m("确定关闭人脸识别功能吗？关闭后您的人脸照片将会被删除，同时阳光跑将无法进行人脸识别核验会导致跑步成绩无效，且本学期将不再支持上传人脸照片，请谨慎操作！", CollectionsKt.listOf(new String[]{"会导致跑步成绩无效", "本学期将不再支持上传人脸照片"}));
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            final UserFaceActivity userFaceActivity = UserFaceActivity.this;
            n(context, spannableStringM, "我再想想", "确定关闭", 10, new Function0<Unit>() { // from class: com.huachenjie.compat.page.student.UserFaceActivity$ClickProxy$clickClose$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m393invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m393invoke() {
                    UserFaceActivity.ClickProxy clickProxy = this.this$0;
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                    final UserFaceActivity userFaceActivity2 = userFaceActivity;
                    UserFaceActivity.ClickProxy.o(clickProxy, context2, "确定仍然关闭人脸识别功能吗？", "我再想想", "仍然关闭", 0, new Function0<Unit>() { // from class: com.huachenjie.compat.page.student.UserFaceActivity$ClickProxy$clickClose$1.1
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m394invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m394invoke() {
                            userFaceActivity2.getMViewModel().j();
                        }
                    }, 16, null);
                }
            });
        }

        public final CountDownTimer j(View contentView, Context context, String confirmText, int countdownSeconds) {
            TextView textView;
            if (countdownSeconds <= 0 || (textView = (TextView) contentView.findViewById(R.id.confirm_dialog_confirm)) == null) {
                return null;
            }
            g(textView, context, confirmText, countdownSeconds);
            a aVar = new a(textView, context, confirmText, ((long) countdownSeconds) * 1000);
            aVar.start();
            return aVar;
        }

        public final Drawable k(Context context) {
            return new DrawableCreator.Builder().setSolidColor(Color.parseColor("#E8E8E8")).setCornersRadius(cr2.c(context, 20.0f)).build();
        }

        public final Drawable l(Context context) {
            return new DrawableCreator.Builder().setSolidColor(Color.parseColor("#F3474A")).setCornersRadius(cr2.c(context, 20.0f)).build();
        }

        public final SpannableString m(String fullText, List<String> highlightTexts) {
            SpannableString spannableString = new SpannableString(fullText);
            for (String str : highlightTexts) {
                int iIndexOf$default = StringsKt.indexOf$default(spannableString, str, 0, false, 6, (Object) null);
                if (iIndexOf$default != -1) {
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F3474A")), iIndexOf$default, str.length() + iIndexOf$default, 34);
                    spannableString.setSpan(new StyleSpan(1), iIndexOf$default, str.length() + iIndexOf$default, 34);
                }
            }
            return spannableString;
        }

        public final void n(final Context context, CharSequence content, String cancelText, final String confirmText, final int countdownSeconds, final Function0<Unit> onConfirm) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Dialog dialogY = ws1.Z(context).U(com.huachenjie.compat.R.style.confirm_dialog_theme).R(com.huachenjie.compat.R.layout.dialog_confirm_box).Q(content).F(cancelText).N(confirmText).K(-1).H(l(context)).C(new View.OnClickListener() { // from class: com.zj.adlib.ci9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserFaceActivity.ClickProxy.p(view);
                }
            }).J(new View.OnClickListener() { // from class: com.zj.adlib.di9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserFaceActivity.ClickProxy.q(onConfirm, view);
                }
            }).a(new OnViewCreateListener() { // from class: com.zj.adlib.ei9
                @Override // com.huachenjie.base.widget.dialog.OnViewCreateListener
                public final void a(View view) {
                    UserFaceActivity.ClickProxy.r(objectRef, this, context, confirmText, countdownSeconds, view);
                }
            }).Y();
            if (dialogY != null) {
                dialogY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.zj.adlib.fi9
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        UserFaceActivity.ClickProxy.s(objectRef, dialogInterface);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.compat.page.student.UserFaceActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/compat/page/student/UserFaceActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean", "", "a", "", "CLOSE_CONFIRM_COUNTDOWN_SECONDS", "I", "", "KEY_USER_FACE_BEAN", "Ljava/lang/String;", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull UserFaceBean userFaceBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userFaceBean, "userFaceBean");
            Intent intent = new Intent(context, (Class<?>) UserFaceActivity.class);
            intent.putExtra(UserFaceActivity.t, userFaceBean);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34181a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34181a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34181a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34181a.invoke(obj);
        }
    }

    public static final void b0(UserFaceActivity userFaceActivity, View view) {
        Intrinsics.checkNotNullParameter(userFaceActivity, "this$0");
        userFaceActivity.finish();
    }

    @JvmStatic
    public static final void c0(@NotNull Context context, @NotNull UserFaceBean userFaceBean) {
        INSTANCE.a(context, userFaceBean);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(wk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(wk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().k().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.compat.page.student.UserFaceActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    this.this$0.finish();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return com.huachenjie.compat.R.layout.compat_activity_user_face;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().l().setValue(getIntent().getParcelableExtra(t));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(0).setTitleName("人脸识别").setTitleTextColor(RunIndexRecordAdapter.K).setBackIconResId(com.huachenjie.compat.R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(RunIndexRecordAdapter.K)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.bi9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserFaceActivity.b0(this.f40756a, view);
            }
        }));
    }
}
