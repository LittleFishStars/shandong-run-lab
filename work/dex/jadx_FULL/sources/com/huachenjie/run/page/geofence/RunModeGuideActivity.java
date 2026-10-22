package com.huachenjie.run.page.geofence;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityRunModeGuideBinding;
import com.huachenjie.run.page.geofence.RunModeGuideActivity;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u000eB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u001b\u0010\f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/page/geofence/RunModeGuideActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityRunModeGuideBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "", "mode", "c0", "b", "Lkotlin/Lazy;", "a0", "()Ljava/lang/String;", "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunModeGuideActivity extends BaseMVVMActivity<RunActivityRunModeGuideBinding, BaseTitleViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "modeString";

    @NotNull
    public static final String x = "mode_free.json";

    @NotNull
    public static final String y = "mode_in_order.json";

    @NotNull
    public static final String z = "mode_in_order_always_show.json";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy mode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.geofence.RunModeGuideActivity$mode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(RunModeGuideActivity.t);
            return stringExtra == null ? RunModeGuideActivity.z : stringExtra;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/geofence/RunModeGuideActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/page/geofence/RunModeGuideActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            RunModeGuideActivity.this.finish();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.geofence.RunModeGuideActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/page/geofence/RunModeGuideActivity$b;", "", "Landroid/content/Context;", "context", "", "mode", "", "a", "EXTRA_MODE", "Ljava/lang/String;", "MODE_FREE", "MODE_IN_ORDER", "MODE_IN_ORDER_ALWAYS_SHOW", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String mode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent(context, (Class<?>) RunModeGuideActivity.class);
            intent.putExtra(RunModeGuideActivity.t, mode);
            context.startActivity(intent);
        }
    }

    public static final void b0(RunModeGuideActivity runModeGuideActivity, View view) {
        Intrinsics.checkNotNullParameter(runModeGuideActivity, "this$0");
        runModeGuideActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    public final String a0() {
        return (String) this.mode.getValue();
    }

    public final String c0(String mode) {
        int iHashCode = mode.hashCode();
        if (iHashCode != -1695678138) {
            if (iHashCode != -527304818) {
                if (iHashCode == 423435416 && mode.equals(z)) {
                    return "顺序打卡模式";
                }
            } else if (mode.equals(x)) {
                return "自由打卡模式";
            }
        } else if (mode.equals(y)) {
            return "随机打卡模式";
        }
        return "";
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_run_mode_guide;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean statusBarHeight = bindingTitleBean.setStatusBarHeight(value.intValue());
        String strA0 = a0();
        Intrinsics.checkNotNullExpressionValue(strA0, "mode");
        mutableLiveDataI.setValue(statusBarHeight.setTitleName(c0(strA0)).setTitleTextColor(zn1.a(R.color.color_191F20)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.jm7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunModeGuideActivity.b0(this.f42618a, view);
            }
        }));
        if (CollectionsKt.listOf(new String[]{x, y, z}).contains(a0())) {
            LottieAnimationView lottieAnimationView = getMBinding().f35488a;
            lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lottieAnimationView.setAnimation(a0());
            lottieAnimationView.setRepeatMode(1);
            lottieAnimationView.setRepeatCount(Integer.MAX_VALUE);
            lottieAnimationView.playAnimation();
        }
    }
}
