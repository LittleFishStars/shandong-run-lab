package com.huachenjie.sport.page.mine.sport_test.informed;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.liveData.SingleLiveEvent;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.InformedConsentDetailBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/informed/InformedVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "fitnessTestConfigCode", "", "r", t.d, "k", "", "hasConsent", "s", "detailContent", "j", "Lcom/huachenjie/sport/api/SportModel;", "c", "Lkotlin/Lazy;", "p", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "isAgree", "b", j.b, "htmlContent", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "n", "()Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "closeEvent", "m", "agreeSuccessEvent", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nInformedVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InformedVM.kt\ncom/huachenjie/sport/page/mine/sport_test/informed/InformedVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1864#2,3:112\n1864#2,3:115\n*S KotlinDebug\n*F\n+ 1 InformedVM.kt\ncom/huachenjie/sport/page/mine/sport_test/informed/InformedVM\n*L\n86#1:112,3\n98#1:115,3\n*E\n"})
public final class InformedVM extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.sport_test.informed.InformedVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m791invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isAgree = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> htmlContent = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent<Boolean> closeEvent = new SingleLiveEvent<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent<Boolean> agreeSuccessEvent = new SingleLiveEvent<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/informed/InformedVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/sport/bean/InformedConsentDetailBean;", "data", "", "onCCSuccess", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<InformedConsentDetailBean> {
        public a() {
            super(true);
        }

        public void onFinish() {
            InformedVM.this.c();
        }

        public void onCCSuccess(@Nullable InformedConsentDetailBean data) {
            MutableLiveData<String> mutableLiveDataO = InformedVM.this.o();
            InformedVM informedVM = InformedVM.this;
            String detailContent = data != null ? data.getDetailContent() : null;
            if (detailContent == null) {
                detailContent = "";
            }
            mutableLiveDataO.setValue(informedVM.j(detailContent));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/informed/InformedVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InformedVM f36725a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, InformedVM informedVM) {
            super(true);
            this.b = z;
            this.f36725a = informedVM;
        }

        public void onCCSuccess(@Nullable Object data) {
            if (this.b) {
                this.f36725a.m().setValue(Boolean.TRUE);
            } else {
                this.f36725a.n().setValue(Boolean.TRUE);
            }
        }

        public void onFinish() {
            this.f36725a.c();
        }
    }

    public final String j(String detailContent) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!doctype html><html lang=\"zh\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title></title></head><body>");
        int i = 0;
        if (StringsKt.contains$default(detailContent, "<img", false, 2, (Object) null)) {
            String str2 = "";
            int i2 = 0;
            for (Object obj : StringsKt.split$default(detailContent, new String[]{"<img"}, false, 0, 6, (Object) null)) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                str2 = i2 == 0 ? str2 + str3 : str2 + "<img style = \"width:100%\" " + str3;
                i2 = i3;
            }
            str = str2;
        } else {
            str = detailContent;
        }
        if (StringsKt.contains$default(str, "<video", false, 2, (Object) null)) {
            for (Object obj2 : StringsKt.split$default(str, new String[]{"<video"}, false, 0, 6, (Object) null)) {
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str4 = (String) obj2;
                if (i == 0) {
                    stringBuffer.append(str4);
                } else {
                    stringBuffer.append("<video style = \"width:100%\" " + str4);
                }
                i = i4;
            }
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("</body></html>");
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final void k(@NotNull String fitnessTestConfigCode) {
        Intrinsics.checkNotNullParameter(fitnessTestConfigCode, "fitnessTestConfigCode");
        s(true, fitnessTestConfigCode);
    }

    public final void l(@NotNull String fitnessTestConfigCode) {
        Intrinsics.checkNotNullParameter(fitnessTestConfigCode, "fitnessTestConfigCode");
        s(false, fitnessTestConfigCode);
    }

    @NotNull
    public final SingleLiveEvent<Boolean> m() {
        return this.agreeSuccessEvent;
    }

    @NotNull
    public final SingleLiveEvent<Boolean> n() {
        return this.closeEvent;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.htmlContent;
    }

    public final SportModel p() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isAgree;
    }

    public final void r(@NotNull String fitnessTestConfigCode) {
        Intrinsics.checkNotNullParameter(fitnessTestConfigCode, "fitnessTestConfigCode");
        if (fitnessTestConfigCode.length() == 0) {
            this.htmlContent.setValue(j(""));
            return;
        }
        Observable<BaseEntity<InformedConsentDetailBean>> observableU = p().u(fitnessTestConfigCode);
        if (observableU == null) {
            this.htmlContent.setValue(j(""));
        } else {
            g();
            observableU.u5(Schedulers.io()).G3(d60.c()).p5(new a());
        }
    }

    public final void s(boolean hasConsent, String fitnessTestConfigCode) {
        if (fitnessTestConfigCode.length() == 0) {
            h("数据异常");
            return;
        }
        Observable<BaseEntity<Object>> observableS = p().S(hasConsent, fitnessTestConfigCode);
        if (observableS == null) {
            return;
        }
        g();
        observableS.u5(Schedulers.io()).G3(d60.c()).p5(new b(hasConsent, this));
    }
}
