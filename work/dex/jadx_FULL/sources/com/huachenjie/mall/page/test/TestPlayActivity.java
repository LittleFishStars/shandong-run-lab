package com.huachenjie.mall.page.test;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.video.AliVideoCallback;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallActivityTestPlayBinding;
import com.huachenjie.mall.page.test.TestPlayActivity;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import com.zj.adlib.i4a;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/test/TestPlayActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityTestPlayBinding;", "Lcom/huachenjie/mall/page/test/TestPlayVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "f0", "g0", "d0", "i0", "<init>", "()V", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class TestPlayActivity extends BaseMVVMActivity<MallActivityTestPlayBinding, TestPlayVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/test/TestPlayActivity$a;", "", "Landroid/view/View;", "v", "", "b", "view", "a", "<init>", "(Lcom/huachenjie/mall/page/test/TestPlayActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            TestPlayActivity.b0(TestPlayActivity.this).b.setVisibility(8);
            TestVideoDetailBean value = TestPlayActivity.c0(TestPlayActivity.this).l().getValue();
            if (value == null) {
                return;
            }
            AliVideoView aliVideoView = TestPlayActivity.b0(TestPlayActivity.this).f10456a;
            Intrinsics.checkNotNullExpressionValue(aliVideoView, "mBinding.videoView");
            aliVideoView.playVideo(value.formatVideoUrl(), value.formatCoverBean().getPath(), 0L, true);
        }

        public final void b(@Nullable View v) {
            TestPlayActivity.b0(TestPlayActivity.this).f10456a.replay();
            TestPlayActivity.b0(TestPlayActivity.this).f34878a.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/mall/page/test/TestPlayActivity$b", "Lcom/huachenjie/common/video/AliVideoCallback;", "", "tag", "", "e", "Lcom/huachenjie/common/video/AliVideoView;", "view", "f", "", "progress", "totalProgress", "i", "c", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements AliVideoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConstraintLayout f35268a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TestPlayActivity f11158a;

        public b(ConstraintLayout constraintLayout, TestPlayActivity testPlayActivity) {
            this.f35268a = constraintLayout;
            this.f11158a = testPlayActivity;
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void c() {
            i4a.c("onPlayCompletion");
            TestVideoAdapter value = TestPlayActivity.c0(this.f11158a).j().getValue();
            if (value == null) {
                return;
            }
            int currentPlayIndex = TestPlayActivity.c0(this.f11158a).getCurrentPlayIndex() + 1;
            if (currentPlayIndex >= 0 && currentPlayIndex < value.getData().size()) {
                AliVideoView aliVideoView = TestPlayActivity.b0(this.f11158a).f10456a;
                Intrinsics.checkNotNullExpressionValue(aliVideoView, "mBinding.videoView");
                TestVideoDetailBean testVideoDetailBean = value.getData().get(currentPlayIndex);
                TestPlayActivity.c0(this.f11158a).n(currentPlayIndex);
                aliVideoView.playVideo(testVideoDetailBean.formatVideoUrl(), testVideoDetailBean.formatCoverBean().getPath(), 0L, false);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void e(int tag) {
            if (tag == 0) {
                this.f35268a.setVisibility(8);
            } else {
                if (tag != 1) {
                    return;
                }
                this.f35268a.setVisibility(0);
            }
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void f(@Nullable AliVideoView view) {
            TestPlayActivity.b0(this.f11158a).f34878a.setVisibility(0);
        }

        @Override // com.huachenjie.common.video.AliVideoCallback
        public void i(long progress, long totalProgress) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35269a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35269a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35269a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35269a.invoke(obj);
        }
    }

    public static final /* synthetic */ MallActivityTestPlayBinding b0(TestPlayActivity testPlayActivity) {
        return testPlayActivity.getMBinding();
    }

    public static final /* synthetic */ TestPlayVM c0(TestPlayActivity testPlayActivity) {
        return testPlayActivity.getMViewModel();
    }

    public static final void e0(TestPlayActivity testPlayActivity, TestVideoAdapter testVideoAdapter, MallActivityTestPlayBinding mallActivityTestPlayBinding, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(testPlayActivity, "this$0");
        Intrinsics.checkNotNullParameter(testVideoAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(mallActivityTestPlayBinding, "$it");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        testPlayActivity.getMBinding().b.setVisibility(8);
        TestVideoDetailBean testVideoDetailBean = testVideoAdapter.getData().get(i);
        mallActivityTestPlayBinding.f10456a.playVideo(testVideoDetailBean.formatVideoUrl(), testVideoDetailBean.formatCoverBean().getPath(), 0L, true);
        testPlayActivity.getMViewModel().n(i);
    }

    public static final void h0(TestPlayActivity testPlayActivity, View view) {
        Intrinsics.checkNotNullParameter(testPlayActivity, "this$0");
        testPlayActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new c(new Function1<TestVideoDetailBean, Unit>() { // from class: com.huachenjie.mall.page.test.TestPlayActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TestVideoDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(TestVideoDetailBean testVideoDetailBean) {
                if (testVideoDetailBean == null) {
                    return;
                }
                TestPlayActivity.b0(this.this$0).f10456a.showCover(testVideoDetailBean.formatCoverBean().getPath());
            }
        }));
    }

    public final void d0() {
        final MallActivityTestPlayBinding mBinding = getMBinding();
        final TestVideoAdapter testVideoAdapter = new TestVideoAdapter();
        y57.d(testVideoAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.g39
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                TestPlayActivity.e0(this.f16692a, testVideoAdapter, mBinding, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().j().setValue(testVideoAdapter);
    }

    public final void f0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void g0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("课程详情");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.h39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestPlayActivity.h0(this.f42042a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_test_play;
    }

    public final void i0() {
        AliVideoView aliVideoView = getMBinding().f10456a;
        Intrinsics.checkNotNullExpressionValue(aliVideoView, "mBinding.videoView");
        ConstraintLayout constraintLayout = getMBinding().f10455a.f8702a;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.toolbar.clTitle");
        aliVideoView.setLifecycle(getLifecycle());
        int iJ = fx7.j();
        aliVideoView.setVideoPortraitSize(iJ, (int) ((iJ * 9.0f) / 16.0f));
        aliVideoView.setCallback(new b(constraintLayout, this));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().m();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        f0();
        g0();
        d0();
        i0();
    }
}
