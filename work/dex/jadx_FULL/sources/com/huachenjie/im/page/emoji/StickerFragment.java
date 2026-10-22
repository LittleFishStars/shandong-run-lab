package com.huachenjie.im.page.emoji;

import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiBean;
import com.huachenjie.im.page.emoji.StickerFragment;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0003H\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/im/page/emoji/StickerVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initDataAfterView", "Lcom/huachenjie/im/page/emoji/StickerFragment$SendCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/im/page/emoji/StickerFragment$SendCallback;", "<init>", "()V", "Companion", "a", "SendCallback", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class StickerFragment extends BaseVMFragment<StickerVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EMOJI_CODE = "emojiCode";

    @Nullable
    private SendCallback callback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerFragment$SendCallback;", "", "", "url", "", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
    public interface SendCallback {
        void a(@NotNull String url);
    }

    /* JADX INFO: renamed from: com.huachenjie.im.page.emoji.StickerFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerFragment$a;", "", "", StickerFragment.EMOJI_CODE, "Lcom/huachenjie/im/page/emoji/StickerFragment$SendCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/im/page/emoji/StickerFragment;", "a", "EMOJI_CODE", "Ljava/lang/String;", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StickerFragment a(@NotNull String emojiCode, @NotNull SendCallback callback) {
            Intrinsics.checkNotNullParameter(emojiCode, StickerFragment.EMOJI_CODE);
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            StickerFragment stickerFragment = new StickerFragment();
            stickerFragment.callback = callback;
            Bundle bundle = new Bundle();
            bundle.putString(StickerFragment.EMOJI_CODE, emojiCode);
            stickerFragment.setArguments(bundle);
            return stickerFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataAfterView$lambda$2$lambda$1(StickerFragment stickerFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<EmojiBean> data;
        EmojiBean emojiBean;
        SendCallback sendCallback;
        Intrinsics.checkNotNullParameter(stickerFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        StickerAdapter value = ((StickerVM) ((BaseVMFragment) stickerFragment).mState).h().getValue();
        if (value == null || (data = value.getData()) == null || (emojiBean = data.get(i)) == null || (sendCallback = stickerFragment.callback) == null) {
            return;
        }
        sendCallback.a(emojiBean.getImgUrl());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @Nullable
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_sticker), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(EMOJI_CODE)) == null) {
            string = "";
        }
        ((StickerVM) ((BaseVMFragment) this).mState).j(string);
        StickerAdapter value = ((StickerVM) ((BaseVMFragment) this).mState).h().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.sr8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    StickerFragment.initDataAfterView$lambda$2$lambda$1(this.f44759a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }
}
