package com.huachenjie.channel.page.manage_channel.chat;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelDialogSelectChatTeamLogoBinding;
import com.huachenjie.channel.page.manage_channel.chat.SelectChatTeamLogoDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.widget.GridSpacingItemDecoration;
import com.zj.adlib.fx7;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/SelectChatTeamLogoDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelDialogSelectChatTeamLogoBinding;", "Lcom/huachenjie/channel/page/manage_channel/chat/SelectChatTeamLogoVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "getVariables", "", "initView", "initData", "Lkotlin/Function1;", "", "onSel", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class SelectChatTeamLogoDialog extends BaseMVVMBottomDialogFragment<ChannelDialogSelectChatTeamLogoBinding, SelectChatTeamLogoVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function1<? super String, Unit> onSel;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.chat.SelectChatTeamLogoDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/SelectChatTeamLogoDialog$a;", "", "Lkotlin/Function1;", "", "", "onSel", "Lcom/huachenjie/channel/page/manage_channel/chat/SelectChatTeamLogoDialog;", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectChatTeamLogoDialog a(@Nullable Function1<? super String, Unit> onSel) {
            SelectChatTeamLogoDialog selectChatTeamLogoDialog = new SelectChatTeamLogoDialog();
            selectChatTeamLogoDialog.onSel = onSel;
            return selectChatTeamLogoDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(SelectChatTeamLogoDialog selectChatTeamLogoDialog, SelectChatTeamLogoAdapter selectChatTeamLogoAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectChatTeamLogoDialog, "this$0");
        Intrinsics.checkNotNullParameter(selectChatTeamLogoAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Function1<? super String, Unit> function1 = selectChatTeamLogoDialog.onSel;
        if (function1 != null) {
            function1.invoke(selectChatTeamLogoAdapter.getItem(i));
        }
        selectChatTeamLogoDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_dialog_select_chat_team_logo;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, SelectChatTeamLogoVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ((SelectChatTeamLogoVM) getMViewModel()).j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        RecyclerView recyclerView;
        super.initView();
        MutableLiveData<SelectChatTeamLogoAdapter> mutableLiveDataI = ((SelectChatTeamLogoVM) getMViewModel()).i();
        final SelectChatTeamLogoAdapter selectChatTeamLogoAdapter = new SelectChatTeamLogoAdapter();
        y57.d(selectChatTeamLogoAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.e48
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectChatTeamLogoDialog.initView$lambda$1$lambda$0(this.f16193a, selectChatTeamLogoAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(selectChatTeamLogoAdapter);
        ChannelDialogSelectChatTeamLogoBinding channelDialogSelectChatTeamLogoBinding = (ChannelDialogSelectChatTeamLogoBinding) getMBinding();
        if (channelDialogSelectChatTeamLogoBinding == null || (recyclerView = channelDialogSelectChatTeamLogoBinding.f33153a) == null) {
            return;
        }
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(4, (fx7.j() - (SizeUtils.b(52.0f) * 4)) / 5, 0, true));
    }
}
