package com.aliyun.svideosdk.editor;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaint;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunPasterRender {
    int addCaption(AliyunCaption aliyunCaption);

    @Deprecated
    int addCaptionPaster(Bitmap bitmap, EffectCaption effectCaption);

    @Deprecated
    int addCaptionPaster(BitmapGenerator bitmapGenerator, EffectCaption effectCaption);

    int addEffectPaster(EffectPaster effectPaster);

    @Deprecated
    int addSubtitle(Bitmap bitmap, EffectText effectText);

    @Deprecated
    int addSubtitle(BitmapGenerator bitmapGenerator, EffectText effectText);

    int applyPaintCanvas(EffectPaint effectPaint);

    List<AliyunCaption> findCaptions(long j);

    Size getDisplaySize();

    int hidePaster(EffectPaster effectPaster);

    void removeCanvas();

    int removeCaption(AliyunCaption aliyunCaption);

    int removePaster(EffectPaster effectPaster);

    void setDisplaySize(int i, int i2);

    int setEffectWaterMark(EffectImage effectImage);

    void setOnPasterResumeAndSave(OnPasterResumeAndSave onPasterResumeAndSave);

    int showCaptionPaster(Bitmap bitmap, EffectCaption effectCaption);

    int showCaptionPaster(BitmapGenerator bitmapGenerator, EffectCaption effectCaption);

    int showPaster(EffectPaster effectPaster);

    int showTextPaster(Bitmap bitmap, EffectText effectText);

    int showTextPaster(BitmapGenerator bitmapGenerator, EffectText effectText);

    int updateCaption(AliyunCaption aliyunCaption);
}
