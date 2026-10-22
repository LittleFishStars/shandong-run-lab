package com.huachenjie.works.page.share.choose_team;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.ChatTeamBean;
import com.huachenjie.works.page.share.choose_team.ChooseTeamVM;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/works/page/share/choose_team/ChooseTeamVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/share/choose_team/ChooseTeamAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/works/bean/ChatTeamBean;", "b", "k", "chatTeamBean", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseTeamVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChooseTeamAdapter> adapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChatTeamBean> chatTeamBean;

    public ChooseTeamVM() {
        MutableLiveData<ChooseTeamAdapter> mutableLiveData = new MutableLiveData<>();
        this.adapter = mutableLiveData;
        this.chatTeamBean = new MutableLiveData<>();
        mutableLiveData.setValue(new ChooseTeamAdapter());
        ChooseTeamAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tv_share);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.pk1
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ChooseTeamVM.l(this.f44000a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public static final void l(ChooseTeamVM chooseTeamVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseTeamVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        ChooseTeamAdapter value = chooseTeamVM.adapter.getValue();
        if (value == null) {
            return;
        }
        MultiItemEntity multiItemEntity = (MultiItemEntity) value.getData().get(i);
        if (multiItemEntity instanceof ChatTeamBean) {
            chooseTeamVM.chatTeamBean.setValue((ChatTeamBean) multiItemEntity);
        }
    }

    @NotNull
    public final MutableLiveData<ChooseTeamAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<ChatTeamBean> k() {
        return this.chatTeamBean;
    }

    public final void m(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.share.choose_team.ChooseTeamVM$queryFriendList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                ChooseTeamAdapter value = this.this$0.j().getValue();
                if (value != null) {
                    value.i();
                }
                return Boolean.FALSE;
            }
        }, null, new ChooseTeamVM$queryFriendList$2(channelNo, this, null), 11, null);
    }
}
