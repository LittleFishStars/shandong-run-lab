package com.huachenjie.channel.page.create_channel.info;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ClassificationBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R)\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040%0\b8\u0006¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r¨\u0006+"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/info/EditChannelInfoVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroid/content/Context;", "context", "", "channelNo", "", "q", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/channel/bean/ClassificationBean;", "b", "p", "typeBean", "c", "n", "subTypeBean", "d", t.d, "name", "e", "k", "localLogoPath", "f", "j", "localCoverImagePath", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "coverHue", "Lkotlin/Pair;", y6b.f, "m", "saveResult", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class EditChannelInfoVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClassificationBean> typeBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClassificationBean> subTypeBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> name = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> localLogoPath = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> localCoverImagePath = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String coverHue = "";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Pair<String, String>> saveResult = new MutableLiveData<>();

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getCoverHue() {
        return this.coverHue;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.localCoverImagePath;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.localLogoPath;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.name;
    }

    @NotNull
    public final MutableLiveData<Pair<String, String>> m() {
        return this.saveResult;
    }

    @NotNull
    public final MutableLiveData<ClassificationBean> n() {
        return this.subTypeBean;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> o() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<ClassificationBean> p() {
        return this.typeBean;
    }

    public final void q(@NotNull Context context, @Nullable String channelNo) {
        String channelClassificationNo;
        ClassificationBean value;
        String channelClassificationNo2;
        String value2;
        String value3;
        Intrinsics.checkNotNullParameter(context, "context");
        ClassificationBean value4 = this.typeBean.getValue();
        if (value4 == null || (channelClassificationNo = value4.getChannelClassificationNo()) == null || (value = this.subTypeBean.getValue()) == null || (channelClassificationNo2 = value.getChannelClassificationNo()) == null || (value2 = this.localLogoPath.getValue()) == null || (value3 = this.localCoverImagePath.getValue()) == null) {
            return;
        }
        String value5 = this.name.getValue();
        String string = value5 != null ? StringsKt.trim(value5).toString() : null;
        if (TextUtils.isEmpty(string)) {
            fv5.b(ys8.e(R.string.channel_edit_info_hint));
        } else {
            BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.create_channel.info.EditChannelInfoVM$saveData$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.c();
                    return Boolean.FALSE;
                }
            }, null, new EditChannelInfoVM$saveData$2(this, context, value2, value3, channelClassificationNo, channelClassificationNo2, string, channelNo, null), 11, null);
        }
    }

    public final void r(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverHue = str;
    }
}
