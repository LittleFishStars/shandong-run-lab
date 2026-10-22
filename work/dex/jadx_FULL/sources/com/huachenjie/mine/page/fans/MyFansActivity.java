package com.huachenjie.mine.page.fans;

import com.huachenjie.mine.R;
import com.huachenjie.mine.adapter.FansAndAttentionsAdapter;
import com.huachenjie.mine.page.FansAndAttentionsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/mine/page/fans/MyFansActivity;", "Lcom/huachenjie/mine/page/FansAndAttentionsActivity;", "Lcom/huachenjie/mine/page/fans/MyFansModel;", "", "h0", "Lcom/huachenjie/mine/adapter/FansAndAttentionsAdapter;", "f0", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyFansActivity extends FansAndAttentionsActivity<MyFansModel> {
    @Override // com.huachenjie.mine.page.FansAndAttentionsActivity
    @NotNull
    public FansAndAttentionsAdapter f0() {
        return new FansAndAttentionsAdapter(false, false, 3, null);
    }

    @Override // com.huachenjie.mine.page.FansAndAttentionsActivity
    @NotNull
    public String h0() {
        String string = getString(R.string.mine_fans_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.mine_fans_title)");
        return string;
    }
}
