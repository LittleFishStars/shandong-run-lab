package com.aliyun.svideosdk.editor.e.f;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b extends TextView implements a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f25721a;

    public b(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.f25721a = a.a(this, attributeSet, i).a((a.d) this);
    }

    @Override // com.aliyun.svideosdk.editor.e.f.a.d
    public void a(float f, float f2) {
    }

    public a getAutofitHelper() {
        return this.f25721a;
    }

    public float getMaxTextSize() {
        return this.f25721a.b();
    }

    public float getMinTextSize() {
        return this.f25721a.c();
    }

    public float getPrecision() {
        return this.f25721a.d();
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        super.setLines(i);
        a aVar = this.f25721a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        a aVar = this.f25721a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setMaxTextSize(float f) {
        this.f25721a.a(f);
    }

    public void setMinTextSize(int i) {
        this.f25721a.b(2, i);
    }

    public void setPrecision(float f) {
        this.f25721a.b(f);
    }

    public void setSizeToFit(boolean z) {
        this.f25721a.a(z);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        a aVar = this.f25721a;
        if (aVar != null) {
            aVar.c(i, f);
        }
    }
}
