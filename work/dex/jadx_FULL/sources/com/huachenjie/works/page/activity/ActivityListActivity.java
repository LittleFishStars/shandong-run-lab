package com.huachenjie.works.page.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.ActivityListAdapter;
import com.huachenjie.works.bean.MultipleActivityData;
import com.huachenjie.works.databinding.WorksActivityActivityListBinding;
import com.huachenjie.works.page.activity.ActivityListActivity;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002R\u001b\u0010\u0018\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/works/page/activity/ActivityListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityActivityListBinding;", "Lcom/huachenjie/works/page/activity/ActivityListModel;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "W", "", "darkMode", "o0", "m0", "k0", "i0", "b", "Lkotlin/Lazy;", "h0", "()I", "titleHeight", "c", "g0", ActivityListActivity.t, "<init>", "()V", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityListActivity extends BaseMVVMActivity<WorksActivityActivityListBinding, ActivityListModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "promotionPlace";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy titleHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.activity.ActivityListActivity$titleHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m830invoke() {
            return Integer.valueOf(this.this$0.getMBinding().f13806a.f8702a.getMeasuredHeight());
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy promotionPlace = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.activity.ActivityListActivity$promotionPlace$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m829invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(ActivityListActivity.t, 1));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.activity.ActivityListActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/activity/ActivityListActivity$a;", "", "Landroid/content/Context;", "context", "", ActivityListActivity.t, "", "a", "", "PROMOTION_PLACE", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int promotionPlace) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ActivityListActivity.class);
            intent.putExtra(ActivityListActivity.t, promotionPlace);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37142a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37142a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37142a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37142a.invoke(obj);
        }
    }

    public static final void j0(ActivityListAdapter activityListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(activityListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        su9.l(activityListAdapter.getContext(), activityListAdapter.getData().get(i).getActivityUrl() + "?activityNo=" + activityListAdapter.getData().get(i).getActivityNo());
    }

    public static final void l0(ActivityListActivity activityListActivity, View view) {
        Intrinsics.checkNotNullParameter(activityListActivity, "this$0");
        activityListActivity.finish();
    }

    public static final void n0(ActivityListActivity activityListActivity, View view) {
        Intrinsics.checkNotNullParameter(activityListActivity, "this$0");
        activityListActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        o0(false);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().i().observe(this, new b(new Function1<MultipleActivityData, Unit>() { // from class: com.huachenjie.works.page.activity.ActivityListActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MultipleActivityData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MultipleActivityData multipleActivityData) {
                ActivityListAdapter value = this.this$0.getMViewModel().j().getValue();
                if (value != null) {
                    value.setList(multipleActivityData.getActivityList());
                }
                BindingTitleBean value2 = this.this$0.getMViewModel().k().getValue();
                if (value2 != null) {
                    ActivityListActivity activityListActivity = this.this$0;
                    value2.setTitleName(multipleActivityData.getTitle());
                    activityListActivity.getMViewModel().k().setValue(value2);
                }
            }
        }));
    }

    public final int g0() {
        return ((Number) this.promotionPlace.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_activity_list;
    }

    public final int h0() {
        return ((Number) this.titleHeight.getValue()).intValue();
    }

    public final void i0() {
        MutableLiveData<ActivityListAdapter> mutableLiveDataJ = getMViewModel().j();
        final ActivityListAdapter activityListAdapter = new ActivityListAdapter();
        activityListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.rt
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivityListActivity.j0(activityListAdapter, baseQuickAdapter, view, i);
            }
        });
        activityListAdapter.setHeaderWithEmptyEnable(true);
        mutableLiveDataJ.setValue(activityListAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().l(g0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        m0();
        k0();
        i0();
    }

    public final void k0() {
        getMBinding().f13805a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.activity.ActivityListActivity$initHeadView$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                float fComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset() / this.f37143a.h0();
                if (this.f37143a.getMBinding().f13806a.f8702a.getAlpha() > 0.5d && fComputeVerticalScrollOffset <= 0.5d) {
                    this.f37143a.o0(false);
                } else if (this.f37143a.getMBinding().f13806a.f8702a.getAlpha() <= 0.5d && fComputeVerticalScrollOffset > 0.5d) {
                    this.f37143a.o0(true);
                }
                this.f37143a.getMBinding().f13806a.f8702a.setAlpha(fComputeVerticalScrollOffset);
            }
        });
        getMBinding().f36765a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.qt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityListActivity.l0(this.f44293a, view);
            }
        });
    }

    public final void m0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataK = getMViewModel().k();
        BindingTitleBean backClick = new BindingTitleBean().setTitleName(getString(R.string.works_activity_list_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackShow(true).setBackIconResId(R.drawable.works_ic_activity_list_back).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.st
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityListActivity.n0(this.f44770a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataK.setValue(backClick.setStatusBarHeight(value.intValue()));
    }

    public final void o0(boolean darkMode) {
        View decorView = getWindow().getDecorView();
        int i = R.color.white;
        decorView.setBackgroundColor(zn1.a(i));
        e.p3(this).G2(R.color.transparent).T2(darkMode).q1(false).u1(i).G1(true).a1();
    }
}
