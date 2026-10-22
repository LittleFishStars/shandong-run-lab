package com.huachenjie.channel.page.channel_main.topic;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.databinding.ChannelFragmentChannelMainTopicBinding;
import com.huachenjie.channel.databinding.ChannelViewChannelMainHotTopicBinding;
import com.huachenjie.channel.page.all_topic.AllTopicActivity;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.igexin.push.g.o;
import com.zj.adlib.tk0;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentChannelMainTopicBinding;", "Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicVM;", "", "initAdapter", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "pageEntity", "Landroid/view/View;", "createTopicView", "", "", "getVariables", "getLayoutResID", "initView", "", "isAdd2ViewPager2", "lazyLoadData", "initDataObservable", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelMainTopicFragment extends BaseMVVMFragment<ChannelFragmentChannelMainTopicBinding, ChannelMainTopicVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channel_no";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channel_no")) == null) ? "" : string;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicFragment;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AllTopicActivity.Companion aVar = AllTopicActivity.INSTANCE;
            Context contextRequireContext = ChannelMainTopicFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String channelNo = ChannelMainTopicFragment.this.getChannelNo();
            Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
            aVar.a(contextRequireContext, channelNo);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicFragment$b;", "", "", "channelNo", "Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainTopicFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChannelMainTopicFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            ChannelMainTopicFragment channelMainTopicFragment = new ChannelMainTopicFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channel_no", channelNo);
            channelMainTopicFragment.setArguments(bundle);
            return channelMainTopicFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33391a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33391a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33391a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33391a.invoke(obj);
        }
    }

    public static final /* synthetic */ ChannelMainTopicVM access$getMViewModel(ChannelMainTopicFragment channelMainTopicFragment) {
        return channelMainTopicFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createTopicView(PageEntity<ChannelTopicBean> pageEntity) {
        ChannelViewChannelMainHotTopicBinding channelViewChannelMainHotTopicBinding = (ChannelViewChannelMainHotTopicBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.channel_view_channel_main_hot_topic, null, false);
        channelViewChannelMainHotTopicBinding.f8226a.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        channelViewChannelMainHotTopicBinding.o(Boolean.valueOf(pageEntity.getTotal() > pageEntity.getList().size()));
        channelViewChannelMainHotTopicBinding.n(new a());
        ChannelMainHotTopicAdapter channelMainHotTopicAdapter = new ChannelMainHotTopicAdapter();
        channelMainHotTopicAdapter.setList(pageEntity.getList());
        channelViewChannelMainHotTopicBinding.m(channelMainHotTopicAdapter);
        channelViewChannelMainHotTopicBinding.setLifecycleOwner(this);
        View root = channelViewChannelMainHotTopicBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate<ChannelViewChann…icFragment\n        }.root");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<WorksAdapter> mutableLiveDataI = getMViewModel().i();
        WorksAdapter worksAdapter = new WorksAdapter(false, false, true, 3, null);
        worksAdapter.setHeaderWithEmptyEnable(true);
        View viewInflate = getLayoutInflater().inflate(R.layout.channel_view_channel_main_topic_title, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(\n…   null\n                )");
        BaseQuickAdapter.setHeaderView$default(worksAdapter, viewInflate, 0, 0, 6, null);
        View viewInflate2 = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        viewInflate2.setPadding(0, SizeUtils.b(100.0f), 0, 0);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "layoutInflater.inflate(R…00f), 0, 0)\n            }");
        worksAdapter.setEmptyView(viewInflate2);
        worksAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.pi1
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ChannelMainTopicFragment.initAdapter$lambda$2$lambda$1(this.f43986a);
            }
        });
        mutableLiveDataI.setValue(worksAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(ChannelMainTopicFragment channelMainTopicFragment) {
        Intrinsics.checkNotNullParameter(channelMainTopicFragment, "this$0");
        ChannelMainTopicVM mViewModel = channelMainTopicFragment.getMViewModel();
        String channelNo = channelMainTopicFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.n(channelNo);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_channel_main_topic;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ChannelMainTopicVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().j().observe(this, new c(new Function1<PageEntity<ChannelTopicBean>, Unit>() { // from class: com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PageEntity<ChannelTopicBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PageEntity<ChannelTopicBean> pageEntity) {
                WorksAdapter value;
                List list = pageEntity.getList();
                if ((list == null || list.isEmpty()) || (value = ChannelMainTopicFragment.access$getMViewModel(ChannelMainTopicFragment.this).i().getValue()) == null) {
                    return;
                }
                ChannelMainTopicFragment channelMainTopicFragment = ChannelMainTopicFragment.this;
                Intrinsics.checkNotNullExpressionValue(pageEntity, o.f);
                BaseQuickAdapter.addHeaderView$default(value, channelMainTopicFragment.createTopicView(pageEntity), 0, 0, 4, null);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        ChannelMainTopicVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.m(channelNo);
        ChannelMainTopicVM mViewModel2 = getMViewModel();
        String channelNo2 = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo2, "channelNo");
        mViewModel2.n(channelNo2);
    }
}
