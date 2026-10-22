package com.huachenjie.works.page.share.choose_friend;

import android.view.View;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogChooseFriendBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.bw9;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogChooseFriendBinding;", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendVM;", "", "getHeight", "getWidth", "", "", "getVariables", "getLayoutResID", "", "initData", "initDataObserve", "initView", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", "<init>", "()V", "Companion", "a", "b", "OnFriendChooseCallback", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseFriendDialog extends BaseMVVMBottomDialogFragment<WorksDialogChooseFriendBinding, ChooseFriendVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnFriendChooseCallback callback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public interface OnFriendChooseCallback {
        void a(@NotNull FriendUserInfo bean);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ChooseFriendDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$b;", "", "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog$OnFriendChooseCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/works/page/share/choose_friend/ChooseFriendDialog;", "a", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChooseFriendDialog a(@NotNull OnFriendChooseCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ChooseFriendDialog chooseFriendDialog = new ChooseFriendDialog();
            chooseFriendDialog.callback = callback;
            return chooseFriendDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37332a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37332a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37332a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37332a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return fx7.h() - jj8.a(88.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_choose_friend;
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
        ((ChooseFriendVM) getMViewModel()).o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        ((ChooseFriendVM) getMViewModel()).m().observe(this, new c(new Function1<FriendUserInfo, Unit>() { // from class: com.huachenjie.works.page.share.choose_friend.ChooseFriendDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FriendUserInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable FriendUserInfo friendUserInfo) {
                if (friendUserInfo != null) {
                    OnFriendChooseCallback onFriendChooseCallback = ChooseFriendDialog.this.callback;
                    if (onFriendChooseCallback != null) {
                        onFriendChooseCallback.a(friendUserInfo);
                    }
                    ChooseFriendDialog.this.dismiss();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        WorksDialogChooseFriendBinding worksDialogChooseFriendBinding = (WorksDialogChooseFriendBinding) getMBinding();
        if (worksDialogChooseFriendBinding != null) {
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = worksDialogChooseFriendBinding.f14027a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            bw9Var.d(recyclerView);
        }
    }
}
