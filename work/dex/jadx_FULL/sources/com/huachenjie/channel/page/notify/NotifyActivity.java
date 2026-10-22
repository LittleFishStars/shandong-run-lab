package com.huachenjie.channel.page.notify;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityNotifyBinding;
import com.huachenjie.channel.page.notify.NotifyActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.tk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/page/notify/NotifyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityNotifyBinding;", "Lcom/huachenjie/channel/page/notify/NotifyVM;", "", "", "", "V", "getLayoutResID", "", "initView", "onResume", "initTitleBar", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyActivity extends BaseMVVMActivity<ChannelActivityNotifyBinding, NotifyVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.channel.page.notify.NotifyActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/notify/NotifyActivity$a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) NotifyActivity.class));
        }
    }

    public static final void a0(NotifyActivity notifyActivity, View view) {
        Intrinsics.checkNotNullParameter(notifyActivity, "this$0");
        notifyActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_notify;
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataL = getMViewModel().l();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataL.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.channel_flash_message_tab_system)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.w26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyActivity.a0(this.f45511a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initTitleBar();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().m();
    }
}
