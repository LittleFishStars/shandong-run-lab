package com.huachenjie.social_contact.page.emoji_sticker.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.broadcast.emoji.EmojiStickerListener;
import com.huachenjie.base.broadcast.emoji.EmojiStickerReceiver;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerSearchBinding;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerActivity;
import com.zj.adlib.bw9;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.o03;
import com.zj.adlib.p03;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0014J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerVM;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "onResume", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "init", "e0", "initViewModel", "Landroid/view/View;", "view", "checkInputAndSearch", "", "", "", "a", "Ljava/util/Map;", "changeEmojiCodeMap", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "mReceiver", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class SearchEmojiStickerActivity extends BaseVmActivity<SearchEmojiStickerVM> {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Map<String, Boolean> changeEmojiCodeMap = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final EmojiStickerReceiver mReceiver = new EmojiStickerReceiver(new b());

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "c", "<init>", "(Lcom/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ((SearchEmojiStickerVM) ((BaseVmActivity) SearchEmojiStickerActivity.this).f8507a).p().setValue("");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SearchEmojiStickerActivity.this.finish();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SearchEmojiStickerActivity.this.checkInputAndSearch(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerActivity$b", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerListener;", "", "emojiStickerCode", "", "c", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements EmojiStickerListener {
        public b() {
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void b(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            SearchEmojiStickerActivity.this.changeEmojiCodeMap.put(emojiStickerCode, Boolean.TRUE);
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void c(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            SearchEmojiStickerActivity.this.changeEmojiCodeMap.put(emojiStickerCode, Boolean.FALSE);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36282a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36282a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36282a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36282a.invoke(obj);
        }
    }

    public static final boolean k0(SearchEmojiStickerActivity searchEmojiStickerActivity, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(searchEmojiStickerActivity, "this$0");
        if (i != 3) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(textView, "view");
        searchEmojiStickerActivity.checkInputAndSearch(textView);
        return true;
    }

    public static final void l0(EmojiStickerAdapter emojiStickerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() != 2) {
            return;
        }
        List<T> data = emojiStickerAdapter.getData();
        MultiItemEntity multiItemEntity = data != 0 ? (MultiItemEntity) data.get(i) : null;
        if (multiItemEntity == null || !(multiItemEntity instanceof EmojiStickerBean)) {
            return;
        }
        p03.f43868a.a(emojiStickerAdapter.getContext(), (EmojiStickerBean) multiItemEntity, 2);
    }

    public static final void m0(EmojiStickerAdapter emojiStickerAdapter, SearchEmojiStickerActivity searchEmojiStickerActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(searchEmojiStickerActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() != 2) {
            return;
        }
        List<T> data = emojiStickerAdapter.getData();
        MultiItemEntity multiItemEntity = data != 0 ? (MultiItemEntity) data.get(i) : null;
        if (multiItemEntity == null || !(multiItemEntity instanceof EmojiStickerBean)) {
            return;
        }
        if (view.getId() == R.id.v_bottom_first) {
            EmojiStickerBean emojiStickerBean = (EmojiStickerBean) multiItemEntity;
            if (emojiStickerBean.getItemStatusType() == 4) {
                ((SearchEmojiStickerVM) ((BaseVmActivity) searchEmojiStickerActivity).f8507a).k(emojiStickerBean, i);
                return;
            }
        }
        if (view.getId() == R.id.v_bottom_second) {
            EmojiStickerBean emojiStickerBean2 = (EmojiStickerBean) multiItemEntity;
            ShareEmojiFriendDialog.INSTANCE.a(emojiStickerBean2.getEmojiBagCode(), emojiStickerBean2.getEmojiBagName(), emojiStickerBean2.formatEmojiUrl(0)).show(searchEmojiStickerActivity.getSupportFragmentManager(), "LabelSelectDialog");
        }
    }

    public final void checkInputAndSearch(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (TextUtils.isEmpty(((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).p().getValue())) {
            fv5.b("请输入表情包名称");
        } else {
            ((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).t();
            KeyboardUtils.k(view);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).x1("#FFFFFF").G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_emoji_sticker_search), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ActivityEmojiStickerSearchBinding activityEmojiStickerSearchBinding = (ActivityEmojiStickerSearchBinding) getBinding();
        if (activityEmojiStickerSearchBinding != null) {
            activityEmojiStickerSearchBinding.f36083a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.sx7
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return SearchEmojiStickerActivity.k0(this.f44805a, textView, i, keyEvent);
                }
            });
            KeyboardUtils.s(activityEmojiStickerSearchBinding.f36083a);
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = activityEmojiStickerSearchBinding.f12720a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "emojiRecyclerView");
            bw9Var.d(recyclerView);
        }
        final EmojiStickerAdapter<MultiItemEntity> value = ((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.tx7
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    SearchEmojiStickerActivity.l0(value, baseQuickAdapter, view, i);
                }
            });
            value.addChildClickViewIds(R.id.v_bottom_first, R.id.v_bottom_second);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ux7
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    SearchEmojiStickerActivity.m0(value, this, baseQuickAdapter, view, i);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).p().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                ((SearchEmojiStickerVM) ((BaseVmActivity) SearchEmojiStickerActivity.this).f8507a).o().setValue(Boolean.valueOf(!TextUtils.isEmpty(str)));
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o03.f43639a.a(this, this.mReceiver);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        o03.f43639a.e(this, this.mReceiver);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue() == null) {
            if (((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue() == null) {
                i4a.a("adapter is null ");
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value = ((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
            if ((value != null ? value.getData() : null) == null) {
                i4a.a("adapter data is null ");
                return;
            }
        }
        EmojiStickerAdapter<MultiItemEntity> value2 = ((SearchEmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
        if (value2 != null) {
            if (this.changeEmojiCodeMap.isEmpty()) {
                i4a.a("changeEmojiCodeMap data is null ");
                return;
            }
            for (T t : value2.getData()) {
                if (t instanceof EmojiStickerBean) {
                    EmojiStickerBean emojiStickerBean = (EmojiStickerBean) t;
                    Boolean bool = this.changeEmojiCodeMap.get(emojiStickerBean.getEmojiBagCode());
                    if (bool != null) {
                        emojiStickerBean.setDownloadFlag(bool.booleanValue());
                        if (emojiStickerBean.getDownloadFlag()) {
                            emojiStickerBean.setItemStatusType(5);
                        } else {
                            emojiStickerBean.setItemStatusType(4);
                        }
                    }
                }
            }
            this.changeEmojiCodeMap.clear();
            value2.notifyDataSetChanged();
        }
    }
}
