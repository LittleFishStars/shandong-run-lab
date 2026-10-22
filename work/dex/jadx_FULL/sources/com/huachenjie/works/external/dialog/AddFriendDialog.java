package com.huachenjie.works.external.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.DataBindingUtil;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.base.widget.dialog.CustomDialog;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogAddFriendBinding;
import com.huachenjie.works.external.dialog.AddFriendDialog;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.gv1;
import com.zj.adlib.p44;
import com.zj.adlib.qk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/works/external/dialog/AddFriendDialog;", "Lcom/huachenjie/base/widget/dialog/CustomDialog;", "context", "Landroid/content/Context;", "userInfoBean", "Lcom/huachenjie/base/bean/UserInfoBean;", "(Landroid/content/Context;Lcom/huachenjie/base/bean/UserInfoBean;)V", "applyFriendSucCallback", "Lkotlin/Function0;", "", "getApplyFriendSucCallback", "()Lkotlin/jvm/functions/Function0;", "setApplyFriendSucCallback", "(Lkotlin/jvm/functions/Function0;)V", "applyFriend", "friendBinding", "Lcom/huachenjie/works/databinding/WorksDialogAddFriendBinding;", "loadingDialog", "Landroid/app/Dialog;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AddFriendDialog extends CustomDialog {

    @Nullable
    private Function0<Unit> applyFriendSucCallback;

    @NotNull
    private final UserInfoBean userInfoBean;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/works/external/dialog/AddFriendDialog$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/netease/nimlib/sdk/uinfo/model/NimUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<List<? extends NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f37132a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WorksDialogAddFriendBinding f14829a;

        /* JADX INFO: renamed from: com.huachenjie.works.external.dialog.AddFriendDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/external/dialog/AddFriendDialog$a$a", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0829a extends DefaultCallback<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Dialog f37133a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AddFriendDialog f14831a;

            public C0829a(Dialog dialog, AddFriendDialog addFriendDialog) {
                this.f37133a = dialog;
                this.f14831a = addFriendDialog;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
                Dialog dialog = this.f37133a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (code != 200) {
                    if (code != 414) {
                        fv5.a(R.string.works_add_friend_apply_fail);
                        return;
                    } else {
                        fv5.a(R.string.works_add_friend_apply_can_not);
                        return;
                    }
                }
                fv5.a(R.string.works_add_friend_apply_suc);
                this.f14831a.userInfoBean.setHasAppliedFriend(true);
                Function0<Unit> applyFriendSucCallback = this.f14831a.getApplyFriendSucCallback();
                if (applyFriendSucCallback != null) {
                    applyFriendSucCallback.invoke();
                }
                this.f14831a.dismiss();
            }
        }

        public a(WorksDialogAddFriendBinding worksDialogAddFriendBinding, Dialog dialog) {
            this.f14829a = worksDialogAddFriendBinding;
            this.f37132a = dialog;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int code, @Nullable List<? extends NimUserInfo> result, @Nullable Throwable exception) {
            dj1.f(AddFriendDialog.this.userInfoBean.getAccId(), String.valueOf(this.f14829a.f13964a.getText()), new C0829a(this.f37132a, AddFriendDialog.this));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/external/dialog/AddFriendDialog$b", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", c.f25231a, "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Dialog f37134a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WorksDialogAddFriendBinding f14832a;

        public b(WorksDialogAddFriendBinding worksDialogAddFriendBinding, Dialog dialog) {
            this.f14832a = worksDialogAddFriendBinding;
            this.f37134a = dialog;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            if (code != 200 || result == null) {
                Dialog dialog = this.f37134a;
                if (dialog != null) {
                    dialog.dismiss();
                }
                fv5.a(R.string.works_add_friend_apply_fail);
                return;
            }
            AddFriendDialog addFriendDialog = AddFriendDialog.this;
            WorksDialogAddFriendBinding worksDialogAddFriendBinding = this.f14832a;
            Intrinsics.checkNotNullExpressionValue(worksDialogAddFriendBinding, "friendBinding");
            addFriendDialog.applyFriend(worksDialogAddFriendBinding, this.f37134a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddFriendDialog(@Nullable Context context, @NotNull UserInfoBean userInfoBean) {
        super(context);
        Intrinsics.checkNotNullParameter(userInfoBean, "userInfoBean");
        this.userInfoBean = userInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFriend(WorksDialogAddFriendBinding friendBinding, Dialog loadingDialog) {
        dj1.F(CollectionsKt.arrayListOf(new String[]{this.userInfoBean.getAccId()}), new a(friendBinding, loadingDialog));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AddFriendDialog addFriendDialog, View view) {
        Intrinsics.checkNotNullParameter(addFriendDialog, "this$0");
        addFriendDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(AddFriendDialog addFriendDialog, WorksDialogAddFriendBinding worksDialogAddFriendBinding, View view) {
        Intrinsics.checkNotNullParameter(addFriendDialog, "this$0");
        Activity activity = gv1.getActivity(addFriendDialog.getContext());
        Dialog dialogP = activity != null ? DialogUtil.p(activity, false) : null;
        if (dialogP != null) {
            dialogP.show();
        }
        if (!p44.r()) {
            p44.x(addFriendDialog.new b(worksDialogAddFriendBinding, dialogP));
        } else {
            Intrinsics.checkNotNullExpressionValue(worksDialogAddFriendBinding, "friendBinding");
            addFriendDialog.applyFriend(worksDialogAddFriendBinding, dialogP);
        }
    }

    @Nullable
    public final Function0<Unit> getApplyFriendSucCallback() {
        return this.applyFriendSucCallback;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WorksDialogAddFriendBinding worksDialogAddFriendBinding = (WorksDialogAddFriendBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.works_dialog_add_friend, null, false);
        worksDialogAddFriendBinding.setVariable(qk0.g, this.userInfoBean);
        setContentView(worksDialogAddFriendBinding.getRoot());
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        worksDialogAddFriendBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.j10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFriendDialog.onCreate$lambda$1(this.f42485a, view);
            }
        });
        worksDialogAddFriendBinding.f13963a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.k10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFriendDialog.onCreate$lambda$3(this.f17538a, worksDialogAddFriendBinding, view);
            }
        });
    }

    public final void setApplyFriendSucCallback(@Nullable Function0<Unit> function0) {
        this.applyFriendSucCallback = function0;
    }
}
