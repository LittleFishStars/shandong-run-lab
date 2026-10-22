package com.huachenjie.channel.page.notify.mailbox;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.notify.NotifyMailBoxAdapter;
import com.huachenjie.channel.bean.notify.NotifyMailBoxBean;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity;
import com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/channel/page/notify/mailbox/NotifyMailBoxActivity;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextActivity;", "Lcom/huachenjie/channel/page/notify/mailbox/NotifyMailBoxModel;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "", "f0", "Lcom/huachenjie/common/bean/BindingTitleBean;", "titleBean", "k0", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "d0", "W", "Lcom/huachenjie/channel/adapter/notify/NotifyMailBoxAdapter;", "adapter", "o0", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyMailBoxActivity extends BaseNotifyNextActivity<NotifyMailBoxModel> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33507a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33507a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33507a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33507a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NotifyMailBoxModel n0(NotifyMailBoxActivity notifyMailBoxActivity) {
        return (NotifyMailBoxModel) notifyMailBoxActivity.getMViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p0(NotifyMailBoxAdapter notifyMailBoxAdapter, NotifyMailBoxActivity notifyMailBoxActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyMailBoxAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(notifyMailBoxActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        NotifyMailBoxBean notifyMailBoxBean = notifyMailBoxAdapter.getData().get(i);
        ((NotifyMailBoxModel) notifyMailBoxActivity.getMViewModel()).F(i, notifyMailBoxBean.getMsgId());
        int messageType = notifyMailBoxBean.getMessageType();
        if (messageType == 82) {
            ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, notifyMailBoxBean.getWorksNo()).navigation();
        } else {
            if (messageType != 84) {
                return;
            }
            fv5.a(R.string.channel_notify_channel_over);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q0(NotifyMailBoxActivity notifyMailBoxActivity, View view) {
        Intrinsics.checkNotNullParameter(notifyMailBoxActivity, "this$0");
        ((NotifyMailBoxModel) notifyMailBoxActivity.getMViewModel()).E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        ((NotifyMailBoxModel) getMViewModel()).D().observe(this, new a(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                BaseQuickAdapter<?, ?> value = NotifyMailBoxActivity.n0(this.this$0).B().getValue();
                if (value != null) {
                    List<?> data = value.getData();
                    Intrinsics.checkNotNullExpressionValue(num, o.f);
                    Object orNull = CollectionsKt.getOrNull(data, num.intValue());
                    NotifyMailBoxBean notifyMailBoxBean = orNull instanceof NotifyMailBoxBean ? (NotifyMailBoxBean) orNull : null;
                    if (notifyMailBoxBean != null) {
                        notifyMailBoxBean.setReadFlag(false);
                    }
                    value.notifyItemChanged(num.intValue());
                }
            }
        }));
        ((NotifyMailBoxModel) getMViewModel()).C().observe(this, new a(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                fv5.a(R.string.channel_notify_all_read);
                BaseQuickAdapter<?, ?> value = NotifyMailBoxActivity.n0(this.this$0).B().getValue();
                if (value != null) {
                    for (Object obj : value.getData()) {
                        NotifyMailBoxBean notifyMailBoxBean = obj instanceof NotifyMailBoxBean ? (NotifyMailBoxBean) obj : null;
                        if (notifyMailBoxBean != null) {
                            notifyMailBoxBean.setReadFlag(false);
                        }
                    }
                    value.notifyDataSetChanged();
                }
            }
        }));
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public BaseQuickAdapter<?, ?> d0() {
        NotifyMailBoxAdapter notifyMailBoxAdapter = new NotifyMailBoxAdapter();
        o0(notifyMailBoxAdapter);
        return notifyMailBoxAdapter;
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public String f0() {
        String string = getString(R.string.channel_notify_mailbox_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.channel_notify_mailbox_title)");
        return string;
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    public void k0(@NotNull BindingTitleBean titleBean) {
        Intrinsics.checkNotNullParameter(titleBean, "titleBean");
        titleBean.setShowRightIcon(false);
        titleBean.setShowRightText(true);
        titleBean.setRightButtonText(getString(R.string.channel_notify_mailbox_clear));
        titleBean.setRightButtonTextColor(Color.parseColor("#FF2C3E50"));
        titleBean.setShowRightIconNew(false);
        titleBean.setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.n36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyMailBoxActivity.q0(this.f43434a, view);
            }
        });
    }

    public final void o0(final NotifyMailBoxAdapter adapter) {
        y57.d(adapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.m36
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyMailBoxActivity.p0(adapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setBackgroundDrawableResource(R.color.color_f5f5f5);
        super.onCreate(savedInstanceState);
    }
}
