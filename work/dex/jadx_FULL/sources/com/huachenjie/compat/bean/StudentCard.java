package com.huachenjie.compat.bean;

import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.UserConstants;
import com.ipd.dsp.internal.i.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/compat/bean/StudentCard;", "", "userName", "", "sex", "", UserConstants.LOGIN_PARAMS.c, "Lcom/huachenjie/common/bean/SchoolInfo;", "(Ljava/lang/String;ILcom/huachenjie/common/bean/SchoolInfo;)V", "getSchoolInfo", "()Lcom/huachenjie/common/bean/SchoolInfo;", "getSex", "()I", "getUserName", "()Ljava/lang/String;", "formatDepartmentName", "compat_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentCard {

    @NotNull
    private final SchoolInfo schoolInfo;
    private final int sex;

    @NotNull
    private final String userName;

    public StudentCard(@NotNull String str, int i, @NotNull SchoolInfo schoolInfo) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(schoolInfo, UserConstants.LOGIN_PARAMS.c);
        this.userName = str;
        this.sex = i;
        this.schoolInfo = schoolInfo;
    }

    @NotNull
    public final String formatDepartmentName() {
        if (this.schoolInfo == null) {
            return "";
        }
        return this.schoolInfo.getDepartmentName() + q.a.i + this.schoolInfo.getMajorName();
    }

    @NotNull
    public final SchoolInfo getSchoolInfo() {
        return this.schoolInfo;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final String getUserName() {
        return this.userName;
    }
}
