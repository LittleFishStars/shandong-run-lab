package com.huachenjie.channel.page.my_channel.organize;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.zj.adlib.ie6;
import com.zj.adlib.ze6;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize/OrganizeAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeAdapter extends BaseNodeAdapter implements LoadMoreModule {
    public static final int K = 1;
    public static final int L = 2;

    public OrganizeAdapter() {
        super(null, 1, null);
        addNodeProvider(new ze6());
        addNodeProvider(new ie6());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseNode baseNode = data.get(position);
        if (baseNode instanceof OrganizeBean) {
            return 1;
        }
        if (baseNode instanceof OrganizeTeamBean) {
            return 2;
        }
        throw new IllegalArgumentException("Invalid type of data " + data);
    }
}
