package com.huachenjie.sport.page.mine.sport_test.time;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivitySportTestChooseTimeBinding;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.f)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002R\u0016\u0010\u0010\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "i0", "initData", "k0", "", "x", "Ljava/lang/String;", "testCode", "y", "yearCode", j.o, "dayCode", "A", "timeCode", "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestChooseTimeActivity extends BaseVmActivity<SportTestChooseTimeVM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = "testCode")
    @JvmField
    @NotNull
    public String testCode = "";

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Autowired(name = "yearCode")
    @JvmField
    @NotNull
    public String yearCode = "";

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    @Autowired(name = "dayCode")
    @JvmField
    @NotNull
    public String dayCode = "";

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    @Autowired(name = "timeCode")
    @JvmField
    @Nullable
    public String timeCode = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeActivity$a$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0828a extends DialogUtil.PositiveNegativeClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SportTestChooseTimeActivity f36739a;

            public C0828a(SportTestChooseTimeActivity sportTestChooseTimeActivity) {
                this.f36739a = sportTestChooseTimeActivity;
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void b() {
                ((SportTestChooseTimeVM) ((BaseVmActivity) this.f36739a).f8507a).D(this.f36739a.testCode);
            }
        }

        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestChooseTimeActivity sportTestChooseTimeActivity = SportTestChooseTimeActivity.this;
            DialogUtil.x(sportTestChooseTimeActivity, "确定预约之后，可以对预约进行修改，但不可取消", "确定", new C0828a(sportTestChooseTimeActivity));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36740a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36740a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36740a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36740a.invoke(obj);
        }
    }

    public static final void j0(SportTestChooseTimeActivity sportTestChooseTimeActivity, View view) {
        Intrinsics.checkNotNullParameter(sportTestChooseTimeActivity, "this$0");
        sportTestChooseTimeActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_sport_test_choose_time), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void i0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataR = ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).r();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("预约体测");
        int i = R.color.color_333333;
        bindingTitleBean.setTitleTextColor(zn1.a(i));
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(i)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.kn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestChooseTimeActivity.j0(this.f42865a, view);
            }
        });
        Integer value = ((BaseVM) ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value == null) {
            iIntValue = 24;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 24");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        mutableLiveDataR.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        i0();
        k0();
        initData();
    }

    public final void initData() {
        if (TextUtils.isEmpty(this.yearCode) || TextUtils.isEmpty(this.dayCode)) {
            fv5.b("数据异常");
            finish();
        } else {
            ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).B(this.yearCode);
            ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).w(this.dayCode);
            ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).z(this.timeCode);
            ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).v(this.testCode);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void k0() {
        ((SportTestChooseTimeVM) ((BaseVmActivity) this).f8507a).o().observe(this, new b(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity$observerData$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<String> list) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (String str : list) {
                    arrayList.add(SportTestChooseTimeFragment.Companion.a(i));
                    i++;
                }
                TimeVPAdapter timeVPAdapter = new TimeVPAdapter(arrayList, this.this$0);
                ViewDataBinding binding = this.this$0.getBinding();
                Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivitySportTestChooseTimeBinding");
                ActivitySportTestChooseTimeBinding activitySportTestChooseTimeBinding = (ActivitySportTestChooseTimeBinding) binding;
                activitySportTestChooseTimeBinding.f13328a.setAdapter(timeVPAdapter);
                activitySportTestChooseTimeBinding.f13329a.setViewPager(activitySportTestChooseTimeBinding.f13328a, list);
                activitySportTestChooseTimeBinding.f13329a.setCurrentTab(((SportTestChooseTimeVM) ((BaseVmActivity) this.this$0).f8507a).getYearIndex(), false);
            }
        }));
    }
}
