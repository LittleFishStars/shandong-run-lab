package com.huachenjie.works.bean;

import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/works/bean/CreateTopicResultBean;", "", yj7.b.b, "", "(Ljava/lang/String;)V", "getSubjectNo", "()Ljava/lang/String;", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CreateTopicResultBean {

    @NotNull
    private final String subjectNo;

    /* JADX WARN: Illegal instructions before constructor call */
    public CreateTopicResultBean() {
        String str = null;
        this(str, 1, str);
    }

    public CreateTopicResultBean(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, yj7.b.b);
        this.subjectNo = str;
    }

    @NotNull
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    public /* synthetic */ CreateTopicResultBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
