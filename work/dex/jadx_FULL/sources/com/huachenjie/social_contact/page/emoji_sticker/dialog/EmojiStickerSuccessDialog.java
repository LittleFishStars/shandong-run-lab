package com.huachenjie.social_contact.page.emoji_sticker.dialog;

import android.os.Bundle;
import android.view.View;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "<init>", "()V", "Companion", "a", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerSuccessDialog extends BaseVMDialogFragment<EmojiStickerSuccessVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMOJI_PROP = "emojiProp";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            EmojiStickerSuccessDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessDialog$b;", "", "Lcom/huachenjie/social_contact/bean/EmojiPropBean;", EmojiStickerSuccessDialog.EMOJI_PROP, "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerSuccessDialog;", "a", "", "EMOJI_PROP", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmojiStickerSuccessDialog a(@NotNull EmojiPropBean emojiProp) {
            Intrinsics.checkNotNullParameter(emojiProp, EmojiStickerSuccessDialog.EMOJI_PROP);
            EmojiStickerSuccessDialog emojiStickerSuccessDialog = new EmojiStickerSuccessDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(EmojiStickerSuccessDialog.EMOJI_PROP, emojiProp);
            emojiStickerSuccessDialog.setArguments(bundle);
            return emojiStickerSuccessDialog;
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_emoji_sticker_success), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        EmojiPropBean emojiPropBean;
        Bundle arguments = getArguments();
        if (arguments == null || (emojiPropBean = (EmojiPropBean) arguments.getParcelable(EMOJI_PROP)) == null) {
            return;
        }
        ((EmojiStickerSuccessVM) ((BaseVMDialogFragment) this).mState).h().setValue(emojiPropBean);
    }
}
