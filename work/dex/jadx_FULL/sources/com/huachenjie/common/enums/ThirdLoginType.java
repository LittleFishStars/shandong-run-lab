package com.huachenjie.common.enums;

import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/huachenjie/common/enums/ThirdLoginType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "WeiXin", "QQ", "AliPay", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ThirdLoginType {
    WeiXin(1),
    QQ(2),
    AliPay(21);

    private final int type;

    ThirdLoginType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
