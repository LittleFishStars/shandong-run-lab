package com.huachenjie.mall.page.express;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import androidx.coroutines.DataBindingUtil;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import com.huachenjie.mall.databinding.MallActivityExpressLogisticsBinding;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsHeadBinding;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity.a;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0011B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/express/ExpressLogisticsActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityExpressLogisticsBinding;", "Lcom/huachenjie/mall/page/express/ExpressLogisticsVm;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "f0", "e0", "Lcom/huachenjie/mall/databinding/MallItemExpressLogisticsHeadBinding;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "d0", "()Lcom/huachenjie/mall/databinding/MallItemExpressLogisticsHeadBinding;", "headViewBinding", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ExpressLogisticsActivity extends BaseMVVMActivity<MallActivityExpressLogisticsBinding, ExpressLogisticsVm> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "logisticNo";

    @NotNull
    public static final String x = "isLightStatus";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy headViewBinding = LazyKt.lazy(new Function0<MallItemExpressLogisticsHeadBinding>() { // from class: com.huachenjie.mall.page.express.ExpressLogisticsActivity$headViewBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallItemExpressLogisticsHeadBinding m520invoke() {
            return (MallItemExpressLogisticsHeadBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_item_express_logistics_head, this.this$0.getMBinding().f34795a, false);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/express/ExpressLogisticsActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/mall/page/express/ExpressLogisticsActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            String logisticSid;
            Object systemService = ExpressLogisticsActivity.this.getApplication().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ExpressLogisticsOutBean value = ExpressLogisticsActivity.c0(ExpressLogisticsActivity.this).l().getValue();
            if (value == null || (logisticSid = value.getLogisticSid()) == null) {
                logisticSid = "";
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Text", logisticSid));
            fv5.a(R.string.mall_order_detail_copy_suc);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.express.ExpressLogisticsActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/express/ExpressLogisticsActivity$b;", "", "Landroid/content/Context;", "context", "", ExpressLogisticsActivity.t, "", ExpressLogisticsActivity.x, "", PerfId.startActivity, "IS_LIGHT_STATUS", "Ljava/lang/String;", "LOGISTIC_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.startActivity(context, str, z);
        }

        public final void startActivity(@NotNull Context context, @NotNull String logisticNo, boolean isLightStatus) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logisticNo, ExpressLogisticsActivity.t);
            Intent intent = new Intent(context, (Class<?>) ExpressLogisticsActivity.class);
            intent.putExtra(ExpressLogisticsActivity.t, logisticNo);
            intent.putExtra(ExpressLogisticsActivity.x, isLightStatus);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35180a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35180a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35180a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35180a.invoke(obj);
        }
    }

    public static final /* synthetic */ ExpressLogisticsVm c0(ExpressLogisticsActivity expressLogisticsActivity) {
        return expressLogisticsActivity.getMViewModel();
    }

    public static final void g0(ExpressLogisticsActivity expressLogisticsActivity, View view) {
        Intrinsics.checkNotNullParameter(expressLogisticsActivity, "this$0");
        expressLogisticsActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().l().observe(this, new c(new Function1<ExpressLogisticsOutBean, Unit>() { // from class: com.huachenjie.mall.page.express.ExpressLogisticsActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ExpressLogisticsOutBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ExpressLogisticsOutBean expressLogisticsOutBean) {
                this.this$0.d0().setVariable(hk0.g, expressLogisticsOutBean);
                this.this$0.d0().setVariable(hk0.k, this.this$0.new a());
                this.this$0.d0().executePendingBindings();
            }
        }));
    }

    public final MallItemExpressLogisticsHeadBinding d0() {
        return (MallItemExpressLogisticsHeadBinding) this.headViewBinding.getValue();
    }

    public final void e0() {
        MutableLiveData<ExpressLogisticsAdapter> mutableLiveDataJ = getMViewModel().j();
        ExpressLogisticsAdapter expressLogisticsAdapter = new ExpressLogisticsAdapter();
        View root = d0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headViewBinding.root");
        BaseQuickAdapter.setHeaderView$default(expressLogisticsAdapter, root, 0, 0, 6, null);
        mutableLiveDataJ.setValue(expressLogisticsAdapter);
        getMBinding().f34795a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.mall.page.express.ExpressLogisticsActivity$initAdapter$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                float fComputeVerticalScrollOffset = ((recyclerView.computeVerticalScrollOffset() * 1.0f) / SizeUtils.b(44.0f)) * 1.0f;
                if (fComputeVerticalScrollOffset < 0.0f) {
                    fComputeVerticalScrollOffset = 0.0f;
                }
                this.f35181a.getMBinding().f10218a.f8702a.setBackgroundColor(Color.argb((int) ((fComputeVerticalScrollOffset <= 1.0f ? fComputeVerticalScrollOffset : 1.0f) * 255), 255, 255, 255));
            }
        });
    }

    public final void f0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataM = getMViewModel().m();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataM.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(0).setTitleName(getString(R.string.mall_express_logistics_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vb3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpressLogisticsActivity.g0(this.f45323a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_express_logistics;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        String stringExtra;
        super.initData();
        ExpressLogisticsVm mViewModel = getMViewModel();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra(t)) == null) {
            stringExtra = "";
        }
        mViewModel.o(stringExtra);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.color_f5f5f5));
        getMViewModel().n().setValue(Boolean.valueOf(getIntent().getBooleanExtra(x, false)));
        f0();
        e0();
    }
}
