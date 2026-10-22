package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CursorUtil {
    private CursorUtil() {
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor c) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(c.getColumnNames(), c.getCount());
            while (c.moveToNext()) {
                Object[] objArr = new Object[c.getColumnCount()];
                for (int i = 0; i < c.getColumnCount(); i++) {
                    int type = c.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(c.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(c.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = c.getString(i);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i] = c.getBlob(i);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            c.close();
            return matrixCursor;
        } catch (Throwable th) {
            c.close();
            throw th;
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String name) {
        return -1;
    }

    @VisibleForTesting(otherwise = 2)
    public static int findColumnIndexBySuffix(String[] columnNames, String name) {
        String str = Consts.DOT + name;
        String str2 = Consts.DOT + name + "`";
        for (int i = 0; i < columnNames.length; i++) {
            String str3 = columnNames[i];
            if (str3.length() >= name.length() + 2) {
                if (str3.endsWith(str)) {
                    return i;
                }
                if (str3.charAt(0) == '`' && str3.endsWith(str2)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor c, @NonNull String name) {
        int columnIndex = c.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c.getColumnIndex("`" + name + "`");
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c, name);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor c, @NonNull String name) {
        String string;
        int columnIndex = getColumnIndex(c, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            string = Arrays.toString(c.getColumnNames());
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            string = "";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + string);
    }
}
