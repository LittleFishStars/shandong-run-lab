package com.huachenjie.sport.page.mine.choose_classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.PEClassesSelectorBean;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.r5a;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.g)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J2\u0010\u001a\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0002R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "initData", "l0", "k0", "initView", "", "", "semesterList", "subjectList", "", "timeList", "j0", "Lcom/lxj/xpopup/core/BasePopupView;", "a", "Lcom/lxj/xpopup/core/BasePopupView;", "i0", "()Lcom/lxj/xpopup/core/BasePopupView;", "n0", "(Lcom/lxj/xpopup/core/BasePopupView;)V", "popupView", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer;", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer;", "h0", "()Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer;", "m0", "(Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer;)V", "drawer", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseClassesActivity extends BaseVmActivity<ChooseClassesVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PEClassesSelectorDrawer drawer;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public BasePopupView popupView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesActivity$a;", "", "Landroid/view/View;", "v", "", "a", "e", "b", "d", "c", "<init>", "(Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChooseClassesActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (ChooseClassesActivity.this.getDrawer() == null) {
                fv5.b("学期列表为空");
                return;
            }
            PEClassesSelectorDrawer drawer = ChooseClassesActivity.this.getDrawer();
            Intrinsics.checkNotNull(drawer);
            drawer.setIndex(((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).getSemesterIndex(), ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).getSubjectIndex(), ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).getTimeIndex());
            BasePopupView popupView = ChooseClassesActivity.this.getPopupView();
            if (popupView != null) {
                popupView.show();
            }
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Sport.h).navigation();
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            MutableLiveData<Boolean> mutableLiveDataP = ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).p();
            Boolean value = ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).p().getValue();
            Intrinsics.checkNotNull(value);
            mutableLiveDataP.setValue(Boolean.valueOf(!value.booleanValue()));
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).F(true);
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intent intent = new Intent(ChooseClassesActivity.this, (Class<?>) PEClassesSearchActivity.class);
            intent.putExtra(PEClassesSearchActivity.x, ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).s().getValue());
            ChooseClassesActivity.this.startActivityForResult(intent, 0);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ChooseClassesActivity$b", "Lcom/huachenjie/sport/page/mine/choose_classes/PEClassesSelectorDrawer$OnConfirmListener;", "", "semesterIndex", "subjectIndex", "time", "", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements PEClassesSelectorDrawer.OnConfirmListener {
        public b() {
        }

        @Override // com.huachenjie.sport.page.mine.choose_classes.PEClassesSelectorDrawer.OnConfirmListener
        public void a(int semesterIndex, int subjectIndex, int time) {
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).K(semesterIndex);
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).L(subjectIndex);
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).M(time);
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).h();
            ((ChooseClassesVM) ((BaseVmActivity) ChooseClassesActivity.this).f8507a).F(true);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36621a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36621a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36621a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36621a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_choose_classes), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Nullable
    /* JADX INFO: renamed from: h0, reason: from getter */
    public final PEClassesSelectorDrawer getDrawer() {
        return this.drawer;
    }

    @Nullable
    /* JADX INFO: renamed from: i0, reason: from getter */
    public final BasePopupView getPopupView() {
        return this.popupView;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        l0();
        initView();
        initData();
        k0();
    }

    public final void initData() {
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).J(1);
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).j().setValue(new ChooseClassesAdapter(1));
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).G();
    }

    public final void initView() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
        Object objNavigation = ARouter.getInstance().build(RoutePathConstants.Sport.i).navigation();
        if (objNavigation instanceof Fragment) {
            fragmentTransactionBeginTransaction.add(R.id.fl_content, (Fragment) objNavigation, RoutePathConstants.Sport.i);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0(List<String> semesterList, List<String> subjectList, List<String> timeList) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.drawer = new PEClassesSelectorDrawer(context, semesterList, subjectList, timeList);
        this.popupView = new r5a.b(getContext()).q0(PopupPosition.Right).U(false).b0(true).r(this.drawer);
        PEClassesSelectorDrawer pEClassesSelectorDrawer = this.drawer;
        if (pEClassesSelectorDrawer == null) {
            return;
        }
        pEClassesSelectorDrawer.setListener(new b());
    }

    public final void k0() {
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).u().observe(this, new c(new Function1<PEClassesSelectorBean, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ChooseClassesActivity$initObserver$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PEClassesSelectorBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PEClassesSelectorBean pEClassesSelectorBean) {
                ChooseClassesActivity chooseClassesActivity = this.this$0;
                chooseClassesActivity.j0(((ChooseClassesVM) ((BaseVmActivity) chooseClassesActivity).f8507a).w(), ((ChooseClassesVM) ((BaseVmActivity) this.this$0).f8507a).z(), ((ChooseClassesVM) ((BaseVmActivity) this.this$0).f8507a).B());
            }
        }));
    }

    public final void l0() {
        e.p3(this).l3().a1();
    }

    public final void m0(@Nullable PEClassesSelectorDrawer pEClassesSelectorDrawer) {
        this.drawer = pEClassesSelectorDrawer;
    }

    public final void n0(@Nullable BasePopupView basePopupView) {
        this.popupView = basePopupView;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == -1 && data != null) {
            ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).s().setValue(data.getStringExtra(PEClassesSearchActivity.x));
            ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).F(true);
        }
    }
}
