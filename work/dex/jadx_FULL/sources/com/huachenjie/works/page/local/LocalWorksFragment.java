package com.huachenjie.works.page.local;

import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import androidx.p002lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentWorkListBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorkListFragment;
import com.huachenjie.works.external.bean.LocaleWorkItemBean;
import com.huachenjie.works.page.local.LocalWorksFragment;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.zj.adlib.ft1;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/local/LocalWorksFragment;", "Lcom/huachenjie/works/external/base/BaseWorkListFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentWorkListBinding;", "Lcom/huachenjie/works/page/local/LocalWorksVM;", "()V", "enableRefresh", "", "initAdapter", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "initData", "", "initLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "initView", "onResume", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLocalWorksFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalWorksFragment.kt\ncom/huachenjie/works/page/local/LocalWorksFragment\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,93:1\n1313#2,2:94\n*S KotlinDebug\n*F\n+ 1 LocalWorksFragment.kt\ncom/huachenjie/works/page/local/LocalWorksFragment\n*L\n33#1:94,2\n*E\n"})
public final class LocalWorksFragment extends BaseWorkListFragment<WorksFragmentWorkListBinding, LocalWorksVM> {

    /* JADX INFO: renamed from: com.huachenjie.works.page.local.LocalWorksFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.local.LocalWorksFragment$onResume$1", f = "LocalWorksFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.huachenjie.works.page.local.LocalWorksFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        @DebugMetadata(c = "com.huachenjie.works.page.local.LocalWorksFragment$onResume$1$1", f = "LocalWorksFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C08311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<LocaleWorkItemBean> $list;
            int label;
            final /* synthetic */ LocalWorksFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C08311(LocalWorksFragment localWorksFragment, List<LocaleWorkItemBean> list, Continuation<? super C08311> continuation) {
                super(2, continuation);
                this.this$0 = localWorksFragment;
                this.$list = list;
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C08311(this.this$0, this.$list, continuation);
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                WorksAdapter value = LocalWorksFragment.access$getMViewModel(this.this$0).i().getValue();
                if (value != null) {
                    List<LocaleWorkItemBean> list = this.$list;
                    value.setList(list);
                    if (list.isEmpty()) {
                        value.r();
                    }
                }
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = LocalWorksFragment.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            v41.e((CoroutineScope) this.L$0, jo2.e(), (CoroutineStart) null, new C08311(LocalWorksFragment.this, LocalWorksFragment.access$getMViewModel(LocalWorksFragment.this).w(), null), 2, (Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ LocalWorksVM access$getMViewModel(LocalWorksFragment localWorksFragment) {
        return (LocalWorksVM) localWorksFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$5$lambda$2(WorksAdapter worksAdapter, LocalWorksFragment localWorksFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(worksAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(localWorksFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        PublishWorkActivity.INSTANCE.a(worksAdapter.getContext(), ((LocalWorksVM) localWorksFragment.getMViewModel()).x().get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$4(final LocalWorksFragment localWorksFragment, final WorksAdapter worksAdapter, final BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(localWorksFragment, "this$0");
        Intrinsics.checkNotNullParameter(worksAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.ivWorkDelete) {
            ft1.p(view.getContext(), localWorksFragment.getString(R.string.works_local_draft_del_hint), new View.OnClickListener() { // from class: com.zj.adlib.sz4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LocalWorksFragment.initAdapter$lambda$5$lambda$4$lambda$3(this.f19687a, i, baseQuickAdapter, worksAdapter, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$5$lambda$4$lambda$3(LocalWorksFragment localWorksFragment, int i, BaseQuickAdapter baseQuickAdapter, WorksAdapter worksAdapter, View view) {
        Intrinsics.checkNotNullParameter(localWorksFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(worksAdapter, "$this_apply");
        ((LocalWorksVM) localWorksFragment.getMViewModel()).v(i);
        baseQuickAdapter.removeAt(i);
        if (baseQuickAdapter.getData().isEmpty()) {
            worksAdapter.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$1(LocalWorksFragment localWorksFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        Sequence<View> children;
        Intrinsics.checkNotNullParameter(localWorksFragment, "this$0");
        WorksFragmentWorkListBinding worksFragmentWorkListBinding = (WorksFragmentWorkListBinding) localWorksFragment.getMBinding();
        if (worksFragmentWorkListBinding == null || (swipeRefreshLayout = worksFragmentWorkListBinding.f14357a) == null || (children = ViewGroupKt.getChildren(swipeRefreshLayout)) == null) {
            return false;
        }
        for (View view : children) {
            if (view instanceof ImageView) {
                ((ImageView) view).setVisibility(8);
            }
        }
        return false;
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    public boolean enableRefresh() {
        return false;
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    @NotNull
    public WorksAdapter initAdapter() {
        final WorksAdapter worksAdapter = new WorksAdapter(false, false, false, 7, null);
        worksAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.tz4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LocalWorksFragment.initAdapter$lambda$5$lambda$2(worksAdapter, this, baseQuickAdapter, view, i);
            }
        });
        worksAdapter.addChildClickViewIds(R.id.ivWorkDelete);
        worksAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.uz4
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LocalWorksFragment.initAdapter$lambda$5$lambda$4(this.f20150a, worksAdapter, baseQuickAdapter, view, i);
            }
        });
        return worksAdapter;
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
    }

    @Override // com.huachenjie.works.external.base.BaseWorkListFragment
    @NotNull
    public StaggeredGridLayoutManager initLayoutManager() {
        return new StaggeredGridLayoutManager(2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.external.base.BaseWorkListFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((LocalWorksVM) getMViewModel()).l().setValue(Boolean.FALSE);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.zj.adlib.vz4
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return LocalWorksFragment.initView$lambda$1(this.f45493a);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        v41.e(LifecycleOwnerKt.getLifecycleScope(this), jo2.c(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
    }
}
