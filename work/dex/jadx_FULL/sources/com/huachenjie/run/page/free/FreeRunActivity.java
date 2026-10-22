package com.huachenjie.run.page.free;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.video.AudioStats;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.map.GPSSignalCompoonent;
import com.huachenjie.common.map.NoBgGPSSignalComponent;
import com.huachenjie.common.run_component.StepComponent;
import com.huachenjie.common.service.LocationService;
import com.huachenjie.common.service.StepService;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.util.PopupWindowManager;
import com.huachenjie.common.widget.BackgroundChronometer;
import com.huachenjie.common.widget.CircleProgressButton;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.common.widget.ShrinkScrollView;
import com.huachenjie.common.widget.UserPausePopupWindow;
import com.huachenjie.run.ICountDown;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.RunData;
import com.huachenjie.run.bean.SensorStepRecord;
import com.huachenjie.run.bean.SubDistanceRecord;
import com.huachenjie.run.page.RunCountDownFragment;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.c82;
import com.zj.adlib.d60;
import com.zj.adlib.dn6;
import com.zj.adlib.ex7;
import com.zj.adlib.fv5;
import com.zj.adlib.jg3;
import com.zj.adlib.jj8;
import com.zj.adlib.jn3;
import com.zj.adlib.kh3;
import com.zj.adlib.nl8;
import com.zj.adlib.pm9;
import com.zj.adlib.r90;
import com.zj.adlib.s72;
import com.zj.adlib.t26;
import com.zj.adlib.tw0;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.e)
public class FreeRunActivity extends BaseActivity<com.huachenjie.run.page.free.a> implements FreeRunContact.FreeRunView, CaocaoOnMapLoadedListener, HCJMapFragment.OrientationChangeListener, ICountDown, View.OnClickListener, AdCancelInterface {
    public static final String A = "targetCalories";
    public static final long l = 200;
    public static final String x = "runRecordCode";
    public static final String y = "targetDistance";
    public static final String z = "targetDuration";
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f35802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ObjectAnimator f12385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f12387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f12388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f12389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f12390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GPSSignalCompoonent f12391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NoBgGPSSignalComponent f12392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StepService f12393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BackgroundChronometer f12394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CircleProgressButton f12395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShadowLayout f12396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShrinkScrollView f12397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public UserPausePopupWindow f12398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RunData f12399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SensorStepRecord f12400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SubDistanceRecord f12401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r f12402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s f12403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dn6 f12404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jn3 f12405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJMapFragment f12406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJMapAdapter f12407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJAddressInfo f12408a;
    public ObjectAnimator b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public FrameLayout f12409b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LinearLayout f12410b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RelativeLayout f12411b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public BackgroundChronometer f12412b;
    public ObjectAnimator c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public FrameLayout f12413c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LinearLayout f12414c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public RelativeLayout f12415c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<HCJLatLng> f12416c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f12417c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ObjectAnimator f12418d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public List<IntervalPace> f12419d;
    public long e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public List<IntervalStep> f12420e;
    public long f;
    public long j;
    public ImageView o;
    public ImageView p;
    public ImageView q;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public boolean f12424q;
    public String t;
    public long g = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ServiceConnection f12386a = new i();

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f12421g = false;
    public boolean h = false;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f12422j = false;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public boolean f12423p = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FreeRunActivity.this.f12418d.start();
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            FreeRunActivity.this.f12414c.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            FreeRunActivity.this.f12410b.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FreeRunActivity.this.b.start();
        }
    }

    public class e extends DialogUtil.PositiveNegativeClickListener {
        public e() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            super.a();
            FreeRunActivity.this.U0(false, true, false);
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
        }
    }

    public class f extends DialogUtil.PositiveNegativeClickListener {
        public f() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            super.a();
            FreeRunActivity.this.U0(false, true, false);
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
        }
    }

    public class g extends DialogUtil.PositiveNegativeClickListener {
        public g() {
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void a() {
            super.a();
            FreeRunActivity.this.U0(false, false, false);
        }

        @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
        public void b() {
        }
    }

    public class h implements AMap.OnMapScreenShotListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f35810a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f12426a;

        public class a implements Action1<File> {
            public a() {
            }

            public void call(File file) {
                FreeRunActivity.this.dismissLoadingDialogs();
                h hVar = h.this;
                FreeRunActivity.this.v(hVar.f12426a, hVar.f35810a);
            }
        }

        public class b implements Action1<Throwable> {
            public b() {
            }

            public void call(Throwable throwable) {
                throwable.printStackTrace();
                FreeRunActivity.this.dismissLoadingDialogs();
                h hVar = h.this;
                FreeRunActivity.this.v(hVar.f12426a, hVar.f35810a);
            }
        }

        public class c implements Func1<File, Boolean> {
            public c() {
            }

            public Boolean call(File file) {
                return Boolean.valueOf(file != null);
            }
        }

        public class d implements Func1<Bitmap, File> {
            public d() {
            }

            public File call(Bitmap bitmap) {
                return tw0.h(bitmap, 131072L, jg3.f42579a.f(((BaseActivity) FreeRunActivity.this).c).getAbsolutePath(), "thumb_" + System.currentTimeMillis() + FileTypes.F);
            }
        }

        public class e implements Func1<Bitmap, Bitmap> {
            public e() {
            }

            public Bitmap call(Bitmap bitmap) {
                return ex7.a(bitmap, Math.min(bitmap.getWidth(), bitmap.getHeight()), Math.min(bitmap.getWidth(), bitmap.getHeight()));
            }
        }

        public h(final boolean val$isValid, final int val$inspirationValue) {
            this.f12426a = val$isValid;
            this.f35810a = val$inspirationValue;
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap) {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap, int status) {
            if (bitmap == null) {
                FreeRunActivity.this.dismissLoadingDialogs();
                FreeRunActivity.this.v(this.f12426a, this.f35810a);
                return;
            }
            try {
                Observable.K2(bitmap).a3(new e()).a3(new d()).T1(new c()).u5(Schedulers.io()).G3(d60.c()).s5(new a(), new b());
            } catch (Exception e2) {
                e2.printStackTrace();
                FreeRunActivity.this.v(this.f12426a, this.f35810a);
            }
        }
    }

    public class i implements ServiceConnection {
        public i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            FreeRunActivity.this.f12399a.setTotalStep(i);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            FreeRunActivity.this.f12393a = ((StepService.StepBinder) service).getService();
            FreeRunActivity.this.f12393a.registerCallback(new StepComponent.StepChangeCallBack() { // from class: com.zj.adlib.xm3
                @Override // com.huachenjie.common.run_component.StepComponent.StepChangeCallBack
                public final void a(int i) {
                    this.f45851a.b(i);
                }
            });
            FreeRunActivity.this.f12393a.resumeStep();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 28)
        public void onClick(View v) {
            FreeRunActivity.this.f12411b.setVisibility(8);
            FreeRunActivity.this.f12390a.setVisibility(0);
            FreeRunActivity.this.f12391a.d();
            FreeRunActivity.this.f12423p = false;
            FreeRunActivity.this.g1();
        }
    }

    public class k implements PopupWindowManager.OnPopupListener {
        public k() {
        }

        @Override // com.huachenjie.common.util.PopupWindowManager.OnPopupListener
        public void a() {
        }

        @Override // com.huachenjie.common.util.PopupWindowManager.OnPopupListener
        public void onClose() {
            FreeRunActivity.this.f12424q = true;
        }

        @Override // com.huachenjie.common.util.PopupWindowManager.OnPopupListener
        public void onDismiss() {
        }
    }

    public class l implements CircleProgressButton.CircleProcessListener {
        public l() {
        }

        @Override // com.huachenjie.common.widget.CircleProgressButton.CircleProcessListener
        public void onCancel() {
        }

        @Override // com.huachenjie.common.widget.CircleProgressButton.CircleProcessListener
        public void onCancelOk() {
        }

        @Override // com.huachenjie.common.widget.CircleProgressButton.CircleProcessListener
        public void onFinished(float angle) {
            FreeRunActivity.this.i1();
        }

        @Override // com.huachenjie.common.widget.CircleProgressButton.CircleProcessListener
        public void onReStart() {
        }
    }

    public class m implements ShrinkScrollView.ShrinkScrollListener {
        public m() {
        }

        @Override // com.huachenjie.common.widget.ShrinkScrollView.ShrinkScrollListener
        public void onCancel() {
        }

        @Override // com.huachenjie.common.widget.ShrinkScrollView.ShrinkScrollListener
        public void onFinish() {
            FreeRunActivity.this.f12413c.setVisibility(8);
            FreeRunActivity.this.f12410b.setVisibility(0);
        }
    }

    public class n implements BackgroundChronometer.OnChronometerTickListener {
        public n() {
        }

        @Override // com.huachenjie.common.widget.BackgroundChronometer.OnChronometerTickListener
        public void onChronometerTick(BackgroundChronometer chronometer) {
            FreeRunActivity.this.f = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            FreeRunActivity.this.d1();
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FreeRunActivity.this.startForegroundService(new Intent(((BaseActivity) FreeRunActivity.this).c, (Class<?>) LocationService.class));
            Intent intent = new Intent(((BaseActivity) FreeRunActivity.this).c, (Class<?>) StepService.class);
            FreeRunActivity freeRunActivity = FreeRunActivity.this;
            freeRunActivity.h = freeRunActivity.bindService(intent, freeRunActivity.f12386a, 1);
        }
    }

    public class p implements Animator.AnimatorListener {
        public p() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            FreeRunActivity.this.f12410b.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public class q implements Animator.AnimatorListener {
        public q() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            FreeRunActivity.this.f12414c.setVisibility(0);
            if (FreeRunActivity.this.f12424q) {
                return;
            }
            FreeRunActivity.this.f12398a.setLastedDuration(FreeRunActivity.this.j);
            FreeRunActivity.this.f12398a.showAsDropDown(FreeRunActivity.this.f12396a, -jj8.a(49.0f), -jj8.a(145.0f));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    public static class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<FreeRunActivity> f35825a;

        public r(FreeRunActivity activity) {
            if (activity != null) {
                this.f35825a = new WeakReference<>(activity);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FreeRunActivity freeRunActivity;
            WeakReference<FreeRunActivity> weakReference = this.f35825a;
            if (weakReference == null || (freeRunActivity = weakReference.get()) == null || freeRunActivity.isFinishing()) {
                return;
            }
            freeRunActivity.a1();
        }
    }

    public static class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<FreeRunActivity> f35826a;

        public s(FreeRunActivity activity) {
            if (activity != null) {
                this.f35826a = new WeakReference<>(activity);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FreeRunActivity freeRunActivity;
            WeakReference<FreeRunActivity> weakReference = this.f35826a;
            if (weakReference == null || (freeRunActivity = weakReference.get()) == null || freeRunActivity.isFinishing()) {
                return;
            }
            freeRunActivity.q1();
        }
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void A(boolean isAuto, boolean isDataError, boolean isValid, int inspirationValue) {
        if (!isDataError) {
            S0(isValid, inspirationValue);
            return;
        }
        if (isAuto) {
            EventBus.f().q(new kh3());
        }
        finish();
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void B(List<IntervalPace> paceList) {
        if (this.f12419d == null) {
            this.f12419d = new ArrayList();
        }
        this.f12419d.addAll(0, paceList);
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void D(List<IntervalStep> stepList) {
        if (this.f12420e == null) {
            this.f12420e = new ArrayList();
        }
        this.f12420e.addAll(0, stepList);
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void G() {
    }

    public final void N0(HCJLatLng latLng) {
        if (this.f12416c == null) {
            this.f12416c = new ArrayList();
        }
        this.f12416c.add(latLng);
    }

    public final void O0() {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.f12399a.getDistance() < 100) {
            z3 = true;
            z2 = false;
        } else {
            z2 = true;
            z3 = false;
        }
        if (this.f < 30) {
            z3 = true;
            z2 = false;
        }
        long jLongValue = BigDecimal.valueOf(ai9.e().getSex() == 2 ? 65L : 53L).multiply(BigDecimal.valueOf(this.f12399a.getDistance())).multiply(BigDecimal.valueOf(1.036d)).setScale(0, RoundingMode.HALF_UP).longValue();
        if (this.f35802a <= 0 || this.f12399a.getDistance() >= this.f35802a) {
            long j2 = this.d;
            if (j2 <= 0 || this.f >= j2) {
                long j3 = this.e;
                if (j3 <= 0 || jLongValue >= j3) {
                    z4 = z2;
                }
            }
        }
        U0(true, z3, z4);
    }

    public final boolean P0(long caloriesValue) {
        return W0() && caloriesValue >= this.e;
    }

    public final boolean Q0(long distanceMeter) {
        return X0() && distanceMeter >= this.f35802a;
    }

    public final boolean R0() {
        return Y0() && this.f >= this.d;
    }

    public final void S0(boolean isValid, int inspirationValue) {
        if (((BaseActivity) this).c.isFinishing() || ((BaseActivity) this).c.isDestroyed() || this.f12406a.getMap() == null) {
            return;
        }
        showLoadingDialog(false);
        ((AMap) this.f12406a.getMap().getReal()).getMapScreenShot(new h(isValid, inspirationValue));
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public View.OnClickListener T() {
        return new j();
    }

    public final HCJAddressInfo T0(HCJAddressInfo addressInfo) {
        HCJAddressInfo hCJAddressInfo;
        if (addressInfo.getSpeed() >= 0.0f || (hCJAddressInfo = this.f12408a) == null || hCJAddressInfo.getSpeed() >= 0.0f) {
            return addressInfo;
        }
        return null;
    }

    public final void U0(boolean isAuto, boolean isDataError, boolean isValid) {
        this.f12405a.L(jj8.a(50.0f));
        ((com.huachenjie.run.page.free.a) ((BaseActivity) this).f8487a).f(isAuto, isDataError, V0(), isValid);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return zn1.a(R.color.black);
    }

    public final Map<String, Object> V0() {
        HashMap map = new HashMap();
        map.put("runRecordCode", this.t);
        map.put("duration", String.valueOf(this.f));
        map.put(SchoolActivitySuccessActivity.x, String.valueOf(this.f12399a.getDistance()));
        map.put("totalStep", String.valueOf(Math.max(0, this.f12399a.getTotalStep())));
        List<HCJLatLng> list = this.f12416c;
        if (list != null && !list.isEmpty()) {
            map.put("pois", this.f12416c);
        }
        e1();
        List<IntervalStep> list2 = this.f12420e;
        if (list2 != null && !list2.isEmpty()) {
            map.put("stepList", this.f12420e);
        }
        map.put("stepInterval", Integer.valueOf(r90.g().getStepInterval()));
        c1(this.f12399a.getDistance());
        List<IntervalPace> list3 = this.f12419d;
        if (list3 != null && !list3.isEmpty()) {
            map.put("paceList", this.f12419d);
        }
        map.put("paceInterval", Long.valueOf(r90.g().getPaceInterval()));
        if (Z0()) {
            map.put("status", Integer.valueOf(this.f12421g ? 2 : 1));
        }
        return map;
    }

    public final boolean W0() {
        return this.e > 0;
    }

    public final boolean X0() {
        return this.f35802a > 0;
    }

    public final boolean Y0() {
        return this.d > 0;
    }

    public final boolean Z0() {
        return X0() || Y0() || W0();
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void a(List<HCJLatLng> pathList) {
        if (this.f12416c == null) {
            this.f12416c = new ArrayList();
        }
        this.f12416c.addAll(0, pathList);
    }

    public final void a1() {
        t26 t26Var = t26.f44833a;
        Activity activity = ((BaseActivity) this).c;
        t26Var.e(activity, 1236, activity.getString(R.string.hcj_app_name), ((BaseActivity) this).c.getString(R.string.run_auto_stop_notification_content), null);
        O0();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.transparent;
    }

    public final void b1(long distance) {
        if (this.f12401a == null) {
            this.f12401a = new SubDistanceRecord();
        }
        long lastCalDistance = distance - this.f12401a.getLastCalDistance();
        long lastCalPaceTime = this.f - this.f12401a.getLastCalPaceTime();
        long lastUploadDistance = distance - this.f12401a.getLastUploadDistance();
        if (lastCalDistance >= r90.g().getPaceInterval()) {
            SubDistanceRecord subDistanceRecord = this.f12401a;
            subDistanceRecord.setCalTimes(subDistanceRecord.getCalTimes() + 1);
            this.f12401a.setLastCalPaceTime(this.f);
            this.f12401a.setLastCalDistance(distance);
            if (this.f12419d == null) {
                this.f12419d = new ArrayList();
            }
            this.f12419d.add(new IntervalPace(lastCalPaceTime, lastCalDistance));
        }
        if (lastUploadDistance < 200 || this.f12399a.getDistance() >= 50000) {
            return;
        }
        this.f12401a.setLastUploadDistance(distance);
        o1();
    }

    public final void c1(long distance) {
        if (this.f12401a == null) {
            this.f12401a = new SubDistanceRecord();
        }
        long lastCalDistance = distance - this.f12401a.getLastCalDistance();
        long lastCalPaceTime = this.f - this.f12401a.getLastCalPaceTime();
        if (lastCalDistance <= 0 || lastCalPaceTime <= 0) {
            return;
        }
        SubDistanceRecord subDistanceRecord = this.f12401a;
        subDistanceRecord.setCalTimes(subDistanceRecord.getCalTimes() + 1);
        this.f12401a.setLastCalPaceTime(this.f);
        this.f12401a.setLastCalDistance(distance);
        if (this.f12419d == null) {
            this.f12419d = new ArrayList();
        }
        this.f12419d.add(new IntervalPace(lastCalPaceTime, lastCalDistance));
    }

    public final void d1() {
        if (this.f12400a == null) {
            this.f12400a = new SensorStepRecord();
        }
        long lastRecordTime = this.f - this.f12400a.getLastRecordTime();
        int totalStep = this.f12399a.getTotalStep() - this.f12400a.getLastRecordStep();
        if (lastRecordTime >= r90.g().getStepInterval()) {
            this.f12400a.setLastRecordTime(this.f);
            this.f12400a.setLastRecordStep(this.f12399a.getTotalStep());
            if (this.f12420e == null) {
                this.f12420e = new ArrayList();
            }
            this.f12420e.add(new IntervalStep(lastRecordTime, totalStep));
        }
        long j2 = this.f;
        if (j2 < 60 || j2 % 60 != 0) {
            return;
        }
        p1();
    }

    public final void e1() {
        if (this.f12400a == null) {
            this.f12400a = new SensorStepRecord();
        }
        long lastRecordTime = this.f - this.f12400a.getLastRecordTime();
        int totalStep = this.f12399a.getTotalStep() - this.f12400a.getLastRecordStep();
        if (lastRecordTime <= 0 || totalStep <= 0) {
            return;
        }
        this.f12400a.setLastRecordTime(this.f);
        this.f12400a.setLastRecordStep(this.f12399a.getTotalStep());
        if (this.f12420e == null) {
            this.f12420e = new ArrayList();
        }
        this.f12420e.add(new IntervalStep(lastRecordTime, totalStep));
    }

    public final void f1() {
        com.gyf.immersionbar.e.p3(this).d3(((BaseActivity) this).f8486a).T2(true).k3().G1(true).a1();
    }

    public final void g1() {
        com.gyf.immersionbar.e.p3(this).d3(((BaseActivity) this).f8486a).T2(false).k3().G1(false).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.run_activity_free_run;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        g1();
    }

    public final void h1() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f12394a.setBase(jElapsedRealtime);
        this.f12412b.setBase(jElapsedRealtime);
        this.f12394a.start();
        this.f12412b.start();
        this.f12394a.setOnChronometerTickListener(new n());
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
        this.t = intent.getStringExtra("runRecordCode");
        this.f35802a = intent.getLongExtra(y, 0L);
        this.d = intent.getLongExtra(z, 0L);
        this.e = intent.getLongExtra(A, 0L);
        this.f12399a.setRunRecordCode(this.t);
    }

    @Override // com.huachenjie.run.ICountDown
    public void i(Fragment fragment) {
        if (fragment == null || !fragment.isAdded()) {
            return;
        }
        getSupportFragmentManager().beginTransaction().remove(fragment).commitNowAllowingStateLoss();
        h1();
    }

    public final void i1() {
        if (this.f12399a.getDistance() < 100) {
            Activity activity = ((BaseActivity) this).c;
            DialogUtil.B(activity, activity.getString(R.string.run_distance_too_short_title), ((BaseActivity) this).c.getString(R.string.run_distance_too_short_content), ((BaseActivity) this).c.getString(R.string.run_confirm_to_finish), ((BaseActivity) this).c.getString(R.string.run_continue_to_run), true, true, new e());
            return;
        }
        if (this.f < 30) {
            Activity activity2 = ((BaseActivity) this).c;
            DialogUtil.B(activity2, activity2.getString(R.string.run_duration_too_short_title), ((BaseActivity) this).c.getString(R.string.run_duration_too_short_content), ((BaseActivity) this).c.getString(R.string.run_confirm_to_finish), ((BaseActivity) this).c.getString(R.string.run_continue_to_run), true, true, new f());
            return;
        }
        long jLongValue = BigDecimal.valueOf(ai9.e().getSex() == 2 ? 65L : 53L).multiply(BigDecimal.valueOf(this.f12399a.getDistance())).multiply(BigDecimal.valueOf(1.036d)).setScale(0, RoundingMode.HALF_UP).longValue();
        if (this.f35802a <= 0 || this.f12399a.getDistance() >= this.f35802a) {
            long j2 = this.d;
            if (j2 <= 0 || this.f >= j2) {
                long j3 = this.e;
                if (j3 <= 0 || jLongValue >= j3) {
                    U0(false, false, true);
                    return;
                }
            }
        }
        Activity activity3 = ((BaseActivity) this).c;
        DialogUtil.B(activity3, "", activity3.getString(R.string.run_not_completed_prompt), ((BaseActivity) this).c.getString(R.string.run_confirm_to_finish), ((BaseActivity) this).c.getString(R.string.run_continue_to_run), true, true, new g());
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f12387a = new Handler(getMainLooper());
        this.f12407a = HCJMapEntry.getInstance();
        this.f12391a = new GPSSignalCompoonent(this);
        this.f12392a = new NoBgGPSSignalComponent(this);
        this.f12402a = new r(this);
        this.f12403a = new s(this);
        RunData runData = new RunData();
        this.f12399a = runData;
        runData.setSportType(2);
        dn6 dn6Var = new dn6();
        this.f12404a = dn6Var;
        dn6Var.p(3);
        UserPausePopupWindow userPausePopupWindow = new UserPausePopupWindow(((BaseActivity) this).c, R.layout.layout_arrow_bottom_pop, R.layout.layout_user_pause_pop);
        this.f12398a = userPausePopupWindow;
        userPausePopupWindow.initPopupWindow(jj8.a(206.0f), jj8.a(37.0f), new ColorDrawable(ResourcesCompat.getColor(((BaseActivity) this).c.getResources(), R.color.transparent, null)), false);
        this.f12398a.setPopupListener(new k());
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        HCJMapFragment hCJMapFragmentCreateMapFragment = this.f12407a.createMapFragment();
        this.f12406a = hCJMapFragmentCreateMapFragment;
        hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_map_container, this.f12406a).commit();
        this.f12406a.setMyLocationMarkerRes(R.drawable.run_ic_my_location);
        this.f12406a.setMyLocationEnable(Boolean.TRUE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_countdown_container, RunCountDownFragment.newInstance(this, R.color.color_main_v2)).commit();
        this.f12390a = (RelativeLayout) findViewById(R.id.rl_panel_model);
        this.f12411b = (RelativeLayout) findViewById(R.id.rl_map_model);
        this.f12389a = (FrameLayout) findViewById(R.id.fl_target_container);
        this.f12409b = (FrameLayout) findViewById(R.id.fl_static_container);
        this.I = (TextView) findViewById(R.id.tv_distance_title);
        this.J = (TextView) findViewById(R.id.tv_distance_value);
        this.K = (TextView) findViewById(R.id.tv_duration_title);
        this.f12412b = (BackgroundChronometer) findViewById(R.id.tv_duration_value);
        this.L = (TextView) findViewById(R.id.tv_calories_title);
        this.M = (TextView) findViewById(R.id.tv_calories_value);
        this.f12388a = findViewById(R.id.sl_relocation);
        if (this.f35802a > 0) {
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_distance_target_header, (ViewGroup) this.f12389a, true);
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_distance_target_statics, (ViewGroup) this.f12409b, true);
            TextView textView = (TextView) findViewById(R.id.tv_target_title);
            this.D = textView;
            Activity activity = ((BaseActivity) this).c;
            int i2 = R.string.run_target_distance;
            textView.setText(String.format(activity.getString(i2), BigDecimal.valueOf(this.f35802a).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString()));
            this.I.setText(String.format(((BaseActivity) this).c.getString(i2), BigDecimal.valueOf(this.f35802a).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString()));
        } else if (this.d > 0) {
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_duration_target_header, (ViewGroup) this.f12389a, true);
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_duration_target_statics, (ViewGroup) this.f12409b, true);
            TextView textView2 = (TextView) findViewById(R.id.tv_target_title);
            this.D = textView2;
            Activity activity2 = ((BaseActivity) this).c;
            int i3 = R.string.run_target_duration;
            textView2.setText(String.format(activity2.getString(i3), s72.n(this.d)));
            this.K.setText(String.format(((BaseActivity) this).c.getString(i3), s72.n(this.d)));
        } else if (this.e > 0) {
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_calories_target_header, (ViewGroup) this.f12389a, true);
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_calories_target_statics, (ViewGroup) this.f12409b, true);
            TextView textView3 = (TextView) findViewById(R.id.tv_target_title);
            this.D = textView3;
            Activity activity3 = ((BaseActivity) this).c;
            int i4 = R.string.run_target_cost_calories;
            textView3.setText(String.format(activity3.getString(i4), Integer.valueOf(BigDecimal.valueOf(this.e).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).intValue())));
            this.L.setText(String.format(((BaseActivity) this).c.getString(i4), Integer.valueOf(BigDecimal.valueOf(this.e).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).intValue())));
        } else {
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_common_header, (ViewGroup) this.f12389a, true);
            LayoutInflater.from(((BaseActivity) this).c).inflate(R.layout.run_layout_distance_target_statics, (ViewGroup) this.f12409b, true);
            TextView textView4 = (TextView) findViewById(R.id.tv_target_title);
            this.D = textView4;
            textView4.setText(((BaseActivity) this).c.getString(R.string.kilometer));
        }
        this.o = (ImageView) findViewById(R.id.img_map_entry);
        this.E = (TextView) findViewById(R.id.tv_average_pace);
        this.F = (TextView) findViewById(R.id.tv_distance);
        this.f12394a = (BackgroundChronometer) findViewById(R.id.tv_costed_time);
        this.H = (TextView) findViewById(R.id.tv_burned_calories);
        this.f12410b = (LinearLayout) findViewById(R.id.rl_run_operate);
        this.f12415c = (RelativeLayout) findViewById(R.id.rl_pause);
        this.p = (ImageView) findViewById(R.id.img_sound);
        this.q = (ImageView) findViewById(R.id.img_lock);
        this.f12414c = (LinearLayout) findViewById(R.id.ll_pause_operate);
        this.f12396a = (ShadowLayout) findViewById(R.id.sl_resume);
        CircleProgressButton circleProgressButton = (CircleProgressButton) findViewById(R.id.btn_finish);
        this.f12395a = circleProgressButton;
        circleProgressButton.setCircleProcessListener(new l());
        this.f12413c = (FrameLayout) findViewById(R.id.fl_lock);
        ShrinkScrollView shrinkScrollView = (ShrinkScrollView) findViewById(R.id.scroll_lock);
        this.f12397a = shrinkScrollView;
        shrinkScrollView.setMessage(((BaseActivity) this).c.getString(R.string.slide_to_unlock));
        this.f12397a.setScrollShrinkLisner(new m());
        this.f12388a.setOnClickListener(this);
        this.f12415c.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.f12396a.setOnClickListener(this);
        this.o.setOnClickListener(this);
        getLifecycle().addObserver(this.f12391a);
        getLifecycle().addObserver(this.f12392a);
        this.N = (TextView) findViewById(R.id.tvSignCount);
        this.O = (TextView) findViewById(R.id.tvAccuracy);
    }

    public final void j1() {
        UserPausePopupWindow userPausePopupWindow = this.f12398a;
        if (userPausePopupWindow != null && userPausePopupWindow.isShowing()) {
            this.f12398a.dismiss();
        }
        if (this.c == null) {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f12414c, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f)).setDuration(200L);
            this.c = duration;
            duration.setInterpolator(new LinearInterpolator());
            this.c.addListener(new b());
        }
        this.c.cancel();
        this.c.start();
        if (this.b == null) {
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.f12410b, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f)).setDuration(200L);
            this.b = duration2;
            duration2.setInterpolator(new LinearInterpolator());
            this.b.addListener(new c());
        }
        this.b.cancel();
        this.f12387a.postDelayed(new d(), 250L);
    }

    public final void k1() {
        if (this.f12385a == null) {
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f12410b, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f)).setDuration(200L);
            this.f12385a = duration;
            duration.setInterpolator(new LinearInterpolator());
            this.f12385a.addListener(new p());
        }
        this.f12385a.cancel();
        this.f12385a.start();
        if (this.f12418d == null) {
            ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.f12414c, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f)).setDuration(200L);
            this.f12418d = duration2;
            duration2.setInterpolator(new LinearInterpolator());
            this.f12418d.addListener(new q());
        }
        this.f12418d.cancel();
        this.f12387a.postDelayed(new a(), 250L);
    }

    public final void l1(HCJAddressInfo addressInfo) {
        if (addressInfo == null || addressInfo.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        this.f12406a.showMyLocationMarker(new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()), -addressInfo.getDirection(), false);
        HCJLatLng hCJLatLng = this.f12399a.getCurrentLocation() != null ? new HCJLatLng(this.f12399a.getCurrentLocation().getLat(), this.f12399a.getCurrentLocation().getLng()) : null;
        this.f12399a.setCurrentLocation(new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()));
        if (this.f12422j) {
            return;
        }
        this.f12399a.addOriginPoint(new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()));
        HCJAddressInfo hCJAddressInfoT0 = T0(addressInfo);
        if (hCJAddressInfoT0 != null) {
            this.f12408a = hCJAddressInfoT0;
            this.f12399a.addFilterPoint(new HCJLatLng(hCJAddressInfoT0.getLat(), hCJAddressInfoT0.getLng()));
            N0(new HCJLatLng(hCJAddressInfoT0.getLat(), hCJAddressInfoT0.getLng()));
            if (hCJLatLng != null) {
                this.f12399a.setDistance(this.f12399a.getDistance() + ((long) BigDecimal.valueOf(this.f12407a.createMapUtils().calculateLineDistance(hCJLatLng, new HCJLatLng(hCJAddressInfoT0.getLat(), hCJAddressInfoT0.getLng()))).setScale(0, RoundingMode.HALF_UP).intValue()));
            }
        }
        if (this.f12405a != null) {
            this.f12405a.v0(this.f12404a.k(this.f12399a.getFilterPathList()));
        }
        n1();
        m1(hCJAddressInfoT0);
    }

    public final void m1(HCJAddressInfo addressInfo) {
        this.N.setText(String.format("%s", Integer.valueOf(addressInfo.getSatellites())));
        this.O.setText(String.format("A:%s S:%s", Float.valueOf(addressInfo.getAccuracy()), Float.valueOf(addressInfo.getSpeed())));
    }

    public final void n1() {
        long distance = this.f12399a.getDistance();
        if (distance == 0) {
            this.F.setText("0.00");
            this.J.setText("0.00");
            this.H.setText("0");
            this.M.setText("0");
            this.E.setText("--");
        }
        double dDoubleValue = distance < 10 ? 0.01d : BigDecimal.valueOf(distance).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_DOWN).doubleValue();
        this.F.setText(c82.b(dDoubleValue, 2));
        this.J.setText(c82.b(dDoubleValue, 2));
        long jLongValue = BigDecimal.valueOf(this.f).divide(BigDecimal.valueOf(dDoubleValue), 0, RoundingMode.HALF_UP).longValue();
        this.E.setText(jLongValue <= 3600 ? s72.e(jLongValue) : "--");
        long jLongValue2 = BigDecimal.valueOf(ai9.e().getSex() == 2 ? 65L : 53L).multiply(BigDecimal.valueOf(distance)).multiply(BigDecimal.valueOf(1.036d)).setScale(0, RoundingMode.HALF_UP).longValue();
        this.H.setText(BigDecimal.valueOf(jLongValue2).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        this.M.setText(BigDecimal.valueOf(jLongValue2).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        b1(distance);
        if (Q0(distance)) {
            this.f12421g = true;
            nl8.e(this).q(R.raw.run_achieve_target);
            pm9.c(3000L);
            O0();
            return;
        }
        if (R0()) {
            this.f12421g = true;
            nl8.e(this).q(R.raw.run_achieve_target);
            pm9.c(3000L);
            O0();
            return;
        }
        if (!P0(jLongValue2)) {
            if (distance >= 50000) {
                O0();
            }
        } else {
            this.f12421g = true;
            nl8.e(this).q(R.raw.run_achieve_target);
            pm9.c(3000L);
            O0();
        }
    }

    public final void o1() {
        List<IntervalPace> list = this.f12419d;
        if (list == null || list.isEmpty()) {
            return;
        }
        ((com.huachenjie.run.page.free.a) ((BaseActivity) this).f8487a).g(this.f12419d, r90.g().getPaceInterval(), this.t);
        this.f12419d.clear();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f12423p) {
            this.f12411b.setVisibility(8);
            this.f12390a.setVisibility(0);
            this.f12391a.d();
            this.f12423p = !this.f12423p;
            g1();
        }
    }

    @Override // android.view.View.OnClickListener
    @RequiresApi(api = 28)
    public void onClick(View v) {
        if (v.getId() == R.id.sl_relocation) {
            if (this.f12406a.getMap() == null || this.f12405a == null || r90.o() == null || r90.o().getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
            this.f12405a.n0(new HCJLatLng(r90.o().getLat(), r90.o().getLng()), 18.0f);
            return;
        }
        if (v.getId() == R.id.rl_pause) {
            pause();
            return;
        }
        if (v.getId() == R.id.img_sound) {
            boolean z2 = !this.f12417c;
            this.f12417c = z2;
            fv5.a(z2 ? R.string.run_slience_on_prompt : R.string.run_slience_off_prompt);
            nl8.e(((BaseActivity) this).c).s(this.f12417c, true);
            this.p.setImageResource(this.f12417c ? R.drawable.run_ic_free_slient : R.drawable.run_ic_free_sound);
            return;
        }
        if (v.getId() == R.id.img_lock) {
            fv5.a(R.string.run_screen_lock_prompt);
            this.f12413c.setVisibility(0);
            this.f12410b.setVisibility(8);
        } else {
            if (v.getId() == R.id.sl_resume) {
                resume();
                return;
            }
            if (v.getId() == R.id.img_map_entry) {
                this.f12411b.setVisibility(this.f12423p ? 8 : 0);
                this.f12390a.setVisibility(this.f12423p ? 0 : 8);
                if (this.f12423p) {
                    this.f12391a.d();
                }
                if (this.f12423p) {
                    g1();
                } else {
                    f1();
                }
                this.f12423p = !this.f12423p;
            }
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.f().v(this);
    }

    @Override // com.huachenjie.common.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f12394a.stop();
        this.f12412b.stop();
        this.f12387a.removeCallbacksAndMessages(null);
        this.f12402a = null;
        this.f12403a = null;
        EventBus.f().A(this);
        stopService(new Intent(((BaseActivity) this).c, (Class<?>) LocationService.class));
        if (this.h) {
            unbindService(this.f12386a);
        }
        ObjectAnimator objectAnimator = this.f12385a;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f12385a.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f12418d;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f12418d.cancel();
        }
        ObjectAnimator objectAnimator3 = this.c;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.c.cancel();
        }
        ObjectAnimator objectAnimator4 = this.b;
        if (objectAnimator4 != null && objectAnimator4.isRunning()) {
            this.b.cancel();
        }
        jn3 jn3Var = this.f12405a;
        if (jn3Var != null) {
            jn3Var.h0();
        }
        this.f12406a.clear(false);
        nl8.e(((BaseActivity) this).c).s(false, false);
        UserPausePopupWindow userPausePopupWindow = this.f12398a;
        if (userPausePopupWindow == null || !userPausePopupWindow.isShowing()) {
            return;
        }
        this.f12398a.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(HCJAddressInfo addressInfo) {
        l1(addressInfo);
    }

    public void onMapLoaded() {
        this.f12406a.setOnOritationChangeListener(this);
        this.f12405a = new jn3(((BaseActivity) this).c, this.f12406a.getMap());
        if (r90.o() != null && r90.o().getLat() != AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.f12405a.n0(new HCJLatLng(r90.o().getLat(), r90.o().getLng()), 18.0f);
        }
        this.f12387a.postDelayed(this.f12403a, ((long) r90.g().getPoiInterval()) * 1000);
        this.f12387a.postDelayed(new o(), 2000L);
    }

    public void onOrientationChange(float bearing) {
        HCJMapFragment hCJMapFragment = this.f12406a;
        if (hCJMapFragment == null || hCJMapFragment.getMap() == null) {
            return;
        }
        this.f12406a.showMyLocationMarker(bearing);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.t = savedInstanceState.getString("runRecordCode");
        this.f35802a = savedInstanceState.getLong(y, 0L);
        this.d = savedInstanceState.getLong(z, 0L);
        this.e = savedInstanceState.getLong(A, 0L);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("runRecordCode", this.t);
        outState.putLong(y, this.f35802a);
        outState.putLong(z, this.d);
        outState.putLong(A, this.e);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f12406a.startOritationSensor(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f12406a.startOritationSensor(false);
    }

    public final void p1() {
        List<IntervalStep> list = this.f12420e;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<IntervalStep> array = JSON.parseArray(JSON.toJSONString(this.f12420e), IntervalStep.class);
        this.f12420e.clear();
        ((com.huachenjie.run.page.free.a) ((BaseActivity) this).f8487a).i(array, r90.g().getStepInterval(), this.t);
    }

    public final void pause() {
        this.f12422j = true;
        this.f12387a.removeCallbacks(this.f12403a);
        nl8.e(((BaseActivity) this).c).q(R.raw.run_pause);
        this.f12394a.stop();
        this.f12412b.stop();
        this.g = SystemClock.elapsedRealtime();
        StepService stepService = this.f12393a;
        if (stepService != null) {
            stepService.pauseStep();
        }
        jn3 jn3Var = this.f12405a;
        if (jn3Var != null) {
            jn3Var.s0();
        }
        this.j = 1800000 - this.f12399a.getPauseDuratin();
        k1();
        if (this.j > 0) {
            this.f12387a.removeCallbacks(this.f12402a);
            this.f12387a.postDelayed(this.f12402a, this.j);
        } else {
            t26 t26Var = t26.f44833a;
            Activity activity = ((BaseActivity) this).c;
            t26Var.e(activity, 1236, activity.getString(R.string.hcj_app_name), ((BaseActivity) this).c.getString(R.string.run_auto_stop_notification_content), null);
            O0();
        }
    }

    public final void q1() {
        this.f12387a.postDelayed(this.f12403a, ((long) r90.g().getPoiInterval()) * 1000);
        List<HCJLatLng> list = this.f12416c;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<HCJLatLng> array = JSON.parseArray(JSON.toJSONString(this.f12416c), HCJLatLng.class);
        this.f12416c.clear();
        ((com.huachenjie.run.page.free.a) ((BaseActivity) this).f8487a).h(array, this.t);
    }

    public final void resume() {
        this.f12387a.removeCallbacks(this.f12402a);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.g;
        this.f12399a.increasePauseDuration(jElapsedRealtime);
        j1();
        nl8.e(((BaseActivity) this).c).q(R.raw.run_resume);
        if (this.f12399a.getPauseDuratin() >= 1800000) {
            t26 t26Var = t26.f44833a;
            Activity activity = ((BaseActivity) this).c;
            t26Var.e(activity, 1236, activity.getString(R.string.hcj_app_name), ((BaseActivity) this).c.getString(R.string.run_auto_stop_notification_content), null);
            O0();
            return;
        }
        long base = this.f12394a.getBase() + jElapsedRealtime;
        this.f12394a.setBase(base);
        this.f12412b.setBase(base);
        this.f12394a.start();
        this.f12412b.start();
        StepService stepService = this.f12393a;
        if (stepService != null) {
            stepService.resumeStep();
        }
        this.f12422j = false;
        this.f12387a.removeCallbacks(this.f12403a);
        this.f12387a.postDelayed(this.f12403a, ((long) r90.g().getPoiInterval()) * 1000);
        jn3 jn3Var = this.f12405a;
        if (jn3Var != null) {
            jn3Var.t0();
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity, com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void t() {
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void u() {
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void v(boolean showSuccessDialog, int inspirationValue) {
        ARouter.getInstance().build(RoutePathConstants.Run.b).withBoolean(RunDetailActivity.A, true).withBoolean(RunDetailActivity.z, showSuccessDialog).withString("runRecordCode", this.t).withInt("inspirationValue", inspirationValue).navigation();
        finish();
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void w(String message) {
        if (!TextUtils.isEmpty(message)) {
            fv5.b(message);
        }
        finish();
    }

    @Override // com.huachenjie.run.page.free.FreeRunContact.FreeRunView
    public void x(boolean isAuto, boolean isDataError, boolean isValid, int code, String message) {
        if (isAuto) {
            finish();
        } else {
            fv5.a(R.string.finish_run_failed_warn);
        }
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public com.huachenjie.run.page.free.a initPresenter() {
        return new com.huachenjie.run.page.free.a();
    }
}
