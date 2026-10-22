package com.huachenjie.run.utils;

import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.AlipayBindTipDialog;
import com.huachenjie.run.dialog.NfcCheckInTipDialog;
import com.zj.adlib.fv5;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "e", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", BridgeDSL.INVOKE, "(Lcom/huachenjie/common/reconfig/net/exception/ResultException;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class StartRunUtils$checkStartSunRun$1 extends Lambda implements Function1<ResultException, Boolean> {
    final /* synthetic */ StartRunUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartRunUtils$checkStartSunRun$1(StartRunUtils startRunUtils) {
        super(1);
        this.this$0 = startRunUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(StartRunUtils startRunUtils) {
        Intrinsics.checkNotNullParameter(startRunUtils, "this$0");
        startRunUtils.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String.finish();
    }

    @NotNull
    public final Boolean invoke(@NotNull ResultException resultException) {
        Intrinsics.checkNotNullParameter(resultException, "e");
        int code = resultException.getCode();
        String message = resultException.getMessage();
        if (code != 2034) {
            if (code == 11111) {
                AppCompatActivity appCompatActivity = this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String;
                String strE = ys8.e(R.string.i_know);
                final StartRunUtils startRunUtils = this.this$0;
                DialogUtil.I(appCompatActivity, "该活动已结束", "校园跑步活动已结束，不允许继续跑步！", strE, false, new DialogUtil.SingleClickListener() { // from class: com.huachenjie.run.utils.a
                    @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                    public final void onClicked() {
                        StartRunUtils$checkStartSunRun$1.invoke$lambda$0(startRunUtils);
                    }
                });
            } else if (code == 6505) {
                AlipayBindTipDialog.Companion companion = AlipayBindTipDialog.INSTANCE;
                FragmentManager supportFragmentManager = this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                companion.a(supportFragmentManager);
            } else if (code == 6506) {
                NfcCheckInTipDialog.Companion companion2 = NfcCheckInTipDialog.INSTANCE;
                FragmentManager supportFragmentManager2 = this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.supportFragmentManager");
                companion2.a(supportFragmentManager2);
            } else if (!TextUtils.isEmpty(message)) {
                fv5.b(message);
            }
        } else if (!TextUtils.isEmpty(message)) {
            DialogUtil.I(this.this$0.com.byazt.hv.TTDownloadField.TT_ACTIVITY java.lang.String, "", message, ys8.e(R.string.i_know), false, null);
        }
        this.this$0.setStartRunBusy(false);
        return Boolean.TRUE;
    }
}
