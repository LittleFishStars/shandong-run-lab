package com.huachenjie.channel.page.all_topic;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityAllTopicBinding;
import com.huachenjie.channel.page.all_topic.AllTopicActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/channel/page/all_topic/AllTopicActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityAllTopicBinding;", "Lcom/huachenjie/channel/page/all_topic/AllTopicVM;", "", "", "V", "getLayoutResID", "", "initView", "initData", "initTitleBar", "c0", "", "b", "Lkotlin/Lazy;", "b0", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AllTopicActivity extends BaseMVVMActivity<ChannelActivityAllTopicBinding, AllTopicVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.all_topic.AllTopicActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channelNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.all_topic.AllTopicActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/all_topic/AllTopicActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) AllTopicActivity.class);
            intent.putExtra("channelNo", channelNo);
            context.startActivity(intent);
        }
    }

    public static final void d0(AllTopicActivity allTopicActivity) {
        Intrinsics.checkNotNullParameter(allTopicActivity, "this$0");
        AllTopicVM mViewModel = allTopicActivity.getMViewModel();
        String strB0 = allTopicActivity.b0();
        Intrinsics.checkNotNullExpressionValue(strB0, "channelNo");
        mViewModel.m(strB0);
    }

    public static final void e0(AllTopicActivity allTopicActivity, View view) {
        Intrinsics.checkNotNullParameter(allTopicActivity, "this$0");
        allTopicActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, AllTopicVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final String b0() {
        return (String) this.channelNo.getValue();
    }

    public final void c0() {
        MutableLiveData<AllTopicAdapter> mutableLiveDataK = getMViewModel().k();
        AllTopicAdapter allTopicAdapter = new AllTopicAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R….layout_empty_work, null)");
        allTopicAdapter.setEmptyView(viewInflate);
        allTopicAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.w40
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AllTopicActivity.d0(this.f45521a);
            }
        });
        mutableLiveDataK.setValue(allTopicAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_all_topic;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        AllTopicVM mViewModel = getMViewModel();
        String strB0 = b0();
        Intrinsics.checkNotNullExpressionValue(strB0, "channelNo");
        mViewModel.m(strB0);
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataL = getMViewModel().l();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataL.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.channel_main_topic)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setShowDivider(true).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.v40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllTopicActivity.e0(this.f45287a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
        c0();
    }
}
