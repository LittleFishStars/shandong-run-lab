package com.zj.adlib;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.sport.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0014\u0010\u0017\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/zj/adlib/ph3;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "", "", "payloads", "b", "Landroid/view/View;", "view", "data", "", "position", "c", "", "isAnimate", "d", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ph3 extends BaseNodeProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        helper.setText(R.id.tv, ((mh3) item).getTitle());
        d(helper, item, false);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        for (Object obj : payloads) {
            if ((obj instanceof Integer) && Intrinsics.areEqual(obj, 110)) {
                d(helper, item, true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        ?? adapter2 = getAdapter2();
        if (adapter2 != 0) {
            adapter2.expandOrCollapse(position, true, true, 110);
        }
    }

    public final void d(BaseViewHolder helper, BaseNode data, boolean isAnimate) {
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.huachenjie.sport.page.mine.helpercenter.problem_tree.FirstNode");
        ImageView imageView = (ImageView) helper.getView(R.id.iv);
        if (((mh3) data).getIsExpanded()) {
            if (isAnimate) {
                ViewCompat.animate(imageView).setDuration(200L).setInterpolator(new DecelerateInterpolator()).rotation(0.0f).start();
                return;
            } else {
                imageView.setRotation(0.0f);
                return;
            }
        }
        if (isAnimate) {
            ViewCompat.animate(imageView).setDuration(200L).setInterpolator(new DecelerateInterpolator()).rotation(180.0f).start();
        } else {
            imageView.setRotation(180.0f);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.item_problem_group;
    }
}
