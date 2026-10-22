package com.huachenjie.works.page.dormitory;

import android.content.Context;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.bean.CommonSwitchEntranceConfig;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.DormitoryMenuBean;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.huachenjie.works.bean.dorm.DormUserInfoBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.dq1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J\u001a\u0010\r\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013¨\u0006#"}, d2 = {"Lcom/huachenjie/works/page/dormitory/DormitoryVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroid/content/Context;", "context", "", "m", "q", "", "needRefreshCharm", j.b, "Lkotlin/Function1;", "Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", RenderCallContext.TYPE_CALLBACK, "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/dorm/DormUserInfoBean;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "userBean", "", "b", "i", "charmValue", "Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", "c", "j", "energyBean", "Lcom/huachenjie/works/page/dormitory/DormitoryAdapter;", "d", "k", "menuAdapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDormitoryVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DormitoryVM.kt\ncom/huachenjie/works/page/dormitory/DormitoryVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,93:1\n1549#2:94\n1620#2,3:95\n766#2:98\n857#2,2:99\n1549#2:101\n1620#2,3:102\n*S KotlinDebug\n*F\n+ 1 DormitoryVM.kt\ncom/huachenjie/works/page/dormitory/DormitoryVM\n*L\n35#1:94\n35#1:95,3\n56#1:98\n56#1:99,2\n58#1:101\n58#1:102,3\n*E\n"})
public final class DormitoryVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<DormUserInfoBean> userBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> charmValue = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<DormEnergyBean> energyBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<DormitoryAdapter> menuAdapter = new MutableLiveData<>();

    public static /* synthetic */ void p(DormitoryVM dormitoryVM, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dormitoryVM.o(z);
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.charmValue;
    }

    @NotNull
    public final MutableLiveData<DormEnergyBean> j() {
        return this.energyBean;
    }

    @NotNull
    public final MutableLiveData<DormitoryAdapter> k() {
        return this.menuAdapter;
    }

    @NotNull
    public final MutableLiveData<DormUserInfoBean> l() {
        return this.userBean;
    }

    public final void m(@NotNull Context context) {
        List<CommonSwitchEntranceConfig> listEmptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        CommonSwitchConfig commonSwitchConfigD = dq1.d();
        if (commonSwitchConfigD == null || (listEmptyList = commonSwitchConfigD.getDeskEntryList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List<CommonSwitchEntranceConfig> list = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CommonSwitchEntranceConfig) it.next()).getEntryType()));
        }
        Set set = CollectionsKt.toSet(arrayList);
        int i = R.drawable.works_ic_dorm_meu_dress;
        String string = context.getString(R.string.works_dormitory_menu_dress);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…rks_dormitory_menu_dress)");
        int i2 = R.drawable.works_ic_dorm_meu_shop;
        String string2 = context.getString(R.string.works_dormitory_menu_shop);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.works_dormitory_menu_shop)");
        int i3 = R.drawable.works_ic_dorm_meu_exchange;
        String string3 = context.getString(R.string.works_dormitory_menu_exchange);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…_dormitory_menu_exchange)");
        List listListOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new DormitoryMenuBean(i, string, 0, 31, 4, null), 31), TuplesKt.to(new DormitoryMenuBean(i2, string2, 0, 23), 23), TuplesKt.to(new DormitoryMenuBean(i3, string3, 0, 30, 4, null), 30)});
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listListOf) {
            if (set.contains(Integer.valueOf(((Number) ((Pair) obj).component2()).intValue()))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((DormitoryMenuBean) ((Pair) it2.next()).getFirst());
        }
        DormitoryAdapter value = this.menuAdapter.getValue();
        if (value != null) {
            value.setList(arrayList3);
        }
    }

    public final void n(@NotNull Function1<? super DormExchangeBean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        BaseViewModelExtKt.b(this, true, false, null, null, new DormitoryVM$queryMemberPerksList$1(this, callback, null), 14, null);
    }

    public final void o(boolean needRefreshCharm) {
        BaseViewModelExtKt.b(this, false, false, null, null, new DormitoryVM$querySpaceEnergyStatus$1(this, needRefreshCharm, null), 15, null);
    }

    public final void q() {
        BaseViewModelExtKt.b(this, true, false, null, null, new DormitoryVM$querySpaceHomePageMetaInfo$1(this, null), 14, null);
    }
}
