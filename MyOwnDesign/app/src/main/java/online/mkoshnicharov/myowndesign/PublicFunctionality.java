package online.mkoshnicharov.myowndesign;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PublicFunctionality {

    public static void openLink(Context contextWindow){

        String link = "https://github.com/koshnicharov";

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(link));

        contextWindow.startActivity(intent);

    }

}
