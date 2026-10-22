package com.huachenjie.shandong_school.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.bean.ThemeConfigBean;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.BottomIconView;
import com.huachenjie.home.page.draw.LotteryThemeConfigManager;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.mall.page.address.ShippingAddressActivity;
import com.huachenjie.mall.page.video_enter.VideoEnterActivity;
import com.huachenjie.mine.page.history.HistoryRecordActivity;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.databinding.ActivityHomeBinding;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fe9;
import com.zj.adlib.su9;
import com.zj.adlib.vs1;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = zj7.a.HOME)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002-<B\u0007¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010 \u001a\u00020\bH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0015J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0014J\b\u0010&\u001a\u00020\bH\u0016J\"\u0010*\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010!H\u0014J\b\u0010+\u001a\u00020\bH\u0014R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u00100R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u00103R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00100R!\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R!\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010=\u001a\u0004\bA\u0010?R!\u0010F\u001a\b\u0012\u0004\u0012\u00020C0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010=\u001a\u0004\bE\u0010?¨\u0006I"}, d2 = {"Lcom/huachenjie/shandong_school/home/HomeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/shandong_school/databinding/ActivityHomeBinding;", "Lcom/huachenjie/shandong_school/home/HomeVM;", "", "tabName", "", "m0", "", "s0", "Landroid/os/Bundle;", "savedInstanceState", "t0", "u0", "q0", "index", "E0", "v0", "l0", "", "showRedDot", "k0", "authAgreementCode", "z0", "w0", "x0", "y0", "", "", "V", "getLayoutResID", "onCreate", "initData", "Landroid/content/Intent;", "intent", "onNewIntent", "onBackPressed", "onResume", "W", RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "onDestroy", "Lcom/huachenjie/common/bean/AlertTip;", "a", "Lcom/huachenjie/common/bean/AlertTip;", yj7.a.ALERT_TIP, "Z", yj7.a.SHOULD_REFRESH_USER_INFO, "", "J", "lastPressedTime", "t", "Ljava/lang/String;", "mCurrentFragmentName", "c", "hasShowPrivacyUpdate", "", "Lcom/huachenjie/common/widget/BottomIconView;", "b", "Lkotlin/Lazy;", "n0", "()Ljava/util/List;", "mBottomIconViews", "o0", "mFragmentNames", "Landroidx/fragment/app/Fragment;", "d", bo.g, "mFragments", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeActivity.kt\ncom/huachenjie/shandong_school/home/HomeActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,642:1\n1864#2,3:643\n1855#2,2:647\n1864#2,3:649\n1#3:646\n*S KotlinDebug\n*F\n+ 1 HomeActivity.kt\ncom/huachenjie/shandong_school/home/HomeActivity\n*L\n221#1:643,3\n355#1:647,2\n378#1:649,3\n*E\n"})
public final class HomeActivity extends BaseMVVMActivity<ActivityHomeBinding, HomeVM> {

    @NotNull
    public static final String A = "LotteryDrawFragment";

    @NotNull
    public static final String B = "HomeMessageFragment";

    @NotNull
    public static final String C = "HomeMineFragment";
    public static final int K = 1001;

    @NotNull
    public static final String x = "key_current_fragment";

    @NotNull
    public static final String y = "HomeFragment";

    @NotNull
    public static final String z = "AlumniFragment";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long lastPressedTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = yj7.a.ALERT_TIP)
    @JvmField
    @Nullable
    public AlertTip alertTip;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = yj7.a.SHOULD_REFRESH_USER_INFO)
    @JvmField
    public boolean shouldRefreshUserInfo;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean hasShowPrivacyUpdate;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public String mCurrentFragmentName = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy mBottomIconViews = LazyKt.lazy(new Function0<List<? extends BottomIconView>>() { // from class: com.huachenjie.shandong_school.home.HomeActivity$mBottomIconViews$2
        {
            super(0);
        }

        @NotNull
        public final List<BottomIconView> invoke() {
            ThemeConfigBean themeConfigBeanD = LotteryThemeConfigManager.f9607a.d();
            HomeActivity.f0(this.this$0).f12625a.c.setIconBean(new BottomIconView.BottomIconBean(R.drawable.ic_home_home_normal, R.drawable.ic_home_home_checked, fe9.b.HOME));
            HomeActivity.f0(this.this$0).f12625a.f36041a.setIconBean(new BottomIconView.BottomIconBean(R.drawable.ic_home_alumni_normal, R.drawable.ic_home_alumni_checked, fe9.b.ALUMNI));
            BottomIconView bottomIconView = HomeActivity.f0(this.this$0).f12625a.b;
            String bottomNavText = themeConfigBeanD.getBottomNavText();
            if (StringsKt.isBlank(bottomNavText)) {
                bottomNavText = fe9.b.FLASH_COINS;
            }
            bottomIconView.setIconBean(new BottomIconView.BottomIconBean(R.drawable.ic_home_flash_coins_normal, R.drawable.ic_home_flash_coins_checked, bottomNavText));
            HomeActivity.f0(this.this$0).f12625a.d.setIconBean(new BottomIconView.BottomIconBean(R.drawable.ic_home_message_normal, R.drawable.ic_home_message_checked, fe9.b.MESSAGE));
            HomeActivity.f0(this.this$0).f12625a.e.setIconBean(new BottomIconView.BottomIconBean(R.drawable.ic_home_mine_normal, R.drawable.ic_home_mine_checked, fe9.b.MINE));
            return CollectionsKt.listOf(new BottomIconView[]{HomeActivity.f0(this.this$0).f12625a.c, HomeActivity.f0(this.this$0).f12625a.f36041a, HomeActivity.f0(this.this$0).f12625a.b, HomeActivity.f0(this.this$0).f12625a.d, HomeActivity.f0(this.this$0).f12625a.e});
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy mFragmentNames = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.huachenjie.shandong_school.home.HomeActivity$mFragmentNames$2
        @NotNull
        public final native List<String> invoke();
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy mFragments = LazyKt.lazy(new Function0<List<? extends BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseViewModel>>>() { // from class: com.huachenjie.shandong_school.home.HomeActivity$mFragments$2
        @NotNull
        public final native List<BaseMVVMFragment<? extends ViewDataBinding, ? extends BaseViewModel>> invoke();
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/shandong_school/home/HomeActivity$a;", "", "Landroid/view/View;", "view", "", "b", "i", y6b.g, "k", "d", y6b.f, "e", "c", "j", "a", "f", "<init>", "(Lcom/huachenjie/shandong_school/home/HomeActivity;)V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShippingAddressActivity.Companion bVar = ShippingAddressActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            bVar.b(context);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeActivity.f0(HomeActivity.this).f12624a.closeDrawers();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoEnterActivity.Companion aVar = VideoEnterActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            aVar.a(context, 0);
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeActivity.this.startActivity(new Intent(HomeActivity.this, (Class<?>) CustomerServiceCenterActivity.class));
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            HomeActivity.this.startActivity(new Intent(HomeActivity.this, (Class<?>) HistoryRecordActivity.class));
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.v(view.getContext(), Environment.c + "/#/mall/license");
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Sport.m).navigation();
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Compat.g).navigation(HomeActivity.this);
        }

        public final void i(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Compat.f).navigation(HomeActivity.this);
        }

        public final void j(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            VideoEnterActivity.Companion aVar = VideoEnterActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            aVar.a(context, 1);
        }

        public final void k(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.x(HomeActivity.this);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/shandong_school/home/HomeActivity$c", "Lcom/huachenjie/im/DefaultCallback;", "", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "onResult", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DefaultCallback<Object> {
        @Override // com.huachenjie.im.DefaultCallback
        public native void onResult(int code, @Nullable Object result, @Nullable Throwable exception);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36045a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36045a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36045a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36045a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.home.HomeActivity$initData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.shandong_school.home.HomeActivity$initData$1", f = "HomeActivity.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final native Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation);

        @Nullable
        public final native Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation);

        @Nullable
        public final native Object invokeSuspend(@NotNull Object obj);
    }

    /* JADX INFO: renamed from: com.huachenjie.shandong_school.home.HomeActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class C14751 extends Lambda implements Function0<Unit> {
        public C14751() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m749invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m749invoke() {
            vs1.f45437a.a(HomeActivity.this);
        }
    }

    public static final native void A0(HomeActivity homeActivity, String str, View view);

    public static final native void B0(View view);

    public static final native void C0(HomeActivity homeActivity, String str, View view);

    public static final native void D0(HomeActivity homeActivity, String str, View view);

    public static final /* synthetic */ ActivityHomeBinding f0(HomeActivity homeActivity) {
        return homeActivity.getMBinding();
    }

    public static final native void r0(HomeActivity homeActivity, int i, View view);

    public final native void E0(int index);

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public native Map<Integer, Object> V();

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public native void W();

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public native int getLayoutResID();

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public native void initData();

    public final native void k0(boolean showRedDot);

    public final native void l0();

    public final native int m0(String tabName);

    public final native List<BottomIconView> n0();

    public final native List<String> o0();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public native void onBackPressed();

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle savedInstanceState);

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public native void onDestroy();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public native void onNewIntent(@Nullable Intent intent);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public native void onResume();

    public final native List<Fragment> p0();

    public final native void q0(Bundle savedInstanceState);

    public final native void s0();

    public final native void t0(Bundle savedInstanceState);

    public final native void u0();

    public final native void v0(int index);

    public final native void w0();

    public final native void x0();

    public final native void y0();

    public final native void z0(String authAgreementCode);
}
