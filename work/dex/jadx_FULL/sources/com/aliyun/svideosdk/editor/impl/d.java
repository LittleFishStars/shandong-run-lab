package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.aliyun.svideosdk.common.struct.effect.EffectPaint;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.editor.AliyunICanvasController;
import com.aliyun.svideosdk.editor.AliyunIEditor;
import com.aliyun.svideosdk.editor.AliyunIPaint;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d implements AliyunICanvasController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25737a;
    private int b;
    private int c;
    private e d;
    private AliyunIPaint e = new i();
    private AliyunIEditor f;
    private AliyunPasterRender g;
    private AliyunEditorProject h;

    public d(Context context, AliyunEditorProject aliyunEditorProject, AliyunIEditor aliyunIEditor, int i, int i2) {
        this.f25737a = context;
        this.b = i;
        this.c = i2;
        this.f = aliyunIEditor;
        this.g = aliyunIEditor.getPasterRender();
        this.h = aliyunEditorProject;
        e eVar = new e(this.f25737a, this.b, this.c);
        this.d = eVar;
        eVar.setAliyunPaint(this.e);
        this.d.setPath(aliyunEditorProject.getProjectDir().getAbsolutePath() + File.separator + "paint.png");
        if (this.h.getCanvasTrack() == null || this.h.getCanvasTrack().getCanvasInfo() == null) {
            return;
        }
        this.d.a(this.h.getCanvasTrack().getCanvasInfo().convertCoordinate(i, i2, true));
    }

    public int a() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.getCanvasHeight();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public int applyPaintCanvas() {
        this.d.g();
        EffectPaint effectPaint = new EffectPaint();
        effectPaint.setCanvasInfo(this.d.getCanvasInfo());
        effectPaint.setPath(this.d.getPath());
        return com.aliyun.svideosdk.common.a.a(this.g.applyPaintCanvas(effectPaint));
    }

    public int b() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.getCanvasWidth();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void cancel() {
        this.d.b();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void clear() {
        e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void confirm() {
        this.d.d();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public View getCanvas() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public boolean hasCanvasPath() {
        return this.h.getCanvasTrack() != null && new File(this.h.getCanvasTrack().getSource().getPath()).exists();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void release() {
        clear();
        e eVar = this.d;
        if (eVar != null) {
            eVar.f();
        }
        this.f25737a = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void removeCanvas() {
        if (this.f != null) {
            this.g.removeCanvas();
        }
        AliyunEditorProject aliyunEditorProject = this.h;
        if (aliyunEditorProject != null) {
            aliyunEditorProject.removeCanvasTrack();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public int resetPaintCanvas() {
        if (TextUtils.isEmpty(this.d.getPath())) {
            return 0;
        }
        EffectPaint effectPaint = new EffectPaint();
        effectPaint.setCanvasInfo(this.d.getCanvasInfo());
        effectPaint.setPath(this.d.getPath());
        return com.aliyun.svideosdk.common.a.a(this.g.applyPaintCanvas(effectPaint));
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setCurrentColor(int i) {
        this.e.setCurrentColor(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setCurrentSize(float f) {
        this.e.setCurrentSize(f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void setPaint(Paint paint) {
        this.e.setPaint(paint);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICanvasController
    public void undo() {
        this.d.i();
    }
}
