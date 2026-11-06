package com.qiyam.ustad.dev;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.mainContentLayout);

        // Urutan gambar sesuai permintaan:
        // 1. diba, 2. qiyam 1, 3. qiyam 2, 4. qiyam 3, 5. qiyam 4, 6. doa
        String[] imageFiles = {
            "diba.png",
            "qiyam 1.png",
            "qiyam 2.png",
            "qiyam 3.png",
            "qiyam 4.png",
            "doa.png"
        };

        for (String fileName : imageFiles) {
            addImageFromAssets(container, fileName);
        }
    }

    private void addImageFromAssets(LinearLayout container, String assetFileName) {
        try {
            InputStream is = getAssets().open(assetFileName);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();

            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            // Tanpa margin/padding agar gambar tersusun rapat tanpa pemisah
            params.setMargins(0, 0, 0, 0);
            imageView.setLayoutParams(params);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(bitmap);

            container.addView(imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}