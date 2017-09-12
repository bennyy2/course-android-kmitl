package kmitl.lab04.benjarat58070079.simplemydot.Model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import java.io.ByteArrayOutputStream;


public class ScreenShot {

    public static Bitmap takeScreenShot(View view){
        View screen = view.getRootView();
        Bitmap screenShot;
        int width = view.getWidth();
        int height = view.getHeight();
        screenShot = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(screenShot);
        screen.draw(canvas);
        return screenShot;

    }


    public static Uri getUri(Context context, Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        String name = MediaStore.Images.Media.insertImage(context.getContentResolver(), bm, "ScreenShot", null);
        return Uri.parse(name);
    }
}
