package com.huachenjie.shandong_school.splash;

import android.app.Application;
import androidx.coroutines.ViewDataBinding;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.shandong_school.R;
import com.zj.adlib.ai9;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0004J\b\u0010\u000e\u001a\u00020\nH\u0017¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/shandong_school/splash/BaseWidgetTempActivity;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "", "", "", "getLayoutResID", "", "initView", "", "checkAppState", "onBackPressed", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public class BaseWidgetTempActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseMVVMActivity<V, VM> {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/shandong_school/splash/BaseWidgetTempActivity$a", "Lcom/alibaba/android/arouter/facade/callback/NavCallback;", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "onArrival", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a extends NavCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseWidgetTempActivity<V, VM> f36050a;

        public a(BaseWidgetTempActivity<V, VM> baseWidgetTempActivity) {
            this.f36050a = baseWidgetTempActivity;
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onArrival(@NotNull Postcard postcard) {
            Intrinsics.checkNotNullParameter(postcard, "postcard");
            this.f36050a.finish();
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return null;
    }

    public final boolean checkAppState() {
        if (ai9.l()) {
            return true;
        }
        ARouter.getInstance().build(zj7.f.LOGIN).navigation(this, new a(this));
        return false;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ThirdUtil thirdUtil = ThirdUtil.f7255a;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        thirdUtil.h(application);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
    }
}
