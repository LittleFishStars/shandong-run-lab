package com.huachenjie.channel.page.manage_channel.chat;

import android.app.Dialog;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b¨\u0006#"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "p", "teamGroupTitle", "Landroid/app/Dialog;", "dialog", "j", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "q", t.d, "teamGroupCode", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "teamChat", "i", "m", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/manage_channel/chat/ManageChatAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "b", j.b, "updateFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nManageChatVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManageChatVM.kt\ncom/huachenjie/channel/page/manage_channel/chat/ManageChatVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1#2:147\n350#3,7:148\n350#3,7:155\n*S KotlinDebug\n*F\n+ 1 ManageChatVM.kt\ncom/huachenjie/channel/page/manage_channel/chat/ManageChatVM\n*L\n105#1:148,7\n122#1:155,7\n*E\n"})
public final class ManageChatVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ManageChatAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateFlag = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"com/huachenjie/channel/page/manage_channel/chat/ManageChatVM$a", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "", "a", "Ljava/lang/Void;", "d", "()Ljava/lang/Void;", "childNode", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BaseNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public final Void childNode;

        @Nullable
        /* JADX INFO: renamed from: d, reason: from getter */
        public Void getChildNode() {
            return this.childNode;
        }

        @Override // com.chad.library.adapter.base.entity.node.BaseNode
        public /* bridge */ /* synthetic */ List getChildNode() {
            return (List) getChildNode();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"com/huachenjie/channel/page/manage_channel/chat/ManageChatVM$b", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "", "a", "Ljava/lang/Void;", "d", "()Ljava/lang/Void;", "childNode", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BaseNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public final Void childNode;

        @Nullable
        /* JADX INFO: renamed from: d, reason: from getter */
        public Void getChildNode() {
            return this.childNode;
        }

        @Override // com.chad.library.adapter.base.entity.node.BaseNode
        public /* bridge */ /* synthetic */ List getChildNode() {
            return (List) getChildNode();
        }
    }

    public final void i(@NotNull String teamGroupCode, @NotNull MyChannelChatTeam teamChat) {
        boolean z;
        Object next;
        BaseNode baseNode;
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        Intrinsics.checkNotNullParameter(teamChat, "teamChat");
        ManageChatAdapter value = this.adapter.getValue();
        if (value != null) {
            Iterator<T> it = value.getData().iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    baseNode = (BaseNode) next;
                }
            } while (!((baseNode instanceof MyChannelChatTeamGroup) && Intrinsics.areEqual(((MyChannelChatTeamGroup) baseNode).getTeamGroupCode(), teamGroupCode)));
            BaseNode baseNode2 = (BaseNode) next;
            if (baseNode2 != null) {
                List<BaseNode> childNode = baseNode2.getChildNode();
                if (childNode != null && childNode.size() == 2) {
                    z = true;
                }
                if (z) {
                    value.nodeSetData(baseNode2, 1, teamChat);
                } else {
                    List<BaseNode> childNode2 = baseNode2.getChildNode();
                    value.nodeAddData(baseNode2, (childNode2 != null ? childNode2.size() : 1) - 1, teamChat);
                }
                this.updateFlag.setValue(Boolean.TRUE);
            }
        }
    }

    public final void j(@NotNull String channelNo, @NotNull String teamGroupTitle, @NotNull Dialog dialog) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamGroupTitle, "teamGroupTitle");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageChatVM$addChatTeamGroup$1(channelNo, teamGroupTitle, this, dialog, null), 14, null);
    }

    public final void k(@NotNull String teamGroupCode, @NotNull MyChannelChatTeam teamChat) {
        Object next;
        List<BaseNode> childNode;
        BaseNode baseNode;
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        Intrinsics.checkNotNullParameter(teamChat, "teamChat");
        ManageChatAdapter value = this.adapter.getValue();
        if (value != null) {
            Iterator<T> it = value.getData().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    baseNode = (BaseNode) next;
                }
            } while (!((baseNode instanceof MyChannelChatTeamGroup) && Intrinsics.areEqual(((MyChannelChatTeamGroup) baseNode).getTeamGroupCode(), teamGroupCode)));
            BaseNode baseNode2 = (BaseNode) next;
            if (baseNode2 == null || (childNode = baseNode2.getChildNode()) == null) {
                return;
            }
            Iterator<BaseNode> it2 = childNode.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                BaseNode next2 = it2.next();
                if ((next2 instanceof MyChannelChatTeam) && Intrinsics.areEqual(((MyChannelChatTeam) next2).getTeamCode(), teamChat.getTeamCode())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0 || i > 1) {
                return;
            }
            List<BaseNode> childNode2 = baseNode2.getChildNode();
            if ((childNode2 != null ? (BaseNode) CollectionsKt.last(childNode2) : null) instanceof MyChannelChatTeam) {
                List<BaseNode> childNode3 = baseNode2.getChildNode();
                if (i == (childNode3 != null ? childNode3.size() : 1) - 1) {
                    value.nodeSetData(baseNode2, i, new a());
                } else {
                    value.nodeRemoveData(baseNode2, i);
                    value.nodeAddData(baseNode2, new b());
                }
            } else {
                value.nodeRemoveData(baseNode2, i);
            }
            this.updateFlag.setValue(Boolean.TRUE);
        }
    }

    public final void l(@NotNull String channelNo, @NotNull MyChannelChatTeamGroup bean, int position) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageChatVM$deleteChatTeamGroup$1(channelNo, bean, this, position, null), 14, null);
    }

    public final void m(@NotNull String teamGroupCode, @NotNull MyChannelChatTeam teamChat) {
        Object next;
        List<BaseNode> childNode;
        BaseNode baseNode;
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        Intrinsics.checkNotNullParameter(teamChat, "teamChat");
        ManageChatAdapter value = this.adapter.getValue();
        if (value != null) {
            Iterator<T> it = value.getData().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    baseNode = (BaseNode) next;
                }
            } while (!((baseNode instanceof MyChannelChatTeamGroup) && Intrinsics.areEqual(((MyChannelChatTeamGroup) baseNode).getTeamGroupCode(), teamGroupCode)));
            BaseNode baseNode2 = (BaseNode) next;
            if (baseNode2 == null || (childNode = baseNode2.getChildNode()) == null) {
                return;
            }
            Iterator<BaseNode> it2 = childNode.iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                BaseNode next2 = it2.next();
                if ((next2 instanceof MyChannelChatTeam) && Intrinsics.areEqual(((MyChannelChatTeam) next2).getTeamCode(), teamChat.getTeamCode())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0 || i > 1) {
                return;
            }
            value.nodeSetData(baseNode2, i, teamChat);
            this.updateFlag.setValue(Boolean.TRUE);
        }
    }

    @NotNull
    public final MutableLiveData<ManageChatAdapter> n() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.updateFlag;
    }

    public final void p(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageChatVM$loadData$1(channelNo, this, null), 14, null);
    }

    public final void q(@NotNull String channelNo, @NotNull String teamGroupTitle, @NotNull MyChannelChatTeamGroup bean, int position, @NotNull Dialog dialog) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamGroupTitle, "teamGroupTitle");
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageChatVM$updateChannelTeamGroup$1(channelNo, teamGroupTitle, bean, this, position, dialog, null), 14, null);
    }
}
