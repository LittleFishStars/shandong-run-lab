package com.huachenjie.social_contact.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.huachenjie.social_contact.databinding.DialogPropLetterBinding;
import com.huachenjie.social_contact.vm.PropLetterVM;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.cr2;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.tg9;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B\u0007¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\n\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0003H\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006)"}, d2 = {"Lcom/huachenjie/social_contact/dialog/PropLetterDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/social_contact/vm/PropLetterVM;", "", "initGift", "Lcom/huachenjie/base/bean/GiftBean;", "item", "Landroid/widget/ImageView;", RemoteMessageConst.Notification.ICON, "gene", "setGiftItem", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "", "getHeight", "getWidth", "setStyle", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "Lcom/huachenjie/social_contact/bean/NoticeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/social_contact/bean/NoticeBean;", "getBean", "()Lcom/huachenjie/social_contact/bean/NoticeBean;", "setBean", "(Lcom/huachenjie/social_contact/bean/NoticeBean;)V", "Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", "getCallback", "()Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", "setCallback", "(Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;)V", "<init>", "()V", "Companion", "a", "b", "OnClickCallback", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPropLetterDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropLetterDialog.kt\ncom/huachenjie/social_contact/dialog/PropLetterDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
public final class PropLetterDialog extends BaseVMBottomDialogFragment<PropLetterVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String NOTICE_MESSAGE = "NOTICE_MESSAGE";

    @Nullable
    private NoticeBean bean;

    @Nullable
    private OnClickCallback callback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", "", "", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public interface OnClickCallback {
        void a();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/dialog/PropLetterDialog$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/social_contact/dialog/PropLetterDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPropLetterDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PropLetterDialog.kt\ncom/huachenjie/social_contact/dialog/PropLetterDialog$ClickProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (Intrinsics.areEqual(((PropLetterVM) ((BaseVMDialogFragment) PropLetterDialog.this).mState).i().getValue(), Boolean.TRUE)) {
                fv5.b("您已经领取过该礼物了");
                return;
            }
            NoticeBean bean = PropLetterDialog.this.getBean();
            if (bean != null) {
                ((PropLetterVM) ((BaseVMDialogFragment) PropLetterDialog.this).mState).k(bean);
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PropLetterDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.dialog.PropLetterDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/social_contact/dialog/PropLetterDialog$b;", "", "Lcom/huachenjie/social_contact/bean/NoticeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/social_contact/dialog/PropLetterDialog;", "a", "", PropLetterDialog.NOTICE_MESSAGE, "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PropLetterDialog a(@Nullable NoticeBean bean, @NotNull OnClickCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            if (bean == null) {
                return null;
            }
            PropLetterDialog propLetterDialog = new PropLetterDialog();
            propLetterDialog.setCallback(callback);
            Bundle bundle = new Bundle();
            bundle.putParcelable(PropLetterDialog.NOTICE_MESSAGE, bean);
            propLetterDialog.setArguments(bundle);
            return propLetterDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36207a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36207a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36207a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36207a.invoke(obj);
        }
    }

    private final void initGift() {
        List<GiftBean> arrayList;
        DialogPropLetterBinding dialogPropLetterBinding = (DialogPropLetterBinding) getBinding();
        if (dialogPropLetterBinding != null) {
            NoticeBean noticeBean = this.bean;
            if (noticeBean == null || (arrayList = noticeBean.getGiftList()) == null) {
                arrayList = new ArrayList<>();
            }
            int size = arrayList.size();
            if (size > 0) {
                GiftBean giftBean = arrayList.get(0);
                ImageView imageView = dialogPropLetterBinding.e;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivIcon1");
                ImageView imageView2 = dialogPropLetterBinding.f36149a;
                Intrinsics.checkNotNullExpressionValue(imageView2, "ivGeneType1");
                setGiftItem(giftBean, imageView, imageView2);
            } else {
                ImageView imageView3 = dialogPropLetterBinding.e;
                Intrinsics.checkNotNullExpressionValue(imageView3, "ivIcon1");
                ImageView imageView4 = dialogPropLetterBinding.f36149a;
                Intrinsics.checkNotNullExpressionValue(imageView4, "ivGeneType1");
                setGiftItem(null, imageView3, imageView4);
            }
            if (size > 1) {
                GiftBean giftBean2 = arrayList.get(1);
                ImageView imageView5 = dialogPropLetterBinding.f;
                Intrinsics.checkNotNullExpressionValue(imageView5, "ivIcon2");
                ImageView imageView6 = dialogPropLetterBinding.b;
                Intrinsics.checkNotNullExpressionValue(imageView6, "ivGeneType2");
                setGiftItem(giftBean2, imageView5, imageView6);
            } else {
                ImageView imageView7 = dialogPropLetterBinding.f;
                Intrinsics.checkNotNullExpressionValue(imageView7, "ivIcon2");
                ImageView imageView8 = dialogPropLetterBinding.b;
                Intrinsics.checkNotNullExpressionValue(imageView8, "ivGeneType2");
                setGiftItem(null, imageView7, imageView8);
            }
            if (size > 2) {
                GiftBean giftBean3 = arrayList.get(2);
                ImageView imageView9 = dialogPropLetterBinding.g;
                Intrinsics.checkNotNullExpressionValue(imageView9, "ivIcon3");
                ImageView imageView10 = dialogPropLetterBinding.c;
                Intrinsics.checkNotNullExpressionValue(imageView10, "ivGeneType3");
                setGiftItem(giftBean3, imageView9, imageView10);
            } else {
                ImageView imageView11 = dialogPropLetterBinding.g;
                Intrinsics.checkNotNullExpressionValue(imageView11, "ivIcon3");
                ImageView imageView12 = dialogPropLetterBinding.c;
                Intrinsics.checkNotNullExpressionValue(imageView12, "ivGeneType3");
                setGiftItem(null, imageView11, imageView12);
            }
            if (size <= 3) {
                ImageView imageView13 = dialogPropLetterBinding.h;
                Intrinsics.checkNotNullExpressionValue(imageView13, "ivIcon4");
                ImageView imageView14 = dialogPropLetterBinding.d;
                Intrinsics.checkNotNullExpressionValue(imageView14, "ivGeneType4");
                setGiftItem(null, imageView13, imageView14);
                return;
            }
            GiftBean giftBean4 = arrayList.get(3);
            ImageView imageView15 = dialogPropLetterBinding.h;
            Intrinsics.checkNotNullExpressionValue(imageView15, "ivIcon4");
            ImageView imageView16 = dialogPropLetterBinding.d;
            Intrinsics.checkNotNullExpressionValue(imageView16, "ivGeneType4");
            setGiftItem(giftBean4, imageView15, imageView16);
        }
    }

    private final void setGiftItem(GiftBean item, ImageView icon, ImageView gene) {
        if (item == null) {
            icon.setVisibility(8);
            gene.setVisibility(8);
            return;
        }
        icon.setVisibility(0);
        gene.setVisibility(0);
        Glide.with(icon).load(item.getGiftImg()).diskCacheStrategy(DiskCacheStrategy.ALL).into(icon);
        int giftType = item.getGiftType();
        if (giftType != 1) {
            if (giftType != 2) {
                gene.setVisibility(8);
                return;
            } else {
                gene.setImageResource(tg9.f44915a.a(item.getGeneType()));
                return;
            }
        }
        Integer numB = tg9.f44915a.b(item.getGeneType());
        if (numB != null) {
            gene.setImageResource(numB.intValue());
        }
    }

    @Nullable
    public final NoticeBean getBean() {
        return this.bean;
    }

    @Nullable
    public final OnClickCallback getCallback() {
        return this.callback;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_prop_letter), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(\n     …m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return fx7.h() - cr2.c(getContext(), 230.0f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        NoticeBean noticeBean = arguments != null ? (NoticeBean) arguments.getParcelable(NOTICE_MESSAGE) : null;
        this.bean = noticeBean;
        if (noticeBean != null) {
            ((PropLetterVM) ((BaseVMDialogFragment) this).mState).j().setValue(noticeBean.getNoticeTitle());
            ((PropLetterVM) ((BaseVMDialogFragment) this).mState).h().setValue(noticeBean.getSubContent());
            ((PropLetterVM) ((BaseVMDialogFragment) this).mState).i().setValue(Boolean.valueOf(noticeBean.getReceiveType()));
            initGift();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        ((PropLetterVM) ((BaseVMDialogFragment) this).mState).g.observe(this, new c(new Function1<DialogFragment, Unit>() { // from class: com.huachenjie.social_contact.dialog.PropLetterDialog.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialogFragment) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable DialogFragment dialogFragment) {
                if (dialogFragment != null) {
                    PropLetterDialog propLetterDialog = PropLetterDialog.this;
                    OnClickCallback callback = propLetterDialog.getCallback();
                    if (callback != null) {
                        callback.a();
                    }
                    dialogFragment.show(propLetterDialog.getChildFragmentManager(), ys8.c("dialog_%d", Long.valueOf(System.currentTimeMillis())));
                }
            }
        }));
    }

    public final void setBean(@Nullable NoticeBean noticeBean) {
        this.bean = noticeBean;
    }

    public final void setCallback(@Nullable OnClickCallback onClickCallback) {
        this.callback = onClickCallback;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public void setStyle() {
        setStyle(1, com.huachenjie.common.R.style.SignalTowerDialogStyle);
    }
}
