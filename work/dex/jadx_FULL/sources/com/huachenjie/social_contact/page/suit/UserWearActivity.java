package com.huachenjie.social_contact.page.suit;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.ModelListBean;
import com.huachenjie.social_contact.bean.ModelPartListBean;
import com.huachenjie.social_contact.bean.UserAssetsBean;
import com.huachenjie.social_contact.bean.UserCultivateInfo;
import com.huachenjie.social_contact.databinding.ActivityUserWearBinding;
import com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog;
import com.huachenjie.social_contact.page.suit.UserWearActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.cr2;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.b)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b1\u00102J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\u0005H\u0014J'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fJ\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fJ\u001e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u0005H\u0002R\u0016\u0010'\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/suit/UserWearVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "", "onResume", "Landroid/os/Bundle;", "savedInstanceState", "init", "w0", "initViewModel", "", "suitType", "", "suitCode", "partType", "r0", "(ILjava/lang/String;Ljava/lang/Integer;)V", "Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", AliyunLogCommon.LogLevel.INFO, "s0", "n0", "crystal", "starDrill", "skinVoucher", "", "m0", "o0", "v0", "y0", "t0", "Lcom/huachenjie/social_contact/bean/ModelListBean;", ze1.k, "needRefreshSpine", bo.g, "q0", "K", "I", "mWearType", "a", "Z", "isExpend", "c", "showBuy", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkItemVisible", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUserWearActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserWearActivity.kt\ncom/huachenjie/social_contact/page/suit/UserWearActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,350:1\n1#2:351\n*E\n"})
public final class UserWearActivity extends BaseVmActivity<UserWearVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isExpend;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean showBuy;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    @Autowired(name = UserConstants.SOCIAL_CONTACT_PARAMS.b)
    @JvmField
    public int mWearType = -1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final AtomicBoolean checkItemVisible = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearActivity$a;", "", "Landroid/view/View;", "v", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/social_contact/page/suit/UserWearActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            UserWearActivity.this.finish();
        }

        public final void b(@Nullable View v) {
            UserWearActivity.this.y0();
        }

        public final void c(@Nullable View v) {
            UserWearActivity userWearActivity = UserWearActivity.this;
            userWearActivity.isExpend = !userWearActivity.isExpend;
            ViewDataBinding binding = UserWearActivity.this.getBinding();
            Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivityUserWearBinding");
            RelativeLayout relativeLayout = ((ActivityUserWearBinding) binding).f12823a;
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            UserWearActivity userWearActivity2 = UserWearActivity.this;
            layoutParams.height = userWearActivity2.isExpend ? -1 : cr2.c(userWearActivity2.getContext(), 345.0f);
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearActivity$b", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogUtil.PositiveNegativeClickListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            UserWearActivity.this.v0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearActivity$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {
        public c() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            UserWearActivity.this.y0();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36298a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36298a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36298a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36298a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearActivity$e", "Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", "", "onAction", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class e implements ExchangeWorldCrystalsDialog.OnActionCallback {
        public e() {
        }

        @Override // com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog.OnActionCallback
        public void onAction() {
            UserWearVM userWearVM = (UserWearVM) ((BaseVmActivity) UserWearActivity.this).f8507a;
            if (userWearVM != null) {
                userWearVM.l(-1);
            }
        }
    }

    public static final void u0(UserWearActivity userWearActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MutableLiveData<UserWearTypeAdapter> mutableLiveDataK;
        UserWearTypeAdapter value;
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ;
        UserCultivateInfo value2;
        int iF;
        Object next;
        ModelListBean modelListBean;
        Intrinsics.checkNotNullParameter(userWearActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        UserWearVM userWearVM = (UserWearVM) ((BaseVmActivity) userWearActivity).f8507a;
        if (userWearVM == null || (mutableLiveDataK = userWearVM.k()) == null || (value = mutableLiveDataK.getValue()) == null || (mutableLiveDataJ = ((UserWearVM) ((BaseVmActivity) userWearActivity).f8507a).j()) == null || (value2 = mutableLiveDataJ.getValue()) == null || (iF = value.getSelectedPosition()) == i) {
            return;
        }
        boolean z = value.getData().get(i).getType() == 3;
        boolean z2 = value.getData().get(iF).getType() == 3;
        if (!z2 && !z) {
            value.g(i);
            userWearActivity.p0(value.getData().get(i), false);
            return;
        }
        if (!z2 || z) {
            if (z2) {
                return;
            }
            value2.setWearType(value.getData().get(i).getType());
            MutableLiveData<UserCultivateInfo> mutableLiveDataJ2 = ((UserWearVM) ((BaseVmActivity) userWearActivity).f8507a).j();
            if (mutableLiveDataJ2 != null) {
                mutableLiveDataJ2.setValue(value2);
            }
            value.g(i);
            userWearActivity.p0(value.getData().get(i), true);
            return;
        }
        ArrayList<ModelListBean> modelList = value2.getModelList();
        if (modelList != null) {
            Iterator<T> it = modelList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    modelListBean = (ModelListBean) next;
                }
            } while (!(modelListBean.getType() != 3 && modelListBean.getWearStatus() == 1));
            ModelListBean modelListBean2 = (ModelListBean) next;
            if (modelListBean2 != null) {
                value2.setWearType(modelListBean2.getType());
                MutableLiveData<UserCultivateInfo> mutableLiveDataJ3 = ((UserWearVM) ((BaseVmActivity) userWearActivity).f8507a).j();
                if (mutableLiveDataJ3 != null) {
                    mutableLiveDataJ3.setValue(value2);
                }
            }
        }
        value.g(i);
        userWearActivity.p0(value.getData().get(i), true);
    }

    public static final void x0(UserWearTypeAdapter userWearTypeAdapter, ActivityUserWearBinding activityUserWearBinding) {
        Intrinsics.checkNotNullParameter(userWearTypeAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(activityUserWearBinding, "$mBinding");
        int iF = userWearTypeAdapter.getSelectedPosition();
        RecyclerView.LayoutManager layoutManager = activityUserWearBinding.f12824a.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() <= iF && iF <= linearLayoutManager.findLastCompletelyVisibleItemPosition()) {
            return;
        }
        linearLayoutManager.scrollToPositionWithOffset(iF, 0);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @Nullable
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_user_wear), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        t0();
        if (this.mWearType == 3) {
            this.checkItemVisible.set(true);
        }
        ((UserWearVM) ((BaseVmActivity) this).f8507a).l(this.mWearType);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((UserWearVM) ((BaseVmActivity) this).f8507a).h().observe(this, new d(new Function1<ModelListBean, Unit>() { // from class: com.huachenjie.social_contact.page.suit.UserWearActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ModelListBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable ModelListBean modelListBean) {
                if (modelListBean == null) {
                    fv5.b("数据异常");
                } else {
                    UserWearActivity.this.p0(modelListBean, true);
                }
            }
        }));
    }

    public final boolean m0(int crystal, int starDrill, int skinVoucher) {
        MutableLiveData<UserAssetsBean> mutableLiveDataI;
        UserAssetsBean value;
        UserWearVM userWearVM = (UserWearVM) ((BaseVmActivity) this).f8507a;
        if (userWearVM == null || (mutableLiveDataI = userWearVM.i()) == null || (value = mutableLiveDataI.getValue()) == null) {
            return false;
        }
        if (value.getCrystalValue() - crystal < 0) {
            DialogUtil.z(this, "世界水晶不足，解锁失败。", "", OptionsPickerHelper.e, "去兑换", new b());
            return false;
        }
        if (value.getStarDrill() - starDrill < 0) {
            DialogUtil.z(this, "星空钻不足，解锁失败。", "", OptionsPickerHelper.e, "去购买", new c());
            return false;
        }
        if (value.getSkinVoucher() - skinVoucher >= 0) {
            return true;
        }
        fv5.b("皮肤券不足，解锁失败");
        return false;
    }

    public final void n0(int partType) {
        UserCultivateInfo value;
        Object next;
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ = ((UserWearVM) ((BaseVmActivity) this).f8507a).j();
        if (mutableLiveDataJ == null || (value = mutableLiveDataJ.getValue()) == null) {
            return;
        }
        value.setWearType(2);
        ArrayList<ModelPartListBean> modelPartList = value.getModelPartList();
        if (modelPartList == null) {
            modelPartList = new ArrayList<>();
        }
        Iterator<T> it = modelPartList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModelPartListBean) next).getType() == partType));
        ModelPartListBean modelPartListBean = (ModelPartListBean) next;
        if (modelPartListBean != null) {
            modelPartList.remove(modelPartListBean);
        }
        value.setModelPartList(modelPartList);
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ2 = ((UserWearVM) ((BaseVmActivity) this).f8507a).j();
        if (mutableLiveDataJ2 != null) {
            mutableLiveDataJ2.setValue(value);
        }
        q0();
    }

    public final void o0(int crystal, int starDrill, int skinVoucher) {
        MutableLiveData<UserAssetsBean> mutableLiveDataI;
        UserAssetsBean value;
        MutableLiveData<UserAssetsBean> mutableLiveDataI2;
        UserAssetsBean value2;
        MutableLiveData<UserAssetsBean> mutableLiveDataI3;
        UserAssetsBean value3;
        MutableLiveData<UserAssetsBean> mutableLiveDataI4;
        UserWearVM userWearVM = (UserWearVM) ((BaseVmActivity) this).f8507a;
        UserAssetsBean value4 = (userWearVM == null || (mutableLiveDataI4 = userWearVM.i()) == null) ? null : mutableLiveDataI4.getValue();
        int skinVoucher2 = 0;
        if ((value4 != null ? Integer.valueOf(value4.getCrystalValue()) : null) != null) {
            UserWearVM userWearVM2 = (UserWearVM) ((BaseVmActivity) this).f8507a;
            value4.setCrystalValue(((userWearVM2 == null || (mutableLiveDataI3 = userWearVM2.i()) == null || (value3 = mutableLiveDataI3.getValue()) == null) ? 0 : value3.getCrystalValue()) - crystal);
        }
        if ((value4 != null ? Integer.valueOf(value4.getStarDrill()) : null) != null) {
            UserWearVM userWearVM3 = (UserWearVM) ((BaseVmActivity) this).f8507a;
            value4.setStarDrill(((userWearVM3 == null || (mutableLiveDataI2 = userWearVM3.i()) == null || (value2 = mutableLiveDataI2.getValue()) == null) ? 0 : value2.getStarDrill()) - starDrill);
        }
        if ((value4 != null ? Integer.valueOf(value4.getSkinVoucher()) : null) != null) {
            UserWearVM userWearVM4 = (UserWearVM) ((BaseVmActivity) this).f8507a;
            if (userWearVM4 != null && (mutableLiveDataI = userWearVM4.i()) != null && (value = mutableLiveDataI.getValue()) != null) {
                skinVoucher2 = value.getSkinVoucher();
            }
            value4.setSkinVoucher(skinVoucher2 - skinVoucher);
        }
        ((UserWearVM) ((BaseVmActivity) this).f8507a).i().setValue(value4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.showBuy) {
            ((UserWearVM) ((BaseVmActivity) this).f8507a).l(-1);
            this.showBuy = false;
        }
    }

    public final void p0(ModelListBean model, boolean needRefreshSpine) {
        Fragment fragmentA;
        int type = model.getType();
        if (type != 1) {
            fragmentA = type != 3 ? UserWearSuitFragment.INSTANCE.a(model.getMetaverseModelCode()) : UserWearGameFragment.INSTANCE.a();
        } else {
            fragmentA = UserWearIPFragment.INSTANCE.a();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        int i = R.id.fl_container;
        ViewGroup viewGroup = (ViewGroup) findViewById(i);
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        fragmentTransactionBeginTransaction.replace(i, fragmentA);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        if (needRefreshSpine) {
            q0();
        }
        if (this.checkItemVisible.get()) {
            w0();
            this.checkItemVisible.set(false);
        }
    }

    public final void q0() {
        UserCultivateInfo value;
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ = ((UserWearVM) ((BaseVmActivity) this).f8507a).j();
        if (mutableLiveDataJ == null || (value = mutableLiveDataJ.getValue()) == null) {
            return;
        }
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivityUserWearBinding");
        ((ActivityUserWearBinding) binding).f12825a.loadSpine(value.getSpineSuitBean());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final void r0(int suitType, @NotNull String suitCode, @Nullable Integer partType) {
        UserCultivateInfo value;
        ModelListBean modelListBean;
        Object next;
        Intrinsics.checkNotNullParameter(suitCode, "suitCode");
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ = ((UserWearVM) ((BaseVmActivity) this).f8507a).j();
        if (mutableLiveDataJ == null || (value = mutableLiveDataJ.getValue()) == null) {
            return;
        }
        boolean z = false;
        Object obj = null;
        Object obj2 = null;
        ModelListBean modelListBean2 = null;
        if (suitType == 1) {
            value.setWearType(1);
            ArrayList<ModelListBean> modelList = value.getModelList();
            if (modelList != null) {
                Iterator it = modelList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while ((((ModelListBean) next).getType() == 1) == false);
                modelListBean = (ModelListBean) next;
            } else {
                modelListBean = null;
            }
            s0(value);
            if (modelListBean != null) {
                modelListBean.setWearStatus(1);
            }
            if (modelListBean != null) {
                modelListBean.setMetaverseModelCode(suitCode);
            }
            value.setModelPartList(null);
        } else if (suitType == 2) {
            value.setWearType(2);
            ArrayList<ModelPartListBean> modelPartList = value.getModelPartList();
            if (modelPartList == null) {
                modelPartList = new ArrayList<>();
            }
            for (Object obj3 : modelPartList) {
                if ((partType != null && ((ModelPartListBean) obj3).getType() == partType.intValue()) != false) {
                    obj = obj3;
                    break;
                }
            }
            ModelPartListBean modelPartListBean = (ModelPartListBean) obj;
            if (modelPartListBean == null) {
                Intrinsics.checkNotNull(partType);
                modelPartList.add(new ModelPartListBean(suitCode, null, null, partType.intValue(), 6, null));
            } else {
                modelPartListBean.setMetaverseModelPartCode(suitCode);
            }
            value.setModelPartList(modelPartList);
            s0(value);
            ArrayList<ModelListBean> modelList2 = value.getModelList();
            if (modelList2 != null) {
                UserWearTypeAdapter value2 = ((UserWearVM) ((BaseVmActivity) this).f8507a).k().getValue();
                int iF = value2 != null ? value2.getSelectedPosition() : 0;
                if (iF >= 0 && iF < modelList2.size()) {
                    z = true;
                }
                if (z) {
                    modelList2.get(iF).setWearStatus(1);
                }
            }
        } else if (suitType == 3) {
            value.setWearType(3);
            ArrayList<ModelListBean> modelList3 = value.getModelList();
            if (modelList3 != null) {
                for (Object obj4 : modelList3) {
                    if ((((ModelListBean) obj4).getType() == 3) != false) {
                        obj2 = obj4;
                        break;
                    }
                }
                modelListBean2 = (ModelListBean) obj2;
            }
            if (modelListBean2 != null) {
                modelListBean2.setMetaverseModelCode(suitCode);
            }
        }
        MutableLiveData<UserCultivateInfo> mutableLiveDataJ2 = ((UserWearVM) ((BaseVmActivity) this).f8507a).j();
        if (mutableLiveDataJ2 != null) {
            mutableLiveDataJ2.setValue(value);
        }
        q0();
    }

    public final void s0(@Nullable UserCultivateInfo info) {
        ArrayList<ModelListBean> modelList;
        if (info == null || (modelList = info.getModelList()) == null) {
            return;
        }
        for (ModelListBean modelListBean : modelList) {
            if (modelListBean.getType() != 3) {
                modelListBean.setWearStatus(0);
            } else {
                modelListBean.setWearStatus(1);
            }
        }
    }

    public final void t0() {
        MutableLiveData<UserWearTypeAdapter> mutableLiveDataK;
        UserWearTypeAdapter value;
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivityUserWearBinding");
        ActivityUserWearBinding activityUserWearBinding = (ActivityUserWearBinding) binding;
        if (activityUserWearBinding.f12824a.getItemAnimator() != null) {
            activityUserWearBinding.f12824a.setItemAnimator(null);
        }
        UserWearVM userWearVM = (UserWearVM) ((BaseVmActivity) this).f8507a;
        if (userWearVM == null || (mutableLiveDataK = userWearVM.k()) == null || (value = mutableLiveDataK.getValue()) == null) {
            return;
        }
        value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.qi9
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                UserWearActivity.u0(this.f44219a, baseQuickAdapter, view, i);
            }
        });
    }

    public final void v0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ExchangeWorldCrystalsDialog.Companion companion = ExchangeWorldCrystalsDialog.INSTANCE;
        companion.a(new e()).show(supportFragmentManager, companion.getClass().getName());
    }

    public final void w0() {
        UserWearVM userWearVM;
        MutableLiveData<UserWearTypeAdapter> mutableLiveDataK;
        final UserWearTypeAdapter value;
        final ActivityUserWearBinding activityUserWearBinding = (ActivityUserWearBinding) getBinding();
        if (activityUserWearBinding == null || (userWearVM = (UserWearVM) ((BaseVmActivity) this).f8507a) == null || (mutableLiveDataK = userWearVM.k()) == null || (value = mutableLiveDataK.getValue()) == null || !(activityUserWearBinding.f12824a.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        activityUserWearBinding.f12824a.postDelayed(new Runnable() { // from class: com.zj.adlib.pi9
            @Override // java.lang.Runnable
            public final void run() {
                UserWearActivity.x0(value, activityUserWearBinding);
            }
        }, 64L);
    }

    public final void y0() {
        this.showBuy = true;
        ARouter.getInstance().build(RoutePathConstants.SocialContact.g).navigation();
    }
}
