package com.alibaba.ariver.app.extensions;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.ipc.IpcMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface CustomServerMsgExtension extends Extension {
    void onGetMessage(AppNode appNode, IpcMessage ipcMessage);
}
