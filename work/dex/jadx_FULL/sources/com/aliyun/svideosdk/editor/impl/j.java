package com.aliyun.svideosdk.editor.impl;

import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.editor.AliyunPasterManager;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Deprecated
class j extends l implements BitmapGenerator {
    private EffectCaption j;

    public j(EffectCaption effectCaption, o oVar, AliyunPasterManager aliyunPasterManager) {
        super(effectCaption, oVar, aliyunPasterManager, false);
        this.j = effectCaption;
    }

    public j(EffectCaption effectCaption, o oVar, AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectCaption, oVar, aliyunPasterManager, z);
        this.j = effectCaption;
    }

    private void c() {
        if (isRevert()) {
            return;
        }
        int pasterTextOffsetX = this.b.getPasterTextOffsetX();
        if (pasterTextOffsetX != 0) {
            this.j.textCenterX = pasterTextOffsetX;
        }
        int pasterTextOffsetY = this.b.getPasterTextOffsetY();
        if (pasterTextOffsetY != 0) {
            this.j.textCenterY = pasterTextOffsetY;
        }
        this.j.textRotation = this.b.getPasterTextRotation();
        int pasterTextWidth = this.b.getPasterTextWidth();
        if (pasterTextWidth != 0) {
            this.j.textWidth = pasterTextWidth;
        }
        int pasterTextHeight = this.b.getPasterTextHeight();
        if (pasterTextHeight != 0) {
            this.j.textHeight = pasterTextHeight;
        }
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public int editCompleted() {
        if (this.b == null) {
            return -4;
        }
        a();
        b();
        c();
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showCaptionPaster(this, this.j);
        }
        int iAddCaptionPaster = this.mRender.addCaptionPaster(this, this.j);
        if (iAddCaptionPaster != 0) {
            return iAddCaptionPaster;
        }
        this.c = true;
        return iAddCaptionPaster;
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public EffectBase getEffect() {
        return this.j;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextHeight() {
        return this.j.textHeight;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetX() {
        return this.j.textCenterX;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextOffsetY() {
        return this.j.textCenterY;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterTextRotation() {
        return this.j.textRotation;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterTextWidth() {
        return this.j.textWidth;
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterExists() {
        return new File(((EffectPaster) this.f25734a).getPath()).exists();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectCaption, com.aliyun.svideosdk.common.struct.effect.EffectText] */
    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setEffect(EffectBase effectBase) {
        if (effectBase instanceof EffectCaption) {
            ?? r2 = (EffectCaption) effectBase;
            this.j = r2;
            this.f25734a = r2;
            this.i = r2;
        }
    }
}
