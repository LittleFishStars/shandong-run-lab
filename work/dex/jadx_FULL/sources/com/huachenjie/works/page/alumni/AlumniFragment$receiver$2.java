package com.huachenjie.works.page.alumni;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.broadcast.config.ConfigOperateListener;
import com.huachenjie.base.broadcast.config.ConfigOperateReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/base/broadcast/config/ConfigOperateReceiver;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class AlumniFragment$receiver$2 extends Lambda implements Function0<ConfigOperateReceiver> {
    final /* synthetic */ AlumniFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlumniFragment$receiver$2(AlumniFragment alumniFragment) {
        super(0);
        this.this$0 = alumniFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(AlumniFragment alumniFragment) {
        Intrinsics.checkNotNullParameter(alumniFragment, "this$0");
        alumniFragment.checkCommonConfig();
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ConfigOperateReceiver m833invoke() {
        final AlumniFragment alumniFragment = this.this$0;
        return new ConfigOperateReceiver(new ConfigOperateListener() { // from class: com.huachenjie.works.page.alumni.a
            @Override // com.huachenjie.base.broadcast.config.ConfigOperateListener
            public final void a() {
                AlumniFragment$receiver$2.invoke$lambda$0(alumniFragment);
            }
        });
    }
}
