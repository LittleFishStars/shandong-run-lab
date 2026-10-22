package com.aliyun.svideosdk.editor;

import android.view.TextureView;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.pplayer.AnimPlayerView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunPasterController extends AliyunIPasterController {
    AnimPlayerView createPasterPlayer(TextureView textureView);

    int editCompleted();

    void editStart();

    int getConfigTextColor();

    int getConfigTextStrokeColor();

    EffectBase getEffect();

    float getPasterCenterX();

    float getPasterCenterY();

    long getPasterDuration();

    long getPasterDuration(TimeUnit timeUnit);

    int getPasterHeight();

    String getPasterIconPath();

    float getPasterRotation();

    long getPasterStartTime();

    long getPasterStartTime(TimeUnit timeUnit);

    @Deprecated
    String getPasterTextFont();

    Source getPasterTextFontSource();

    int getPasterTextHeight();

    int getPasterTextOffsetX();

    int getPasterTextOffsetY();

    float getPasterTextRotation();

    int getPasterTextWidth();

    int getPasterType();

    int getPasterWidth();

    String getText();

    int getTextBgLabelColor();

    int getTextColor();

    int getTextStrokeColor();

    boolean isOnlyApplyUI();

    boolean isPasterExists();

    boolean isPasterMirrored();

    boolean isRevert();

    boolean isTextHasStroke();

    @Deprecated
    int removePaster();

    void setEffect(EffectBase effectBase);

    void setOnlyApplyUI(boolean z);

    void setPasterDuration(long j);

    void setPasterDuration(long j, TimeUnit timeUnit);

    void setPasterStartTime(long j);

    void setPasterStartTime(long j, TimeUnit timeUnit);

    void setPasterView(AliyunPasterBaseView aliyunPasterBaseView);

    void setRevert(boolean z);
}
