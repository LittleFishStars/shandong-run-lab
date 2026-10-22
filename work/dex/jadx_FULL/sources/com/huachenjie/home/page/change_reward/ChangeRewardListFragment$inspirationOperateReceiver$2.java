package com.huachenjie.home.page.change_reward;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.broadcast.inspiration.InspirationListener;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import com.huachenjie.home.bean.reward.AwardListBean;
import com.huachenjie.home.bean.reward.JackpotListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ChangeRewardListFragment$inspirationOperateReceiver$2 extends Lambda implements Function0<InspirationReceiver> {
    final /* synthetic */ ChangeRewardListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeRewardListFragment$inspirationOperateReceiver$2(ChangeRewardListFragment changeRewardListFragment) {
        super(0);
        this.this$0 = changeRewardListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(ChangeRewardListFragment changeRewardListFragment, int i) {
        AwardListBean item;
        List<AwardListBean> awardList;
        Intrinsics.checkNotNullParameter(changeRewardListFragment, "this$0");
        FragmentActivity activity = changeRewardListFragment.getActivity();
        ChangeRewardActivity changeRewardActivity = activity instanceof ChangeRewardActivity ? (ChangeRewardActivity) activity : null;
        if (changeRewardActivity != null) {
            changeRewardActivity.k0(i);
        }
        if (changeRewardListFragment.exchangeIndex >= 0) {
            int i2 = changeRewardListFragment.exchangeIndex;
            JackpotListBean jackpotList = changeRewardListFragment.getJackpotList();
            if (i2 < ((jackpotList == null || (awardList = jackpotList.getAwardList()) == null) ? 0 : awardList.size())) {
                ChangeRewardListAdapter value = changeRewardListFragment.getMViewModel().i().getValue();
                if (value != null && (item = value.getItem(changeRewardListFragment.exchangeIndex)) != null) {
                    item.setStock(item.getStock() - 1);
                    ChangeRewardListAdapter value2 = changeRewardListFragment.getMViewModel().i().getValue();
                    if (value2 != null) {
                        value2.notifyItemChanged(changeRewardListFragment.exchangeIndex);
                    }
                }
                changeRewardListFragment.exchangeIndex = -1;
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final InspirationReceiver m407invoke() {
        final ChangeRewardListFragment changeRewardListFragment = this.this$0;
        return new InspirationReceiver(new InspirationListener() { // from class: com.huachenjie.home.page.change_reward.a
            @Override // com.huachenjie.base.broadcast.inspiration.InspirationListener
            public final void a(int i) {
                ChangeRewardListFragment$inspirationOperateReceiver$2.invoke$lambda$1(changeRewardListFragment, i);
            }
        });
    }
}
