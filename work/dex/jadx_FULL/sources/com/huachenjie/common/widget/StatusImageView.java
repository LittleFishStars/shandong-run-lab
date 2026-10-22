package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class StatusImageView extends AppCompatImageView {

    public interface StatusImage {
        Drawable getStatusImage();

        int getStatusImageRes();
    }

    public StatusImageView(@NonNull Context context) {
        super(context);
    }

    public void setStatusImage(StatusImage statusImage) {
        if (statusImage == null) {
            return;
        }
        if (statusImage.getStatusImageRes() > 0) {
            setImageResource(statusImage.getStatusImageRes());
        } else if (statusImage.getStatusImage() != null) {
            setImageDrawable(statusImage.getStatusImage());
        }
    }

    public StatusImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
