package com.huachenjie.mine.page.home.work;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.broadcast.works.WorkOperateListener;
import com.huachenjie.base.broadcast.works.WorkOperateReceiver;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.works.databinding.WorksFragmentWorkListBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorkListFragment;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.zj.adlib.oz9;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010(¨\u00063"}, d2 = {"Lcom/huachenjie/mine/page/home/work/MyWorksFragment;", "Lcom/huachenjie/works/external/base/BaseWorkListFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentWorkListBinding;", "Lcom/huachenjie/mine/page/home/work/MyWorksVM;", "", "queryLocalDraftSize", "checkVisible", "onVisibleToUser", "onViewCreated", "onDestroyView", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "initAdapter", "initData", "", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "onResume", "", "workType$delegate", "Lkotlin/Lazy;", "getWorkType", "()I", MyWorksFragment.WORK_TYPE, "onFriendPage$delegate", "getOnFriendPage", "()Z", "onFriendPage", "", "appUserCode$delegate", "getAppUserCode", "()Ljava/lang/String;", "appUserCode", "Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "worksOperateReceiver$delegate", "getWorksOperateReceiver", "()Lcom/huachenjie/base/broadcast/works/WorkOperateReceiver;", "worksOperateReceiver", "hasInitModel", "Z", "hasInitData", "hiddenChanged", "Ljava/lang/Boolean;", "visibleToUser", "realVisible", BaseSearchResultFragment.NEED_REFRESH_KEY, "<init>", "()V", "Companion", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyWorksFragment extends BaseWorkListFragment<WorksFragmentWorkListBinding, MyWorksVM> {

    @NotNull
    public static final String APP_USER_CODE = "appUserCode";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ON_FRIEND_PAGE = "onFriendPage";

    @NotNull
    public static final String WORK_TYPE = "workType";
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    /* JADX INFO: renamed from: workType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy workType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mine.page.home.work.MyWorksFragment$workType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m606invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(MyWorksFragment.WORK_TYPE) : 0);
        }
    });

    /* JADX INFO: renamed from: onFriendPage$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy onFriendPage = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mine.page.home.work.MyWorksFragment$onFriendPage$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m605invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("onFriendPage", false) : false);
        }
    });

    /* JADX INFO: renamed from: appUserCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy appUserCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mine.page.home.work.MyWorksFragment$appUserCode$2
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

    /* JADX INFO: renamed from: worksOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy worksOperateReceiver = LazyKt.lazy(new Function0<WorkOperateReceiver>() { // from class: com.huachenjie.mine.page.home.work.MyWorksFragment$worksOperateReceiver$2

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mine/page/home/work/MyWorksFragment$worksOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/works/WorkOperateListener;", "", "a", "c", "", "workNo", "", "visible", "e", "mine_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nMyWorksFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyWorksFragment.kt\ncom/huachenjie/mine/page/home/work/MyWorksFragment$worksOperateReceiver$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,164:1\n350#2,7:165\n*S KotlinDebug\n*F\n+ 1 MyWorksFragment.kt\ncom/huachenjie/mine/page/home/work/MyWorksFragment$worksOperateReceiver$2$1\n*L\n64#1:165,7\n*E\n"})
        public static final class a implements WorkOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MyWorksFragment f35403a;

            public a(MyWorksFragment myWorksFragment) {
                this.f35403a = myWorksFragment;
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void a() {
                this.f35403a.needRefresh = true;
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void c() {
                this.f35403a.needRefresh = true;
            }

            @Override // com.huachenjie.base.broadcast.works.WorkOperateListener
            public void e(@Nullable String workNo, int visible) {
                MyWorksVM myWorksVMAccess$getMViewModel;
                MutableLiveData<WorksAdapter> mutableLiveDataI;
                WorksAdapter value;
                if (this.f35403a.getWorkType() != 1 || (myWorksVMAccess$getMViewModel = MyWorksFragment.access$getMViewModel(this.f35403a)) == null || (mutableLiveDataI = myWorksVMAccess$getMViewModel.i()) == null || (value = mutableLiveDataI.getValue()) == null) {
                    return;
                }
                Iterator it = value.getData().iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (TextUtils.equals(((WorkItemBean) it.next()).getWorksNo(), workNo)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0 && i < value.getData().size()) {
                    ((WorkItemBean) value.getData().get(i)).setVisit(visible);
                    value.notifyItemChanged(i);
                }
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorkOperateReceiver m607invoke() {
            return new WorkOperateReceiver(new a(this.this$0));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mine.page.home.work.MyWorksFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/mine/page/home/work/MyWorksFragment$a;", "", "", "type", "", "onFriendPage", "", "appUserCode", "Lcom/huachenjie/mine/page/home/work/MyWorksFragment;", "a", "APP_USER_CODE", "Ljava/lang/String;", "ON_FRIEND_PAGE", "WORK_TYPE", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyWorksFragment a(int type, boolean onFriendPage, @Nullable String appUserCode) {
            MyWorksFragment myWorksFragment = new MyWorksFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MyWorksFragment.WORK_TYPE, type);
            bundle.putBoolean("onFriendPage", onFriendPage);
            bundle.putString("appUserCode", appUserCode);
            myWorksFragment.setArguments(bundle);
            return myWorksFragment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ MyWorksVM access$getMViewModel(MyWorksFragment myWorksFragment) {
        return (MyWorksVM) myWorksFragment.getMViewModel();
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

    private final String getAppUserCode() {
        return (String) this.appUserCode.getValue();
    }

    private final boolean getOnFriendPage() {
        return ((Boolean) this.onFriendPage.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWorkType() {
        return ((Number) this.workType.getValue()).intValue();
    }

    private final WorkOperateReceiver getWorksOperateReceiver() {
        return (WorkOperateReceiver) this.worksOperateReceiver.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onVisibleToUser() {
        boolean z = this.hasInitData;
        if (!z && this.hasInitModel) {
            this.hasInitData = true;
            ((MyWorksVM) getMViewModel()).p();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            ((MyWorksVM) getMViewModel()).p();
        } else if (z) {
            queryLocalDraftSize();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void queryLocalDraftSize() {
        if (Intrinsics.areEqual(((MyWorksVM) getMViewModel()).y().getValue(), Boolean.TRUE)) {
            ((MyWorksVM) getMViewModel()).A();
        }
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    @NotNull
    public WorksAdapter initAdapter() {
        return new WorksAdapter(false, getWorkType() == 1, false, 5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.external.base.BaseWorkListFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        ((MyWorksVM) getMViewModel()).z().setValue(Integer.valueOf(getWorkType()));
        ((MyWorksVM) getMViewModel()).x().setValue(Boolean.valueOf(getOnFriendPage()));
        ((MyWorksVM) getMViewModel()).w().setValue(getAppUserCode());
        ((MyWorksVM) getMViewModel()).y().setValue(Boolean.valueOf(getWorkType() == 1 && !getOnFriendPage()));
        this.hasInitModel = true;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getWorkType() == 1 && !getOnFriendPage()) {
            oz9 oz9Var = oz9.f43864a;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            oz9Var.h(contextRequireContext, getWorksOperateReceiver());
        }
        super.onDestroyView();
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

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        if (getWorkType() != 1 || getOnFriendPage()) {
            return;
        }
        oz9 oz9Var = oz9.f43864a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        oz9Var.a(contextRequireContext, getWorksOperateReceiver());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.visibleToUser = Boolean.valueOf(isVisibleToUser);
        checkVisible();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
