package com.huachenjie.mall.page.goods_detail.preview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.VideoBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityBannerPreviewBinding;
import com.zj.adlib.hk0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityBannerPreviewBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getLayoutResID", "", "", "V", "", "S", "initData", "onResume", "onPause", "onBackPressed", "Z", "<init>", "()V", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ImagePreviewActivity extends BaseMVVMActivity<MallActivityBannerPreviewBinding, BaseViewModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "position";

    @NotNull
    public static final String x = "video";

    @NotNull
    public static final String y = "image_list";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ImagePreviewActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.preview.ImagePreviewActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/ImagePreviewActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/base/bean/VideoBean;", "videoBean", "Ljava/util/ArrayList;", "Lcom/huachenjie/base/bean/ImageBean;", "Lkotlin/collections/ArrayList;", "imageList", "", "position", "Landroid/content/Intent;", "a", "", "KEY_IMAGE_LIST", "Ljava/lang/String;", "KEY_POSITION", "KEY_VIDEO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @Nullable VideoBean videoBean, @NotNull ArrayList<ImageBean> imageList, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageList, "imageList");
            Intent intent = new Intent(context, (Class<?>) ImagePreviewActivity.class);
            intent.putExtra("video", videoBean);
            intent.putExtra(ImagePreviewActivity.y, imageList);
            intent.putExtra("position", position);
            return intent;
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.black).G1(false).k3().a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    public final void Z() {
        VideoBean videoBean = (VideoBean) getIntent().getParcelableExtra("video");
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(y);
        Intrinsics.checkNotNull(parcelableArrayListExtra);
        int intExtra = getIntent().getIntExtra("position", 0);
        getMBinding().f10144a.initData(videoBean, parcelableArrayListExtra, intExtra == 0, !PlayerManager.INSTANCE.a().getPrepared(), intExtra, true);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_banner_preview;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        Z();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("position", getMBinding().f10144a.getCurrentPosition());
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        getMBinding().f10144a.pause();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMBinding().f10144a.resume();
    }
}
