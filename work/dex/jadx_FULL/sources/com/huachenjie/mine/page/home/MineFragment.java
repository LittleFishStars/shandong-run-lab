package com.huachenjie.mine.page.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.databinding.MineFragmentHomeBinding;
import com.huachenjie.mine.databinding.MineLayoutMineHeaderBinding;
import com.huachenjie.mine.page.attentions.MyAttentionsActivity;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.mine.page.fans.MyFansActivity;
import com.huachenjie.mine.page.home.MineFragment;
import com.huachenjie.mine.page.home.channel.MyChannelFragment;
import com.huachenjie.mine.page.home.post.MyPostFragment;
import com.huachenjie.mine.page.home.showcase.ShowcaseFragment;
import com.huachenjie.mine.page.home.topic.MyTopicFragment;
import com.huachenjie.mine.page.home.work.MyWorksFragment;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import com.huachenjie.mine.page.qr_code.MineQrCodeActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.kuaishou.weapon.p0.t;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ai9;
import com.zj.adlib.dj1;
import com.zj.adlib.dq1;
import com.zj.adlib.ik0;
import com.zj.adlib.jj8;
import com.zj.adlib.kq5;
import com.zj.adlib.r5a;
import com.zj.adlib.su9;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import java.util.ArrayList;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 D2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002EFB\u0007¢\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001d\u00100\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010)\u001a\u0004\b3\u00104R\u001d\u00108\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010)\u001a\u0004\b7\u0010/R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0015098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R#\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u00188\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/huachenjie/mine/page/home/MineFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentHomeBinding;", "Lcom/huachenjie/mine/page/home/MineVM;", "", "checkVisible", "loadData", "", "", "tagList", "", "isVip", "setFlowLevel", "binding", "initAppBar", "darkMode", "setStatusBar", "initTab", "initSlideLayout", "Landroid/view/View;", "view", "", "index", "startDressingTable", "", "", "getVariables", "getLayoutResID", "initData", "onFragmentResume", "onResume", "hidden", "onHiddenChanged", "initView", "initDataObservable", "Landroidx/drawerlayout/widget/DrawerLayout;", "mDrawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "statusBarDark", "Z", "onFriendPage$delegate", "Lkotlin/Lazy;", "getOnFriendPage", "()Z", "onFriendPage", "appUserCode$delegate", "getAppUserCode", "()Ljava/lang/String;", "appUserCode", "Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle$delegate", "getCustomTabStyle", "()Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle", "skipTarget$delegate", "getSkipTarget", MineFragment.SKIP_TARGET, "", "flowViewIdList", "Ljava/util/List;", "fragmentIsVisible", "Ljava/lang/Boolean;", "mineWorkTypeMap", "Ljava/util/Map;", "getMineWorkTypeMap", "()Ljava/util/Map;", "<init>", "()V", "Companion", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMineFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MineFragment.kt\ncom/huachenjie/mine/page/home/MineFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,455:1\n1855#2,2:456\n1855#2,2:458\n*S KotlinDebug\n*F\n+ 1 MineFragment.kt\ncom/huachenjie/mine/page/home/MineFragment\n*L\n185#1:456,2\n191#1:458,2\n*E\n"})
public final class MineFragment extends BaseMVVMFragment<MineFragmentHomeBinding, MineVM> {

    @NotNull
    public static final String APP_USER_CODE = "appUserCode";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ON_FRIEND_PAGE = "onFriendPage";

    @NotNull
    public static final String SKIP_TARGET = "skipTarget";

    @Nullable
    private Boolean fragmentIsVisible;

    @Nullable
    private DrawerLayout mDrawerLayout;
    private boolean statusBarDark;

    /* JADX INFO: renamed from: onFriendPage$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy onFriendPage = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mine.page.home.MineFragment$onFriendPage$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m598invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("onFriendPage", false) : false);
        }
    });

    /* JADX INFO: renamed from: appUserCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appUserCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.home.MineFragment$appUserCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("appUserCode");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: customTabStyle$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customTabStyle = LazyKt.lazy(new Function0<CustomTabStyle>() { // from class: com.huachenjie.mine.page.home.MineFragment$customTabStyle$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomTabStyle m597invoke() {
            return new CustomTabStyle();
        }
    });

    /* JADX INFO: renamed from: skipTarget$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy skipTarget = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.home.MineFragment$skipTarget$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString(MineFragment.SKIP_TARGET);
            }
            return null;
        }
    });

    @NotNull
    private final List<Integer> flowViewIdList = new ArrayList();

    @NotNull
    private final Map<String, Integer> mineWorkTypeMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("作品", 1), TuplesKt.to("收藏", 2), TuplesKt.to("喜欢", 3), TuplesKt.to("频道", 4), TuplesKt.to("话题", 5), TuplesKt.to("帖子", 6), TuplesKt.to("橱窗", 7)});

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/mine/page/home/MineFragment$a;", "", "Landroid/view/View;", "view", "", "e", "p", "d", t.d, y6b.g, "s", "r", "q", y6b.f, "c", "m", "j", "i", "k", "f", "<init>", "(Lcom/huachenjie/mine/page/home/MineFragment;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void n(View view, final MineFragment mineFragment, int i, String str) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(mineFragment, "this$0");
            view.postDelayed(new Runnable() { // from class: com.zj.adlib.op5
                @Override // java.lang.Runnable
                public final void run() {
                    MineFragment.a.o(mineFragment);
                }
            }, 150L);
        }

        public static final void o(MineFragment mineFragment) {
            Intrinsics.checkNotNullParameter(mineFragment, "this$0");
            ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.g, mineFragment.getAppUserCode()).withInt(UserConstants.CHAT_PARAMS.e, 1).navigation();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            MineFragment.this.startActivity(new Intent(view.getContext(), (Class<?>) MyAttentionsActivity.class));
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            MineFragment.this.startDressingTable(view, 2);
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            FragmentActivity activity = MineFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            su9.f(view.getContext());
        }

        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            MineFragment.this.startActivity(new Intent(view.getContext(), (Class<?>) MyFansActivity.class));
        }

        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            MineFragment.this.startDressingTable(view, 1);
        }

        public final void i(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            kq5.c(view.getContext(), "click_my_order");
            ARouter.getInstance().build(zj7.g.MY_ORDER).navigation();
        }

        public final void j(@NotNull View view) {
            MineData value;
            String avatarFrameImgUrl;
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage() || (value = MineFragment.access$getMViewModel(MineFragment.this).m().getValue()) == null) {
                return;
            }
            if (TextUtils.isEmpty(value.getAvatarFrameImgUrl())) {
                MineMateData value2 = MineFragment.access$getMViewModel(MineFragment.this).n().getValue();
                if (value2 == null || (avatarFrameImgUrl = value2.getAvatarFrameImgUrl()) == null) {
                    avatarFrameImgUrl = "";
                }
                value.setAvatarFrameImgUrl(avatarFrameImgUrl);
            }
            MineQrCodeActivity.Companion bVar = MineQrCodeActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            bVar.a(context, value);
        }

        public final void k(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            kq5.c(view.getContext(), "click_my_prize_records");
            ARouter.getInstance().build(zj7.e.REWARD_RECORD).navigation();
        }

        public final void l(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            MineFragment.this.startDressingTable(view, 0);
        }

        public final void m(@NotNull final View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            r5a.m(0);
            r5a.h(200);
            r5a.b bVarB0 = new r5a.b(MineFragment.this.getContext()).F(view).q0(PopupPosition.Bottom).n0(jj8.a(4.0f)).m0(jj8.a(0.0f)).b0(true);
            String[] strArr = {view.getContext().getString(R.string.works_detail_lao_report)};
            int[] iArr = {R.drawable.works_ic_user_pop_report};
            final MineFragment mineFragment = MineFragment.this;
            bVarB0.c(strArr, iArr, new OnSelectListener() { // from class: com.zj.adlib.np5
                public final void a(int i, String str) {
                    MineFragment.a.n(view, mineFragment, i, str);
                }
            }).show();
        }

        public final void p(@NotNull View view) {
            DrawerLayout drawerLayout;
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage() || (drawerLayout = MineFragment.this.mDrawerLayout) == null) {
                return;
            }
            drawerLayout.openDrawer(GravityCompat.START);
        }

        public final void q(@NotNull View view) {
            MineMateData value;
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage() || (value = MineFragment.access$getMViewModel(MineFragment.this).n().getValue()) == null) {
                return;
            }
            MineFragment mineFragment = MineFragment.this;
            kq5.c(view.getContext(), "click_my_theme");
            MyThemeActivity.Companion bVar = MyThemeActivity.INSTANCE;
            Context contextRequireContext = mineFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            bVar.startActivity(contextRequireContext, value.getThemeImg());
        }

        public final void r(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            su9.e(MineFragment.this.requireActivity());
        }

        public final void s(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (MineFragment.this.getOnFriendPage()) {
                return;
            }
            su9.t(MineFragment.this.requireActivity());
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.home.MineFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mine/page/home/MineFragment$b;", "", "", "onFriendPage", "", "appUserCode", MineFragment.SKIP_TARGET, "Lcom/huachenjie/mine/page/home/MineFragment;", "a", "APP_USER_CODE", "Ljava/lang/String;", "ON_FRIEND_PAGE", "SKIP_TARGET", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MineFragment a(boolean onFriendPage, @Nullable String appUserCode, @Nullable String skipTarget) {
            MineFragment mineFragment = new MineFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("onFriendPage", onFriendPage);
            bundle.putString("appUserCode", appUserCode);
            bundle.putString(MineFragment.SKIP_TARGET, skipTarget);
            mineFragment.setArguments(bundle);
            return mineFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35392a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35392a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35392a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35392a.invoke(obj);
        }
    }

    public static final /* synthetic */ MineVM access$getMViewModel(MineFragment mineFragment) {
        return mineFragment.getMViewModel();
    }

    private final void checkVisible() {
        if (Intrinsics.areEqual(this.fragmentIsVisible, Boolean.TRUE)) {
            loadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAppUserCode() {
        return (String) this.appUserCode.getValue();
    }

    private final CustomTabStyle getCustomTabStyle() {
        return (CustomTabStyle) this.customTabStyle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getOnFriendPage() {
        return ((Boolean) this.onFriendPage.getValue()).booleanValue();
    }

    private final String getSkipTarget() {
        return (String) this.skipTarget.getValue();
    }

    private final void initAppBar(final MineFragmentHomeBinding binding) {
        binding.f11271a.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.zj.adlib.mp5
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                MineFragment.initAppBar$lambda$6(binding, this, appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAppBar$lambda$6(MineFragmentHomeBinding mineFragmentHomeBinding, MineFragment mineFragment, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(mineFragmentHomeBinding, "$binding");
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        float fAbs = Math.abs(i) / mineFragmentHomeBinding.f11267a.getHeight();
        boolean z = ((double) fAbs) > 0.5d;
        mineFragment.statusBarDark = z;
        mineFragment.setStatusBar(z);
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 1.0f) {
            fAbs = 1.0f;
        }
        float f = 255;
        int iArgb = Color.argb((int) (fAbs * f), 255, 255, 255);
        int i2 = (int) ((1 - fAbs) * f);
        Color.argb(255, i2, i2, i2);
        mineFragmentHomeBinding.f11268a.setBackgroundColor(iArgb);
        if (mineFragment.getOnFriendPage()) {
            if (mineFragment.statusBarDark) {
                mineFragmentHomeBinding.f35323a.setImageResource(com.huachenjie.mine.R.drawable.base_ic_back_border);
                mineFragmentHomeBinding.c.setImageResource(com.huachenjie.mine.R.drawable.base_ic_menu_more_border);
            } else {
                mineFragmentHomeBinding.f35323a.setImageResource(com.huachenjie.mine.R.drawable.base_ic_back);
                mineFragmentHomeBinding.c.setImageResource(com.huachenjie.mine.R.drawable.base_ic_menu_more);
            }
            mineFragmentHomeBinding.f11275a.setPersonBlackState(mineFragment.statusBarDark);
            return;
        }
        if (mineFragment.statusBarDark) {
            mineFragmentHomeBinding.b.setImageResource(com.huachenjie.mine.R.drawable.mine_ic_mine_menu_border);
            mineFragmentHomeBinding.d.setImageResource(com.huachenjie.mine.R.drawable.mine_ic_mine_wear_border);
        } else {
            mineFragmentHomeBinding.b.setImageResource(com.huachenjie.mine.R.drawable.mine_ic_mine_menu);
            mineFragmentHomeBinding.d.setImageResource(com.huachenjie.mine.R.drawable.mine_ic_mine_wear);
        }
    }

    private final void initSlideLayout() {
        FragmentActivity activity = getActivity();
        this.mDrawerLayout = activity != null ? (DrawerLayout) activity.findViewById(com.huachenjie.mine.R.id.drawerLayout) : null;
    }

    private final void initTab(MineFragmentHomeBinding binding) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(childFragmentManager);
        binding.f11269a.setAdapter(viewPagerAdapter);
        List<String> listListOf = getOnFriendPage() ? CollectionsKt.listOf(new String[]{"作品", "收藏", "喜欢", "橱窗"}) : CollectionsKt.listOf(new String[]{"作品", "收藏", "喜欢", "频道", "话题", "帖子", "橱窗"});
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = listListOf.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            Integer num = this.mineWorkTypeMap.get(it.next());
            if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) || (num != null && num.intValue() == 3)) {
                i = 1;
            }
            if (i != 0) {
                arrayList.add(MyWorksFragment.INSTANCE.a(num.intValue(), getOnFriendPage(), getAppUserCode()));
            } else if (num != null && num.intValue() == 4) {
                arrayList.add(new MyChannelFragment());
            } else if (num != null && num.intValue() == 5) {
                arrayList.add(new MyTopicFragment());
            } else if (num != null && num.intValue() == 6) {
                arrayList.add(new MyPostFragment());
            } else if (num != null && num.intValue() == 7) {
                arrayList.add(ShowcaseFragment.INSTANCE.a(getOnFriendPage() ? getAppUserCode() : null));
            }
        }
        binding.f11269a.setOffscreenPageLimit(listListOf.size());
        viewPagerAdapter.a(listListOf, arrayList);
        binding.f11270a.setViewPager(binding.f11269a, listListOf);
        CustomTabStyle customTabStyle = getCustomTabStyle();
        SlidingTabLayout slidingTabLayout = binding.f11270a;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout, "binding.tabLayout");
        CustomTabStyle.f(customTabStyle, slidingTabLayout, binding.f11269a, null, 0, 12, null);
        if (TextUtils.equals(getSkipTarget(), "1")) {
            int iIndexOf = listListOf.indexOf("橱窗");
            binding.f11270a.setCurrentTab(iIndexOf != -1 ? iIndexOf : 0);
        }
    }

    private final void loadData() {
        getMViewModel().r(getAppUserCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFlowLevel(List<String> tagList, boolean isVip) {
        MineLayoutMineHeaderBinding mineLayoutMineHeaderBinding;
        LinearLayout linearLayout;
        MineFragmentHomeBinding mBinding = getMBinding();
        if (mBinding == null || (mineLayoutMineHeaderBinding = mBinding.f11272a) == null || (linearLayout = mineLayoutMineHeaderBinding.f11347b) == null) {
            return;
        }
        Iterator<T> it = this.flowViewIdList.iterator();
        while (it.hasNext()) {
            View viewFindViewById = linearLayout.findViewById(((Number) it.next()).intValue());
            if (viewFindViewById != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(id)");
                linearLayout.removeView(viewFindViewById);
            }
        }
        this.flowViewIdList.clear();
        for (String str : tagList) {
            TextView textView = new TextView(linearLayout.getContext());
            textView.setId(View.generateViewId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, jj8.a(20.0f));
            layoutParams.setMarginEnd(jj8.a(4.0f));
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            int iA = jj8.a(8.0f);
            textView.setPadding(iA, 0, iA, 0);
            textView.setText(str);
            textView.setTextColor(RunIndexRecordAdapter.K);
            textView.setTextSize(10.0f);
            textView.setBackground(new DrawableCreator.Builder().setSolidColor(isVip ? -5461 : -5967873).setCornersRadius(jj8.a(10.0f)).build());
            this.flowViewIdList.add(Integer.valueOf(textView.getId()));
            linearLayout.addView(textView);
        }
    }

    private final void setStatusBar(boolean darkMode) {
        if (getActivity() == null) {
            return;
        }
        e.z3(this).G2(com.huachenjie.mine.R.color.transparent).T2(darkMode).q1(false).u1(com.huachenjie.mine.R.color.white).G1(true).a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDressingTable(View view, int index) {
        String avatarFrameImgUrl;
        MineData value = getMViewModel().m().getValue();
        if (value == null) {
            return;
        }
        if (TextUtils.isEmpty(value.getAvatarFrameImgUrl())) {
            MineMateData value2 = getMViewModel().n().getValue();
            if (value2 == null || (avatarFrameImgUrl = value2.getAvatarFrameImgUrl()) == null) {
                avatarFrameImgUrl = "";
            }
            value.setAvatarFrameImgUrl(avatarFrameImgUrl);
        }
        kq5.c(view.getContext(), "click_my_dressing");
        DressingTableActivity.Companion companion = DressingTableActivity.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        companion.a(context, value, index);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return com.huachenjie.mine.R.layout.mine_fragment_home;
    }

    @NotNull
    public final Map<String, Integer> getMineWorkTypeMap() {
        return this.mineWorkTypeMap;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().o().setValue(Boolean.valueOf(getOnFriendPage()));
        getMViewModel().q().setValue(Boolean.valueOf(!Intrinsics.areEqual(getAppUserCode(), ai9.e().getUserId())));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().n().observe(this, new c(new Function1<MineMateData, Unit>() { // from class: com.huachenjie.mine.page.home.MineFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MineMateData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MineMateData mineMateData) {
                String avatar;
                String nickName;
                if (MineFragment.this.getOnFriendPage()) {
                    MutableLiveData<UserInfoBean> mutableLiveDataP = MineFragment.access$getMViewModel(MineFragment.this).p();
                    String appUserCode = MineFragment.this.getAppUserCode();
                    String str = appUserCode == null ? "" : appUserCode;
                    String accid = mineMateData.getAccid();
                    String str2 = accid == null ? "" : accid;
                    int i = mineMateData.getFollowed() ? 2 : 1;
                    MineData value = MineFragment.access$getMViewModel(MineFragment.this).m().getValue();
                    String str3 = (value == null || (nickName = value.getNickName()) == null) ? "" : nickName;
                    MineData value2 = MineFragment.access$getMViewModel(MineFragment.this).m().getValue();
                    mutableLiveDataP.setValue(new UserInfoBean(null, str3, (value2 == null || (avatar = value2.getAvatar()) == null) ? "" : avatar, null, str, mineMateData.getAvatarFrameImgUrl(), str2, null, i, dj1.i(mineMateData.getAccid()), 0, null, null, false, false, 31881, null));
                }
            }
        }));
        getMViewModel().m().observe(this, new c(new Function1<MineData, Unit>() { // from class: com.huachenjie.mine.page.home.MineFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MineData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MineData mineData) {
                MineFragment mineFragment = MineFragment.this;
                List<String> tagList = mineData.getTagList();
                MineMateData value = MineFragment.access$getMViewModel(MineFragment.this).n().getValue();
                mineFragment.setFlowLevel(tagList, value != null ? value.getBisVip() : false);
                UserInfoBean value2 = MineFragment.access$getMViewModel(MineFragment.this).p().getValue();
                if (value2 != null) {
                    MineFragment mineFragment2 = MineFragment.this;
                    value2.setNickName(mineData.getNickName());
                    value2.setAvatar(mineData.getAvatar());
                    MineFragment.access$getMViewModel(mineFragment2).p().setValue(value2);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initSlideLayout();
        MineFragmentHomeBinding mBinding = getMBinding();
        if (mBinding != null) {
            initAppBar(mBinding);
            initTab(mBinding);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        super.onFragmentResume();
        setStatusBar(this.statusBarDark);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.fragmentIsVisible = Boolean.valueOf(!hidden);
        if (hidden || !dq1.e().getRefreshMyTab()) {
            return;
        }
        loadData();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fragmentIsVisible == null) {
            this.fragmentIsVisible = Boolean.TRUE;
        }
        checkVisible();
    }
}
