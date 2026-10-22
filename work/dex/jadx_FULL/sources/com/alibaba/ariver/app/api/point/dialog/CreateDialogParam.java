package com.alibaba.ariver.app.api.point.dialog;

import android.content.DialogInterface;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateDialogParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23821a;
    public AgreementClickListener agreementListener;
    public Map<String, Agreement> agreements;
    private String b;
    private String c;
    public String cancelColor;
    public DialogInterface.OnCancelListener cancelListener;
    public boolean cancelable = false;
    private String d;
    private String e;
    public DialogInterface.OnClickListener negativeListener;
    public String negativeTextColor;
    public DialogInterface.OnClickListener positiveListener;
    public String positiveTextColor;

    public static class Agreement {
        public boolean hasPermission;
        public String tag;
        public String text;
        public String url;
    }

    public interface AgreementClickListener {
        void onClick(String str);
    }

    public CreateDialogParam(String str, String str2, String str3, String str4, String str5) {
        this.f23821a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public String getAlign() {
        return this.e;
    }

    public String getMessage() {
        return this.b;
    }

    public String getNegativeString() {
        return this.d;
    }

    public String getPositiveString() {
        return this.c;
    }

    public String getTitle() {
        return this.f23821a;
    }
}
