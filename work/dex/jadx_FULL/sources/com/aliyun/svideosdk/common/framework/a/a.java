package com.aliyun.svideosdk.common.framework.a;

import com.aliyun.svideosdk.common.framework.AliyunIStickerController;
import com.aliyun.svideosdk.common.struct.effect.ICopyable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a<MODEL extends ICopyable<MODEL>> implements AliyunIStickerController {
    protected long mDuration;
    protected EnumC0218a mEditMode = EnumC0218a.Editing;
    protected MODEL mModelBeforeEdit = null;
    protected MODEL mModel = null;

    /* JADX INFO: renamed from: com.aliyun.svideosdk.common.framework.a.a$a, reason: collision with other inner class name */
    public enum EnumC0218a {
        Idle,
        Editing
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void beginEdit() {
        EnumC0218a enumC0218a = this.mEditMode;
        EnumC0218a enumC0218a2 = EnumC0218a.Editing;
        if (enumC0218a == enumC0218a2) {
            return;
        }
        this.mEditMode = enumC0218a2;
        this.mModelBeforeEdit = (MODEL) this.mModel.copy();
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void cancelEdit() {
        MODEL model;
        if (this.mEditMode != EnumC0218a.Editing || (model = this.mModelBeforeEdit) == null) {
            return;
        }
        this.mModel.copy(model);
        this.mEditMode = EnumC0218a.Idle;
        this.mModelBeforeEdit = null;
    }

    @Override // com.aliyun.svideosdk.common.framework.AliyunIStickerController
    public void endEdit() {
        if (this.mEditMode == EnumC0218a.Editing) {
            this.mEditMode = EnumC0218a.Idle;
            onUpdate(this.mModel);
            this.mModelBeforeEdit = null;
        }
    }

    public abstract void onUpdate(MODEL model);
}
