package com.huachenjie.home.page.draw;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.FeaturedAwardBean;
import com.huachenjie.base.bean.HomeInspirationBean;
import com.huachenjie.base.bean.JackpotBean;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.base.bean.ThemeConfigBean;
import com.huachenjie.base.broadcast.inspiration.InspirationListener;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import com.huachenjie.base.dialog.lottery.LotteryDialog;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.PointsGoodsBean;
import com.huachenjie.home.databinding.HomeActivityLotteryDrawBinding;
import com.huachenjie.home.databinding.HomeLayoutFlashCoinsHeaderBinding;
import com.huachenjie.home.dialog.sign.SignDialog;
import com.huachenjie.home.dialog.task.TaskListDialog;
import com.huachenjie.home.dialog.task.TaskListFragment;
import com.huachenjie.home.page.draw.LotteryDrawFragment;
import com.huachenjie.home.page.inspiration_record.InspirationRecordActivity;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.huachenjie.home.widget.TopCropImageView;
import com.ipd.dsp.internal.e1.f;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;
import com.zj.adlib.dq1;
import com.zj.adlib.fb4;
import com.zj.adlib.fv5;
import com.zj.adlib.j14;
import com.zj.adlib.jj8;
import com.zj.adlib.kq5;
import com.zj.adlib.qk0;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001:B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R#\u0010/\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/huachenjie/home/page/draw/LotteryDrawFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeActivityLotteryDrawBinding;", "Lcom/huachenjie/home/page/draw/LotteryDrawVM;", "", com.alipay.sdk.m.c0.d.q, "initBgThemeConfig", "Lcom/huachenjie/base/bean/ThemeConfigBean;", "config", "applyLotteryPagePromoAndDesc", "", "url", "applyPromoImage", "applyDescImage", "Landroid/widget/ImageView;", "imageView", "", "heightPx", "updateDescImageHeight", "initAdapter", "initHeader", "refreshHeader", "initTaskList", "initBanner", "initWinnerListBroadcast", "indexTag", "Lcom/huachenjie/base/bean/JackpotBean;", "findLotteryDraw", "", "", "getVariables", "getLayoutResID", "initView", "initData", "initDataObservable", "onFragmentResume", "onViewCreated", "onDestroyView", "Lcom/huachenjie/home/dialog/task/TaskListFragment;", "taskListFragment", "Lcom/huachenjie/home/dialog/task/TaskListFragment;", "Lcom/huachenjie/home/databinding/HomeLayoutFlashCoinsHeaderBinding;", "kotlin.jvm.PlatformType", "mHeaderBinding$delegate", "Lkotlin/Lazy;", "getMHeaderBinding", "()Lcom/huachenjie/home/databinding/HomeLayoutFlashCoinsHeaderBinding;", "mHeaderBinding", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "inspirationOperateReceiver$delegate", "getInspirationOperateReceiver", "()Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "inspirationOperateReceiver", "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nLotteryDrawFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LotteryDrawFragment.kt\ncom/huachenjie/home/page/draw/LotteryDrawFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,417:1\n68#2,4:418\n40#2:422\n56#2:423\n75#2:424\n329#2,4:425\n1#3:429\n*S KotlinDebug\n*F\n+ 1 LotteryDrawFragment.kt\ncom/huachenjie/home/page/draw/LotteryDrawFragment\n*L\n133#1:418,4\n133#1:422\n133#1:423\n133#1:424\n190#1:425,4\n*E\n"})
public final class LotteryDrawFragment extends BaseMVVMFragment<HomeActivityLotteryDrawBinding, LotteryDrawVM> {

    @Nullable
    private TaskListFragment taskListFragment;

    /* JADX INFO: renamed from: mHeaderBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHeaderBinding = LazyKt.lazy(new Function0<HomeLayoutFlashCoinsHeaderBinding>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment$mHeaderBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HomeLayoutFlashCoinsHeaderBinding m410invoke() {
            return (HomeLayoutFlashCoinsHeaderBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.home_layout_flash_coins_header, null, false);
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.z25
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            LotteryDrawFragment.onRefreshListener$lambda$0(this.f46170a);
        }
    };

    /* JADX INFO: renamed from: inspirationOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inspirationOperateReceiver = LazyKt.lazy(new Function0<InspirationReceiver>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment$inspirationOperateReceiver$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/home/page/draw/LotteryDrawFragment$inspirationOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/inspiration/InspirationListener;", "", "changeValue", "", "a", "b", "home_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements InspirationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LotteryDrawFragment f34342a;

            public a(LotteryDrawFragment lotteryDrawFragment) {
                this.f34342a = lotteryDrawFragment;
            }

            @Override // com.huachenjie.base.broadcast.inspiration.InspirationListener
            public void a(int changeValue) {
                LotteryDrawFragment.access$getMViewModel(this.f34342a).t();
            }

            @Override // com.huachenjie.base.broadcast.inspiration.InspirationListener
            public void b() {
                TaskListFragment taskListFragment = this.f34342a.taskListFragment;
                if (taskListFragment != null) {
                    taskListFragment.reloadData();
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final InspirationReceiver m409invoke() {
            return new InspirationReceiver(new a(this.this$0));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/draw/LotteryDrawFragment$a;", "", "Landroid/view/View;", "view", "", "c", "b", "a", "d", "e", "f", "<init>", "(Lcom/huachenjie/home/page/draw/LotteryDrawFragment;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.home.page.draw.LotteryDrawFragment$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/home/page/draw/LotteryDrawFragment$a$a", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment$DialogFragmentListener;", "", "onDismiss", "home_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0805a implements BaseDialogFragment.DialogFragmentListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TaskListDialog f34337a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ LotteryDrawFragment f9605a;

            public C0805a(TaskListDialog taskListDialog, LotteryDrawFragment lotteryDrawFragment) {
                this.f34337a = taskListDialog;
                this.f9605a = lotteryDrawFragment;
            }

            @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment.DialogFragmentListener
            public void onDismiss() {
                TaskListFragment taskListFragment;
                ArrayList<DailyTasksBean> taskList = this.f34337a.getTaskList();
                if (taskList == null || (taskListFragment = this.f9605a.taskListFragment) == null) {
                    return;
                }
                taskListFragment.updateListData(taskList);
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(zj7.e.CHANGE_REWARD).navigation();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LotteryDrawFragment.this.startActivity(new Intent(view.getContext(), (Class<?>) RewardRecordActivity.class));
        }

        public final void c(@NotNull View view) {
            HomeInspirationBean inspiration;
            Intrinsics.checkNotNullParameter(view, "view");
            InspirationRecordActivity.Companion companion = InspirationRecordActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            LotteryDrawBean value = LotteryDrawFragment.access$getMViewModel(LotteryDrawFragment.this).k().getValue();
            companion.a(context, (value == null || (inspiration = value.getInspiration()) == null) ? 0 : inspiration.getTotal());
        }

        public final void d(@NotNull View view) {
            HomeInspirationBean inspiration;
            Intrinsics.checkNotNullParameter(view, "view");
            JackpotBean jackpotBeanFindLotteryDraw = LotteryDrawFragment.this.findLotteryDraw(view.getTag().toString());
            if (jackpotBeanFindLotteryDraw != null) {
                LotteryDrawFragment lotteryDrawFragment = LotteryDrawFragment.this;
                j14.e(view.getContext(), jackpotBeanFindLotteryDraw.getLotteryType());
                if (jackpotBeanFindLotteryDraw.getJackpotType() == 3) {
                    ARouter.getInstance().build(zj7.e.CHANGE_REWARD).withBoolean(yj7.c.KEY_CHANGE_IMPORTANT_REWARD, true).navigation();
                    return;
                }
                LotteryDrawBean value = LotteryDrawFragment.access$getMViewModel(lotteryDrawFragment).k().getValue();
                if (jackpotBeanFindLotteryDraw.getJackpotUse() > ((value == null || (inspiration = value.getInspiration()) == null) ? 0 : inspiration.getTotal())) {
                    fv5.b("闪金币不足，前往每日必修完成任务后领取闪金币");
                    return;
                }
                LotteryDialog.Companion companion = LotteryDialog.INSTANCE;
                FragmentManager childFragmentManager = lotteryDrawFragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                companion.a(childFragmentManager, jackpotBeanFindLotteryDraw.getLotteryDesc(), jackpotBeanFindLotteryDraw.getJackpotNo(), jackpotBeanFindLotteryDraw.getJackpotUse(), jackpotBeanFindLotteryDraw.getAwardNo(), 1);
                HashMap map = new HashMap();
                map.put("jackpotName", jackpotBeanFindLotteryDraw.getJackpotName());
                kq5.b(view.getContext(), MobClickConstants.i, map);
            }
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TaskListDialog.Companion companion = TaskListDialog.INSTANCE;
            TaskListFragment taskListFragment = LotteryDrawFragment.this.taskListFragment;
            TaskListDialog taskListDialogA = companion.a(taskListFragment != null ? taskListFragment.getListData() : null);
            taskListDialogA.setDialogFragmentListener(new C0805a(taskListDialogA, LotteryDrawFragment.this));
            FragmentManager childFragmentManager = LotteryDrawFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            taskListDialogA.show(childFragmentManager, Reflection.getOrCreateKotlinClass(TaskListDialog.class).getSimpleName());
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SignDialog.Companion companion = SignDialog.INSTANCE;
            FragmentManager childFragmentManager = LotteryDrawFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.a(childFragmentManager);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/home/page/draw/LotteryDrawFragment$b", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/drawable/Drawable;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "", "onResourceReady", "placeholder", "onLoadCleared", "home_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nLotteryDrawFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LotteryDrawFragment.kt\ncom/huachenjie/home/page/draw/LotteryDrawFragment$applyDescImage$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,417:1\n1#2:418\n*E\n"})
    public static final class b extends CustomTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f34338a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ LotteryDrawFragment f9606a;

        public b(ImageView imageView, LotteryDrawFragment lotteryDrawFragment) {
            this.f34338a = imageView;
            this.f9606a = lotteryDrawFragment;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable placeholder) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
        }

        public void onResourceReady(@NotNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.f34338a.setImageDrawable(resource);
            int intrinsicWidth = resource.getIntrinsicWidth();
            int intrinsicHeight = resource.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return;
            }
            Integer numValueOf = Integer.valueOf(this.f34338a.getWidth());
            if (!(numValueOf.intValue() > 0)) {
                numValueOf = null;
            }
            this.f9606a.updateDescImageHeight(this.f34338a, ((numValueOf != null ? numValueOf.intValue() : this.f9606a.getResources().getDisplayMetrics().widthPixels - jj8.a(32.0f)) * intrinsicHeight) / intrinsicWidth);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"com/huachenjie/home/page/draw/LotteryDrawFragment$c", "Lcom/youth/banner/listener/OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int state) {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            List<FeaturedAwardBean> awardList;
            FeaturedAwardBean featuredAwardBean;
            try {
                LotteryDrawBean value = LotteryDrawFragment.access$getMViewModel(LotteryDrawFragment.this).k().getValue();
                if (value != null && (awardList = value.getAwardList()) != null && (featuredAwardBean = awardList.get(position)) != null) {
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = LotteryDrawFragment.this.getMHeaderBinding();
                    BLTextView bLTextView = mHeaderBinding != null ? mHeaderBinding.f9571a : null;
                    if (bLTextView == null) {
                        return;
                    }
                    bLTextView.setText(featuredAwardBean.getAwardName());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", f.l, "right", f.n, "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnNextLayout$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 LotteryDrawFragment.kt\ncom/huachenjie/home/page/draw/LotteryDrawFragment\n*L\n1#1,432:1\n72#2:433\n73#2:436\n134#3,2:434\n*E\n"})
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            HomeActivityLotteryDrawBinding homeActivityLotteryDrawBindingAccess$getMBinding = LotteryDrawFragment.access$getMBinding(LotteryDrawFragment.this);
            TopCropImageView topCropImageView = homeActivityLotteryDrawBindingAccess$getMBinding != null ? homeActivityLotteryDrawBindingAccess$getMBinding.f9291a : null;
            if (topCropImageView == null) {
                return;
            }
            topCropImageView.setBackgroundReferenceHeightPx(view.getHeight());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34341a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34341a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34341a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34341a.invoke(obj);
        }
    }

    public static final /* synthetic */ HomeActivityLotteryDrawBinding access$getMBinding(LotteryDrawFragment lotteryDrawFragment) {
        return lotteryDrawFragment.getMBinding();
    }

    public static final /* synthetic */ LotteryDrawVM access$getMViewModel(LotteryDrawFragment lotteryDrawFragment) {
        return lotteryDrawFragment.getMViewModel();
    }

    private final void applyDescImage(String url) {
        ImageView imageView = getMHeaderBinding().b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mHeaderBinding.ivLotteryDesc");
        Glide.with(imageView).clear(imageView);
        if (StringsKt.isBlank(url)) {
            imageView.setImageDrawable(null);
            imageView.setVisibility(8);
            updateDescImageHeight(imageView, 0);
        } else {
            imageView.setVisibility(0);
            updateDescImageHeight(imageView, 0);
            Glide.with(imageView).load(url).into(new b(imageView, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyLotteryPagePromoAndDesc(ThemeConfigBean config) {
        applyPromoImage(config.getPagePromoUrl());
        applyDescImage(config.getLotteryDescUrl());
    }

    private final void applyPromoImage(String url) {
        ImageView imageView = getMHeaderBinding().d;
        if (!StringsKt.isBlank(url)) {
            Glide.with(imageView).load(url).into(imageView);
        } else {
            Glide.with(imageView).clear(imageView);
            imageView.setImageDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final JackpotBean findLotteryDraw(String indexTag) {
        LotteryDrawBean value;
        LotteryDrawBean value2;
        LotteryDrawBean value3;
        switch (indexTag.hashCode()) {
            case 48:
                if (indexTag.equals("0") && (value = getMViewModel().k().getValue()) != null) {
                    return value.findLotteryDraw(0);
                }
                return null;
            case 49:
                if (indexTag.equals("1") && (value2 = getMViewModel().k().getValue()) != null) {
                    return value2.findLotteryDraw(1);
                }
                return null;
            case 50:
                if (indexTag.equals("2") && (value3 = getMViewModel().k().getValue()) != null) {
                    return value3.findLotteryDraw(2);
                }
                return null;
            default:
                return null;
        }
    }

    private final InspirationReceiver getInspirationOperateReceiver() {
        return (InspirationReceiver) this.inspirationOperateReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeLayoutFlashCoinsHeaderBinding getMHeaderBinding() {
        return (HomeLayoutFlashCoinsHeaderBinding) this.mHeaderBinding.getValue();
    }

    private final void initAdapter() {
        if (getMBinding() != null) {
            final PointsGoodStuffAdapter pointsGoodStuffAdapter = new PointsGoodStuffAdapter(0.0f, 0.0f, 0.0f, 7, null);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.home_layout_empty_data, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(R.id.bt_empty);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
            pointsGoodStuffAdapter.o(viewInflate);
            pointsGoodStuffAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.a35
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    LotteryDrawFragment.initAdapter$lambda$6$lambda$4(this.f40442a);
                }
            });
            y57.d(pointsGoodStuffAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.b35
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    LotteryDrawFragment.initAdapter$lambda$6$lambda$5(pointsGoodStuffAdapter, baseQuickAdapter, view, i);
                }
            }, 1, null);
            initHeader();
            View root = getMHeaderBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "mHeaderBinding.root");
            BaseQuickAdapter.setHeaderView$default(pointsGoodStuffAdapter, root, 0, 0, 6, null);
            initTaskList();
            pointsGoodStuffAdapter.setHeaderWithEmptyEnable(true);
            getMViewModel().i().setValue(pointsGoodStuffAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$4(LotteryDrawFragment lotteryDrawFragment) {
        Intrinsics.checkNotNullParameter(lotteryDrawFragment, "this$0");
        lotteryDrawFragment.getMViewModel().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$6$lambda$5(PointsGoodStuffAdapter pointsGoodStuffAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pointsGoodStuffAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "view");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", ((PointsGoodsBean) pointsGoodStuffAdapter.getItem(i)).getGoodsNo()).navigation();
    }

    private final void initBanner() {
        final Banner banner;
        HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = getMHeaderBinding();
        if (mHeaderBinding == null || (banner = mHeaderBinding.f9572a) == null) {
            return;
        }
        banner.post(new Runnable() { // from class: com.zj.adlib.y25
            @Override // java.lang.Runnable
            public final void run() {
                LotteryDrawFragment.initBanner$lambda$10(this.f45943a, banner);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$10(LotteryDrawFragment lotteryDrawFragment, Banner banner) {
        Banner banner2;
        Intrinsics.checkNotNullParameter(lotteryDrawFragment, "this$0");
        Intrinsics.checkNotNullParameter(banner, "$banner");
        LotteryDrawBannerAdapter lotteryDrawBannerAdapter = new LotteryDrawBannerAdapter();
        lotteryDrawBannerAdapter.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.d35
            public final void OnBannerClick(Object obj, int i) {
                LotteryDrawFragment.initBanner$lambda$10$lambda$9$lambda$8((String) obj, i);
            }
        });
        HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = lotteryDrawFragment.getMHeaderBinding();
        if (mHeaderBinding != null && (banner2 = mHeaderBinding.f9572a) != null) {
            banner2.setAdapter(lotteryDrawBannerAdapter);
        }
        banner.addBannerLifecycleObserver(lotteryDrawFragment);
        banner.setBannerGalleryEffect(68, 20, 0.56f);
        banner.getViewPager2().setOffscreenPageLimit(5);
        banner.addOnPageChangeListener(lotteryDrawFragment.new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$10$lambda$9$lambda$8(String str, int i) {
    }

    private final void initBgThemeConfig() {
        LotteryThemeConfigManager lotteryThemeConfigManager = LotteryThemeConfigManager.f9607a;
        ThemeConfigBean themeConfigBeanD = lotteryThemeConfigManager.d();
        ImageView imageView = getMHeaderBinding().f9566a;
        String pageBgUrl = themeConfigBeanD.getPageBgUrl();
        int i = R.drawable.home_bg_lottery_draw;
        lotteryThemeConfigManager.i(imageView, pageBgUrl, i);
        HomeActivityLotteryDrawBinding mBinding = getMBinding();
        lotteryThemeConfigManager.i(mBinding != null ? mBinding.f9291a : null, themeConfigBeanD.getPageBgUrl(), i);
        ImageView imageView2 = getMHeaderBinding().f9566a;
        Intrinsics.checkNotNullExpressionValue(imageView2, "mHeaderBinding.ivLotteryBg");
        if (!ViewCompat.isLaidOut(imageView2) || imageView2.isLayoutRequested()) {
            imageView2.addOnLayoutChangeListener(new d());
            return;
        }
        HomeActivityLotteryDrawBinding homeActivityLotteryDrawBindingAccess$getMBinding = access$getMBinding(this);
        TopCropImageView topCropImageView = homeActivityLotteryDrawBindingAccess$getMBinding != null ? homeActivityLotteryDrawBindingAccess$getMBinding.f9291a : null;
        if (topCropImageView == null) {
            return;
        }
        topCropImageView.setBackgroundReferenceHeightPx(imageView2.getHeight());
    }

    private final void initHeader() {
        getMHeaderBinding().setLifecycleOwner(this);
        getMHeaderBinding().getRoot().setTag("flashCoinsHeader");
        refreshHeader();
    }

    private final void initTaskList() {
        final int taskDisplayCount = dq1.e().getTaskDisplayCount();
        this.taskListFragment = TaskListFragment.Companion.b(TaskListFragment.INSTANCE, taskDisplayCount, null, new Function1<Integer, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment.initTaskList.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                LotteryDrawFragment.this.getMHeaderBinding().f9573b.setVisibility(i > taskDisplayCount ? 0 : 8);
            }
        }, 2, null);
        getMHeaderBinding().getRoot().post(new Runnable() { // from class: com.zj.adlib.e35
            @Override // java.lang.Runnable
            public final void run() {
                LotteryDrawFragment.initTaskList$lambda$7(this.f41336a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTaskList$lambda$7(LotteryDrawFragment lotteryDrawFragment) {
        Intrinsics.checkNotNullParameter(lotteryDrawFragment, "this$0");
        FragmentTransaction fragmentTransactionBeginTransaction = lotteryDrawFragment.getChildFragmentManager().beginTransaction();
        int id = lotteryDrawFragment.getMHeaderBinding().f34301a.getId();
        TaskListFragment taskListFragment = lotteryDrawFragment.taskListFragment;
        Intrinsics.checkNotNull(taskListFragment);
        fragmentTransactionBeginTransaction.replace(id, taskListFragment).commitAllowingStateLoss();
    }

    private final void initWinnerListBroadcast() {
        Banner banner;
        HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = getMHeaderBinding();
        if (mHeaderBinding == null || (banner = mHeaderBinding.f9574b) == null) {
            return;
        }
        banner.addBannerLifecycleObserver(this).setAdapter(new WinnerListBroadcastAdapter()).setUserInputEnabled(false).setLoopTime(2000L).setScrollTime(500).setIndicator(new CircleIndicator(banner.getContext()));
        banner.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.c35
            public final void OnBannerClick(Object obj, int i) {
                LotteryDrawFragment.initWinnerListBroadcast$lambda$11(obj, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWinnerListBroadcast$lambda$11(Object obj, int i) {
    }

    private final void onRefresh() {
        getMViewModel().t();
        getMViewModel().s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(LotteryDrawFragment lotteryDrawFragment) {
        Intrinsics.checkNotNullParameter(lotteryDrawFragment, "this$0");
        lotteryDrawFragment.onRefresh();
    }

    private final void refreshHeader() {
        getMHeaderBinding().setVariable(qk0.p0, getMViewModel());
        getMHeaderBinding().setVariable(qk0.k, new a());
        getMHeaderBinding().executePendingBindings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDescImageHeight(ImageView imageView, int heightPx) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = heightPx;
        imageView.setLayoutParams(layoutParams2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_lottery_draw;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a()), TuplesKt.to(Integer.valueOf(xk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().s();
        getMViewModel().r();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().k().observe(this, new e(new Function1<LotteryDrawBean, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LotteryDrawBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LotteryDrawBean lotteryDrawBean) {
                Banner banner;
                Banner banner2;
                Banner banner3;
                LotteryDrawFragment.this.applyLotteryPagePromoAndDesc(lotteryDrawBean.getThemeConfig());
                if (lotteryDrawBean.getWinningList().isEmpty()) {
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = LotteryDrawFragment.this.getMHeaderBinding();
                    BLLinearLayout bLLinearLayout = mHeaderBinding != null ? mHeaderBinding.f9570a : null;
                    if (bLLinearLayout != null) {
                        bLLinearLayout.setVisibility(8);
                    }
                } else {
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding2 = LotteryDrawFragment.this.getMHeaderBinding();
                    BLLinearLayout bLLinearLayout2 = mHeaderBinding2 != null ? mHeaderBinding2.f9570a : null;
                    if (bLLinearLayout2 != null) {
                        bLLinearLayout2.setVisibility(0);
                    }
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding3 = LotteryDrawFragment.this.getMHeaderBinding();
                    if (mHeaderBinding3 != null && (banner = mHeaderBinding3.f9574b) != null) {
                        banner.setDatas(lotteryDrawBean.getWinningList());
                    }
                }
                List<FeaturedAwardBean> awardList = lotteryDrawBean.getAwardList();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(awardList, 10));
                Iterator<T> it = awardList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FeaturedAwardBean) it.next()).getImgUrl());
                }
                HomeLayoutFlashCoinsHeaderBinding mHeaderBinding4 = LotteryDrawFragment.this.getMHeaderBinding();
                if (mHeaderBinding4 != null && (banner3 = mHeaderBinding4.f9572a) != null) {
                    banner3.setDatas(arrayList);
                }
                if (!lotteryDrawBean.getAwardList().isEmpty()) {
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding5 = LotteryDrawFragment.this.getMHeaderBinding();
                    FeaturedAwardBean featuredAwardBean = lotteryDrawBean.getAwardList().get(BannerUtils.getRealPosition(true, (mHeaderBinding5 == null || (banner2 = mHeaderBinding5.f9572a) == null) ? 1 : banner2.getStartPosition(), arrayList.size()));
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding6 = LotteryDrawFragment.this.getMHeaderBinding();
                    BLTextView bLTextView = mHeaderBinding6 != null ? mHeaderBinding6.f9571a : null;
                    if (bLTextView == null) {
                        return;
                    }
                    bLTextView.setText(featuredAwardBean.getAwardName());
                }
            }
        }));
        getMViewModel().j().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Banner banner;
                BLTextView bLTextView;
                CharSequence text;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    HomeLayoutFlashCoinsHeaderBinding mHeaderBinding = LotteryDrawFragment.this.getMHeaderBinding();
                    boolean z = false;
                    if (mHeaderBinding != null && (bLTextView = mHeaderBinding.f9571a) != null && (text = bLTextView.getText()) != null) {
                        if (text.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        HomeLayoutFlashCoinsHeaderBinding mHeaderBinding2 = LotteryDrawFragment.this.getMHeaderBinding();
                        BLTextView bLTextView2 = mHeaderBinding2 != null ? mHeaderBinding2.f9571a : null;
                        if (bLTextView2 != null) {
                            bLTextView2.setText("");
                        }
                        HomeLayoutFlashCoinsHeaderBinding mHeaderBinding3 = LotteryDrawFragment.this.getMHeaderBinding();
                        if (mHeaderBinding3 == null || (banner = mHeaderBinding3.f9572a) == null) {
                            return;
                        }
                        banner.setDatas((List) null);
                    }
                }
            }
        }));
        getMViewModel().n().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.page.draw.LotteryDrawFragment.initDataObservable.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    SignDialog.Companion companion = SignDialog.INSTANCE;
                    FragmentManager childFragmentManager = LotteryDrawFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this@LotteryDrawFragment.childFragmentManager");
                    companion.a(childFragmentManager);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initBgThemeConfig();
        initAdapter();
        initBanner();
        initWinnerListBroadcast();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Context context = getContext();
        if (context != null) {
            fb4.f41638a.unregisterReceiver(context, getInspirationOperateReceiver());
        }
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        super.onFragmentResume();
        getMViewModel().t();
        TaskListFragment taskListFragment = this.taskListFragment;
        if (taskListFragment != null) {
            taskListFragment.reloadData();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        Context context = getContext();
        if (context != null) {
            fb4.f41638a.registerReceiver(context, getInspirationOperateReceiver());
        }
    }
}
