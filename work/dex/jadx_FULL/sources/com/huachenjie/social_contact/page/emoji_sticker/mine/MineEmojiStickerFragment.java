package com.huachenjie.social_contact.page.emoji_sticker.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerFragment;
import com.zj.adlib.ft1;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.p03;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u000f\u001a\u00020\u0003H\u0014J\u0006\u0010\u0010\u001a\u00020\u0003¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerSubVM;", "", "initAdapter", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "item", "showDeleteCreateConfirmBox", "showDeleteCreateConfirmBoxSub", "showDeleteOwnConfirmBox", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "refreshData", "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class MineEmojiStickerFragment extends BaseVMFragment<MineEmojiStickerSubVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMOJI_STICKER_TYPE = "emojiStickerType";

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerFragment$a;", "", "", "type", "Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerFragment;", "a", "", "EMOJI_STICKER_TYPE", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MineEmojiStickerFragment a(int type) {
            MineEmojiStickerFragment mineEmojiStickerFragment = new MineEmojiStickerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MineEmojiStickerFragment.EMOJI_STICKER_TYPE, type);
            mineEmojiStickerFragment.setArguments(bundle);
            return mineEmojiStickerFragment;
        }
    }

    private final void initAdapter() {
        final EmojiStickerAdapter<MultiItemEntity> value = ((MineEmojiStickerSubVM) ((BaseVMFragment) this).mState).n().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.jp5
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MineEmojiStickerFragment.initAdapter$lambda$3$lambda$0(value, baseQuickAdapter, view, i);
                }
            });
            int i = R.id.v_bottom_first;
            value.addChildClickViewIds(i, R.id.v_bottom_second);
            value.addChildClickViewIds(i);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.kp5
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    MineEmojiStickerFragment.initAdapter$lambda$3$lambda$2(value, this, baseQuickAdapter, view, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$0(EmojiStickerAdapter emojiStickerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MultiItemEntity multiItemEntity;
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() == 2 && (multiItemEntity = (MultiItemEntity) emojiStickerAdapter.getData().get(i)) != null && (multiItemEntity instanceof EmojiStickerBean)) {
            EmojiStickerBean emojiStickerBean = (EmojiStickerBean) multiItemEntity;
            if (emojiStickerBean.getAuidtStatus() == 2 && emojiStickerBean.getIllegalStatus() == 2) {
                p03.f43868a.a(emojiStickerAdapter.getContext(), emojiStickerBean, 2);
            } else {
                p03.f43868a.a(emojiStickerAdapter.getContext(), emojiStickerBean, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(EmojiStickerAdapter emojiStickerAdapter, MineEmojiStickerFragment mineEmojiStickerFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MultiItemEntity multiItemEntity;
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(mineEmojiStickerFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() == 2 && (multiItemEntity = (MultiItemEntity) emojiStickerAdapter.getData().get(i)) != null && (multiItemEntity instanceof EmojiStickerBean)) {
            EmojiStickerBean emojiStickerBean = (EmojiStickerBean) multiItemEntity;
            int id = view.getId();
            if (id == R.id.v_bottom_first) {
                int itemStatusType = emojiStickerBean.getItemStatusType();
                if (itemStatusType == 2) {
                    mineEmojiStickerFragment.showDeleteCreateConfirmBox(emojiStickerBean);
                    return;
                } else {
                    if (itemStatusType != 3) {
                        return;
                    }
                    mineEmojiStickerFragment.showDeleteOwnConfirmBox(emojiStickerBean);
                    return;
                }
            }
            if (id == R.id.v_bottom_second) {
                int itemStatusType2 = emojiStickerBean.getItemStatusType();
                if (itemStatusType2 != 2) {
                    if (itemStatusType2 != 3) {
                        return;
                    }
                    ShareEmojiFriendDialog.INSTANCE.a(emojiStickerBean.getEmojiBagCode(), emojiStickerBean.getEmojiBagName(), emojiStickerBean.formatEmojiUrl(0)).show(mineEmojiStickerFragment.getChildFragmentManager(), "LabelSelectDialog");
                } else {
                    Intent intent = new Intent(emojiStickerAdapter.getContext(), (Class<?>) CreateEmojiStickerActivity.class);
                    intent.putExtra("emojiStickerCode", emojiStickerBean.getEmojiBagCode());
                    mineEmojiStickerFragment.startActivity(intent);
                }
            }
        }
    }

    private final void showDeleteCreateConfirmBox(final EmojiStickerBean item) {
        ft1.g(getContext()).Q("确定删除创作的表情包吗？删除成功后将清除对应的永久楼层！").I(Color.parseColor("#FFFF3D3D")).J(new View.OnClickListener() { // from class: com.zj.adlib.gp5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEmojiStickerFragment.showDeleteCreateConfirmBox$lambda$4(this.f16834a, item, view);
            }
        }).F(OptionsPickerHelper.e).N("确定").Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteCreateConfirmBox$lambda$4(MineEmojiStickerFragment mineEmojiStickerFragment, EmojiStickerBean emojiStickerBean, View view) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerFragment, "this$0");
        Intrinsics.checkNotNullParameter(emojiStickerBean, "$item");
        mineEmojiStickerFragment.showDeleteCreateConfirmBoxSub(emojiStickerBean);
    }

    private final void showDeleteCreateConfirmBoxSub(final EmojiStickerBean item) {
        ft1.g(getContext()).Q("请再次确认是否删除该表情包？").O(Color.parseColor("#FFFF3D3D")).I(Color.parseColor("#FFFF3D3D")).J(new View.OnClickListener() { // from class: com.zj.adlib.hp5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEmojiStickerFragment.showDeleteCreateConfirmBoxSub$lambda$5(this.f17049a, item, view);
            }
        }).F(OptionsPickerHelper.e).N("确定").Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteCreateConfirmBoxSub$lambda$5(MineEmojiStickerFragment mineEmojiStickerFragment, EmojiStickerBean emojiStickerBean, View view) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerFragment, "this$0");
        Intrinsics.checkNotNullParameter(emojiStickerBean, "$item");
        ((MineEmojiStickerSubVM) ((BaseVMFragment) mineEmojiStickerFragment).mState).l(emojiStickerBean);
    }

    private final void showDeleteOwnConfirmBox(final EmojiStickerBean item) {
        ft1.g(getContext()).Q("确定删除下载的表情包吗？").I(Color.parseColor("#FFFF3D3D")).J(new View.OnClickListener() { // from class: com.zj.adlib.ip5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEmojiStickerFragment.showDeleteOwnConfirmBox$lambda$6(this.f17252a, item, view);
            }
        }).F(OptionsPickerHelper.e).N("确定").Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteOwnConfirmBox$lambda$6(MineEmojiStickerFragment mineEmojiStickerFragment, EmojiStickerBean emojiStickerBean, View view) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerFragment, "this$0");
        Intrinsics.checkNotNullParameter(emojiStickerBean, "$item");
        ((MineEmojiStickerSubVM) ((BaseVMFragment) mineEmojiStickerFragment).mState).k(emojiStickerBean);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragmnet_emoji_sticker_mine), Integer.valueOf(nk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt(EMOJI_STICKER_TYPE) : 1;
        initAdapter();
        ((MineEmojiStickerSubVM) ((BaseVMFragment) this).mState).getType().setValue(Integer.valueOf(i));
        ((MineEmojiStickerSubVM) ((BaseVMFragment) this).mState).s();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    public final void refreshData() {
        ((MineEmojiStickerSubVM) ((BaseVMFragment) this).mState).s();
    }
}
