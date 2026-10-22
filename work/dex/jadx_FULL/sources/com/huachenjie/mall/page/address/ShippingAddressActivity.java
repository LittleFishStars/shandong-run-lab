package com.huachenjie.mall.page.address;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.triver.basic.api.RequestPermission;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityShippingAddressBinding;
import com.huachenjie.mall.page.address.ShippingAddressActivity;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001eB\u0007¢\u0006\u0004\b(\u0010)J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/mall/page/address/ShippingAddressActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityShippingAddressBinding;", "Lcom/huachenjie/mall/page/address/ShippingAddressVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "onBackPressed", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "s0", "r0", "l0", "i0", "Landroid/view/View;", "view", "h0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "", "b", "Lkotlin/Lazy;", "j0", "()Z", "needSelectedAddress", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "c", "k0", "()Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShippingAddressActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressActivity.kt\ncom/huachenjie/mall/page/address/ShippingAddressActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,255:1\n1#2:256\n350#3,7:257\n*S KotlinDebug\n*F\n+ 1 ShippingAddressActivity.kt\ncom/huachenjie/mall/page/address/ShippingAddressActivity\n*L\n230#1:257,7\n*E\n"})
public final class ShippingAddressActivity extends BaseMVVMActivity<MallActivityShippingAddressBinding, ShippingAddressVM> {
    public static final int K = 101;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "selectedAddress";

    @NotNull
    public static final String x = "needSelectedAddress";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.v98
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            ShippingAddressActivity.u0(this.f45313a);
        }
    };

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy needSelectedAddress = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.address.ShippingAddressActivity$needSelectedAddress$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m487invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra("needSelectedAddress", false));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy shippingAddress = LazyKt.lazy(new Function0<ShippingAddressBean>() { // from class: com.huachenjie.mall.page.address.ShippingAddressActivity$shippingAddress$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ShippingAddressBean m488invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return (ShippingAddressBean) intent.getParcelableExtra("selectedAddress");
            }
            return null;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/address/ShippingAddressActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/address/ShippingAddressActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressActivity.this.h0(view);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.address.ShippingAddressActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/address/ShippingAddressActivity$b;", "", "Landroid/content/Context;", "context", "", "b", "Landroid/app/Activity;", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "", RequestPermission.REQUEST_CODE, "a", "EDIT_ADDRESS_CODE", "I", "", "NEED_SELECTED_ADDRESS", "Ljava/lang/String;", "SELECTED_ADDRESS", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Activity activity, ShippingAddressBean shippingAddressBean, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                shippingAddressBean = null;
            }
            companion.a(activity, shippingAddressBean, i);
        }

        public final void a(@NotNull Activity context, @Nullable ShippingAddressBean shippingAddress, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ShippingAddressActivity.class);
            intent.putExtra("needSelectedAddress", true);
            intent.putExtra("selectedAddress", shippingAddress);
            context.startActivityForResult(intent, requestCode);
        }

        public final void b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ShippingAddressActivity.class);
            intent.putExtra("needSelectedAddress", false);
            context.startActivity(intent);
        }
    }

    public static final void m0(ShippingAddressActivity shippingAddressActivity, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, o.f);
        shippingAddressActivity.h0(view);
    }

    public static final void n0(ShippingAddressActivity shippingAddressActivity) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        shippingAddressActivity.getMViewModel().q();
    }

    public static final void o0(ShippingAddressActivity shippingAddressActivity, ShippingAddressAdapter shippingAddressAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        Intrinsics.checkNotNullParameter(shippingAddressAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (shippingAddressActivity.j0()) {
            boolean z = false;
            if (i >= 0 && i < shippingAddressAdapter.getData().size()) {
                z = true;
            }
            if (z) {
                shippingAddressActivity.getMViewModel().u(null);
                shippingAddressAdapter.k(shippingAddressAdapter.getData().get(i));
            }
            shippingAddressActivity.i0();
        }
    }

    public static final void p0(final ShippingAddressAdapter shippingAddressAdapter, final ShippingAddressActivity shippingAddressActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(shippingAddressAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.btDefault) {
            if (shippingAddressAdapter.getData().get(i).getDefaultFlag()) {
                return;
            }
            if (i >= 0 && i < shippingAddressAdapter.getData().size()) {
                shippingAddressActivity.getMViewModel().t(shippingAddressAdapter.getData().get(i));
                return;
            }
            return;
        }
        if (id == R.id.tv_delete) {
            if (i >= 0 && i < shippingAddressAdapter.getData().size()) {
                ft1.p(view.getContext(), "是否删除", new View.OnClickListener() { // from class: com.zj.adlib.u98
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ShippingAddressActivity.q0(this.f45096a, shippingAddressAdapter, i, view2);
                    }
                });
            }
        } else if (id == R.id.tv_edit) {
            ShippingAddressEditActivity.INSTANCE.a(shippingAddressActivity, shippingAddressAdapter.getData().get(i), false, 101);
        }
    }

    public static final void q0(ShippingAddressActivity shippingAddressActivity, ShippingAddressAdapter shippingAddressAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        Intrinsics.checkNotNullParameter(shippingAddressAdapter, "$this_apply");
        shippingAddressActivity.getMViewModel().j(shippingAddressAdapter.getData().get(i));
    }

    public static final void t0(ShippingAddressActivity shippingAddressActivity, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        shippingAddressActivity.i0();
    }

    public static final void u0(ShippingAddressActivity shippingAddressActivity) {
        Intrinsics.checkNotNullParameter(shippingAddressActivity, "this$0");
        shippingAddressActivity.getMViewModel().s();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_shipping_address;
    }

    public final void h0(View view) {
        ShippingAddressEditActivity.Companion.b(ShippingAddressEditActivity.INSTANCE, this, null, true, 101, 2, null);
    }

    public final void i0() {
        List<ShippingAddressBean> data;
        if (j0()) {
            ShippingAddressAdapter value = getMViewModel().k().getValue();
            ShippingAddressBean shippingAddressBean = null;
            Object obj = null;
            shippingAddressBean = null;
            if (value != null && (data = value.getData()) != null) {
                for (Object obj2 : data) {
                    if (((ShippingAddressBean) obj2).isSelected()) {
                        obj = obj2;
                        break;
                    }
                }
                shippingAddressBean = (ShippingAddressBean) obj;
            }
            Intent intent = new Intent();
            intent.putExtra("selectedAddress", shippingAddressBean);
            setResult(-1, intent);
        }
        finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ShippingAddressVM mViewModel = getMViewModel();
        ShippingAddressBean shippingAddressBeanK0 = k0();
        mViewModel.u(shippingAddressBeanK0 != null ? shippingAddressBeanK0.getAddressNo() : null);
        r0();
        s0();
        l0();
    }

    public final boolean j0() {
        return ((Boolean) this.needSelectedAddress.getValue()).booleanValue();
    }

    public final ShippingAddressBean k0() {
        return (ShippingAddressBean) this.shippingAddress.getValue();
    }

    public final void l0() {
        final ShippingAddressAdapter shippingAddressAdapter = new ShippingAddressAdapter();
        y57.d(shippingAddressAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.w98
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShippingAddressActivity.o0(this.f45553a, shippingAddressAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        shippingAddressAdapter.addChildClickViewIds(R.id.btDefault, R.id.tv_delete, R.id.tv_edit);
        y57.b(shippingAddressAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.x98
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShippingAddressActivity.p0(shippingAddressAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.emptyContainer);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.emptyContainer)");
            viewFindViewById.setBackgroundColor(-1);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.bt_empty);
        if (textView != null) {
            Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.bt_empty)");
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.y98
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShippingAddressActivity.m0(this.f45982a, view);
                }
            });
            textView.setVisibility(0);
            textView.setText("添加地址");
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        shippingAddressAdapter.i(viewInflate);
        shippingAddressAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.z98
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ShippingAddressActivity.n0(this.f46219a);
            }
        });
        getMViewModel().k().setValue(shippingAddressAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List<ShippingAddressBean> data2;
        ShippingAddressAdapter value;
        List<ShippingAddressBean> data3;
        super.onActivityResult(requestCode, resultCode, data);
        int i = -1;
        if (resultCode == -1 && requestCode == 101 && data != null) {
            boolean z = false;
            boolean booleanExtra = data.getBooleanExtra(ShippingAddressEditActivity.x, false);
            ShippingAddressBean shippingAddressBean = (ShippingAddressBean) data.getParcelableExtra("shippingAddress");
            if (shippingAddressBean == null) {
                return;
            }
            ShippingAddressAdapter value2 = getMViewModel().k().getValue();
            ShippingAddressBean shippingAddressBean2 = null;
            Object obj = null;
            shippingAddressBean2 = null;
            if (value2 != null && (data3 = value2.getData()) != null) {
                for (Object obj2 : data3) {
                    if (((ShippingAddressBean) obj2).getDefaultFlag()) {
                        obj = obj2;
                        break;
                    }
                }
                shippingAddressBean2 = (ShippingAddressBean) obj;
            }
            if (shippingAddressBean2 != null && !TextUtils.equals(shippingAddressBean2.getAddressNo(), shippingAddressBean.getAddressNo()) && shippingAddressBean.getDefaultFlag() && (value = getMViewModel().k().getValue()) != null) {
                int iIndexOf = value.getData().indexOf(shippingAddressBean2);
                value.getData().get(iIndexOf).setDefaultFlag(false);
                if ((iIndexOf >= 0 && iIndexOf < value.getData().size()) != false) {
                    value.notifyItemChanged(iIndexOf);
                }
            }
            if (booleanExtra) {
                getMViewModel().s();
                return;
            }
            ShippingAddressAdapter value3 = getMViewModel().k().getValue();
            if (value3 != null) {
                ShippingAddressAdapter value4 = getMViewModel().k().getValue();
                if (value4 != null && (data2 = value4.getData()) != null) {
                    Iterator<ShippingAddressBean> it = data2.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        if (TextUtils.equals(it.next().getAddressNo(), shippingAddressBean.getAddressNo())) {
                            i = i2;
                            break;
                        }
                        i2++;
                    }
                }
                if (i >= 0 && i < value3.getData().size()) {
                    z = true;
                }
                if (z) {
                    ShippingAddressBean shippingAddressBean3 = value3.getData().get(i);
                    shippingAddressBean3.setAddressNo(shippingAddressBean.getAddressNo());
                    shippingAddressBean3.setReceiverName(shippingAddressBean.getReceiverName());
                    shippingAddressBean3.setReceiverPhone(shippingAddressBean.getReceiverPhone());
                    shippingAddressBean3.setAddress(shippingAddressBean.getAddress());
                    shippingAddressBean3.setDefaultFlag(shippingAddressBean.getDefaultFlag());
                    shippingAddressBean3.setProvinceCode(shippingAddressBean.getProvinceCode());
                    shippingAddressBean3.setProvinceName(shippingAddressBean.getProvinceName());
                    shippingAddressBean3.setCityCode(shippingAddressBean.getCityCode());
                    shippingAddressBean3.setCityName(shippingAddressBean.getCityName());
                    shippingAddressBean3.setDistrictCode(shippingAddressBean.getDistrictCode());
                    shippingAddressBean3.setDistrictName(shippingAddressBean.getDistrictName());
                    value3.notifyItemChanged(i);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        i0();
    }

    public final void r0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void s0() {
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
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.aa8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingAddressActivity.t0(this.f40496a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }
}
