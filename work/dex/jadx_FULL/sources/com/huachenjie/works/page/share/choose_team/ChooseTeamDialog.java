package com.huachenjie.works.page.share.choose_team;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.databinding.WorksDialogChooseTeamBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.bw9;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogChooseTeamBinding;", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamVM;", "", "getHeight", "getWidth", "", "", "getVariables", "getLayoutResID", "", "initData", "initDataObserve", "initView", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "<init>", "()V", "Companion", "a", "b", "OnTeamChooseCallback", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseTeamDialog extends BaseMVVMBottomDialogFragment<WorksDialogChooseTeamBinding, ChooseTeamVM> {

    @NotNull
    public static final String CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnTeamChooseCallback callback;

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.share.choose_team.ChooseTeamDialog$channelNo$2
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", "", "Lcom/huachenjie/works/bean/ChatTeamBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public interface OnTeamChooseCallback {
        void a(@NotNull ChatTeamBean bean);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChooseTeamDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.share.choose_team.ChooseTeamDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$b;", "", "", "channelNo", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog$OnTeamChooseCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamDialog;", "a", "CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChooseTeamDialog a(@NotNull String channelNo, @NotNull OnTeamChooseCallback callback) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ChooseTeamDialog chooseTeamDialog = new ChooseTeamDialog();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            chooseTeamDialog.setArguments(bundle);
            chooseTeamDialog.callback = callback;
            return chooseTeamDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37337a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37337a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37337a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37337a.invoke(obj);
        }
    }

    private final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return fx7.h() - jj8.a(88.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_choose_team;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        setCancelable(true);
        ChooseTeamVM chooseTeamVM = (ChooseTeamVM) getMViewModel();
        String channelNo = getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        chooseTeamVM.m(channelNo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        ((ChooseTeamVM) getMViewModel()).k().observe(this, new c(new Function1<ChatTeamBean, Unit>() { // from class: com.huachenjie.works.page.share.choose_team.ChooseTeamDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ChatTeamBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable ChatTeamBean chatTeamBean) {
                if (chatTeamBean != null) {
                    OnTeamChooseCallback onTeamChooseCallback = ChooseTeamDialog.this.callback;
                    if (onTeamChooseCallback != null) {
                        onTeamChooseCallback.a(chatTeamBean);
                    }
                    ChooseTeamDialog.this.dismiss();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        WorksDialogChooseTeamBinding worksDialogChooseTeamBinding = (WorksDialogChooseTeamBinding) getMBinding();
        if (worksDialogChooseTeamBinding != null) {
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = worksDialogChooseTeamBinding.f14035a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            bw9Var.d(recyclerView);
        }
    }
}
