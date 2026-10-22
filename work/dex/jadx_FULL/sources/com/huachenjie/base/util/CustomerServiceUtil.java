package com.huachenjie.base.util;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.alibaba.android.arouter.launcher.ARouter;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.dialog.CustomerServiceCenterDialog;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.dq1;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.r57;
import com.zj.adlib.r90;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/base/util/CustomerServiceUtil;", "", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "", y6b.f, "Landroidx/fragment/app/Fragment;", "fragment", "f", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/app/Activity;", y6b.g, "d", "Lcom/huachenjie/common/bean/CustomerServerStatusData;", "data", "e", "j", "", "url", "i", "a", "Ljava/lang/String;", "DEFAULT_SERVICE_WECHAT", "b", "TITLE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class CustomerServiceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CustomerServiceUtil f32958a = new CustomerServiceUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String DEFAULT_SERVICE_WECHAT = "18058783110";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String TITLE = "人工客服";

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(Activity activity) {
        CustomerServerStatusData customerServerStatusDataH = r90.h();
        if (customerServerStatusDataH != null) {
            e(activity, customerServerStatusDataH);
            return;
        }
        LifecycleOwner lifecycleOwner = activity instanceof LifecycleOwner ? (LifecycleOwner) activity : null;
        if (lifecycleOwner == null) {
            j(activity);
        } else {
            v41.e(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new CustomerServiceUtil$consultOfficial$1(activity, null), 3, (Object) null);
        }
    }

    public final void e(Activity activity, CustomerServerStatusData data) {
        if (!(data != null ? Intrinsics.areEqual(data.getCustomerStatus(), Boolean.TRUE) : false)) {
            j(activity);
        } else if (TextUtils.isEmpty(data.getUrl())) {
            r57.c(activity);
        } else {
            i(data.getUrl());
        }
    }

    public final void f(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "fragment.requireActivity()");
        h(childFragmentManager, fragmentActivityRequireActivity);
    }

    public final void g(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        h(supportFragmentManager, activity);
    }

    public final void h(@NotNull FragmentManager fragmentManager, @NotNull final Activity activity) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        CommonSwitchConfig commonSwitchConfigD = dq1.d();
        boolean z = false;
        if (commonSwitchConfigD != null && commonSwitchConfigD.getDedicatedSupportSwitch()) {
            z = true;
        }
        if (z) {
            CustomerServiceCenterDialog.INSTANCE.a(fragmentManager, new Function0<Unit>() { // from class: com.huachenjie.base.util.CustomerServiceUtil$open$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m227invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m227invoke() {
                    CustomerServiceUtil.f32958a.d(activity);
                }
            });
        } else {
            d(activity);
        }
    }

    public final void i(String url) {
        if (TextUtils.isEmpty(url)) {
            fv5.b("加载失败，稍后再试试");
        } else {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", TITLE).withString("url", url).navigation();
        }
    }

    public final void j(Activity activity) {
        String serviceWechat = r90.g().getServiceWechat();
        if (serviceWechat == null) {
            serviceWechat = DEFAULT_SERVICE_WECHAT;
        }
        gm1.c("Label", serviceWechat);
        DialogUtil.s(TITLE, "已复制微信号" + serviceWechat + "，请添加客服微信", "OK", null).create(activity);
    }
}
