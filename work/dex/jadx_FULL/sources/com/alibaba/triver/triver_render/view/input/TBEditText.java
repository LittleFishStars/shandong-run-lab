package com.alibaba.triver.triver_render.view.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f25237a;

    public interface a {
        void a();
    }

    public TBEditText(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return super.onKeyPreIme(i, keyEvent);
        }
        super.onKeyPreIme(i, keyEvent);
        a aVar = this.f25237a;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return false;
    }

    public void setKeyBordHideListener(a aVar) {
        this.f25237a = aVar;
    }

    public TBEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TBEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public TBEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
