package com.alibaba.ariver.app.api.point.dialog;

import android.app.Dialog;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface ActionSheetPoint extends Extension {
    Dialog getActionSheet(CreateActionSheetParam createActionSheetParam);

    void onRelease();

    void updateActionSheetContent(ArrayList<String> arrayList);
}
