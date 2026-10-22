package com.huachenjie.home.page.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.databinding.HomeFragmentBuddyCardPageBinding;
import com.huachenjie.home.page.home.HomeBuddyCardPageFragment;
import com.huachenjie.home.widget.WrapContentHeightViewPager;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.buddy.BuddyCardAdapter;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.bean.BuddyCardListBean;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.bean.BuddyUserBean;
import com.huachenjie.works.page.buddy.BuddyApplyDialog;
import com.zj.adlib.su9;
import com.zj.adlib.v41;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/huachenjie/home/page/home/HomeBuddyCardPageFragment;", "Landroidx/fragment/app/Fragment;", "", "initAdapter", "requestParentViewPagerHeightUpdate", "refreshOnVisible", "loadData", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "", "newScopeType", "updateScopeType", "", "isVisibleToUser", "setUserVisibleHint", "onResume", "onDestroyView", "Lcom/huachenjie/home/databinding/HomeFragmentBuddyCardPageBinding;", "_binding", "Lcom/huachenjie/home/databinding/HomeFragmentBuddyCardPageBinding;", HomeBuddyCardPageFragment.ARG_SCOPE_TYPE, "I", "", "buddyTypeCode$delegate", "Lkotlin/Lazy;", "getBuddyTypeCode", "()Ljava/lang/String;", HomeBuddyCardPageFragment.ARG_BUDDY_TYPE_CODE, "Lcom/huachenjie/works/adapter/buddy/BuddyCardAdapter;", "cardAdapter$delegate", "getCardAdapter", "()Lcom/huachenjie/works/adapter/buddy/BuddyCardAdapter;", "cardAdapter", "getBinding", "()Lcom/huachenjie/home/databinding/HomeFragmentBuddyCardPageBinding;", "binding", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeBuddyCardPageFragment extends Fragment {

    @NotNull
    private static final String ARG_BUDDY_TYPE_CODE = "buddyTypeCode";

    @NotNull
    private static final String ARG_SCOPE_TYPE = "scopeType";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private HomeFragmentBuddyCardPageBinding _binding;

    /* JADX INFO: renamed from: buddyTypeCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy buddyTypeCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.home.page.home.HomeBuddyCardPageFragment$buddyTypeCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("buddyTypeCode") : null;
            return string == null ? "" : string;
        }
    });

    /* JADX INFO: renamed from: cardAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy cardAdapter = LazyKt.lazy(new Function0<BuddyCardAdapter>() { // from class: com.huachenjie.home.page.home.HomeBuddyCardPageFragment$cardAdapter$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final BuddyCardAdapter m424invoke() {
            return new BuddyCardAdapter();
        }
    });
    private int scopeType;

    /* JADX INFO: renamed from: com.huachenjie.home.page.home.HomeBuddyCardPageFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/home/HomeBuddyCardPageFragment$a;", "", "", HomeBuddyCardPageFragment.ARG_SCOPE_TYPE, "", HomeBuddyCardPageFragment.ARG_BUDDY_TYPE_CODE, "Lcom/huachenjie/home/page/home/HomeBuddyCardPageFragment;", "a", "ARG_BUDDY_TYPE_CODE", "Ljava/lang/String;", "ARG_SCOPE_TYPE", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HomeBuddyCardPageFragment a(int scopeType, @NotNull String buddyTypeCode) {
            Intrinsics.checkNotNullParameter(buddyTypeCode, HomeBuddyCardPageFragment.ARG_BUDDY_TYPE_CODE);
            HomeBuddyCardPageFragment homeBuddyCardPageFragment = new HomeBuddyCardPageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(HomeBuddyCardPageFragment.ARG_SCOPE_TYPE, scopeType);
            bundle.putString(HomeBuddyCardPageFragment.ARG_BUDDY_TYPE_CODE, buddyTypeCode);
            homeBuddyCardPageFragment.setArguments(bundle);
            return homeBuddyCardPageFragment;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.page.home.HomeBuddyCardPageFragment$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.home.page.home.HomeBuddyCardPageFragment$loadData$1", f = "HomeBuddyCardPageFragment.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HomeBuddyCardPageFragment.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            List<BuddyCardBean> listEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HomeBuddyCardPageFragment homeBuddyCardPageFragment = HomeBuddyCardPageFragment.this;
                    Result.Companion companion = Result.Companion;
                    HomeRequest homeRequest = HomeRequest.f34197a;
                    int i2 = homeBuddyCardPageFragment.scopeType;
                    String buddyTypeCode = homeBuddyCardPageFragment.getBuddyTypeCode();
                    this.label = 1;
                    obj = homeRequest.e(i2, buddyTypeCode, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                BuddyCardListBean buddyCardListBean = (BuddyCardListBean) obj;
                if (buddyCardListBean == null || (listEmptyList = buddyCardListBean.getList()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                obj2 = Result.constructor-impl(listEmptyList);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            List listEmptyList2 = CollectionsKt.emptyList();
            if (Result.isFailure-impl(obj2)) {
                obj2 = listEmptyList2;
            }
            final HomeBuddyCardPageFragment homeBuddyCardPageFragment2 = HomeBuddyCardPageFragment.this;
            List listSubList = (List) obj2;
            if (listSubList.size() > 3) {
                listSubList = listSubList.subList(0, 3);
            }
            if (listSubList.isEmpty()) {
                homeBuddyCardPageFragment2.getCardAdapter().setList(CollectionsKt.emptyList());
                homeBuddyCardPageFragment2.getBinding().f9397a.setVisibility(8);
                homeBuddyCardPageFragment2.getBinding().f9398a.getRoot().setVisibility(0);
            } else {
                homeBuddyCardPageFragment2.getBinding().f9397a.setVisibility(0);
                homeBuddyCardPageFragment2.getBinding().f9398a.getRoot().setVisibility(8);
                homeBuddyCardPageFragment2.getCardAdapter().setList(listSubList);
            }
            homeBuddyCardPageFragment2.getBinding().getRoot().post(new Runnable() { // from class: com.huachenjie.home.page.home.a
                @Override // java.lang.Runnable
                public final void run() {
                    HomeBuddyCardPageFragment.access$requestParentViewPagerHeightUpdate(homeBuddyCardPageFragment2);
                }
            });
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ void access$requestParentViewPagerHeightUpdate(HomeBuddyCardPageFragment homeBuddyCardPageFragment) {
        homeBuddyCardPageFragment.requestParentViewPagerHeightUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeFragmentBuddyCardPageBinding getBinding() {
        HomeFragmentBuddyCardPageBinding homeFragmentBuddyCardPageBinding = this._binding;
        Intrinsics.checkNotNull(homeFragmentBuddyCardPageBinding);
        return homeFragmentBuddyCardPageBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBuddyTypeCode() {
        return (String) this.buddyTypeCode.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BuddyCardAdapter getCardAdapter() {
        return (BuddyCardAdapter) this.cardAdapter.getValue();
    }

    private final void initAdapter() {
        getBinding().f9398a.f9556a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.h14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeBuddyCardPageFragment.initAdapter$lambda$1(view);
            }
        });
        final BuddyCardAdapter cardAdapter = getCardAdapter();
        cardAdapter.A(true);
        cardAdapter.addChildClickViewIds(R.id.tv_buddy_join);
        cardAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.i14
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeBuddyCardPageFragment.initAdapter$lambda$3$lambda$2(cardAdapter, this, baseQuickAdapter, view, i);
            }
        });
        getBinding().f9397a.setAdapter(getCardAdapter());
        getCardAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.huachenjie.home.page.home.HomeBuddyCardPageFragment.initAdapter.3
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                HomeBuddyCardPageFragment.this.requestParentViewPagerHeightUpdate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                HomeBuddyCardPageFragment.this.requestParentViewPagerHeightUpdate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                HomeBuddyCardPageFragment.this.requestParentViewPagerHeightUpdate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1(View view) {
        su9.l(view.getContext(), Environment.c + "/#/buddy/publish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(BuddyCardAdapter buddyCardAdapter, HomeBuddyCardPageFragment homeBuddyCardPageFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(buddyCardAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(homeBuddyCardPageFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        BuddyCardBean item = buddyCardAdapter.getItem(i);
        if (item.isJoinButtonEnabled()) {
            BuddyApplyDialog.Companion companion = BuddyApplyDialog.INSTANCE;
            FragmentManager parentFragmentManager = homeBuddyCardPageFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String buddyCode = item.getBuddyCode();
            BuddyUserBean creatorInfo = item.getCreatorInfo();
            String avatar = creatorInfo != null ? creatorInfo.getAvatar() : null;
            String str = avatar == null ? "" : avatar;
            String str2 = item.formatterTitle();
            List<String> list = item.formatterTagList();
            BuddyTypeScopeTypeBean buddyTypeInfo = item.getBuddyTypeInfo();
            String buddyTypeName = buddyTypeInfo != null ? buddyTypeInfo.getBuddyTypeName() : null;
            companion.a(parentFragmentManager, buddyCode, str, str2, list, (64 & 32) != 0 ? "" : buddyTypeName == null ? "" : buddyTypeName, (64 & 64) != 0 ? null : null);
        }
    }

    private final void loadData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        v41.e(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    private final void refreshOnVisible() {
        if (!getUserVisibleHint() || this._binding == null) {
            return;
        }
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestParentViewPagerHeightUpdate() {
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.zj.adlib.g14
                @Override // java.lang.Runnable
                public final void run() {
                    HomeBuddyCardPageFragment.requestParentViewPagerHeightUpdate$lambda$4(this.f41798a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestParentViewPagerHeightUpdate$lambda$4(HomeBuddyCardPageFragment homeBuddyCardPageFragment) {
        Intrinsics.checkNotNullParameter(homeBuddyCardPageFragment, "this$0");
        View view = homeBuddyCardPageFragment.getView();
        for (ViewParent parent = view != null ? view.getParent() : null; parent != null; parent = parent.getParent()) {
            if (parent instanceof WrapContentHeightViewPager) {
                ((WrapContentHeightViewPager) parent).requestHeightUpdate();
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = HomeFragmentBuddyCardPageBinding.d(inflater, container, false);
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshOnVisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.scopeType == 0) {
            Bundle arguments = getArguments();
            this.scopeType = arguments != null ? arguments.getInt(ARG_SCOPE_TYPE) : 1;
        }
        getBinding().f9397a.setVisibility(8);
        getBinding().f9398a.getRoot().setVisibility(8);
        initAdapter();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isResumed()) {
            refreshOnVisible();
        }
    }

    public final void updateScopeType(int newScopeType) {
        if (this.scopeType == newScopeType) {
            return;
        }
        this.scopeType = newScopeType;
        HomeFragmentBuddyCardPageBinding homeFragmentBuddyCardPageBinding = this._binding;
        if (homeFragmentBuddyCardPageBinding != null) {
            homeFragmentBuddyCardPageBinding.f9397a.setVisibility(8);
            homeFragmentBuddyCardPageBinding.f9398a.getRoot().setVisibility(8);
        }
        refreshOnVisible();
    }
}
