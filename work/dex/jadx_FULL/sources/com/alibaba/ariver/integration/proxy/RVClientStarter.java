package com.alibaba.ariver.integration.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVClientStarter extends Proxiable {
    Fragment createFragment(Context context, RVAppRecord rVAppRecord, Bundle bundle);

    @Nullable
    PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback);

    Class<? extends Activity> startClient(Context context, RVAppRecord rVAppRecord, Intent intent);
}
