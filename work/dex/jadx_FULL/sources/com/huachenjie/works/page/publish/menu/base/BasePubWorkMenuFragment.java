package com.huachenjie.works.page.publish.menu.base;

import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVParams;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuModel;
import com.igexin.push.g.o;
import com.zj.adlib.qa4;
import com.zj.adlib.qk0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ?*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003:\u0001@B\u0007¢\u0006\u0004\b=\u0010>J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0017J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001f\u0010\u0019\u001a\u00028\u0001\"\b\b\u0001\u0010\u0017*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00028\u0001\"\b\b\u0001\u0010\u0017*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u000eH\u0017J\u0014\u0010\u001f\u001a\u00020\u000e2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0016J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 J\b\u0010#\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0016H\u0017J\u001a\u0010)\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0013H\u0016R\u001d\u00102\u001a\u0004\u0018\u00010-8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentPubWorkMenuBinding;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "Ljava/lang/Class;", "getViewModelClass", "", "initView", RVParams.LONG_SHOW_LOADING, "hideLoading", "showError", "", "content", "searchContentChanged", "Landroid/view/View;", "T", "id", "insertViewToPlaceholder1", "(I)Landroid/view/View;", "insertViewToPlaceholder2", "initDataObserve", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "entityValue", "saveExtraListValue", "", "hasNext", "setListLoadMore", "updateAdapterSuccess", "v", "onDismissDialog", "Landroidx/fragment/app/FragmentManager;", "manager", "tag", "show", "onClearInput", "searchValue", "onSearchActionCall", "Landroid/widget/EditText;", "etSearch$delegate", "Lkotlin/Lazy;", "getEtSearch", "()Landroid/widget/EditText;", "etSearch", "Landroid/os/Handler;", "searchHandler$delegate", "getSearchHandler", "()Landroid/os/Handler;", "searchHandler", "Ljava/lang/Runnable;", "searchCallback$delegate", "getSearchCallback", "()Ljava/lang/Runnable;", "searchCallback", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public class BasePubWorkMenuFragment<VM extends BasePubWorkMenuModel> extends BaseMVVMBottomDialogFragment<WorksFragmentPubWorkMenuBinding, VM> {
    private static final long SEARCH_DELAY_TIME = 500;

    /* JADX INFO: renamed from: etSearch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy etSearch = LazyKt.lazy(new Function0<EditText>(this) { // from class: com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment$etSearch$2
        final /* synthetic */ BasePubWorkMenuFragment<VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final EditText m949invoke() {
            View root;
            WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBindingAccess$getMBinding = BasePubWorkMenuFragment.access$getMBinding(this.this$0);
            if (worksFragmentPubWorkMenuBindingAccess$getMBinding == null || (root = worksFragmentPubWorkMenuBindingAccess$getMBinding.getRoot()) == null) {
                return null;
            }
            return (EditText) root.findViewById(R.id.et_search);
        }
    });

    /* JADX INFO: renamed from: searchHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment$searchHandler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m951invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: searchCallback$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchCallback = LazyKt.lazy(new BasePubWorkMenuFragment$searchCallback$2(this));

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37301a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37301a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37301a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37301a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ WorksFragmentPubWorkMenuBinding access$getMBinding(BasePubWorkMenuFragment basePubWorkMenuFragment) {
        return (WorksFragmentPubWorkMenuBinding) basePubWorkMenuFragment.getMBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BasePubWorkMenuModel access$getMViewModel(BasePubWorkMenuFragment basePubWorkMenuFragment) {
        return (BasePubWorkMenuModel) basePubWorkMenuFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable getSearchCallback() {
        return (Runnable) this.searchCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getSearchHandler() {
        return (Handler) this.searchHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$0(BasePubWorkMenuFragment basePubWorkMenuFragment, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(basePubWorkMenuFragment, "this$0");
        basePubWorkMenuFragment.getSearchHandler().removeCallbacks(basePubWorkMenuFragment.getSearchCallback());
        String value = ((BasePubWorkMenuModel) basePubWorkMenuFragment.getMViewModel()).H().getValue();
        if (!(value == null || StringsKt.isBlank(value))) {
            basePubWorkMenuFragment.getSearchCallback().run();
            String value2 = ((BasePubWorkMenuModel) basePubWorkMenuFragment.getMViewModel()).H().getValue();
            if (value2 == null) {
                value2 = "";
            }
            basePubWorkMenuFragment.onSearchActionCall(value2);
        }
        qa4.b(textView);
        return true;
    }

    @Nullable
    public final EditText getEtSearch() {
        return (EditText) this.etSearch.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_pub_work_menu;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @Nullable
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.s), this)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Class<VM> getViewModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment>");
        return (Class) type;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    public final void hideLoading() {
        getMViewModel().r().setValue(1);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @CallSuper
    public void initDataObserve() {
        super.initDataObserve();
        getMViewModel().E().observe(this, new b(new Function1<PubWorksMenuPageEntity<?>, Unit>(this) { // from class: com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment.initDataObserve.1
            final /* synthetic */ BasePubWorkMenuFragment<VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PubWorksMenuPageEntity<?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PubWorksMenuPageEntity<?> pubWorksMenuPageEntity) {
                BasePubWorkMenuAdapter<?, ?> value;
                RecyclerView recyclerView;
                BasePubWorkMenuFragment<VM> basePubWorkMenuFragment = this.this$0;
                Intrinsics.checkNotNullExpressionValue(pubWorksMenuPageEntity, o.f);
                basePubWorkMenuFragment.saveExtraListValue(pubWorksMenuPageEntity);
                if (BasePubWorkMenuFragment.access$getMViewModel(this.this$0).I(pubWorksMenuPageEntity.getType()) && (value = BasePubWorkMenuFragment.access$getMViewModel(this.this$0).B().getValue()) != null) {
                    if (pubWorksMenuPageEntity.getPageNum() == 1) {
                        List list = pubWorksMenuPageEntity.getList();
                        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Nothing>");
                        value.setList(list);
                        WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBindingAccess$getMBinding = BasePubWorkMenuFragment.access$getMBinding(this.this$0);
                        if (worksFragmentPubWorkMenuBindingAccess$getMBinding != null && (recyclerView = worksFragmentPubWorkMenuBindingAccess$getMBinding.f14275a) != null) {
                            recyclerView.scrollToPosition(0);
                        }
                    } else {
                        List list2 = pubWorksMenuPageEntity.getList();
                        Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Nothing>");
                        value.addData((Collection<? extends Object>) list2);
                    }
                    this.this$0.setListLoadMore(pubWorksMenuPageEntity.getHasNext());
                    this.this$0.updateAdapterSuccess();
                }
            }
        }));
    }

    @CallSuper
    public void initView() {
        getMViewModel().H().observe(this, new b(new Function1<String, Unit>(this) { // from class: com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment.initView.1
            final /* synthetic */ BasePubWorkMenuFragment<VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                this.this$0.getSearchHandler().removeCallbacks(this.this$0.getSearchCallback());
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                if (str.length() == 0) {
                    this.this$0.getSearchCallback().run();
                } else {
                    this.this$0.getSearchHandler().postDelayed(this.this$0.getSearchCallback(), 500L);
                }
            }
        }));
        EditText etSearch = getEtSearch();
        if (etSearch != null) {
            etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.wq0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return BasePubWorkMenuFragment.initView$lambda$0(this.f45660a, textView, i, keyEvent);
                }
            });
        }
        getMViewModel().B().observe(this, new b(new Function1<BasePubWorkMenuAdapter<?, ?>, Unit>(this) { // from class: com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment.initView.3
            final /* synthetic */ BasePubWorkMenuFragment<VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BasePubWorkMenuAdapter<?, ?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BasePubWorkMenuAdapter<?, ?> basePubWorkMenuAdapter) {
                EditText etSearch2 = this.this$0.getEtSearch();
                Intrinsics.checkNotNull(etSearch2);
                basePubWorkMenuAdapter.f(etSearch2);
                BasePubWorkMenuModel basePubWorkMenuModelAccess$getMViewModel = BasePubWorkMenuFragment.access$getMViewModel(this.this$0);
                BasePubWorkMenuFragment<VM> basePubWorkMenuFragment = this.this$0;
                WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBindingAccess$getMBinding = BasePubWorkMenuFragment.access$getMBinding(basePubWorkMenuFragment);
                Intrinsics.checkNotNull(worksFragmentPubWorkMenuBindingAccess$getMBinding);
                StateLayout stateLayout = worksFragmentPubWorkMenuBindingAccess$getMBinding.f14276a;
                Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
                BaseStateRequestModel.p(basePubWorkMenuModelAccess$getMViewModel, basePubWorkMenuFragment, stateLayout, basePubWorkMenuAdapter, false, 8, null);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T extends View> T insertViewToPlaceholder1(int id) {
        T t;
        View root;
        ViewStub viewStub;
        WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
        if (worksFragmentPubWorkMenuBinding == null || (root = worksFragmentPubWorkMenuBinding.getRoot()) == null || (viewStub = (ViewStub) root.findViewById(R.id.vs_placeholder1)) == null) {
            t = null;
        } else {
            viewStub.setLayoutResource(id);
            t = (T) viewStub.inflate();
        }
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment.insertViewToPlaceholder1");
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T extends View> T insertViewToPlaceholder2(int id) {
        T t;
        View root;
        ViewStub viewStub;
        WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
        if (worksFragmentPubWorkMenuBinding == null || (root = worksFragmentPubWorkMenuBinding.getRoot()) == null || (viewStub = (ViewStub) root.findViewById(R.id.vs_placeholder2)) == null) {
            t = null;
        } else {
            viewStub.setLayoutResource(id);
            t = (T) viewStub.inflate();
        }
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment.insertViewToPlaceholder2");
        return t;
    }

    public final void onClearInput(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        getMViewModel().H().setValue("");
    }

    @CallSuper
    public void onDismissDialog(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        dismiss();
    }

    public void onSearchActionCall(@NotNull String searchValue) {
        Intrinsics.checkNotNullParameter(searchValue, "searchValue");
    }

    public void saveExtraListValue(@NotNull PubWorksMenuPageEntity<?> entityValue) {
        Intrinsics.checkNotNullParameter(entityValue, "entityValue");
    }

    public void searchContentChanged(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
    }

    public final void setListLoadMore(boolean hasNext) {
        BasePubWorkMenuAdapter<?, ?> value = getMViewModel().B().getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.chad.library.adapter.base.BaseQuickAdapter<*, *>");
        BasePubWorkMenuAdapter<?, ?> basePubWorkMenuAdapter = value;
        basePubWorkMenuAdapter.getLoadMoreModule().loadMoreComplete();
        if (hasNext) {
            return;
        }
        BaseLoadMoreModule.loadMoreEnd$default(basePubWorkMenuAdapter.getLoadMoreModule(), false, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        FragmentTransaction fragmentTransactionBeginTransaction = manager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "manager.beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.add(this, tag);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final void showError() {
        getMViewModel().r().setValue(3);
    }

    public final void showLoading() {
        getMViewModel().r().setValue(4);
    }

    public void updateAdapterSuccess() {
    }
}
