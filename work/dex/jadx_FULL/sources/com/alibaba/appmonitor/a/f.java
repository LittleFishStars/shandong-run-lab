package com.alibaba.appmonitor.a;

import com.alibaba.analytics.a.j;
import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {
    private static void a(Transaction transaction) {
        if (transaction == null || transaction.dimensionValues == null) {
            return;
        }
        com.alibaba.appmonitor.event.e.a().a(transaction.transactionId, transaction.eventId, transaction.module, transaction.monitorPoint, DimensionValueSet.create().addValues(transaction.dimensionValues));
    }

    public static void c(Transaction transaction, String str) {
        try {
            if (a.X && transaction != null) {
                j.d("TransactionDelegate", "statEvent begin. module: ", transaction.module, " monitorPoint: ", transaction.monitorPoint, " measureName: ", str);
                EventType eventType = EventType.STAT;
                if (eventType.isOpen()) {
                    if (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, transaction.module, transaction.monitorPoint)) {
                        com.alibaba.appmonitor.event.e.a().a(transaction.transactionId, transaction.eventId, transaction.module, transaction.monitorPoint, str);
                        a(transaction);
                    }
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void d(Transaction transaction, String str) {
        try {
            if (a.X && transaction != null) {
                j.d("TransactionDelegate", "statEvent end. module: ", transaction.module, " monitorPoint: ", transaction.monitorPoint, " measureName: ", str);
                EventType eventType = EventType.STAT;
                if (eventType.isOpen()) {
                    if (a.W || com.alibaba.appmonitor.c.b.a().b(eventType, transaction.module, transaction.monitorPoint)) {
                        a(transaction);
                        com.alibaba.appmonitor.event.e.a().a(transaction.transactionId, str, false);
                    }
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.m133a(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }
}
