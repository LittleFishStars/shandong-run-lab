package com.huachenjie.mall.page.comment.write;

import android.app.Activity;
import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.WriteReviewAddImageBean;
import com.huachenjie.mall.bean.WriteReviewImageBean;
import com.huachenjie.mall.bean.WriteReviewRequestBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.u66;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\r8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\r8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00060\u00060\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u001f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b&\u0010#R%\u0010+\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010(0(0\r8\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R%\u0010.\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010(0(0\r8\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R%\u00101\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010(0(0\r8\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R%\u00104\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\r8\u0006¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012¨\u00067"}, d2 = {"Lcom/huachenjie/mall/page/comment/write/WriteReviewVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", t.d, "Landroid/app/Activity;", "context", "", "path", "w", "orderNo", "x", "imageUrl", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", WriteReviewActivity.x, "", "kotlin.jvm.PlatformType", "c", "n", "canPublish", "d", "m", "anonymous", "e", j.b, "comment", "Landroidx/lifecycle/MediatorLiveData;", "a", "Landroidx/lifecycle/MediatorLiveData;", "p", "()Landroidx/lifecycle/MediatorLiveData;", "commentLength", "Lcom/huachenjie/mall/page/comment/write/WriteReviewImageAdapter;", "s", "imageAdapter", "", "f", "q", "describeStar", y6b.f, "t", "logisticsStar", y6b.g, "u", "merchantsStar", "i", "v", "startWriteReviewSuccess", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWriteReviewVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WriteReviewVM.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n1855#2,2:144\n*S KotlinDebug\n*F\n+ 1 WriteReviewVM.kt\ncom/huachenjie/mall/page/comment/write/WriteReviewVM\n*L\n120#1:144,2\n*E\n"})
public final class WriteReviewVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> commentLength;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<WriteReviewImageAdapter> imageAdapter;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrderGoodsBean> goodsBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canPublish;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> anonymous;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> comment;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> describeStar;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> logisticsStar;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> merchantsStar;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> startWriteReviewSuccess;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35162a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35162a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35162a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35162a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/mall/page/comment/write/WriteReviewVM$b", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f11111a;

        public b(String str) {
            this.f11111a = str;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            WriteReviewVM.this.c();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            WriteReviewVM.this.c();
            if (fileUrl == null) {
                return;
            }
            WriteReviewVM.this.k(this.f11111a, fileUrl);
        }
    }

    public WriteReviewVM() {
        Boolean bool = Boolean.FALSE;
        this.canPublish = new MutableLiveData<>(bool);
        this.anonymous = new MutableLiveData<>(bool);
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.comment = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.commentLength = mediatorLiveData;
        this.imageAdapter = new MediatorLiveData<>();
        this.describeStar = new MutableLiveData<>(0);
        this.logisticsStar = new MutableLiveData<>(0);
        this.merchantsStar = new MutableLiveData<>(0);
        this.startWriteReviewSuccess = new MutableLiveData<>(bool);
        mediatorLiveData.addSource(mutableLiveData, new a(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.comment.write.WriteReviewVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                WriteReviewVM.this.p().setValue(str.length() + "/300");
            }
        }));
    }

    public final void k(String path, String imageUrl) {
        WriteReviewImageAdapter value = this.imageAdapter.getValue();
        if (value == null) {
            return;
        }
        if (value.getData().isEmpty()) {
            value.addData(new WriteReviewImageBean(path, imageUrl));
            value.addData(new WriteReviewAddImageBean(5));
            return;
        }
        if (value.getData().size() == 6 && ((WriteReviewImageBean) value.getData().get(5)).getPostType() == 1) {
            value.removeAt(5);
            value.addData(new WriteReviewImageBean(path, imageUrl));
            return;
        }
        value.addData(value.getData().size() - 1, new WriteReviewImageBean(path, imageUrl));
        WriteReviewImageBean writeReviewImageBean = (WriteReviewImageBean) CollectionsKt.last(value.getData());
        if (writeReviewImageBean.getPostType() == 1 && (writeReviewImageBean instanceof WriteReviewAddImageBean)) {
            WriteReviewAddImageBean writeReviewAddImageBean = (WriteReviewAddImageBean) writeReviewImageBean;
            writeReviewAddImageBean.setOptionalNum(writeReviewAddImageBean.getOptionalNum() - 1);
            value.notifyItemChanged(value.getData().size() - 1);
        }
    }

    public final void l() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.comment.getValue())) {
            IntRange intRange = new IntRange(1, 5);
            Integer value = this.describeStar.getValue();
            if (value != null && intRange.contains(value.intValue())) {
                IntRange intRange2 = new IntRange(1, 5);
                Integer value2 = this.logisticsStar.getValue();
                if (value2 != null && intRange2.contains(value2.intValue())) {
                    IntRange intRange3 = new IntRange(1, 5);
                    Integer value3 = this.merchantsStar.getValue();
                    if (value3 != null && intRange3.contains(value3.intValue())) {
                        z = true;
                    }
                }
            }
        }
        if (Intrinsics.areEqual(Boolean.valueOf(z), this.canPublish.getValue())) {
            return;
        }
        this.canPublish.setValue(Boolean.valueOf(z));
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.anonymous;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.canPublish;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.comment;
    }

    @NotNull
    public final MediatorLiveData<String> p() {
        return this.commentLength;
    }

    @NotNull
    public final MutableLiveData<Integer> q() {
        return this.describeStar;
    }

    @NotNull
    public final MutableLiveData<OrderGoodsBean> r() {
        return this.goodsBean;
    }

    @NotNull
    public final MediatorLiveData<WriteReviewImageAdapter> s() {
        return this.imageAdapter;
    }

    @NotNull
    public final MutableLiveData<Integer> t() {
        return this.logisticsStar;
    }

    @NotNull
    public final MutableLiveData<Integer> u() {
        return this.merchantsStar;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.startWriteReviewSuccess;
    }

    public final void w(@NotNull Activity context, @NotNull String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        g();
        u66.d(context, UploadFileType.UPLOAD_EMOJI, path, new b(path));
    }

    public final void x(@NotNull String orderNo) {
        Iterable<WriteReviewImageBean> data;
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        if (TextUtils.isEmpty(this.comment.getValue())) {
            fv5.b("请输入评论");
            return;
        }
        IntRange intRange = new IntRange(1, 5);
        Integer value = this.describeStar.getValue();
        if (!(value != null && intRange.contains(value.intValue()))) {
            fv5.b("请给描述相符评分");
            return;
        }
        IntRange intRange2 = new IntRange(1, 5);
        Integer value2 = this.logisticsStar.getValue();
        if (!(value2 != null && intRange2.contains(value2.intValue()))) {
            fv5.b("请给物流服务评分");
            return;
        }
        IntRange intRange3 = new IntRange(1, 5);
        Integer value3 = this.merchantsStar.getValue();
        if (!(value3 != null && intRange3.contains(value3.intValue()))) {
            fv5.b("请给商家服务评分");
            return;
        }
        ArrayList arrayList = new ArrayList();
        WriteReviewImageAdapter value4 = this.imageAdapter.getValue();
        if (value4 != null && (data = value4.getData()) != null) {
            for (WriteReviewImageBean writeReviewImageBean : data) {
                if (writeReviewImageBean.getPostType() == 0) {
                    arrayList.add(new ImageBean(writeReviewImageBean.getImageUrl(), null, 0, 0, 0, 30, null));
                }
            }
        }
        String value5 = this.comment.getValue();
        if (value5 == null) {
            value5 = "";
        }
        String str = value5;
        Integer value6 = this.describeStar.getValue();
        if (value6 == null) {
            value6 = 0;
        }
        int iIntValue = value6.intValue();
        Integer value7 = this.logisticsStar.getValue();
        if (value7 == null) {
            value7 = 0;
        }
        int iIntValue2 = value7.intValue();
        Integer value8 = this.merchantsStar.getValue();
        if (value8 == null) {
            value8 = 0;
        }
        int iIntValue3 = value8.intValue();
        Boolean value9 = this.anonymous.getValue();
        if (value9 == null) {
            value9 = Boolean.FALSE;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new WriteReviewVM$writeReview$2(new WriteReviewRequestBean(orderNo, str, arrayList, iIntValue, iIntValue2, iIntValue3, value9.booleanValue()), this, null), 14, null);
    }
}
