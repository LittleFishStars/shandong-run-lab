package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcServerUtils {
    public static final String LOG_TAG = "AriverInt:IpcServer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LongSparseArray<List<Message>> f23833a = new LongSparseArray<>();

    private static void a(long j, Message message) {
        LongSparseArray<List<Message>> longSparseArray = f23833a;
        synchronized (longSparseArray) {
            List<Message> arrayList = longSparseArray.get(j);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                longSparseArray.put(j, arrayList);
            }
            arrayList.add(message);
        }
    }

    public static void addAttrToClient(String str, long j, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_STUB_NAME, str2);
        bundle.putString(IpcMessageConstants.EXTRA_ATTR_VALUE, str3);
        sendMsgToClient(str, j, 16, bundle);
    }

    public static void addStubToClient(String str, long j, String str2, long j2) {
        Bundle bundle = new Bundle();
        bundle.putString(IpcMessageConstants.EXTRA_STUB_NAME, str2);
        bundle.putLong(IpcMessageConstants.EXTRA_STUB_TS, j2);
        sendMsgToClient(str, j, 12, bundle);
    }

    public static void flushMessages(long j) {
        IIpcChannel clientChannel = IpcChannelManager.getInstance().getClientChannel(j);
        LongSparseArray<List<Message>> longSparseArray = f23833a;
        synchronized (longSparseArray) {
            List<Message> list = longSparseArray.get(j);
            RVLogger.d(LOG_TAG, "flushMessages: " + j + " msgSize: " + (list == null ? 0 : list.size()));
            if (list != null) {
                for (Message message : list) {
                    Object obj = message.obj;
                    String str = obj instanceof String ? (String) obj : IpcMessageConstants.BIZ_APP;
                    message.obj = null;
                    a(clientChannel, str, message);
                }
            }
            f23833a.remove(j);
        }
    }

    public static void removeToken(long j) {
        f23833a.remove(j);
    }

    public static void sendMsgToClient(String str, long j, int i, @Nullable Bundle bundle) {
        sendMsgToClient(str, j, i, IpcMessageConstants.BIZ_APP, bundle);
    }

    public static void sendMsgToClient(String str, long j, int i, String str2, @Nullable Bundle bundle) {
        if (i == 4) {
            RVLogger.w(LOG_TAG, "send SERVER_MSG_FORCE_FINISH with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        }
        Message message = new Message();
        message.what = i;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.setClassLoader(IpcServerUtils.class.getClassLoader());
        bundle.putString("appId", str);
        bundle.putLong(RVConstants.EXTRA_START_TOKEN, j);
        message.setData(bundle);
        IIpcChannel clientChannel = IpcChannelManager.getInstance().getClientChannel(j);
        if (clientChannel != null) {
            RVLogger.d(LOG_TAG, "sendMsgToClient (direct) " + i + " token: " + j);
            a(clientChannel, str2, message);
            return;
        }
        RVLogger.d(LOG_TAG, "sendMsgToClient (pending) " + i + " token: " + j);
        message.obj = str2;
        a(j, message);
    }

    private static void a(IIpcChannel iIpcChannel, String str, Message message) {
        if (iIpcChannel == null) {
            return;
        }
        IpcMessage ipcMessage = new IpcMessage();
        ipcMessage.biz = str;
        ipcMessage.bizMsg = message;
        try {
            iIpcChannel.sendMessage(ipcMessage);
        } catch (RemoteException e) {
            RVLogger.e(LOG_TAG, "IpcMsgServer send error " + Log.getStackTraceString(e));
        }
    }
}
