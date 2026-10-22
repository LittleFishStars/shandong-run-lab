package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/huachenjie/run/bean/EmaQuestionBean;", "Landroid/os/Parcelable;", "questionNo", "", "questionCode", "content", "options", "", "Lcom/huachenjie/run/bean/EmaOptionBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "getQuestionCode", "getQuestionNo", "component1", "component2", "component3", "component4", OperatePopupWindow.g, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmaQuestionBean implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<EmaQuestionBean> CREATOR = new Creator();

    @NotNull
    private final String content;

    @NotNull
    private final List<EmaOptionBean> options;

    @NotNull
    private final String questionCode;

    @NotNull
    private final String questionNo;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<EmaQuestionBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaQuestionBean createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(EmaOptionBean.CREATOR.createFromParcel(parcel));
            }
            return new EmaQuestionBean(string, string2, string3, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final EmaQuestionBean[] newArray(int i) {
            return new EmaQuestionBean[i];
        }
    }

    public EmaQuestionBean() {
        this(null, null, null, null, 15, null);
    }

    public EmaQuestionBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<EmaOptionBean> list) {
        Intrinsics.checkNotNullParameter(str, "questionNo");
        Intrinsics.checkNotNullParameter(str2, "questionCode");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(list, "options");
        this.questionNo = str;
        this.questionCode = str2;
        this.content = str3;
        this.options = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmaQuestionBean copy$default(EmaQuestionBean emaQuestionBean, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emaQuestionBean.questionNo;
        }
        if ((i & 2) != 0) {
            str2 = emaQuestionBean.questionCode;
        }
        if ((i & 4) != 0) {
            str3 = emaQuestionBean.content;
        }
        if ((i & 8) != 0) {
            list = emaQuestionBean.options;
        }
        return emaQuestionBean.copy(str, str2, str3, list);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuestionNo() {
        return this.questionNo;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuestionCode() {
        return this.questionCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<EmaOptionBean> component4() {
        return this.options;
    }

    @NotNull
    public final EmaQuestionBean copy(@NotNull String questionNo, @NotNull String questionCode, @NotNull String content, @NotNull List<EmaOptionBean> options) {
        Intrinsics.checkNotNullParameter(questionNo, "questionNo");
        Intrinsics.checkNotNullParameter(questionCode, "questionCode");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(options, "options");
        return new EmaQuestionBean(questionNo, questionCode, content, options);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmaQuestionBean)) {
            return false;
        }
        EmaQuestionBean emaQuestionBean = (EmaQuestionBean) other;
        return Intrinsics.areEqual(this.questionNo, emaQuestionBean.questionNo) && Intrinsics.areEqual(this.questionCode, emaQuestionBean.questionCode) && Intrinsics.areEqual(this.content, emaQuestionBean.content) && Intrinsics.areEqual(this.options, emaQuestionBean.options);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final List<EmaOptionBean> getOptions() {
        return this.options;
    }

    @NotNull
    public final String getQuestionCode() {
        return this.questionCode;
    }

    @NotNull
    public final String getQuestionNo() {
        return this.questionNo;
    }

    public int hashCode() {
        return (((((this.questionNo.hashCode() * 31) + this.questionCode.hashCode()) * 31) + this.content.hashCode()) * 31) + this.options.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmaQuestionBean(questionNo=" + this.questionNo + ", questionCode=" + this.questionCode + ", content=" + this.content + ", options=" + this.options + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.questionNo);
        parcel.writeString(this.questionCode);
        parcel.writeString(this.content);
        List<EmaOptionBean> list = this.options;
        parcel.writeInt(list.size());
        Iterator<EmaOptionBean> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ EmaQuestionBean(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
