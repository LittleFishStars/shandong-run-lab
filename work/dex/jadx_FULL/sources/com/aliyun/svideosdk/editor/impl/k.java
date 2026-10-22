package com.aliyun.svideosdk.editor.impl;

import android.graphics.PointF;
import android.graphics.RectF;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Log;
import android.view.TextureView;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.project.Frame;
import com.aliyun.svideosdk.common.struct.project.FrameTime;
import com.aliyun.svideosdk.editor.AliyunPasterManager;
import com.aliyun.svideosdk.editor.pplayer.AnimPlayerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class k extends a<EffectPaster> {
    public k(EffectPaster effectPaster, o oVar, AliyunPasterManager aliyunPasterManager) {
        super(effectPaster, oVar, aliyunPasterManager, false);
    }

    public k(EffectPaster effectPaster, o oVar, AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectPaster, oVar, aliyunPasterManager, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        int pasterWidth = this.b.getPasterWidth();
        if (pasterWidth != 0) {
            ((EffectPaster) this.f25734a).width = pasterWidth;
        }
        int pasterHeight = this.b.getPasterHeight();
        if (pasterHeight != 0) {
            ((EffectPaster) this.f25734a).height = pasterHeight;
        }
        if (!isOnlyApplyUI() && !isRevert()) {
            ((EffectPaster) this.f25734a).x = this.b.getPasterCenterX();
            ((EffectPaster) this.f25734a).y = this.b.getPasterCenterY();
        }
        ((EffectPaster) this.f25734a).mirror = this.b.isPasterMirrored();
        ((EffectPaster) this.f25734a).rotation = this.b.getPasterRotation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public AnimPlayerView createPasterPlayer(TextureView textureView) {
        AnimPlayerView animPlayerView = new AnimPlayerView(textureView);
        ArrayList arrayList = new ArrayList();
        for (FrameTime frameTime : ((EffectPaster) this.f25734a).timeArry) {
            arrayList.add(new com.aliyun.svideosdk.editor.pplayer.a((long) (frameTime.beginTime * 1000.0d), (long) (frameTime.endTime * 1000.0d), (long) (frameTime.minTime * 1000.0d), (long) (frameTime.maxTime * 1000.0d), frameTime.shrink));
        }
        for (Frame frame : ((EffectPaster) this.f25734a).frameArry) {
            animPlayerView.addFrameList((long) (frame.time * 1000.0f), frame.pic);
        }
        Log.d("DURATION", "init duration : " + ((EffectPaster) this.f25734a).duration);
        animPlayerView.setAnimationBlocks(arrayList);
        animPlayerView.setMirror(((EffectPaster) this.f25734a).mirror);
        animPlayerView.setDefaltDuration(((EffectPaster) this.f25734a).duration / 1000);
        EffectPaster effectPaster = (EffectPaster) this.f25734a;
        animPlayerView.setPlayTime(effectPaster.start, effectPaster.end);
        animPlayerView.setAnimationPath(((EffectPaster) this.f25734a).getPath() + WVNativeCallbackUtil.SEPERATER + ((EffectPaster) this.f25734a).name);
        animPlayerView.setPreview(false);
        return animPlayerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int editCompleted() {
        if (this.b != null) {
            a();
        }
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showPaster((EffectPaster) this.f25734a);
        }
        int iAddEffectPaster = this.mRender.addEffectPaster((EffectPaster) this.f25734a);
        if (iAddEffectPaster != 0) {
            return iAddEffectPaster;
        }
        this.c = true;
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void editStart() {
        if (isOnlyApplyUI()) {
            return;
        }
        this.mRender.hidePaster((EffectPaster) this.f25734a);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return getPasterDuration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EffectBase getEffect() {
        return (EffectBase) this.f25734a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterCenterX() {
        return ((EffectPaster) this.f25734a).x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterCenterY() {
        return ((EffectPaster) this.f25734a).y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterDuration() {
        EffectPaster effectPaster = (EffectPaster) this.f25734a;
        return effectPaster.end - effectPaster.start;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterDuration(TimeUnit timeUnit) {
        return timeUnit.convert(getPasterDuration(), TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterHeight() {
        return ((EffectPaster) this.f25734a).height;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public String getPasterIconPath() {
        Locale locale = Locale.ENGLISH;
        EffectPaster effectPaster = (EffectPaster) this.f25734a;
        return String.format(locale, "%s/%s%d.png", ((EffectPaster) this.f25734a).getPath(), effectPaster.name, Integer.valueOf(effectPaster.kernelFrame));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterRotation() {
        return ((EffectPaster) this.f25734a).rotation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterStartTime() {
        return ((EffectPaster) this.f25734a).start;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterStartTime(TimeUnit timeUnit) {
        return TimeUnit.MICROSECONDS.toMillis(getPasterStartTime());
    }

    public int getPasterType() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterWidth() {
        return ((EffectPaster) this.f25734a).width;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public PointF getPosition() {
        return new PointF(getPasterCenterX(), getPasterCenterY());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return getPasterRotation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public RectF getSize() {
        return new RectF(0.0f, 0.0f, getPasterWidth(), getPasterHeight());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return getPasterStartTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return getPasterType();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isOnlyApplyUI() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isPasterExists() {
        String path = ((EffectPaster) this.f25734a).getPath();
        if (path == null || path.isEmpty()) {
            return false;
        }
        return new File(path).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterMirrored() {
        return ((EffectPaster) this.f25734a).mirror;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isRevert() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.g
    public int remove() {
        return this.mRender.removePaster((EffectPaster) this.f25734a);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int removePaster() {
        this.f.remove(this);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController, com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j) {
        setPasterDuration(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, TimeUnit timeUnit) {
        setPasterDuration(j, timeUnit);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectPaster] */
    public void setEffect(EffectBase effectBase) {
        if (effectBase instanceof EffectPaster) {
            this.f25734a = (EffectPaster) effectBase;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setOnlyApplyUI(boolean z) {
        this.d = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterDuration(long j) {
        setPasterDuration(j, TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterDuration(long j, TimeUnit timeUnit) {
        ((EffectPaster) this.f25734a).end = getPasterStartTime() + timeUnit.toMicros(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterStartTime(long j) {
        setPasterStartTime(j, TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterStartTime(long j, TimeUnit timeUnit) {
        ((EffectPaster) this.f25734a).end = timeUnit.toMicros(j) + getPasterDuration();
        ((EffectPaster) this.f25734a).start = timeUnit.toMicros(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    @Deprecated
    public void setPosition(PointF pointF) {
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setRevert(boolean z) {
        this.e = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    @Deprecated
    public void setRotate(float f) {
    }

    @Override // com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController, com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j) {
        setPasterStartTime(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, TimeUnit timeUnit) {
        setPasterStartTime(j, timeUnit);
    }
}
