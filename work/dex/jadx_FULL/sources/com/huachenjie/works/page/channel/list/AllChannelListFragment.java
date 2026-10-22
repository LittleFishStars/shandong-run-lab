package com.huachenjie.works.page.channel.list;

import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentListChannelBinding;
import com.huachenjie.works.page.channel.list.AllChannelListFragment;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0007¢\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006("}, d2 = {"Lcom/huachenjie/works/page/channel/list/AllChannelListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentListChannelBinding;", "Lcom/huachenjie/works/page/channel/list/AllChannelListVM;", "", "checkVisible", "onVisibleToUser", "", "", "", "getVariables", "getLayoutResID", "initData", "", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "onResume", "", "channelCode$delegate", "Lkotlin/Lazy;", "getChannelCode", "()Ljava/lang/String;", "channelCode", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "hasInitModel", "Z", "hasInitData", "hiddenChanged", "Ljava/lang/Boolean;", "visibleToUser", "realVisible", BaseSearchResultFragment.NEED_REFRESH_KEY, "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AllChannelListFragment extends BaseMVVMFragment<WorksFragmentListChannelBinding, AllChannelListVM> {

    @NotNull
    public static final String CHANNEL_CODE = "channelCode";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    /* JADX INFO: renamed from: channelCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.channel.list.AllChannelListFragment$channelCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channelCode")) == null) ? "" : string;
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.m40
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            AllChannelListFragment.onRefreshListener$lambda$0(this.f43214a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.works.page.channel.list.AllChannelListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/channel/list/AllChannelListFragment$a;", "", "", "code", "Lcom/huachenjie/works/page/channel/list/AllChannelListFragment;", "a", "CHANNEL_CODE", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AllChannelListFragment a(@NotNull String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            AllChannelListFragment allChannelListFragment = new AllChannelListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelCode", code);
            allChannelListFragment.setArguments(bundle);
            return allChannelListFragment;
        }
    }

    private final void checkVisible() {
        Boolean bool = this.hiddenChanged;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(this.visibleToUser, bool2)) {
            this.realVisible = false;
        } else {
            onVisibleToUser();
            this.realVisible = true;
        }
    }

    private final String getChannelCode() {
        return (String) this.channelCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(AllChannelListFragment allChannelListFragment) {
        Intrinsics.checkNotNullParameter(allChannelListFragment, "this$0");
        allChannelListFragment.getMViewModel().t();
    }

    private final void onVisibleToUser() {
        if (!this.hasInitData && this.hasInitModel) {
            this.hasInitData = true;
            getMViewModel().t();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            getMViewModel().t();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_list_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().o().setValue(getChannelCode());
        this.hasInitModel = true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        this.hiddenChanged = Boolean.valueOf(hidden);
        checkVisible();
        super.onHiddenChanged(hidden);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.visibleToUser = Boolean.valueOf(isVisibleToUser);
        checkVisible();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
