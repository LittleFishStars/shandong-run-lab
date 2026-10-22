package com.huachenjie.mall.dialog.express;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.utils.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.databinding.MallDialogFillExpressBinding;
import com.huachenjie.mall.dialog.express.FillExpressDialog;
import com.huachenjie.mall.page.express_company.ExpressCompanyActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002+,B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R*\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR)\u0010'\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/huachenjie/mall/dialog/express/FillExpressDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogFillExpressBinding;", "Lcom/huachenjie/mall/dialog/express/FillExpressVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "initView", "initData", "initDataObserve", "onDestroy", "Lkotlin/Function2;", "Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function2;", "", "isFillExpress$delegate", "Lkotlin/Lazy;", "isFillExpress", "()Z", "refundOrderNo$delegate", "getRefundOrderNo", "()Ljava/lang/String;", "refundOrderNo", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "chooseExpressDispatch$delegate", "getChooseExpressDispatch", "()Landroidx/activity/result/ActivityResultLauncher;", "chooseExpressDispatch", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class FillExpressDialog extends BaseMVVMBottomDialogFragment<MallDialogFillExpressBinding, FillExpressVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_BEFORE_EXPRESS_CODE = "before_express_code";

    @NotNull
    private static final String KEY_BEFORE_EXPRESS_NAME = "before_express_name";

    @NotNull
    private static final String KEY_BEFORE_EXPRESS_SID = "before_express_sid";

    @NotNull
    private static final String KEY_IS_FILL_EXPRESS_TYPE = "KEY_IS_FILL_EXPRESS_TYPE";

    @NotNull
    private static final String KEY_REFUND_ORDER_NO = "refund_order_no";

    @Nullable
    private Function2<? super ExpressCompanyBean, ? super String, Unit> callback;

    /* JADX INFO: renamed from: isFillExpress$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFillExpress = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.dialog.express.FillExpressDialog.isFillExpress.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m467invoke() {
            Bundle arguments = FillExpressDialog.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(FillExpressDialog.KEY_IS_FILL_EXPRESS_TYPE) : true);
        }
    });

    /* JADX INFO: renamed from: refundOrderNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy refundOrderNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.dialog.express.FillExpressDialog$refundOrderNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString(RefundDetailActivity.t)) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: chooseExpressDispatch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy chooseExpressDispatch = LazyKt.lazy(new FillExpressDialog$chooseExpressDispatch$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/dialog/express/FillExpressDialog$a;", "", "Landroid/view/View;", "v", "", "a", "b", "c", "<init>", "(Lcom/huachenjie/mall/dialog/express/FillExpressDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            FillExpressDialog.this.dismiss();
        }

        public final void b(@Nullable View v) {
            FillExpressDialog.this.getChooseExpressDispatch().launch(new Intent(FillExpressDialog.this.getContext(), (Class<?>) ExpressCompanyActivity.class));
        }

        public final void c(@Nullable View v) {
            if (FillExpressDialog.access$getMViewModel(FillExpressDialog.this).j().getValue() == null) {
                fv5.a(R.string.mall_fill_express_dialog_sure_hin1);
                return;
            }
            if (TextUtils.isEmpty(FillExpressDialog.access$getMViewModel(FillExpressDialog.this).k().getValue())) {
                fv5.a(R.string.mall_fill_express_dialog_sure_hin2);
                return;
            }
            FillExpressVM fillExpressVMAccess$getMViewModel = FillExpressDialog.access$getMViewModel(FillExpressDialog.this);
            boolean zIsFillExpress = FillExpressDialog.this.isFillExpress();
            String refundOrderNo = FillExpressDialog.this.getRefundOrderNo();
            Intrinsics.checkNotNullExpressionValue(refundOrderNo, "refundOrderNo");
            fillExpressVMAccess$getMViewModel.i(zIsFillExpress, refundOrderNo);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.dialog.express.FillExpressDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017JV\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u000bR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/mall/dialog/express/FillExpressDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "isFillExpress", "", "refundOrderNo", "beforeExpressName", "beforeExpressCode", "beforeExpressSid", "Lkotlin/Function2;", "Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "", RenderCallContext.TYPE_CALLBACK, "a", "KEY_BEFORE_EXPRESS_CODE", "Ljava/lang/String;", "KEY_BEFORE_EXPRESS_NAME", "KEY_BEFORE_EXPRESS_SID", FillExpressDialog.KEY_IS_FILL_EXPRESS_TYPE, "KEY_REFUND_ORDER_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, boolean isFillExpress, @NotNull String refundOrderNo, @NotNull String beforeExpressName, @NotNull String beforeExpressCode, @NotNull String beforeExpressSid, @NotNull Function2<? super ExpressCompanyBean, ? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(refundOrderNo, "refundOrderNo");
            Intrinsics.checkNotNullParameter(beforeExpressName, "beforeExpressName");
            Intrinsics.checkNotNullParameter(beforeExpressCode, "beforeExpressCode");
            Intrinsics.checkNotNullParameter(beforeExpressSid, "beforeExpressSid");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            FillExpressDialog fillExpressDialog = new FillExpressDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(FillExpressDialog.KEY_IS_FILL_EXPRESS_TYPE, isFillExpress);
            bundle.putString("refund_order_no", refundOrderNo);
            if (beforeExpressName.length() > 0) {
                bundle.putString(FillExpressDialog.KEY_BEFORE_EXPRESS_NAME, beforeExpressName);
            }
            if (beforeExpressCode.length() > 0) {
                bundle.putString(FillExpressDialog.KEY_BEFORE_EXPRESS_CODE, beforeExpressCode);
            }
            if (beforeExpressSid.length() > 0) {
                bundle.putString(FillExpressDialog.KEY_BEFORE_EXPRESS_SID, beforeExpressSid);
            }
            fillExpressDialog.setArguments(bundle);
            fillExpressDialog.callback = callback;
            fillExpressDialog.show(fragmentManager, "FillExpressDialog");
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35105a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35105a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35105a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35105a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FillExpressVM access$getMViewModel(FillExpressDialog fillExpressDialog) {
        return (FillExpressVM) fillExpressDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> getChooseExpressDispatch() {
        return (ActivityResultLauncher) this.chooseExpressDispatch.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRefundOrderNo() {
        return (String) this.refundOrderNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$0(FillExpressDialog fillExpressDialog, int i) {
        Intrinsics.checkNotNullParameter(fillExpressDialog, "this$0");
        ((FillExpressVM) fillExpressDialog.getMViewModel()).m().setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFillExpress() {
        return ((Boolean) this.isFillExpress.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_fill_express;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String string;
        String string2;
        super.initData();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(KEY_BEFORE_EXPRESS_NAME)) == null) {
            return;
        }
        MutableLiveData<ExpressCompanyBean> mutableLiveDataJ = ((FillExpressVM) getMViewModel()).j();
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString(KEY_BEFORE_EXPRESS_CODE)) == null) {
            string2 = "";
        }
        Intrinsics.checkNotNullExpressionValue(string2, "arguments?.getString(KEY…EFORE_EXPRESS_CODE) ?: \"\"");
        mutableLiveDataJ.setValue(new ExpressCompanyBean(string, string2));
        MutableLiveData<String> mutableLiveDataK = ((FillExpressVM) getMViewModel()).k();
        Bundle arguments3 = getArguments();
        mutableLiveDataK.setValue(arguments3 != null ? arguments3.getString(KEY_BEFORE_EXPRESS_SID) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        ((FillExpressVM) getMViewModel()).l().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.dialog.express.FillExpressDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Function2 function2 = FillExpressDialog.this.callback;
                if (function2 != null) {
                    ExpressCompanyBean value = FillExpressDialog.access$getMViewModel(FillExpressDialog.this).j().getValue();
                    Intrinsics.checkNotNull(value);
                    String value2 = FillExpressDialog.access$getMViewModel(FillExpressDialog.this).k().getValue();
                    Intrinsics.checkNotNull(value2);
                    function2.invoke(value, value2);
                }
                FillExpressDialog.this.dismiss();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        KeyboardUtils.o(requireActivity(), new KeyboardUtils.OnSoftInputChangedListener() { // from class: com.zj.adlib.og3
            @Override // com.blankj.utilcode.util.KeyboardUtils.OnSoftInputChangedListener
            public final void a(int i) {
                FillExpressDialog.initView$lambda$0(this.f43740a, i);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChooseExpressDispatch();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Window window;
        super.onDestroy();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        KeyboardUtils.v(window);
    }
}
