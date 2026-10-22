package com.huachenjie.im.page.emoji;

import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.im.R;
import com.huachenjie.im.databinding.FragmentEmojiBinding;
import com.zj.adlib.i62;
import com.zj.adlib.yk0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "onResume", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initDataAfterView", "", "enabled", "changeDeleteButton", "Lcom/huachenjie/base/widget/input_panel/emoji/EmojiPanelView$EmojiCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/base/widget/input_panel/emoji/EmojiPanelView$EmojiCallback;", "<init>", "()V", "Companion", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiFragment extends BaseVMFragment<BaseVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private EmojiPanelView.EmojiCallback callback;

    /* JADX INFO: renamed from: com.huachenjie.im.page.emoji.EmojiFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiFragment$a;", "", "Lcom/huachenjie/base/widget/input_panel/emoji/EmojiPanelView$EmojiCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/im/page/emoji/EmojiFragment;", "a", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmojiFragment a(@NotNull EmojiPanelView.EmojiCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            EmojiFragment emojiFragment = new EmojiFragment();
            emojiFragment.callback = callback;
            return emojiFragment;
        }
    }

    public final void changeDeleteButton(boolean enabled) {
        FragmentEmojiBinding fragmentEmojiBinding = (FragmentEmojiBinding) getBinding();
        if (fragmentEmojiBinding != null) {
            fragmentEmojiBinding.f34419a.changeDeleteButton(enabled);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @Nullable
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_emoji), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        FragmentEmojiBinding fragmentEmojiBinding = (FragmentEmojiBinding) getBinding();
        if (fragmentEmojiBinding != null) {
            fragmentEmojiBinding.f34419a.setCallback(this.callback);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentEmojiBinding fragmentEmojiBinding = (FragmentEmojiBinding) getBinding();
        if (fragmentEmojiBinding != null) {
            fragmentEmojiBinding.f34419a.fixVisibleRect();
        }
    }
}
