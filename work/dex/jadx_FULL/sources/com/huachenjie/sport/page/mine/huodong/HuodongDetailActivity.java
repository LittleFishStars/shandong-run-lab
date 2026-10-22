package com.huachenjie.sport.page.mine.huodong;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.HuodongDetailBean;
import com.huachenjie.sport.bean.HuodongDetailImgs;
import com.huachenjie.sport.databinding.ActivityHuodongDetailBinding;
import com.huachenjie.sport.page.mine.huodong.HuodongDetailActivity;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity;
import com.huachenjie.sport.widget.HuodongSignButton;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.yn1;
import com.zj.adlib.zn1;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongDetailActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/huodong/HuodongDetailVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "init", "initViewModel", "onResume", "n0", "Lcom/huachenjie/sport/databinding/ActivityHuodongDetailBinding;", "binding", bo.g, "k0", "", "a", "D", "l0", "()D", "s0", "(D)V", "scroll2titleB", "b", "m0", "t0", "scroll2titleM", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongDetailActivity extends BaseVmActivity<HuodongDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public double scroll2titleB;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public double scroll2titleM;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongDetailActivity$a;", "", "Landroid/view/View;", "v", "", "c", "b", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/huodong/HuodongDetailActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.huodong.HuodongDetailActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/huodong/HuodongDetailActivity$a$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0827a extends DialogUtil.PositiveNegativeClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ HuodongDetailActivity f36690a;

            public C0827a(HuodongDetailActivity huodongDetailActivity) {
                this.f36690a = huodongDetailActivity;
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void b() {
                Intent intent = this.f36690a.getIntent();
                if (intent != null) {
                    ((HuodongDetailVM) ((BaseVmActivity) this.f36690a).f8507a).z(intent.getStringExtra("activityCode"));
                }
            }
        }

        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            HuodongDetailBean value = ((HuodongDetailVM) ((BaseVmActivity) HuodongDetailActivity.this).f8507a).i().getValue();
            if (value != null && value.getActivityType() == 2) {
                if (value.getActivityStatus() == 6) {
                    HuodongRunRanksActivity.Companion bVar = HuodongRunRanksActivity.INSTANCE;
                    Context context = v.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "v.context");
                    bVar.a(context, value.getActivityCode(), value.getSignUpStatus() == 4);
                    return;
                }
                if (value.getActivityStatus() == 4 && value.getSignUpStatus() == 4 && !value.getRunFlag()) {
                    ARouter.getInstance().build(RoutePathConstants.Run.r).withString(UserConstants.RUN_PARAMS.f33735a, value.getActivityCode()).withString(UserConstants.RUN_PARAMS.b, value.getActivityFenceCode()).withInt(UserConstants.RUN_PARAMS.c, value.findDistance()).navigation();
                }
            }
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            HuodongDetailBean value = ((HuodongDetailVM) ((BaseVmActivity) HuodongDetailActivity.this).f8507a).i().getValue();
            String activityRule = value != null ? value.getActivityRule() : null;
            if (activityRule == null) {
                activityRule = "";
            }
            HuodongLimitBottomDialog.INSTANCE.a(activityRule).show(HuodongDetailActivity.this.getSupportFragmentManager(), "ruleDialog");
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            HuodongDetailBean value = ((HuodongDetailVM) ((BaseVmActivity) HuodongDetailActivity.this).f8507a).i().getValue();
            boolean z = false;
            if (value != null && value.getSignUpStatus() == 1) {
                z = true;
            }
            if (z) {
                HuodongDetailActivity huodongDetailActivity = HuodongDetailActivity.this;
                DialogUtil.z(huodongDetailActivity, "是否确定报名此活动?", "报名后无法撤回哦，特殊情况请联系负责老师", "我再想想", "确认报名", new C0827a(huodongDetailActivity));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/huodong/HuodongDetailActivity$b", "Lcom/huachenjie/sport/widget/HuodongSignButton$CountDownCompleteListener;", "", "onComplete", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements HuodongSignButton.CountDownCompleteListener {
        public b() {
        }

        @Override // com.huachenjie.sport.widget.HuodongSignButton.CountDownCompleteListener
        public void onComplete() {
            MutableLiveData<HuodongDetailBean> mutableLiveDataI = ((HuodongDetailVM) ((BaseVmActivity) HuodongDetailActivity.this).f8507a).i();
            HuodongDetailBean value = ((HuodongDetailVM) ((BaseVmActivity) HuodongDetailActivity.this).f8507a).i().getValue();
            if (value != null) {
                value.setSignUpStatus(7);
            } else {
                value = null;
            }
            mutableLiveDataI.setValue(value);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36692a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36692a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36692a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36692a.invoke(obj);
        }
    }

    public static final void o0(HuodongDetailActivity huodongDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(huodongDetailActivity, "this$0");
        huodongDetailActivity.finish();
    }

    public static final void q0(ActivityHuodongDetailBinding activityHuodongDetailBinding, HuodongDetailActivity huodongDetailActivity) {
        Intrinsics.checkNotNullParameter(activityHuodongDetailBinding, "$binding");
        Intrinsics.checkNotNullParameter(huodongDetailActivity, "this$0");
        double height = ((double) activityHuodongDetailBinding.f13253a.getHeight()) * 0.8d;
        ViewGroup.LayoutParams layoutParams = activityHuodongDetailBinding.f13267b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(0, (int) height, 0, 0);
        activityHuodongDetailBinding.f13267b.setLayoutParams(layoutParams2);
        int height2 = activityHuodongDetailBinding.f13257a.f8702a.getHeight();
        int iH0 = (height2 - e.H0(huodongDetailActivity)) / 2;
        double d = height - ((double) height2);
        huodongDetailActivity.scroll2titleB = d;
        huodongDetailActivity.scroll2titleM = d + ((double) iH0);
    }

    public static final void r0(HuodongDetailActivity huodongDetailActivity, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(huodongDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(nestedScrollView, "v");
        if ((huodongDetailActivity.scroll2titleB == AudioStats.AUDIO_AMPLITUDE_NONE) || ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().getValue() == null) {
            return;
        }
        double d = huodongDetailActivity.scroll2titleB;
        double d2 = huodongDetailActivity.scroll2titleM;
        double d3 = i2;
        BindingTitleBean bindingTitleBean = null;
        if (d <= d3 && d3 <= d2) {
            double d4 = (d3 - d) / (d2 - d);
            BindingTitleBean value = ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().getValue();
            if (value != null) {
                float f = (float) d4;
                value.setTitleTextColor(yn1.a(Integer.valueOf(zn1.a(R.color.color_002C3E50)), Integer.valueOf(zn1.a(R.color.color_2C3E50)), f));
                value.setBackground(yn1.a(Integer.valueOf(zn1.a(R.color.color_00E6E8EC)), Integer.valueOf(zn1.a(R.color.color_E6E8EC)), f));
                value.setBackTintColor(Integer.valueOf(yn1.a(Integer.valueOf(zn1.a(R.color.white)), Integer.valueOf(zn1.a(R.color.black)), f)));
                bindingTitleBean = value;
            }
            ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().setValue(bindingTitleBean);
            e.p3(huodongDetailActivity).l3().T2(d4 > 0.5d).a1();
            return;
        }
        double d5 = i4;
        if (d5 > d && d3 <= d) {
            BindingTitleBean value2 = ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().getValue();
            if (value2 != null) {
                value2.setTitleTextColor(zn1.a(R.color.color_002C3E50));
                value2.setBackground(zn1.a(R.color.color_00E6E8EC));
                value2.setBackTintColor(Integer.valueOf(zn1.a(R.color.white)));
                bindingTitleBean = value2;
            }
            ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().setValue(bindingTitleBean);
            e.p3(huodongDetailActivity).l3().T2(false).a1();
            return;
        }
        if (d5 >= d2 || d3 < d2) {
            return;
        }
        BindingTitleBean value3 = ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().getValue();
        if (value3 != null) {
            value3.setTitleTextColor(zn1.a(R.color.color_2C3E50));
            value3.setBackground(zn1.a(R.color.color_E6E8EC));
            value3.setBackTintColor(Integer.valueOf(zn1.a(R.color.black)));
            bindingTitleBean = value3;
        }
        ((HuodongDetailVM) ((BaseVmActivity) huodongDetailActivity).f8507a).y().setValue(bindingTitleBean);
        e.p3(huodongDetailActivity).l3().T2(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_huodong_detail), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityHuodongDetailBinding");
        n0();
        p0((ActivityHuodongDetailBinding) binding);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((HuodongDetailVM) ((BaseVmActivity) this).f8507a).i().observe(this, new c(new Function1<HuodongDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.huodong.HuodongDetailActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HuodongDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HuodongDetailBean huodongDetailBean) {
                ViewDataBinding binding = HuodongDetailActivity.this.getBinding();
                Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityHuodongDetailBinding");
                ShadowLayout shadowLayout = ((ActivityHuodongDetailBinding) binding).f13259a;
                Intrinsics.checkNotNullExpressionValue(shadowLayout, "binding.clContent");
                if (TextUtils.isEmpty(huodongDetailBean.getDetail().getActivityDescription()) && huodongDetailBean.getDetail().getImgsList().isEmpty()) {
                    shadowLayout.setVisibility(8);
                    return;
                }
                shadowLayout.setVisibility(0);
                int width = shadowLayout.getWidth();
                if (width == 0) {
                    return;
                }
                for (HuodongDetailImgs huodongDetailImgs : huodongDetailBean.getDetail().getImgsList()) {
                    double width2 = ((double) width) / ((((double) huodongDetailImgs.getWidth()) * 1.0d) / ((double) huodongDetailImgs.getHeight()));
                    ImageView imageView = new ImageView(HuodongDetailActivity.this);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(width, (int) width2));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    shadowLayout.addView(imageView);
                    Glide.with((FragmentActivity) HuodongDetailActivity.this).load(huodongDetailImgs.getUrl()).into(imageView);
                }
            }
        }));
    }

    public final void k0() {
        Intent intent = getIntent();
        if (intent != null) {
            HuodongDetailVM huodongDetailVM = (HuodongDetailVM) ((BaseVmActivity) this).f8507a;
            String stringExtra = intent.getStringExtra("activityCode");
            if (stringExtra == null) {
                stringExtra = "";
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, "getStringExtra(\"activityCode\") ?: \"\"");
            huodongDetailVM.j(stringExtra);
        }
    }

    /* JADX INFO: renamed from: l0, reason: from getter */
    public final double getScroll2titleB() {
        return this.scroll2titleB;
    }

    /* JADX INFO: renamed from: m0, reason: from getter */
    public final double getScroll2titleM() {
        return this.scroll2titleM;
    }

    public final void n0() {
        int iIntValue;
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Intent intent = getIntent();
        bindingTitleBean.setTitleName(intent != null ? intent.getStringExtra("title") : null);
        bindingTitleBean.setShowDivider(false);
        Integer value = ((BaseVM) ((HuodongDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.color_002C3E50));
        bindingTitleBean.setBackground(zn1.a(R.color.color_00E6E8EC));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(R.color.white)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.f34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuodongDetailActivity.o0(this.f41585a, view);
            }
        });
        e.p3(this).l3().T2(false).a1();
        ((HuodongDetailVM) ((BaseVmActivity) this).f8507a).y().setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(12);
        getWindow().requestFeature(13);
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        k0();
    }

    public final void p0(final ActivityHuodongDetailBinding binding) {
        binding.f13253a.post(new Runnable() { // from class: com.zj.adlib.d34
            @Override // java.lang.Runnable
            public final void run() {
                HuodongDetailActivity.q0(binding, this);
            }
        });
        binding.f13256a.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.zj.adlib.e34
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                HuodongDetailActivity.r0(this.f41335a, nestedScrollView, i, i2, i3, i4);
            }
        });
        binding.f13262a.setCountDownListener(new b());
    }

    public final void s0(double d) {
        this.scroll2titleB = d;
    }

    public final void t0(double d) {
        this.scroll2titleM = d;
    }
}
