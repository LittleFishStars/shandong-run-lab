package com.huachenjie.channel.page.advertise.preview;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.CommonBannerBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/page/advertise/preview/PreviewAdvertiseVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/huachenjie/common/bean/CommonBannerBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "imageList", "", "c", "j", "content", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class PreviewAdvertiseVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<CommonBannerBean>> imageList = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> content = new MutableLiveData<>("");

    @NotNull
    public final MutableLiveData<String> j() {
        return this.content;
    }

    @NotNull
    public final MutableLiveData<List<CommonBannerBean>> k() {
        return this.imageList;
    }
}
