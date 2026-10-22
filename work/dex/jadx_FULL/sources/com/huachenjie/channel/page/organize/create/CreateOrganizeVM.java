package com.huachenjie.channel.page.organize.create;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R%\u0010\u000e\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR%\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010&\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR%\u0010)\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r¨\u0006,"}, d2 = {"Lcom/huachenjie/channel/page/organize/create/CreateOrganizeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "j", "", "channelNo", "clubCode", "k", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "s", "()Landroidx/lifecycle/MutableLiveData;", "publishStr", "", "c", t.d, "canPublish", "d", "r", "name", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", "e", j.b, "coverList", "f", "m", "content", "Landroidx/lifecycle/MediatorLiveData;", "a", "Landroidx/lifecycle/MediatorLiveData;", "n", "()Landroidx/lifecycle/MediatorLiveData;", "contentLength", y6b.f, "p", "finishActivity", y6b.g, "q", "finishAndNotify", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateOrganizeVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> contentLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> publishStr = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canPublish;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> name;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ImagePickBean>> coverList;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> content;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishActivity;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishAndNotify;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33520a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33520a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33520a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33520a.invoke(obj);
        }
    }

    public CreateOrganizeVM() {
        Boolean bool = Boolean.FALSE;
        this.canPublish = new MutableLiveData<>(bool);
        this.name = new MutableLiveData<>("");
        this.coverList = new MutableLiveData<>();
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.content = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.contentLength = mediatorLiveData;
        this.finishActivity = new MutableLiveData<>(bool);
        this.finishAndNotify = new MutableLiveData<>(bool);
        mediatorLiveData.addSource(mutableLiveData, new a(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateOrganizeVM.this.n().setValue(str.length() + "/100");
            }
        }));
    }

    public final void j() {
        MutableLiveData<Boolean> mutableLiveData = this.canPublish;
        List<ImagePickBean> value = this.coverList.getValue();
        boolean z = false;
        if ((value != null ? value.size() : 0) > 0 && !TextUtils.isEmpty(this.name.getValue()) && !TextUtils.isEmpty(this.content.getValue())) {
            z = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
    }

    public final void k(@NotNull String channelNo, @Nullable String clubCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        if (this.coverList.getValue() != null) {
            List<ImagePickBean> value = this.coverList.getValue();
            Intrinsics.checkNotNull(value);
            if (!value.isEmpty()) {
                BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.organize.create.CreateOrganizeVM$createOrganize$1
                    {
                        super(1);
                    }

                    @NotNull
                    public final Boolean invoke(@NotNull ResultException resultException) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(resultException, o.f);
                        if (resultException.getCode() == 10100) {
                            fv5.b(resultException.getMessage());
                            this.this$0.q().setValue(Boolean.TRUE);
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, null, new CreateOrganizeVM$createOrganize$2(clubCode, this, channelNo, null), 10, null);
                return;
            }
        }
        fv5.b("请先完成相关内容编辑~");
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.canPublish;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.content;
    }

    @NotNull
    public final MediatorLiveData<String> n() {
        return this.contentLength;
    }

    @NotNull
    public final MutableLiveData<List<ImagePickBean>> o() {
        return this.coverList;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.finishActivity;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.finishAndNotify;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.name;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.publishStr;
    }
}
