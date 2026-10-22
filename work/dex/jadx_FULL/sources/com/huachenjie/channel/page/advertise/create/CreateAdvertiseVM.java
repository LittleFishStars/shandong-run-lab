package com.huachenjie.channel.page.advertise.create;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.channel.bean.CreateAdvertiseRequestBean;
import com.huachenjie.channel.bean.CreateImageBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R%\u0010\u000e\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR%\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\b8\u0006¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b'\u0010\"R%\u0010+\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\b8\u0006¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR%\u0010.\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR%\u00100\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000f0\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b/\u0010\r¨\u00063"}, d2 = {"Lcom/huachenjie/channel/page/advertise/create/CreateAdvertiseVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "j", "", "channelNo", "channelAdCode", "v", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "t", "()Landroidx/lifecycle/MutableLiveData;", "publishStr", "", "c", "k", "canPublish", "", "Lcom/huachenjie/base/widget/image_pick/ImagePickBean;", "d", "n", "coverList", "e", "u", "useOutsideLink", "f", t.d, "content", "Landroidx/lifecycle/MediatorLiveData;", "a", "Landroidx/lifecycle/MediatorLiveData;", "m", "()Landroidx/lifecycle/MediatorLiveData;", "contentLength", y6b.f, "q", "imageList", "r", "imagePickLength", y6b.g, "s", "outsideLink", "i", j.b, "finishActivity", "p", "finishAndNotify", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCreateAdvertiseVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateAdvertiseVM.kt\ncom/huachenjie/channel/page/advertise/create/CreateAdvertiseVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1549#2:113\n1620#2,3:114\n*S KotlinDebug\n*F\n+ 1 CreateAdvertiseVM.kt\ncom/huachenjie/channel/page/advertise/create/CreateAdvertiseVM\n*L\n84#1:113\n84#1:114,3\n*E\n"})
public final class CreateAdvertiseVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> contentLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> imagePickLength;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> publishStr = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canPublish;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ImagePickBean>> coverList;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> useOutsideLink;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> content;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<ImagePickBean>> imageList;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> outsideLink;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishActivity;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishAndNotify;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33364a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33364a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33364a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33364a.invoke(obj);
        }
    }

    public CreateAdvertiseVM() {
        Boolean bool = Boolean.FALSE;
        this.canPublish = new MutableLiveData<>(bool);
        this.coverList = new MutableLiveData<>();
        this.useOutsideLink = new MutableLiveData<>(bool);
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.content = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.contentLength = mediatorLiveData;
        MutableLiveData<List<ImagePickBean>> mutableLiveData2 = new MutableLiveData<>();
        this.imageList = mutableLiveData2;
        MediatorLiveData<String> mediatorLiveData2 = new MediatorLiveData<>();
        this.imagePickLength = mediatorLiveData2;
        this.outsideLink = new MutableLiveData<>("");
        this.finishActivity = new MutableLiveData<>(bool);
        this.finishAndNotify = new MutableLiveData<>(bool);
        mediatorLiveData.addSource(mutableLiveData, new a(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateAdvertiseVM.this.m().setValue(str.length() + "/300");
            }
        }));
        mediatorLiveData2.addSource(mutableLiveData2, new a(new Function1<List<? extends ImagePickBean>, Unit>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends ImagePickBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<? extends ImagePickBean> list) {
                MediatorLiveData<String> mediatorLiveDataR = CreateAdvertiseVM.this.r();
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                sb.append(list != null ? list.size() : 0);
                sb.append("/5)");
                mediatorLiveDataR.setValue(sb.toString());
            }
        }));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    public final void j() {
        boolean z;
        if (Intrinsics.areEqual(this.useOutsideLink.getValue(), Boolean.TRUE)) {
            MutableLiveData<Boolean> mutableLiveData = this.canPublish;
            List<ImagePickBean> value = this.coverList.getValue();
            mutableLiveData.setValue(Boolean.valueOf((value != null ? value.size() : 0) > 0 && !TextUtils.isEmpty(this.outsideLink.getValue())));
            return;
        }
        MutableLiveData<Boolean> mutableLiveData2 = this.canPublish;
        List<ImagePickBean> value2 = this.coverList.getValue();
        if ((value2 != null ? value2.size() : 0) > 0 && !TextUtils.isEmpty(this.content.getValue())) {
            List<ImagePickBean> value3 = this.imageList.getValue();
            z = (value3 != null ? value3.size() : 0) > 0;
        }
        mutableLiveData2.setValue(Boolean.valueOf(z));
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.canPublish;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.content;
    }

    @NotNull
    public final MediatorLiveData<String> m() {
        return this.contentLength;
    }

    @NotNull
    public final MutableLiveData<List<ImagePickBean>> n() {
        return this.coverList;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.finishActivity;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.finishAndNotify;
    }

    @NotNull
    public final MutableLiveData<List<ImagePickBean>> q() {
        return this.imageList;
    }

    @NotNull
    public final MediatorLiveData<String> r() {
        return this.imagePickLength;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.outsideLink;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.publishStr;
    }

    @NotNull
    public final MutableLiveData<Boolean> u() {
        return this.useOutsideLink;
    }

    public final void v(@NotNull String channelNo, @Nullable String channelAdCode) {
        List list;
        CreateAdvertiseRequestBean createAdvertiseRequestBean;
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        if (this.coverList.getValue() != null) {
            List<ImagePickBean> value = this.coverList.getValue();
            Intrinsics.checkNotNull(value);
            if (!value.isEmpty()) {
                if (Intrinsics.areEqual(this.useOutsideLink.getValue(), Boolean.TRUE)) {
                    List<ImagePickBean> value2 = this.coverList.getValue();
                    Intrinsics.checkNotNull(value2);
                    String url = value2.get(0).getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "coverList.value!!.get(0).url");
                    String value3 = this.outsideLink.getValue();
                    createAdvertiseRequestBean = new CreateAdvertiseRequestBean(channelNo, url, "", true, value3 == null ? "" : value3, channelAdCode, null);
                } else {
                    List<ImagePickBean> value4 = this.coverList.getValue();
                    Intrinsics.checkNotNull(value4);
                    String url2 = value4.get(0).getUrl();
                    Intrinsics.checkNotNullExpressionValue(url2, "coverList.value!!.get(0).url");
                    String value5 = this.content.getValue();
                    String str = value5 == null ? "" : value5;
                    List<ImagePickBean> value6 = this.imageList.getValue();
                    if (value6 != null) {
                        List<ImagePickBean> list2 = value6;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (ImagePickBean imagePickBean : list2) {
                            String url3 = imagePickBean.getUrl();
                            Intrinsics.checkNotNullExpressionValue(url3, "it.url");
                            arrayList.add(new CreateImageBean(url3, imagePickBean.getWidth(), imagePickBean.getHeight()));
                        }
                        list = CollectionsKt.toList(arrayList);
                    } else {
                        list = null;
                    }
                    createAdvertiseRequestBean = new CreateAdvertiseRequestBean(channelNo, url2, str, false, null, channelAdCode, list);
                }
                BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM$publishAdvertise$1
                    {
                        super(1);
                    }

                    @NotNull
                    public final Boolean invoke(@NotNull ResultException resultException) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(resultException, o.f);
                        if (resultException.getCode() == 10100) {
                            fv5.b(resultException.getMessage());
                            this.this$0.p().setValue(Boolean.TRUE);
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, null, new CreateAdvertiseVM$publishAdvertise$2(channelAdCode, createAdvertiseRequestBean, this, null), 10, null);
                return;
            }
        }
        fv5.b("请先完成相关内容编辑~");
    }
}
