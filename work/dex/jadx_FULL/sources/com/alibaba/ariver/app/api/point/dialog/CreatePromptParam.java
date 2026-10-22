package com.alibaba.ariver.app.api.point.dialog;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreatePromptParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23822a;
    private String b;
    private String c;
    public String cancelColor;
    public DialogInterface.OnCancelListener cancelListener;
    public boolean cancelable = true;
    private String d;
    private String e;
    public DialogInterface.OnClickListener negativeListener;
    public String negativeTextColor;
    public PositiveListener positiveListener;
    public String positiveTextColor;

    public interface PositiveListener {
        void onClick(DialogInterface dialogInterface, String str);
    }

    public CreatePromptParam(String str, String str2, String str3, String str4, String str5) {
        this.f23822a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public String getMessage() {
        return this.b;
    }

    public String getNegativeString() {
        return this.d;
    }

    public String getPlaceHolder() {
        return this.e;
    }

    public String getPositiveString() {
        return this.c;
    }

    public String getTitle() {
        return this.f23822a;
    }
}
