package com.huachenjie.mall.page.address.edit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.triver.basic.api.RequestPermission;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityShippingAddressEditBinding;
import com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.pd6;
import com.zj.adlib.rd6;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002!\u0015B\u0007¢\u0006\u0004\b.\u0010/J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u001fj\b\u0012\u0004\u0012\u00020\u0012` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010$\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001fj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u001fj\b\u0012\u0004\u0012\u00020\u0012` ` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\"RV\u0010%\u001aD\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001f0\u001fj.\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f0\u001fj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u001fj\b\u0012\u0004\u0012\u00020\u0012` ` ` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010'R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010,¨\u00060"}, d2 = {"Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityShippingAddressEditBinding;", "Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditVM;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "o0", "n0", "Lcom/huachenjie/base/bean/AddressInfo;", "addressBean", "t0", "Lcom/zj/adlib/rd6;", "", "l0", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "b", "Lkotlin/Lazy;", "m0", "()Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "", "c", "k0", "()Z", "addressCreate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "provinceList", "cityList", "districtList", "Lcom/bigkoo/pickerview/listener/OnOptionsSelectListener;", "Lcom/bigkoo/pickerview/listener/OnOptionsSelectListener;", "optionsSelectListener", "Lcom/zj/adlib/rd6;", "optionsPickerView", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "pickerClickListener", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShippingAddressEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShippingAddressEditActivity.kt\ncom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,273:1\n1864#2,2:274\n1864#2,2:276\n1864#2,3:278\n1866#2:281\n1866#2:282\n*S KotlinDebug\n*F\n+ 1 ShippingAddressEditActivity.kt\ncom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity\n*L\n195#1:274,2\n201#1:276,2\n207#1:278,3\n201#1:281\n195#1:282\n*E\n"})
public final class ShippingAddressEditActivity extends BaseMVVMActivity<MallActivityShippingAddressEditBinding, ShippingAddressEditVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "shippingAddress";

    @NotNull
    public static final String x = "shippingAddressCreate";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public rd6<String> optionsPickerView;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy shippingAddress = LazyKt.lazy(new Function0<ShippingAddressBean>() { // from class: com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity$shippingAddress$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ShippingAddressBean m490invoke() {
            Intent intent = this.this$0.getIntent();
            if (intent != null) {
                return (ShippingAddressBean) intent.getParcelableExtra("shippingAddress");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy addressCreate = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity$addressCreate$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m489invoke() {
            Intent intent = this.this$0.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra(ShippingAddressEditActivity.x, false) : false);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ArrayList<String> provinceList = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<ArrayList<String>> cityList = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<ArrayList<ArrayList<String>>> districtList = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final OnOptionsSelectListener optionsSelectListener = new OnOptionsSelectListener() { // from class: com.zj.adlib.ca8
        @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
        public final void a(int i, int i2, int i3, View view) {
            ShippingAddressEditActivity.r0(this.f40936a, i, i2, i3, view);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final View.OnClickListener pickerClickListener = new View.OnClickListener() { // from class: com.zj.adlib.da8
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ShippingAddressEditActivity.s0(this.f41141a, view);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity$a;", "", "Landroid/view/View;", "view", "", "c", "b", "a", "v", "d", "<init>", "(Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressEditActivity.g0(ShippingAddressEditActivity.this).o().setValue("");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressEditActivity.g0(ShippingAddressEditActivity.this).q().setValue("");
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ShippingAddressEditActivity.this.k0()) {
                ShippingAddressEditActivity.g0(ShippingAddressEditActivity.this).j();
            } else {
                ShippingAddressEditActivity.g0(ShippingAddressEditActivity.this).u();
            }
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ShippingAddressEditActivity.g0(ShippingAddressEditActivity.this).t();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditActivity$b;", "", "Landroid/app/Activity;", "context", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "shippingAddress", "", "addressCreate", "", RequestPermission.REQUEST_CODE, "", "a", "", "SHIPPING_ADDRESS", "Ljava/lang/String;", "SHIPPING_ADDRESS_CREATE", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Activity activity, ShippingAddressBean shippingAddressBean, boolean z, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                shippingAddressBean = null;
            }
            companion.a(activity, shippingAddressBean, z, i);
        }

        public final void a(@NotNull Activity context, @Nullable ShippingAddressBean shippingAddress, boolean addressCreate, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ShippingAddressEditActivity.class);
            intent.putExtra("shippingAddress", shippingAddress);
            intent.putExtra(ShippingAddressEditActivity.x, addressCreate);
            context.startActivityForResult(intent, requestCode);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"com/huachenjie/mall/page/address/edit/ShippingAddressEditActivity$c", "Lcom/bigkoo/pickerview/listener/CustomListener;", "Landroid/view/View;", "v", "", "a", "", "Ljava/lang/String;", "TAG_SUBMIT", "b", "TAG_CANCEL", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final String TAG_SUBMIT = "submit";

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final String TAG_CANCEL = "cancel";

        public c() {
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            View viewFindViewById = v.findViewById(R.id.btnSubmit);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) viewFindViewById;
            View viewFindViewById2 = v.findViewById(R.id.btnCancel);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
            Button button2 = (Button) viewFindViewById2;
            button.setTag(this.TAG_SUBMIT);
            button2.setTag(this.TAG_CANCEL);
            button.setOnClickListener(ShippingAddressEditActivity.this.pickerClickListener);
            button2.setOnClickListener(ShippingAddressEditActivity.this.pickerClickListener);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35128a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35128a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35128a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35128a.invoke(obj);
        }
    }

    public static final /* synthetic */ ShippingAddressEditVM g0(ShippingAddressEditActivity shippingAddressEditActivity) {
        return shippingAddressEditActivity.getMViewModel();
    }

    public static final void p0(ShippingAddressEditActivity shippingAddressEditActivity, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressEditActivity, "this$0");
        shippingAddressEditActivity.finish();
    }

    public static final void q0(ShippingAddressEditActivity shippingAddressEditActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(shippingAddressEditActivity, "this$0");
        shippingAddressEditActivity.getMViewModel().n().setValue(Boolean.valueOf(z));
    }

    public static final void r0(ShippingAddressEditActivity shippingAddressEditActivity, int i, int i2, int i3, View view) {
        List<AddressInfo> children;
        Intrinsics.checkNotNullParameter(shippingAddressEditActivity, "this$0");
        ShippingAddressBean shippingAddressBean = new ShippingAddressBean(null, null, null, null, null, null, null, null, null, null, null, false, false, 8191, null);
        AddressInfo value = shippingAddressEditActivity.getMViewModel().p().getValue();
        if (value != null && (children = value.getChildren()) != null) {
            String code = children.get(i).getCode();
            if (code == null) {
                code = "";
            }
            shippingAddressBean.setProvinceCode(code);
            String value2 = children.get(i).getValue();
            if (value2 == null) {
                value2 = "";
            }
            shippingAddressBean.setProvinceName(value2);
            List<AddressInfo> children2 = children.get(i).getChildren();
            if (children2 != null) {
                String code2 = children2.get(i2).getCode();
                if (code2 == null) {
                    code2 = "";
                }
                shippingAddressBean.setCityCode(code2);
                String value3 = children2.get(i2).getValue();
                if (value3 == null) {
                    value3 = "";
                }
                shippingAddressBean.setCityName(value3);
                List<AddressInfo> children3 = children2.get(i2).getChildren();
                if (children3 != null) {
                    String code3 = children3.get(i3).getCode();
                    if (code3 == null) {
                        code3 = "";
                    }
                    shippingAddressBean.setDistrictCode(code3);
                    String value4 = children3.get(i3).getValue();
                    shippingAddressBean.setDistrictName(value4 != null ? value4 : "");
                }
            }
        }
        shippingAddressEditActivity.getMViewModel().l().setValue(shippingAddressBean);
        shippingAddressEditActivity.getMViewModel().k().setValue(shippingAddressBean.formatCity());
    }

    public static final void s0(ShippingAddressEditActivity shippingAddressEditActivity, View view) {
        Intrinsics.checkNotNullParameter(shippingAddressEditActivity, "this$0");
        rd6<String> rd6Var = shippingAddressEditActivity.optionsPickerView;
        if (rd6Var != null) {
            Intrinsics.checkNotNull(rd6Var);
            rd6Var.onClick(view);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().p().observe(this, new d(new Function1<AddressInfo, Unit>() { // from class: com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AddressInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AddressInfo addressInfo) {
                if (addressInfo != null) {
                    ShippingAddressEditActivity shippingAddressEditActivity = this.this$0;
                    shippingAddressEditActivity.provinceList.clear();
                    shippingAddressEditActivity.cityList.clear();
                    shippingAddressEditActivity.districtList.clear();
                    shippingAddressEditActivity.t0(addressInfo);
                }
            }
        }));
        getMViewModel().s().observe(this, new d(new Function1<ShippingAddressBean, Unit>() { // from class: com.huachenjie.mall.page.address.edit.ShippingAddressEditActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ShippingAddressBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable ShippingAddressBean shippingAddressBean) {
                if (shippingAddressBean != null) {
                    ShippingAddressEditActivity shippingAddressEditActivity = this.this$0;
                    Intent intent = new Intent();
                    intent.putExtra("shippingAddress", shippingAddressBean);
                    intent.putExtra(ShippingAddressEditActivity.x, shippingAddressEditActivity.k0());
                    shippingAddressEditActivity.setResult(-1, intent);
                    shippingAddressEditActivity.finish();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_shipping_address_edit;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        n0();
        ShippingAddressBean shippingAddressBeanM0 = m0();
        if (shippingAddressBeanM0 != null) {
            getMViewModel().q().setValue(shippingAddressBeanM0.getReceiverName());
            getMViewModel().r().setValue(shippingAddressBeanM0.getReceiverPhone());
            getMViewModel().l().setValue(shippingAddressBeanM0);
            getMViewModel().k().setValue(shippingAddressBeanM0.formatCity());
            getMViewModel().o().setValue(shippingAddressBeanM0.getAddress());
            getMViewModel().n().setValue(Boolean.valueOf(shippingAddressBeanM0.getDefaultFlag()));
            getMViewModel().m().setValue(shippingAddressBeanM0.getAddressNo());
        }
        if (k0()) {
            getMViewModel().n().setValue(Boolean.TRUE);
        }
        o0();
        MallActivityShippingAddressEditBinding mBinding = getMBinding();
        SwitchCompat switchCompat = mBinding != null ? mBinding.f10415a : null;
        if (switchCompat != null) {
            Boolean value = getMViewModel().n().getValue();
            switchCompat.setChecked(value == null ? false : value.booleanValue());
        }
        getMBinding().f10415a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.ea8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ShippingAddressEditActivity.q0(this.f41392a, compoundButton, z);
            }
        });
    }

    public final boolean k0() {
        return ((Boolean) this.addressCreate.getValue()).booleanValue();
    }

    public final rd6<String> l0() {
        if (this.optionsPickerView == null) {
            this.optionsPickerView = new pd6(this, this.optionsSelectListener).r(R.layout.pickerview_custom_options, new c()).f(true).C(Color.parseColor("#650aec")).D(Color.parseColor("#cc333333")).n(Color.parseColor("#E8E8E8")).p(7).s(3.0f).k(18).b();
        }
        return this.optionsPickerView;
    }

    public final ShippingAddressBean m0() {
        return (ShippingAddressBean) this.shippingAddress.getValue();
    }

    public final void n0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void o0() {
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
        bindingTitleBean.setTitleName(!k0() ? "修改地址" : "添加收货地址");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ba8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShippingAddressEditActivity.p0(this.f40708a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    public final void t0(AddressInfo addressBean) {
        String provinceName;
        String cityName;
        String districtName;
        List<AddressInfo> children = addressBean.getChildren();
        if (children == null || children.isEmpty()) {
            return;
        }
        ShippingAddressBean value = getMViewModel().l().getValue();
        if (value == null || (provinceName = value.getProvinceName()) == null) {
            provinceName = "";
        }
        ShippingAddressBean value2 = getMViewModel().l().getValue();
        if (value2 == null || (cityName = value2.getCityName()) == null) {
            cityName = "";
        }
        ShippingAddressBean value3 = getMViewModel().l().getValue();
        if (value3 == null || (districtName = value3.getDistrictName()) == null) {
            districtName = "";
        }
        Iterator it = children.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AddressInfo addressInfo = (AddressInfo) next;
            if (TextUtils.equals(provinceName, addressInfo.getValue())) {
                i2 = i;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<ArrayList<String>> arrayList2 = new ArrayList<>();
            List<AddressInfo> children2 = addressInfo.getChildren();
            if (children2 != null) {
                int i6 = 0;
                for (Object obj : children2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    AddressInfo addressInfo2 = (AddressInfo) obj;
                    if (TextUtils.equals(cityName, addressInfo2.getValue())) {
                        i3 = i6;
                    }
                    String value4 = addressInfo2.getValue();
                    if (value4 == null) {
                        value4 = "";
                    }
                    arrayList.add(value4);
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    List<AddressInfo> children3 = addressInfo2.getChildren();
                    if (children3 != null) {
                        int i8 = 0;
                        for (Object obj2 : children3) {
                            int i9 = i8 + 1;
                            if (i8 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            AddressInfo addressInfo3 = (AddressInfo) obj2;
                            Iterator it2 = it;
                            if (TextUtils.equals(districtName, addressInfo3.getValue())) {
                                i4 = i8;
                            }
                            String value5 = addressInfo3.getValue();
                            if (value5 == null) {
                                value5 = "";
                            }
                            arrayList3.add(value5);
                            i8 = i9;
                            it = it2;
                        }
                    }
                    arrayList2.add(arrayList3);
                    i6 = i7;
                    it = it;
                }
            }
            Iterator it3 = it;
            ArrayList<String> arrayList4 = this.provinceList;
            String value6 = addressInfo.getValue();
            if (value6 == null) {
                value6 = "";
            }
            arrayList4.add(value6);
            this.cityList.add(arrayList);
            this.districtList.add(arrayList2);
            i = i5;
            it = it3;
        }
        rd6<String> rd6VarL0 = l0();
        if (rd6VarL0 != null) {
            rd6VarL0.H(0, 0, 0);
            rd6VarL0.E(this.provinceList, this.cityList, this.districtList);
            rd6VarL0.H(i2, i3, i4);
            rd6VarL0.t();
        }
    }
}
