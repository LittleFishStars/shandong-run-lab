package com.huachenjie.home.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.gson.Gson;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.base.app_widget.InspirationWidget;
import com.huachenjie.base.app_widget.a;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoMaterialBean;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.home.R;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.BrowseGoodsDetailBean;
import com.huachenjie.home.bean.DailyTasksActionBean;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.DailyTasksLinkBean;
import com.huachenjie.home.bean.ReceiveRewardBean;
import com.huachenjie.home.dialog.reward.RewardInfoDialog;
import com.huachenjie.home.dialog.sign.SignDialog;
import com.huachenjie.home.dialog.task.DoubleRewardDialog;
import com.huachenjie.home.page.SignUpWebActivity;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import com.huachenjie.home.page.union_search.UnionGoodsSearchActivity;
import com.huachenjie.home.util.TasksUtil;
import com.huachenjie.works.page.alumni.school.JoinChannelTipDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.utils.PublishUtil;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.ew;
import com.zj.adlib.fb4;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
import com.zj.adlib.jr8;
import com.zj.adlib.kq5;
import com.zj.adlib.r90;
import com.zj.adlib.s72;
import com.zj.adlib.su9;
import com.zj.adlib.t47;
import com.zj.adlib.vb8;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.ys8;
import com.zj.adlib.zj7;
import huachenjie.sdk.share.sharebody.WebPageBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+Jt\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2<\b\u0002\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rJ_\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bJ;\u0010!\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00122+\b\u0002\u0010 \u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018J\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010%\u001a\u0004\u0018\u00010$J\u0006\u0010&\u001a\u00020\u0014R\u0014\u0010)\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/huachenjie/home/util/TasksUtil;", "", "Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "parentFragmentManager", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "viewModel", "Lcom/huachenjie/home/bean/DailyTasksBean;", "item", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", UserTrackConstant.IS_SUCCESS, "", "taskNo", "", RenderCallContext.TYPE_CALLBACK, "e", "fragmentManager", "Lkotlin/Function1;", "fromAd", "adBackCallback", "Lkotlin/Function0;", y6b.g, SignUpWebActivity.A, "", "taskNoList", "block", "j", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "b", "Lcom/huachenjie/home/bean/BrowseGoodsDetailBean;", "d", "c", "a", "Ljava/lang/String;", "KEY_BROWSE_GOODS_DETAIL_INFO", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class TasksUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TasksUtil f34372a = new TasksUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String KEY_BROWSE_GOODS_DETAIL_INFO = "browse_goods_detail_info";

    public static final void g(boolean z, Context context, final Function2 function2, DailyTasksBean dailyTasksBean, BaseViewModel baseViewModel) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(dailyTasksBean, "$item");
        Intrinsics.checkNotNullParameter(baseViewModel, "$viewModel");
        boolean zB = a.b(InspirationWidget.class);
        if (z && zB) {
            f34372a.j(dailyTasksBean.getTaskConfigNo(), new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<String>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull List<String> list) {
                    Intrinsics.checkNotNullParameter(list, o.f);
                    Function2<Boolean, String, Unit> function3 = function2;
                    if (function3 != null) {
                        function3.invoke(Boolean.TRUE, list.get(0));
                    }
                }
            });
        } else {
            su9.q(context, "https://mp.weixin.qq.com/s/fBKRrpeSyloaPxZ1HqnOIA");
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, (Object) null);
            }
        }
        baseViewModel.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(TasksUtil tasksUtil, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        tasksUtil.j(str, function1);
    }

    public final boolean b(@NotNull DailyTasksBean bean) {
        String threshold;
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        BrowseGoodsDetailBean browseGoodsDetailBeanD = d();
        String strC = s72.c(System.currentTimeMillis(), "yyyy-MM-dd");
        if (browseGoodsDetailBeanD != null && Intrinsics.areEqual(browseGoodsDetailBeanD.getTaskConfigNo(), bean.getTaskConfigNo()) && Intrinsics.areEqual(browseGoodsDetailBeanD.getDate(), strC)) {
            browseGoodsDetailBeanD.setBrowseCount(browseGoodsDetailBeanD.getBrowseCount() + 1);
        } else {
            String taskConfigNo = bean.getTaskConfigNo();
            Intrinsics.checkNotNullExpressionValue(strC, "now");
            browseGoodsDetailBeanD = new BrowseGoodsDetailBean(taskConfigNo, strC, 1);
        }
        ai9.t(KEY_BROWSE_GOODS_DETAIL_INFO, new Gson().toJson(browseGoodsDetailBeanD));
        int browseCount = browseGoodsDetailBeanD.getBrowseCount();
        DailyTasksActionBean action = bean.getAction();
        return browseCount >= ((action == null || (threshold = action.getThreshold()) == null) ? 0 : Integer.parseInt(threshold));
    }

    public final void c() {
        ai9.p(KEY_BROWSE_GOODS_DETAIL_INFO);
    }

    @Nullable
    public final BrowseGoodsDetailBean d() {
        String strF = ai9.f(KEY_BROWSE_GOODS_DETAIL_INFO);
        if (strF == null || strF.length() == 0) {
            return null;
        }
        return (BrowseGoodsDetailBean) new Gson().fromJson(strF, BrowseGoodsDetailBean.class);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d9  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x00a2, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00c1, please report this as an issue */
    public final void e(@NotNull final Context context, @NotNull Lifecycle lifecycle, @NotNull FragmentManager childFragmentManager, @NotNull FragmentManager parentFragmentManager, @NotNull final BaseViewModel viewModel, @NotNull final DailyTasksBean item, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
        String channelNo;
        DailyTasksLinkBean link;
        DailyTasksLinkBean link2;
        String url;
        DailyTasksLinkBean link3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "parentFragmentManager");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(item, "item");
        int taskType = item.getTaskType();
        switch (taskType) {
            case 1:
                t47.e(context);
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 2:
                viewModel.g();
                final boolean zA = a.a(InspirationWidget.class);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.i19
                    @Override // java.lang.Runnable
                    public final void run() {
                        TasksUtil.g(zA, context, callback, item, viewModel);
                    }
                }, 500L);
                break;
            case 3:
                JoinChannelTipDialog.Companion companion = JoinChannelTipDialog.INSTANCE;
                DailyTasksActionBean action = item.getAction();
                if (action == null || (channelNo = action.getChannelNo()) == null) {
                    channelNo = "";
                }
                companion.a(channelNo, new Function0<Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m435invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m435invoke() {
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, (Object) null);
                        }
                    }
                }).show(childFragmentManager, Reflection.getOrCreateKotlinClass(JoinChannelTipDialog.class).getSimpleName());
                break;
            case 4:
                ARouter.getInstance().build(zj7.c.HOME).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 5:
                jr8 jr8Var = jr8.f17466a;
                if (jr8Var.d()) {
                    if (!jr8Var.c(context)) {
                        jr8Var.e(context, new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Boolean) obj).booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z) {
                                if (z) {
                                    fv5.b("步数正在采集中~");
                                }
                            }
                        });
                    } else {
                        fv5.b("步数正在采集中~");
                    }
                }
                break;
            case 6:
                PublishUtil.f37344a.b(context, 1, null, null, viewModel, new Function0<Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m436invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m436invoke() {
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, (Object) null);
                        }
                    }
                });
                break;
            case 7:
                String str = (String) CollectionsKt.listOf(new String[]{"书中自有黄金屋，闪金币&大奖等你拿", "别再蹲点抢奶茶，快来“宝书”抽大奖！", "老师刚推荐 “真是宝书”啦——全班瞬间开启 “寻宝模式”，学霸已开始计算最短路线！"}).get(RangesKt.random(new IntRange(0, 2), Random.Default));
                WebPageBody webPageBody = new WebPageBody(str, Environment.c + "/#/activities/lucky-draw-share", "真是宝书征“寻宝人”", str);
                webPageBody.setBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.home_ic_daily_tasks_share));
                ShareDialog.Companion.c(ShareDialog.INSTANCE, webPageBody, "", new ShareDialog.OnShareCallback() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$5
                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void a(boolean shareToInternal, @NotNull String shareFlavour) {
                        Intrinsics.checkNotNullParameter(shareFlavour, "shareFlavour");
                        TasksUtil tasksUtil = TasksUtil.f34372a;
                        String taskConfigNo = item.getTaskConfigNo();
                        final Function2<Boolean, String, Unit> function2 = callback;
                        tasksUtil.j(taskConfigNo, new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$5$onShare$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((List<String>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull List<String> list) {
                                Intrinsics.checkNotNullParameter(list, o.f);
                                Function2<Boolean, String, Unit> function3 = function2;
                                if (function3 != null) {
                                    function3.invoke(Boolean.TRUE, list.get(0));
                                }
                            }
                        });
                    }

                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void onFailed(@Nullable String message) {
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.FALSE, (Object) null);
                        }
                    }

                    @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
                    public void onSuccess() {
                        ShareDialog.OnShareCallback.a.c(this);
                    }
                }, false, 8, null).show(childFragmentManager, Reflection.getOrCreateKotlinClass(ShareDialog.class).getSimpleName());
                break;
            case 8:
                ARouter.getInstance().build(zj7.a.HOME).withInt(yj7.a.HOME_INDEX, 0).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 9:
                viewModel.g();
                ew.j().i(vb8.j, com.blankj.utilcode.util.a.x(context), lifecycle, new RewardVideoAdListener() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$6
                    @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
                    public void b(int loadSupplier) {
                        super.b(loadSupplier);
                        viewModel.c();
                    }

                    @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
                    public void c(int loadSupplier, @Nullable String code, @Nullable String message) {
                        viewModel.c();
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.FALSE, (Object) null);
                        }
                        fv5.b("广告加载失败，请稍后再试");
                    }

                    @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
                    public void d(int loadSupplier, @Nullable String platform) {
                        TasksUtil tasksUtil = TasksUtil.f34372a;
                        String taskConfigNo = item.getTaskConfigNo();
                        final Function2<Boolean, String, Unit> function2 = callback;
                        tasksUtil.j(taskConfigNo, new Function1<List<? extends String>, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$goCompleteTask$6$onReward$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((List<String>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull List<String> list) {
                                Intrinsics.checkNotNullParameter(list, o.f);
                                Function2<Boolean, String, Unit> function3 = function2;
                                if (function3 != null) {
                                    function3.invoke(Boolean.TRUE, list.get(0));
                                }
                            }
                        });
                    }

                    @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
                    public void e(int loadSupplier, @Nullable String platform) {
                        viewModel.c();
                    }
                });
                break;
            case 10:
                DailyTasksActionBean action2 = item.getAction();
                if (action2 != null && (link = action2.getLink()) != null) {
                    if (link.getLinkType() == 1) {
                        su9.l(context, link.getUrl());
                    } else if (link.getLinkType() == 2) {
                        su9.q(context, link.getUrl());
                    }
                    k(f34372a, item.getTaskConfigNo(), null, 2, null);
                    if (callback != null) {
                        callback.invoke(Boolean.TRUE, (Object) null);
                    }
                }
                break;
            case 11:
                UnionGoodsSearchActivity.f34371a.a(context, item.getTaskConfigNo());
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 12:
                ARouter.getInstance().build(zj7.a.HOME).withInt(yj7.a.HOME_INDEX, 0).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 13:
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_SUB_INDEX, fe9.a.HOT).navigation();
                k(this, item.getTaskConfigNo(), null, 2, null);
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 14:
                context.startActivity(new Intent(context, (Class<?>) ChangeRewardActivity.class));
                k(this, item.getTaskConfigNo(), null, 2, null);
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 15:
                ARouter.getInstance().build(zj7.g.MALL_HOME).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 16:
                SignDialog.INSTANCE.a(parentFragmentManager);
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 17:
                ARouter.getInstance().build(zj7.i.DORMITORY).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 18:
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_SUB_INDEX, fe9.a.FIND_ALUMNI).navigation();
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 19:
                su9.l(context, Environment.c + "/#/buddy");
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            case 20:
                su9.l(context, Environment.c + "/#/buddy/publish");
                if (callback != null) {
                    callback.invoke(Boolean.TRUE, (Object) null);
                }
                break;
            default:
                switch (taskType) {
                    case 100:
                        su9.o(context);
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, (Object) null);
                        }
                        break;
                    case 101:
                        DailyTasksActionBean action3 = item.getAction();
                        if (action3 != null && (link2 = action3.getLink()) != null && (url = link2.getUrl()) != null) {
                            SignUpWebActivity.f34330a.a(context, url, item.getTaskConfigNo());
                            if (callback != null) {
                                callback.invoke(Boolean.TRUE, (Object) null);
                            }
                        }
                        break;
                    case 102:
                        su9.l(context, Environment.c + "/#/buddy");
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, (Object) null);
                        }
                        break;
                    case 103:
                        su9.l(context, Environment.c + "/#/buddy/publish");
                        if (callback != null) {
                            callback.invoke(Boolean.TRUE, (Object) null);
                        }
                        break;
                    default:
                        DailyTasksActionBean action4 = item.getAction();
                        if (action4 != null && (link3 = action4.getLink()) != null) {
                            if (link3.getLinkType() == 1) {
                                su9.l(context, link3.getUrl());
                            } else if (link3.getLinkType() == 2) {
                                su9.q(context, link3.getUrl());
                            }
                            if (callback != null) {
                                callback.invoke(Boolean.TRUE, (Object) null);
                            }
                        }
                        break;
                }
                break;
        }
        kq5.b(context, MobClickConstants.f, MapsKt.mapOf(new Pair[]{TuplesKt.to(SignUpWebActivity.A, item.getTaskConfigNo()), TuplesKt.to("taskName", item.getName())}));
    }

    public final void h(@NotNull final Context context, @NotNull final BaseViewModel viewModel, @NotNull final FragmentManager fragmentManager, @NotNull final DailyTasksBean item, @Nullable final Function1<? super Boolean, Unit> adBackCallback, @Nullable final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(item, "item");
        final Function2<Boolean, Boolean, Unit> function2 = new Function2<Boolean, Boolean, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$receiveTaskReward$fuc$1

            /* JADX INFO: renamed from: com.huachenjie.home.util.TasksUtil$receiveTaskReward$fuc$1$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.home.util.TasksUtil$receiveTaskReward$fuc$1$1", f = "TasksUtil.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $callback;
                final /* synthetic */ Context $context;
                final /* synthetic */ FragmentManager $fragmentManager;
                final /* synthetic */ boolean $isDouble;
                final /* synthetic */ DailyTasksBean $item;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DailyTasksBean dailyTasksBean, boolean z, Context context, FragmentManager fragmentManager, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$item = dailyTasksBean;
                    this.$isDouble = z;
                    this.$context = context;
                    this.$fragmentManager = fragmentManager;
                    this.$callback = function0;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$item, this.$isDouble, this.$context, this.$fragmentManager, this.$callback, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objY;
                    StringBuilder sb;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        HomeRequest homeRequest = HomeRequest.f34197a;
                        String taskNo = this.$item.getTaskNo();
                        boolean z = this.$isDouble;
                        this.label = 1;
                        objY = homeRequest.y(taskNo, z ? 1 : 0, this);
                        if (objY == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objY = obj;
                    }
                    ReceiveRewardBean receiveRewardBean = (ReceiveRewardBean) objY;
                    int reward = receiveRewardBean != null ? receiveRewardBean.getReward() : 0;
                    if (this.$isDouble) {
                        sb = new StringBuilder();
                        sb.append(fe9.b.FLASH_COINS);
                        sb.append(reward / 2);
                        sb.append("x2");
                    } else {
                        sb = new StringBuilder();
                        sb.append("闪金币X");
                        sb.append(reward);
                    }
                    RewardInfoDetailBean rewardInfoDetailBean = new RewardInfoDetailBean(null, sb.toString(), null, null, 3, null, new RewardInfoMaterialBean(null, 0, 0, null, reward, 15, null), null, false, 429, null);
                    String strE = ys8.e(R.string.home_reward_dialog_top_title);
                    Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.home_reward_dialog_top_title)");
                    RewardInfoBean rewardInfoBean = new RewardInfoBean(rewardInfoDetailBean, 0L, 0L, 0, null, null, 0L, 0, null, strE, true, 510, null);
                    fb4.f41638a.a(this.$context, reward);
                    RewardInfoDialog.INSTANCE.a(this.$fragmentManager, rewardInfoBean);
                    Function0<Unit> function0 = this.$callback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, boolean z2) {
                Function1<Boolean, Unit> function1 = adBackCallback;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z));
                }
                BaseViewModelExtKt.b(viewModel, true, false, null, null, new AnonymousClass1(item, z2, context, fragmentManager, callback, null), 14, null);
                kq5.b(context, MobClickConstants.g, MapsKt.mapOf(new Pair[]{TuplesKt.to(SignUpWebActivity.A, item.getTaskConfigNo()), TuplesKt.to("taskName", item.getName())}));
            }
        };
        if (item.getRewardStrat() == 10 && System.currentTimeMillis() > r90.k()) {
            DoubleRewardDialog.INSTANCE.a(fragmentManager, new Function2<Boolean, Boolean, Unit>() { // from class: com.huachenjie.home.util.TasksUtil$receiveTaskReward$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, boolean z2) {
                    if (!z) {
                        kq5.b(context, MobClickConstants.m, MapsKt.mapOf(new Pair[]{TuplesKt.to(SignUpWebActivity.A, item.getTaskConfigNo()), TuplesKt.to("taskName", item.getName())}));
                    }
                    function2.invoke(Boolean.valueOf(!z), Boolean.valueOf(z2));
                }
            });
        } else {
            Boolean bool = Boolean.FALSE;
            function2.invoke(bool, bool);
        }
    }

    public final void j(@NotNull String taskConfigNo, @Nullable Function1<? super List<String>, Unit> block) {
        Intrinsics.checkNotNullParameter(taskConfigNo, SignUpWebActivity.A);
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, null, null, new TasksUtil$requestCompleteTask$1(taskConfigNo, block, null), 6, null);
    }
}
