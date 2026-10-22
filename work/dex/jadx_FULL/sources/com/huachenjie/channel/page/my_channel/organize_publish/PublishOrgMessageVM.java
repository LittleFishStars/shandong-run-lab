package com.huachenjie.channel.page.my_channel.organize_publish;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b#\u0010\u0011¨\u0006'"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "p", "", "f", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "q", "(Ljava/lang/String;)V", "channelNo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "b", t.d, "inputTitle", "c", "k", "inputContent", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", "d", "j", "imageList", "Lcom/huachenjie/channel/bean/OrganizeBean;", "e", "n", "selectedClub", "", "m", "publishResult", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class PublishOrgMessageVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String channelNo = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> inputTitle = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> inputContent = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ImagePickBean>> imageList = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeBean> selectedClub = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> publishResult = new MutableLiveData<>();

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    public final MutableLiveData<List<ImagePickBean>> j() {
        return this.imageList;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.inputContent;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.inputTitle;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.publishResult;
    }

    @NotNull
    public final MutableLiveData<OrganizeBean> n() {
        return this.selectedClub;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> o() {
        return this.titleBean;
    }

    public final void p() {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageVM$publishMessage$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                fv5.b(resultException.getMessage());
                this.this$0.m().setValue(Integer.valueOf(resultException.getCode()));
                return Boolean.TRUE;
            }
        }, null, new PublishOrgMessageVM$publishMessage$2(this, null), 10, null);
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelNo = str;
    }
}
