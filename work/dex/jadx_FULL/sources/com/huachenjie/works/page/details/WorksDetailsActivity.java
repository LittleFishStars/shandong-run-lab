package com.huachenjie.works.page.details;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.a;
import com.gyf.immersionbar.e;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.picture.PicturePromotionFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.video.VideoWorkListFragment;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.WORKS_DETAIL)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002R\u001b\u0010\u0017\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001fR\u001b\u0010&\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016¨\u0006)"}, d2 = {"Lcom/huachenjie/works/page/details/WorksDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onBackPressed", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "onDestroy", "Landroidx/fragment/app/Fragment;", "fragment", "Z", "Y", "S", "a", "Lkotlin/Lazy;", "V", "()I", "worksAttachType", "", "b", "W", "()Ljava/lang/String;", yj7.g.WORKS_NO, "c", "U", "()Z", "fromMine", "d", "T", yj7.g.WORKS_LOAD_MORE, "e", "X", yj7.g.WORKS_TYPE, "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksDetailsActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy worksAttachType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.details.WorksDetailsActivity$worksAttachType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m917invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(yj7.g.WORKS_ATTACH_TYPE, 1));
        }
    });

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy worksNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.details.WorksDetailsActivity$worksNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(yj7.g.WORKS_NO);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromMine = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.details.WorksDetailsActivity$fromMine$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m916invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra("fromMine", false));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy canLoadMore = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.details.WorksDetailsActivity$canLoadMore$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m915invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(yj7.g.WORKS_LOAD_MORE, false));
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy worksType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.details.WorksDetailsActivity$worksType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m919invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(yj7.g.WORKS_TYPE, -1));
        }
    });

    public final void S() {
        if (a.D().size() == 1) {
            ARouter.getInstance().build(zj7.a.HOME).navigation();
        }
    }

    public final boolean T() {
        return ((Boolean) this.canLoadMore.getValue()).booleanValue();
    }

    public final boolean U() {
        return ((Boolean) this.fromMine.getValue()).booleanValue();
    }

    public final int V() {
        return ((Number) this.worksAttachType.getValue()).intValue();
    }

    public final String W() {
        return (String) this.worksNo.getValue();
    }

    public final int X() {
        return ((Number) this.worksType.getValue()).intValue();
    }

    public final void Y() {
        e eVarP3 = e.p3(this);
        int i = R.color.white;
        eVarP3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    public final void Z(Fragment fragment) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
        if (getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName()) == null) {
            fragmentTransactionBeginTransaction.add(R.id.fl_container, fragment, fragment.getClass().getName());
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        S();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Y();
        setContentView(R.layout.works_activity_works_detail);
        if (X() == 6) {
            PicturePromotionFragment.Companion bVar = PicturePromotionFragment.INSTANCE;
            String strW = W();
            Intrinsics.checkNotNullExpressionValue(strW, yj7.g.WORKS_NO);
            Z(bVar.a(strW));
            return;
        }
        int iV = V();
        if (iV == 1) {
            PictureWorksDetailFragment.Companion bVar2 = PictureWorksDetailFragment.INSTANCE;
            String strW2 = W();
            Intrinsics.checkNotNullExpressionValue(strW2, yj7.g.WORKS_NO);
            Z(bVar2.a(strW2, U()));
            return;
        }
        if (iV != 2) {
            return;
        }
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        VideoWorkListFragment.Companion aVar = VideoWorkListFragment.INSTANCE;
        String strW3 = W();
        Intrinsics.checkNotNullExpressionValue(strW3, yj7.g.WORKS_NO);
        Z(aVar.a(strW3, U(), T()));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Window window;
        if (V() == 2 && (window = getWindow()) != null) {
            window.clearFlags(128);
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            S();
        }
        return super.onKeyDown(keyCode, event);
    }
}
