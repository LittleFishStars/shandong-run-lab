package com.huachenjie.channel.page.create_channel.preference;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ClassificationBean;
import com.huachenjie.channel.databinding.ChannelActivityChooseTypePreferenceBinding;
import com.huachenjie.channel.page.create_channel.info.EditChannelInfoActivity;
import com.huachenjie.channel.page.create_channel.preference.ChooseTypePreferenceActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/preference/ChooseTypePreferenceActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityChooseTypePreferenceBinding;", "Lcom/huachenjie/channel/page/create_channel/preference/ChooseTypePreferenceVM;", "", "", "V", "getLayoutResID", "", "initView", "initData", "e0", "c0", "", "b", "Lkotlin/Lazy;", "b0", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseTypePreferenceActivity extends BaseMVVMActivity<ChannelActivityChooseTypePreferenceBinding, ChooseTypePreferenceVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "key_type";

    @NotNull
    public static final String x = "key_channel_no";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.create_channel.preference.ChooseTypePreferenceActivity$channelNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("key_channel_no");
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.create_channel.preference.ChooseTypePreferenceActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/preference/ChooseTypePreferenceActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/bean/ClassificationBean;", "typeBean", "", "channelNo", "", PerfId.startActivity, "KEY_CHANNEL_NO", "Ljava/lang/String;", "KEY_TYPE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull ClassificationBean typeBean, @Nullable String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(typeBean, "typeBean");
            Intent intent = new Intent(context, (Class<?>) ChooseTypePreferenceActivity.class);
            intent.putExtra("key_type", typeBean);
            intent.putExtra("key_channel_no", channelNo);
            context.startActivity(intent);
        }
    }

    public static final void d0(ChooseTypePreferenceActivity chooseTypePreferenceActivity, ChooseChannelTypePreferenceAdapter chooseChannelTypePreferenceAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseTypePreferenceActivity, "this$0");
        Intrinsics.checkNotNullParameter(chooseChannelTypePreferenceAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ClassificationBean value = chooseTypePreferenceActivity.getMViewModel().k().getValue();
        if (value == null) {
            return;
        }
        EditChannelInfoActivity.INSTANCE.a(chooseTypePreferenceActivity, value, chooseChannelTypePreferenceAdapter.getItem(i), chooseTypePreferenceActivity.b0());
    }

    public static final void f0(ChooseTypePreferenceActivity chooseTypePreferenceActivity, View view) {
        Intrinsics.checkNotNullParameter(chooseTypePreferenceActivity, "this$0");
        chooseTypePreferenceActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, ChooseTypePreferenceVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    public final String b0() {
        return (String) this.channelNo.getValue();
    }

    public final void c0() {
        MutableLiveData<ChooseChannelTypePreferenceAdapter> mutableLiveDataI = getMViewModel().i();
        final ChooseChannelTypePreferenceAdapter chooseChannelTypePreferenceAdapter = new ChooseChannelTypePreferenceAdapter();
        y57.d(chooseChannelTypePreferenceAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.qk1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChooseTypePreferenceActivity.d0(this.f19133a, chooseChannelTypePreferenceAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(chooseChannelTypePreferenceAdapter);
    }

    public final void e0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ = getMViewModel().j();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataJ.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.channel_type_preference_header_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseTypePreferenceActivity.f0(this.f44472a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_choose_type_preference;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ClassificationBean classificationBean = (ClassificationBean) getIntent().getParcelableExtra("key_type");
        if (classificationBean == null) {
            return;
        }
        getMViewModel().k().setValue(classificationBean);
        getMViewModel().l(classificationBean.getChannelClassificationNo());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        e0();
        c0();
    }
}
