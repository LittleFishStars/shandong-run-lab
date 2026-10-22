package com.huachenjie.social_contact.page.emoji_sticker.mine;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.e;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.broadcast.emoji.EmojiStickerListener;
import com.huachenjie.base.broadcast.emoji.EmojiStickerReceiver;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerMineBinding;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerActivity;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.o03;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.k)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerVM;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "init", "initViewModel", "j0", "i0", "", "Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerFragment;", "c", "Ljava/util/List;", "fragmentArray", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "a", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "mReceiver", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class MineEmojiStickerActivity extends BaseVmActivity<MineEmojiStickerVM> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<MineEmojiStickerFragment> fragmentArray = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final EmojiStickerReceiver mReceiver = new EmojiStickerReceiver(new a());

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerActivity$a", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerListener;", "", "emojiStickerCode", "", "c", "b", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements EmojiStickerListener {
        public a() {
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void a(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            MineEmojiStickerFragment mineEmojiStickerFragment = (MineEmojiStickerFragment) MineEmojiStickerActivity.this.fragmentArray.get(0);
            if (mineEmojiStickerFragment != null) {
                mineEmojiStickerFragment.refreshData();
            }
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void b(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            MineEmojiStickerFragment mineEmojiStickerFragment = (MineEmojiStickerFragment) MineEmojiStickerActivity.this.fragmentArray.get(1);
            if (mineEmojiStickerFragment != null) {
                mineEmojiStickerFragment.refreshData();
            }
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void c(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
        }
    }

    public static final void k0(MineEmojiStickerActivity mineEmojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerActivity, "this$0");
        mineEmojiStickerActivity.finish();
    }

    public static final void l0(MineEmojiStickerActivity mineEmojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerActivity, "this$0");
        mineEmojiStickerActivity.startActivity(new Intent(mineEmojiStickerActivity.getContext(), (Class<?>) CreateEmojiStickerActivity.class));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_emoji_sticker_mine), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a);
    }

    public final void i0() {
        ActivityEmojiStickerMineBinding activityEmojiStickerMineBinding = (ActivityEmojiStickerMineBinding) getBinding();
        if (activityEmojiStickerMineBinding != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
            activityEmojiStickerMineBinding.f36081a.setAdapter(viewPagerAdapter);
            List<String> listListOf = CollectionsKt.listOf(new String[]{"我的表情", "我下载的"});
            MineEmojiStickerFragment.Companion aVar = MineEmojiStickerFragment.INSTANCE;
            this.fragmentArray = CollectionsKt.mutableListOf(new MineEmojiStickerFragment[]{aVar.a(1), aVar.a(2)});
            activityEmojiStickerMineBinding.f36081a.setOffscreenPageLimit(listListOf.size());
            viewPagerAdapter.a(listListOf, this.fragmentArray);
            activityEmojiStickerMineBinding.f12712a.setViewPager(activityEmojiStickerMineBinding.f36081a, listListOf);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        j0();
        i0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((MineEmojiStickerVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean rightIconClick = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("我的表情包").setTitleTextColor(Color.parseColor("#FF2C3E50")).setBackground(Color.parseColor("#FFFFFF")).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(Color.parseColor("#FF2C3E50"))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ep5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEmojiStickerActivity.k0(this.f41491a, view);
            }
        }).setShowRightIcon(true).setRightIconResId(R.drawable.ic_emoji_sticker_add).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.fp5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineEmojiStickerActivity.l0(this.f41725a, view);
            }
        });
        e.p3(this).G2(R.color.transparent).T2(true).x1("#FFFFFF").G1(true).a1();
        ((MineEmojiStickerVM) ((BaseVmActivity) this).f8507a).h().setValue(rightIconClick);
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
}
