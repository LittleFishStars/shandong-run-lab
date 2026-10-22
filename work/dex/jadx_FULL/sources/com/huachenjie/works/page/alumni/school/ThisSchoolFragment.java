package com.huachenjie.works.page.alumni.school;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.broadcast.channel.ChannelOperateListener;
import com.huachenjie.base.broadcast.channel.ChannelOperateReceiver;
import com.huachenjie.base.broadcast.post.PostOperateListener;
import com.huachenjie.base.broadcast.post.PostOperateReceiver;
import com.huachenjie.base.mob.MobClickConstants;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.bean.PostCategoryDataBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.bean.PostedSchoolBean;
import com.huachenjie.works.bean.SchoolBannerBean;
import com.huachenjie.works.bean.ThisSchoolBean;
import com.huachenjie.works.databinding.WorksFragmentThisSchoolBinding;
import com.huachenjie.works.databinding.WorksHeadThisSchoolBinding;
import com.huachenjie.works.page.alumni.AlumniFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.huachenjie.works.page.this_school.ThisSchoolActivity;
import com.igexin.push.g.o;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.fe9;
import com.zj.adlib.ju3;
import com.zj.adlib.kq5;
import com.zj.adlib.qi1;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import com.zj.adlib.tv6;
import com.zj.adlib.yj7;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0017H\u0016J\u0016\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0016J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0016J\b\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0016J\b\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/huachenjie/works/page/alumni/school/ThisSchoolFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentThisSchoolBinding;", "Lcom/huachenjie/works/page/alumni/school/ThisSchoolVM;", "()V", "channelOperateReceiver", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "getChannelOperateReceiver", "()Lcom/huachenjie/base/broadcast/channel/ChannelOperateReceiver;", "channelOperateReceiver$delegate", "Lkotlin/Lazy;", "isDark", "", "()Z", "setDark", "(Z)V", "mHeaderBinding", "Lcom/huachenjie/works/databinding/WorksHeadThisSchoolBinding;", "kotlin.jvm.PlatformType", "getMHeaderBinding", "()Lcom/huachenjie/works/databinding/WorksHeadThisSchoolBinding;", "mHeaderBinding$delegate", "offsetY", "", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "pickerHelper", "Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "getPickerHelper", "()Lcom/huachenjie/base/widget/picker/OptionsPickerHelper;", "pickerHelper$delegate", "postOperateReceiver", "Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "getPostOperateReceiver", "()Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "postOperateReceiver$delegate", "totalOffset", "dealClickBanner", "", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/works/bean/SchoolBannerBean;", "getLayoutResID", "getVariables", "", "", "initAdapter", "initBanner", "initData", "initDataObservable", "initView", "onDestroyView", "onViewCreated", "refreshHeader", "setParentFragmentDark", "ClickProxy", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ThisSchoolFragment extends BaseMVVMFragment<WorksFragmentThisSchoolBinding, ThisSchoolVM> {
    private int offsetY;
    private int totalOffset;
    private boolean isDark = true;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.g59
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            ThisSchoolFragment.onRefreshListener$lambda$0(this.f41825a);
        }
    };

    /* JADX INFO: renamed from: mHeaderBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHeaderBinding = LazyKt.lazy(new Function0<WorksHeadThisSchoolBinding>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$mHeaderBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksHeadThisSchoolBinding m861invoke() {
            return (WorksHeadThisSchoolBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.works_head_this_school, null, false);
        }
    });

    /* JADX INFO: renamed from: postOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy postOperateReceiver = LazyKt.lazy(new Function0<PostOperateReceiver>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$postOperateReceiver$2

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/alumni/school/ThisSchoolFragment$postOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/post/PostOperateListener;", "", "postNo", "", "isChecked", "", "likeCount", "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nThisSchoolFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThisSchoolFragment.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolFragment$postOperateReceiver$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,421:1\n350#2,7:422\n*S KotlinDebug\n*F\n+ 1 ThisSchoolFragment.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolFragment$postOperateReceiver$2$1\n*L\n85#1:422,7\n*E\n"})
        public static final class a implements PostOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThisSchoolFragment f37197a;

            public a(ThisSchoolFragment thisSchoolFragment) {
                this.f37197a = thisSchoolFragment;
            }

            @Override // com.huachenjie.base.broadcast.post.PostOperateListener
            public void a(@Nullable String postNo, boolean isChecked, int likeCount) {
                PostAdapter value;
                if (TextUtils.isEmpty(postNo) || (value = ThisSchoolFragment.access$getMViewModel(this.f37197a).k().getValue()) == null) {
                    return;
                }
                Iterator it = value.getData().iterator();
                boolean z = false;
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(((PostItemBean) it.next()).getPostInfo().getPostNo(), postNo)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && i < value.getData().size()) {
                    z = true;
                }
                if (z) {
                    ((PostItemBean) value.getData().get(i)).setLiked(isChecked, likeCount);
                    value.notifyItemChanged(i + value.getHeaderLayoutCount());
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PostOperateReceiver m863invoke() {
            return new PostOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: channelOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelOperateReceiver = LazyKt.lazy(new Function0<ChannelOperateReceiver>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$channelOperateReceiver$2

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/huachenjie/works/page/alumni/school/ThisSchoolFragment$channelOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/channel/ChannelOperateListener;", "", "channelNo", "logo", "", "isCrested", "", "b", "a", qi1.CHANNEL_STATUS_CHANGE, "d", "teamId", qi1.FROM_ORGANIZE, "c", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements ChannelOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ThisSchoolFragment f37195a;

            public a(ThisSchoolFragment thisSchoolFragment) {
                this.f37195a = thisSchoolFragment;
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void a(@NotNull String channelNo) {
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                ThisSchoolBean value = ThisSchoolFragment.access$getMViewModel(this.f37195a).r().getValue();
                if (value != null && TextUtils.equals(channelNo, value.findOfficialChannel().getChannelNo())) {
                    value.findOfficialChannel().setJoinFlag(false);
                    ThisSchoolFragment.access$getMViewModel(this.f37195a).r().setValue(value);
                }
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void b(@NotNull String channelNo, @NotNull String logo, boolean isCrested) {
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(logo, "logo");
                ThisSchoolBean value = ThisSchoolFragment.access$getMViewModel(this.f37195a).r().getValue();
                if (value != null && TextUtils.equals(channelNo, value.findOfficialChannel().getChannelNo())) {
                    value.findOfficialChannel().setJoinFlag(true);
                    ThisSchoolFragment.access$getMViewModel(this.f37195a).r().setValue(value);
                }
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void c(@NotNull String channelNo, @NotNull String teamId, boolean fromOrganize) {
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(teamId, "teamId");
            }

            @Override // com.huachenjie.base.broadcast.channel.ChannelOperateListener
            public void d(@NotNull String channelNo, @NotNull String logo, boolean channelStatusChange) {
                Intrinsics.checkNotNullParameter(channelNo, "channelNo");
                Intrinsics.checkNotNullParameter(logo, "logo");
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelOperateReceiver m860invoke() {
            return new ChannelOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: pickerHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy pickerHelper = LazyKt.lazy(new Function0<OptionsPickerHelper>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$pickerHelper$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OptionsPickerHelper m862invoke() {
            return new OptionsPickerHelper();
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/alumni/school/ThisSchoolFragment$ClickProxy;", "", "Landroid/view/View;", "v", "", "a", "e", "b", "view", "d", "c", "<init>", "(Lcom/huachenjie/works/page/alumni/school/ThisSchoolFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            final ThisSchoolBean value = ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).r().getValue();
            if (value == null) {
                return;
            }
            if (value.findOfficialChannel().getJoinFlag()) {
                ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", value.findOfficialChannel().getChannelNo()).navigation();
                return;
            }
            JoinChannelTipDialog.Companion bVar = JoinChannelTipDialog.INSTANCE;
            String channelNo = value.findOfficialChannel().getChannelNo();
            final ThisSchoolFragment thisSchoolFragment = ThisSchoolFragment.this;
            JoinChannelTipDialog joinChannelTipDialogA = bVar.a(channelNo, new Function0<Unit>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$ClickProxy$clickChannelMain$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m859invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m859invoke() {
                    qi1 qi1Var = qi1.f44215a;
                    Context contextRequireContext = thisSchoolFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    qi1Var.d(contextRequireContext, value.findOfficialChannel().getChannelNo(), value.findOfficialChannel().getLogo());
                }
            });
            FragmentManager childFragmentManager = ThisSchoolFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            joinChannelTipDialogA.show(childFragmentManager, Reflection.getOrCreateKotlinClass(JoinChannelTipDialog.class).getSimpleName());
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            PostCategoryDataBean value = ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).o().getValue();
            if (value == null) {
                return;
            }
            PostListActivity.Companion companion = PostListActivity.INSTANCE;
            Context context = v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            companion.a(context, 1, "吃瓜热榜", "", "", ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).s().getValue(), value.getTypeList());
        }

        public final void c(@Nullable View view) {
            PostCategoryDataBean value;
            if (view == null) {
                return;
            }
            try {
                int i = Integer.parseInt(view.getTag().toString());
                if (view instanceof TextView) {
                    boolean z = false;
                    if (i >= 0 && i < 6) {
                        z = true;
                    }
                    if (z && (value = ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).o().getValue()) != null) {
                        if (i < 3) {
                            PostListActivity.Companion companion = PostListActivity.INSTANCE;
                            Context context = ((TextView) view).getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "clickView.context");
                            companion.a(context, 2, ((TextView) view).getText().toString(), value.findCategory(i).getTypeCode(), "", ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).s().getValue(), (64 & 64) != 0 ? new ArrayList() : null);
                        } else {
                            PostCategoryBean postCategoryBeanFindCategory = value.findCategory(i);
                            PostListActivity.Companion companion2 = PostListActivity.INSTANCE;
                            Context context2 = ((TextView) view).getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "clickView.context");
                            companion2.a(context2, 3, ((TextView) view).getText().toString(), postCategoryBeanFindCategory.getTypeCode(), postCategoryBeanFindCategory.getTagCode(), ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).s().getValue(), (64 & 64) != 0 ? new ArrayList() : null);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void d(@NotNull View view) {
            ArrayList<PostCategoryBean> typeList;
            Intrinsics.checkNotNullParameter(view, "view");
            PostCategoryDataBean value = ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).o().getValue();
            if (value == null || (typeList = value.getTypeList()) == null || typeList.isEmpty()) {
                return;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            PublishPostDialog publishPostDialogA = PublishPostDialog.INSTANCE.a(iArr[0], iArr[1], typeList);
            FragmentManager childFragmentManager = ThisSchoolFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            publishPostDialogA.show(childFragmentManager, PublishPostDialog.class.getSimpleName());
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).A();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37194a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37194a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37194a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37194a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$initDataObservable$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", GoodsSpecificationPreviewActivity.z, "", "Lcom/huachenjie/works/bean/PostedSchoolBean;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nThisSchoolFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThisSchoolFragment.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolFragment$initDataObservable$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,421:1\n1549#2:422\n1620#2,3:423\n*S KotlinDebug\n*F\n+ 1 ThisSchoolFragment.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolFragment$initDataObservable$5\n*L\n272#1:422\n272#1:423,3\n*E\n"})
    public static final class AnonymousClass5 extends Lambda implements Function1<List<? extends PostedSchoolBean>, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(ThisSchoolFragment thisSchoolFragment, List list, int i, String str) {
            Intrinsics.checkNotNullParameter(thisSchoolFragment, "this$0");
            ThisSchoolFragment.access$getMViewModel(thisSchoolFragment).s().setValue(((PostedSchoolBean) list.get(i)).getSchoolCode());
            ThisSchoolFragment.access$getMViewModel(thisSchoolFragment).C(true);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<PostedSchoolBean>) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(final List<PostedSchoolBean> list) {
            Context context;
            if (list == null || !(!list.isEmpty()) || (context = ThisSchoolFragment.this.getContext()) == null) {
                return;
            }
            final ThisSchoolFragment thisSchoolFragment = ThisSchoolFragment.this;
            OptionsPickerHelper pickerHelper = thisSchoolFragment.getPickerHelper();
            List<PostedSchoolBean> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((PostedSchoolBean) it.next()).getName());
            }
            pickerHelper.p(context, null, CollectionsKt.toList(arrayList), new OptionsPickerHelper.OnPickChangeListener() { // from class: com.huachenjie.works.page.alumni.school.a
                @Override // com.huachenjie.base.widget.picker.OptionsPickerHelper.OnPickChangeListener
                public final void a(int i, String str) {
                    ThisSchoolFragment.AnonymousClass5.invoke$lambda$2$lambda$1(thisSchoolFragment, list, i, str);
                }
            });
        }
    }

    public static final /* synthetic */ WorksFragmentThisSchoolBinding access$getMBinding(ThisSchoolFragment thisSchoolFragment) {
        return thisSchoolFragment.getMBinding();
    }

    public static final /* synthetic */ ThisSchoolVM access$getMViewModel(ThisSchoolFragment thisSchoolFragment) {
        return thisSchoolFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealClickBanner(SchoolBannerBean bean) {
        int linkType = bean.getLinkType();
        if (linkType == 2) {
            ARouter.getInstance().build(zj7.i.POST_DETAIL).withString("postNo", bean.getRelationCode()).navigation();
            return;
        }
        if (linkType == 3) {
            ARouter.getInstance().build(zj7.b.ORGANIZE_ACTIVITY_DETAIL).withString(yj7.b.ORGANIZE_ACTIVITY_NO, bean.getRelationCode()).navigation();
            return;
        }
        if (linkType == 4) {
            Context context = getContext();
            if (context != null) {
                su9.q(context, bean.getRelationUrl());
                return;
            }
            return;
        }
        if (linkType != 5) {
            if (linkType == 10 || linkType == 11) {
                ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", bean.getRelationCode()).navigation();
                return;
            }
            return;
        }
        Context context2 = getContext();
        if (context2 != null) {
            su9.l(context2, bean.getRelationUrl());
        }
    }

    private final ChannelOperateReceiver getChannelOperateReceiver() {
        return (ChannelOperateReceiver) this.channelOperateReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WorksHeadThisSchoolBinding getMHeaderBinding() {
        return (WorksHeadThisSchoolBinding) this.mHeaderBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OptionsPickerHelper getPickerHelper() {
        return (OptionsPickerHelper) this.pickerHelper.getValue();
    }

    private final PostOperateReceiver getPostOperateReceiver() {
        return (PostOperateReceiver) this.postOperateReceiver.getValue();
    }

    private final void initAdapter() {
        RecyclerView recyclerView;
        View view;
        MutableLiveData<PostAdapter> mutableLiveDataK = getMViewModel().k();
        PostAdapter postAdapter = new PostAdapter(getMViewModel(), 0, 12.0f);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.emptyView);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.emptyView)");
            if (viewFindViewById.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.2f;
            }
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        postAdapter.o(viewInflate);
        initBanner();
        getMHeaderBinding().m(getMViewModel());
        getMHeaderBinding().l(new ClickProxy());
        getMHeaderBinding().executePendingBindings();
        View root = getMHeaderBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mHeaderBinding.root");
        BaseQuickAdapter.addHeaderView$default(postAdapter, root, 0, 0, 6, null);
        postAdapter.setHeaderWithEmptyEnable(true);
        postAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.e59
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ThisSchoolFragment.initAdapter$lambda$4$lambda$3(this.f41351a);
            }
        });
        mutableLiveDataK.setValue(postAdapter);
        WorksFragmentThisSchoolBinding mBinding = getMBinding();
        if (mBinding != null && (view = mBinding.f36962a) != null) {
            view.post(new Runnable() { // from class: com.zj.adlib.f59
                @Override // java.lang.Runnable
                public final void run() {
                    ThisSchoolFragment.initAdapter$lambda$5(this.f41603a);
                }
            });
        }
        WorksFragmentThisSchoolBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (recyclerView = mBinding2.f14340a) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment.initAdapter.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                ThisSchoolBean value = ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).r().getValue();
                if (value != null && value.showOfficialChannel()) {
                    ThisSchoolFragment.this.offsetY += dy;
                    float fAbs = Math.abs(ThisSchoolFragment.this.offsetY) / ThisSchoolFragment.this.totalOffset;
                    if (fAbs < 0.0f) {
                        fAbs = 0.0f;
                    }
                    if (fAbs > 1.0f) {
                        fAbs = 1.0f;
                    }
                    boolean z = ((double) fAbs) > 0.5d;
                    if (ThisSchoolFragment.this.getIsDark() != z) {
                        ThisSchoolFragment.this.setDark(z);
                        ThisSchoolFragment thisSchoolFragment = ThisSchoolFragment.this;
                        thisSchoolFragment.setParentFragmentDark(thisSchoolFragment.getIsDark());
                    }
                    ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).l().setValue(Integer.valueOf(Color.argb((int) (fAbs * 255), 255, 255, 255)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$3(ThisSchoolFragment thisSchoolFragment) {
        Intrinsics.checkNotNullParameter(thisSchoolFragment, "this$0");
        thisSchoolFragment.getMViewModel().w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5(ThisSchoolFragment thisSchoolFragment) {
        View view;
        Intrinsics.checkNotNullParameter(thisSchoolFragment, "this$0");
        WorksFragmentThisSchoolBinding mBinding = thisSchoolFragment.getMBinding();
        thisSchoolFragment.totalOffset = (mBinding == null || (view = mBinding.f36962a) == null) ? 0 : view.getHeight();
    }

    private final void initBanner() {
        Banner banner;
        BannerImageAdapter<SchoolBannerBean> bannerImageAdapter = new BannerImageAdapter<SchoolBannerBean>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment$initBanner$bannerAdapter$1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onBindView(@NotNull BannerImageHolder holder, @NotNull SchoolBannerBean data, int position, int size) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(data, "data");
                Glide.with(holder.itemView).load(data.getAdImg()).apply((BaseRequestOptions<?>) ju3.n).into(holder.imageView);
            }
        };
        bannerImageAdapter.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.d59
            public final void OnBannerClick(Object obj, int i) {
                ThisSchoolFragment.initBanner$lambda$7$lambda$6(this.f41111a, (SchoolBannerBean) obj, i);
            }
        });
        WorksHeadThisSchoolBinding mHeaderBinding = getMHeaderBinding();
        if (mHeaderBinding == null || (banner = mHeaderBinding.f14410a) == null) {
            return;
        }
        banner.setAdapter(bannerImageAdapter);
        banner.setIndicator(new CircleIndicator(requireContext()));
        banner.addBannerLifecycleObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$7$lambda$6(ThisSchoolFragment thisSchoolFragment, SchoolBannerBean schoolBannerBean, int i) {
        Intrinsics.checkNotNullParameter(thisSchoolFragment, "this$0");
        Context context = thisSchoolFragment.getContext();
        if (context == null) {
            return;
        }
        kq5.c(context, MobClickConstants.e);
        ThisSchoolVM mViewModel = thisSchoolFragment.getMViewModel();
        Intrinsics.checkNotNullExpressionValue(schoolBannerBean, "data");
        mViewModel.j(schoolBannerBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(ThisSchoolFragment thisSchoolFragment) {
        Intrinsics.checkNotNullParameter(thisSchoolFragment, "this$0");
        ThisSchoolVM.D(thisSchoolFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshHeader() {
        getMHeaderBinding().setVariable(qk0.p0, getMViewModel());
        getMHeaderBinding().setVariable(qk0.k, new ClickProxy());
        getMHeaderBinding().executePendingBindings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setParentFragmentDark(boolean isDark) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof AlumniFragment) {
            ((AlumniFragment) parentFragment).childSetTabDark(fe9.a.THIS_SCHOOL, isDark);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ThisSchoolActivity) {
            ((ThisSchoolActivity) activity).Z(isDark);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_this_school;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener), TuplesKt.to(Integer.valueOf(qk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ThisSchoolVM.D(getMViewModel(), false, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().v().observe(this, new a(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    ThisSchoolFragment.this.offsetY = 0;
                    ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).l().setValue(Integer.valueOf(Color.parseColor("#00000000")));
                }
            }
        }));
        getMViewModel().m().observe(this, new a(new Function1<SchoolBannerBean, Unit>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SchoolBannerBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SchoolBannerBean schoolBannerBean) {
                if (schoolBannerBean != null) {
                    ThisSchoolFragment.this.dealClickBanner(schoolBannerBean);
                }
            }
        }));
        getMViewModel().r().observe(this, new a(new Function1<ThisSchoolBean, Unit>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment.initDataObservable.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ThisSchoolBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ThisSchoolBean thisSchoolBean) {
                Banner banner;
                RecyclerView recyclerView;
                ThisSchoolFragment.this.setDark(!thisSchoolBean.showOfficialChannel());
                ThisSchoolFragment thisSchoolFragment = ThisSchoolFragment.this;
                thisSchoolFragment.setParentFragmentDark(thisSchoolFragment.getIsDark());
                if (!thisSchoolBean.showOfficialChannel()) {
                    ThisSchoolFragment.access$getMViewModel(ThisSchoolFragment.this).l().setValue(-1);
                }
                WorksFragmentThisSchoolBinding worksFragmentThisSchoolBindingAccess$getMBinding = ThisSchoolFragment.access$getMBinding(ThisSchoolFragment.this);
                if (worksFragmentThisSchoolBindingAccess$getMBinding != null && (recyclerView = worksFragmentThisSchoolBindingAccess$getMBinding.f14340a) != null) {
                    recyclerView.scrollToPosition(0);
                }
                WorksHeadThisSchoolBinding mHeaderBinding = ThisSchoolFragment.this.getMHeaderBinding();
                if (mHeaderBinding != null && (banner = mHeaderBinding.f14410a) != null) {
                    banner.setDatas(thisSchoolBean.getBannerList());
                }
                ThisSchoolFragment.this.refreshHeader();
            }
        }));
        getMViewModel().o().observe(this, new a(new Function1<PostCategoryDataBean, Unit>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolFragment.initDataObservable.4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PostCategoryDataBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PostCategoryDataBean postCategoryDataBean) {
                ThisSchoolFragment.this.refreshHeader();
            }
        }));
        getMViewModel().p().observe(this, new a(new AnonymousClass5()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    /* JADX INFO: renamed from: isDark, reason: from getter */
    public final boolean getIsDark() {
        return this.isDark;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        tv6 tv6Var = tv6.f45013a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        tv6Var.unregisterReceiver(contextRequireContext, getPostOperateReceiver());
        qi1 qi1Var = qi1.f44215a;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        qi1Var.unregisterReceiver(contextRequireContext2, getChannelOperateReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        tv6 tv6Var = tv6.f45013a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        tv6Var.registerReceiver(contextRequireContext, getPostOperateReceiver());
        qi1 qi1Var = qi1.f44215a;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        qi1Var.registerReceiver(contextRequireContext2, getChannelOperateReceiver());
    }

    public final void setDark(boolean z) {
        this.isDark = z;
    }
}
