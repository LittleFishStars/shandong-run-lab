package com.huachenjie.mall.page.address.modify;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityShippingAddressModifyBinding;
import com.huachenjie.mall.page.address.ShippingAddressActivity;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u0011B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityShippingAddressModifyBinding;", "Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "onResume", "m0", "l0", "h0", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "b", "Lkotlin/Lazy;", "g0", "()Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "Landroid/view/View;", "c", "f0", "()Landroid/view/View;", "mHeaderView", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShippingAddressModifyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressModifyActivity.kt\ncom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
public final class ShippingAddressModifyActivity extends BaseMVVMActivity<MallActivityShippingAddressModifyBinding, ShippingAddressModifyVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "shippingAddress";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy shippingAddress = LazyKt.lazy(new Function0<ShippingAddressBean>() { // from class: com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity$shippingAddress$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ShippingAddressBean m492invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return (ShippingAddressBean) intent.getParcelableExtra("shippingAddress");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy mHeaderView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity$mHeaderView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final View m491invoke() {
            return this.this$0.getLayoutInflater().inflate(R.layout.mall_layout_shipping_address_modify_header, (ViewGroup) null, false);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nShippingAddressModifyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressModifyActivity.kt\ncom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity$ClickProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
    public final class a {
        public a() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(@NotNull View view) {
            String orderAddressNo;
            MutableLiveData<ShippingAddressModifyAdapter> mutableLiveDataJ;
            ShippingAddressModifyAdapter value;
            List<ShippingAddressBean> data;
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressModifyVM shippingAddressModifyVMD0 = ShippingAddressModifyActivity.d0(ShippingAddressModifyActivity.this);
            ShippingAddressBean shippingAddressBean = null;
            Object obj = null;
            shippingAddressBean = null;
            shippingAddressBean = null;
            shippingAddressBean = null;
            if (shippingAddressModifyVMD0 != null && (mutableLiveDataJ = shippingAddressModifyVMD0.j()) != null && (value = mutableLiveDataJ.getValue()) != null && (data = value.getData()) != null) {
                for (Object obj2 : data) {
                    if (((ShippingAddressBean) obj2).isSelected()) {
                        obj = obj2;
                        break;
                    }
                }
                shippingAddressBean = (ShippingAddressBean) obj;
            }
            if (shippingAddressBean == null) {
                fv5.b("请选择新的地址");
                return;
            }
            ShippingAddressBean shippingAddressBeanG0 = ShippingAddressModifyActivity.this.g0();
            if (shippingAddressBeanG0 == null || (orderAddressNo = shippingAddressBeanG0.getOrderAddressNo()) == null) {
                orderAddressNo = "";
            }
            shippingAddressBean.setOrderAddressNo(orderAddressNo);
            Intent intent = new Intent();
            intent.putExtra("shippingAddress", shippingAddressBean);
            ShippingAddressModifyActivity.this.setResult(-1, intent);
            ShippingAddressModifyActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/mall/page/address/modify/ShippingAddressModifyActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "Landroid/content/Intent;", "a", "", "SHIPPING_ADDRESS", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull ShippingAddressBean shippingAddress) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(shippingAddress, "shippingAddress");
            Intent intent = new Intent(context, (Class<?>) ShippingAddressModifyActivity.class);
            intent.putExtra("shippingAddress", shippingAddress);
            return intent;
        }
    }

    public static final /* synthetic */ ShippingAddressModifyVM d0(ShippingAddressModifyActivity shippingAddressModifyActivity) {
        return shippingAddressModifyActivity.getMViewModel();
    }

    public static final void i0(ShippingAddressModifyActivity shippingAddressModifyActivity, View view) {
        String addressNo;
        MutableLiveData<ShippingAddressModifyAdapter> mutableLiveDataJ;
        ShippingAddressModifyAdapter value;
        List<ShippingAddressBean> data;
        Intrinsics.checkNotNullParameter(shippingAddressModifyActivity, "this$0");
        ShippingAddressModifyVM mViewModel = shippingAddressModifyActivity.getMViewModel();
        ShippingAddressBean shippingAddressBean = null;
        Object obj = null;
        shippingAddressBean = null;
        shippingAddressBean = null;
        shippingAddressBean = null;
        if (mViewModel != null && (mutableLiveDataJ = mViewModel.j()) != null && (value = mutableLiveDataJ.getValue()) != null && (data = value.getData()) != null) {
            for (Object obj2 : data) {
                if (((ShippingAddressBean) obj2).isSelected()) {
                    obj = obj2;
                    break;
                }
            }
            shippingAddressBean = (ShippingAddressBean) obj;
        }
        ShippingAddressModifyVM mViewModel2 = shippingAddressModifyActivity.getMViewModel();
        if (shippingAddressBean == null || (addressNo = shippingAddressBean.getAddressNo()) == null) {
            addressNo = "";
        }
        mViewModel2.t(addressNo);
        ShippingAddressActivity.Companion companion = ShippingAddressActivity.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        companion.b(context);
    }

    public static final void j0(ShippingAddressModifyAdapter shippingAddressModifyAdapter, ShippingAddressModifyActivity shippingAddressModifyActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(shippingAddressModifyAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(shippingAddressModifyActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        shippingAddressModifyAdapter.h(shippingAddressModifyAdapter.getData().get(i));
        shippingAddressModifyActivity.getMViewModel().t(null);
        shippingAddressModifyActivity.getMViewModel().k().setValue(Boolean.TRUE);
    }

    public static final void k0(ShippingAddressModifyActivity shippingAddressModifyActivity) {
        Intrinsics.checkNotNullParameter(shippingAddressModifyActivity, "this$0");
        shippingAddressModifyActivity.getMViewModel().q();
    }

    public static final void n0(ShippingAddressModifyActivity shippingAddressModifyActivity, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressModifyActivity, "this$0");
        shippingAddressModifyActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    public final View f0() {
        Object value = this.mHeaderView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mHeaderView>(...)");
        return (View) value;
    }

    public final ShippingAddressBean g0() {
        return (ShippingAddressBean) this.shippingAddress.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_shipping_address_modify;
    }

    public final void h0() {
        String phone;
        String shippingUser;
        String address;
        String city;
        getMBinding();
        final ShippingAddressModifyAdapter shippingAddressModifyAdapter = new ShippingAddressModifyAdapter();
        TextView textView = (TextView) f0().findViewById(R.id.tv_address);
        String str = "";
        if (textView != null) {
            ShippingAddressBean shippingAddressBeanG0 = g0();
            if (shippingAddressBeanG0 == null || (city = shippingAddressBeanG0.formatCity()) == null) {
                city = "";
            }
            textView.setText(city);
        }
        TextView textView2 = (TextView) f0().findViewById(R.id.tv_address_street);
        if (textView2 != null) {
            ShippingAddressBean shippingAddressBeanG1 = g0();
            if (shippingAddressBeanG1 == null || (address = shippingAddressBeanG1.getAddress()) == null) {
                address = "";
            }
            textView2.setText(address);
        }
        TextView textView3 = (TextView) f0().findViewById(R.id.tv_shipping_user);
        if (textView3 != null) {
            ShippingAddressBean shippingAddressBeanG2 = g0();
            if (shippingAddressBeanG2 == null || (shippingUser = shippingAddressBeanG2.formatShippingUser()) == null) {
                shippingUser = "";
            }
            textView3.setText(shippingUser);
        }
        TextView textView4 = (TextView) f0().findViewById(R.id.tv_user_phone);
        if (textView4 != null) {
            ShippingAddressBean shippingAddressBeanG3 = g0();
            if (shippingAddressBeanG3 != null && (phone = shippingAddressBeanG3.formatPhone()) != null) {
                str = phone;
            }
            textView4.setText(str);
        }
        View viewFindViewById = f0().findViewById(R.id.bt_edit_address);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ga8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShippingAddressModifyActivity.i0(this.f41858a, view);
                }
            });
        }
        BaseQuickAdapter.addHeaderView$default(shippingAddressModifyAdapter, f0(), 0, 0, 6, null);
        y57.d(shippingAddressModifyAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ha8
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShippingAddressModifyActivity.j0(shippingAddressModifyAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
        View viewFindViewById2 = viewInflate.findViewById(R.id.emptyView);
        if (viewFindViewById2 != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(R.id.emptyView)");
            if (viewFindViewById2.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.1f;
            }
        }
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.bt_empty);
        if (textView5 != null) {
            Intrinsics.checkNotNullExpressionValue(textView5, "findViewById<TextView>(R.id.bt_empty)");
            textView5.setVisibility(8);
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        shippingAddressModifyAdapter.g(viewInflate);
        shippingAddressModifyAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ia8
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ShippingAddressModifyActivity.k0(this.f42315a);
            }
        });
        shippingAddressModifyAdapter.setHeaderWithEmptyEnable(true);
        getMViewModel().j().setValue(shippingAddressModifyAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        l0();
        m0();
        h0();
    }

    public final void l0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void m0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("收货地址");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.fa8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingAddressModifyActivity.n0(this.f41635a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().s();
    }
}
