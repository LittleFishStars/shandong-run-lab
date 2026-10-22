package com.huachenjie.sport.page.campus_letter;

import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.huachenjie.sport.bean.CampusLetterInfo;
import com.huachenjie.sport.page.campus_letter.CampusLetterVM;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.n76;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u00108\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u001c0\u001c0\u00108\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b#\u0010\u0015¨\u0006&"}, d2 = {"Lcom/huachenjie/sport/page/campus_letter/CampusLetterVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "v", "", LetterDetailActivity.x, "", "position", t.d, "u", "s", "t", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "kotlin.jvm.PlatformType", "j", "p", "isRefreshing", "Lcom/huachenjie/sport/page/campus_letter/CampusLetterAdapter;", "k", "m", "adapter", "K", "I", "pageNum", "n", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class CampusLetterVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CampusLetterAdapter> adapter;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> letterCode;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/campus_letter/CampusLetterVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(CampusLetterVM.this, true);
            this.K = i;
        }

        public void onCCSuccess(@Nullable Object data) {
            CampusLetterAdapter value = CampusLetterVM.this.m().getValue();
            if (value != null) {
                value.removeAt(this.K);
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/campus_letter/CampusLetterVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/sport/bean/CampusLetterBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<PageEntity<CampusLetterBean>> {
        public b() {
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            if (CampusLetterVM.this.m().getValue() == null) {
                i4a.a("adapter is null");
            } else {
                i4a.a("adapter is not null");
            }
            if (CampusLetterVM.this.pageNum == 1) {
                CampusLetterAdapter value = CampusLetterVM.this.m().getValue();
                if (value != null) {
                    value.setList(null);
                }
                CampusLetterAdapter value2 = CampusLetterVM.this.m().getValue();
                if (value2 != null) {
                    value2.i();
                }
            } else {
                CampusLetterVM.this.pageNum--;
            }
            CampusLetterVM.this.p().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@NotNull PageEntity<CampusLetterBean> data) {
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            Intrinsics.checkNotNullParameter(data, "data");
            CampusLetterVM.this.p().setValue(Boolean.FALSE);
            if (CampusLetterVM.this.pageNum != 1) {
                List list = data.getList();
                if (list == null || !(!list.isEmpty())) {
                    CampusLetterVM.this.pageNum--;
                } else {
                    CampusLetterAdapter value = CampusLetterVM.this.m().getValue();
                    if (value != null) {
                        List list2 = data.getList();
                        Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                        value.addData((Collection) list2);
                    }
                }
            } else if (data.getList() == null || data.getList().isEmpty()) {
                CampusLetterAdapter value2 = CampusLetterVM.this.m().getValue();
                if (value2 != null) {
                    value2.setList(null);
                }
                CampusLetterAdapter value3 = CampusLetterVM.this.m().getValue();
                if (value3 != null) {
                    value3.i();
                }
            } else {
                CampusLetterAdapter value4 = CampusLetterVM.this.m().getValue();
                if (value4 != null) {
                    value4.h();
                }
                CampusLetterAdapter value5 = CampusLetterVM.this.m().getValue();
                if (value5 != null) {
                    value5.setList(data.getList());
                }
            }
            if (data.getHasNext()) {
                CampusLetterAdapter value6 = CampusLetterVM.this.m().getValue();
                if (value6 == null || (loadMoreModule2 = value6.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            CampusLetterAdapter value7 = CampusLetterVM.this.m().getValue();
            if (value7 == null || (loadMoreModule = value7.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/campus_letter/CampusLetterVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "result", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<Object> {
        public final /* synthetic */ int K;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, int i) {
            super(CampusLetterVM.this, true);
            this.f = str;
            this.K = i;
        }

        public void onCCSuccess(@Nullable Object result) {
            if (!TextUtils.isEmpty(this.f)) {
                CampusLetterAdapter value = CampusLetterVM.this.m().getValue();
                if (value != null) {
                    int i = this.K;
                    value.getData().get(i).setReadFlag(true);
                    value.notifyItemChanged(i);
                    return;
                }
                return;
            }
            fv5.b("信件全部已读");
            CampusLetterAdapter value2 = CampusLetterVM.this.m().getValue();
            if (value2 != null) {
                Iterator<CampusLetterBean> it = value2.getData().iterator();
                while (it.hasNext()) {
                    it.next().setReadFlag(true);
                }
                value2.notifyDataSetChanged();
            }
            MutableLiveData<BindingTitleBean> mutableLiveDataO = CampusLetterVM.this.o();
            BindingTitleBean value3 = CampusLetterVM.this.o().getValue();
            if (value3 != null) {
                value3.setShowRightIconNew(false);
            } else {
                value3 = null;
            }
            mutableLiveDataO.setValue(value3);
        }
    }

    public CampusLetterVM() {
        MutableLiveData<CampusLetterAdapter> mutableLiveData = new MutableLiveData<>(new CampusLetterAdapter());
        this.adapter = mutableLiveData;
        this.pageNum = 1;
        this.letterCode = new MutableLiveData<>();
        CampusLetterAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.kd1
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    CampusLetterVM.q(this.f42790a);
                }
            });
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.ld1
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    CampusLetterVM.r(this.f43041a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public static final void q(CampusLetterVM campusLetterVM) {
        Intrinsics.checkNotNullParameter(campusLetterVM, "this$0");
        campusLetterVM.s();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00db  */
    public static final void r(CampusLetterVM campusLetterVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<CampusLetterBean> data;
        CampusLetterBean campusLetterBean;
        String businessRelationCode;
        CampusLetterInfo messageNotificationInfo;
        Intrinsics.checkNotNullParameter(campusLetterVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        CampusLetterAdapter value = campusLetterVM.adapter.getValue();
        if (value == null || (data = value.getData()) == null || (campusLetterBean = data.get(i)) == null) {
            return;
        }
        int source = campusLetterBean.getSource();
        if (source == 10) {
            campusLetterVM.letterCode.setValue(campusLetterBean.getSchoolLetterRelationCode());
        } else if (source == 20) {
            CampusLetterInfo messageNotificationInfo2 = campusLetterBean.getMessageNotificationInfo();
            int businessType = messageNotificationInfo2 != null ? messageNotificationInfo2.getBusinessType() : 0;
            if (businessType == 10 || businessType == 20) {
                CampusLetterInfo messageNotificationInfo3 = campusLetterBean.getMessageNotificationInfo();
                if (messageNotificationInfo3 != null && (businessRelationCode = messageNotificationInfo3.getBusinessRelationCode()) != null) {
                    ARouter.getInstance().build(RoutePathConstants.Run.b).withString("runRecordCode", businessRelationCode).navigation();
                }
            } else if (businessType == 70) {
                CampusLetterInfo messageNotificationInfo4 = campusLetterBean.getMessageNotificationInfo();
                if (messageNotificationInfo4 != null) {
                    ARouter.getInstance().build(RoutePathConstants.Base.b).withString("url", Environment.c + "/#/application-form/test-free/detail?code=" + messageNotificationInfo4.getBusinessRelationCode()).navigation();
                }
            } else if (businessType == 80 && (messageNotificationInfo = campusLetterBean.getMessageNotificationInfo()) != null) {
                ARouter.getInstance().build(RoutePathConstants.Base.b).withString("url", Environment.c + "/#/application-form/test-hold/detail?code=" + messageNotificationInfo.getBusinessRelationCode()).navigation();
            }
        } else if (source == 30 || source == 40) {
            campusLetterVM.letterCode.setValue(campusLetterBean.getSchoolLetterRelationCode());
        }
        if (campusLetterBean.getReadFlag()) {
            return;
        }
        campusLetterVM.u(campusLetterBean.getSchoolLetterRelationCode(), i);
    }

    public final void l(@Nullable String letterCode, int position) {
        SportModel sportModel = this.model;
        if (letterCode == null) {
            letterCode = "";
        }
        n76.e(this, sportModel.a(letterCode)).p5(new a(position));
    }

    @NotNull
    public final MutableLiveData<CampusLetterAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.letterCode;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> o() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.isRefreshing;
    }

    public final void s() {
        this.pageNum++;
        t();
    }

    public final void t() {
        n76.e(this, this.model.A(this.pageNum)).p5(new b());
    }

    public final void u(@Nullable String letterCode, int position) {
        n76.e(this, this.model.J(letterCode == null ? "" : letterCode)).p5(new c(letterCode, position));
    }

    public final void v() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        t();
    }
}
