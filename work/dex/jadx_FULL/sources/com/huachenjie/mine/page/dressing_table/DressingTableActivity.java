package com.huachenjie.mine.page.dressing_table;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.base.adapter.ViewPagerAdapter;
import com.huachenjie.base.util.CustomTabStyle;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.R;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.databinding.MineActivityDressingTableBinding;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameFragment;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.huachenjie.mine.page.dressing_table.tag.UserTagFragment;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ik0;
import com.zj.adlib.jj8;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.h.DRESS_TABLE)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010-J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nJ\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0002J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010*¨\u0006/"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/DressingTableActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mine/databinding/MineActivityDressingTableBinding;", "Lcom/huachenjie/mine/page/dressing_table/DressingTableVM;", "", "", "V", "getLayoutResID", "", "initView", "", "name", "d0", "slogan", "e0", "avatar", "b0", "", "selectTags", "f0", "k0", "j0", "levelList", "m0", "avatarFrameImgUrl", "c0", "Lcom/huachenjie/mine/bean/MineData;", "b", "Lkotlin/Lazy;", "h0", "()Lcom/huachenjie/mine/bean/MineData;", "mineData", "c", "i0", "()I", DressingTableActivity.x, "Lcom/huachenjie/base/util/CustomTabStyle;", "d", "g0", "()Lcom/huachenjie/base/util/CustomTabStyle;", "customTabStyle", "", "Ljava/util/List;", "flowViewIdList", "<init>", "()V", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDressingTableActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DressingTableActivity.kt\ncom/huachenjie/mine/page/dressing_table/DressingTableActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1855#2,2:183\n1855#2,2:185\n*S KotlinDebug\n*F\n+ 1 DressingTableActivity.kt\ncom/huachenjie/mine/page/dressing_table/DressingTableActivity\n*L\n111#1:183,2\n117#1:185,2\n*E\n"})
public final class DressingTableActivity extends BaseMVVMActivity<MineActivityDressingTableBinding, DressingTableVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "userData";

    @NotNull
    public static final String x = "selectedIndex";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy mineData = LazyKt.lazy(new Function0<MineData>() { // from class: com.huachenjie.mine.page.dressing_table.DressingTableActivity$mineData$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MineData m591invoke() {
            Intent intent = this.this$0.getIntent();
            MineData mineData = intent != null ? (MineData) intent.getParcelableExtra("userData") : null;
            return mineData == null ? new MineData(null, null, null, null, null, null, null, null, null, 511, null) : mineData;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy selectedIndex = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mine.page.dressing_table.DressingTableActivity$selectedIndex$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m592invoke() {
            Intent intent = this.this$0.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra(DressingTableActivity.x, 0) : 0);
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy customTabStyle = LazyKt.lazy(new Function0<CustomTabStyle>() { // from class: com.huachenjie.mine.page.dressing_table.DressingTableActivity$customTabStyle$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CustomTabStyle m590invoke() {
            return new CustomTabStyle();
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Integer> flowViewIdList = new ArrayList();

    /* JADX INFO: renamed from: com.huachenjie.mine.page.dressing_table.DressingTableActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/DressingTableActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/mine/bean/MineData;", "data", "", "index", "", "a", "", "SELECTED_INDEX", "Ljava/lang/String;", "USER_DATA", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull MineData data, int index) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) DressingTableActivity.class);
            intent.putExtra("userData", data);
            intent.putExtra(DressingTableActivity.x, index);
            context.startActivity(intent);
        }
    }

    public static final void l0(DressingTableActivity dressingTableActivity, View view) {
        Intrinsics.checkNotNullParameter(dressingTableActivity, "this$0");
        dressingTableActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, DressingTableVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()));
    }

    public final void b0(@NotNull String avatar) {
        MineData value;
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        if (TextUtils.isEmpty(avatar) || (value = getMViewModel().i().getValue()) == null) {
            return;
        }
        value.setAvatar(avatar);
        getMViewModel().i().setValue(value);
    }

    public final void c0(String avatarFrameImgUrl) {
        MineData value = getMViewModel().i().getValue();
        if (value == null) {
            return;
        }
        value.setAvatarFrameImgUrl(avatarFrameImgUrl);
        getMViewModel().i().setValue(value);
    }

    public final void d0(@NotNull String name) {
        MineData value;
        Intrinsics.checkNotNullParameter(name, "name");
        if (TextUtils.isEmpty(name) || (value = getMViewModel().i().getValue()) == null) {
            return;
        }
        value.setNickName(name);
        getMViewModel().i().setValue(value);
    }

    public final void e0(@NotNull String slogan) {
        MineData value;
        Intrinsics.checkNotNullParameter(slogan, "slogan");
        if (TextUtils.isEmpty(slogan) || (value = getMViewModel().i().getValue()) == null) {
            return;
        }
        value.setSlogan(slogan);
        getMViewModel().i().setValue(value);
    }

    public final void f0(@NotNull List<String> selectTags) {
        Intrinsics.checkNotNullParameter(selectTags, "selectTags");
        MineData value = getMViewModel().i().getValue();
        if (value != null) {
            value.setTagList(selectTags);
            m0(selectTags);
        } else {
            value = null;
        }
        getMViewModel().i().setValue(value);
    }

    public final CustomTabStyle g0() {
        return (CustomTabStyle) this.customTabStyle.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_activity_dressing_table;
    }

    public final MineData h0() {
        return (MineData) this.mineData.getValue();
    }

    public final int i0() {
        return ((Number) this.selectedIndex.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        k0();
        getMViewModel().i().setValue(h0());
        m0(h0().getTagList());
        j0();
    }

    public final void j0() {
        String nickName;
        String slogan;
        String avatar;
        MineActivityDressingTableBinding mBinding = getMBinding();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(supportFragmentManager);
        mBinding.f11174a.setAdapter(viewPagerAdapter);
        List<String> listListOf = CollectionsKt.listOf(new String[]{"昵称", "签名", "头像", "头像框", "标签"});
        BaseMVVMFragment[] baseMVVMFragmentArr = new BaseMVVMFragment[5];
        NicknameFragment.Companion bVar = NicknameFragment.INSTANCE;
        MineData value = getMViewModel().i().getValue();
        String str = "";
        if (value == null || (nickName = value.getNickName()) == null) {
            nickName = "";
        }
        baseMVVMFragmentArr[0] = bVar.a(nickName);
        SignatureFragment.Companion bVar2 = SignatureFragment.INSTANCE;
        MineData value2 = getMViewModel().i().getValue();
        if (value2 == null || (slogan = value2.getSlogan()) == null) {
            slogan = "";
        }
        baseMVVMFragmentArr[1] = bVar2.a(slogan);
        AvatarFragment.Companion bVar3 = AvatarFragment.INSTANCE;
        MineData value3 = getMViewModel().i().getValue();
        if (value3 != null && (avatar = value3.getAvatar()) != null) {
            str = avatar;
        }
        baseMVVMFragmentArr[2] = bVar3.a(str);
        baseMVVMFragmentArr[3] = AvatarFrameFragment.INSTANCE.a(new DressingTableActivity$initTab$1$fragmentArray$1(this));
        baseMVVMFragmentArr[4] = UserTagFragment.INSTANCE.a();
        List<? extends Fragment> listMutableListOf = CollectionsKt.mutableListOf(baseMVVMFragmentArr);
        mBinding.f11174a.setOffscreenPageLimit(listListOf.size());
        viewPagerAdapter.a(listListOf, listMutableListOf);
        mBinding.f11175a.setViewPager(mBinding.f11174a, listListOf);
        CustomTabStyle customTabStyleG0 = g0();
        SlidingTabLayout slidingTabLayout = mBinding.f11175a;
        Intrinsics.checkNotNullExpressionValue(slidingTabLayout, "tabLayout");
        CustomTabStyle.f(customTabStyleG0, slidingTabLayout, mBinding.f11174a, null, 0, 12, null);
    }

    public final void k0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ = getMViewModel().j();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataJ.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(0).setTitleName("装扮台").setTitleTextColor(zn1.a(com.huachenjie.channel.R.color.hcj_header_txt)).setBackIconResId(com.huachenjie.channel.R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pr2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DressingTableActivity.l0(this.f44048a, view);
            }
        }));
    }

    public final void m0(List<String> levelList) {
        LinearLayout linearLayout = getMBinding().f11170a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.llTags");
        Iterator<T> it = this.flowViewIdList.iterator();
        while (it.hasNext()) {
            View viewFindViewById = linearLayout.findViewById(((Number) it.next()).intValue());
            if (viewFindViewById != null) {
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(id)");
                linearLayout.removeView(viewFindViewById);
            }
        }
        this.flowViewIdList.clear();
        for (String str : levelList) {
            TextView textView = new TextView(linearLayout.getContext());
            textView.setId(View.generateViewId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, jj8.a(20.0f));
            layoutParams.setMarginEnd(jj8.a(4.0f));
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            int iA = jj8.a(8.0f);
            textView.setPadding(iA, 0, iA, 0);
            textView.setText(str);
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            textView.setBackground(new DrawableCreator.Builder().setSolidColor(-16777216).setCornersRadius(jj8.a(10.0f)).build());
            this.flowViewIdList.add(Integer.valueOf(textView.getId()));
            linearLayout.addView(textView);
        }
    }
}
