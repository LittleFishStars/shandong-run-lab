package com.alibaba.ariver.engine.api.extensions;

import android.content.Context;
import androidx.annotation.Nullable;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface CreateWorkerPoint extends Extension {
    @Nullable
    Worker createWorker(Context context, Node node, String str, String str2);
}
