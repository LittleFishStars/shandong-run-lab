package com.huachenjie.channel.page.organize.menu;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.ri1;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u001b\u0010\u0011\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM;", "", "initAdapter", "initView", "initDataObserve", "updateAdapterSuccess", "", "content", "searchContentChanged", "searchValue", "onSearchActionCall", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "clubCode$delegate", "getClubCode", "clubCode", "clubAdminUserCode$delegate", "getClubAdminUserCode", OrganizeMenuMemberFragment.CLUB_ADMIN_CODE, "Lcom/huachenjie/channel/page/organize/menu/OnSetAdminCallback;", "mCallback", "Lcom/huachenjie/channel/page/organize/menu/OnSetAdminCallback;", "Landroid/widget/TextView;", "tvChannelMembers$delegate", "getTvChannelMembers", "()Landroid/widget/TextView;", "tvChannelMembers", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMenuMemberFragment extends BasePubWorkMenuFragment<OrganizeMenuMemberVM> {

    @NotNull
    private static final String CHANNEL_NO = "channelNo";

    @NotNull
    private static final String CLUB_ADMIN_CODE = "clubAdminUserCode";

    @NotNull
    private static final String CLUB_CODE = "clubCode";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnSetAdminCallback mCallback;

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channelNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: clubCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clubCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment$clubCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("clubCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: clubAdminUserCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy clubAdminUserCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment$clubAdminUserCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("clubAdminUserCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: tvChannelMembers$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvChannelMembers = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment$tvChannelMembers$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m312invoke() {
            return (TextView) this.this$0.insertViewToPlaceholder1(R.layout.channel_view_channel_members);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberFragment$a;", "", "", "channelNo", "clubCode", OrganizeMenuMemberFragment.CLUB_ADMIN_CODE, "Lcom/huachenjie/channel/page/organize/menu/OnSetAdminCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberFragment;", "a", "CHANNEL_NO", "Ljava/lang/String;", "CLUB_ADMIN_CODE", "CLUB_CODE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrganizeMenuMemberFragment a(@NotNull String channelNo, @NotNull String clubCode, @Nullable String clubAdminUserCode, @NotNull OnSetAdminCallback callback) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(clubCode, "clubCode");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            OrganizeMenuMemberFragment organizeMenuMemberFragment = new OrganizeMenuMemberFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            bundle.putString("clubCode", clubCode);
            bundle.putString(OrganizeMenuMemberFragment.CLUB_ADMIN_CODE, clubAdminUserCode);
            organizeMenuMemberFragment.setArguments(bundle);
            organizeMenuMemberFragment.mCallback = callback;
            return organizeMenuMemberFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33522a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33522a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33522a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33522a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final String getClubAdminUserCode() {
        return (String) this.clubAdminUserCode.getValue();
    }

    private final String getClubCode() {
        return (String) this.clubCode.getValue();
    }

    private final TextView getTvChannelMembers() {
        return (TextView) this.tvChannelMembers.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB = ((OrganizeMenuMemberVM) getMViewModel()).B();
        final OrganizeMenuMemberAdapter organizeMenuMemberAdapter = new OrganizeMenuMemberAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null, false);
        View viewFindViewById = viewInflate.findViewById(R.id.emptyView);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.emptyView)");
            if (viewFindViewById.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.4f;
            }
        }
        organizeMenuMemberAdapter.k(viewInflate);
        organizeMenuMemberAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.qe6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OrganizeMenuMemberFragment.initAdapter$lambda$6$lambda$3(this.f44192a);
            }
        });
        organizeMenuMemberAdapter.addChildClickViewIds(R.id.ivAvatar, R.id.tv_set);
        y57.b(organizeMenuMemberAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.re6
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeMenuMemberFragment.initAdapter$lambda$6$lambda$5(organizeMenuMemberAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(organizeMenuMemberAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$6$lambda$3(OrganizeMenuMemberFragment organizeMenuMemberFragment) {
        Intrinsics.checkNotNullParameter(organizeMenuMemberFragment, "this$0");
        ((OrganizeMenuMemberVM) organizeMenuMemberFragment.getMViewModel()).w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$5(OrganizeMenuMemberAdapter organizeMenuMemberAdapter, final OrganizeMenuMemberFragment organizeMenuMemberFragment, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(organizeMenuMemberAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(organizeMenuMemberFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final ChannelMemberBean channelMemberBean = organizeMenuMemberAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ivAvatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", channelMemberBean.getMemberUserCode()).navigation();
        } else if (id == R.id.tv_set) {
            ft1.p(view.getContext(), "确定设置该用户为社长吗？", new View.OnClickListener() { // from class: com.zj.adlib.pe6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OrganizeMenuMemberFragment.initAdapter$lambda$6$lambda$5$lambda$4(this.f18827a, channelMemberBean, i, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$6$lambda$5$lambda$4(OrganizeMenuMemberFragment organizeMenuMemberFragment, ChannelMemberBean channelMemberBean, int i, View view) {
        Intrinsics.checkNotNullParameter(organizeMenuMemberFragment, "this$0");
        Intrinsics.checkNotNullParameter(channelMemberBean, "$bean");
        OrganizeMenuMemberVM organizeMenuMemberVM = (OrganizeMenuMemberVM) organizeMenuMemberFragment.getMViewModel();
        String channelNo = organizeMenuMemberFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        String clubCode = organizeMenuMemberFragment.getClubCode();
        Intrinsics.checkNotNullExpressionValue(clubCode, "clubCode");
        organizeMenuMemberVM.M(channelNo, channelMemberBean, clubCode, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        ((OrganizeMenuMemberVM) getMViewModel()).K().observe(this, new b(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                OnSetAdminCallback onSetAdminCallback;
                if (TextUtils.isEmpty(str) || (onSetAdminCallback = OrganizeMenuMemberFragment.this.mCallback) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                onSetAdminCallback.a(str, false);
            }
        }));
        ((OrganizeMenuMemberVM) getMViewModel()).L().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment.initDataObserve.2
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
                    Context context = OrganizeMenuMemberFragment.this.getContext();
                    if (context != null) {
                        OrganizeMenuMemberFragment organizeMenuMemberFragment = OrganizeMenuMemberFragment.this;
                        ri1 ri1Var = ri1.f19330a;
                        String channelNo = organizeMenuMemberFragment.getChannelNo();
                        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
                        ri1Var.b(context, channelNo, 1);
                    }
                    OnSetAdminCallback onSetAdminCallback = OrganizeMenuMemberFragment.this.mCallback;
                    if (onSetAdminCallback != null) {
                        onSetAdminCallback.a("", true);
                    }
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((OrganizeMenuMemberVM) getMViewModel()).J().setValue(getChannelNo());
        ((OrganizeMenuMemberVM) getMViewModel()).K().setValue(getClubAdminUserCode());
        ((OrganizeMenuMemberVM) getMViewModel()).D().setValue("任命社长");
        ((OrganizeMenuMemberVM) getMViewModel()).G().setValue(Integer.valueOf(R.drawable.ic_common_search_dp16));
        ((OrganizeMenuMemberVM) getMViewModel()).F().setValue("搜索频道成员");
        getTvChannelMembers().setVisibility(0);
        WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
        if (worksFragmentPubWorkMenuBinding != null) {
            worksFragmentPubWorkMenuBinding.f14273a.setTextSize(14.0f);
        }
        initAdapter();
        ((OrganizeMenuMemberVM) getMViewModel()).C().setValue(1);
        ((OrganizeMenuMemberVM) getMViewModel()).y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void onSearchActionCall(@NotNull String searchValue) {
        Intrinsics.checkNotNullParameter(searchValue, "searchValue");
        if (TextUtils.isEmpty(searchValue)) {
            return;
        }
        ((OrganizeMenuMemberVM) getMViewModel()).y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void searchContentChanged(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            ((OrganizeMenuMemberVM) getMViewModel()).y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void updateAdapterSuccess() {
        PubWorksMenuPageEntity<?> value = ((OrganizeMenuMemberVM) getMViewModel()).E().getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.huachenjie.works.bean.publish.PubWorksMenuPageEntity<com.huachenjie.channel.bean.OrganizeTeamUserBean>");
        PubWorksMenuPageEntity<?> pubWorksMenuPageEntity = value;
        if (pubWorksMenuPageEntity.getPageNum() == 1) {
            hideLoading();
            if (pubWorksMenuPageEntity.getList().isEmpty()) {
                OrganizeMenuMemberAdapter organizeMenuMemberAdapter = (OrganizeMenuMemberAdapter) ((OrganizeMenuMemberVM) getMViewModel()).B().getValue();
                if (organizeMenuMemberAdapter != null) {
                    organizeMenuMemberAdapter.l();
                    return;
                }
                return;
            }
            OrganizeMenuMemberAdapter organizeMenuMemberAdapter2 = (OrganizeMenuMemberAdapter) ((OrganizeMenuMemberVM) getMViewModel()).B().getValue();
            if (organizeMenuMemberAdapter2 != null) {
                organizeMenuMemberAdapter2.j();
            }
        }
    }
}
