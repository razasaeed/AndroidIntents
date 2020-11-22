package razi.constructor.android_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNext, btnEmail;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        btnNext = findViewById(R.id.btnNext);
        btnEmail = findViewById(R.id.btnEmail);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(Intent.ACTION_SEND);
                obj.putExtra(Intent.ACTION_SENDTO, "razasaeed@gmail.com");
                obj.putExtra(Intent.EXTRA_SUBJECT, "Application");
                obj.putExtra(Intent.EXTRA_TEXT, "Hello World");
                obj.putExtra(Intent.EXTRA_CC, "ali@gmail.com");
                startActivity(Intent.createChooser(obj, "Select App:"));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj  = new Intent(MainActivity.this, MainTwoActivity.class);
                obj.putExtra("xyz", nameEdit.getText().toString());
                startActivity(obj);
            }
        });

    }
}