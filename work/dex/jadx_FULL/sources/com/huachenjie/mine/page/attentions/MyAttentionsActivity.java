package com.huachenjie.mine.page.attentions;

import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.mine.R;
import com.huachenjie.mine.adapter.FansAndAttentionsAdapter;
import com.huachenjie.mine.page.FansAndAttentionsActivity;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/mine/page/attentions/MyAttentionsActivity;", "Lcom/huachenjie/mine/page/FansAndAttentionsActivity;", "Lcom/huachenjie/mine/page/attentions/MyAttentionsModel;", "", "h0", "Lcom/huachenjie/mine/adapter/FansAndAttentionsAdapter;", "f0", "appUserCode", "", "o0", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyAttentionsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAttentionsActivity.kt\ncom/huachenjie/mine/page/attentions/MyAttentionsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1864#2,3:38\n*S KotlinDebug\n*F\n+ 1 MyAttentionsActivity.kt\ncom/huachenjie/mine/page/attentions/MyAttentionsActivity\n*L\n23#1:38,3\n*E\n"})
public final class MyAttentionsActivity extends FansAndAttentionsActivity<MyAttentionsModel> {
    @Override // com.huachenjie.mine.page.FansAndAttentionsActivity
    @NotNull
    public FansAndAttentionsAdapter f0() {
        return new FansAndAttentionsAdapter(false, true);
    }

    @Override // com.huachenjie.mine.page.FansAndAttentionsActivity
    @NotNull
    public String h0() {
        String string = getString(R.string.mine_attentions_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.mine_attentions_title)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.mine.page.FansAndAttentionsActivity
    public void o0(@NotNull String appUserCode) {
        Intrinsics.checkNotNullParameter(appUserCode, "appUserCode");
        FansAndAttentionsAdapter value = ((MyAttentionsModel) getMViewModel()).B().getValue();
        if (value != null) {
            int i = 0;
            for (Object obj : value.getData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FansBean fansBean = (FansBean) obj;
                if (Intrinsics.areEqual(fansBean.getAppUserCode(), appUserCode)) {
                    fansBean.setEachFollow(false);
                    value.removeAt(i);
                    break;
                }
                i = i2;
            }
            if (value.getData().isEmpty()) {
                ((MyAttentionsModel) getMViewModel()).y();
            }
        }
    }
}
