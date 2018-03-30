package com.tistory.deque.translationtranslater;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ocrTaskActivity extends AppCompatActivity {

  private ImageView imageView;
  private TextView textView;

  private Uri resultImageURI;
  private static String tag = "ocrTaskActivityTAG";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ocr_task);
    Log.d(tag, "start Activity");

    imageView = findViewById(R.id.imageView);
    textView = findViewById(R.id.textView);

    ocr();
  }
  private void ocr(){
    Log.d(tag, "getBase64Encoded func");
    Intent intent = getIntent();
    resultImageURI = (Uri) intent.getExtras().get("IMAGE_URI");
    Log.d(tag, "image uri : " + resultImageURI);
    imageView.setImageURI(resultImageURI);

    ocrTask _ocrTask = new ocrTask(getApplicationContext());
    Log.d(tag, "ocrTask success make");

    _ocrTask.setImageURI(resultImageURI);
    _ocrTask.setTextView(textView);
    _ocrTask.setImageView(imageView);
    textView.setText(_ocrTask.RUN());
  }
}
