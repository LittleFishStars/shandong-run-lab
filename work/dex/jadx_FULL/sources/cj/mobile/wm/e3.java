package cj.mobile.wm;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e3 extends c3<InputStream> {
    public static final UriMatcher dexd;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        dexd = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
    }

    public e3(Context context, Uri uri) {
        super(context, uri);
    }

    @TargetApi(14)
    private InputStream dexa(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream dexa(Uri uri, ContentResolver contentResolver, int i) throws FileNotFoundException {
        if (i != 1 && i != 3) {
            return contentResolver.openInputStream(uri);
        }
        if (i == 1 && (uri = ContactsContract.Contacts.lookupContact(contentResolver, uri)) == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return dexa(contentResolver, uri);
    }

    @Override // cj.mobile.wm.c3
    public void dexa(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // cj.mobile.wm.c3
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public InputStream dexa(Uri uri, ContentResolver contentResolver) {
        return dexa(uri, contentResolver, dexd.match(uri));
    }
}
