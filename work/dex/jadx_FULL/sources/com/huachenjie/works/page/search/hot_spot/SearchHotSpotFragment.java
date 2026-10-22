package com.huachenjie.works.page.search.hot_spot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.bean.UserActivityInfo;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.search.SearchHotSpotAdapter;
import com.huachenjie.works.bean.search.SearchHotSpotBean;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import com.huachenjie.works.databinding.WorksFragmentSearchHotSpotBinding;
import com.huachenjie.works.databinding.WorksHeadSearchHotSpotBinding;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment.a;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.qk0;
import com.zj.adlib.su9;
import com.zj.adlib.y57;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002&'B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0014\u001a\u00020\u0004H\u0016R.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR#\u0010\"\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentSearchHotSpotBinding;", "Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotModel;", "", "initAdapter", "", yj7.b.SUBJECT_NO, "goTopicHome", "queryUserInfo", "showHistory", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "content", "saveSearchHistory", "initDataObservable", "Lkotlin/Function1;", "clickHistoryCallback", "Lkotlin/jvm/functions/Function1;", "getClickHistoryCallback", "()Lkotlin/jvm/functions/Function1;", "setClickHistoryCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/huachenjie/works/databinding/WorksHeadSearchHotSpotBinding;", "kotlin.jvm.PlatformType", "headViewBinding$delegate", "Lkotlin/Lazy;", "getHeadViewBinding", "()Lcom/huachenjie/works/databinding/WorksHeadSearchHotSpotBinding;", "headViewBinding", "<init>", "()V", "Companion", "a", "b", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSearchHotSpotFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchHotSpotFragment.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,228:1\n1855#2,2:229\n1855#2,2:231\n*S KotlinDebug\n*F\n+ 1 SearchHotSpotFragment.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment\n*L\n104#1:229,2\n111#1:231,2\n*E\n"})
public final class SearchHotSpotFragment extends BaseMVVMFragment<WorksFragmentSearchHotSpotBinding, SearchHotSpotModel> {
    private static final int MAX_HISTORTY_SIZE = 10;

    @NotNull
    private Function1<? super String, Unit> clickHistoryCallback = new Function1<String, Unit>() { // from class: com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment$clickHistoryCallback$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, o.f);
        }
    };

    /* JADX INFO: renamed from: headViewBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy headViewBinding = LazyKt.lazy(new Function0<WorksHeadSearchHotSpotBinding>() { // from class: com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment$headViewBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final WorksHeadSearchHotSpotBinding m969invoke() {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.this$0.getContext());
            int i = R.layout.works_head_search_hot_spot;
            View view = this.this$0.getView();
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(layoutInflaterFrom, i, view instanceof ViewGroup ? (ViewGroup) view : null, false);
            SearchHotSpotFragment searchHotSpotFragment = this.this$0;
            WorksHeadSearchHotSpotBinding worksHeadSearchHotSpotBinding = (WorksHeadSearchHotSpotBinding) viewDataBindingInflate;
            worksHeadSearchHotSpotBinding.setVariable(qk0.p0, SearchHotSpotFragment.access$getMViewModel(searchHotSpotFragment));
            worksHeadSearchHotSpotBinding.setVariable(qk0.k, searchHotSpotFragment.new a());
            return worksHeadSearchHotSpotBinding;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment$a;", "", "Landroid/view/View;", "v", "", "b", "a", "d", "c", "e", "f", "<init>", "(Lcom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nSearchHotSpotFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchHotSpotFragment.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment$ClickProxy\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,228:1\n1313#2,2:229\n*S KotlinDebug\n*F\n+ 1 SearchHotSpotFragment.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotFragment$ClickProxy\n*L\n182#1:229,2\n*E\n"})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).D().setValue(Boolean.FALSE);
            SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).H().clear();
            SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).N();
            SearchHotSpotFragment.this.showHistory();
            SearchHotSpotFragment.this.getHeadViewBinding().setVariable(qk0.p0, SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this));
        }

        public final void b(@NotNull View v) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(v, "v");
            SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).D().setValue(Boolean.valueOf(!Intrinsics.areEqual(SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).D().getValue(), Boolean.TRUE)));
            ConstraintLayout constraintLayout = SearchHotSpotFragment.this.getHeadViewBinding().f14387a;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "headViewBinding.clHistory");
            Sequence<View> children = ViewGroupKt.getChildren(constraintLayout);
            SearchHotSpotFragment searchHotSpotFragment = SearchHotSpotFragment.this;
            for (View view : children) {
                if ((view instanceof ViewGroup) && (imageView = (ImageView) view.findViewById(R.id.iv_delete)) != null) {
                    imageView.setVisibility(Intrinsics.areEqual(SearchHotSpotFragment.access$getMViewModel(searchHotSpotFragment).D().getValue(), Boolean.TRUE) ? 0 : 8);
                }
            }
            SearchHotSpotFragment.this.getHeadViewBinding().setVariable(qk0.p0, SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this));
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SearchHotSpotItemBean value = SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).E().getValue();
            if (value != null) {
                SearchHotSpotFragment.this.goTopicHome(value.getSubjectNo());
            }
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            UserActivityInfo value = SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).B().getValue();
            if (value != null) {
                su9.v(SearchHotSpotFragment.this.getContext(), value.getActivityUrl());
            }
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SearchHotSpotItemBean value = SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).J().getValue();
            if (value != null) {
                SearchHotSpotFragment.this.goTopicHome(value.getSubjectNo());
            }
        }

        public final void f(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SearchHotSpotItemBean value = SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).K().getValue();
            if (value != null) {
                SearchHotSpotFragment.this.goTopicHome(value.getSubjectNo());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37317a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37317a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37317a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37317a.invoke(obj);
        }
    }

    public static final /* synthetic */ SearchHotSpotModel access$getMViewModel(SearchHotSpotFragment searchHotSpotFragment) {
        return searchHotSpotFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WorksHeadSearchHotSpotBinding getHeadViewBinding() {
        return (WorksHeadSearchHotSpotBinding) this.headViewBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goTopicHome(String subjectNo) {
        ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, subjectNo).navigation();
    }

    private final void initAdapter() {
        MutableLiveData<SearchHotSpotAdapter> mutableLiveDataC = getMViewModel().C();
        final SearchHotSpotAdapter searchHotSpotAdapter = new SearchHotSpotAdapter();
        SearchHotSpotModel mViewModel = getMViewModel();
        WorksFragmentSearchHotSpotBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f36946a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateView");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, searchHotSpotAdapter, false, 8, null);
        View root = getHeadViewBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headViewBinding.root");
        BaseQuickAdapter.setHeaderView$default(searchHotSpotAdapter, root, 0, 0, 6, null);
        y57.d(searchHotSpotAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ay7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SearchHotSpotFragment.initAdapter$lambda$1$lambda$0(searchHotSpotAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataC.setValue(searchHotSpotAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(SearchHotSpotAdapter searchHotSpotAdapter, SearchHotSpotFragment searchHotSpotFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(searchHotSpotAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(searchHotSpotFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        searchHotSpotFragment.goTopicHome(searchHotSpotAdapter.getData().get(i).getSubjectNo());
    }

    private final void queryUserInfo() {
        List<UserActivityInfo> activityInfoList = ai9.e().getActivityInfoList();
        UserActivityInfo userActivityInfo = null;
        Object obj = null;
        if (activityInfoList != null) {
            for (Object obj2 : activityInfoList) {
                if (((UserActivityInfo) obj2).getActivityPlace() == 7) {
                    obj = obj2;
                    break;
                }
            }
            userActivityInfo = (UserActivityInfo) obj;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (userActivityInfo == null || jCurrentTimeMillis < userActivityInfo.getActivityStartTime() || jCurrentTimeMillis > userActivityInfo.getActivityEndTime()) {
            return;
        }
        getMViewModel().B().setValue(userActivityInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHistory() {
        Iterator<T> it = getMViewModel().G().iterator();
        while (it.hasNext()) {
            View viewFindViewById = getHeadViewBinding().f14387a.findViewById(((Number) it.next()).intValue());
            getHeadViewBinding().f14387a.removeView(viewFindViewById);
            getHeadViewBinding().f14386a.removeView(viewFindViewById);
        }
        getMViewModel().G().clear();
        for (final String str : getMViewModel().H()) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.works_layout_search_history, (ViewGroup) getHeadViewBinding().f14387a, false);
            viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-2, SizeUtils.b(24.0f)));
            ((TextView) viewInflate.findViewById(R.id.tv_history)).setText(str);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_delete);
            if (imageView != null) {
                imageView.setVisibility(Intrinsics.areEqual(getMViewModel().D().getValue(), Boolean.TRUE) ? 0 : 8);
            }
            viewInflate.setId(View.generateViewId());
            getMViewModel().G().add(Integer.valueOf(viewInflate.getId()));
            getHeadViewBinding().f14387a.addView(viewInflate);
            getHeadViewBinding().f14386a.addView(viewInflate);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zx7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHotSpotFragment.showHistory$lambda$5$lambda$4(this.f46364a, str, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHistory$lambda$5$lambda$4(SearchHotSpotFragment searchHotSpotFragment, String str, View view) {
        Intrinsics.checkNotNullParameter(searchHotSpotFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$it");
        if (!Intrinsics.areEqual(searchHotSpotFragment.getMViewModel().D().getValue(), Boolean.TRUE)) {
            searchHotSpotFragment.clickHistoryCallback.invoke(str);
            return;
        }
        searchHotSpotFragment.getMViewModel().H().remove(str);
        searchHotSpotFragment.getMViewModel().N();
        searchHotSpotFragment.showHistory();
        if (searchHotSpotFragment.getMViewModel().H().isEmpty()) {
            searchHotSpotFragment.getMViewModel().D().setValue(Boolean.FALSE);
            searchHotSpotFragment.getHeadViewBinding().setVariable(qk0.p0, searchHotSpotFragment.getMViewModel());
        }
    }

    @NotNull
    public final Function1<String, Unit> getClickHistoryCallback() {
        return this.clickHistoryCallback;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_search_hot_spot;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().M();
        queryUserInfo();
        getMViewModel().L();
        showHistory();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().I().observe(this, new c(new Function1<SearchHotSpotBean, Unit>() { // from class: com.huachenjie.works.page.search.hot_spot.SearchHotSpotFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SearchHotSpotBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SearchHotSpotBean searchHotSpotBean) {
                SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).E().setValue(CollectionsKt.firstOrNull(searchHotSpotBean.getList()));
                SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).J().setValue(CollectionsKt.getOrNull(searchHotSpotBean.getList(), 1));
                SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).K().setValue(CollectionsKt.getOrNull(searchHotSpotBean.getList(), 2));
                SearchHotSpotAdapter value = SearchHotSpotFragment.access$getMViewModel(SearchHotSpotFragment.this).C().getValue();
                if (value != null) {
                    List<SearchHotSpotItemBean> list = searchHotSpotBean.getList();
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (i > 2) {
                            arrayList.add(obj);
                        }
                        i = i2;
                    }
                    value.setList(arrayList);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    public final void saveSearchHistory(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        for (int lastIndex = CollectionsKt.getLastIndex(getMViewModel().H()); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(getMViewModel().H().get(lastIndex), content)) {
                getMViewModel().H().remove(lastIndex);
                break;
            }
        }
        getMViewModel().H().add(0, content);
        while (getMViewModel().H().size() > MAX_HISTORTY_SIZE) {
            getMViewModel().H().remove(CollectionsKt.getLastIndex(getMViewModel().H()));
        }
        getMViewModel().N();
        showHistory();
        if (getMViewModel().H().size() == 1) {
            getHeadViewBinding().setVariable(qk0.p0, getMViewModel());
        }
    }

    public final void setClickHistoryCallback(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.clickHistoryCallback = function1;
    }
}
