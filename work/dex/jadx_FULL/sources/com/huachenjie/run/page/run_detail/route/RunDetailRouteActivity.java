package com.huachenjie.run.page.run_detail.route;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.gyf.immersionbar.e;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.databinding.RunActivityDetailRouteBinding;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteActivity;
import com.ipd.dsp.internal.i.q;
import com.zj.adlib.bm7;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;
import com.zj.adlib.s72;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0013\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityDetailRouteBinding;", "Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteVM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "", "S", "", "getLayoutResID", "", "", "V", "initView", "onMapLoaded", "onDestroy", "b0", "e0", "d0", "Lcom/huachenjie/run/bean/RunDetailEntity;", "a", "Lcom/huachenjie/run/bean/RunDetailEntity;", "runDetail", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "Lcom/zj/adlib/bm7;", "Lcom/zj/adlib/bm7;", "routeOverlay", "<init>", "()V", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunDetailRouteActivity extends BaseMVVMActivity<RunActivityDetailRouteBinding, RunDetailRouteVM> implements CaocaoOnMapLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_data";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunDetailEntity runDetail;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public bm7 routeOverlay;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapFragment mMapFragment;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteActivity$a;", "", "Landroid/view/View;", "v", "", "back", "view", "a", "<init>", "(Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailRouteActivity.a0(RunDetailRouteActivity.this).l();
        }

        public final void back(@Nullable View v) {
            RunDetailRouteActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.run_detail.route.RunDetailRouteActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/run/bean/RunDetailEntity;", "detail", "", "a", "", "KEY_DATA", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull RunDetailEntity detail) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intent intent = new Intent(context, (Class<?>) RunDetailRouteActivity.class);
            intent.putExtra(RunDetailRouteActivity.t, detail);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ RunDetailRouteVM a0(RunDetailRouteActivity runDetailRouteActivity) {
        return runDetailRouteActivity.getMViewModel();
    }

    public static final void c0(RunDetailRouteActivity runDetailRouteActivity) {
        Intrinsics.checkNotNullParameter(runDetailRouteActivity, "this$0");
        runDetailRouteActivity.e0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    public final void b0() {
        RunDetailEntity runDetailEntity = this.runDetail;
        if (runDetailEntity == null || runDetailEntity.getPois() == null) {
            return;
        }
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        Intrinsics.checkNotNull(hCJMapFragment);
        bm7 bm7Var = new bm7(this, hCJMapFragment.getMap());
        this.routeOverlay = bm7Var;
        bm7Var.v0(runDetailEntity);
        getMBinding().f11471a.post(new Runnable() { // from class: com.zj.adlib.zl7
            @Override // java.lang.Runnable
            public final void run() {
                RunDetailRouteActivity.c0(this.f46288a);
            }
        });
    }

    public final void d0() {
        RunDetailEntity runDetailEntity = this.runDetail;
        if (runDetailEntity == null) {
            return;
        }
        getMBinding().c.setText(runDetailEntity.formatValidDistance());
        getMBinding().f11473b.setText(s72.n(runDetailEntity.getDuration()));
        getMBinding().g.setText(s72.e(runDetailEntity.getPace()));
        getMBinding().f11467a.setText(runDetailEntity.formatCalorie());
        long startTime = runDetailEntity.getStartTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        getMBinding().i.setText(simpleDateFormat.format(Long.valueOf(startTime)) + q.a.i + simpleDateFormat2.format(Long.valueOf(startTime)));
    }

    public final void e0() {
        Integer value = getMViewModel().e().c().getValue();
        if (value == null) {
            value = Integer.valueOf(jj8.a(44.0f));
        }
        int iIntValue = value.intValue() + jj8.a(52.0f);
        int height = getMBinding().f11471a.getHeight() + jj8.a(12.0f);
        int iA = jj8.a(32.0f);
        bm7 bm7Var = this.routeOverlay;
        if (bm7Var != null) {
            bm7Var.M(iA, iA, iIntValue, height);
        }
        bm7 bm7Var2 = this.routeOverlay;
        if (bm7Var2 != null) {
            bm7Var2.w0();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_detail_route;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        this.runDetail = (RunDetailEntity) getIntent().getParcelableExtra(t);
        HCJMapAdapter hCJMapEntry = HCJMapEntry.getInstance();
        HCJMapFragment hCJMapFragmentCreateMapFragment = hCJMapEntry != null ? hCJMapEntry.createMapFragment() : null;
        this.mMapFragment = hCJMapFragmentCreateMapFragment;
        if (hCJMapFragmentCreateMapFragment != null) {
            hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R.id.fl_map_container;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        Intrinsics.checkNotNull(hCJMapFragment);
        fragmentTransactionBeginTransaction.replace(i, hCJMapFragment).commit();
        HCJMapFragment hCJMapFragment2 = this.mMapFragment;
        if (hCJMapFragment2 != null) {
            hCJMapFragment2.setMyLocationEnable(Boolean.FALSE);
        }
        d0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        bm7 bm7Var = this.routeOverlay;
        if (bm7Var != null) {
            bm7Var.h0();
        }
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.clear(false);
        }
        super.onDestroy();
    }

    public void onMapLoaded() {
        b0();
    }
}
