package com.byazt.sq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 900, 15})
public class uj {

    public interface c {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    @com.byazt.zqa.c(c = {0, 1, 900, 153})
    public static class tt extends com.byazt.fb.uj implements c {
        public c c;

        public tt(c cVar) {
            this.c = cVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.byazt.fb.uj
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    return this.c != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999906:
                    return this.c != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999905:
                    if (this.c != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.c != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.c != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.c != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.byazt.sq.uj.c
        public int delete(Uri uri, String str, String[] strArr) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.byazt.sq.uj.c
        public String getTableName() {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.getTableName();
            }
            return null;
        }

        @Override // com.byazt.sq.uj.c
        public String getType(Uri uri) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.getType(uri);
            }
            return null;
        }

        @Override // com.byazt.sq.uj.c
        public void init() {
            c cVar = this.c;
            if (cVar != null) {
                cVar.init();
            }
        }

        @Override // com.byazt.sq.uj.c
        public void injectContext(Context context) {
            c cVar = this.c;
            if (cVar != null) {
                cVar.injectContext(context);
            }
        }

        @Override // com.byazt.sq.uj.c
        public Uri insert(Uri uri, ContentValues contentValues) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.byazt.sq.uj.c
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.byazt.sq.uj.c
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 900, 1694})
    public static class ve implements ITTProvider, c {
        public c c;

        public ve(c cVar) {
            this.c = cVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public int delete(Uri uri, String str, String[] strArr) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public String getTableName() {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public String getType(Uri uri) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public void init() {
            c cVar = this.c;
            if (cVar != null) {
                cVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public void injectContext(Context context) {
            c cVar = this.c;
            if (cVar != null) {
                cVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public Uri insert(Uri uri, ContentValues contentValues) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            c cVar = this.c;
            if (cVar != null) {
                return cVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    public static Object c(c cVar, Class cls, Bundle bundle) {
        if (c(bundle)) {
            return new tt(cVar);
        }
        if (c(cls)) {
            return new ve(cVar);
        }
        return null;
    }

    public static boolean c(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return c(cls) || c(bundle);
    }

    private static boolean c(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean c(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }
}
