package com.huachenjie.works.page.details.video;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.TouchGestureView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.databinding.WorksFragmentVideoWorkListBinding;
import com.huachenjie.works.page.comment.CommentDialog;
import com.huachenjie.works.page.details.video.VideoWorkListFragment;
import com.huachenjie.works.page.details.video.player.VideoListPlayer;
import com.huachenjie.works.page.share.OnShareSuccessCallback;
import com.huachenjie.works.page.share.a;
import com.igexin.push.g.o;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.zj.adlib.fx7;
import com.zj.adlib.i4a;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00029:B\u0007¢\u0006\u0004\b6\u00107J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004R\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010'R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00102\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010!\u001a\u0004\b0\u00101R\u001a\u00104\u001a\u000603R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/huachenjie/works/page/details/video/VideoWorkListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentVideoWorkListBinding;", "Lcom/huachenjie/works/page/details/video/VideoWorkListVM;", "", "isDarkFont", "", "showDarkStatusBar", "initAdapter", "initRefresh", "initViewPager", "initTouchGesture", "registerOnPageChangeCallback", "unregisterOnPageChangeCallback", "", "position", "Landroid/view/View;", "findCurrentViewContainer", "", "getVariables", "getLayoutResID", "initData", "initDataObservable", "initView", "Landroidx/recyclerview/widget/RecyclerView;", "findRecyclerView", "viewContainer", "onNewPageSelected", "onPageRelease", "open", "showVideoCommentOpen", "", "worksNo$delegate", "Lkotlin/Lazy;", "getWorksNo", "()Ljava/lang/String;", yj7.g.WORKS_NO, "fromMine$delegate", "getFromMine", "()Z", "fromMine", "canLoadMore$delegate", "getCanLoadMore", "canLoadMore", "autoScroll", "Z", "Lcom/huachenjie/works/page/details/video/player/VideoListPlayer;", "videoListPlayer$delegate", "getVideoListPlayer", "()Lcom/huachenjie/works/page/details/video/player/VideoListPlayer;", "videoListPlayer", "Lcom/huachenjie/works/page/details/video/VideoWorkListFragment$OnPageChangeListener;", "pagerChangeCallback", "Lcom/huachenjie/works/page/details/video/VideoWorkListFragment$OnPageChangeListener;", "<init>", "()V", "Companion", "a", "OnPageChangeListener", "works_release"}, k = 1, mv = {1, 8, 0})
public final class VideoWorkListFragment extends BaseMVVMFragment<WorksFragmentVideoWorkListBinding, VideoWorkListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_FROM_MINE = "from_mine";

    @NotNull
    private static final String KEY_LOAD_MORE = "canLoadMore";

    @NotNull
    private static final String KEY_WORKS_NO = "works_no";
    private boolean autoScroll;

    /* JADX INFO: renamed from: worksNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment$worksNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("works_no")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: fromMine$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fromMine = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment$fromMine$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m931invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("from_mine") : false);
        }
    });

    /* JADX INFO: renamed from: canLoadMore$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy canLoadMore = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment$canLoadMore$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m930invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(yj7.g.WORKS_LOAD_MORE) : false);
        }
    });

    /* JADX INFO: renamed from: videoListPlayer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoListPlayer = LazyKt.lazy(new Function0<VideoListPlayer>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment$videoListPlayer$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final VideoListPlayer m932invoke() {
            return new VideoListPlayer();
        }
    });

    @NotNull
    private OnPageChangeListener pagerChangeCallback = new OnPageChangeListener();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/details/video/VideoWorkListFragment$OnPageChangeListener;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "state", "onPageScrollStateChanged", "Ljava/util/concurrent/atomic/AtomicInteger;", "a", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "lastSelectedPosition", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "showBottomTip", "lastScrollState", "<init>", "(Lcom/huachenjie/works/page/details/video/VideoWorkListFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class OnPageChangeListener extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final AtomicInteger lastSelectedPosition = new AtomicInteger(-1);

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final AtomicBoolean showBottomTip = new AtomicBoolean(false);

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final AtomicInteger lastScrollState = new AtomicInteger(0);

        public OnPageChangeListener() {
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: from getter */
        public final AtomicInteger getLastSelectedPosition() {
            return this.lastSelectedPosition;
        }

        @NotNull
        /* JADX INFO: renamed from: b, reason: from getter */
        public final AtomicBoolean getShowBottomTip() {
            return this.showBottomTip;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            WorkVideoListAdapter value = VideoWorkListFragment.access$getMViewModel(VideoWorkListFragment.this).m().getValue();
            if (value != null && position == value.getData().size() - 1 && this.lastScrollState.get() == 1 && !this.showBottomTip.get() && positionOffsetPixels == 0) {
                this.showBottomTip.set(true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            i4a.a("OnPageChangeListener.onPageSelected:" + position);
            if (this.lastSelectedPosition.get() == position) {
                return;
            }
            i4a.a("lastSelectedPosition:" + this.lastSelectedPosition);
            WorkVideoListAdapter value = VideoWorkListFragment.access$getMViewModel(VideoWorkListFragment.this).m().getValue();
            if (value == null) {
                return;
            }
            int size = value.getData().size();
            int i = this.lastSelectedPosition.get();
            boolean z = false;
            if (i >= 0 && i < size) {
                z = true;
            }
            if (z) {
                VideoWorkListFragment.this.onPageRelease(this.lastSelectedPosition.get(), VideoWorkListFragment.this.findCurrentViewContainer(this.lastSelectedPosition.get()));
            }
            View viewFindCurrentViewContainer = VideoWorkListFragment.this.findCurrentViewContainer(position);
            if (viewFindCurrentViewContainer != null) {
                VideoWorkListFragment videoWorkListFragment = VideoWorkListFragment.this;
                this.lastSelectedPosition.set(position);
                videoWorkListFragment.onNewPageSelected(position, viewFindCurrentViewContainer);
            }
            if (value.getData().size() < 3) {
                if (position == value.getData().size() - 1) {
                    VideoWorkListFragment.access$getMViewModel(VideoWorkListFragment.this).A();
                }
            } else if (position == value.getData().size() - 3) {
                VideoWorkListFragment.access$getMViewModel(VideoWorkListFragment.this).A();
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.details.video.VideoWorkListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/details/video/VideoWorkListFragment$a;", "", "", yj7.g.WORKS_NO, "", "fromMine", "canLoadMore", "Lcom/huachenjie/works/page/details/video/VideoWorkListFragment;", "a", "KEY_FROM_MINE", "Ljava/lang/String;", "KEY_LOAD_MORE", "KEY_WORKS_NO", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoWorkListFragment a(@NotNull String worksNo, boolean fromMine, boolean canLoadMore) {
            Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
            VideoWorkListFragment videoWorkListFragment = new VideoWorkListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(VideoWorkListFragment.KEY_WORKS_NO, worksNo);
            bundle.putBoolean(VideoWorkListFragment.KEY_FROM_MINE, fromMine);
            bundle.putBoolean("canLoadMore", canLoadMore);
            videoWorkListFragment.setArguments(bundle);
            return videoWorkListFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/works/page/details/video/VideoWorkListFragment$b", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onShow", "onDismiss", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements BaseDialogFragment.DialogFragmentListener {
        public b() {
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onDismiss() {
            VideoWorkListFragment.this.showVideoCommentOpen(false);
        }

        @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
        public void onShow() {
            VideoWorkListFragment.this.showVideoCommentOpen(true);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/huachenjie/works/page/details/video/VideoWorkListFragment$c", "Lcom/huachenjie/common/widget/TouchGestureView$OnGestureChangeListener;", "", "onScaleStart", "", "scale", "", "onScale", "onScaleEnd", "", "scrollStatus", "Landroid/graphics/PointF;", "downPoint", "onScrollStart", "onScrollEnd", "b", "d", "a", "Z", "()Z", "c", "(Z)V", "onFullScreen", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends TouchGestureView.OnGestureChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        public boolean onFullScreen;

        public c() {
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getOnFullScreen() {
            return this.onFullScreen;
        }

        public final void b() {
            ViewPager2 viewPager2;
            i4a.a("hideFullScreen:" + this.onFullScreen);
            WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
            if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (viewPager2 = worksFragmentVideoWorkListBindingAccess$getMBinding.f36966a) == null) {
                return;
            }
            View viewFindCurrentViewContainer = VideoWorkListFragment.this.findCurrentViewContainer(viewPager2.getCurrentItem());
            if (viewFindCurrentViewContainer != null) {
                viewFindCurrentViewContainer.findViewById(R.id.vBottomContainer).setVisibility(0);
            }
            VideoWorkListFragment.this.getVideoListPlayer().q(false);
        }

        public final void c(boolean z) {
            this.onFullScreen = z;
        }

        public final void d() {
            ViewPager2 viewPager2;
            i4a.a("showFullScreen:" + this.onFullScreen);
            WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
            if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (viewPager2 = worksFragmentVideoWorkListBindingAccess$getMBinding.f36966a) == null) {
                return;
            }
            View viewFindCurrentViewContainer = VideoWorkListFragment.this.findCurrentViewContainer(viewPager2.getCurrentItem());
            if (viewFindCurrentViewContainer != null) {
                viewFindCurrentViewContainer.findViewById(R.id.vBottomContainer).setVisibility(8);
            }
            VideoWorkListFragment.this.getVideoListPlayer().q(true);
        }

        @Override // com.huachenjie.common.widget.TouchGestureView.OnGestureChangeListener
        public void onScale(float scale) {
            ViewPager2 viewPager2;
            i4a.a("onScale:" + scale);
            WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
            if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (viewPager2 = worksFragmentVideoWorkListBindingAccess$getMBinding.f36966a) == null) {
                return;
            }
            VideoWorkListFragment.this.getVideoListPlayer().J(scale, viewPager2);
        }

        @Override // com.huachenjie.common.widget.TouchGestureView.OnGestureChangeListener
        public void onScaleEnd() {
            ViewPager2 viewPager2;
            i4a.a("onScaleEnd");
            if (this.onFullScreen) {
                b();
            }
            WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
            if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (viewPager2 = worksFragmentVideoWorkListBindingAccess$getMBinding.f36966a) == null) {
                return;
            }
            VideoWorkListFragment.this.getVideoListPlayer().J(1.0f, viewPager2);
            this.onFullScreen = !this.onFullScreen;
        }

        @Override // com.huachenjie.common.widget.TouchGestureView.OnGestureChangeListener
        public boolean onScaleStart() {
            ViewPager2 viewPager2;
            i4a.a("onScaleStart");
            if (this.onFullScreen) {
                return true;
            }
            WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
            if (worksFragmentVideoWorkListBindingAccess$getMBinding != null && (viewPager2 = worksFragmentVideoWorkListBindingAccess$getMBinding.f36966a) != null) {
                int currentItem = viewPager2.getCurrentItem();
                WorkVideoListAdapter value = VideoWorkListFragment.access$getMViewModel(VideoWorkListFragment.this).m().getValue();
                if (value != null) {
                    if ((currentItem >= 0 && currentItem < value.getData().size()) && ((WorkDetailBean) value.getData().get(currentItem)).getPostType() == 2) {
                        d();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.huachenjie.common.widget.TouchGestureView.OnGestureChangeListener
        public void onScrollEnd(int scrollStatus) {
            i4a.a("onScrollEnd:" + this.onFullScreen);
            if (this.onFullScreen) {
                if (scrollStatus == 3 || scrollStatus == 4) {
                    b();
                    this.onFullScreen = !this.onFullScreen;
                }
            }
        }

        @Override // com.huachenjie.common.widget.TouchGestureView.OnGestureChangeListener
        public boolean onScrollStart(int scrollStatus, @NotNull PointF downPoint) {
            Intrinsics.checkNotNullParameter(downPoint, "downPoint");
            i4a.a("onScrollStart:" + this.onFullScreen);
            if (this.onFullScreen) {
                return scrollStatus == 3 || scrollStatus == 4;
            }
            return false;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37271a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37271a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37271a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37271a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentVideoWorkListBinding access$getMBinding(VideoWorkListFragment videoWorkListFragment) {
        return videoWorkListFragment.getMBinding();
    }

    public static final /* synthetic */ VideoWorkListVM access$getMViewModel(VideoWorkListFragment videoWorkListFragment) {
        return videoWorkListFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findCurrentViewContainer(int position) {
        ViewPager2 viewPager2;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f36966a) == null) {
            return null;
        }
        if (viewPager2.getChildCount() == 0) {
            i4a.a("childCount is 0");
            return null;
        }
        View view = ViewGroupKt.get(viewPager2, 0);
        if (!(view instanceof RecyclerView)) {
            return null;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(position);
        View view2 = viewHolderFindViewHolderForLayoutPosition != null ? viewHolderFindViewHolderForLayoutPosition.itemView : null;
        if (view2 == null) {
            i4a.a("mLayoutView is null");
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
            view2 = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
        }
        if (view2 == null) {
            i4a.a("mAdapterView is null");
        }
        return view2;
    }

    private final boolean getCanLoadMore() {
        return ((Boolean) this.canLoadMore.getValue()).booleanValue();
    }

    private final boolean getFromMine() {
        return ((Boolean) this.fromMine.getValue()).booleanValue();
    }

    private final String getWorksNo() {
        return (String) this.worksNo.getValue();
    }

    private final void initAdapter() {
        ViewPager2 viewPager2;
        MutableLiveData<WorkVideoListAdapter> mutableLiveDataM = getMViewModel().m();
        WorkVideoListAdapter workVideoListAdapter = new WorkVideoListAdapter();
        workVideoListAdapter.addChildClickViewIds(R.id.ivShare, R.id.tvShare, R.id.ivComment, R.id.tvComment, R.id.ivAvatar, R.id.ivBack, R.id.tvLevel);
        y57.b(workVideoListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.qp9
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VideoWorkListFragment.initAdapter$lambda$5$lambda$4(this.f44273a, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataM.setValue(workVideoListAdapter);
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f36966a) == null) {
            return;
        }
        viewPager2.setOrientation(1);
        viewPager2.setAdapter(getMViewModel().m().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$4(final VideoWorkListFragment videoWorkListFragment, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(videoWorkListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = baseQuickAdapter.getData().get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.works.bean.WorkDetailBean");
        final WorkDetailBean workDetailBean = (WorkDetailBean) obj;
        int id = view.getId();
        if (id == R.id.ivShare || id == R.id.tvShare) {
            FragmentManager childFragmentManager = videoWorkListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            a.c(workDetailBean, childFragmentManager, new OnShareSuccessCallback() { // from class: com.zj.adlib.op9
                @Override // com.huachenjie.works.page.share.OnShareSuccessCallback
                public final void a() {
                    VideoWorkListFragment.initAdapter$lambda$5$lambda$4$lambda$2(workDetailBean, videoWorkListFragment, i);
                }
            });
            return;
        }
        if (id == R.id.ivComment || id == R.id.tvComment) {
            CommentDialog commentDialogA = CommentDialog.INSTANCE.a(1, workDetailBean.getWorksNo(), workDetailBean.getUserInfo().getAppUserCode(), workDetailBean.getInteractInfo().getCommentCount(), 4, true, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment$initAdapter$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke(((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    TextView textView;
                    if (workDetailBean.getInteractInfo().getCommentCount() != i2) {
                        workDetailBean.getInteractInfo().setCommentCount(i2);
                        View viewFindCurrentViewContainer = videoWorkListFragment.findCurrentViewContainer(i);
                        if (viewFindCurrentViewContainer == null || (textView = (TextView) viewFindCurrentViewContainer.findViewById(R.id.tvComment)) == null) {
                            return;
                        }
                        textView.setText(workDetailBean.formatCommentCount());
                    }
                }
            });
            commentDialogA.setDialogFragmentListener(videoWorkListFragment.new b());
            FragmentManager childFragmentManager2 = videoWorkListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            commentDialogA.show(childFragmentManager2, CommentDialog.class.getName());
            return;
        }
        if (id == R.id.ivAvatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", workDetailBean.getUserInfo().getAppUserCode()).navigation();
            return;
        }
        if (id != R.id.ivBack) {
            if (id == R.id.tvLevel) {
                ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", workDetailBean.getChannelNo()).navigation();
            }
        } else {
            FragmentActivity activity = videoWorkListFragment.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$4$lambda$2(WorkDetailBean workDetailBean, VideoWorkListFragment videoWorkListFragment, int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(workDetailBean, "$bean");
        Intrinsics.checkNotNullParameter(videoWorkListFragment, "this$0");
        workDetailBean.setShareCount(workDetailBean.getShareCount() + 1);
        View viewFindCurrentViewContainer = videoWorkListFragment.findCurrentViewContainer(i);
        if (viewFindCurrentViewContainer == null || (textView = (TextView) viewFindCurrentViewContainer.findViewById(R.id.tvShare)) == null) {
            return;
        }
        textView.setText(workDetailBean.formatShareCount());
    }

    private final void initRefresh() {
        SmartRefreshLayout smartRefreshLayout;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (smartRefreshLayout = mBinding.f14353a) == null) {
            return;
        }
        if (!getCanLoadMore()) {
            smartRefreshLayout.setEnableRefresh(false);
            smartRefreshLayout.setEnableLoadMore(false);
            return;
        }
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setEnableAutoLoadMore(false);
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.pp9
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(RefreshLayout refreshLayout) {
                VideoWorkListFragment.initRefresh$lambda$6(this.f44039a, refreshLayout);
            }
        });
        smartRefreshLayout.setDisableContentWhenLoading(true);
        smartRefreshLayout.setEnableHeaderTranslationContent(false);
        smartRefreshLayout.setEnableScrollContentWhenLoaded(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRefresh$lambda$6(VideoWorkListFragment videoWorkListFragment, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(videoWorkListFragment, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, o.f);
        videoWorkListFragment.getMViewModel().A();
    }

    private final void initTouchGesture() {
        TouchGestureView touchGestureView;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (touchGestureView = mBinding.f14351a) == null) {
            return;
        }
        touchGestureView.setGestureListener(new c());
    }

    private final void initViewPager() {
        RecyclerView recyclerViewFindRecyclerView = findRecyclerView();
        if (recyclerViewFindRecyclerView == null) {
            return;
        }
        recyclerViewFindRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment.initViewPager.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NotNull View view) {
                RecyclerView.LayoutManager layoutManager;
                Intrinsics.checkNotNullParameter(view, "view");
                RecyclerView recyclerViewFindRecyclerView2 = VideoWorkListFragment.this.findRecyclerView();
                int position = (recyclerViewFindRecyclerView2 == null || (layoutManager = recyclerViewFindRecyclerView2.getLayoutManager()) == null) ? -1 : layoutManager.getPosition(view);
                i4a.a("onChildViewAttachedToWindow:" + position);
                if (VideoWorkListFragment.this.pagerChangeCallback.getLastSelectedPosition().get() == -1 && position > -1) {
                    VideoWorkListFragment.this.pagerChangeCallback.getLastSelectedPosition().set(position);
                    VideoWorkListFragment.this.onNewPageSelected(position, view);
                } else {
                    if (!VideoWorkListFragment.this.autoScroll || VideoWorkListFragment.this.pagerChangeCallback.getLastSelectedPosition().get() == position) {
                        return;
                    }
                    VideoWorkListFragment.this.autoScroll = false;
                    VideoWorkListFragment.this.pagerChangeCallback.getLastSelectedPosition().set(position);
                    VideoWorkListFragment.this.onNewPageSelected(position, view);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        });
        registerOnPageChangeCallback();
    }

    private final void registerOnPageChangeCallback() {
        ViewPager2 viewPager2;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f36966a) == null) {
            return;
        }
        this.pagerChangeCallback.getLastSelectedPosition().set(-1);
        this.pagerChangeCallback.getShowBottomTip().set(false);
        viewPager2.registerOnPageChangeCallback(this.pagerChangeCallback);
    }

    private final void showDarkStatusBar(boolean isDarkFont) {
        e.z3(this).G2(R.color.transparent).T2(isDarkFont).u1(R.color.white).G1(true).a1();
    }

    private final void unregisterOnPageChangeCallback() {
        ViewPager2 viewPager2;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f36966a) == null) {
            return;
        }
        viewPager2.unregisterOnPageChangeCallback(this.pagerChangeCallback);
    }

    @Nullable
    public final RecyclerView findRecyclerView() {
        ViewPager2 viewPager2;
        WorksFragmentVideoWorkListBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f36966a) == null) {
            return null;
        }
        if (viewPager2.getChildCount() == 0) {
            i4a.a("childCount is 0");
            return null;
        }
        View view = ViewGroupKt.get(viewPager2, 0);
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        return null;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_video_work_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, VideoWorkListVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @NotNull
    public final VideoListPlayer getVideoListPlayer() {
        return (VideoListPlayer) this.videoListPlayer.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().z().setValue(getWorksNo());
        getMViewModel().o().setValue(Boolean.valueOf(getFromMine()));
        getMViewModel().n().setValue(Boolean.valueOf(getCanLoadMore()));
        VideoWorkListVM mViewModel = getMViewModel();
        String worksNo = getWorksNo();
        Intrinsics.checkNotNullExpressionValue(worksNo, yj7.g.WORKS_NO);
        mViewModel.y(worksNo);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().x().observe(this, new d(new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<String>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<String> list) {
                if (list != null) {
                    VideoWorkListFragment videoWorkListFragment = VideoWorkListFragment.this;
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        videoWorkListFragment.getVideoListPlayer().p((String) it.next());
                    }
                }
            }
        }));
        getMViewModel().q().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                SmartRefreshLayout smartRefreshLayout;
                WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
                if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (smartRefreshLayout = worksFragmentVideoWorkListBindingAccess$getMBinding.f14353a) == null) {
                    return;
                }
                smartRefreshLayout.finishLoadMore();
            }
        }));
        getMViewModel().r().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListFragment.initDataObservable.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                SmartRefreshLayout smartRefreshLayout;
                WorksFragmentVideoWorkListBinding worksFragmentVideoWorkListBindingAccess$getMBinding = VideoWorkListFragment.access$getMBinding(VideoWorkListFragment.this);
                if (worksFragmentVideoWorkListBindingAccess$getMBinding == null || (smartRefreshLayout = worksFragmentVideoWorkListBindingAccess$getMBinding.f14353a) == null) {
                    return;
                }
                smartRefreshLayout.finishLoadMoreWithNoMoreData();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        showDarkStatusBar(false);
        Context context = getContext();
        if (context != null) {
            getVideoListPlayer().s(context);
            getLifecycle().addObserver(getVideoListPlayer());
        }
        initAdapter();
        initRefresh();
        initViewPager();
        initTouchGesture();
    }

    public final void onNewPageSelected(int position, @Nullable View viewContainer) {
        FrameLayout frameLayout;
        i4a.a("onNewPageSelected:" + position);
        WorkVideoListAdapter value = getMViewModel().m().getValue();
        if (value == null) {
            return;
        }
        boolean z = false;
        if (position >= 0 && position < value.getData().size()) {
            z = true;
        }
        if (!z) {
            i4a.a("position error:" + position);
            return;
        }
        WorkDetailBean workDetailBean = (WorkDetailBean) value.getData().get(position);
        if (viewContainer == null) {
            i4a.a("currentViewContainer is null");
        } else if (workDetailBean.getPostType() == 2 && (frameLayout = (FrameLayout) viewContainer.findViewById(R.id.works_video_container)) != null) {
            getVideoListPlayer().H(workDetailBean.formatVideoUrl(), frameLayout);
        }
    }

    public final void onPageRelease(int position, @Nullable View viewContainer) {
        i4a.a("onPageRelease:" + position);
        WorkVideoListAdapter value = getMViewModel().m().getValue();
        if (value == null) {
            return;
        }
        boolean z = false;
        if (position >= 0 && position < value.getData().size()) {
            z = true;
        }
        if (z) {
            WorkDetailBean workDetailBean = (WorkDetailBean) value.getData().get(position);
            if (workDetailBean.getPostType() == 2 && !workDetailBean.showVideoViolation()) {
                i4a.a("stopPlay");
                getVideoListPlayer().O();
            }
        }
    }

    public final void showVideoCommentOpen(boolean open) {
        int height;
        WorksFragmentVideoWorkListBinding mBinding;
        ViewPager2 viewPager2;
        View viewFindCurrentViewContainer;
        ViewGroup.LayoutParams layoutParams;
        WorksFragmentVideoWorkListBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (height = mBinding2.getRoot().getHeight()) == 0 || (mBinding = getMBinding()) == null || (viewPager2 = mBinding.f36966a) == null) {
            return;
        }
        int currentItem = viewPager2.getCurrentItem();
        WorkVideoListAdapter value = getMViewModel().m().getValue();
        if (value == null) {
            return;
        }
        if ((currentItem >= 0 && currentItem < value.getData().size()) && (viewFindCurrentViewContainer = findCurrentViewContainer(currentItem)) != null) {
            View viewFindViewById = viewFindCurrentViewContainer.findViewById(R.id.worksTextureView);
            if (viewFindViewById != null && (layoutParams = viewFindViewById.getLayoutParams()) != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams ?: return@apply");
                if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                    ((ConstraintLayout.LayoutParams) layoutParams).bottomToBottom = open ? -1 : 0;
                }
                layoutParams.height = open ? (int) (((double) fx7.h()) * 0.34d) : height;
                viewFindViewById.setLayoutParams(layoutParams);
            }
            View viewFindViewById2 = viewFindCurrentViewContainer.findViewById(R.id.ivPlayButton);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setScaleX(open ? 0.34f : 1.0f);
                viewFindViewById2.setScaleY(open ? 0.34f : 1.0f);
            }
            View viewFindViewById3 = viewFindCurrentViewContainer.findViewById(R.id.video_cover);
            if (viewFindViewById3 != null) {
                ViewGroup.LayoutParams layoutParams2 = viewFindViewById3.getLayoutParams();
                if (open) {
                    height = (int) (((double) fx7.h()) * 0.34d);
                }
                layoutParams2.height = height;
            }
            View viewFindViewById4 = viewFindCurrentViewContainer.findViewById(R.id.vBottomContainer);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(open ? 8 : 0);
            }
        }
    }
}
