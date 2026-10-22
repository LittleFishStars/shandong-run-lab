package com.huachenjie.channel.page.topic_main;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.channel.databinding.ChannelActivityTopicMainBinding;
import com.huachenjie.channel.databinding.ChannelViewTopicMainHeaderBinding;
import com.huachenjie.channel.page.all_member.AllMemberActivity;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.huachenjie.channel.page.topic_main.TopicMainActivity.a;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.e99;
import com.zj.adlib.ft1;
import com.zj.adlib.jj8;
import com.zj.adlib.tk0;
import com.zj.adlib.w88;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Route(path = zj7.b.TOPIC_MAIN)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0016\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001c\u001a\u00060\u0017R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR#\u0010%\u001a\n !*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/huachenjie/channel/page/topic_main/TopicMainActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityTopicMainBinding;", "Lcom/huachenjie/channel/page/topic_main/TopicMainVM;", "", "getLayoutResID", "", "", "V", "", "S", "initView", "initData", "W", "", "isDark", "m0", "l0", "j0", "", "t", "Ljava/lang/String;", yj7.b.SUBJECT_NO, "Lcom/huachenjie/channel/page/topic_main/TopicMainActivity$a;", "b", "Lkotlin/Lazy;", "h0", "()Lcom/huachenjie/channel/page/topic_main/TopicMainActivity$a;", "clickProxy", "a", "Z", "isTransparentToolBar", "Lcom/huachenjie/channel/databinding/ChannelViewTopicMainHeaderBinding;", "kotlin.jvm.PlatformType", "c", "i0", "()Lcom/huachenjie/channel/databinding/ChannelViewTopicMainHeaderBinding;", "headerViewBinding", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TopicMainActivity extends BaseMVVMActivity<ChannelActivityTopicMainBinding, TopicMainVM> {

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Autowired(name = yj7.b.SUBJECT_NO)
    @JvmField
    @NotNull
    public String subjectNo = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy clickProxy = LazyKt.lazy(new Function0<a>() { // from class: com.huachenjie.channel.page.topic_main.TopicMainActivity$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TopicMainActivity.a m322invoke() {
            return this.this$0.new a();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean isTransparentToolBar = true;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerViewBinding = LazyKt.lazy(new Function0<ChannelViewTopicMainHeaderBinding>() { // from class: com.huachenjie.channel.page.topic_main.TopicMainActivity$headerViewBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelViewTopicMainHeaderBinding m323invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.channel_view_topic_main_header, null, false);
            TopicMainActivity topicMainActivity = this.this$0;
            ChannelViewTopicMainHeaderBinding channelViewTopicMainHeaderBinding = (ChannelViewTopicMainHeaderBinding) viewDataBindingInflate;
            Integer value = TopicMainActivity.d0(topicMainActivity).e().b().getValue();
            Intrinsics.checkNotNull(value);
            channelViewTopicMainHeaderBinding.o(value);
            channelViewTopicMainHeaderBinding.n(topicMainActivity.h0());
            channelViewTopicMainHeaderBinding.setLifecycleOwner(topicMainActivity);
            return channelViewTopicMainHeaderBinding;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/topic_main/TopicMainActivity$a;", "", "Landroid/view/View;", "view", "", "c", "f", "b", "d", "<init>", "(Lcom/huachenjie/channel/page/topic_main/TopicMainActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void e(TopicMainActivity topicMainActivity, View view) {
            Intrinsics.checkNotNullParameter(topicMainActivity, "this$0");
            TopicMainActivity.d0(topicMainActivity).r(topicMainActivity.subjectNo);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TopicMainActivity topicMainActivity = TopicMainActivity.this;
            topicMainActivity.startActivity(AllMemberActivity.INSTANCE.a(topicMainActivity, AllMemberActivity.L, topicMainActivity.subjectNo));
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TopicMainActivity.this.finish();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (TopicMainActivity.d0(TopicMainActivity.this).p().getValue() == null) {
                return;
            }
            TopicMainBean value = TopicMainActivity.d0(TopicMainActivity.this).p().getValue();
            boolean z = false;
            if (value != null && value.getJoinFlag()) {
                z = true;
            }
            if (!z) {
                TopicMainActivity.d0(TopicMainActivity.this).q(TopicMainActivity.this.subjectNo);
                return;
            }
            TopicMainActivity topicMainActivity = TopicMainActivity.this;
            String string = topicMainActivity.getString(R.string.channel_main_cancel_follow);
            final TopicMainActivity topicMainActivity2 = TopicMainActivity.this;
            ft1.p(topicMainActivity, string, new View.OnClickListener() { // from class: com.zj.adlib.d99
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TopicMainActivity.a.e(topicMainActivity2, view2);
                }
            });
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (TopicMainActivity.d0(TopicMainActivity.this).p().getValue() == null) {
                return;
            }
            TopicMainBean value = TopicMainActivity.d0(TopicMainActivity.this).p().getValue();
            Intrinsics.checkNotNull(value);
            FragmentManager supportFragmentManager = TopicMainActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            w88.c(value, supportFragmentManager);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33538a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33538a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33538a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33538a.invoke(obj);
        }
    }

    public static final /* synthetic */ TopicMainVM d0(TopicMainActivity topicMainActivity) {
        return topicMainActivity.getMViewModel();
    }

    public static final void k0(TopicMainActivity topicMainActivity) {
        Intrinsics.checkNotNullParameter(topicMainActivity, "this$0");
        topicMainActivity.getMViewModel().t(topicMainActivity.subjectNo);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        m0(false);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), h0())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().p().observe(this, new b(new Function1<TopicMainBean, Unit>() { // from class: com.huachenjie.channel.page.topic_main.TopicMainActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TopicMainBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(TopicMainBean topicMainBean) {
                this.this$0.i0().m(topicMainBean);
                this.this$0.i0().executePendingBindings();
            }
        }));
        getMViewModel().n().observe(this, new b(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.topic_main.TopicMainActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                if (num != null && num.intValue() == 1) {
                    e99.f16248a.a(this.this$0);
                } else if (num != null && num.intValue() == 2) {
                    e99.f16248a.b(this.this$0);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_topic_main;
    }

    public final a h0() {
        return (a) this.clickProxy.getValue();
    }

    public final ChannelViewTopicMainHeaderBinding i0() {
        return (ChannelViewTopicMainHeaderBinding) this.headerViewBinding.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().s(this.subjectNo);
        getMViewModel().t(this.subjectNo);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        j0();
        l0();
    }

    public final void j0() {
        MutableLiveData<WorksAdapter> mutableLiveDataM = getMViewModel().m();
        WorksAdapter worksAdapter = new WorksAdapter(false, false, true, 3, null);
        worksAdapter.setHeaderWithEmptyEnable(true);
        View root = i0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerViewBinding.root");
        BaseQuickAdapter.setHeaderView$default(worksAdapter, root, 0, 0, 6, null);
        View viewInflate = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        viewInflate.setPadding(0, SizeUtils.b(100.0f), 0, 0);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…00f), 0, 0)\n            }");
        worksAdapter.setEmptyView(viewInflate);
        worksAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.c99
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                TopicMainActivity.k0(this.f40928a);
            }
        });
        mutableLiveDataM.setValue(worksAdapter);
    }

    public final void l0() {
        getMBinding().f33134a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.channel.page.topic_main.TopicMainActivity$initToolBar$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (recyclerView.computeVerticalScrollOffset() > jj8.a(35.0f)) {
                    if (this.f33539a.isTransparentToolBar) {
                        this.f33539a.isTransparentToolBar = false;
                        TopicMainActivity.d0(this.f33539a).o().setValue(-1);
                        this.f33539a.getMBinding().f7708a.setBackground(null);
                        this.f33539a.getMBinding().b.setBackground(null);
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(-16777216);
                        TopicMainActivity topicMainActivity = this.f33539a;
                        topicMainActivity.getMBinding().f7708a.setImageTintList(colorStateListValueOf);
                        topicMainActivity.getMBinding().b.setImageTintList(colorStateListValueOf);
                        this.f33539a.m0(true);
                        return;
                    }
                    return;
                }
                if (this.f33539a.isTransparentToolBar) {
                    return;
                }
                this.f33539a.isTransparentToolBar = true;
                TopicMainActivity.d0(this.f33539a).o().setValue(0);
                Drawable drawableBuild = new DrawableCreator.Builder().setSolidColor(Integer.MIN_VALUE).setCornersRadius(jj8.a(36.0f)).build();
                TopicMainActivity topicMainActivity2 = this.f33539a;
                topicMainActivity2.getMBinding().f7708a.setBackground(drawableBuild);
                topicMainActivity2.getMBinding().b.setBackground(drawableBuild);
                ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(-1);
                TopicMainActivity topicMainActivity3 = this.f33539a;
                topicMainActivity3.getMBinding().f7708a.setImageTintList(colorStateListValueOf2);
                topicMainActivity3.getMBinding().b.setImageTintList(colorStateListValueOf2);
                this.f33539a.m0(false);
            }
        });
    }

    public final void m0(boolean isDark) {
        e.p3(this).G2(R.color.transparent).T2(isDark).k3().a1();
    }
}
