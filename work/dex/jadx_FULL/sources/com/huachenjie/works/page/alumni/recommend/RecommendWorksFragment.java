package com.huachenjie.works.page.alumni.recommend;

import android.os.Bundle;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.works.databinding.WorksFragmentWorkListBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorkListFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017¨\u0006\""}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendWorksFragment;", "Lcom/huachenjie/works/external/base/BaseWorkListFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentWorkListBinding;", "Lcom/huachenjie/works/page/alumni/recommend/RecommendWorksVM;", "", "checkVisible", "onVisibleToUser", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "initAdapter", "initData", "", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "onResume", "", "channelCode$delegate", "Lkotlin/Lazy;", "getChannelCode", "()Ljava/lang/String;", "channelCode", "hasInitModel", "Z", "hasInitData", "hiddenChanged", "Ljava/lang/Boolean;", "visibleToUser", "realVisible", BaseSearchResultFragment.NEED_REFRESH_KEY, "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class RecommendWorksFragment extends BaseWorkListFragment<WorksFragmentWorkListBinding, RecommendWorksVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String WORK_CHANNEL_CODE = "channelCode";

    /* JADX INFO: renamed from: channelCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.alumni.recommend.RecommendWorksFragment$channelCode$2
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
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.recommend.RecommendWorksFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendWorksFragment$a;", "", "", "channelCode", "Lcom/huachenjie/works/page/alumni/recommend/RecommendWorksFragment;", "a", "WORK_CHANNEL_CODE", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommendWorksFragment a(@NotNull String channelCode) {
            Intrinsics.checkNotNullParameter(channelCode, "channelCode");
            RecommendWorksFragment recommendWorksFragment = new RecommendWorksFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelCode", channelCode);
            recommendWorksFragment.setArguments(bundle);
            return recommendWorksFragment;
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

    /* JADX WARN: Multi-variable type inference failed */
    private final void onVisibleToUser() {
        if (!this.hasInitData && this.hasInitModel) {
            this.hasInitData = true;
            ((RecommendWorksVM) getMViewModel()).p();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            ((RecommendWorksVM) getMViewModel()).p();
        }
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    @NotNull
    public WorksAdapter initAdapter() {
        return new WorksAdapter(true, false, true, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.external.base.BaseWorkListFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ((RecommendWorksVM) getMViewModel()).v().setValue(getChannelCode());
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
