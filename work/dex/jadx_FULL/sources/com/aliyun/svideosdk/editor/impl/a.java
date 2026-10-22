package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.AliyunPasterBaseView;
import com.aliyun.svideosdk.editor.AliyunPasterController;
import com.aliyun.svideosdk.editor.AliyunPasterManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
abstract class a<T> extends AliyunPasterAbstractController<T> implements AliyunPasterController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f25734a;
    protected AliyunPasterBaseView b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    protected AliyunPasterManager f;

    public a(T t, o oVar, AliyunPasterManager aliyunPasterManager, boolean z) {
        super(t, oVar);
        this.f25734a = t;
        this.c = z;
        this.f = aliyunPasterManager;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextStrokeColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    @Deprecated
    public String getPasterTextFont() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public Source getPasterTextFontSource() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextHeight() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetX() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetY() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterTextRotation() {
        return 0.0f;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextWidth() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public String getText() {
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextBgLabelColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextStrokeColor() {
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isTextHasStroke() {
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterView(AliyunPasterBaseView aliyunPasterBaseView) {
        this.b = aliyunPasterBaseView;
    }
}
