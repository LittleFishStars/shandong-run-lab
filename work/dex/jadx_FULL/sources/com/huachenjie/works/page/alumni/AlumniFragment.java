package com.huachenjie.works.page.alumni;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import com.flyco.tablayout.SlideTabLayout;
import com.flyco.tablayout.listener.OnTabInterceptListener;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.broadcast.config.ConfigOperateReceiver;
import com.huachenjie.base.broadcast.find_alumni.FindAlumniListener;
import com.huachenjie.base.broadcast.find_alumni.FindAlumniReceiver;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.SchoolmateConfigBean;
import com.huachenjie.works.bean.SchoolmateGradeBean;
import com.huachenjie.works.databinding.WorksFragmentAlumniBinding;
import com.huachenjie.works.page.alumni.AlumniFragment;
import com.huachenjie.works.page.alumni.attention.AttentionFragment;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniDialog;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniFragment;
import com.huachenjie.works.page.alumni.recommend.RecommendFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.noober.background.view.BLView;
import com.zj.adlib.ai9;
import com.zj.adlib.dq1;
import com.zj.adlib.fe9;
import com.zj.adlib.i4a;
import com.zj.adlib.kq5;
import com.zj.adlib.qk0;
import com.zj.adlib.vs1;
import com.zj.adlib.yg3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0019J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020\u001b2\u0006\u00100\u001a\u00020%2\u0006\u0010 \u001a\u00020\u0019H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u0019H\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u00100\u001a\u00020%H\u0002J\u000e\u00106\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\rJ \u00107\u001a\u00020\u001b2\u0006\u00100\u001a\u00020%2\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/huachenjie/works/page/alumni/AlumniFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentAlumniBinding;", "Lcom/huachenjie/works/page/alumni/AlumniVM;", "()V", "findAlumniReceiver", "Lcom/huachenjie/base/broadcast/find_alumni/FindAlumniReceiver;", "getFindAlumniReceiver", "()Lcom/huachenjie/base/broadcast/find_alumni/FindAlumniReceiver;", "findAlumniReceiver$delegate", "Lkotlin/Lazy;", "mFragmentNames", "", "", "getMFragmentNames", "()Ljava/util/Map;", "mFragmentNames$delegate", "mTitleList", "", "receiver", "Lcom/huachenjie/base/broadcast/config/ConfigOperateReceiver;", "getReceiver", "()Lcom/huachenjie/base/broadcast/config/ConfigOperateReceiver;", "receiver$delegate", "statusBarDark", "", "checkCommonConfig", "", "checkSchoolmateConfig", "sourceType", "childSetTabDark", "tabName", "isDark", "createTabFragment", "Landroidx/fragment/app/Fragment;", "fragmentName", "getLayoutResID", "", "getVariables", "initData", "initDataObservable", "initTab", "config", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "initView", "onDestroyView", "onFragmentResume", "onTabSelected", "index", "onViewCreated", "setTabDark", "showDarkStatusBar", "isDarkFont", "switchFragment", "switchFragmentByName", "updateTabTextFont", "textSelectColor", "textUnselectColor", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAlumniFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlumniFragment.kt\ncom/huachenjie/works/page/alumni/AlumniFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,342:1\n1855#2,2:343\n*S KotlinDebug\n*F\n+ 1 AlumniFragment.kt\ncom/huachenjie/works/page/alumni/AlumniFragment\n*L\n233#1:343,2\n*E\n"})
public final class AlumniFragment extends BaseMVVMFragment<WorksFragmentAlumniBinding, AlumniVM> {

    /* JADX INFO: renamed from: receiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy receiver = LazyKt.lazy(new AlumniFragment$receiver$2(this));

    /* JADX INFO: renamed from: findAlumniReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy findAlumniReceiver = LazyKt.lazy(new Function0<FindAlumniReceiver>() { // from class: com.huachenjie.works.page.alumni.AlumniFragment$findAlumniReceiver$2

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/works/page/alumni/AlumniFragment$findAlumniReceiver$2$a", "Lcom/huachenjie/base/broadcast/find_alumni/FindAlumniListener;", "", "sourceType", "", "a", "works_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements FindAlumniListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlumniFragment f37147a;

            public a(AlumniFragment alumniFragment) {
                this.f37147a = alumniFragment;
            }

            @Override // com.huachenjie.base.broadcast.find_alumni.FindAlumniListener
            public void a(@NotNull String sourceType) {
                Intrinsics.checkNotNullParameter(sourceType, "sourceType");
                this.f37147a.checkSchoolmateConfig(sourceType);
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FindAlumniReceiver m831invoke() {
            return new FindAlumniReceiver(new a(this.this$0));
        }
    });
    private boolean statusBarDark = true;

    @NotNull
    private final List<String> mTitleList = new ArrayList();

    /* JADX INFO: renamed from: mFragmentNames$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFragmentNames = LazyKt.lazy(new Function0<Map<String, ? extends String>>() { // from class: com.huachenjie.works.page.alumni.AlumniFragment$mFragmentNames$2
        @NotNull
        public final Map<String, String> invoke() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to(fe9.a.HOT, "RecommendFragment"), TuplesKt.to(fe9.a.ATTENTION, "AttentionFragment"), TuplesKt.to(fe9.a.THIS_SCHOOL, "ThisSchoolFragment"), TuplesKt.to(fe9.a.FIND_ALUMNI, "FindAlumniFragment")});
        }
    });

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/works/page/alumni/AlumniFragment$a", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnTabSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlideTabLayout f37145a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlumniFragment f14847a;

        public a(SlideTabLayout slideTabLayout, AlumniFragment alumniFragment) {
            this.f37145a = slideTabLayout;
            this.f14847a = alumniFragment;
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            this.f37145a.setCurrentItem(position);
            this.f14847a.switchFragment(position);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37146a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37146a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37146a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37146a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentAlumniBinding access$getMBinding(AlumniFragment alumniFragment) {
        return alumniFragment.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCommonConfig() {
        CommonSwitchConfig commonSwitchConfigD = dq1.d();
        if (commonSwitchConfigD != null) {
            initTab(commonSwitchConfigD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSchoolmateConfig(String sourceType) {
        if (getMViewModel().i().getValue() == null) {
            return;
        }
        SchoolmateConfigBean value = getMViewModel().i().getValue();
        boolean z = false;
        if (value != null && value.getHasUserTag()) {
            z = true;
        }
        if (z) {
            return;
        }
        SchoolmateConfigBean value2 = getMViewModel().i().getValue();
        Intrinsics.checkNotNull(value2);
        value2.setHasUserTag(true);
        if (Intrinsics.areEqual(sourceType, yg3.SOURCE_TYPE_SETTINGS)) {
            getMViewModel().i().setValue(getMViewModel().i().getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Fragment createTabFragment(String fragmentName) {
        switch (fragmentName.hashCode()) {
            case -1704387828:
                if (fragmentName.equals("RecommendFragment")) {
                    return new RecommendFragment();
                }
                break;
            case -763582098:
                if (fragmentName.equals("AttentionFragment")) {
                    return new AttentionFragment();
                }
                break;
            case 657965991:
                if (fragmentName.equals("FindAlumniFragment")) {
                    FindAlumniFragment.Companion companion = FindAlumniFragment.INSTANCE;
                    SchoolmateConfigBean value = getMViewModel().i().getValue();
                    ArrayList<SchoolmateGradeBean> gradeList = value != null ? value.getGradeList() : null;
                    SchoolmateConfigBean value2 = getMViewModel().i().getValue();
                    return companion.a(gradeList, value2 != null ? value2.getTagList() : null);
                }
                break;
            case 1751242818:
                if (fragmentName.equals("ThisSchoolFragment")) {
                    return new ThisSchoolFragment();
                }
                break;
        }
        return new Fragment();
    }

    private final FindAlumniReceiver getFindAlumniReceiver() {
        return (FindAlumniReceiver) this.findAlumniReceiver.getValue();
    }

    private final Map<String, String> getMFragmentNames() {
        return (Map) this.mFragmentNames.getValue();
    }

    private final ConfigOperateReceiver getReceiver() {
        return (ConfigOperateReceiver) this.receiver.getValue();
    }

    private final void initTab(CommonSwitchConfig config) {
        final SlideTabLayout slideTabLayout;
        WorksFragmentAlumniBinding mBinding = getMBinding();
        if (mBinding == null || (slideTabLayout = mBinding.f14151a) == null) {
            return;
        }
        slideTabLayout.setOnTabInterceptListener(new OnTabInterceptListener() { // from class: com.zj.adlib.f50
            @Override // com.flyco.tablayout.listener.OnTabInterceptListener
            public final boolean a(int i) {
                return AlumniFragment.initTab$lambda$1(this.f41599a, i);
            }
        });
        slideTabLayout.setOnTabSelectListener(new a(slideTabLayout, this));
        this.mTitleList.clear();
        this.mTitleList.add(fe9.a.HOT);
        this.mTitleList.add(fe9.a.ATTENTION);
        if (config.getMySchoolEnable()) {
            this.mTitleList.add(fe9.a.THIS_SCHOOL);
        }
        this.mTitleList.add(fe9.a.FIND_ALUMNI);
        slideTabLayout.setTabTitles(this.mTitleList);
        final Ref.IntRef intRef = new Ref.IntRef();
        int iIndexOf = this.mTitleList.indexOf(fe9.a.HOT);
        intRef.element = iIndexOf;
        if (!(iIndexOf >= 0 && iIndexOf < this.mTitleList.size())) {
            intRef.element = 0;
        }
        switchFragment(intRef.element);
        slideTabLayout.post(new Runnable() { // from class: com.zj.adlib.g50
            @Override // java.lang.Runnable
            public final void run() {
                AlumniFragment.initTab$lambda$2(slideTabLayout, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initTab$lambda$1(AlumniFragment alumniFragment, int i) {
        Intrinsics.checkNotNullParameter(alumniFragment, "this$0");
        if (!TextUtils.equals(alumniFragment.getMFragmentNames().get(alumniFragment.mTitleList.get(i)), alumniFragment.getMFragmentNames().get(fe9.a.FIND_ALUMNI))) {
            return true;
        }
        SchoolmateConfigBean value = alumniFragment.getMViewModel().i().getValue();
        if (value == null) {
            alumniFragment.getMViewModel().k();
            return false;
        }
        if (value.getHasUserTag()) {
            return true;
        }
        FindAlumniDialog.Companion companion = FindAlumniDialog.INSTANCE;
        FragmentManager childFragmentManager = alumniFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, value.getTagList());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTab$lambda$2(SlideTabLayout slideTabLayout, Ref.IntRef intRef) {
        Intrinsics.checkNotNullParameter(slideTabLayout, "$tabLayout");
        Intrinsics.checkNotNullParameter(intRef, "$defaultPosition");
        slideTabLayout.setCurrentTab(intRef.element);
    }

    private final void onTabSelected(int index) {
        SlideTabLayout slideTabLayout;
        getMViewModel().j().setValue(Integer.valueOf(index));
        String str = getMFragmentNames().get(this.mTitleList.get(index));
        WorksFragmentAlumniBinding mBinding = getMBinding();
        if (((mBinding == null || (slideTabLayout = mBinding.f14151a) == null) ? -1 : slideTabLayout.getCurrentTab()) != index) {
            WorksFragmentAlumniBinding mBinding2 = getMBinding();
            SlideTabLayout slideTabLayout2 = mBinding2 != null ? mBinding2.f14151a : null;
            if (slideTabLayout2 != null) {
                slideTabLayout2.setCurrentTab(index);
            }
        }
        if (!TextUtils.equals(str, getMFragmentNames().get(fe9.a.THIS_SCHOOL))) {
            setTabDark(index, true);
            return;
        }
        kq5.b(getActivity(), "clickThisSchoolPage", MapsKt.mapOf(TuplesKt.to("schoolName", ai9.e().getSchoolName())));
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(getMFragmentNames().get(fe9.a.THIS_SCHOOL));
        if (fragmentFindFragmentByTag instanceof ThisSchoolFragment) {
            setTabDark(index, ((ThisSchoolFragment) fragmentFindFragmentByTag).getIsDark());
        }
    }

    private final void setTabDark(int index, boolean isDark) {
        SlideTabLayout slideTabLayout;
        BLView bLView;
        String str = index >= 0 && index < this.mTitleList.size() ? this.mTitleList.get(index) : "";
        this.statusBarDark = isDark;
        showDarkStatusBar(isDark);
        WorksFragmentAlumniBinding mBinding = getMBinding();
        if (mBinding == null || (slideTabLayout = mBinding.f14151a) == null) {
            return;
        }
        int color = isDark ? Color.parseColor("#FF191F20") : Color.parseColor("#FFFFFFFF");
        int color2 = isDark ? Color.parseColor("#FF191F20") : Color.parseColor("#FFFFFFFF");
        slideTabLayout.setTextColorValue(color, color2);
        if (!TextUtils.equals(str, fe9.a.THIS_SCHOOL)) {
            WorksFragmentAlumniBinding mBinding2 = getMBinding();
            bLView = mBinding2 != null ? mBinding2.f14153a : null;
            if (bLView != null) {
                bLView.setVisibility(0);
            }
        } else if (isDark) {
            WorksFragmentAlumniBinding mBinding3 = getMBinding();
            bLView = mBinding3 != null ? mBinding3.f14153a : null;
            if (bLView != null) {
                bLView.setVisibility(0);
            }
        } else {
            WorksFragmentAlumniBinding mBinding4 = getMBinding();
            bLView = mBinding4 != null ? mBinding4.f14153a : null;
            if (bLView != null) {
                bLView.setVisibility(8);
            }
        }
        updateTabTextFont(index, color, color2);
    }

    private final void showDarkStatusBar(boolean isDarkFont) {
        e.z3(this).G2(R.color.transparent).T2(isDarkFont).u1(R.color.white).G1(true).a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void switchFragment(int index) {
        i4a.a("switchFragment:" + index);
        boolean z = false;
        if (index >= 0 && index < this.mTitleList.size()) {
            z = true;
        }
        if (!z) {
            i4a.a("switchFragment:" + index);
            return;
        }
        if (isAdded()) {
            String str = getMFragmentNames().get(this.mTitleList.get(index));
            Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
            if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.getView() == null) {
                FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
                fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
                fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                i4a.a("view is null :" + index);
            }
            if (fragmentFindFragmentByTag != null && !fragmentFindFragmentByTag.isHidden()) {
                i4a.a("view is visible :" + index);
                return;
            }
            FragmentTransaction fragmentTransactionBeginTransaction2 = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "childFragmentManager.beginTransaction()");
            for (String str2 : getMFragmentNames().values()) {
                Fragment fragmentFindFragmentByTag2 = getChildFragmentManager().findFragmentByTag(str2);
                if (TextUtils.equals(str, str2)) {
                    i4a.a("is current fragment:" + str2);
                    if (fragmentFindFragmentByTag2 == null) {
                        i4a.a("fragment is null:" + str2);
                        fragmentTransactionBeginTransaction2.add(R.id.fragment_sub_container, createTabFragment(str2), str2);
                    } else {
                        i4a.a("fragment is no null:" + str2);
                        if (fragmentFindFragmentByTag2.isHidden()) {
                            i4a.a("show fragment:" + str2);
                            fragmentTransactionBeginTransaction2.show(fragmentFindFragmentByTag2);
                        }
                    }
                } else {
                    i4a.a("is not current fragment:" + str2);
                    if (fragmentFindFragmentByTag2 == null || fragmentFindFragmentByTag2.isHidden()) {
                        i4a.a("fragment is null:" + str2);
                    } else {
                        i4a.a("hide fragment:" + str2);
                        fragmentTransactionBeginTransaction2.hide(fragmentFindFragmentByTag2);
                    }
                }
            }
            i4a.a("commit:" + index);
            fragmentTransactionBeginTransaction2.commitNowAllowingStateLoss();
            onTabSelected(index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchFragmentByName$lambda$3(AlumniFragment alumniFragment, int i) {
        Intrinsics.checkNotNullParameter(alumniFragment, "this$0");
        alumniFragment.switchFragment(i);
    }

    private final void updateTabTextFont(int index, int textSelectColor, int textUnselectColor) {
        SlideTabLayout slideTabLayout;
        WorksFragmentAlumniBinding mBinding = getMBinding();
        if (mBinding == null || (slideTabLayout = mBinding.f14151a) == null) {
            return;
        }
        Typeface font = slideTabLayout.getResources().getFont(R.font.shandong_pht3);
        Intrinsics.checkNotNullExpressionValue(font, "tabLayout.resources.getFont(R.font.shandong_pht3)");
        int tabCount = slideTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TextView tabTitleView = slideTabLayout.getTabTitleView(i);
            if (tabTitleView != null) {
                if (i == index) {
                    tabTitleView.setTypeface(font);
                    tabTitleView.setTextColor(textSelectColor);
                } else {
                    tabTitleView.setTypeface(null, 1);
                    tabTitleView.setTextColor(textUnselectColor);
                }
            }
        }
        slideTabLayout.postInvalidate();
    }

    public final void childSetTabDark(@NotNull String tabName, boolean isDark) {
        Integer value;
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        int iIndexOf = this.mTitleList.indexOf(tabName);
        boolean z = false;
        if (iIndexOf >= 0 && iIndexOf < this.mTitleList.size()) {
            z = true;
        }
        if (z && (value = getMViewModel().j().getValue()) != null && value.intValue() == iIndexOf) {
            setTabDark(iIndexOf, isDark);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_alumni;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, AlumniVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        checkCommonConfig();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().i().observe(this, new b(new Function1<SchoolmateConfigBean, Unit>() { // from class: com.huachenjie.works.page.alumni.AlumniFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SchoolmateConfigBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SchoolmateConfigBean schoolmateConfigBean) {
                int iIndexOf;
                WorksFragmentAlumniBinding worksFragmentAlumniBindingAccess$getMBinding;
                SlideTabLayout slideTabLayout;
                View tabView;
                if (schoolmateConfigBean == null || (iIndexOf = AlumniFragment.this.mTitleList.indexOf(fe9.a.FIND_ALUMNI)) < 0 || (worksFragmentAlumniBindingAccess$getMBinding = AlumniFragment.access$getMBinding(AlumniFragment.this)) == null || (slideTabLayout = worksFragmentAlumniBindingAccess$getMBinding.f14151a) == null || (tabView = slideTabLayout.getTabView(iIndexOf)) == null) {
                    return;
                }
                tabView.performClick();
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        vs1 vs1Var = vs1.f45437a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        vs1Var.unregisterReceiver(contextRequireContext, getReceiver());
        yg3 yg3Var = yg3.f46026a;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        yg3Var.unregisterReceiver(contextRequireContext2, getFindAlumniReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onFragmentResume() {
        Integer value = getMViewModel().j().getValue();
        if (value == null) {
            value = 1;
        }
        setTabDark(value.intValue(), this.statusBarDark);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        vs1 vs1Var = vs1.f45437a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        vs1Var.registerReceiver(contextRequireContext, getReceiver());
        yg3 yg3Var = yg3.f46026a;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        yg3Var.registerReceiver(contextRequireContext2, getFindAlumniReceiver());
    }

    public final void switchFragmentByName(@NotNull String tabName) {
        SlideTabLayout slideTabLayout;
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        final int iIndexOf = this.mTitleList.indexOf(tabName);
        WorksFragmentAlumniBinding mBinding = getMBinding();
        if (mBinding == null || (slideTabLayout = mBinding.f14151a) == null) {
            return;
        }
        slideTabLayout.post(new Runnable() { // from class: com.zj.adlib.h50
            @Override // java.lang.Runnable
            public final void run() {
                AlumniFragment.switchFragmentByName$lambda$3(this.f42055a, iIndexOf);
            }
        });
    }
}
