package com.huachenjie.login.enums;

import com.blankj.utilcode.constant.PermissionConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/huachenjie/login/enums/VerifyCodeType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", PermissionConstants.h, "VOICE", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum VerifyCodeType {
    SMS(1),
    VOICE(2);

    private final int value;

    VerifyCodeType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
