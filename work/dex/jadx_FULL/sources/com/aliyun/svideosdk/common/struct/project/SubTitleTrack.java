package com.aliyun.svideosdk.common.struct.project;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class SubTitleTrack extends PhotoPasterTrack {

    @SerializedName("BackgroundImgPath")
    private Source mBackgroundImgPath;

    @SerializedName("Font")
    private Source mFont;
    private transient float mPreBegin;
    private transient float mPreEnd;

    @SerializedName("Text")
    private String mText;

    @SerializedName("TextAlignment")
    private int mTextAlignment;

    @SerializedName("TextBgColor")
    private int mTextBackgroundColor = 0;

    @SerializedName("TextBmpPath")
    private String mTextBmpPath;

    @SerializedName("TextColor")
    private int mTextColor;

    @SerializedName("TextHeight")
    private float mTextHeight;

    @SerializedName("TextMaxLines")
    private int mTextMaxLines;

    @SerializedName("TextPaddingX")
    private float mTextPaddingX;

    @SerializedName("TextPaddingY")
    private float mTextPaddingY;
    private transient float mTextRotation;

    @SerializedName("TextSize")
    private float mTextSize;

    @SerializedName("OutlineColor")
    private int mTextStrokeColor;

    @SerializedName("TextWidth")
    private float mTextWidth;

    public SubTitleTrack() {
        setType(PasterTrack.Type.subtitle);
    }

    public Source getBackgroundImgPath() {
        return this.mBackgroundImgPath;
    }

    public Source getFont() {
        return this.mFont;
    }

    public float getPreBegin() {
        return this.mPreBegin;
    }

    public float getPreEnd() {
        return this.mPreEnd;
    }

    public String getText() {
        return this.mText;
    }

    public int getTextAlignment() {
        return this.mTextAlignment;
    }

    public int getTextBackgroundColor() {
        return this.mTextBackgroundColor;
    }

    public String getTextBmpPath() {
        return this.mTextBmpPath;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextHeight() {
        return this.mTextHeight;
    }

    public int getTextMaxLines() {
        return this.mTextMaxLines;
    }

    public float getTextPaddingX() {
        return this.mTextPaddingX;
    }

    public float getTextPaddingY() {
        return this.mTextPaddingY;
    }

    public float getTextRotation() {
        return this.mTextRotation;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public int getTextStrokeColor() {
        return this.mTextStrokeColor;
    }

    public float getTextWidth() {
        return this.mTextWidth;
    }

    public void setBackgroundImgPath(Source source) {
        this.mBackgroundImgPath = source;
    }

    public void setFont(Source source) {
        this.mFont = source;
    }

    public void setPreBegin(float f) {
        this.mPreBegin = f;
    }

    public void setPreEnd(float f) {
        this.mPreEnd = f;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextAlignment(int i) {
        this.mTextAlignment = i;
    }

    public void setTextBackgroundColor(int i) {
        this.mTextBackgroundColor = i;
    }

    public void setTextBmpPath(String str) {
        this.mTextBmpPath = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTextHeight(float f) {
        this.mTextHeight = f;
    }

    public void setTextMaxLines(int i) {
        this.mTextMaxLines = i;
    }

    public void setTextPaddingX(float f) {
        this.mTextPaddingX = f;
    }

    public void setTextPaddingY(float f) {
        this.mTextPaddingY = f;
    }

    public void setTextRotation(float f) {
        this.mTextRotation = f;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
    }

    public void setTextStrokeColor(int i) {
        this.mTextStrokeColor = i;
    }

    public void setTextWidth(float f) {
        this.mTextWidth = f;
    }
}
