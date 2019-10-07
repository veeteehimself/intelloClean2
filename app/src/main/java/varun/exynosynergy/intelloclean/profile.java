package varun.exynosynergy.intelloclean;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import varun.exynosynergy.intelloclean.Map;
import varun.exynosynergy.intelloclean.R;

public class profile extends AppCompatActivity {

    ImageView imageView;
    private Button btnMap;
    //TextView name123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //name123=(TextView)findViewById(R.id.name123);
        //Bundle b=getIntent().getExtras();
        //String name=b.getString("name");
        //name123.setText("Hello "+name+" !");
        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        btnMap = (Button)findViewById(R.id.btnMap);
        imageView = (ImageView)findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(profile.this, Map.class);
                startActivityForResult(intent2,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);

    }
}
