package com.byazt.rg;

import android.content.Context;
import android.widget.ImageView;
import com.byazt.fe.UGRatingBar;
import com.byazt.nr.z;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 803, SecExceptionCode.SEC_ERROR_LBSRISK_INIT_JNI_FAILED})
public class UGNewRatingBar extends UGRatingBar {
    public UGNewRatingBar(Context context) {
        super(context);
    }

    @Override // com.byazt.fe.UGRatingBar
    public void c(ImageView imageView, String str) {
        z.c(getContext(), str, imageView, 320);
    }
}
