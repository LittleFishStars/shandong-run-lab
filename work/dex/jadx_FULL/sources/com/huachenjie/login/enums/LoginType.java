package com.huachenjie.login.enums;

import com.king.zxing.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/huachenjie/login/enums/LoginType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", e.f.d, "SMS_CODE", "login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum LoginType {
    PASSWORD(1),
    SMS_CODE(2);

    private final int value;

    LoginType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
