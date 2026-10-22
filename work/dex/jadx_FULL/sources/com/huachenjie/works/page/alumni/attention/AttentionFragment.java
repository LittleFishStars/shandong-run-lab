package com.huachenjie.works.page.alumni.attention;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aliyun.player.AliPlayer;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.broadcast.works.WorkOperateListener;
import com.huachenjie.base.broadcast.works.WorkOperateReceiver;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.databinding.WorksFragmentAlumniAttentionBinding;
import com.huachenjie.works.external.widget.BLOperateAnimView;
import com.huachenjie.works.page.alumni.attention.AttentionFragment;
import com.huachenjie.works.page.comment.CommentDialog;
import com.huachenjie.works.page.publish.delegate.PublishWorksDelegate;
import com.huachenjie.works.page.share.OnShareSuccessCallback;
import com.igexin.push.g.o;
import com.zj.adlib.fx7;
import com.zj.adlib.i4a;
import com.zj.adlib.jd0;
import com.zj.adlib.oz9;
import com.zj.adlib.qk0;
import com.zj.adlib.rh2;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013*\u00019\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010)\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010*\u001a\u00020\u0006H\u0016R\u0014\u0010,\u001a\u00020+8\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00103\u001a\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010I\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00103\u001a\u0004\bG\u0010HR\u001b\u0010M\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00103\u001a\u0004\bK\u0010LR\u001b\u0010P\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00103\u001a\u0004\bO\u0010HR\u001b\u0010S\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u00103\u001a\u0004\bR\u0010H¨\u0006V"}, d2 = {"Lcom/huachenjie/works/page/alumni/attention/AttentionFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentAlumniAttentionBinding;", "Lcom/huachenjie/works/page/alumni/attention/AttentionVM;", "", "position", "", "onCurrentPageChanged", "onCurrentPagePause", "onCurrentPageResume", "Landroid/view/View;", "view", "onCurrentPageDestroy", "", "newProgress", "startAnimation", "progress", "dealPublishProgress", "viewWidth", "screenWidth", "currentWidth", "fixProgressTranslationX", "initAdapter", "lastPosition", "onVisibleItemChanged", "", "play", "controlPlayStatus", "pausePlay", "resumePlay", "findViewContainerByPosition", "", "", "getVariables", "getLayoutResID", "onFragmentResume", "onFragmentPause", "onViewCreated", "onDestroyView", "initView", "findPlayViewByPosition", "getViewVisibleHeight", "initData", "", "TAG", "Ljava/lang/String;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/zj/adlib/jd0;", "videoPlayer$delegate", "Lkotlin/Lazy;", "getVideoPlayer", "()Lcom/zj/adlib/jd0;", "videoPlayer", "currentPosition", "I", "com/huachenjie/works/page/alumni/attention/AttentionFragment$mWorksProgressReceiver$2$1", "mWorksProgressReceiver$delegate", "getMWorksProgressReceiver", "()Lcom/huachenjie/works/page/alumni/attention/AttentionFragment$mWorksProgressReceiver$2$1;", "mWorksProgressReceiver", "Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "worksOperateReceiver$delegate", "getWorksOperateReceiver", "()Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "worksOperateReceiver", "Landroid/animation/ValueAnimator;", "valueAnimation", "Landroid/animation/ValueAnimator;", "appScreenWidth$delegate", "getAppScreenWidth", "()I", "appScreenWidth", "progressUnitWidth$delegate", "getProgressUnitWidth", "()F", "progressUnitWidth", "iconWidth$delegate", "getIconWidth", "iconWidth", "progressTextWidth$delegate", "getProgressTextWidth", "progressTextWidth", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttentionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttentionFragment.kt\ncom/huachenjie/works/page/alumni/attention/AttentionFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,571:1\n1#2:572\n*E\n"})
public final class AttentionFragment extends BaseMVVMFragment<WorksFragmentAlumniAttentionBinding, AttentionVM> {

    @Nullable
    private ValueAnimator valueAnimation;

    @NotNull
    private final String TAG = "attention";

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.yc0
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            AttentionFragment.onRefreshListener$lambda$1(this.f45994a);
        }
    };

    /* JADX INFO: renamed from: videoPlayer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoPlayer = LazyKt.lazy(new Function0<jd0>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$videoPlayer$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final jd0 m839invoke() {
            return new jd0();
        }
    });
    private int currentPosition = -1;

    /* JADX INFO: renamed from: mWorksProgressReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mWorksProgressReceiver = LazyKt.lazy(new Function0<AttentionFragment$mWorksProgressReceiver$2.AnonymousClass1>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$mWorksProgressReceiver$2
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.works.page.alumni.attention.AttentionFragment$mWorksProgressReceiver$2$1] */
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnonymousClass1 m836invoke() {
            final AttentionFragment attentionFragment = this.this$0;
            return new BroadcastReceiver() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$mWorksProgressReceiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    int intExtra = intent != null ? intent.getIntExtra("progress", 0) : 0;
                    attentionFragment.startAnimation(intExtra);
                    i4a.f("upload progress: " + intExtra);
                }
            };
        }
    });

    /* JADX INFO: renamed from: worksOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksOperateReceiver = LazyKt.lazy(new Function0<WorkOperateReceiver>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$worksOperateReceiver$2

        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/works/page/alumni/attention/AttentionFragment$worksOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/works/WorkOperateListener;", "", "workNo", "", "isChecked", "", "likeCount", "", "d", "collectedCount", "b", "Landroid/os/Parcelable;", "worksDetail", "f", "works_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nAttentionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttentionFragment.kt\ncom/huachenjie/works/page/alumni/attention/AttentionFragment$worksOperateReceiver$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,571:1\n350#2,7:572\n350#2,7:579\n*S KotlinDebug\n*F\n+ 1 AttentionFragment.kt\ncom/huachenjie/works/page/alumni/attention/AttentionFragment$worksOperateReceiver$2$1\n*L\n102#1:572,7\n120#1:579,7\n*E\n"})
        public static final class a implements WorkOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AttentionFragment f37154a;

            public a(AttentionFragment attentionFragment) {
                this.f37154a = attentionFragment;
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void b(@NotNull String workNo, boolean isChecked, int collectedCount) {
                AttentionWorksAdapter value;
                BLOperateAnimView bLOperateAnimView;
                Intrinsics.checkNotNullParameter(workNo, "workNo");
                if (TextUtils.isEmpty(workNo) || (value = this.f37154a.getMViewModel().o().getValue()) == null) {
                    return;
                }
                Iterator it = value.getData().iterator();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(((WorkDetailBean) it.next()).getWorksNo(), workNo)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && i < value.getData().size()) {
                    z = true;
                }
                if (z) {
                    ((WorkDetailBean) value.getData().get(i)).setCollected(isChecked, collectedCount);
                    View viewFindViewContainerByPosition = this.f37154a.findViewContainerByPosition(i);
                    if (viewFindViewContainerByPosition == null || (bLOperateAnimView = (BLOperateAnimView) viewFindViewContainerByPosition.findViewById(R.id.llCollection)) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(bLOperateAnimView, "findViewById<BLOperateAnimView>(R.id.llCollection)");
                    bLOperateAnimView.setCheckedStateAtOnce(isChecked, collectedCount);
                }
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void d(@NotNull String workNo, boolean isChecked, int likeCount) {
                AttentionWorksAdapter value;
                BLOperateAnimView bLOperateAnimView;
                Intrinsics.checkNotNullParameter(workNo, "workNo");
                if (TextUtils.isEmpty(workNo) || (value = this.f37154a.getMViewModel().o().getValue()) == null) {
                    return;
                }
                Iterator it = value.getData().iterator();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(((WorkDetailBean) it.next()).getWorksNo(), workNo)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && i < value.getData().size()) {
                    z = true;
                }
                if (z) {
                    ((WorkDetailBean) value.getData().get(i)).setLiked(isChecked, likeCount);
                    View viewFindViewContainerByPosition = this.f37154a.findViewContainerByPosition(i);
                    if (viewFindViewContainerByPosition == null || (bLOperateAnimView = (BLOperateAnimView) viewFindViewContainerByPosition.findViewById(R.id.llLike)) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(bLOperateAnimView, "findViewById<BLOperateAnimView>(R.id.llLike)");
                    bLOperateAnimView.setCheckedStateAtOnce(isChecked, likeCount);
                }
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void f(@Nullable Parcelable worksDetail) {
                RecyclerView recyclerView;
                if (worksDetail instanceof WorkDetailBean) {
                    i4a.b(this.f37154a.TAG, "PublishedWorksDetail");
                    this.f37154a.currentPosition = -1;
                    this.f37154a.getMViewModel().u((WorkDetailBean) worksDetail);
                    WorksFragmentAlumniAttentionBinding worksFragmentAlumniAttentionBindingAccess$getMBinding = AttentionFragment.access$getMBinding(this.f37154a);
                    if (worksFragmentAlumniAttentionBindingAccess$getMBinding == null || (recyclerView = worksFragmentAlumniAttentionBindingAccess$getMBinding.f14141a) == null) {
                        return;
                    }
                    recyclerView.scrollToPosition(0);
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorkOperateReceiver m840invoke() {
            return new WorkOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: appScreenWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appScreenWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$appScreenWidth$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m834invoke() {
            return Integer.valueOf(fx7.e());
        }
    });

    /* JADX INFO: renamed from: progressUnitWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy progressUnitWidth = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$progressUnitWidth$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m838invoke() {
            return Float.valueOf(this.this$0.getAppScreenWidth() / 100.0f);
        }
    });

    /* JADX INFO: renamed from: iconWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy iconWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$iconWidth$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m835invoke() {
            return Integer.valueOf(SizeUtils.b(18.0f));
        }
    });

    /* JADX INFO: renamed from: progressTextWidth$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy progressTextWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$progressTextWidth$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m837invoke() {
            return Integer.valueOf(SizeUtils.b(38.0f));
        }
    });

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/works/page/alumni/attention/AttentionFragment$a", "Lcom/zj/adlib/rh2;", "Lcom/aliyun/player/AliPlayer;", "aliPlayer", "", "a", "", "showCover", "b", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends rh2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f37150a;

        public a(FrameLayout frameLayout) {
            this.f37150a = frameLayout;
        }

        @Override // com.zj.adlib.rh2, com.huachenjie.common.video.OnPlayerCallback
        public void a(@Nullable AliPlayer aliPlayer) {
            AttentionFragment.this.getVideoPlayer().i(this.f37150a);
        }

        @Override // com.zj.adlib.rh2, com.huachenjie.common.video.OnPlayerCallback
        public void b(boolean showCover) {
            View viewFindViewWithTag = this.f37150a.findViewWithTag(AttentionWorksAdapter.f);
            if (viewFindViewWithTag != null) {
                viewFindViewWithTag.setVisibility(showCover ? 0 : 8);
            }
            View viewFindViewWithTag2 = this.f37150a.findViewWithTag(AttentionWorksAdapter.g);
            if (viewFindViewWithTag2 != null) {
                viewFindViewWithTag2.setVisibility(showCover ? 0 : 8);
            }
        }
    }

    public static final /* synthetic */ WorksFragmentAlumniAttentionBinding access$getMBinding(AttentionFragment attentionFragment) {
        return attentionFragment.getMBinding();
    }

    private final void controlPlayStatus(int position, boolean play) {
        List<T> data;
        View viewFindViewContainerByPosition;
        FrameLayout frameLayout;
        if (getVideoPlayer().t()) {
            getVideoPlayer().v();
        }
        AttentionWorksAdapter value = getMViewModel().o().getValue();
        if (value == null || (data = value.getData()) == 0) {
            return;
        }
        if ((position >= 0 && position < data.size()) && (viewFindViewContainerByPosition = findViewContainerByPosition(position)) != null) {
            WorkDetailBean workDetailBean = (WorkDetailBean) data.get(position);
            int attachmentType = workDetailBean.getAttachmentType();
            if (attachmentType == 1) {
                CommonBanner commonBanner = (CommonBanner) viewFindViewContainerByPosition.findViewById(R.id.works_banner);
                if (commonBanner != null) {
                    if (!play) {
                        workDetailBean.setStartPosition(commonBanner.getCurrentItem());
                        i4a.a(position + " -> end:" + workDetailBean.getStartPosition());
                        commonBanner.stop();
                        return;
                    }
                    i4a.a(position + " -> start:" + workDetailBean.getStartPosition());
                    commonBanner.setCurrentItem(workDetailBean.getStartPosition(), false);
                    commonBanner.isAutoLoop(true);
                    commonBanner.start();
                    return;
                }
                return;
            }
            if (attachmentType != 2 || workDetailBean.showVideoViolation() || (frameLayout = (FrameLayout) viewFindViewContainerByPosition.findViewById(R.id.fl_works_container)) == null) {
                return;
            }
            if (!play) {
                getVideoPlayer().j(frameLayout);
                View viewFindViewWithTag = frameLayout.findViewWithTag(AttentionWorksAdapter.f);
                if (viewFindViewWithTag != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewWithTag, "findViewWithTag<View>(At…onWorksAdapter.COVER_TAG)");
                    viewFindViewWithTag.setVisibility(0);
                }
                View viewFindViewWithTag2 = frameLayout.findViewWithTag(AttentionWorksAdapter.g);
                if (viewFindViewWithTag2 != null) {
                    viewFindViewWithTag2.setVisibility(0);
                    return;
                }
                return;
            }
            getVideoPlayer().y(new a(frameLayout));
            i4a.b(this.TAG, "mIsVisibleToUser:" + getMIsVisibleToUser());
            if (getMIsVisibleToUser()) {
                getVideoPlayer().w(workDetailBean.formatVideoUrl());
            } else {
                this.currentPosition = position;
            }
        }
    }

    private final void dealPublishProgress(float progress) {
        getMViewModel().p().setValue(Integer.valueOf((int) progress));
        boolean z = false;
        if (0.0f <= progress && progress <= 100.0f) {
            z = true;
        }
        if (z) {
            float progressUnitWidth = progress * getProgressUnitWidth();
            getMViewModel().s().setValue(Float.valueOf(fixProgressTranslationX(getIconWidth(), getAppScreenWidth(), progressUnitWidth)));
            getMViewModel().t().setValue(Float.valueOf(fixProgressTranslationX(getProgressTextWidth(), getAppScreenWidth(), progressUnitWidth)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findViewContainerByPosition(int position) {
        RecyclerView recyclerView;
        WorksFragmentAlumniAttentionBinding mBinding = getMBinding();
        if (mBinding == null || (recyclerView = mBinding.f14141a) == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(position);
        View view = viewHolderFindViewHolderForLayoutPosition != null ? viewHolderFindViewHolderForLayoutPosition.itemView : null;
        if (view == null) {
            i4a.a("mLayoutView is null");
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
            view = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
        }
        if (view == null) {
            i4a.a("mAdapterView is null");
        }
        return view;
    }

    private final float fixProgressTranslationX(int viewWidth, int screenWidth, float currentWidth) {
        float f = viewWidth;
        return Math.min(screenWidth - f, Math.max(0.0f, currentWidth - (f / 2.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAppScreenWidth() {
        return ((Number) this.appScreenWidth.getValue()).intValue();
    }

    private final int getIconWidth() {
        return ((Number) this.iconWidth.getValue()).intValue();
    }

    private final AttentionFragment$mWorksProgressReceiver$2.AnonymousClass1 getMWorksProgressReceiver() {
        return (AttentionFragment$mWorksProgressReceiver$2.AnonymousClass1) this.mWorksProgressReceiver.getValue();
    }

    private final int getProgressTextWidth() {
        return ((Number) this.progressTextWidth.getValue()).intValue();
    }

    private final float getProgressUnitWidth() {
        return ((Number) this.progressUnitWidth.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jd0 getVideoPlayer() {
        return (jd0) this.videoPlayer.getValue();
    }

    private final WorkOperateReceiver getWorksOperateReceiver() {
        return (WorkOperateReceiver) this.worksOperateReceiver.getValue();
    }

    private final void initAdapter() {
        final AttentionWorksAdapter attentionWorksAdapter = new AttentionWorksAdapter(this);
        attentionWorksAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.ad0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AttentionFragment.initAdapter$lambda$9$lambda$8(this.f40508a);
            }
        });
        getMViewModel().o().setValue(attentionWorksAdapter);
        attentionWorksAdapter.addChildClickViewIds(R.id.llShare, R.id.llComment, R.id.ivAvatar);
        y57.b(attentionWorksAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.bd0
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AttentionFragment.initAdapter$lambda$12(attentionWorksAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$12(AttentionWorksAdapter attentionWorksAdapter, final AttentionFragment attentionFragment, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(attentionWorksAdapter, "$mAdapter");
        Intrinsics.checkNotNullParameter(attentionFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final WorkDetailBean workDetailBean = (WorkDetailBean) attentionWorksAdapter.getItem(i);
        int id = view.getId();
        if (id == R.id.llShare) {
            FragmentManager childFragmentManager = attentionFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            com.huachenjie.works.page.share.a.c(workDetailBean, childFragmentManager, new OnShareSuccessCallback() { // from class: com.zj.adlib.zc0
                @Override // com.huachenjie.works.page.share.OnShareSuccessCallback
                public final void a() {
                    AttentionFragment.initAdapter$lambda$12$lambda$11(workDetailBean, attentionFragment, i);
                }
            });
        } else if (id != R.id.llComment) {
            if (id == R.id.ivAvatar) {
                ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", workDetailBean.getUserInfo().getAppUserCode()).navigation();
            }
        } else {
            CommentDialog commentDialogA = CommentDialog.INSTANCE.a(1, workDetailBean.getWorksNo(), workDetailBean.getUserInfo().getAppUserCode(), workDetailBean.getInteractInfo().getCommentCount(), 4, true, new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment$initAdapter$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    TextView textView;
                    if (workDetailBean.getInteractInfo().getCommentCount() != i2) {
                        workDetailBean.getInteractInfo().setCommentCount(i2);
                        View viewFindViewContainerByPosition = attentionFragment.findViewContainerByPosition(i);
                        if (viewFindViewContainerByPosition == null || (textView = (TextView) viewFindViewContainerByPosition.findViewById(R.id.tvComment)) == null) {
                            return;
                        }
                        textView.setText(workDetailBean.formatCommentCount());
                    }
                }
            });
            FragmentManager childFragmentManager2 = attentionFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            commentDialogA.show(childFragmentManager2, CommentDialog.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$12$lambda$11(WorkDetailBean workDetailBean, AttentionFragment attentionFragment, int i) {
        TextView textView;
        Intrinsics.checkNotNullParameter(workDetailBean, "$bean");
        Intrinsics.checkNotNullParameter(attentionFragment, "this$0");
        workDetailBean.setShareCount(workDetailBean.getShareCount() + 1);
        View viewFindViewContainerByPosition = attentionFragment.findViewContainerByPosition(i);
        if (viewFindViewContainerByPosition == null || (textView = (TextView) viewFindViewContainerByPosition.findViewById(R.id.tvShare)) == null) {
            return;
        }
        textView.setText(workDetailBean.formatShareCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$9$lambda$8(AttentionFragment attentionFragment) {
        Intrinsics.checkNotNullParameter(attentionFragment, "this$0");
        attentionFragment.getMViewModel().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCurrentPageChanged(int position) {
        onVisibleItemChanged(this.currentPosition, position);
        this.currentPosition = position;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCurrentPageDestroy(int position, View view) {
        List<T> data;
        FrameLayout frameLayout;
        this.currentPosition = -1;
        getVideoPlayer().v();
        AttentionWorksAdapter value = getMViewModel().o().getValue();
        if (value == null || (data = value.getData()) == 0) {
            return;
        }
        if (position >= 0 && position < data.size()) {
            WorkDetailBean workDetailBean = (WorkDetailBean) data.get(position);
            int attachmentType = workDetailBean.getAttachmentType();
            if (attachmentType == 1) {
                CommonBanner commonBanner = (CommonBanner) view.findViewById(R.id.works_banner);
                if (commonBanner != null) {
                    workDetailBean.setStartPosition(commonBanner.getCurrentItem());
                    i4a.a(position + " -> end:" + workDetailBean.getStartPosition());
                    commonBanner.stop();
                    return;
                }
                return;
            }
            if (attachmentType != 2 || workDetailBean.showVideoViolation() || (frameLayout = (FrameLayout) view.findViewById(R.id.fl_works_container)) == null) {
                return;
            }
            getVideoPlayer().j(frameLayout);
            View viewFindViewWithTag = frameLayout.findViewWithTag(AttentionWorksAdapter.f);
            if (viewFindViewWithTag != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewWithTag, "findViewWithTag<View>(At…onWorksAdapter.COVER_TAG)");
                viewFindViewWithTag.setVisibility(0);
            }
            View viewFindViewWithTag2 = frameLayout.findViewWithTag(AttentionWorksAdapter.g);
            if (viewFindViewWithTag2 != null) {
                viewFindViewWithTag2.setVisibility(0);
            }
        }
    }

    private final void onCurrentPagePause(int position) {
        pausePlay(position);
    }

    private final void onCurrentPageResume(int position) {
        resumePlay(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$1(AttentionFragment attentionFragment) {
        Intrinsics.checkNotNullParameter(attentionFragment, "this$0");
        int i = attentionFragment.currentPosition;
        if (i != -1) {
            View viewFindViewContainerByPosition = attentionFragment.findViewContainerByPosition(i);
            if (viewFindViewContainerByPosition != null) {
                attentionFragment.onCurrentPageDestroy(attentionFragment.currentPosition, viewFindViewContainerByPosition);
            }
            attentionFragment.currentPosition = -1;
        }
        attentionFragment.getMViewModel().y();
    }

    private final void onVisibleItemChanged(int lastPosition, int position) {
        controlPlayStatus(lastPosition, false);
        controlPlayStatus(position, true);
    }

    private final void pausePlay(int position) {
        List<T> data;
        View viewFindViewContainerByPosition;
        AttentionWorksAdapter value = getMViewModel().o().getValue();
        if (value == null || (data = value.getData()) == 0) {
            return;
        }
        boolean z = false;
        if (position >= 0 && position < data.size()) {
            z = true;
        }
        if (z && (viewFindViewContainerByPosition = findViewContainerByPosition(position)) != null) {
            WorkDetailBean workDetailBean = (WorkDetailBean) data.get(position);
            int attachmentType = workDetailBean.getAttachmentType();
            if (attachmentType != 1) {
                if (attachmentType != 2 || workDetailBean.showVideoViolation() || ((FrameLayout) viewFindViewContainerByPosition.findViewById(R.id.fl_works_container)) == null) {
                    return;
                }
                getVideoPlayer().v();
                return;
            }
            CommonBanner commonBanner = (CommonBanner) viewFindViewContainerByPosition.findViewById(R.id.works_banner);
            if (commonBanner != null) {
                workDetailBean.setStartPosition(commonBanner.getCurrentItem());
                i4a.a(position + " -> end:" + workDetailBean.getStartPosition());
                commonBanner.stop();
            }
        }
    }

    private final void resumePlay(int position) {
        List<T> data;
        View viewFindViewContainerByPosition;
        AttentionWorksAdapter value = getMViewModel().o().getValue();
        if (value == null || (data = value.getData()) == 0) {
            return;
        }
        if ((position >= 0 && position < data.size()) && (viewFindViewContainerByPosition = findViewContainerByPosition(position)) != null) {
            WorkDetailBean workDetailBean = (WorkDetailBean) data.get(position);
            int attachmentType = workDetailBean.getAttachmentType();
            if (attachmentType != 1) {
                if (attachmentType != 2 || workDetailBean.showVideoViolation() || ((FrameLayout) viewFindViewContainerByPosition.findViewById(R.id.fl_works_container)) == null) {
                    return;
                }
                getVideoPlayer().x();
                return;
            }
            CommonBanner commonBanner = (CommonBanner) viewFindViewContainerByPosition.findViewById(R.id.works_banner);
            if (commonBanner != null) {
                i4a.a(position + " -> start:" + workDetailBean.getStartPosition());
                commonBanner.setCurrentItem(workDetailBean.getStartPosition(), false);
                commonBanner.isAutoLoop(true);
                commonBanner.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation(float newProgress) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (!(0.0f <= newProgress && newProgress <= 100.0f)) {
            ValueAnimator valueAnimator3 = this.valueAnimation;
            if ((valueAnimator3 != null && valueAnimator3.isRunning()) && (valueAnimator2 = this.valueAnimation) != null) {
                valueAnimator2.cancel();
            }
            getMViewModel().p().setValue(Integer.valueOf((int) newProgress));
            return;
        }
        Integer value = getMViewModel().p().getValue();
        if (value == null) {
            value = 0;
        }
        float fMax = Math.max(0.0f, value.intValue());
        if ((newProgress == 0.0f) || fMax < newProgress) {
            ValueAnimator valueAnimator4 = this.valueAnimation;
            if ((valueAnimator4 != null && valueAnimator4.isRunning()) && (valueAnimator = this.valueAnimation) != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fMax, newProgress);
            this.valueAnimation = valueAnimatorOfFloat;
            if (valueAnimatorOfFloat != null) {
                valueAnimatorOfFloat.setDuration(500L);
            }
            ValueAnimator valueAnimator5 = this.valueAnimation;
            if (valueAnimator5 != null) {
                valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.cd0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                        AttentionFragment.startAnimation$lambda$7(this.f40948a, valueAnimator6);
                    }
                });
            }
            ValueAnimator valueAnimator6 = this.valueAnimation;
            if (valueAnimator6 != null) {
                valueAnimator6.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$7(AttentionFragment attentionFragment, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(attentionFragment, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, o.f);
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        attentionFragment.dealPublishProgress(((Float) animatedValue).floatValue());
    }

    @Nullable
    public final View findPlayViewByPosition(int position) {
        List<T> data;
        View viewFindViewContainerByPosition;
        AttentionWorksAdapter value = getMViewModel().o().getValue();
        if (value == null || (data = value.getData()) == 0) {
            return null;
        }
        boolean z = false;
        if (position >= 0 && position < data.size()) {
            z = true;
        }
        if (!z || (viewFindViewContainerByPosition = findViewContainerByPosition(position)) == null) {
            return null;
        }
        int attachmentType = ((WorkDetailBean) data.get(position)).getAttachmentType();
        if (attachmentType == 1) {
            return viewFindViewContainerByPosition.findViewById(R.id.works_banner);
        }
        if (attachmentType != 2) {
            return null;
        }
        return viewFindViewContainerByPosition.findViewById(R.id.fl_works_container);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_alumni_attention;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    public final float getViewVisibleHeight(@Nullable View view) {
        if (view == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0f;
        }
        return rect.height() / view.getHeight();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        this.currentPosition = -1;
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        WorksFragmentAlumniAttentionBinding mBinding = getMBinding();
        if (mBinding != null && (recyclerView2 = mBinding.f14141a) != null) {
            recyclerView2.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment.initView.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewAttachedToWindow(@NotNull View view) {
                    RecyclerView recyclerView3;
                    RecyclerView.LayoutManager layoutManager;
                    RecyclerView recyclerView4;
                    RecyclerView.LayoutManager layoutManager2;
                    Intrinsics.checkNotNullParameter(view, "view");
                    WorksFragmentAlumniAttentionBinding worksFragmentAlumniAttentionBindingAccess$getMBinding = AttentionFragment.access$getMBinding(AttentionFragment.this);
                    if (worksFragmentAlumniAttentionBindingAccess$getMBinding == null || (recyclerView3 = worksFragmentAlumniAttentionBindingAccess$getMBinding.f14141a) == null || (layoutManager = recyclerView3.getLayoutManager()) == null) {
                        return;
                    }
                    AttentionFragment attentionFragment = AttentionFragment.this;
                    if (layoutManager instanceof LinearLayoutManager) {
                        WorksFragmentAlumniAttentionBinding worksFragmentAlumniAttentionBindingAccess$getMBinding2 = AttentionFragment.access$getMBinding(attentionFragment);
                        int position = (worksFragmentAlumniAttentionBindingAccess$getMBinding2 == null || (recyclerView4 = worksFragmentAlumniAttentionBindingAccess$getMBinding2.f14141a) == null || (layoutManager2 = recyclerView4.getLayoutManager()) == null) ? -1 : layoutManager2.getPosition(view);
                        if (attentionFragment.currentPosition == -1) {
                            i4a.b(attentionFragment.TAG, "onChildViewAttachedToWindow:" + position);
                            attentionFragment.onCurrentPageChanged(position);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
                public void onChildViewDetachedFromWindow(@NotNull View view) {
                    RecyclerView recyclerView3;
                    RecyclerView.LayoutManager layoutManager;
                    Intrinsics.checkNotNullParameter(view, "view");
                    WorksFragmentAlumniAttentionBinding worksFragmentAlumniAttentionBindingAccess$getMBinding = AttentionFragment.access$getMBinding(AttentionFragment.this);
                    int position = (worksFragmentAlumniAttentionBindingAccess$getMBinding == null || (recyclerView3 = worksFragmentAlumniAttentionBindingAccess$getMBinding.f14141a) == null || (layoutManager = recyclerView3.getLayoutManager()) == null) ? -1 : layoutManager.getPosition(view);
                    if (position == AttentionFragment.this.currentPosition) {
                        i4a.b(AttentionFragment.this.TAG, "onChildViewDetachedFromWindow:" + AttentionFragment.this.currentPosition);
                        AttentionFragment.this.onCurrentPageDestroy(position, view);
                    }
                }
            });
        }
        WorksFragmentAlumniAttentionBinding mBinding2 = getMBinding();
        if (mBinding2 != null && (recyclerView = mBinding2.f14141a) != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.attention.AttentionFragment.initView.2

                /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
                public int oldState;

                /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                public int offsetY;

                /* JADX INFO: renamed from: a, reason: from getter */
                public final int getOffsetY() {
                    return this.offsetY;
                }

                /* JADX INFO: renamed from: b, reason: from getter */
                public final int getOldState() {
                    return this.oldState;
                }

                public final void c(int i) {
                    this.offsetY = i;
                }

                public final void d(int i) {
                    this.oldState = i;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NotNull RecyclerView recyclerView3, int newState) {
                    WorksFragmentAlumniAttentionBinding worksFragmentAlumniAttentionBindingAccess$getMBinding;
                    RecyclerView recyclerView4;
                    RecyclerView.LayoutManager layoutManager;
                    Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                    int i = this.oldState;
                    if (i == 0 && newState == 1) {
                        this.offsetY = 0;
                    } else if (i == 1 && newState == 0 && (worksFragmentAlumniAttentionBindingAccess$getMBinding = AttentionFragment.access$getMBinding(AttentionFragment.this)) != null && (recyclerView4 = worksFragmentAlumniAttentionBindingAccess$getMBinding.f14141a) != null && (layoutManager = recyclerView4.getLayoutManager()) != null) {
                        AttentionFragment attentionFragment = AttentionFragment.this;
                        if (!(layoutManager instanceof LinearLayoutManager)) {
                            return;
                        }
                        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                        int i2 = iFindFirstVisibleItemPosition + 1;
                        if (attentionFragment.getViewVisibleHeight(attentionFragment.findPlayViewByPosition(iFindFirstVisibleItemPosition)) < attentionFragment.getViewVisibleHeight(attentionFragment.findPlayViewByPosition(i2))) {
                            iFindFirstVisibleItemPosition = i2;
                        }
                        if (attentionFragment.currentPosition != iFindFirstVisibleItemPosition) {
                            attentionFragment.onCurrentPageChanged(iFindFirstVisibleItemPosition);
                        }
                    }
                    if (newState == 0 || newState == 1) {
                        this.oldState = newState;
                    }
                    if (this.oldState == 0) {
                        this.offsetY = 0;
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView3, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                    if (this.oldState == 1) {
                        this.offsetY += dy;
                    }
                }
            });
        }
        initAdapter();
        Context context = getContext();
        if (context != null) {
            getVideoPlayer().k(context);
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ValueAnimator valueAnimator = this.valueAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        getVideoPlayer().u();
        PublishWorksDelegate.f14925a.n(getMWorksProgressReceiver());
        oz9 oz9Var = oz9.f43864a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        oz9Var.h(contextRequireContext, getWorksOperateReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentPause() {
        i4a.b(this.TAG, "onFragmentPause");
        controlPlayStatus(this.currentPosition, false);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        i4a.b(this.TAG, "onFragmentResume");
        controlPlayStatus(this.currentPosition, true);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        PublishWorksDelegate publishWorksDelegate = PublishWorksDelegate.f14925a;
        publishWorksDelegate.k(getMWorksProgressReceiver());
        oz9 oz9Var = oz9.f43864a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        oz9Var.a(contextRequireContext, getWorksOperateReceiver());
        getMViewModel().p().setValue(Integer.valueOf(publishWorksDelegate.g()));
    }
}
