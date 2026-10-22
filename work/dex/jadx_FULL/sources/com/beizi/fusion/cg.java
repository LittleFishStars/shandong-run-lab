package com.beizi.fusion;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.task.TaskUrlModel;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cg extends hb {
    public cg(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.hb
    public void a(ConfigResponseModel configResponseModel, g.a aVar) {
        List<TaskUrlModel> taskModels;
        if (configResponseModel == null || configResponseModel.getStatistics() == null || (taskModels = configResponseModel.getStatistics().getTaskModels()) == null || taskModels.isEmpty()) {
            return;
        }
        om.a("InvokeRequestByUpdate", "配置更新, 检查是否存在上报...");
        fb fbVar = (fb) cn.a().b(this.f27361a);
        if (fbVar != null) {
            fbVar.a(new a(this.f27361a, taskModels));
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27140a;
        private final List b;

        private a(Context context, List list) {
            this.f27140a = context.getApplicationContext();
            this.b = list;
        }

        private void a(TaskUrlModel taskUrlModel) {
            if (taskUrlModel != null) {
                long delay = taskUrlModel.getDelay();
                fb fbVar = (fb) cn.a().b(this.f27140a);
                if (fbVar != null) {
                    fbVar.a(new RunnableC0303a(taskUrlModel), delay, TimeUnit.MILLISECONDS);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.b;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                a((TaskUrlModel) it.next());
            }
        }

        /* JADX INFO: renamed from: com.beizi.fusion.cg$a$a, reason: collision with other inner class name */
        public class RunnableC0303a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TaskUrlModel f27141a;

            private RunnableC0303a(TaskUrlModel taskUrlModel) {
                this.f27141a = taskUrlModel;
            }

            private void a(TaskUrlModel taskUrlModel) {
                Runnable runnable;
                fb fbVar;
                String implement = taskUrlModel.getImplement();
                long jB = b(taskUrlModel);
                final String url = taskUrlModel.getUrl();
                if (TextUtils.isEmpty(url)) {
                    return;
                }
                if (cm.GET.b().equalsIgnoreCase(implement)) {
                    runnable = new Runnable() { // from class: com.beizi.fusion.if
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27407a.a(url);
                        }
                    };
                } else if (cm.POST.b().equalsIgnoreCase(implement)) {
                    runnable = new Runnable() { // from class: com.beizi.fusion.do
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27200a.b(url);
                        }
                    };
                } else if ("WEBVIEW".equalsIgnoreCase(implement)) {
                    runnable = new Runnable() { // from class: com.beizi.fusion.wq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27994a.c(url);
                        }
                    };
                } else {
                    runnable = "DEEPLINK".equalsIgnoreCase(implement) ? new Runnable() { // from class: com.beizi.fusion.xq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f28045a.d(url);
                        }
                    } : null;
                }
                if (runnable == null || jB < 0 || (fbVar = (fb) cn.a().b(a.this.f27140a)) == null) {
                    return;
                }
                fbVar.a(runnable, jB, TimeUnit.MILLISECONDS);
            }

            private long b(TaskUrlModel taskUrlModel) {
                return taskUrlModel.getDelay() + ((long) (new Random(System.currentTimeMillis()).nextInt((int) taskUrlModel.getRandomTime()) + 1));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c(String str) {
                wf.a(a.this.f27140a, str, (Bundle) null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void d(String str) {
                wf.a(a.this.f27140a, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b != null) {
                    a(this.f27141a);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(String str) {
                ((u9) o0.a().b(a.this.f27140a)).a(str, "", null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(String str) {
                ((u9) o0.a().b(a.this.f27140a)).a(str, null);
            }
        }
    }
}
