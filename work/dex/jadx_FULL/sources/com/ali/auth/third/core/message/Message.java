package com.ali.auth.third.core.message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Message implements Cloneable {
    public String action;
    public int code;
    public String message;
    public String type;

    public static Message create(int i, Object... objArr) {
        return MessageUtils.createMessage(i, objArr);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
