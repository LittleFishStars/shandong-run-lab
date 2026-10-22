package com.huachenjie.channel.page.manage_channel.topic_chat;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "k", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;", "manageTopicChat", "", "memberCount", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "b", "j", "updateFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageTopicChatVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ManageTopicChatAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateFlag = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ManageTopicChatAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.updateFlag;
    }

    public final void k(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatVM$loadData$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 10002) {
                    ManageTopicChatAdapter value = this.this$0.i().getValue();
                    if (value != null) {
                        value.j();
                    }
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new ManageTopicChatVM$loadData$2(channelNo, this, null), 10, null);
    }

    public final void l(@NotNull ManageTopicChat manageTopicChat, int memberCount) {
        int iFindParentNode;
        Intrinsics.checkNotNullParameter(manageTopicChat, "manageTopicChat");
        manageTopicChat.setTeamCount(memberCount);
        ManageTopicChatAdapter value = this.adapter.getValue();
        if (value == null || (iFindParentNode = value.findParentNode(manageTopicChat)) < 0) {
            return;
        }
        BaseNode item = value.getItem(iFindParentNode);
        List<BaseNode> childNode = item.getChildNode();
        int iIndexOf = childNode != null ? childNode.indexOf(manageTopicChat) : -1;
        if (iIndexOf < 0) {
            return;
        }
        value.nodeSetData(item, iIndexOf, manageTopicChat);
    }
}
