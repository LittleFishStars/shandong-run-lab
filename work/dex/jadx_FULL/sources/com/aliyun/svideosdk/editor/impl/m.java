package com.aliyun.svideosdk.editor.impl;

import android.text.Layout;
import android.util.Log;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.SubTitleTrack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class m {
    public static float d = 640.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25750a = 0;
    private int b = 0;
    public int c;

    public void a(int i, int i2) {
        this.f25750a = i;
        this.b = i2;
        this.c = Math.min(i, i2);
    }

    public void a(EffectPaster effectPaster, PhotoPasterTrack photoPasterTrack) {
        if (this.c == 0 || this.f25750a == 0 || this.b == 0) {
            Log.e("AliYunLog", "Please set valid ConvertWidthAndHeight");
            return;
        }
        photoPasterTrack.setId(effectPaster.getViewId());
        photoPasterTrack.setX(effectPaster.x / effectPaster.displayWidth);
        photoPasterTrack.setY(effectPaster.y / effectPaster.displayHeight);
        photoPasterTrack.setWidth(effectPaster.width / effectPaster.displayWidth);
        photoPasterTrack.setHeight(effectPaster.height / effectPaster.displayHeight);
        photoPasterTrack.setRotation(effectPaster.rotation);
        photoPasterTrack.setMirror(effectPaster.mirror);
        photoPasterTrack.setTimelineIn(effectPaster.start / 1000000.0f);
        photoPasterTrack.setTimelineOut(effectPaster.end / 1000000.0f);
        if (effectPaster.getPasterType() == 0) {
            photoPasterTrack.setSource(effectPaster.getSource());
            return;
        }
        if (effectPaster.getPasterType() == 1 || effectPaster.getPasterType() == 2) {
            EffectText effectText = (EffectText) effectPaster;
            SubTitleTrack subTitleTrack = (SubTitleTrack) photoPasterTrack;
            subTitleTrack.setText(effectText.text);
            subTitleTrack.setTextColor(effectText.textColor);
            subTitleTrack.setTextStrokeColor(effectText.textStrokeColor);
            subTitleTrack.setFont(effectText.getFontSource());
            subTitleTrack.setTextBmpPath(effectText.textBmpPath);
            subTitleTrack.setTextWidth(effectText.textWidth / effectPaster.displayWidth);
            subTitleTrack.setTextHeight(effectText.textHeight / effectPaster.displayHeight);
            subTitleTrack.setTextBackgroundColor(effectText.textLabelColor);
            subTitleTrack.setBackgroundImgPath(new Source(effectText.mBackgroundBmpPath));
            subTitleTrack.setTextSize(effectText.mTextSize / Math.min(effectPaster.displayWidth, effectPaster.displayHeight));
            subTitleTrack.setTextPaddingX(effectText.mTextPaddingX / effectPaster.displayWidth);
            subTitleTrack.setTextPaddingY(effectText.mTextPaddingY / effectPaster.displayHeight);
            Layout.Alignment alignment = effectText.mTextAlignment;
            if (alignment != null) {
                subTitleTrack.setTextAlignment(alignment.ordinal());
            }
            subTitleTrack.setTextMaxLines(effectText.mTextMaxLines);
            if (effectPaster.getPasterType() == 2) {
                EffectCaption effectCaption = (EffectCaption) effectPaster;
                photoPasterTrack.setSource(effectPaster.getSource());
                BubbleCaptionTrack bubbleCaptionTrack = (BubbleCaptionTrack) photoPasterTrack;
                bubbleCaptionTrack.setTextCenterX(effectCaption.textCenterX / effectPaster.width);
                bubbleCaptionTrack.setTextCenterY(effectCaption.textCenterY / effectPaster.height);
            }
        }
    }

    public void a(EffectText effectText, SubTitleTrack subTitleTrack) {
        effectText.text = subTitleTrack.getText();
        effectText.dTextColor = subTitleTrack.getTextColor();
        effectText.textColor = subTitleTrack.getTextColor();
        effectText.dTextStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.textStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.hasLabel = subTitleTrack.getTextBackgroundColor() == 0;
        effectText.textLabelColor = subTitleTrack.getTextBackgroundColor();
        if (subTitleTrack.getFont() != null && !com.aliyun.common.utils.q.b(subTitleTrack.getFont().getPath())) {
            effectText.font = subTitleTrack.getFont().getPath();
            effectText.fontSource = subTitleTrack.getFont();
        }
        effectText.textBmpPath = subTitleTrack.getTextBmpPath();
        if (subTitleTrack.getBackgroundImgPath() != null && !com.aliyun.common.utils.q.b(subTitleTrack.getBackgroundImgPath().getPath())) {
            effectText.mBackgroundBmpPath = subTitleTrack.getBackgroundImgPath().getPath();
        }
        float f = this.c / d;
        float textWidth = subTitleTrack.getTextWidth();
        float textHeight = subTitleTrack.getTextHeight();
        effectText.textWidth = (int) (textWidth * f);
        effectText.textHeight = (int) (textHeight * f);
        effectText.mTextSize = (int) (subTitleTrack.getTextSize() * f);
        effectText.mTextPaddingX = (int) (subTitleTrack.getTextPaddingX() * f);
        effectText.mTextPaddingY = (int) (subTitleTrack.getTextPaddingY() * f);
        effectText.mTextAlignment = (subTitleTrack.getTextAlignment() < 0 || subTitleTrack.getTextAlignment() > 2) ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.values()[subTitleTrack.getTextAlignment()];
        effectText.mTextMaxLines = subTitleTrack.getTextMaxLines();
        if (effectText instanceof EffectCaption) {
            EffectCaption effectCaption = (EffectCaption) effectText;
            effectCaption.textRotation = subTitleTrack.getTextRotation();
            effectCaption.preBegin = (long) (subTitleTrack.getPreBegin() * 1000000.0f);
            effectCaption.preEnd = (long) (subTitleTrack.getPreEnd() * 1000000.0f);
            BubbleCaptionTrack bubbleCaptionTrack = (BubbleCaptionTrack) subTitleTrack;
            effectCaption.textCenterX = (int) (bubbleCaptionTrack.getTextCenterX() * f);
            effectCaption.textCenterY = (int) (bubbleCaptionTrack.getTextCenterY() * f);
        }
    }

    public boolean a() {
        return this.f25750a > 0 && this.b > 0;
    }

    public void b(EffectPaster effectPaster, PhotoPasterTrack photoPasterTrack) {
        float f = this.c / d;
        effectPaster.width = (int) (photoPasterTrack.getWidth() * f);
        effectPaster.height = (int) (photoPasterTrack.getHeight() * f);
        if (a()) {
            float x = photoPasterTrack.getX();
            float y = photoPasterTrack.getY() * f;
            float width = x * f;
            int i = this.f25750a;
            int i2 = this.b;
            if (i > i2) {
                if (d - photoPasterTrack.getWidth() != 0.0f) {
                    int i3 = effectPaster.width;
                    float f2 = (((this.f25750a * i3) / this.b) - i3) / 2.0f;
                    float height = photoPasterTrack.getHeight();
                    float f3 = d;
                    width += (f2 * (height - (f3 / 2.0f))) / ((f3 - photoPasterTrack.getWidth()) / 2.0f);
                }
            } else if (i2 > i && d - photoPasterTrack.getHeight() != 0.0f) {
                int i4 = effectPaster.height;
                float f4 = (((this.b * i4) / this.f25750a) - i4) / 2.0f;
                float y2 = photoPasterTrack.getY();
                float f5 = d;
                y += (f4 * (y2 - (f5 / 2.0f))) / ((f5 - photoPasterTrack.getHeight()) / 2.0f);
            }
            float f6 = (this.f25750a / 2) - width;
            float f7 = (this.b / 2) - y;
            effectPaster.x = ((photoPasterTrack.getX() / d) * this.f25750a) - f6;
            float y3 = photoPasterTrack.getY() / d;
            int i5 = this.b;
            effectPaster.y = (y3 * i5) - f7;
            effectPaster.displayWidth = this.f25750a;
            effectPaster.displayHeight = i5;
        }
        effectPaster.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
        long timelineOut = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
        effectPaster.end = timelineOut;
        effectPaster.duration = timelineOut - effectPaster.start;
        effectPaster.rotation = photoPasterTrack.getRotation();
        effectPaster.mirror = photoPasterTrack.isMirror();
        effectPaster.name = photoPasterTrack.getName();
        effectPaster.frameArry = photoPasterTrack.getFrameArray();
        effectPaster.timeArry = photoPasterTrack.getTimeArray();
    }

    public void b(EffectText effectText, SubTitleTrack subTitleTrack) {
        effectText.text = subTitleTrack.getText();
        effectText.dTextColor = subTitleTrack.getTextColor();
        effectText.textColor = subTitleTrack.getTextColor();
        effectText.dTextStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.textStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.hasLabel = subTitleTrack.getTextBackgroundColor() == 0;
        effectText.textLabelColor = subTitleTrack.getTextBackgroundColor();
        if (subTitleTrack.getFont() != null && !com.aliyun.common.utils.q.b(subTitleTrack.getFont().getPath())) {
            effectText.font = subTitleTrack.getFont().getPath();
            effectText.fontSource = subTitleTrack.getFont();
        }
        effectText.textBmpPath = subTitleTrack.getTextBmpPath();
        if (subTitleTrack.getBackgroundImgPath() != null && !com.aliyun.common.utils.q.b(subTitleTrack.getBackgroundImgPath().getPath())) {
            effectText.mBackgroundBmpPath = subTitleTrack.getBackgroundImgPath().getPath();
        }
        float textWidth = subTitleTrack.getTextWidth();
        float textHeight = subTitleTrack.getTextHeight();
        effectText.textWidth = (int) (textWidth * this.f25750a);
        effectText.textHeight = (int) (textHeight * this.b);
        effectText.mTextSize = (int) (subTitleTrack.getTextSize() * Math.min(this.f25750a, this.b));
        effectText.mTextPaddingX = (int) (subTitleTrack.getTextPaddingX() * this.f25750a);
        effectText.mTextPaddingY = (int) (subTitleTrack.getTextPaddingY() * this.b);
        effectText.mTextAlignment = (subTitleTrack.getTextAlignment() < 0 || subTitleTrack.getTextAlignment() > 2) ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.values()[subTitleTrack.getTextAlignment()];
        effectText.mTextMaxLines = subTitleTrack.getTextMaxLines();
        if (effectText instanceof EffectCaption) {
            EffectCaption effectCaption = (EffectCaption) effectText;
            effectCaption.textRotation = subTitleTrack.getTextRotation();
            effectCaption.preBegin = (long) (subTitleTrack.getPreBegin() * 1000000.0f);
            effectCaption.preEnd = (long) (subTitleTrack.getPreEnd() * 1000000.0f);
            BubbleCaptionTrack bubbleCaptionTrack = (BubbleCaptionTrack) subTitleTrack;
            effectCaption.textCenterX = (int) (bubbleCaptionTrack.getTextCenterX() * effectText.width);
            effectCaption.textCenterY = (int) (bubbleCaptionTrack.getTextCenterY() * effectText.height);
        }
    }

    public void c(EffectPaster effectPaster, PhotoPasterTrack photoPasterTrack) {
        effectPaster.width = (int) (photoPasterTrack.getWidth() * this.f25750a);
        effectPaster.height = (int) (photoPasterTrack.getHeight() * this.b);
        if (a()) {
            effectPaster.x = photoPasterTrack.getX() * this.f25750a;
            float y = photoPasterTrack.getY();
            int i = this.b;
            effectPaster.y = y * i;
            effectPaster.displayWidth = this.f25750a;
            effectPaster.displayHeight = i;
        }
        effectPaster.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
        long timelineOut = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
        effectPaster.end = timelineOut;
        effectPaster.duration = timelineOut - effectPaster.start;
        effectPaster.rotation = photoPasterTrack.getRotation();
        effectPaster.mirror = photoPasterTrack.isMirror();
        effectPaster.name = photoPasterTrack.getName();
        effectPaster.frameArry = photoPasterTrack.getFrameArray();
        effectPaster.timeArry = photoPasterTrack.getTimeArray();
    }
}
