package com.huachenjie.channel.page.notify.favorites;

import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.notify.NotifyFavoritesAdapter;
import com.huachenjie.channel.bean.notify.NotifyFavoritesBean;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity;
import com.huachenjie.channel.page.notify.favorites.NotifyFavoritesActivity;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/notify/favorites/NotifyFavoritesActivity;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextActivity;", "Lcom/huachenjie/channel/page/notify/favorites/NotifyFavoritesModel;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "d0", "", "f0", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyFavoritesActivity extends BaseNotifyNextActivity<NotifyFavoritesModel> {
    public static final void n0(NotifyFavoritesAdapter notifyFavoritesAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFavoritesAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", notifyFavoritesAdapter.getData().get(i).getFavorUserCode()).navigation();
    }

    public static final void o0(NotifyFavoritesAdapter notifyFavoritesAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFavoritesAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        NotifyFavoritesBean notifyFavoritesBean = notifyFavoritesAdapter.getData().get(i);
        notifyFavoritesBean.setReadFlag(false);
        notifyFavoritesAdapter.notifyItemChanged(i);
        ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, notifyFavoritesBean.getWorksNo()).navigation();
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public BaseQuickAdapter<?, ?> d0() {
        final NotifyFavoritesAdapter notifyFavoritesAdapter = new NotifyFavoritesAdapter();
        notifyFavoritesAdapter.addChildClickViewIds(R.id.iv_avatar);
        y57.b(notifyFavoritesAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.k36
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyFavoritesActivity.n0(notifyFavoritesAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        y57.d(notifyFavoritesAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.l36
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyFavoritesActivity.o0(notifyFavoritesAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        return notifyFavoritesAdapter;
    }

    @Override // com.huachenjie.channel.page.notify.base.BaseNotifyNextActivity
    @NotNull
    public String f0() {
        String string = getString(R.string.channel_notify_favorites);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.channel_notify_favorites)");
        return string;
    }
}
