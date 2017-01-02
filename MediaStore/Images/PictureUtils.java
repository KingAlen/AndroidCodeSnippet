import android.content.Intent;
import android.provider.MediaStore;

public class PictureUtils {

    /**
     * select a picture from photo album
     */
    public static void selectPicture() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);
    }
}