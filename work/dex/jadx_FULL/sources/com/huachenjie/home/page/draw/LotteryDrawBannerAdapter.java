package com.huachenjie.home.page.draw;

import android.view.ViewGroup;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeItemLotteryDrawBannerBinding;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J.\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/home/page/draw/LotteryDrawBannerAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/home/databinding/HomeItemLotteryDrawBannerBinding;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "e", "holder", "data", "position", "size", "", "c", "K", "I", "layoutRes", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class LotteryDrawBannerAdapter extends BannerAdapter<String, BaseDataBindingHolder<HomeItemLotteryDrawBannerBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int layoutRes;

    public LotteryDrawBannerAdapter() {
        super((List) null);
        this.layoutRes = R.layout.home_item_lottery_draw_banner;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindView(@NotNull BaseDataBindingHolder<HomeItemLotteryDrawBannerBinding> holder, @NotNull String data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        HomeItemLotteryDrawBannerBinding homeItemLotteryDrawBannerBinding = (HomeItemLotteryDrawBannerBinding) holder.getDataBinding();
        if (homeItemLotteryDrawBannerBinding != null) {
            homeItemLotteryDrawBannerBinding.k(data);
            homeItemLotteryDrawBannerBinding.executePendingBindings();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BaseDataBindingHolder<HomeItemLotteryDrawBannerBinding> onCreateHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new BaseDataBindingHolder<>(AdapterUtilsKt.getItemView(parent, this.layoutRes));
    }
}
