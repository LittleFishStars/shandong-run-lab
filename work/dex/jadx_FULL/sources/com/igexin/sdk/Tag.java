package com.igexin.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class Tag implements Serializable {
    private static final long serialVersionUID = 7265815580156141684L;
    private String name;

    private boolean isValidTagName(String str) {
        boolean z = false;
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            z = (cCharAt >= 19968 && cCharAt <= 40869) || (cCharAt >= 'A' && cCharAt <= 'Z') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '+' || cCharAt == '-' || cCharAt == '*' || cCharAt == '_' || cCharAt == ' ' || cCharAt == ':'));
            if (!z) {
                break;
            }
        }
        return z;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValidTagValue(String str) {
        return isValidTagName(str);
    }

    public Tag setName(String str) {
        this.name = str;
        return this;
    }
}
