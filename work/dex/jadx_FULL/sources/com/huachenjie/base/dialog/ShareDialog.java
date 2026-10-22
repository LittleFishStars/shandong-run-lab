package com.huachenjie.base.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.common.reconfig.baseView.BaseBottomDialogFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.SharedBody;
import huachenjie.sdk.share.sharebody.WebPageBody;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/base/dialog/ShareDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "Landroid/view/View;", "v", "", "clickShare", "clickCancel", "", "getWidth", "getHeight", "getLayoutResID", "initView", "initData", "Lhuachenjie/sdk/share/sharebody/SharedBody;", "mSharedBody", "Lhuachenjie/sdk/share/sharebody/SharedBody;", "", "mRemoteUrl", "Ljava/lang/String;", "", "mShowInternal", "Z", "Lcom/huachenjie/base/dialog/ShareDialog$OnShareCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/base/dialog/ShareDialog$OnShareCallback;", "<init>", "()V", "Companion", "a", "OnShareCallback", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ShareDialog extends BaseBottomDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String MOMENTS = "moments";

    @NotNull
    public static final String QQ = "qq";

    @NotNull
    public static final String SINA = "sina";

    @NotNull
    public static final String WECHAT = "wechat";

    @Nullable
    private OnShareCallback callback;

    @Nullable
    private String mRemoteUrl;
    private SharedBody mSharedBody;
    private boolean mShowInternal;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/base/dialog/ShareDialog$OnShareCallback;", "", "", "shareToInternal", "", "shareFlavour", "", "a", "onSuccess", "message", "onFailed", "base_release"}, k = 1, mv = {1, 8, 0})
    public interface OnShareCallback {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class a {
            public static void a(@NotNull OnShareCallback onShareCallback, @Nullable String str) {
            }

            public static void b(@NotNull OnShareCallback onShareCallback, boolean z, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "shareFlavour");
            }

            public static void c(@NotNull OnShareCallback onShareCallback) {
            }
        }

        void a(boolean shareToInternal, @NotNull String shareFlavour);

        void onFailed(@Nullable String message);

        void onSuccess();
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.ShareDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/base/dialog/ShareDialog$a;", "", "Lhuachenjie/sdk/share/sharebody/SharedBody;", "sharedBody", "", "remoteUrl", "Lcom/huachenjie/base/dialog/ShareDialog;", "a", "Lcom/huachenjie/base/dialog/ShareDialog$OnShareCallback;", RenderCallContext.TYPE_CALLBACK, "", "showInternal", "b", "MOMENTS", "Ljava/lang/String;", "QQ", "SINA", "WECHAT", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ShareDialog c(Companion companion, SharedBody sharedBody, String str, OnShareCallback onShareCallback, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.b(sharedBody, str, onShareCallback, z);
        }

        @NotNull
        public final ShareDialog a(@NotNull SharedBody sharedBody, @Nullable String remoteUrl) {
            Intrinsics.checkNotNullParameter(sharedBody, "sharedBody");
            ShareDialog shareDialog = new ShareDialog();
            shareDialog.mSharedBody = sharedBody;
            shareDialog.mRemoteUrl = remoteUrl;
            return shareDialog;
        }

        @NotNull
        public final ShareDialog b(@NotNull SharedBody sharedBody, @NotNull String remoteUrl, @NotNull OnShareCallback callback, boolean showInternal) {
            Intrinsics.checkNotNullParameter(sharedBody, "sharedBody");
            Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ShareDialog shareDialog = new ShareDialog();
            shareDialog.mSharedBody = sharedBody;
            shareDialog.mRemoteUrl = remoteUrl;
            shareDialog.mShowInternal = showInternal;
            shareDialog.callback = callback;
            return shareDialog;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.ShareDialog$initData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.dialog.ShareDialog$initData$2", f = "ShareDialog.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C14552(Continuation<? super C14552> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ShareDialog.this.new C14552(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            WebPageBody webPageBody = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcherC = jo2.c();
                ShareDialog$initData$2$bitmap$1 shareDialog$initData$2$bitmap$1 = new ShareDialog$initData$2$bitmap$1(ShareDialog.this, null);
                this.label = 1;
                obj = v41.h(coroutineDispatcherC, shareDialog$initData$2$bitmap$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Bitmap bitmap = (Bitmap) obj;
            WebPageBody webPageBody2 = ShareDialog.this.mSharedBody;
            if (webPageBody2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
            } else {
                webPageBody = webPageBody2;
            }
            webPageBody.setBitmap(bitmap);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickCancel(View v) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x0080 A[REMOVE] */
    public final void clickShare(View v) {
        FlavourName flavourName;
        SharedBody sharedBody = this.mSharedBody;
        if (sharedBody != null) {
            SharedBody sharedBody2 = null;
            if (sharedBody == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
                sharedBody = null;
            }
            if (sharedBody instanceof WebPageBody) {
                SharedBody sharedBody3 = this.mSharedBody;
                if (sharedBody3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
                    sharedBody3 = null;
                }
                if (((WebPageBody) sharedBody3).getImageBitmap() == null) {
                    return;
                }
            }
            Object tag = v.getTag();
            String str = tag instanceof String ? (String) tag : null;
            if (str == null) {
                return;
            }
            SharedBody sharedBody4 = this.mSharedBody;
            if (sharedBody4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
                sharedBody4 = null;
            }
            int iHashCode = str.hashCode();
            if (iHashCode != -791770330) {
                if (iHashCode != 3616) {
                    if (iHashCode != 3530377) {
                        if (iHashCode == 1235271283 && str.equals(MOMENTS)) {
                            flavourName = FlavourName.WX_MOMENT;
                        } else {
                            flavourName = FlavourName.WX_MOMENT;
                        }
                    } else if (str.equals(SINA)) {
                        flavourName = FlavourName.SINA;
                    } else {
                        flavourName = FlavourName.WX_MOMENT;
                    }
                } else if (str.equals(QQ)) {
                    flavourName = FlavourName.QQ;
                } else {
                    flavourName = FlavourName.WX_MOMENT;
                }
            } else if (str.equals(WECHAT)) {
                flavourName = FlavourName.WX_SESSION;
            } else {
                flavourName = FlavourName.WX_MOMENT;
            }
            sharedBody4.setFlavour(flavourName);
            OnShareCallback onShareCallback = this.callback;
            if (onShareCallback != null) {
                onShareCallback.a(false, str);
            }
            Context context = v.getContext();
            SharedBody sharedBody5 = this.mSharedBody;
            if (sharedBody5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
            } else {
                sharedBody2 = sharedBody5;
            }
            y88.i(context, sharedBody2, new ShareListener() { // from class: com.huachenjie.base.dialog.ShareDialog.clickShare.2
                public void onCancel(@Nullable FlavourName flavour) {
                    fv5.b("分享取消");
                }

                public void onFailed(@Nullable FlavourName flavour, int code, @Nullable String message) {
                    if (code == 1) {
                        fv5.b(message);
                    } else {
                        fv5.b(message == null ? "分享失败" : message);
                    }
                    OnShareCallback onShareCallback2 = ShareDialog.this.callback;
                    if (onShareCallback2 != null) {
                        onShareCallback2.onFailed(message);
                    }
                }

                public void onSuccess(@Nullable FlavourName flavour) {
                    OnShareCallback onShareCallback2 = ShareDialog.this.callback;
                    if (onShareCallback2 != null) {
                        onShareCallback2.onSuccess();
                    }
                    fv5.b("分享成功");
                }
            });
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ShareDialog shareDialog, View view) {
        Intrinsics.checkNotNullParameter(shareDialog, "this$0");
        OnShareCallback onShareCallback = shareDialog.callback;
        if (onShareCallback != null) {
            onShareCallback.a(true, "friend");
        }
        shareDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.dialog_share;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        SharedBody sharedBody = this.mSharedBody;
        if (sharedBody != null) {
            if (sharedBody == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSharedBody");
                sharedBody = null;
            }
            if (sharedBody instanceof WebPageBody) {
                String str = this.mRemoteUrl;
                if (str == null || str.length() == 0) {
                    return;
                }
                v41.e(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new C14552(null), 3, (Object) null);
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        View viewFindViewById;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        super.initView();
        if (this.mShowInternal) {
            View view = getView();
            ImageView imageView7 = view != null ? (ImageView) view.findViewById(R.id.iv_save_to_friend) : null;
            if (imageView7 != null) {
                imageView7.setVisibility(0);
            }
            View view2 = getView();
            viewFindViewById = view2 != null ? view2.findViewById(R.id.tv_save_to_friend) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            View view3 = getView();
            if (view3 != null && (imageView = (ImageView) view3.findViewById(R.id.iv_save_to_friend)) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.r88
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        ShareDialog.initView$lambda$0(this.f44396a, view4);
                    }
                });
            }
        } else {
            View view4 = getView();
            ImageView imageView8 = view4 != null ? (ImageView) view4.findViewById(R.id.iv_save_to_friend) : null;
            if (imageView8 != null) {
                imageView8.setVisibility(8);
            }
            View view5 = getView();
            viewFindViewById = view5 != null ? (TextView) view5.findViewById(R.id.tv_save_to_friend) : null;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        }
        View view6 = getView();
        if (view6 != null && (imageView6 = (ImageView) view6.findViewById(R.id.iv_share_to_wechat)) != null) {
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s88
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    this.f44639a.clickShare(view7);
                }
            });
        }
        View view7 = getView();
        if (view7 != null && (imageView5 = (ImageView) view7.findViewById(R.id.iv_share_to_wechat)) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s88
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    this.f44639a.clickShare(view8);
                }
            });
        }
        View view8 = getView();
        if (view8 != null && (imageView4 = (ImageView) view8.findViewById(R.id.iv_share_to_qq)) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s88
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    this.f44639a.clickShare(view9);
                }
            });
        }
        View view9 = getView();
        if (view9 != null && (imageView3 = (ImageView) view9.findViewById(R.id.iv_share_to_moments)) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s88
                @Override // android.view.View.OnClickListener
                public final void onClick(View view10) {
                    this.f44639a.clickShare(view10);
                }
            });
        }
        View view10 = getView();
        if (view10 != null && (imageView2 = (ImageView) view10.findViewById(R.id.iv_share_to_sina)) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.s88
                @Override // android.view.View.OnClickListener
                public final void onClick(View view11) {
                    this.f44639a.clickShare(view11);
                }
            });
        }
        View view11 = getView();
        if (view11 == null || (textView = (TextView) view11.findViewById(R.id.tv_cancel)) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.t88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view12) {
                this.f44870a.clickCancel(view12);
            }
        });
    }
}
