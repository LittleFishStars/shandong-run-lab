package com.huachenjie.social_contact.page.emoji_sticker.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerDetailBean;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportDialog;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.o03;
import com.zj.adlib.zj7;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.l)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "m0", "", "x", "Ljava/lang/String;", "l0", "()Ljava/lang/String;", "s0", "(Ljava/lang/String;)V", "emojiStickerCode", "", "K", "I", "k0", "()I", "r0", "(I)V", UserConstants.EMOJI_PARAMS.b, "", "a", "Z", "j0", "()Z", "q0", "(Z)V", UserConstants.EMOJI_PARAMS.c, "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerDetailActivity extends BaseVmActivity<EmojiStickerDetailVM> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int emojiStatus;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean downloadFlag;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @NotNull
    public String emojiStickerCode = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailActivity$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (TextUtils.isEmpty(((EmojiStickerDetailVM) ((BaseVmActivity) EmojiStickerDetailActivity.this).f8507a).m().getValue())) {
                return;
            }
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", ((EmojiStickerDetailVM) ((BaseVmActivity) EmojiStickerDetailActivity.this).f8507a).m().getValue()).navigation();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ((EmojiStickerDetailVM) ((BaseVmActivity) EmojiStickerDetailActivity.this).f8507a).i(EmojiStickerDetailActivity.this.getEmojiStickerCode());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36262a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36262a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36262a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36262a.invoke(obj);
        }
    }

    public static final void n0(EmojiStickerDetailActivity emojiStickerDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerDetailActivity, "this$0");
        emojiStickerDetailActivity.finish();
    }

    public static final void o0(EmojiStickerDetailActivity emojiStickerDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerDetailActivity, "this$0");
        EmojiStickerDetailBean value = ((EmojiStickerDetailVM) ((BaseVmActivity) emojiStickerDetailActivity).f8507a).t().getValue();
        if (value != null) {
            ShareEmojiFriendDialog.INSTANCE.a(emojiStickerDetailActivity.emojiStickerCode, value.getEmojiBagName(), value.findEmojiImageUrl(0)).show(emojiStickerDetailActivity.getSupportFragmentManager(), "LabelSelectDialog");
        }
    }

    public static final void p0(EmojiStickerDetailActivity emojiStickerDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerDetailActivity, "this$0");
        EmojiStickerReportDialog.INSTANCE.a(emojiStickerDetailActivity.emojiStickerCode).show(emojiStickerDetailActivity.getSupportFragmentManager(), "EmojiStickerReportDialog");
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_emoji_sticker_detail), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        String stringExtra;
        String stringExtra2;
        Intent intent = getIntent();
        String stringExtra3 = intent != null ? intent.getStringExtra("emojiStickerCode") : null;
        String str = "";
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.emojiStickerCode = stringExtra3;
        Intent intent2 = getIntent();
        this.emojiStatus = intent2 != null ? intent2.getIntExtra(UserConstants.EMOJI_PARAMS.b, 2) : 2;
        Intent intent3 = getIntent();
        this.downloadFlag = intent3 != null ? intent3.getBooleanExtra(UserConstants.EMOJI_PARAMS.c, false) : false;
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).s().setValue(Integer.valueOf(this.emojiStatus));
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).n().setValue(Boolean.valueOf(this.downloadFlag));
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).u().setValue(Boolean.valueOf(this.emojiStatus != 2));
        MutableLiveData<String> mutableLiveDataL = ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).l();
        Intent intent4 = getIntent();
        if (intent4 == null || (stringExtra = intent4.getStringExtra(UserConstants.EMOJI_PARAMS.d)) == null) {
            stringExtra = "";
        }
        mutableLiveDataL.setValue(stringExtra);
        MutableLiveData<String> mutableLiveDataK = ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).k();
        Intent intent5 = getIntent();
        if (intent5 != null && (stringExtra2 = intent5.getStringExtra(UserConstants.EMOJI_PARAMS.e)) != null) {
            str = stringExtra2;
        }
        mutableLiveDataK.setValue(str);
        m0();
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).q(this.emojiStickerCode);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    o03 o03Var = o03.f43639a;
                    Context context = EmojiStickerDetailActivity.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    o03Var.c(context, EmojiStickerDetailActivity.this.getEmojiStickerCode());
                }
            }
        }));
    }

    /* JADX INFO: renamed from: j0, reason: from getter */
    public final boolean getDownloadFlag() {
        return this.downloadFlag;
    }

    /* JADX INFO: renamed from: k0, reason: from getter */
    public final int getEmojiStatus() {
        return this.emojiStatus;
    }

    @NotNull
    /* JADX INFO: renamed from: l0, reason: from getter */
    public final String getEmojiStickerCode() {
        return this.emojiStickerCode;
    }

    public final void m0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean rightSubIconClick = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("表情包详情").setTitleTextColor(Color.parseColor("#FF2C3E50")).setBackground(Color.parseColor("#FFFFFF")).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(Color.parseColor("#FF2C3E50"))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.l03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerDetailActivity.n0(this.f42958a, view);
            }
        }).setShowRightIcon(true).setRightIconResId(R.drawable.ic_emoji_sticker_detail_share).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.m03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerDetailActivity.o0(this.f43194a, view);
            }
        }).setShowRightSubIcon(false).setRightSubIconResId(R.drawable.ic_emoji_sticker_report).setRightSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.n03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerDetailActivity.p0(this.f43420a, view);
            }
        });
        e.p3(this).G2(R.color.transparent).T2(true).x1("#FFFFFF").G1(true).a1();
        ((EmojiStickerDetailVM) ((BaseVmActivity) this).f8507a).w().setValue(rightSubIconClick);
    }

    public final void q0(boolean z) {
        this.downloadFlag = z;
    }

    public final void r0(int i) {
        this.emojiStatus = i;
    }

    public final void s0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emojiStickerCode = str;
    }
}
