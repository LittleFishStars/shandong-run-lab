package com.huachenjie.run.page.run_detail;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentManager;
import com.amap.api.maps.AMap;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailActivity$captureMapScreenShot$1;
import com.huachenjie.run.page.share.RunShareDialog;
import com.zj.adlib.d60;
import com.zj.adlib.ex7;
import com.zj.adlib.fv5;
import com.zj.adlib.jg3;
import com.zj.adlib.tw0;
import java.io.File;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/run/page/run_detail/RunDetailActivity$captureMapScreenShot$1", "Lcom/amap/api/maps/AMap$OnMapScreenShotListener;", "onMapScreenShot", "", "bitmap", "Landroid/graphics/Bitmap;", "status", "", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunDetailActivity$captureMapScreenShot$1 implements AMap.OnMapScreenShotListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RunDetailActivity f35912a;

    public RunDetailActivity$captureMapScreenShot$1(RunDetailActivity runDetailActivity) {
        this.f35912a = runDetailActivity;
    }

    public static final Bitmap f(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (Bitmap) function1.invoke(obj);
    }

    public static final File g(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (File) function1.invoke(obj);
    }

    public static final Boolean h(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    public static final void i(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void j(RunDetailActivity runDetailActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        th.printStackTrace();
        runDetailActivity.X0();
        runDetailActivity.getMLoadingDialog().dismiss();
        fv5.a(R.string.run_create_screenshot_failed);
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@Nullable Bitmap bitmap) {
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public void onMapScreenShot(@Nullable Bitmap bitmap, int status) {
        if (bitmap == null) {
            this.f35912a.X0();
            this.f35912a.getMLoadingDialog().dismiss();
            return;
        }
        Observable observableK2 = Observable.K2(bitmap);
        final RunDetailActivity runDetailActivity = this.f35912a;
        final Function1<Bitmap, Bitmap> function1 = new Function1<Bitmap, Bitmap>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$captureMapScreenShot$1$onMapScreenShot$1
            {
                super(1);
            }

            public final Bitmap invoke(Bitmap bitmap2) {
                return ex7.d(bitmap2, runDetailActivity.getMBinding().f11444a, runDetailActivity.getMBinding().f35454a.getHeight(), null);
            }
        };
        Observable observableA3 = observableK2.a3(new Func1() { // from class: com.zj.adlib.ul7
            public final Object call(Object obj) {
                return RunDetailActivity$captureMapScreenShot$1.f(function1, obj);
            }
        });
        final RunDetailActivity runDetailActivity2 = this.f35912a;
        final Function1<Bitmap, File> function2 = new Function1<Bitmap, File>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$captureMapScreenShot$1$onMapScreenShot$2
            {
                super(1);
            }

            public final File invoke(Bitmap bitmap2) {
                File fileF = jg3.f42579a.f(runDetailActivity2);
                Intrinsics.checkNotNull(fileF);
                return tw0.h(bitmap2, 1048576L, fileF.getAbsolutePath(), "screenshot_" + System.currentTimeMillis() + FileTypes.F);
            }
        };
        Observable observableA4 = observableA3.a3(new Func1() { // from class: com.zj.adlib.vl7
            public final Object call(Object obj) {
                return RunDetailActivity$captureMapScreenShot$1.g(function2, obj);
            }
        });
        final RunDetailActivity$captureMapScreenShot$1$onMapScreenShot$3 runDetailActivity$captureMapScreenShot$1$onMapScreenShot$3 = new Function1<File, Boolean>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$captureMapScreenShot$1$onMapScreenShot$3
            public final Boolean invoke(File file) {
                return Boolean.valueOf(file != null);
            }
        };
        Observable observableG3 = observableA4.T1(new Func1() { // from class: com.zj.adlib.wl7
            public final Object call(Object obj) {
                return RunDetailActivity$captureMapScreenShot$1.h(runDetailActivity$captureMapScreenShot$1$onMapScreenShot$3, obj);
            }
        }).u5(Schedulers.io()).G3(d60.c());
        final RunDetailActivity runDetailActivity3 = this.f35912a;
        final Function1<File, Unit> function3 = new Function1<File, Unit>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$captureMapScreenShot$1$onMapScreenShot$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((File) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                runDetailActivity3.X0();
                runDetailActivity3.getMLoadingDialog().dismiss();
                RunShareDialog.Companion companion = RunShareDialog.INSTANCE;
                FragmentManager supportFragmentManager = runDetailActivity3.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                companion.a(supportFragmentManager, absolutePath);
            }
        };
        Action1 action1 = new Action1() { // from class: com.zj.adlib.xl7
            public final void call(Object obj) {
                RunDetailActivity$captureMapScreenShot$1.i(function3, obj);
            }
        };
        final RunDetailActivity runDetailActivity4 = this.f35912a;
        observableG3.s5(action1, new Action1() { // from class: com.zj.adlib.yl7
            public final void call(Object obj) {
                RunDetailActivity$captureMapScreenShot$1.j(runDetailActivity4, (Throwable) obj);
            }
        });
    }
}
