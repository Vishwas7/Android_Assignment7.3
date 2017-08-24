package com.vishwas.opengallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //declaring variable

    protected ImageView imagViw;
    private Button pressBtn;

    // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pressBtn  = (Button) findViewById(R.id.btn);
        imagViw = (ImageView) findViewById(R.id.selectedImageView);
        /**
         *
         * In here creating setOnClickListener event and in side the onClick event using Intent.
         * Intent is a kind of message or information that is passed to the components.
         * It is used to launch an activity, display a web page, send sms, send email etc.
         *
         * @param v
         *
         */

        pressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 10);
            }
        });
    }

    /**
     * Creating onActivityResult method includes three arguments:
     *
     * @param requestCode - passed to onActivityResult
     * @param resultCode  - specified by the second activity.
     *                    This is either RESULT_OK if the operation was successful or RESULT_CANCELED
     * @param data        -An Intent that carries the result data.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                imagViw.setImageURI(selectedImageUri);

            }
        }
    }
}

