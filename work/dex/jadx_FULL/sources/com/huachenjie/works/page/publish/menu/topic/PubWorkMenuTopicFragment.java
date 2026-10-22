package com.huachenjie.works.page.publish.menu.topic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.google.gson.Gson;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.adapter.publish.PubWorkMenuTopicAdapter;
import com.huachenjie.works.adapter.publish.PubWorkTopicHistoryAdapter;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.databinding.WorksFragmentPubWorkMenuBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment;
import com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.r90;
import com.zj.adlib.y57;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b2\u00103J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0014\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R2\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010%\u001a\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/topic/PubWorkMenuTopicFragment;", "Lcom/huachenjie/works/page/publish/menu/base/BasePubWorkMenuFragment;", "Lcom/huachenjie/works/page/publish/menu/topic/PubWorkMenuTopicModel;", "", "initAdapter", "restoreHotList", "Lcom/huachenjie/works/bean/publish/PubWorkTopicBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "onSelectCallback", "checkHistory", "clearHistory", "saveHistory", "initView", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "entityValue", "saveExtraListValue", "updateAdapterSuccess", "", "content", "searchContentChanged", "initDataObserve", "Landroid/view/View;", "v", "onDismissDialog", "Lkotlin/Function1;", "selectCallback", "Lkotlin/jvm/functions/Function1;", "getSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "selectIdList$delegate", "Lkotlin/Lazy;", "getSelectIdList", "()Ljava/util/ArrayList;", "selectIdList", "viewHistory$delegate", "getViewHistory", "()Landroid/view/View;", "viewHistory", "Landroid/widget/TextView;", "tvSubHot$delegate", "getTvSubHot", "()Landroid/widget/TextView;", "tvSubHot", "", "historyList", "Ljava/util/List;", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPubWorkMenuTopicFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PubWorkMenuTopicFragment.kt\ncom/huachenjie/works/page/publish/menu/topic/PubWorkMenuTopicFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,232:1\n1#2:233\n*E\n"})
public final class PubWorkMenuTopicFragment extends BasePubWorkMenuFragment<PubWorkMenuTopicModel> {

    @NotNull
    public static final String SELECTED_TOPIC_KEY = "selected_topic_key";

    @Nullable
    private Function1<? super PubWorkTopicBean, Unit> selectCallback;

    /* JADX INFO: renamed from: selectIdList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectIdList = LazyKt.lazy(new Function0<ArrayList<String>>() { // from class: com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment$selectIdList$2
        {
            super(0);
        }

        @Nullable
        public final ArrayList<String> invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getStringArrayList(PubWorkMenuTopicFragment.SELECTED_TOPIC_KEY);
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: viewHistory$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewHistory = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment$viewHistory$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final View m960invoke() {
            return this.this$0.insertViewToPlaceholder1(R.layout.works_view_pub_work_topic_history);
        }
    });

    /* JADX INFO: renamed from: tvSubHot$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvSubHot = LazyKt.lazy(new Function0<TextView>() { // from class: com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment$tvSubHot$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextView m959invoke() {
            return (TextView) this.this$0.insertViewToPlaceholder2(R.layout.works_view_pub_work_menu_topic);
        }
    });

    @NotNull
    private final List<PubWorkTopicBean> historyList = new ArrayList();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37309a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37309a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37309a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37309a.invoke(obj);
        }
    }

    private final void checkHistory() {
        PubWorkTopicBean[] pubWorkTopicBeanArr = (PubWorkTopicBean[]) new Gson().fromJson(r90.u(), PubWorkTopicBean[].class);
        this.historyList.clear();
        if (pubWorkTopicBeanArr != null) {
            if (!(pubWorkTopicBeanArr.length == 0)) {
                this.historyList.addAll(ArraysKt.toList(pubWorkTopicBeanArr));
            }
        }
        if (this.historyList.isEmpty()) {
            getViewHistory().setVisibility(8);
            return;
        }
        getViewHistory().setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) getViewHistory().findViewById(R.id.history_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getViewHistory().getContext(), 0, false));
        final PubWorkTopicHistoryAdapter pubWorkTopicHistoryAdapter = new PubWorkTopicHistoryAdapter();
        y57.d(pubWorkTopicHistoryAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.b37
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PubWorkMenuTopicFragment.checkHistory$lambda$8$lambda$7(this.f15430a, pubWorkTopicHistoryAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        recyclerView.setAdapter(pubWorkTopicHistoryAdapter);
        pubWorkTopicHistoryAdapter.setList(this.historyList);
        View viewFindViewById = getViewHistory().findViewById(R.id.iv_history_clear);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.c37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PubWorkMenuTopicFragment.checkHistory$lambda$9(this.f40893a, view);
                }
            });
        }
        View viewFindViewById2 = getViewHistory().findViewById(R.id.tv_history_clear);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.d37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PubWorkMenuTopicFragment.checkHistory$lambda$10(this.f41100a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkHistory$lambda$10(PubWorkMenuTopicFragment pubWorkMenuTopicFragment, View view) {
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicFragment, "this$0");
        pubWorkMenuTopicFragment.clearHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkHistory$lambda$8$lambda$7(PubWorkMenuTopicFragment pubWorkMenuTopicFragment, PubWorkTopicHistoryAdapter pubWorkTopicHistoryAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicFragment, "this$0");
        Intrinsics.checkNotNullParameter(pubWorkTopicHistoryAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        pubWorkMenuTopicFragment.onSelectCallback(pubWorkTopicHistoryAdapter.getData().get(i));
        pubWorkMenuTopicFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkHistory$lambda$9(PubWorkMenuTopicFragment pubWorkMenuTopicFragment, View view) {
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicFragment, "this$0");
        pubWorkMenuTopicFragment.clearHistory();
    }

    private final void clearHistory() {
        getViewHistory().setVisibility(8);
        this.historyList.clear();
        r90.Y("");
    }

    private final ArrayList<String> getSelectIdList() {
        return (ArrayList) this.selectIdList.getValue();
    }

    private final TextView getTvSubHot() {
        return (TextView) this.tvSubHot.getValue();
    }

    private final View getViewHistory() {
        return (View) this.viewHistory.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<BasePubWorkMenuAdapter<?, ?>> mutableLiveDataB = ((PubWorkMenuTopicModel) getMViewModel()).B();
        final PubWorkMenuTopicAdapter pubWorkMenuTopicAdapter = new PubWorkMenuTopicAdapter();
        y57.d(pubWorkMenuTopicAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.z27
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PubWorkMenuTopicFragment.initAdapter$lambda$2$lambda$0(pubWorkMenuTopicAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        pubWorkMenuTopicAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.a37
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PubWorkMenuTopicFragment.initAdapter$lambda$2$lambda$1(this.f40444a);
            }
        });
        mutableLiveDataB.setValue(pubWorkMenuTopicAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0032  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$2$lambda$0(PubWorkMenuTopicAdapter pubWorkMenuTopicAdapter, PubWorkMenuTopicFragment pubWorkMenuTopicFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        PubWorkTopicBean pubWorkTopicBean = pubWorkMenuTopicAdapter.getData().get(i);
        ArrayList<String> selectIdList = pubWorkMenuTopicFragment.getSelectIdList();
        if (selectIdList != null) {
            z = selectIdList.contains(pubWorkTopicBean.getSubjectNo());
        }
        if (z) {
            fv5.a(R.string.works_publish_work_topic_selected);
            return;
        }
        if (!pubWorkTopicBean.isNewTopic()) {
            pubWorkMenuTopicFragment.onSelectCallback(pubWorkMenuTopicAdapter.getData().get(i));
            pubWorkMenuTopicFragment.dismiss();
        } else if (StringsKt.contains$default(pubWorkTopicBean.getTitle(), "#", false, 2, (Object) null) || StringsKt.contains$default(pubWorkTopicBean.getTitle(), " ", false, 2, (Object) null) || StringsKt.contains$default(pubWorkTopicBean.getTitle(), "\n", false, 2, (Object) null)) {
            fv5.a(R.string.works_publish_work_menu_topic_illegal);
        } else {
            ((PubWorkMenuTopicModel) pubWorkMenuTopicFragment.getMViewModel()).K(pubWorkTopicBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$2$lambda$1(PubWorkMenuTopicFragment pubWorkMenuTopicFragment) {
        Intrinsics.checkNotNullParameter(pubWorkMenuTopicFragment, "this$0");
        ((PubWorkMenuTopicModel) pubWorkMenuTopicFragment.getMViewModel()).w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectCallback(PubWorkTopicBean bean) {
        saveHistory(bean);
        Function1<? super PubWorkTopicBean, Unit> function1 = this.selectCallback;
        if (function1 != null) {
            function1.invoke(bean);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void restoreHotList() {
        RecyclerView recyclerView;
        ((PubWorkMenuTopicModel) getMViewModel()).C().setValue(1);
        BasePubWorkMenuAdapter<?, ?> value = ((PubWorkMenuTopicModel) getMViewModel()).B().getValue();
        if (value != null) {
            PubWorksMenuPageEntity<PubWorkTopicBean> value2 = ((PubWorkMenuTopicModel) getMViewModel()).M().getValue();
            if (value2 == null) {
                ((PubWorkMenuTopicModel) getMViewModel()).y();
                return;
            }
            ((PubWorkMenuTopicAdapter) value).setList(value2.getList());
            WorksFragmentPubWorkMenuBinding worksFragmentPubWorkMenuBinding = (WorksFragmentPubWorkMenuBinding) getMBinding();
            if (worksFragmentPubWorkMenuBinding != null && (recyclerView = worksFragmentPubWorkMenuBinding.f14275a) != null) {
                recyclerView.scrollToPosition(0);
            }
            setListLoadMore(value2.getHasNext());
        }
    }

    private final void saveHistory(PubWorkTopicBean bean) {
        Object next;
        if (bean != null) {
            Iterator<T> it = this.historyList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!TextUtils.equals(((PubWorkTopicBean) next).getSubjectNo(), bean.getSubjectNo()));
            PubWorkTopicBean pubWorkTopicBean = (PubWorkTopicBean) next;
            if (pubWorkTopicBean != null) {
                this.historyList.remove(pubWorkTopicBean);
            }
            this.historyList.add(0, bean);
            while (this.historyList.size() > 6) {
                CollectionsKt.removeLast(this.historyList);
            }
            r90.Y(new Gson().toJson(this.historyList));
        }
    }

    @Nullable
    public final Function1<PubWorkTopicBean, Unit> getSelectCallback() {
        return this.selectCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        ((PubWorkMenuTopicModel) getMViewModel()).L().observe(this, new b(new Function1<PubWorkTopicBean, Unit>() { // from class: com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicFragment.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PubWorkTopicBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PubWorkTopicBean pubWorkTopicBean) {
                PubWorkMenuTopicFragment.this.onSelectCallback(pubWorkTopicBean);
                PubWorkMenuTopicFragment.this.dismiss();
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment, com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ((PubWorkMenuTopicModel) getMViewModel()).D().setValue(getString(R.string.works_publish_work_menu_topic));
        ((PubWorkMenuTopicModel) getMViewModel()).G().setValue(Integer.valueOf(R.drawable.common_ic_publish_topic));
        ((PubWorkMenuTopicModel) getMViewModel()).F().setValue(getString(R.string.works_publish_work_menu_topic_hint));
        getTvSubHot().setVisibility(0);
        checkHistory();
        initAdapter();
        showLoading();
        ((PubWorkMenuTopicModel) getMViewModel()).C().setValue(1);
        ((PubWorkMenuTopicModel) getMViewModel()).y();
    }

    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void onDismissDialog(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        super.onDismissDialog(v);
        onSelectCallback(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void saveExtraListValue(@NotNull PubWorksMenuPageEntity<?> entityValue) {
        Intrinsics.checkNotNullParameter(entityValue, "entityValue");
        if (entityValue.getType() == 1) {
            if (entityValue.getPageNum() == 1) {
                ((PubWorkMenuTopicModel) getMViewModel()).M().setValue(entityValue);
                hideLoading();
                return;
            }
            PubWorksMenuPageEntity<PubWorkTopicBean> value = ((PubWorkMenuTopicModel) getMViewModel()).M().getValue();
            if (value != null) {
                List list = value.getList();
                List list2 = entityValue.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "pageEntity.list");
                list.addAll(list2);
                value.setPageNum(entityValue.getPageNum());
                value.setHasNext(entityValue.getHasNext());
                value.setRefreshTime(entityValue.getRefreshTime());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void searchContentChanged(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!TextUtils.isEmpty(content)) {
            ((PubWorkMenuTopicModel) getMViewModel()).C().setValue(2);
            ((PubWorkMenuTopicModel) getMViewModel()).y();
        } else {
            getTvSubHot().setVisibility(0);
            if (!this.historyList.isEmpty()) {
                getViewHistory().setVisibility(0);
            }
            restoreHotList();
        }
    }

    public final void setSelectCallback(@Nullable Function1<? super PubWorkTopicBean, Unit> function1) {
        this.selectCallback = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.works.page.publish.menu.base.BasePubWorkMenuFragment
    public void updateAdapterSuccess() {
        if (((PubWorkMenuTopicModel) getMViewModel()).I(2)) {
            getTvSubHot().setVisibility(8);
            getViewHistory().setVisibility(8);
        }
    }
}
