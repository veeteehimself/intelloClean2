package varun.exynosynergy.uploadexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class Homepage extends AppCompatActivity {

    private Button homeUpload;
    private Button homeCamera;
    private Button homeMap;
    private Button homeLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setTitle("Homepage");

        homeCamera=(Button)findViewById(R.id.homeCamera);
        homeUpload=(Button)findViewById(R.id.homeUpload);
        homeMap = (Button)findViewById(R.id.homeMap);
        homeLogout=(Button)findViewById(R.id.homeLogout);
        homeCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        homeUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        homeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, MapActivity.class);
                startActivity(intent);
            }
        });
        homeLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
