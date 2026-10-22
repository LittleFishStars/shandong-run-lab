package com.huachenjie.channel.page.my_channel.topic;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicChat;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelTopicBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.tk0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0016\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/topic/TopicFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentMyChannelTopicBinding;", "Lcom/huachenjie/channel/page/my_channel/topic/TopicVM;", "", "initAdapter", "", "", "getVariables", "getLayoutResID", "initView", "lazyLoadData", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "messageList", "updateChatMessage", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTopicFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicFragment.kt\ncom/huachenjie/channel/page/my_channel/topic/TopicFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2,2:69\n*S KotlinDebug\n*F\n+ 1 TopicFragment.kt\ncom/huachenjie/channel/page/my_channel/topic/TopicFragment\n*L\n58#1:69,2\n*E\n"})
public final class TopicFragment extends BaseMVVMFragment<ChannelFragmentMyChannelTopicBinding, TopicVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.my_channel.topic.TopicFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channelNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.topic.TopicFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/topic/TopicFragment$a;", "", "", "channelNo", "Lcom/huachenjie/channel/page/my_channel/topic/TopicFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TopicFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            TopicFragment topicFragment = new TopicFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            topicFragment.setArguments(bundle);
            return topicFragment;
        }
    }

    private final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<TopicAdapter> mutableLiveDataI = getMViewModel().i();
        TopicAdapter topicAdapter = new TopicAdapter();
        topicAdapter.setHeaderWithEmptyEnable(true);
        View viewInflate = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        viewInflate.setPadding(0, SizeUtils.b(160.0f), 0, 0);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…60f), 0, 0)\n            }");
        topicAdapter.setEmptyView(viewInflate);
        mutableLiveDataI.setValue(topicAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_my_channel_topic;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, TopicVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        TopicVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.k(channelNo);
    }

    public final void updateChatMessage(@NotNull List<? extends RecentContact> messageList) {
        TopicAdapter value;
        Intrinsics.checkNotNullParameter(messageList, "messageList");
        if (messageList.isEmpty() || (value = getMViewModel().i().getValue()) == null) {
            return;
        }
        for (RecentContact recentContact : messageList) {
            MyChannelTopicChat myChannelTopicChat = getMViewModel().j().get(recentContact != null ? recentContact.getContactId() : null);
            if (myChannelTopicChat != null) {
                TopicVM mViewModel = getMViewModel();
                Intrinsics.checkNotNull(recentContact);
                mViewModel.l(myChannelTopicChat, recentContact);
                int itemPosition = value.getItemPosition(myChannelTopicChat);
                if (itemPosition >= 0) {
                    value.notifyItemChanged(itemPosition + value.getHeaderLayoutCount());
                }
            }
        }
    }
}
