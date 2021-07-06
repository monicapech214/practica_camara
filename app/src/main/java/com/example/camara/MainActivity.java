package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button tomarfoto;
    ImageView verfoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tomarfoto=(Button)findViewById(R.id.buttontomarfoto);
        verfoto=(ImageView) findViewById(R.id.imageViewVerfoto);

        tomarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TomarFoto();
            }
        });
    }
    private  void  TomarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    protected  void  onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        if(requestcode==0){
            if(resultcode==RESULT_OK){
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                verfoto.setImageBitmap(bitmap);
            }
        }
    }
}