package com.huachenjie.social_contact.dialog.share_emoji;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.DialogShareEmojiFriendBinding;
import com.zj.adlib.bw9;
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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "", "getHeight", "getWidth", "initViewModel", "Landroid/view/View;", "mRootView", "initView", "<init>", "()V", "Companion", "a", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ShareEmojiFriendDialog extends BaseVMBottomDialogFragment<ShareEmojiFriendVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMOJI_BAG_CODE = "emojiBagCode";

    @NotNull
    public static final String EMOJI_BAG_NAME = "emojiBagName";

    @NotNull
    public static final String EMOJI_URL = "emojiUrl";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ShareEmojiFriendDialog.this.dismiss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendDialog$b;", "", "", "emojiBagCode", ShareEmojiFriendDialog.EMOJI_BAG_NAME, "emojiUr", "Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendDialog;", "a", "EMOJI_BAG_CODE", "Ljava/lang/String;", "EMOJI_BAG_NAME", "EMOJI_URL", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShareEmojiFriendDialog a(@NotNull String emojiBagCode, @NotNull String emojiBagName, @NotNull String emojiUr) {
            Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
            Intrinsics.checkNotNullParameter(emojiBagName, ShareEmojiFriendDialog.EMOJI_BAG_NAME);
            Intrinsics.checkNotNullParameter(emojiUr, "emojiUr");
            ShareEmojiFriendDialog shareEmojiFriendDialog = new ShareEmojiFriendDialog();
            Bundle bundle = new Bundle();
            bundle.putString("emojiBagCode", emojiBagCode);
            bundle.putString(ShareEmojiFriendDialog.EMOJI_BAG_NAME, emojiBagName);
            bundle.putString(ShareEmojiFriendDialog.EMOJI_URL, emojiUr);
            shareEmojiFriendDialog.setArguments(bundle);
            return shareEmojiFriendDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36210a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36210a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36210a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36210a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_share_emoji_friend), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        String string;
        String string2;
        String string3;
        setCancelable(true);
        MutableLiveData<String> mutableLiveDataK = ((ShareEmojiFriendVM) ((BaseVMDialogFragment) this).mState).k();
        Bundle arguments = getArguments();
        String str = "";
        if (arguments == null || (string = arguments.getString("emojiBagCode")) == null) {
            string = "";
        }
        mutableLiveDataK.setValue(string);
        MutableLiveData<String> mutableLiveDataL = ((ShareEmojiFriendVM) ((BaseVMDialogFragment) this).mState).l();
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString(EMOJI_BAG_NAME)) == null) {
            string2 = "";
        }
        mutableLiveDataL.setValue(string2);
        MutableLiveData<String> mutableLiveDataM = ((ShareEmojiFriendVM) ((BaseVMDialogFragment) this).mState).m();
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string3 = arguments3.getString(EMOJI_URL)) != null) {
            str = string3;
        }
        mutableLiveDataM.setValue(str);
        ((ShareEmojiFriendVM) ((BaseVMDialogFragment) this).mState).n();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initView(@Nullable View mRootView) {
        DialogShareEmojiFriendBinding dialogShareEmojiFriendBinding = (DialogShareEmojiFriendBinding) getBinding();
        if (dialogShareEmojiFriendBinding != null) {
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = dialogShareEmojiFriendBinding.f12912a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            bw9Var.d(recyclerView);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        ((ShareEmojiFriendVM) ((BaseVMDialogFragment) this).mState).j().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ShareEmojiFriendDialog.this.dismiss();
                }
            }
        }));
    }
}
