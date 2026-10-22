package com.huachenjie.sport.page.mine.helpercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.FeedbackData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.helpercenter.FeedbackDetailsActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.l)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/FeedbackDetailsActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/helpercenter/FeedBackV2VM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "e0", "k0", "", "index", "m0", "Lcom/huachenjie/common/bean/FeedbackData;", "a", "Lcom/huachenjie/common/bean/FeedbackData;", "i0", "()Lcom/huachenjie/common/bean/FeedbackData;", "n0", "(Lcom/huachenjie/common/bean/FeedbackData;)V", "mFeedbackData", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFeedbackDetailsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackDetailsActivity.kt\ncom/huachenjie/sport/page/mine/helpercenter/FeedbackDetailsActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public final class FeedbackDetailsActivity extends BaseVmActivity<FeedBackV2VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public FeedbackData mFeedbackData;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36685a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36685a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36685a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36685a.invoke(obj);
        }
    }

    public static final void j0(FeedbackDetailsActivity feedbackDetailsActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(feedbackDetailsActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        feedbackDetailsActivity.m0(i);
    }

    public static final void l0(FeedbackDetailsActivity feedbackDetailsActivity, View view) {
        Intrinsics.checkNotNullParameter(feedbackDetailsActivity, "this$0");
        feedbackDetailsActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).g0(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_feedback_details), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Nullable
    /* JADX INFO: renamed from: i0, reason: from getter */
    public final FeedbackData getMFeedbackData() {
        return this.mFeedbackData;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveDataI;
        FeedbackDetailsAdapter value;
        FeedBackV2VM feedBackV2VM = (FeedBackV2VM) ((BaseVmActivity) this).f8507a;
        MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveDataI2 = feedBackV2VM != null ? feedBackV2VM.i() : null;
        if (mediatorLiveDataI2 != null) {
            mediatorLiveDataI2.setValue(new FeedbackDetailsAdapter());
        }
        FeedBackV2VM feedBackV2VM2 = (FeedBackV2VM) ((BaseVmActivity) this).f8507a;
        if (feedBackV2VM2 != null && (mediatorLiveDataI = feedBackV2VM2.i()) != null && (value = mediatorLiveDataI.getValue()) != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.se3
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    FeedbackDetailsActivity.j0(this.f44669a, baseQuickAdapter, view, i);
                }
            });
        }
        Intent intent = getIntent();
        if (intent != null) {
            FeedbackData feedbackData = (FeedbackData) intent.getParcelableExtra(UserConstants.MINE_PARAMS.f33731a);
            if (feedbackData == null) {
                feedbackData = new FeedbackData("", new ArrayList(), "");
            }
            this.mFeedbackData = feedbackData;
            FeedBackV2VM feedBackV2VM3 = (FeedBackV2VM) ((BaseVmActivity) this).f8507a;
            MediatorLiveData<FeedbackData> mediatorLiveDataJ = feedBackV2VM3 != null ? feedBackV2VM3.j() : null;
            if (mediatorLiveDataJ != null) {
                mediatorLiveDataJ.setValue(feedbackData);
            }
        }
        k0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        MediatorLiveData<FeedbackData> mediatorLiveDataJ;
        FeedBackV2VM feedBackV2VM = (FeedBackV2VM) ((BaseVmActivity) this).f8507a;
        if (feedBackV2VM == null || (mediatorLiveDataJ = feedBackV2VM.j()) == null) {
            return;
        }
        mediatorLiveDataJ.observe(this, new a(new Function1<FeedbackData, Unit>() { // from class: com.huachenjie.sport.page.mine.helpercenter.FeedbackDetailsActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FeedbackData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FeedbackData feedbackData) {
                FeedBackV2VM feedBackV2VM2;
                MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveDataI;
                FeedbackDetailsAdapter value;
                if (feedbackData != null) {
                    FeedbackDetailsActivity feedbackDetailsActivity = FeedbackDetailsActivity.this;
                    ArrayList<String> imgList = feedbackData.getImgList();
                    if (imgList == null || (feedBackV2VM2 = (FeedBackV2VM) ((BaseVmActivity) feedbackDetailsActivity).f8507a) == null || (mediatorLiveDataI = feedBackV2VM2.i()) == null || (value = mediatorLiveDataI.getValue()) == null) {
                        return;
                    }
                    value.setList(imgList);
                }
            }
        }));
    }

    public final void k0() {
        BindingTitleBean backClick = new BindingTitleBean().setTitleName("小闪通知").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackground(zn1.a(R.color.transparent)).setBackIconResId(R.mipmap.ic_message_back).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.te3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackDetailsActivity.l0(this.f44899a, view);
            }
        });
        Integer value = ((BaseVM) ((FeedBackV2VM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value != null) {
            backClick.setStatusBarHeight(value.intValue());
        }
        ((FeedBackV2VM) ((BaseVmActivity) this).f8507a).o().setValue(backClick);
    }

    public final void m0(int index) {
        MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveDataI;
        final FeedbackDetailsAdapter value;
        FeedBackV2VM feedBackV2VM = (FeedBackV2VM) ((BaseVmActivity) this).f8507a;
        if (feedBackV2VM == null || (mediatorLiveDataI = feedBackV2VM.i()) == null || (value = mediatorLiveDataI.getValue()) == null) {
            return;
        }
        List<String> data = value.getData();
        if (!data.isEmpty()) {
            PicturePreviewUtil.h(this, data, index, new Function1<Integer, View>() { // from class: com.huachenjie.sport.page.mine.helpercenter.FeedbackDetailsActivity$preImage$1$1$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @Nullable
                public final View invoke(int i) {
                    return value.getViewByPosition(i, R.id.iv_feed);
                }
            });
        }
    }

    public final void n0(@Nullable FeedbackData feedbackData) {
        this.mFeedbackData = feedbackData;
    }
}
