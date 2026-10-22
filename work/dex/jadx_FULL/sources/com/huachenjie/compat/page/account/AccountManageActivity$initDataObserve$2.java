package com.huachenjie.compat.page.account;

import android.content.Intent;
import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.personal.PhoneModifyActivity;
import com.zj.adlib.ft1;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "code", "", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE, "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class AccountManageActivity$initDataObserve$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ AccountManageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountManageActivity$initDataObserve$2(AccountManageActivity accountManageActivity) {
        super(1);
        this.this$0 = accountManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(AccountManageActivity accountManageActivity, View view) {
        Intrinsics.checkNotNullParameter(accountManageActivity, "this$0");
        accountManageActivity.startActivity(new Intent(accountManageActivity, (Class<?>) PhoneModifyActivity.class));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        if (num != null && num.intValue() == 1552) {
            ft1.z(this.this$0, ys8.e(R.string.already_modify_phone_today_warn), ys8.e(R.string.i_know));
            return;
        }
        if (num == null || num.intValue() != 1553) {
            if (num != null && num.intValue() == 1554) {
                ft1.z(this.this$0, ys8.e(R.string.reach_max_tims_warn), ys8.e(R.string.i_know));
                return;
            }
            return;
        }
        AccountManageActivity accountManageActivity = this.this$0;
        String strE = ys8.e(R.string.last_ont_times_warn);
        String strE2 = ys8.e(R.string.cancel);
        String strE3 = ys8.e(R.string.resume);
        final AccountManageActivity accountManageActivity2 = this.this$0;
        ft1.o(accountManageActivity, strE, strE2, strE3, new View.OnClickListener() { // from class: com.huachenjie.compat.page.account.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageActivity$initDataObserve$2.invoke$lambda$0(accountManageActivity2, view);
            }
        });
    }
}
