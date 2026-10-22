package com.huachenjie.channel.page.my_channel.communication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelFragmentMyChannelCommunicationBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.tk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/communication/CommunicationFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentMyChannelCommunicationBinding;", "Lcom/huachenjie/channel/page/my_channel/communication/CommunicationVM;", "", "initAdapter", "", "", "getVariables", "getLayoutResID", "initView", "lazyLoadData", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CommunicationFragment extends BaseMVVMFragment<ChannelFragmentMyChannelCommunicationBinding, CommunicationVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.my_channel.communication.CommunicationFragment$channelNo$2
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

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.communication.CommunicationFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/communication/CommunicationFragment$a;", "", "", "channelNo", "Lcom/huachenjie/channel/page/my_channel/communication/CommunicationFragment;", "a", "KEY_CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CommunicationFragment a(@NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            CommunicationFragment communicationFragment = new CommunicationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            communicationFragment.setArguments(bundle);
            return communicationFragment;
        }
    }

    private final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final void initAdapter() {
        MutableLiveData<CommunicationAdapter> mutableLiveDataI = getMViewModel().i();
        CommunicationAdapter communicationAdapter = new CommunicationAdapter();
        communicationAdapter.setHeaderWithEmptyEnable(true);
        View viewInflate = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        viewInflate.setPadding(0, SizeUtils.b(160.0f), 0, 0);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…60f), 0, 0)\n            }");
        communicationAdapter.setEmptyView(viewInflate);
        mutableLiveDataI.setValue(communicationAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_my_channel_communication;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, CommunicationVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        CommunicationVM mViewModel = getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.j(channelNo);
    }
}
