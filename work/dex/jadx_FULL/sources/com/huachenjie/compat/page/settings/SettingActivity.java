package com.huachenjie.compat.page.settings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.RxViewUtil;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.AccountManageActivity;
import com.huachenjie.compat.page.ad_report.AdReportActivity;
import com.huachenjie.compat.page.settings.SettingActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.ba1;
import com.zj.adlib.d60;
import com.zj.adlib.fo6;
import com.zj.adlib.fv5;
import com.zj.adlib.m25;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.g)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\u001e\u0010\"\u001a\u00020\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\b0\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0018\u00101\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010&R&\u00104\u001a\u0012\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00106¨\u0006:"}, d2 = {"Lcom/huachenjie/compat/page/settings/SettingActivity;", "Lcom/huachenjie/common/base/BaseActivity;", "Lcom/huachenjie/compat/page/settings/a;", "Lcom/huachenjie/compat/page/settings/SettingContact$PersonalView;", "", "F0", "Landroid/widget/LinearLayout;", "view", "", "yes", "B0", "(Landroid/widget/LinearLayout;Ljava/lang/Boolean;)V", "onResume", "h0", "", "a0", "Y", "b0", "U", "V", "initField", "s", "initPresenter", "initView", "getContentViewRes", "", "X", "Landroid/content/Intent;", "intent", "handleIntent", "getServerData", "", "", "map", y6b.g, "isOpen", t.d, "b", "Landroid/widget/LinearLayout;", "_llNotificaTV", "c", "_llLocationTV", "d", "_llPhotoTV", "e", "_llDeviceTV", "f", "_llPushRoot", y6b.f, "_llGiftRoot", "a", "Ljava/util/Map;", "mResult", "", "J", "cacheSize", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class SettingActivity extends BaseActivity<com.huachenjie.compat.page.settings.a> implements SettingContact.PersonalView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long cacheSize;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Map<String, Boolean> mResult;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llNotificaTV;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llLocationTV;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llPhotoTV;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llDeviceTV;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llPushRoot;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public LinearLayout _llGiftRoot;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/compat/page/settings/SettingActivity$a", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "", "onCheckedChanged", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
            if (((BaseActivity) SettingActivity.this).f8487a == null) {
                return;
            }
            ((com.huachenjie.compat.page.settings.a) ((BaseActivity) SettingActivity.this).f8487a).h(isChecked);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/compat/page/settings/SettingActivity$b", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "", "onCheckedChanged", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@Nullable CompoundButton buttonView, boolean isChecked) {
            if (((BaseActivity) SettingActivity.this).f8487a == null) {
                return;
            }
            ((com.huachenjie.compat.page.settings.a) ((BaseActivity) SettingActivity.this).f8487a).g(isChecked);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/compat/page/settings/SettingActivity$c", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogUtil.PositiveNegativeClickListener {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/settings/SettingActivity$c$a", "Lcom/alibaba/android/arouter/facade/callback/NavCallback;", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "onArrival", "compat_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends NavCallback {
            @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
            public void onArrival(@Nullable Postcard postcard) {
                ActivityLifecycleManager.l().j(zj7.f.LOGIN);
            }
        }

        public c() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
            m25.b(SettingActivity.this);
            ARouter.getInstance().build(zj7.f.LOGIN).addFlags(268468224).navigation(SettingActivity.this, new a());
        }
    }

    public static final void G0(Activity activity) {
        ba1.i(activity);
    }

    public static final void H0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void I0(SettingActivity settingActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        th.printStackTrace();
        settingActivity.dismissLoadingDialogs();
    }

    public static final Long J0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (Long) function1.invoke(obj);
    }

    public static final void K0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void L0(SettingActivity settingActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        th.printStackTrace();
        settingActivity.dismissLoadingDialogs();
    }

    public static final void M0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Map<String, Boolean> map = settingActivity.mResult;
        if (map != null ? Intrinsics.areEqual(map.get(Permission.ACCESS_NOTIFICATION_POLICY), Boolean.TRUE) : false) {
            PushSettingActivity.INSTANCE.a(settingActivity);
        } else {
            fo6.f41719a.d(settingActivity);
        }
    }

    public static final void N0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        fo6.f41719a.d(settingActivity);
    }

    public static final void O0() {
        ARouter.getInstance().build(RoutePathConstants.Compat.k).navigation();
    }

    public static final void P0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        fo6.f41719a.d(settingActivity);
    }

    public static final void Q0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        fo6.f41719a.d(settingActivity);
    }

    public static final void R0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        if (settingActivity.cacheSize == 0) {
            fv5.a(R.string.no_cache_prompt);
        } else {
            settingActivity.F0();
        }
    }

    public static final void S0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        DialogUtil.y(((BaseActivity) settingActivity).c, settingActivity.getString(R.string.logout_confirm), settingActivity.getString(R.string.cancel), settingActivity.getString(R.string.sure), settingActivity.new c());
    }

    public static final void T0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        AccountManageActivity.INSTANCE.a(settingActivity);
    }

    public static final void U0() {
        ARouter.getInstance().build(RoutePathConstants.Compat.h).navigation();
    }

    public static final void V0(SettingActivity settingActivity) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        AdReportActivity.INSTANCE.a(settingActivity);
    }

    public static final void W0() {
        ARouter.getInstance().build(RoutePathConstants.Compat.j).navigation();
    }

    public final void B0(LinearLayout view, Boolean yes) {
        if (view == null) {
            return;
        }
        View childAt = view.getChildAt(1);
        Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(1)");
        if (childAt instanceof Switch) {
            ((Switch) childAt).setChecked(yes != null ? yes.booleanValue() : false);
        } else if (childAt instanceof TextView) {
            if (Intrinsics.areEqual(Boolean.TRUE, yes)) {
                TextView textView = (TextView) childAt;
                textView.setText("已开启");
                textView.setTextColor(Color.parseColor("#191F20"));
            } else {
                TextView textView2 = (TextView) childAt;
                textView2.setText("未开启");
                textView2.setTextColor(Color.parseColor("#CCCCCC"));
            }
        }
        View childAt2 = view.getChildAt(0);
        if (childAt2 instanceof LinearLayout) {
            View childAt3 = ((LinearLayout) childAt2).getChildAt(1);
            if (!Intrinsics.areEqual(Boolean.TRUE, yes) || Intrinsics.areEqual(view, this._llPushRoot)) {
                if (childAt3 == null) {
                    return;
                }
                childAt3.setVisibility(0);
            } else {
                if (childAt3 == null) {
                    return;
                }
                childAt3.setVisibility(8);
            }
        }
    }

    public final void F0() {
        showLoadingDialog(((BaseActivity) this).c.getString(R.string.cache_clearing), false);
        Observable observableG3 = Observable.K2(((BaseActivity) this).c).J1(new Action1() { // from class: com.zj.adlib.f78
            public final void call(Object obj) {
                SettingActivity.G0((Activity) obj);
            }
        }).u5(Schedulers.io()).G3(d60.c());
        final Function1<Activity, Unit> function1 = new Function1<Activity, Unit>() { // from class: com.huachenjie.compat.page.settings.SettingActivity$clearCache$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Activity) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Activity activity) {
                long unused = this.this$0.cacheSize;
                fv5.a(R.string.cache_clear_finished);
                this.this$0.dismissLoadingDialogs();
            }
        };
        observableG3.s5(new Action1() { // from class: com.zj.adlib.g78
            public final void call(Object obj) {
                SettingActivity.H0(function1, obj);
            }
        }, new Action1() { // from class: com.zj.adlib.h78
            public final void call(Object obj) {
                SettingActivity.I0(this.f42066a, (Throwable) obj);
            }
        });
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back_black;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return Color.parseColor("#000000");
    }

    @Override // com.huachenjie.common.base.BaseActivity
    @NotNull
    public CharSequence X() {
        return "个人设置";
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int Y() {
        return R.color.white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int a0() {
        return R.color.color_2C3E50;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.activity_setting;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void getServerData() {
        showLoadingDialog(false);
        Observable observableK2 = Observable.K2(((BaseActivity) this).c);
        final AnonymousClass1 anonymousClass1 = new Function1<Activity, Long>() { // from class: com.huachenjie.compat.page.settings.SettingActivity.getServerData.1
            public final Long invoke(Activity activity) {
                return Long.valueOf(ba1.o(activity));
            }
        };
        Observable observableG3 = observableK2.a3(new Func1() { // from class: com.zj.adlib.c78
            public final Object call(Object obj) {
                return SettingActivity.J0(anonymousClass1, obj);
            }
        }).u5(Schedulers.io()).G3(d60.c());
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.huachenjie.compat.page.settings.SettingActivity.getServerData.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                SettingActivity settingActivity = SettingActivity.this;
                Intrinsics.checkNotNullExpressionValue(l, "size");
                settingActivity.cacheSize = l.longValue();
                SettingActivity.this.dismissLoadingDialogs();
            }
        };
        observableG3.s5(new Action1() { // from class: com.zj.adlib.d78
            public final void call(Object obj) {
                SettingActivity.K0(function1, obj);
            }
        }, new Action1() { // from class: com.zj.adlib.e78
            public final void call(Object obj) {
                SettingActivity.L0(this.f41363a, (Throwable) obj);
            }
        });
    }

    @Override // com.huachenjie.compat.page.settings.SettingContact.PersonalView
    public void h(@NotNull Map<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.mResult = map;
        B0(this._llNotificaTV, map.get(Permission.ACCESS_NOTIFICATION_POLICY));
        B0(this._llLocationTV, map.get("android.permission.ACCESS_COARSE_LOCATION"));
        B0(this._llPhotoTV, map.get(Permission.CAMERA));
        B0(this._llDeviceTV, map.get("android.permission.READ_PHONE_STATE"));
        B0(this._llPushRoot, Boolean.valueOf(Intrinsics.areEqual(map.get("featurePush"), Boolean.TRUE)));
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e eVarD3 = e.p3(this).d3(((BaseActivity) this).f8486a);
        int i = R.color.transparent;
        eVarD3.G2(i).T2(true).u1(i).G1(false).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(@Nullable Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        int i = R.id.ll_notification;
        this._llNotificaTV = (LinearLayout) findViewById(i);
        int i2 = R.id.ll_location;
        this._llLocationTV = (LinearLayout) findViewById(i2);
        int i3 = R.id.ll_photo_permision;
        this._llPhotoTV = (LinearLayout) findViewById(i3);
        int i4 = R.id.ll_device_permision;
        this._llDeviceTV = (LinearLayout) findViewById(i4);
        this._llPushRoot = (LinearLayout) findViewById(R.id.llFeaturePush);
        this._llGiftRoot = (LinearLayout) findViewById(R.id.llGiftRecommend);
        Switch r4 = (Switch) findViewById(R.id.switcher);
        if (r4 != null) {
            r4.setOnCheckedChangeListener(new a());
        }
        Switch r5 = (Switch) findViewById(R.id.gift_switcher);
        if (r5 != null) {
            r5.setOnCheckedChangeListener(new b());
        }
        RxViewUtil.f(findViewById(i), 0L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.a78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.M0(this.f40466a);
            }
        });
        RxViewUtil.f(findViewById(i2), 0L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.j78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.N0(this.f42524a);
            }
        });
        RxViewUtil.f(findViewById(i3), 0L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.k78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.P0(this.f42755a);
            }
        });
        RxViewUtil.f(findViewById(i4), 0L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.l78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.Q0(this.f43012a);
            }
        });
        RxViewUtil.f(findViewById(R.id.tv_clear_cache), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.m78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.R0(this.f43241a);
            }
        });
        RxViewUtil.f(findViewById(R.id.btnLogout), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.n78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.S0(this.f43466a);
            }
        });
        RxViewUtil.f(findViewById(R.id.tv_account_info), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.o78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.T0(this.f43685a);
            }
        });
        RxViewUtil.f(findViewById(R.id.tv_change_password), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.p78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.U0();
            }
        });
        int i5 = R.id.tv_ad_report;
        ((TextView) findViewById(i5)).setVisibility(ai9.m() ? 0 : 8);
        RxViewUtil.f(findViewById(i5), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.q78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.V0(this.f44144a);
            }
        });
        RxViewUtil.f(findViewById(R.id.tv_about_as), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.b78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.W0();
            }
        });
        RxViewUtil.f(findViewById(R.id.tv_user_info), 1000L, new RxViewUtil.ClickAction() { // from class: com.zj.adlib.i78
            @Override // com.huachenjie.common.util.RxViewUtil.ClickAction
            public final void onClick() {
                SettingActivity.O0();
            }
        });
    }

    @Override // com.huachenjie.compat.page.settings.SettingContact.PersonalView
    public void l(boolean isOpen) {
        B0(this._llGiftRoot, Boolean.valueOf(isOpen));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((com.huachenjie.compat.page.settings.a) ((BaseActivity) this).f8487a).f(this);
    }

    @Override // com.huachenjie.common.base.BaseActivity, com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return false;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    @NotNull
    public com.huachenjie.compat.page.settings.a initPresenter() {
        return new com.huachenjie.compat.page.settings.a();
    }
}
