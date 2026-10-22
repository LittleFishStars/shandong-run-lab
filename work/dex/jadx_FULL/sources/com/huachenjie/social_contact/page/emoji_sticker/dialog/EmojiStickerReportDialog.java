package com.huachenjie.social_contact.page.emoji_sticker.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.DialogEmojiStickerReportBinding;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMDialogFragment;", "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", "emojiBagCode", "Ljava/lang/String;", "getEmojiBagCode", "()Ljava/lang/String;", "setEmojiBagCode", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerReportDialog extends BaseVMDialogFragment<EmojiStickerReportVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMOJI_BAG_CODE = "emojiBagCode";

    @NotNull
    private String emojiBagCode = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportDialog$a;", "", "Landroid/view/View;", "view", "", "a", "c", "b", "<init>", "(Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            EmojiStickerReportDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DialogEmojiStickerReportBinding dialogEmojiStickerReportBinding = (DialogEmojiStickerReportBinding) EmojiStickerReportDialog.this.getBinding();
            if (dialogEmojiStickerReportBinding != null) {
                EmojiStickerReportDialog emojiStickerReportDialog = EmojiStickerReportDialog.this;
                if (dialogEmojiStickerReportBinding.f36134a.isChecked()) {
                    ((EmojiStickerReportVM) ((BaseVMDialogFragment) emojiStickerReportDialog).mState).j(emojiStickerReportDialog.getEmojiBagCode(), "不正当内容", 1);
                } else if (dialogEmojiStickerReportBinding.b.isChecked()) {
                    ((EmojiStickerReportVM) ((BaseVMDialogFragment) emojiStickerReportDialog).mState).j(emojiStickerReportDialog.getEmojiBagCode(), "广告骚扰", 2);
                } else if (dialogEmojiStickerReportBinding.c.isChecked()) {
                    ((EmojiStickerReportVM) ((BaseVMDialogFragment) emojiStickerReportDialog).mState).j(emojiStickerReportDialog.getEmojiBagCode(), "侵犯著作权", 3);
                }
            }
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportDialog$b;", "", "", "emojiBagCode", "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/EmojiStickerReportDialog;", "a", "EMOJI_BAG_CODE", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmojiStickerReportDialog a(@NotNull String emojiBagCode) {
            Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
            EmojiStickerReportDialog emojiStickerReportDialog = new EmojiStickerReportDialog();
            Bundle bundle = new Bundle();
            bundle.putString("emojiBagCode", emojiBagCode);
            emojiStickerReportDialog.setArguments(bundle);
            return emojiStickerReportDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36269a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36269a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36269a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36269a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_emoji_sticker_report), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @NotNull
    public final String getEmojiBagCode() {
        return this.emojiBagCode;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("emojiBagCode") : null;
        if (string == null) {
            string = "";
        }
        this.emojiBagCode = string;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        ((EmojiStickerReportVM) ((BaseVMDialogFragment) this).mState).h().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportDialog.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    EmojiStickerReportDialog.this.dismiss();
                }
            }
        }));
    }

    public final void setEmojiBagCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emojiBagCode = str;
    }
}
