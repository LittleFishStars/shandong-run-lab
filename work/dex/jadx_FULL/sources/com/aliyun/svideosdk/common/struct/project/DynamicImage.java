package com.aliyun.svideosdk.common.struct.project;

import android.graphics.Color;
import android.text.TextUtils;
import com.aliyun.common.f.a;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DynamicImage implements a, Serializable {
    public static final int TYPE_FACE = 1;
    public static final int TYPE_NORMAL = 2;
    public static final int TYPE_TEXT = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25676a;
    public float c;
    public float du;
    public int extendSection;
    public float fh;
    public long fid;
    public long fontId;
    public List<Frame> frameArry;
    public float fw;
    public float fx;
    public float fy;
    public float h;
    public boolean hasTextLabel;
    public int kernelFrame = -1;
    public String n;
    public int pExtend;
    public String pText;
    public String path;
    public long pid;
    public int strokeB;
    public int strokeG;
    public int strokeR;
    public int strokeWidth;
    public float tAngle;
    public int tB;
    public float tBegin;
    public float tEnd;
    public String tFont;
    public int tG;
    public float tHeight;
    public float tLeft;
    public float tMaxSize;
    public float tMinSize;
    public int tR;
    public float tSize;
    public float tTop;
    public float tWidth;
    public int textLabelColor;
    public List<FrameTime> timeArry;
    public int type;
    public boolean variableLab;
    public float variableLabHeight;
    public float variableLabLeft;
    public String variableLabText;
    public float variableLabTop;
    public String variableLabType;
    public float variableLabWidth;
    public float w;
    public float x;
    public float y;

    public static DynamicImage getTextOnlyConfig() {
        DynamicImage dynamicImage = new DynamicImage();
        dynamicImage.pid = 1L;
        dynamicImage.fid = 1L;
        dynamicImage.du = 1.0f;
        dynamicImage.type = 0;
        dynamicImage.x = 320.0f;
        dynamicImage.y = 320.0f;
        dynamicImage.w = 470.0f;
        dynamicImage.h = 160.0f;
        dynamicImage.f25676a = 0.0f;
        dynamicImage.fx = 0.0f;
        dynamicImage.fy = 0.0f;
        dynamicImage.fw = 0.0f;
        dynamicImage.fh = 0.0f;
        dynamicImage.n = "text_sample";
        dynamicImage.c = 8.0f;
        dynamicImage.pText = "请输入文字";
        dynamicImage.tFont = "SentyTEA";
        dynamicImage.tMinSize = 21.0f;
        dynamicImage.tSize = 48.0f;
        dynamicImage.tLeft = 235.0f;
        dynamicImage.tTop = 80.0f;
        dynamicImage.tWidth = 460.0f;
        dynamicImage.tHeight = 120.0f;
        dynamicImage.strokeR = 51;
        dynamicImage.strokeG = 51;
        dynamicImage.strokeB = 51;
        dynamicImage.strokeWidth = 4;
        dynamicImage.pExtend = 1;
        dynamicImage.extendSection = 0;
        dynamicImage.tR = 255;
        dynamicImage.tG = 255;
        dynamicImage.tB = 255;
        dynamicImage.tBegin = 0.0f;
        dynamicImage.tEnd = 1.0f;
        return dynamicImage;
    }

    public void fillPaster(SubTitleTrack subTitleTrack) {
        subTitleTrack.setWidth(this.w);
        subTitleTrack.setHeight(this.h);
        subTitleTrack.setX(this.x);
        subTitleTrack.setY(this.y);
        subTitleTrack.setName(this.n);
        subTitleTrack.setTimelineIn(0.0f);
        subTitleTrack.setTimelineOut(this.du);
        subTitleTrack.setPreBegin(this.tBegin);
        subTitleTrack.setPreEnd(this.tEnd);
        subTitleTrack.setTextColor(getTextColor());
        subTitleTrack.setTextStrokeColor(getTextStrokeColor());
        subTitleTrack.setRotation(0.0f);
        subTitleTrack.setTextRotation((float) Math.toRadians(this.tAngle));
        subTitleTrack.setText(this.pText);
        subTitleTrack.setTextWidth(this.tWidth);
        subTitleTrack.setTextHeight(this.tHeight);
        subTitleTrack.setFrameArray(this.frameArry);
        subTitleTrack.setTimeArray(this.timeArry);
        subTitleTrack.setTextBackgroundColor(this.textLabelColor);
        if (subTitleTrack instanceof BubbleCaptionTrack) {
            BubbleCaptionTrack bubbleCaptionTrack = (BubbleCaptionTrack) subTitleTrack;
            bubbleCaptionTrack.setTextCenterX(this.tLeft);
            bubbleCaptionTrack.setTextCenterY(this.tTop);
        }
    }

    public float getA() {
        return this.f25676a;
    }

    public float getC() {
        return this.c;
    }

    public float getDu() {
        return this.du;
    }

    public int getExtendSection() {
        return this.extendSection;
    }

    public float getFh() {
        return this.fh;
    }

    public long getFid() {
        return this.fid;
    }

    public long getFontId() {
        return this.fontId;
    }

    public List<Frame> getFrameArry() {
        return this.frameArry;
    }

    public float getFw() {
        return this.fw;
    }

    public float getFx() {
        return this.fx;
    }

    public float getFy() {
        return this.fy;
    }

    public float getH() {
        return this.h;
    }

    public String getN() {
        return this.n;
    }

    public String getPath() {
        return this.path;
    }

    public long getPid() {
        return this.pid;
    }

    public int getStrokeB() {
        return this.strokeB;
    }

    public int getStrokeG() {
        return this.strokeG;
    }

    public int getStrokeR() {
        return this.strokeR;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getTextColor() {
        return Color.argb(255, this.tR, this.tG, this.tB);
    }

    public int getTextStrokeColor() {
        return Color.argb(255, this.strokeR, this.strokeG, this.strokeB);
    }

    public List<FrameTime> getTimeArry() {
        return this.timeArry;
    }

    public int getType() {
        return this.type;
    }

    public float getVariableLabHeight() {
        return this.variableLabHeight;
    }

    public float getVariableLabLeft() {
        return this.variableLabLeft;
    }

    public String getVariableLabText() {
        return this.variableLabText;
    }

    public float getVariableLabTop() {
        return this.variableLabTop;
    }

    public String getVariableLabType() {
        return this.variableLabType;
    }

    public float getVariableLabWidth() {
        return this.variableLabWidth;
    }

    public float getW() {
        return this.w;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public String getpText() {
        return this.pText;
    }

    public float gettAngle() {
        return this.tAngle;
    }

    public int gettB() {
        return this.tB;
    }

    public float gettBegin() {
        return this.tBegin;
    }

    public float gettEnd() {
        return this.tEnd;
    }

    public String gettFont() {
        return this.tFont;
    }

    public int gettG() {
        return this.tG;
    }

    public float gettHeight() {
        return this.tHeight;
    }

    public float gettLeft() {
        return this.tLeft;
    }

    public float gettMaxSize() {
        return this.tMaxSize;
    }

    public float gettMinSize() {
        return this.tMinSize;
    }

    public int gettR() {
        return this.tR;
    }

    public float gettSize() {
        return this.tSize;
    }

    public float gettTop() {
        return this.tTop;
    }

    public float gettWidth() {
        return this.tWidth;
    }

    public boolean isVariableLab() {
        return this.variableLab;
    }

    public int ispExtend() {
        return this.pExtend;
    }

    public void setA(float f) {
        this.f25676a = f;
    }

    public void setC(float f) {
        this.c = f;
    }

    public void setDu(float f) {
        this.du = f;
    }

    public void setExtendSection(int i) {
        this.extendSection = i;
    }

    public void setFh(float f) {
        this.fh = f;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public void setFontId(long j) {
        this.fontId = j;
    }

    public void setFrameArry(List<Frame> list) {
        this.frameArry = list;
    }

    public void setFw(float f) {
        this.fw = f;
    }

    public void setFx(float f) {
        this.fx = f;
    }

    public void setFy(float f) {
        this.fy = f;
    }

    public void setH(float f) {
        this.h = f;
    }

    public void setKernelFrame(int i) {
        this.kernelFrame = i;
    }

    public void setN(String str) {
        this.n = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPid(long j) {
        this.pid = j;
    }

    public void setStrokeB(int i) {
        this.strokeB = i;
    }

    public void setStrokeG(int i) {
        this.strokeG = i;
    }

    public void setStrokeR(int i) {
        this.strokeR = i;
    }

    public void setStrokeWidth(int i) {
        this.strokeWidth = i;
    }

    public void setTimeArry(List<FrameTime> list) {
        this.timeArry = list;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVariableLab(boolean z) {
        this.variableLab = z;
    }

    public void setVariableLabHeight(float f) {
        this.variableLabHeight = f;
    }

    public void setVariableLabLeft(float f) {
        this.variableLabLeft = f;
    }

    public void setVariableLabText(String str) {
        this.variableLabText = str;
    }

    public void setVariableLabTop(float f) {
        this.variableLabTop = f;
    }

    public void setVariableLabType(String str) {
        this.variableLabType = str;
    }

    public void setVariableLabWidth(float f) {
        this.variableLabWidth = f;
    }

    public void setW(float f) {
        this.w = f;
    }

    public void setX(float f) {
        this.x = f;
    }

    public void setY(float f) {
        this.y = f;
    }

    public void setpExtend(int i) {
        this.pExtend = i;
    }

    public void setpText(String str) {
        this.pText = str;
    }

    public void settAngle(float f) {
        this.tAngle = f;
    }

    public void settB(int i) {
        this.tB = i;
    }

    public void settBegin(float f) {
        this.tBegin = f;
    }

    public void settEnd(float f) {
        this.tEnd = f;
    }

    public void settFont(String str) {
        this.tFont = str;
    }

    public void settG(int i) {
        this.tG = i;
    }

    public void settHeight(float f) {
        this.tHeight = f;
    }

    public void settLeft(float f) {
        this.tLeft = f;
    }

    public void settMaxSize(float f) {
        this.tMaxSize = f;
    }

    public void settMinSize(float f) {
        this.tMinSize = f;
    }

    public void settR(int i) {
        this.tR = i;
    }

    public void settSize(float f) {
        this.tSize = f;
    }

    public void settTop(float f) {
        this.tTop = f;
    }

    public void settWidth(float f) {
        this.tWidth = f;
    }

    @Override // com.aliyun.common.f.a
    public boolean validate() {
        List<FrameTime> list;
        if (TextUtils.equals(this.n, "text_sample")) {
            return true;
        }
        List<Frame> list2 = this.frameArry;
        return (list2 == null || list2.isEmpty() || (list = this.timeArry) == null || list.isEmpty()) ? false : true;
    }
}
