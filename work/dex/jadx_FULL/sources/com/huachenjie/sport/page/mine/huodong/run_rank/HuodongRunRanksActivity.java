package com.huachenjie.sport.page.mine.huodong.run_rank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.RunRankBean;
import com.huachenjie.sport.databinding.ActivityHuodongRunRanksBinding;
import com.huachenjie.sport.databinding.ActivityHuodongRunRanksHeaderBinding;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.h46;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.ok0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0015B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001e\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", "isDarkFont", "s0", "o0", "r0", "", "a", "Lkotlin/Lazy;", "l0", "()Ljava/lang/String;", "activityCode", "b", "m0", "()Z", "hasSignUp", "Lcom/huachenjie/sport/databinding/ActivityHuodongRunRanksHeaderBinding;", "kotlin.jvm.PlatformType", "c", "n0", "()Lcom/huachenjie/sport/databinding/ActivityHuodongRunRanksHeaderBinding;", "headerBinding", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongRunRanksActivity extends BaseVmActivity<HuodongRunRanksVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String x = "activityCode";

    @NotNull
    public static final String y = "signUp";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy activityCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity$activityCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("activityCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy hasSignUp = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity$hasSignUp$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m784invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(HuodongRunRanksActivity.y, false));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerBinding = LazyKt.lazy(new Function0<ActivityHuodongRunRanksHeaderBinding>() { // from class: com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity$headerBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ActivityHuodongRunRanksHeaderBinding m785invoke() {
            return (ActivityHuodongRunRanksHeaderBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.activity_huodong_run_ranks_header, null, false);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Integer value = ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).q().getValue();
            if (value != null && value.intValue() == 1) {
                ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).q().setValue(2);
            } else {
                ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).q().setValue(1);
            }
            ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).w().setValue(Boolean.valueOf(Intrinsics.areEqual(((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).o().getValue(), ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).q().getValue()) && HuodongRunRanksActivity.this.m0()));
            ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).s().setValue(new RunRankBean(0, null, null, 0L, 15, null));
            ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).t().setValue(new RunRankBean(0, null, null, 0L, 15, null));
            ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).u().setValue(new RunRankBean(0, null, null, 0L, 15, null));
            ((HuodongRunRanksVM) ((BaseVmActivity) HuodongRunRanksActivity.this).f8507a).A();
            h46 h46Var = h46.f42049a;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/run_rank/HuodongRunRanksActivity$b;", "", "Landroid/content/Context;", "context", "", "activityCode", "", "hasSignUp", "", "a", "KEY_ACTIVITY_CODE", "Ljava/lang/String;", "KEY_SIGN_UP", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String activityCode, boolean hasSignUp) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(activityCode, "activityCode");
            context.startActivity(new Intent(context, (Class<?>) HuodongRunRanksActivity.class).putExtra("activityCode", activityCode).putExtra(HuodongRunRanksActivity.y, hasSignUp));
        }
    }

    public static final void p0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
    }

    public static final void q0(HuodongRunRanksActivity huodongRunRanksActivity) {
        Intrinsics.checkNotNullParameter(huodongRunRanksActivity, "this$0");
        ((HuodongRunRanksVM) ((BaseVmActivity) huodongRunRanksActivity).f8507a).x();
    }

    public static final void t0(HuodongRunRanksActivity huodongRunRanksActivity, View view) {
        Intrinsics.checkNotNullParameter(huodongRunRanksActivity, "this$0");
        huodongRunRanksActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_huodong_run_ranks), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        boolean z = false;
        s0(false);
        o0();
        r0();
        HuodongRunRanksVM huodongRunRanksVM = (HuodongRunRanksVM) ((BaseVmActivity) this).f8507a;
        String strL0 = l0();
        Intrinsics.checkNotNullExpressionValue(strL0, "activityCode");
        huodongRunRanksVM.C(strL0);
        ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).o().setValue(Integer.valueOf(ai9.e().getSex()));
        MediatorLiveData<Boolean> mediatorLiveDataW = ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).w();
        if (Intrinsics.areEqual(((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).o().getValue(), ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).q().getValue()) && m0()) {
            z = true;
        }
        mediatorLiveDataW.setValue(Boolean.valueOf(z));
        ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).A();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final String l0() {
        return (String) this.activityCode.getValue();
    }

    public final boolean m0() {
        return ((Boolean) this.hasSignUp.getValue()).booleanValue();
    }

    public final ActivityHuodongRunRanksHeaderBinding n0() {
        return (ActivityHuodongRunRanksHeaderBinding) this.headerBinding.getValue();
    }

    public final void o0() {
        HuodongRunRanksAdapter huodongRunRanksAdapter = new HuodongRunRanksAdapter();
        y57.d(huodongRunRanksAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.h34
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HuodongRunRanksActivity.p0(baseQuickAdapter, view, i);
            }
        }, 1, null);
        n0().setLifecycleOwner(this);
        n0().setVariable(lk0.p0, ((BaseVmActivity) this).f8507a);
        n0().setVariable(lk0.k, new a());
        n0().getRoot().setTag("RankListHead");
        View root = n0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerBinding.root");
        BaseQuickAdapter.setHeaderView$default(huodongRunRanksAdapter, root, 0, 0, 6, null);
        huodongRunRanksAdapter.setHeaderWithEmptyEnable(true);
        huodongRunRanksAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.i34
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                HuodongRunRanksActivity.q0(this.f42267a);
            }
        });
        ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).k().setValue(huodongRunRanksAdapter);
    }

    public final void r0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityHuodongRunRanksBinding");
        final ActivityHuodongRunRanksBinding activityHuodongRunRanksBinding = (ActivityHuodongRunRanksBinding) binding;
        activityHuodongRunRanksBinding.f36411a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity$initScroll$1$1

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            public int scrollY;

            /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
            public boolean lastDarkFont;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.scrollY += dy;
                i4a.c("scrollY:" + this.scrollY);
                float fMax = ((float) this.scrollY) / ((float) Math.max(1, activityHuodongRunRanksBinding.f13281a.f8702a.getHeight()));
                int i = this.scrollY;
                if (fMax == ((float) i)) {
                    return;
                }
                double d = fMax;
                if ((d > 0.5d) != this.lastDarkFont) {
                    boolean z = d > 0.5d;
                    this.lastDarkFont = z;
                    this.s0(z);
                } else if (i == 0) {
                    this.lastDarkFont = false;
                    this.s0(false);
                }
            }
        });
    }

    public final void s0(boolean isDarkFont) {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("活动榜单");
        int iIntValue = 0;
        bindingTitleBean.setShowDivider(false);
        Integer value = ((BaseVM) ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleTextColor(zn1.a(isDarkFont ? R.color.color_2C3E50 : R.color.white));
        bindingTitleBean.setBackground(zn1.a(isDarkFont ? R.color.white : R.color.transparent));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(isDarkFont ? R.color.color_2C3E50 : R.color.white)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.j34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuodongRunRanksActivity.t0(this.f42496a, view);
            }
        });
        e.p3(this).l3().T2(isDarkFont).a1();
        ((HuodongRunRanksVM) ((BaseVmActivity) this).f8507a).i.setValue(bindingTitleBean);
    }
}
