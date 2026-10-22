package com.huachenjie.works.page.dormitory;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.huachenjie.works.bean.dorm.DormExchangeCardBean;
import com.huachenjie.works.bean.dorm.DormUserInfoBean;
import com.huachenjie.works.databinding.WorksActivityDormitoryBinding;
import com.huachenjie.works.page.dormitory.DormitoryActivity;
import com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeDialog;
import com.huachenjie.works.widget.EnergyCircleView;
import com.igexin.push.g.o;
import com.zj.adlib.kq5;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.DORMITORY)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/page/dormitory/DormitoryActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityDormitoryBinding;", "Lcom/huachenjie/works/page/dormitory/DormitoryVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "onResume", "W", "g0", "i0", "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class DormitoryActivity extends BaseMVVMActivity<WorksActivityDormitoryBinding, DormitoryVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.works.page.dormitory.DormitoryActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/dormitory/DormitoryActivity$a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) DormitoryActivity.class));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/works/page/dormitory/DormitoryActivity$b", "Lcom/huachenjie/works/widget/EnergyCircleView$OnCountdownListener;", "", "onCountdownFinished", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements EnergyCircleView.OnCountdownListener {
        public b() {
        }

        @Override // com.huachenjie.works.widget.EnergyCircleView.OnCountdownListener
        public void onCountdownFinished() {
            DormitoryActivity.f0(DormitoryActivity.this).o(true);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37280a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37280a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37280a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37280a.invoke(obj);
        }
    }

    public static final /* synthetic */ DormitoryVM f0(DormitoryActivity dormitoryActivity) {
        return dormitoryActivity.getMViewModel();
    }

    public static final void h0(DormitoryAdapter dormitoryAdapter, final DormitoryActivity dormitoryActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(dormitoryAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(dormitoryActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        int entryType = dormitoryAdapter.getData().get(i).getEntryType();
        if (entryType == 23) {
            kq5.c(dormitoryActivity, "click_space_black_shop");
            su9.t(dormitoryActivity);
        } else if (entryType == 30) {
            dormitoryActivity.getMViewModel().n(new Function1<DormExchangeBean, Unit>() { // from class: com.huachenjie.works.page.dormitory.DormitoryActivity$initAdapter$1$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DormExchangeBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull DormExchangeBean dormExchangeBean) {
                    Intrinsics.checkNotNullParameter(dormExchangeBean, o.f);
                    DormitoryExchangeDialog dormitoryExchangeDialogA = DormitoryExchangeDialog.INSTANCE.a(dormExchangeBean);
                    final DormitoryActivity dormitoryActivity2 = this.this$0;
                    dormitoryExchangeDialogA.setOnExchangeClickListener(new Function1<DormExchangeCardBean, Unit>() { // from class: com.huachenjie.works.page.dormitory.DormitoryActivity$initAdapter$1$1$1$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DormExchangeCardBean) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull DormExchangeCardBean dormExchangeCardBean) {
                            Intrinsics.checkNotNullParameter(dormExchangeCardBean, "selectedCard");
                            DormUserInfoBean value = DormitoryActivity.f0(dormitoryActivity2).l().getValue();
                            if (value != null) {
                                DormitoryActivity dormitoryActivity3 = dormitoryActivity2;
                                value.setCharmValue(value.getCharmValue() - dormExchangeCardBean.getCharmCost());
                                DormitoryActivity.f0(dormitoryActivity3).i().setValue(String.valueOf(value.getCharmValue()));
                            }
                        }
                    });
                    FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    dormitoryExchangeDialogA.show(supportFragmentManager, "DormitoryExchangeDialog");
                }
            });
        } else {
            if (entryType != 31) {
                return;
            }
            ARouter.getInstance().build(RoutePathConstants.SocialContact.b).navigation();
        }
    }

    public static final void j0(DormitoryActivity dormitoryActivity, View view) {
        Intrinsics.checkNotNullParameter(dormitoryActivity, "this$0");
        dormitoryActivity.finish();
    }

    public static final void k0(View view) {
        ARouter.getInstance().build(RoutePathConstants.SocialContact.g).navigation();
    }

    public static final void l0(DormitoryActivity dormitoryActivity, View view) {
        String ruleUrl;
        Intrinsics.checkNotNullParameter(dormitoryActivity, "this$0");
        Postcard postcardBuild = ARouter.getInstance().build(RoutePathConstants.Common.c);
        DormUserInfoBean value = dormitoryActivity.getMViewModel().l().getValue();
        if (value == null || (ruleUrl = value.getRuleUrl()) == null) {
            ruleUrl = "";
        }
        postcardBuild.withString("url", ruleUrl).navigation();
    }

    public static final void m0(DormitoryActivity dormitoryActivity, View view) {
        Intrinsics.checkNotNullParameter(dormitoryActivity, "this$0");
        kq5.c(dormitoryActivity, "click_space_add_energy");
        dormitoryActivity.startActivity(new Intent(dormitoryActivity, (Class<?>) ReplenishEnergyActivity.class));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(true).q1(false).u1(i).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new c(new Function1<DormUserInfoBean, Unit>() { // from class: com.huachenjie.works.page.dormitory.DormitoryActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DormUserInfoBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DormUserInfoBean dormUserInfoBean) {
                this.this$0.getMBinding().f13852a.loadSpine(dormUserInfoBean.getSpine());
            }
        }));
        getMViewModel().j().observe(this, new c(new Function1<DormEnergyBean, Unit>() { // from class: com.huachenjie.works.page.dormitory.DormitoryActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DormEnergyBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DormEnergyBean dormEnergyBean) {
                this.this$0.getMBinding().f13854a.setEnergyData(dormEnergyBean);
            }
        }));
    }

    public final void g0() {
        MutableLiveData<DormitoryAdapter> mutableLiveDataK = getMViewModel().k();
        final DormitoryAdapter dormitoryAdapter = new DormitoryAdapter();
        dormitoryAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.kp2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DormitoryActivity.h0(dormitoryAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataK.setValue(dormitoryAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_dormitory;
    }

    public final void i0() {
        getMBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.gp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DormitoryActivity.j0(this.f41958a, view);
            }
        });
        getMBinding().b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.hp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DormitoryActivity.k0(view);
            }
        });
        getMBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ip2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DormitoryActivity.l0(this.f42411a, view);
            }
        });
        getMBinding().f36778a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jp2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DormitoryActivity.m0(this.f42638a, view);
            }
        });
        getMBinding().f13854a.setOnCountdownListener(new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().m(this);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        i0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().q();
        DormitoryVM.p(getMViewModel(), false, 1, null);
    }
}
