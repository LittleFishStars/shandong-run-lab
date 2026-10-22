package com.huachenjie.sport.page.mine.sport_test.informed;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.SportDialogInformedBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.ok0;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/sport/databinding/SportDialogInformedBinding;", "Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedVM;", "", "initWebView", "", "getWidth", "getHeight", "", "", "getVariables", "getLayoutResID", "initView", "initData", "initDataObserve", "Lkotlin/Function0;", "onAgreeSuccess", "Lkotlin/jvm/functions/Function0;", "getOnAgreeSuccess", "()Lkotlin/jvm/functions/Function0;", "setOnAgreeSuccess", "(Lkotlin/jvm/functions/Function0;)V", "onUnAgreeSuccess", "getOnUnAgreeSuccess", "setOnUnAgreeSuccess", "", "isAgree$delegate", "Lkotlin/Lazy;", InformedDialog.IS_AGREE, "()Z", "", "fitnessTestConfigCode$delegate", "getFitnessTestConfigCode", "()Ljava/lang/String;", InformedDialog.FITNESS_TEST_CONFIG_CODE, "<init>", "()V", "Companion", "a", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class InformedDialog extends BaseMVVMDialogFragment<SportDialogInformedBinding, InformedVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FITNESS_TEST_CONFIG_CODE = "fitnessTestConfigCode";

    @NotNull
    private static final String IS_AGREE = "isAgree";

    @Nullable
    private Function0<Unit> onAgreeSuccess;

    @Nullable
    private Function0<Unit> onUnAgreeSuccess;

    /* JADX INFO: renamed from: isAgree$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isAgree = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog.isAgree.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m790invoke() {
            Bundle arguments = InformedDialog.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(InformedDialog.IS_AGREE) : false);
        }
    });

    /* JADX INFO: renamed from: fitnessTestConfigCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fitnessTestConfigCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog$fitnessTestConfigCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("fitnessTestConfigCode") : null;
            return string == null ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedDialog$a;", "", "Landroid/view/View;", "view", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedDialog;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            InformedDialog.access$getMViewModel(InformedDialog.this).k(InformedDialog.this.getFitnessTestConfigCode());
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            InformedDialog.this.dismiss();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            InformedDialog.access$getMViewModel(InformedDialog.this).l(InformedDialog.this.getFitnessTestConfigCode());
            Function0<Unit> onUnAgreeSuccess = InformedDialog.this.getOnUnAgreeSuccess();
            if (onUnAgreeSuccess != null) {
                onUnAgreeSuccess.invoke();
            }
            InformedDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedDialog$b;", "", "", InformedDialog.IS_AGREE, "", InformedDialog.FITNESS_TEST_CONFIG_CODE, "Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedDialog;", "a", "FITNESS_TEST_CONFIG_CODE", "Ljava/lang/String;", "IS_AGREE", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InformedDialog a(boolean isAgree, @NotNull String fitnessTestConfigCode) {
            Intrinsics.checkNotNullParameter(fitnessTestConfigCode, InformedDialog.FITNESS_TEST_CONFIG_CODE);
            InformedDialog informedDialog = new InformedDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(InformedDialog.IS_AGREE, isAgree);
            bundle.putString(InformedDialog.FITNESS_TEST_CONFIG_CODE, fitnessTestConfigCode);
            informedDialog.setArguments(bundle);
            return informedDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36722a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36722a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36722a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36722a.invoke(obj);
        }
    }

    public static final /* synthetic */ SportDialogInformedBinding access$getMBinding(InformedDialog informedDialog) {
        return informedDialog.getMBinding();
    }

    public static final /* synthetic */ InformedVM access$getMViewModel(InformedDialog informedDialog) {
        return informedDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFitnessTestConfigCode() {
        return (String) this.fitnessTestConfigCode.getValue();
    }

    private final void initWebView() {
        WebView webView;
        SportDialogInformedBinding mBinding = getMBinding();
        if (mBinding == null || (webView = mBinding.f36547a) == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setCacheMode(-1);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }

    private final boolean isAgree() {
        return ((Boolean) this.isAgree.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return fx7.h() - SizeUtils.b(isAgree() ? 100.0f : 150.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.sport_dialog_informed;
    }

    @Nullable
    public final Function0<Unit> getOnAgreeSuccess() {
        return this.onAgreeSuccess;
    }

    @Nullable
    public final Function0<Unit> getOnUnAgreeSuccess() {
        return this.onUnAgreeSuccess;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ok0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ok0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(32.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().q().setValue(Boolean.valueOf(isAgree()));
        getMViewModel().r(getFitnessTestConfigCode());
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        getMViewModel().o().observe(getViewLifecycleOwner(), new c(new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                WebView webView;
                SportDialogInformedBinding sportDialogInformedBindingAccess$getMBinding = InformedDialog.access$getMBinding(InformedDialog.this);
                if (sportDialogInformedBindingAccess$getMBinding == null || (webView = sportDialogInformedBindingAccess$getMBinding.f36547a) == null) {
                    return;
                }
                webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            }
        }));
        getMViewModel().m().observe(getViewLifecycleOwner(), new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog.initDataObserve.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    Function0<Unit> onAgreeSuccess = InformedDialog.this.getOnAgreeSuccess();
                    if (onAgreeSuccess != null) {
                        onAgreeSuccess.invoke();
                    }
                    InformedDialog.this.dismiss();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        setCancelable(false);
        initWebView();
    }

    public final void setOnAgreeSuccess(@Nullable Function0<Unit> function0) {
        this.onAgreeSuccess = function0;
    }

    public final void setOnUnAgreeSuccess(@Nullable Function0<Unit> function0) {
        this.onUnAgreeSuccess = function0;
    }
}
