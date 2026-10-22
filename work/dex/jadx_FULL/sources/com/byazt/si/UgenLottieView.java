package com.byazt.si;

import android.content.Context;
import com.byazt.ga.LottieAnimationView;
import com.byazt.sa.uj;
import com.huachenjie.common.constants.ErrorCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 608, ErrorCode.CHECK_START_RUN_ERROR.h})
public class UgenLottieView extends LottieAnimationView {
    public uj c;

    public UgenLottieView(Context context) {
        super(context);
    }

    public void c(uj ujVar) {
        this.c = ujVar;
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }
}
