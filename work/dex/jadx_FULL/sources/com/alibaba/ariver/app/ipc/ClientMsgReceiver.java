package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ClientMsgReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23832a = "AriverInt:IpcClient";
    private static ClientMsgReceiver b;
    private static final Map<String, IpcMessageHandler> c = new HashMap();
    private static final LongSparseArray<IpcMessageHandler> d = new LongSparseArray<>();
    private static final LongSparseArray<List<IpcMessage>> e = new LongSparseArray<>();

    private ClientMsgReceiver() {
    }

    private void a(long j, IpcMessage ipcMessage) {
        synchronized (ClientMsgReceiver.class) {
            LongSparseArray<List<IpcMessage>> longSparseArray = e;
            List<IpcMessage> arrayList = longSparseArray.get(j);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                longSparseArray.put(j, arrayList);
            }
            arrayList.add(ipcMessage);
        }
    }

    public static ClientMsgReceiver getInstance() {
        ClientMsgReceiver clientMsgReceiver;
        ClientMsgReceiver clientMsgReceiver2 = b;
        if (clientMsgReceiver2 != null) {
            return clientMsgReceiver2;
        }
        synchronized (ClientMsgReceiver.class) {
            if (b == null) {
                b = new ClientMsgReceiver();
            }
            clientMsgReceiver = b;
        }
        return clientMsgReceiver;
    }

    public void handleMessage(IpcMessage ipcMessage) {
        Message message = ipcMessage.bizMsg;
        if (message != null && message.getData() != null) {
            ipcMessage.bizMsg.getData().setClassLoader(ClientMsgReceiver.class.getClassLoader());
        }
        if (TextUtils.isEmpty(ipcMessage.biz)) {
            return;
        }
        Message message2 = ipcMessage.bizMsg;
        if (!IpcMessageConstants.BIZ_APP.equals(ipcMessage.biz)) {
            IpcMessageHandler ipcMessageHandler = c.get(ipcMessage.biz);
            if (ipcMessageHandler != null) {
                ipcMessageHandler.handleMessage(ipcMessage);
                return;
            }
            RVLogger.d("AriverInt:IpcClient", "ClientMsgReceiver biz " + ipcMessage.biz + " not registered");
            return;
        }
        long j = BundleUtils.getLong(message2.getData(), RVConstants.EXTRA_START_TOKEN, -1L);
        RVLogger.d("AriverInt:IpcClient", "ClientMsgReceiver handle app message what: " + message2.what + " token: " + j);
        if (j > 0) {
            synchronized (ClientMsgReceiver.class) {
                if (message2.what == 6) {
                    a(j, message2);
                    return;
                }
                IpcMessageHandler ipcMessageHandler2 = d.get(j);
                if (ipcMessageHandler2 != null) {
                    ipcMessageHandler2.handleMessage(ipcMessage);
                } else {
                    RVLogger.w("AriverInt:IpcClient", "ClientMsgReceiver handleMessage " + ipcMessage + " with " + j + " add pending!");
                    a(j, ipcMessage);
                }
            }
        }
    }

    public void manualPreCreateApp(long j, String str, Bundle bundle, Bundle bundle2) {
        AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
        synchronized (AppManager.class) {
            if (j > 0) {
                RVLogger.d("AriverInt:IpcClient", "manualPreCreateApp, startToken: " + j);
                if (appManager.findAppByToken(j) == null) {
                    appManager.preCreateApp(str, bundle, bundle2);
                }
            }
        }
    }

    public void manualStartApp(long j, String str, Bundle bundle, Bundle bundle2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_App_manualStartApp);
        AppManager appManager = (AppManager) RVProxy.get(AppManager.class);
        synchronized (AppManager.class) {
            if (j > 0) {
                RVLogger.d("AriverInt:IpcClient", "manualStartApp, startToken: " + j);
                App appFindAppByToken = appManager.findAppByToken(j);
                if (appFindAppByToken == null || !((AppNode) appFindAppByToken).isInited()) {
                    appFindAppByToken = appManager.startApp(str, bundle, bundle2);
                }
                if (appFindAppByToken != null) {
                    appFindAppByToken.start();
                }
            }
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_App_manualStartApp);
    }

    public void registerAppHandler(App app) {
        long startToken = app.getStartToken();
        IpcMessageHandler msgHandler = app.getMsgHandler();
        RVLogger.d("AriverInt:IpcClient", "registerAppHandler " + startToken);
        synchronized (ClientMsgReceiver.class) {
            d.put(startToken, msgHandler);
            List<IpcMessage> list = e.get(startToken);
            if (list != null) {
                Iterator<IpcMessage> it = list.iterator();
                while (it.hasNext()) {
                    msgHandler.handleMessage(it.next());
                }
            }
            e.remove(startToken);
        }
    }

    public void registerBizHandler(String str, IpcMessageHandler ipcMessageHandler) {
        synchronized (ClientMsgReceiver.class) {
            c.put(str, ipcMessageHandler);
        }
    }

    public void unRegisterAppHandler(long j) {
        synchronized (ClientMsgReceiver.class) {
            RVLogger.d("AriverInt:IpcClient", "unRegisterAppHandler " + j);
            e.remove(j);
            d.remove(j);
        }
    }

    public void unRegisterBizHandler(String str) {
        synchronized (ClientMsgReceiver.class) {
            c.remove(str);
        }
    }

    private void a(final long j, Message message) {
        RVLogger.d("AriverInt:IpcClient", "quickStartApp! " + j);
        final String string = BundleUtils.getString(message.getData(), "appId");
        final Bundle bundle = (Bundle) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_START_PARAMS);
        final Bundle bundle2 = (Bundle) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_SCENE_PARAMS);
        ExecutorUtils.runNotOnMain(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.app.ipc.ClientMsgReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                ClientMsgReceiver.this.manualStartApp(j, string, bundle, bundle2);
                RVLogger.d("AriverInt:IpcClient", "end quickStartApp!");
            }
        });
    }
}
