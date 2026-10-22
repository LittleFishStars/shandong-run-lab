package com.huachenjie.sport.page.mine.helpercenter.problem_tree;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.zj.adlib.b38;
import com.zj.adlib.c38;
import com.zj.adlib.mh3;
import com.zj.adlib.ph3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/problem_tree/CustomerServiceAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class CustomerServiceAdapter extends BaseNodeAdapter {
    public static final int K = 110;

    public CustomerServiceAdapter() {
        super(null, 1, null);
        addNodeProvider(new ph3());
        addNodeProvider(new c38());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseNode baseNode = data.get(position);
        if (baseNode instanceof mh3) {
            return 1;
        }
        return baseNode instanceof b38 ? 2 : -1;
    }
}
