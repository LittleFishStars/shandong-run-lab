package com.huachenjie.run.page.geofence;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.ToastUtils;
import com.huachenjie.base.util.CustomerServiceUtil;
import com.huachenjie.base.view.CustomVideoView;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.util.weimai_hh.SpanHonghuUtil;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GuideFragmentAdapter;
import com.huachenjie.run.databinding.RunFragmentGuideVideoBinding;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.si0;
import com.zj.adlib.zn1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/huachenjie/run/page/geofence/VideoGuideFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/run/page/geofence/GeoFenceV2VM;", "", "getTipsByBiz", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "view", "onViewCreated", "pauseVideo", "onDestroyView", "mUrl", "Ljava/lang/String;", "Lcom/huachenjie/base/view/CustomVideoView;", "mVideo", "Lcom/huachenjie/base/view/CustomVideoView;", "Lcom/huachenjie/run/databinding/RunFragmentGuideVideoBinding;", "myBinding", "Lcom/huachenjie/run/databinding/RunFragmentGuideVideoBinding;", "", "type$delegate", "Lkotlin/Lazy;", "getType", "()I", "type", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class VideoGuideFragment extends BaseVMFragment<GeoFenceV2VM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String mUrl;

    @Nullable
    private CustomVideoView mVideo;
    private RunFragmentGuideVideoBinding myBinding;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.page.geofence.VideoGuideFragment$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m653invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("type") : GuideFragmentAdapter.INSTANCE.b());
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/geofence/VideoGuideFragment$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/page/geofence/VideoGuideFragment;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            if (si0.a()) {
                return;
            }
            CustomerServiceUtil.f32958a.f(VideoGuideFragment.this);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.geofence.VideoGuideFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/geofence/VideoGuideFragment$b;", "", "", "type", "", "url", "Lcom/huachenjie/run/page/geofence/VideoGuideFragment;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoGuideFragment a(int type, @Nullable String url) {
            VideoGuideFragment videoGuideFragment = new VideoGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putString("mUrl", url);
            bundle.putInt("type", type);
            videoGuideFragment.setArguments(bundle);
            return videoGuideFragment;
        }
    }

    private final String getTipsByBiz() {
        int type = getType();
        GuideFragmentAdapter.Companion companion = GuideFragmentAdapter.INSTANCE;
        if (type == companion.b()) {
            String string = getResources().getString(R.string.run_runGuidePointTips);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                resour…ePointTips)\n            }");
            return string;
        }
        if (type == companion.a()) {
            String string2 = getResources().getString(R.string.run_runGuideDisTips);
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                resour…ideDisTips)\n            }");
            return string2;
        }
        String string3 = getResources().getString(R.string.run_runGuideSpeedTips);
        Intrinsics.checkNotNullExpressionValue(string3, "{\n                resour…eSpeedTips)\n            }");
        return string3;
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_fragment_guide_video), Integer.valueOf(lk0.L), ((BaseVMFragment) this).mState).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String str = (String) (arguments != null ? arguments.get("mUrl") : null);
        this.mUrl = str;
        if (str == null || str.length() == 0) {
            ToastUtils.W("跑步指引视频地址为空!", new Object[0]);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        CustomVideoView customVideoView = this.mVideo;
        if (customVideoView != null) {
            customVideoView.release();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunFragmentGuideVideoBinding");
        RunFragmentGuideVideoBinding runFragmentGuideVideoBinding = (RunFragmentGuideVideoBinding) binding;
        this.myBinding = runFragmentGuideVideoBinding;
        RunFragmentGuideVideoBinding runFragmentGuideVideoBinding2 = null;
        if (runFragmentGuideVideoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myBinding");
            runFragmentGuideVideoBinding = null;
        }
        CustomVideoView customVideoView = runFragmentGuideVideoBinding.f35587a;
        if (customVideoView != null) {
            this.mVideo = customVideoView;
            customVideoView.setThumbnailRes(R.drawable.run_bg_guide_video);
            customVideoView.setVideoDisplayType(4);
            String str = this.mUrl;
            if (str == null) {
                str = "";
            }
            customVideoView.setVideoPath(str);
        }
        String tipsByBiz = getTipsByBiz();
        if (getType() != GuideFragmentAdapter.INSTANCE.b()) {
            RunFragmentGuideVideoBinding runFragmentGuideVideoBinding3 = this.myBinding;
            if (runFragmentGuideVideoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myBinding");
            } else {
                runFragmentGuideVideoBinding2 = runFragmentGuideVideoBinding3;
            }
            runFragmentGuideVideoBinding2.f11852a.f12146a.setText(tipsByBiz);
            return;
        }
        SpanHonghuUtil.SpanBuilder spanBuilderD = SpanHonghuUtil.a().h(tipsByBiz + '\n').d("*围栏无打卡点位时，是不需要完成点位打卡的", zn1.a(R.color.hcj_vip_txt_color));
        RunFragmentGuideVideoBinding runFragmentGuideVideoBinding4 = this.myBinding;
        if (runFragmentGuideVideoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myBinding");
        } else {
            runFragmentGuideVideoBinding2 = runFragmentGuideVideoBinding4;
        }
        spanBuilderD.v0(runFragmentGuideVideoBinding2.f11852a.f12146a);
    }

    public final void pauseVideo() {
        CustomVideoView customVideoView = this.mVideo;
        if (customVideoView != null) {
            customVideoView.pause();
        }
    }
}
