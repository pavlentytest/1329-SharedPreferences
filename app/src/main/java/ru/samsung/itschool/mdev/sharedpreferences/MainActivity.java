package ru.samsung.itschool.mdev.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    private SharedPreferences preferences;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        edittext = findViewById(R.id.name);

        preferences = getPreferences(0);
        String saved_name = preferences.getString("name","Default");
        edittext.setText(saved_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                String get_value = edittext.getText().toString();
                editor.putString("name",get_value);
                editor.apply();
                Snackbar.make(findViewById(R.id.root),get_value,Snackbar.LENGTH_LONG).show();
            }
        });
    }
}