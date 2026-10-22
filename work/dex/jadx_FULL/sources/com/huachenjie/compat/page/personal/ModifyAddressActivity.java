package com.huachenjie.compat.page.personal;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.AddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.personal.ModifyAddressActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.pd6;
import com.zj.adlib.rd6;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.l)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0014j\b\u0012\u0004\u0012\u00020\u000e`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R:\u0010\u0019\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u0014j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u0014j\b\u0012\u0004\u0012\u00020\u000e`\u0015`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016RV\u0010\u001b\u001aD\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u00140\u0014j.\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u0014j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u0014j\b\u0012\u0004\u0012\u00020\u000e`\u0015`\u0015`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\"¨\u0006&"}, d2 = {"Lcom/huachenjie/compat/page/personal/ModifyAddressActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/compat/page/personal/ModifyAddressVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "e0", "initViewModel", "onBackPressed", "q0", "Lcom/zj/adlib/rd6;", "", bo.g, "Lcom/huachenjie/common/bean/AddressBean;", "a", "Lcom/huachenjie/common/bean/AddressBean;", "addressBean", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "provinceList", "b", "cityList", "c", "districtList", "Lcom/bigkoo/pickerview/listener/OnOptionsSelectListener;", "Lcom/bigkoo/pickerview/listener/OnOptionsSelectListener;", "optionsSelectListener", "Lcom/zj/adlib/rd6;", "optionsPickerView", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "pickerClickListener", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class ModifyAddressActivity extends BaseVmActivity<ModifyAddressVM> {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = "address")
    @JvmField
    @Nullable
    public AddressBean addressBean;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public rd6<String> optionsPickerView;

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
    public final OnOptionsSelectListener optionsSelectListener = new OnOptionsSelectListener() { // from class: com.zj.adlib.xq5
        @Override // com.bigkoo.pickerview.listener.OnOptionsSelectListener
        public final void a(int i, int i2, int i3, View view) {
            ModifyAddressActivity.t0(this.f45877a, i, i2, i3, view);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final View.OnClickListener pickerClickListener = new View.OnClickListener() { // from class: com.zj.adlib.yq5
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModifyAddressActivity.u0(this.f46097a, view);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/compat/page/personal/ModifyAddressActivity$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/compat/page/personal/ModifyAddressActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (TextUtils.isEmpty(((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).j().getValue())) {
                fv5.b("请填写完整住址");
                return;
            }
            if (TextUtils.isEmpty(((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).i().getValue())) {
                fv5.b("请填写完整住址");
                return;
            }
            AddressBean value = ((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).h().getValue();
            if (value == null) {
                value = new AddressBean();
            }
            value.setDetailAddress(((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).i().getValue());
            ((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).n(value);
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((ModifyAddressVM) ((BaseVmActivity) ModifyAddressActivity.this).f8507a).m();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"com/huachenjie/compat/page/personal/ModifyAddressActivity$b", "Lcom/bigkoo/pickerview/listener/CustomListener;", "Landroid/view/View;", "v", "", "a", "", "Ljava/lang/String;", "TAG_SUBMIT", "b", "TAG_CANCEL", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final String TAG_SUBMIT = "submit";

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final String TAG_CANCEL = "cancel";

        public b() {
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
            button.setOnClickListener(ModifyAddressActivity.this.pickerClickListener);
            button2.setOnClickListener(ModifyAddressActivity.this.pickerClickListener);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34138a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34138a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34138a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34138a.invoke(obj);
        }
    }

    public static final void r0(ModifyAddressActivity modifyAddressActivity, View view) {
        Intrinsics.checkNotNullParameter(modifyAddressActivity, "this$0");
        modifyAddressActivity.onBackPressed();
    }

    public static final void s0(ModifyAddressActivity modifyAddressActivity, View view) {
        Intrinsics.checkNotNullParameter(modifyAddressActivity, "this$0");
        modifyAddressActivity.finish();
    }

    public static final void t0(ModifyAddressActivity modifyAddressActivity, int i, int i2, int i3, View view) {
        List<AddressInfo> children;
        Intrinsics.checkNotNullParameter(modifyAddressActivity, "this$0");
        AddressBean addressBean = new AddressBean();
        AddressInfo value = ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).k().getValue();
        if (value != null && (children = value.getChildren()) != null) {
            addressBean.setProvinceCode(children.get(i).getCode());
            addressBean.setProvinceName(children.get(i).getValue());
            List<AddressInfo> children2 = children.get(i).getChildren();
            if (children2 != null) {
                addressBean.setCityCode(children2.get(i2).getCode());
                addressBean.setCityName(children2.get(i2).getValue());
                List<AddressInfo> children3 = children2.get(i2).getChildren();
                if (children3 != null) {
                    addressBean.setDistrictCode(children3.get(i3).getCode());
                    addressBean.setDistrictName(children3.get(i3).getValue());
                }
            }
        }
        ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).h().setValue(addressBean);
        ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).j().setValue(addressBean.getProvinceName() + ' ' + addressBean.getCityName() + ' ' + addressBean.getDistrictName());
    }

    public static final void u0(ModifyAddressActivity modifyAddressActivity, View view) {
        Intrinsics.checkNotNullParameter(modifyAddressActivity, "this$0");
        rd6<String> rd6Var = modifyAddressActivity.optionsPickerView;
        if (rd6Var != null) {
            Intrinsics.checkNotNull(rd6Var);
            rd6Var.onClick(view);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).x1("#F5F5F5").G1(false).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_modify_address), Integer.valueOf(wk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        q0();
        MutableLiveData<AddressBean> mutableLiveDataH = ((ModifyAddressVM) ((BaseVmActivity) this).f8507a).h();
        AddressBean addressBean = this.addressBean;
        if (addressBean == null) {
            addressBean = new AddressBean();
        }
        mutableLiveDataH.setValue(addressBean);
        AddressBean addressBean2 = this.addressBean;
        if (addressBean2 != null) {
            if (!TextUtils.isEmpty(addressBean2.getProvinceName()) || !TextUtils.isEmpty(addressBean2.getCityName()) || !TextUtils.isEmpty(addressBean2.getDistrictName())) {
                ((ModifyAddressVM) ((BaseVmActivity) this).f8507a).j().setValue(addressBean2.getProvinceName() + ' ' + addressBean2.getCityName() + ' ' + addressBean2.getDistrictName());
            }
            ((ModifyAddressVM) ((BaseVmActivity) this).f8507a).i().setValue(addressBean2.getDetailAddress());
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((ModifyAddressVM) ((BaseVmActivity) this).f8507a).k().observe(this, new c(new Function1<AddressInfo, Unit>() { // from class: com.huachenjie.compat.page.personal.ModifyAddressActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AddressInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AddressInfo addressInfo) {
                ModifyAddressActivity.this.provinceList.clear();
                ModifyAddressActivity.this.cityList.clear();
                ModifyAddressActivity.this.districtList.clear();
                List<AddressInfo> children = addressInfo.getChildren();
                if (children != null) {
                    ModifyAddressActivity modifyAddressActivity = ModifyAddressActivity.this;
                    AddressBean value = ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).h().getValue();
                    String str = value != null ? value.provinceName : null;
                    String str2 = "";
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "mState.addressBean.value?.provinceName ?: \"\"");
                    }
                    AddressBean value2 = ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).h().getValue();
                    String str3 = value2 != null ? value2.cityName : null;
                    if (str3 == null) {
                        str3 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str3, "mState.addressBean.value?.cityName ?: \"\"");
                    }
                    AddressBean value3 = ((ModifyAddressVM) ((BaseVmActivity) modifyAddressActivity).f8507a).h().getValue();
                    String str4 = value3 != null ? value3.districtName : null;
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "mState.addressBean.value?.districtName ?: \"\"");
                    }
                    int iIndexOf = 0;
                    int iIndexOf2 = 0;
                    int iIndexOf3 = 0;
                    for (AddressInfo addressInfo2 : children) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        List<AddressInfo> children2 = addressInfo2.getChildren();
                        if (children2 != null) {
                            for (AddressInfo addressInfo3 : children2) {
                                if (TextUtils.equals(str3, addressInfo3.getValue())) {
                                    iIndexOf2 = children2.indexOf(addressInfo3);
                                }
                                String value4 = addressInfo3.getValue();
                                if (value4 == null) {
                                    value4 = str2;
                                }
                                arrayList.add(value4);
                                ArrayList arrayList3 = new ArrayList();
                                List<AddressInfo> children3 = addressInfo3.getChildren();
                                if (children3 != null) {
                                    for (AddressInfo addressInfo4 : children3) {
                                        String str5 = str2;
                                        String str6 = str3;
                                        if (TextUtils.equals(str4, addressInfo4.getValue())) {
                                            iIndexOf3 = children3.indexOf(addressInfo4);
                                        }
                                        String value5 = addressInfo4.getValue();
                                        if (value5 == null) {
                                            value5 = str5;
                                        }
                                        arrayList3.add(value5);
                                        str3 = str6;
                                        str2 = str5;
                                    }
                                }
                                arrayList2.add(arrayList3);
                                str3 = str3;
                                str2 = str2;
                            }
                        }
                        String str7 = str2;
                        String str8 = str3;
                        if (TextUtils.equals(str, addressInfo2.getValue())) {
                            iIndexOf = children.indexOf(addressInfo2);
                        }
                        ArrayList arrayList4 = modifyAddressActivity.provinceList;
                        String value6 = addressInfo2.getValue();
                        if (value6 == null) {
                            value6 = str7;
                        }
                        arrayList4.add(value6);
                        modifyAddressActivity.cityList.add(arrayList);
                        modifyAddressActivity.districtList.add(arrayList2);
                        str3 = str8;
                        str2 = str7;
                    }
                    rd6 rd6VarP0 = modifyAddressActivity.p0();
                    if (rd6VarP0 != null) {
                        rd6VarP0.H(0, 0, 0);
                        rd6VarP0.E(modifyAddressActivity.provinceList, modifyAddressActivity.cityList, modifyAddressActivity.districtList);
                        rd6VarP0.H(iIndexOf, iIndexOf2, iIndexOf3);
                        rd6VarP0.t();
                    }
                }
            }
        }));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ft1.g(getContext()).Q("确认放弃修改地址?").F("放弃修改").C(new View.OnClickListener() { // from class: com.zj.adlib.wq5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModifyAddressActivity.s0(this.f45662a, view);
            }
        }).N("继续编辑").Y();
    }

    public final rd6<String> p0() {
        if (this.optionsPickerView == null) {
            this.optionsPickerView = new pd6(this, this.optionsSelectListener).r(R.layout.pickerview_custom_options, new b()).f(true).C(Color.parseColor("#650aec")).D(Color.parseColor("#cc333333")).n(Color.parseColor("#E8E8E8")).p(7).s(3.0f).k(18).b();
        }
        return this.optionsPickerView;
    }

    public final void q0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((ModifyAddressVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((ModifyAddressVM) ((BaseVmActivity) this).f8507a).l().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("修改住址").setTitleTextColor(Color.parseColor("#2C3E50")).setBackTintColor(Integer.valueOf(Color.parseColor("#000000"))).setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vq5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModifyAddressActivity.r0(this.f45419a, view);
            }
        }));
    }
}
