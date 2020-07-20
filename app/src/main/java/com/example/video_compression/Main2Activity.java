package com.example.video_compression;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class  Main2Activity extends AppCompatActivity {
    VideoView videoView;



    private static final String VIDEO_DIRECTORY = "/Compressed Videos";
    private int GALLERY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView = (VideoView)findViewById(R.id.videoView);
        openGallery();
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("result",""+resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            Log.d("what","cancel");
            return;
        }
        if (requestCode == GALLERY) {
            Log.d("what","gale");
            if (data != null) {
                Uri contentURI = data.getData();
                videoView.setVideoURI(contentURI);
                videoView.requestFocus();
                videoView.start();

            }

        }
    }
}

