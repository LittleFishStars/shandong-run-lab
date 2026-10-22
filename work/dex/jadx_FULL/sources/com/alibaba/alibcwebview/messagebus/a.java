package com.alibaba.alibcwebview.messagebus;

import android.os.Message;
import android.util.SparseArray;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<List<AlibcMessageListener>> f23733a;
    private com.alibaba.alibcwebview.messagebus.b b;

    /* JADX INFO: renamed from: com.alibaba.alibcwebview.messagebus.a$a, reason: collision with other inner class name */
    public static class C0131a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f23734a = new a(0);
    }

    public class b extends com.alibaba.alibcwebview.messagebus.b.C0132b {
        public b() {
        }

        @Override // com.alibaba.alibcwebview.messagebus.b.C0132b
        public final void a(Message message) {
            final int i = message.what;
            final Object obj = message.obj;
            synchronized (a.class) {
                List<AlibcMessageListener> list = (List) a.this.f23733a.get(i);
                if (list != null && list.size() > 0) {
                    for (final AlibcMessageListener alibcMessageListener : list) {
                        if (alibcMessageListener.b) {
                            ExecutorManager.getTaskExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.alibcwebview.messagebus.a.b.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    alibcMessageListener.a(obj);
                                }
                            });
                        } else {
                            alibcMessageListener.a(obj);
                        }
                    }
                }
            }
        }
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.f23733a = new SparseArray<>();
        this.b = new com.alibaba.alibcwebview.messagebus.b(new b());
    }

    public static a a() {
        return C0131a.f23734a;
    }

    public final void a(Object obj) {
        Message message = new Message();
        message.what = 1201;
        message.obj = obj;
        this.b.f23737a.sendMessage(message);
    }

    public final synchronized void a(AlibcMessageListener alibcMessageListener) {
        if (alibcMessageListener == null) {
            return;
        }
        if (this.f23733a.get(alibcMessageListener.c) == null) {
            this.f23733a.put(alibcMessageListener.c, new LinkedList());
        }
        List<AlibcMessageListener> list = this.f23733a.get(alibcMessageListener.c);
        if (list != null) {
            list.add(alibcMessageListener);
        }
    }
}
