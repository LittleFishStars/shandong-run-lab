package com.huachenjie.channel.page.channel_home;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.channel.page.channel_home.CreateChannelDialog;
import com.huachenjie.channel.page.create_channel.type.ChooseChannelTypeActivity;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.zj.adlib.fv5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0016J$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006\""}, d2 = {"Lcom/huachenjie/channel/page/channel_home/CreateChannelDialog;", "Lcom/huachenjie/common/base/data_binding/BaseDialogFragment;", "Landroid/view/View;", "view", "", "x", "y", "offsetX", "offsetY", "", "setMoveAnimation", "startCreateChatTeam", "startCreateChannel", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "", "targetX$delegate", "Lkotlin/Lazy;", "getTargetX", "()I", CreateChannelDialog.TARGET_X, "targetY$delegate", "getTargetY", CreateChannelDialog.TARGET_Y, "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateChannelDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TARGET_X = "targetX";

    @NotNull
    public static final String TARGET_Y = "targetY";

    /* JADX INFO: renamed from: targetX$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy targetX = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.channel_home.CreateChannelDialog$targetX$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m260invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(CreateChannelDialog.TARGET_X) : 0);
        }
    });

    /* JADX INFO: renamed from: targetY$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy targetY = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.channel_home.CreateChannelDialog$targetY$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m261invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(CreateChannelDialog.TARGET_Y) : 0);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.channel_home.CreateChannelDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/CreateChannelDialog$a;", "", "", CreateChannelDialog.TARGET_X, CreateChannelDialog.TARGET_Y, "Lcom/huachenjie/channel/page/channel_home/CreateChannelDialog;", "a", "", "TARGET_X", "Ljava/lang/String;", "TARGET_Y", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CreateChannelDialog a(int targetX, int targetY) {
            CreateChannelDialog createChannelDialog = new CreateChannelDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(CreateChannelDialog.TARGET_X, targetX);
            bundle.putInt(CreateChannelDialog.TARGET_Y, targetY);
            createChannelDialog.setArguments(bundle);
            return createChannelDialog;
        }
    }

    private final int getTargetX() {
        return ((Number) this.targetX.getValue()).intValue();
    }

    private final int getTargetY() {
        return ((Number) this.targetY.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$lambda$1(CreateChannelDialog createChannelDialog, View view) {
        Intrinsics.checkNotNullParameter(createChannelDialog, "this$0");
        createChannelDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$lambda$4$lambda$3(CreateChannelDialog createChannelDialog, View view) {
        Intrinsics.checkNotNullParameter(createChannelDialog, "this$0");
        createChannelDialog.startCreateChatTeam();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$lambda$6$lambda$5(CreateChannelDialog createChannelDialog, View view) {
        Intrinsics.checkNotNullParameter(createChannelDialog, "this$0");
        createChannelDialog.startCreateChannel();
    }

    private final void setMoveAnimation(View view, float x, float y, float offsetX, float offsetY) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, x, 1, y);
        TranslateAnimation translateAnimation = new TranslateAnimation(offsetX, 0.0f, offsetY, 0.0f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(300L);
        view.setAnimation(animationSet);
    }

    private final void startCreateChannel() {
        ChooseChannelTypeActivity.Companion companion = ChooseChannelTypeActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ChooseChannelTypeActivity.Companion.b(companion, contextRequireContext, null, 2, null);
        dismiss();
    }

    private final void startCreateChatTeam() {
        fv5.b("聊天群");
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        View viewInflate = inflater.inflate(com.huachenjie.channel.R.layout.channel_dialog_create_channel, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateChannelDialog.onCreateView$lambda$7$lambda$1(this.f40856a, view);
            }
        });
        View viewFindViewById = viewInflate.findViewById(com.huachenjie.channel.R.id.llCreteBt);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.llCreteBt)");
            if (viewFindViewById.getLayoutParams() != null && (viewFindViewById.getLayoutParams() instanceof ConstraintLayout.LayoutParams)) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).setMarginStart(getTargetX());
                ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams2)).topMargin = getTargetY();
            }
        }
        View viewFindViewById2 = viewInflate.findViewById(com.huachenjie.channel.R.id.llChatTeam);
        if (viewFindViewById2 != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(R.id.llChatTeam)");
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.cx1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CreateChannelDialog.onCreateView$lambda$7$lambda$4$lambda$3(this.f41060a, view);
                }
            });
            setMoveAnimation(viewFindViewById2, 0.5f, 1.0f, 0.0f, SizeUtils.b(20.0f));
        }
        View viewFindViewById3 = viewInflate.findViewById(com.huachenjie.channel.R.id.llChatChannel);
        if (viewFindViewById3 != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById<View>(R.id.llChatChannel)");
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dx1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CreateChannelDialog.onCreateView$lambda$7$lambda$6$lambda$5(this.f41299a, view);
                }
            });
            setMoveAnimation(viewFindViewById3, 0.0f, 0.5f, -SizeUtils.b(20.0f), 0.0f);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        viewInflate.setAnimation(alphaAnimation);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.0f;
        int i = window.getAttributes().flags;
        window.setAttributes(window.getAttributes());
    }
}
