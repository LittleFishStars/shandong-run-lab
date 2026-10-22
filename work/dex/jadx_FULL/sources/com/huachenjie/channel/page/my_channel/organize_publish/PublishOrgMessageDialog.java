package com.huachenjie.channel.page.my_channel.organize_publish;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelDialogPublishOrgMessageBinding;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialog;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.igexin.push.g.o;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelDialogPublishOrgMessageBinding;", "Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageDialogVM;", "", "initAdapter", "", "", "", "getVariables", "getWidth", "getHeight", "getLayoutResID", "initView", "initData", "Lkotlin/Function1;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "selCallback", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class PublishOrgMessageDialog extends BaseMVVMBottomDialogFragment<ChannelDialogPublishOrgMessageBinding, PublishOrgMessageDialogVM> {

    @NotNull
    private static final String CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Function1<? super OrganizeBean, Unit> selCallback = new Function1<OrganizeBean, Unit>() { // from class: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialog$selCallback$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((OrganizeBean) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull OrganizeBean organizeBean) {
            Intrinsics.checkNotNullParameter(organizeBean, o.f);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageDialog$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageDialog;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            PublishOrgMessageDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "channelNo", "Lkotlin/Function1;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "", RenderCallContext.TYPE_CALLBACK, "a", "CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String channelNo, @NotNull Function1<? super OrganizeBean, Unit> callback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            PublishOrgMessageDialog publishOrgMessageDialog = new PublishOrgMessageDialog();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            publishOrgMessageDialog.setArguments(bundle);
            publishOrgMessageDialog.selCallback = callback;
            publishOrgMessageDialog.show(fragmentManager, "PublishOrgMessageDialog");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<PublishOrgMessageClubAdapter> mutableLiveDataB = ((PublishOrgMessageDialogVM) getMViewModel()).B();
        final PublishOrgMessageClubAdapter publishOrgMessageClubAdapter = new PublishOrgMessageClubAdapter();
        publishOrgMessageClubAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.m37
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                PublishOrgMessageDialog.initAdapter$lambda$2$lambda$0(this.f43212a);
            }
        });
        BaseStateRequestModel baseStateRequestModel = (BaseStateRequestModel) getMViewModel();
        V mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = ((ChannelDialogPublishOrgMessageBinding) mBinding).f7747a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(baseStateRequestModel, this, stateLayout, publishOrgMessageClubAdapter, false, 8, null);
        BaseStateRequestModel.n((BaseStateRequestModel) getMViewModel(), this, publishOrgMessageClubAdapter, false, 4, null);
        y57.d(publishOrgMessageClubAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.n37
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PublishOrgMessageDialog.initAdapter$lambda$2$lambda$1(publishOrgMessageClubAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(publishOrgMessageClubAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$2$lambda$0(PublishOrgMessageDialog publishOrgMessageDialog) {
        Intrinsics.checkNotNullParameter(publishOrgMessageDialog, "this$0");
        BaseStateRequestModel.x((BaseStateRequestModel) publishOrgMessageDialog.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(PublishOrgMessageClubAdapter publishOrgMessageClubAdapter, PublishOrgMessageDialog publishOrgMessageDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(publishOrgMessageClubAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(publishOrgMessageDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        publishOrgMessageDialog.selCallback.invoke(publishOrgMessageClubAdapter.getData().get(i));
        publishOrgMessageDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_dialog_publish_org_message;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.k), new a()), TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        PublishOrgMessageDialogVM publishOrgMessageDialogVM = (PublishOrgMessageDialogVM) getMViewModel();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("channelNo") : null;
        if (string == null) {
            string = "";
        }
        publishOrgMessageDialogVM.D(string);
        ((PublishOrgMessageDialogVM) getMViewModel()).y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }
}
