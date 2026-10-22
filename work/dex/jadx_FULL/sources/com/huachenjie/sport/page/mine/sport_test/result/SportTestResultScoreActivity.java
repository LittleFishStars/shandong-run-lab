package com.huachenjie.sport.page.mine.sport_test.result;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.bean.TestResultYearBean;
import com.huachenjie.sport.databinding.ActivitySportTestResultBinding;
import com.huachenjie.sport.databinding.LayoutSportTestResultDetailBinding;
import com.huachenjie.sport.databinding.LayoutSportTestResultSimpleBinding;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity.a;
import com.igexin.push.g.o;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.r5a;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.q)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u001f\u0010\u001e\u001a\u00060\u001aR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "m0", "", "showDetail", "l0", "Landroid/view/View;", "contentView", "j0", "Lcom/lxj/xpopup/core/BasePopupView;", "a", "Lcom/lxj/xpopup/core/BasePopupView;", "popupView", "", "Ljava/lang/Integer;", "currentContentLayoutRes", "Landroid/view/View;", "currentContentView", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity$a;", "Lkotlin/Lazy;", "k0", "()Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity$a;", "clickProxy", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestResultScoreActivity extends BaseVmActivity<SportTestResultScoreVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View currentContentView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public BasePopupView popupView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer currentContentLayoutRes;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportTestResultScoreActivity.a m792invoke() {
            return this.this$0.new a();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestResultScoreActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (SportTestResultScoreActivity.this.popupView == null) {
                fv5.b("年份列表为空");
                return;
            }
            BasePopupView basePopupView = SportTestResultScoreActivity.this.popupView;
            if (basePopupView != null) {
                basePopupView.show();
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36728a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36728a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36728a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36728a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_sport_test_result), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), k0());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…ram(BR.click, clickProxy)");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a).o();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        m0();
    }

    public final void j0(View contentView) {
        ViewDataBinding viewDataBindingBind = DataBindingUtil.bind(contentView);
        if (viewDataBindingBind != null) {
            viewDataBindingBind.setLifecycleOwner(this);
        }
        if (viewDataBindingBind instanceof LayoutSportTestResultDetailBinding) {
            LayoutSportTestResultDetailBinding layoutSportTestResultDetailBinding = (LayoutSportTestResultDetailBinding) viewDataBindingBind;
            layoutSportTestResultDetailBinding.m((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a);
            layoutSportTestResultDetailBinding.l(k0());
        } else if (viewDataBindingBind instanceof LayoutSportTestResultSimpleBinding) {
            ((LayoutSportTestResultSimpleBinding) viewDataBindingBind).k((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a);
        }
    }

    public final a k0() {
        return (a) this.clickProxy.getValue();
    }

    public final void l0(boolean showDetail) {
        ViewDataBinding binding = getBinding();
        ActivitySportTestResultBinding activitySportTestResultBinding = binding instanceof ActivitySportTestResultBinding ? (ActivitySportTestResultBinding) binding : null;
        if (activitySportTestResultBinding == null) {
            return;
        }
        int i = showDetail ? R.layout.layout_sport_test_result_detail : R.layout.layout_sport_test_result_simple;
        if (!activitySportTestResultBinding.f36436a.isInflated()) {
            ViewStub viewStub = activitySportTestResultBinding.f36436a.getViewStub();
            if (viewStub == null) {
                return;
            }
            viewStub.setLayoutResource(i);
            View viewInflate = viewStub.inflate();
            this.currentContentLayoutRes = Integer.valueOf(i);
            this.currentContentView = viewInflate;
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflated");
            j0(viewInflate);
            return;
        }
        Integer num = this.currentContentLayoutRes;
        if (num != null && num.intValue() == i) {
            return;
        }
        View root = this.currentContentView;
        if (root == null) {
            root = activitySportTestResultBinding.f36436a.getRoot();
        }
        if (root == null) {
            return;
        }
        ViewParent parent = root.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        int iIndexOfChild = viewGroup.indexOfChild(root);
        viewGroup.removeView(root);
        View viewInflate2 = getLayoutInflater().inflate(i, viewGroup, false);
        viewGroup.addView(viewInflate2, iIndexOfChild);
        this.currentContentLayoutRes = Integer.valueOf(i);
        this.currentContentView = viewInflate2;
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "newView");
        j0(viewInflate2);
    }

    public final void m0() {
        ((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a).l().observe(this, new b(new Function1<List<? extends TestResultYearBean>, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity$observerData$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreActivity$observerData$1$a", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreDrawer$OnConfirmListener;", "Lcom/huachenjie/sport/bean/TestResultYearBean;", "item", "", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements SportTestResultScoreDrawer.OnConfirmListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ SportTestResultScoreActivity f36729a;

                public a(SportTestResultScoreActivity sportTestResultScoreActivity) {
                    this.f36729a = sportTestResultScoreActivity;
                }

                @Override // com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreDrawer.OnConfirmListener
                public void a(@NotNull TestResultYearBean item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    ((SportTestResultScoreVM) ((BaseVmActivity) ((BaseVmActivity) this.f36729a)).f8507a).k().setValue(item);
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<TestResultYearBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<TestResultYearBean> list) {
                Object next;
                if (CollectionUtils.r(list)) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((TestResultYearBean) next).getCurrentYear(), Boolean.TRUE));
                TestResultYearBean testResultYearBean = (TestResultYearBean) next;
                if (testResultYearBean == null) {
                    testResultYearBean = list.get(0);
                }
                ((SportTestResultScoreVM) ((BaseVmActivity) ((BaseVmActivity) this.this$0)).f8507a).k().setValue(testResultYearBean);
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SportTestResultScoreDrawer sportTestResultScoreDrawer = new SportTestResultScoreDrawer(context, list, list.indexOf(testResultYearBean));
                SportTestResultScoreActivity sportTestResultScoreActivity = this.this$0;
                sportTestResultScoreActivity.popupView = new r5a.b(sportTestResultScoreActivity.getContext()).q0(PopupPosition.Right).U(false).b0(true).r(sportTestResultScoreDrawer);
                sportTestResultScoreDrawer.setListener(new a(this.this$0));
            }
        }));
        ((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a).k().observe(this, new b(new Function1<TestResultYearBean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity$observerData$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TestResultYearBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(TestResultYearBean testResultYearBean) {
                if (testResultYearBean != null) {
                    ((SportTestResultScoreVM) ((BaseVmActivity) ((BaseVmActivity) this.this$0)).f8507a).n();
                }
            }
        }));
        ((SportTestResultScoreVM) ((BaseVmActivity) this).f8507a).j().observe(this, new b(new Function1<SportTestResultBean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity$observerData$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SportTestResultBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SportTestResultBean sportTestResultBean) {
                SportTestResultScoreActivity sportTestResultScoreActivity = this.this$0;
                boolean z = false;
                if (sportTestResultBean != null && sportTestResultBean.getFitnessAllScoreVisible()) {
                    z = true;
                }
                sportTestResultScoreActivity.l0(!z);
            }
        }));
    }
}
