package com.aliyun.svideosdk.editor;

import android.graphics.Bitmap;
import android.text.Layout;
import android.view.View;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunPasterBaseView {
    Bitmap getBackgroundBitmap();

    int getPasterCenterX();

    int getPasterCenterY();

    int getPasterHeight();

    float getPasterRotation();

    @Deprecated
    String getPasterTextFont();

    Source getPasterTextFontSource();

    int getPasterTextHeight();

    int getPasterTextOffsetX();

    int getPasterTextOffsetY();

    float getPasterTextRotation();

    int getPasterTextWidth();

    View getPasterView();

    int getPasterWidth();

    String getText();

    Layout.Alignment getTextAlign();

    int getTextBgLabelColor();

    int getTextColor();

    int getTextFixSize();

    int getTextMaxLines();

    int getTextPaddingX();

    int getTextPaddingY();

    int getTextStrokeColor();

    View getTextView();

    boolean isPasterMirrored();

    boolean isTextHasLabel();

    boolean isTextHasStroke();

    Bitmap transToImage();
}
