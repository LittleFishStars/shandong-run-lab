package com.huachenjie.run.page.sun_run.success;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.gyf.immersionbar.e;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivitySchoolActivityRunSuccessBinding;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u000e\u0013B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0017R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/run/page/sun_run/success/SchoolActivitySuccessActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/base/data_binding/BaseTitleVM;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "onBackPressed", "", "a", "Lkotlin/Lazy;", "f0", "()J", SchoolActivitySuccessActivity.x, "b", "g0", "time", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public class SchoolActivitySuccessActivity extends BaseVmActivity<BaseTitleVM> implements AdCancelInterface {

    @NotNull
    public static final String x = "distance";

    @NotNull
    public static final String y = "time";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy distance = LazyKt.lazy(new Function0<Long>() { // from class: com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity$distance$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m714invoke() {
            return Long.valueOf(this.this$0.getIntent().getLongExtra(SchoolActivitySuccessActivity.x, 0L));
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy time = LazyKt.lazy(new Function0<Long>() { // from class: com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity$time$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m715invoke() {
            return Long.valueOf(this.this$0.getIntent().getLongExtra("time", 0L));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/sun_run/success/SchoolActivitySuccessActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/run/page/sun_run/success/SchoolActivitySuccessActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SchoolActivitySuccessActivity.this.finish();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.white).G1(true).a1();
    }

    public final long f0() {
        return ((Number) this.distance.getValue()).longValue();
    }

    public final long g0() {
        return ((Number) this.time.getValue()).longValue();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_activity_school_activity_run_success), Integer.valueOf(lk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        MutableLiveData<BindingTitleBean> mutableLiveData = ((BaseTitleVM) ((BaseVmActivity) this).f8507a).i;
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setBackShow(false);
        mutableLiveData.setValue(bindingTitleBean);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunActivitySchoolActivityRunSuccessBinding");
        RunActivitySchoolActivityRunSuccessBinding runActivitySchoolActivityRunSuccessBinding = (RunActivitySchoolActivityRunSuccessBinding) binding;
        runActivitySchoolActivityRunSuccessBinding.f11548a.setText(ll7.f43096a.i(Long.valueOf(f0()), true, true, 3));
        runActivitySchoolActivityRunSuccessBinding.d.setText(s72.o(g0(), true));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
    }
}
