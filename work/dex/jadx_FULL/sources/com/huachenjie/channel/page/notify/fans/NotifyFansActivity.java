package com.huachenjie.channel.page.notify.fans;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.notify.NotifyFansAdapter;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.dialog.NotifyFansMenuDialog;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity;
import com.huachenjie.channel.page.notify.fans.NotifyFansActivity;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/notify/fans/NotifyFansActivity;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextActivity;", "Lcom/huachenjie/channel/page/notify/fans/NotifyFansModel;", "", "f0", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "d0", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyFansActivity extends BaseNotifyNextActivity<NotifyFansModel> {
    public static final void n0(NotifyFansAdapter notifyFansAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFansAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        FansBean fansBean = notifyFansAdapter.getData().get(i);
        fansBean.setReadFlag(false);
        notifyFansAdapter.notifyItemChanged(i);
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", fansBean.getAppUserCode()).navigation();
    }

    public static final void o0(NotifyFansAdapter notifyFansAdapter, NotifyFansActivity notifyFansActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFansAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(notifyFansActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        FansBean fansBean = notifyFansAdapter.getData().get(i);
        if (view.getId() == R.id.iv_menu) {
            NotifyFansMenuDialog notifyFansMenuDialogA = NotifyFansMenuDialog.INSTANCE.a(fansBean);
            FragmentManager supportFragmentManager = notifyFansActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            notifyFansMenuDialogA.show(supportFragmentManager, NotifyFansMenuDialog.class.getSimpleName());
        }
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public BaseQuickAdapter<?, ?> d0() {
        final NotifyFansAdapter notifyFansAdapter = new NotifyFansAdapter();
        y57.d(notifyFansAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.h36
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyFansActivity.n0(notifyFansAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        notifyFansAdapter.addChildClickViewIds(R.id.iv_menu);
        y57.b(notifyFansAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.i36
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyFansActivity.o0(notifyFansAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        return notifyFansAdapter;
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public String f0() {
        String string = getString(R.string.channel_notify_fans);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.channel_notify_fans)");
        return string;
    }
}
