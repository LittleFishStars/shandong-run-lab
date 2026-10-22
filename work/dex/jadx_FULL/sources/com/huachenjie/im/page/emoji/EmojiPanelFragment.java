package com.huachenjie.im.page.emoji;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.adapter.ViewPager2Adapter;
import com.huachenjie.base.broadcast.emoji.EmojiStickerListener;
import com.huachenjie.base.broadcast.emoji.EmojiStickerReceiver;
import com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiItemData;
import com.huachenjie.im.databinding.FragmentEmojiPanelBinding;
import com.huachenjie.im.page.emoji.EmojiPanelFragment;
import com.zj.adlib.bw9;
import com.zj.adlib.i62;
import com.zj.adlib.o03;
import com.zj.adlib.yk0;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001\u001b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/im/page/emoji/EmojiPanelVM;", "Landroid/content/Context;", "context", "", "onAttach", "onDetach", "onResume", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initDataAfterView", "", "enabled", "changeDeleteButton", "Lcom/huachenjie/im/page/emoji/EmojiFragment;", "emojiFragment", "Lcom/huachenjie/im/page/emoji/EmojiFragment;", "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "mReceiver", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "needRefreshOnResume", "Z", "com/huachenjie/im/page/emoji/EmojiPanelFragment$c", "emojiCallback", "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment$c;", "<init>", "()V", "Companion", "a", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEmojiPanelFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmojiPanelFragment.kt\ncom/huachenjie/im/page/emoji/EmojiPanelFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,184:1\n1#2:185\n*E\n"})
public final class EmojiPanelFragment extends BaseVMFragment<EmojiPanelVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private EmojiInputCallback callback;

    @Nullable
    private EmojiFragment emojiFragment;
    private boolean needRefreshOnResume;

    @NotNull
    private final EmojiStickerReceiver mReceiver = new EmojiStickerReceiver(new d());

    @NotNull
    private final c emojiCallback = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiPanelFragment$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;)V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.SocialContact.j).navigation();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.SocialContact.k).navigation();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.im.page.emoji.EmojiPanelFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiPanelFragment$b;", "", "Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/im/page/emoji/EmojiPanelFragment;", "a", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmojiPanelFragment a(@NotNull EmojiInputCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            EmojiPanelFragment emojiPanelFragment = new EmojiPanelFragment();
            emojiPanelFragment.callback = callback;
            return emojiPanelFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/im/page/emoji/EmojiPanelFragment$c", "Lcom/huachenjie/base/widget/input_panel/emoji/EmojiPanelView$EmojiCallback;", "", "emoji", "", "onEmojiSelected", "Landroid/view/KeyEvent;", "keyEventDown", "keyEventUp", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements EmojiPanelView.EmojiCallback {
        public c() {
        }

        @Override // com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView.EmojiCallback
        public void a(@NotNull KeyEvent keyEventDown, @NotNull KeyEvent keyEventUp) {
            Intrinsics.checkNotNullParameter(keyEventDown, "keyEventDown");
            Intrinsics.checkNotNullParameter(keyEventUp, "keyEventUp");
            EmojiInputCallback emojiInputCallback = EmojiPanelFragment.this.callback;
            if (emojiInputCallback != null) {
                emojiInputCallback.a(keyEventDown, keyEventUp);
            }
        }

        @Override // com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView.EmojiCallback
        public void onEmojiSelected(@Nullable String emoji) {
            EmojiInputCallback emojiInputCallback;
            if (emoji == null || (emojiInputCallback = EmojiPanelFragment.this.callback) == null) {
                return;
            }
            emojiInputCallback.b(emoji);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/im/page/emoji/EmojiPanelFragment$d", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerListener;", "", "emojiStickerCode", "", "c", "b", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements EmojiStickerListener {
        public d() {
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void b(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            EmojiPanelFragment.this.needRefreshOnResume = true;
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void c(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            EmojiPanelFragment.this.needRefreshOnResume = true;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34574a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34574a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34574a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34574a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataAfterView$lambda$3$lambda$2(FragmentEmojiPanelBinding fragmentEmojiPanelBinding, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(fragmentEmojiPanelBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        fragmentEmojiPanelBinding.f9688a.setCurrentItem(i);
    }

    public final void changeDeleteButton(boolean enabled) {
        EmojiFragment emojiFragment = this.emojiFragment;
        if (emojiFragment != null) {
            emojiFragment.changeDeleteButton(enabled);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @Nullable
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_emoji_panel), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(yk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        this.needRefreshOnResume = true;
        ((EmojiPanelVM) ((BaseVMFragment) this).mState).l().setValue(new ViewPager2Adapter(this));
        final FragmentEmojiPanelBinding fragmentEmojiPanelBinding = (FragmentEmojiPanelBinding) getBinding();
        if (fragmentEmojiPanelBinding != null) {
            fragmentEmojiPanelBinding.f9688a.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.huachenjie.im.page.emoji.EmojiPanelFragment$initDataAfterView$1$1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int position) {
                    StickerItemAdapter value = ((EmojiPanelVM) ((BaseVMFragment) this.f9903a).mState).i().getValue();
                    if (value != null) {
                        value.e(position);
                    }
                    fragmentEmojiPanelBinding.f34421a.scrollToPosition(position);
                }
            });
            StickerItemAdapter value = ((EmojiPanelVM) ((BaseVMFragment) this).mState).i().getValue();
            if (value != null) {
                value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.tz2
                    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                        EmojiPanelFragment.initDataAfterView$lambda$3$lambda$2(fragmentEmojiPanelBinding, baseQuickAdapter, view, i);
                    }
                });
            }
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = fragmentEmojiPanelBinding.f34421a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "emojiRecyclerView");
            bw9Var.d(recyclerView);
            ViewPager2 viewPager2 = fragmentEmojiPanelBinding.f9688a;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "emojiViewPager");
            bw9Var.g(viewPager2);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((EmojiPanelVM) ((BaseVMFragment) this).mState).k().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.im.page.emoji.EmojiPanelFragment.initViewModel.1

            /* JADX INFO: renamed from: com.huachenjie.im.page.emoji.EmojiPanelFragment$initViewModel$1$a */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/im/page/emoji/EmojiPanelFragment$initViewModel$1$a", "Lcom/huachenjie/im/page/emoji/StickerFragment$SendCallback;", "", "url", "", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements StickerFragment.SendCallback {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ EmojiPanelFragment f34576a;

                public a(EmojiPanelFragment emojiPanelFragment) {
                    this.f34576a = emojiPanelFragment;
                }

                @Override // com.huachenjie.im.page.emoji.StickerFragment.SendCallback
                public void a(@NotNull String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    EmojiInputCallback emojiInputCallback = this.f34576a.callback;
                    if (emojiInputCallback != null) {
                        emojiInputCallback.c(url);
                    }
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                ViewPager2Adapter value = ((EmojiPanelVM) ((BaseVMFragment) EmojiPanelFragment.this).mState).l().getValue();
                if (value != null) {
                    EmojiPanelFragment emojiPanelFragment = EmojiPanelFragment.this;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    emojiPanelFragment.emojiFragment = EmojiFragment.INSTANCE.a(emojiPanelFragment.emojiCallback);
                    EmojiFragment emojiFragment = emojiPanelFragment.emojiFragment;
                    Intrinsics.checkNotNull(emojiFragment);
                    arrayList.add(emojiFragment);
                    arrayList2.add(new EmojiItemData("-1", null, R.mipmap.ic_chat_emoji_icon, false, 10, null));
                    List<EmojiItemData> value2 = ((EmojiPanelVM) ((BaseVMFragment) emojiPanelFragment).mState).h().getValue();
                    if (value2 != null) {
                        Iterator<EmojiItemData> it = value2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(StickerFragment.INSTANCE.a(it.next().getEmojiBagCode(), new a(emojiPanelFragment)));
                        }
                        arrayList2.addAll(value2);
                    }
                    StickerItemAdapter value3 = ((EmojiPanelVM) ((BaseVMFragment) emojiPanelFragment).mState).i().getValue();
                    if (value3 != null) {
                        value3.setList(arrayList2);
                    }
                    value.g(arrayList);
                    FragmentEmojiPanelBinding fragmentEmojiPanelBinding = (FragmentEmojiPanelBinding) emojiPanelFragment.getBinding();
                    if (fragmentEmojiPanelBinding != null) {
                        fragmentEmojiPanelBinding.f9688a.setCurrentItem(0);
                    }
                }
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            o03.f43639a.a(activity, this.mReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            o03.f43639a.e(activity, this.mReceiver);
        }
        super.onDetach();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needRefreshOnResume) {
            this.needRefreshOnResume = false;
            ((EmojiPanelVM) ((BaseVMFragment) this).mState).m();
        }
    }
}
