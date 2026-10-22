package com.ali.auth.third.core.message;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.ResourceUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MessageUtils {
    private static final Message c;
    private static final Message d;
    private static Message e;
    private static Message f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Integer, Message> f23420a = new HashMap();
    private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final Object g = new Object();

    static {
        Message message = new Message();
        c = message;
        message.code = 1;
        message.message = "未在消息文件中找到 id 为 {0} 的消息";
        message.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        message.type = "E";
        Message message2 = new Message();
        d = message2;
        message2.code = 2;
        message2.message = "检索消息时发生如下错误 {0}";
        message2.action = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        message2.type = "E";
    }

    private static Message a(int i) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    Message messageB = b(1);
                    e = messageB;
                    if (messageB == null) {
                        e = c;
                    }
                }
            }
        }
        try {
            Message message = (Message) e.clone();
            message.message = MessageFormat.format(message.message, String.valueOf(i));
            return message;
        } catch (CloneNotSupportedException unused) {
            return e;
        }
    }

    private static Message a(String str) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    Message messageB = b(2);
                    f = messageB;
                    if (messageB == null) {
                        f = d;
                    }
                }
            }
        }
        try {
            Message message = (Message) f.clone();
            message.message = MessageFormat.format(message.message, str);
            return message;
        } catch (CloneNotSupportedException unused) {
            return f;
        }
    }

    private static Message b(int i) {
        String string;
        String string2;
        try {
            if (ResourceUtils.getIdentifier(KernelContext.getApplicationContext(), TypedValues.Custom.S_STRING, "auth_sdk_message_" + i + "_message") == 0) {
                return null;
            }
            Message message = new Message();
            message.code = i;
            message.message = ResourceUtils.getString(KernelContext.getApplicationContext(), "auth_sdk_message_" + i + "_message");
            if (ResourceUtils.getIdentifier(KernelContext.getApplicationContext(), TypedValues.Custom.S_STRING, "auth_sdk_message_" + i + "_action") != 0) {
                string = ResourceUtils.getString(KernelContext.getApplicationContext(), "auth_sdk_message_" + i + "_action");
            } else {
                string = "";
            }
            message.action = string;
            if (ResourceUtils.getIdentifier(KernelContext.getApplicationContext(), TypedValues.Custom.S_STRING, "auth_sdk_message_" + i + "_type") != 0) {
                string2 = ResourceUtils.getString(KernelContext.getApplicationContext(), "auth_sdk_message_" + i + "_type");
            } else {
                string2 = "I";
            }
            message.type = string2;
            return message;
        } catch (Exception e2) {
            SDKLogger.e("kernel", "Fail to get message of the code " + i + ", the error message is " + e2.getMessage());
            return null;
        }
    }

    public static Message createMessage(int i, Object... objArr) {
        try {
            b.readLock().lock();
            Message messageB = f23420a.get(Integer.valueOf(i));
            if (messageB == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                try {
                    messageB = b(i);
                    if (messageB != null) {
                        f23420a.put(Integer.valueOf(i), messageB);
                    }
                    b.readLock().lock();
                    b.writeLock().unlock();
                } catch (Throwable th) {
                    b.writeLock().unlock();
                    throw th;
                }
            }
            try {
                if (messageB == null) {
                    Message messageA = a(i);
                    b.readLock().unlock();
                    return messageA;
                }
                if (objArr.length == 0) {
                    b.readLock().unlock();
                    return messageB;
                }
                Message message = (Message) messageB.clone();
                message.message = MessageFormat.format(messageB.message, objArr);
                b.readLock().unlock();
                return message;
            } catch (Throwable th2) {
                b.readLock().unlock();
                throw th2;
            }
        } catch (Exception e2) {
            return a(e2.getMessage());
        }
    }

    public static String getMessageContent(int i, Object... objArr) {
        try {
            b.readLock().lock();
            Message messageB = f23420a.get(Integer.valueOf(i));
            if (messageB == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                try {
                    messageB = b(i);
                    if (messageB != null) {
                        f23420a.put(Integer.valueOf(i), messageB);
                    }
                    b.readLock().lock();
                    b.writeLock().unlock();
                } catch (Throwable th) {
                    b.writeLock().unlock();
                    throw th;
                }
            }
            try {
                if (messageB == null) {
                    String str = a(i).message;
                    b.readLock().unlock();
                    return str;
                }
                String str2 = MessageFormat.format(messageB.message, objArr);
                b.readLock().unlock();
                return str2;
            } catch (Throwable th2) {
                b.readLock().unlock();
                throw th2;
            }
        } catch (Exception e2) {
            return a(e2.getMessage()).message;
        }
    }
}
