package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;;
public class MainActivity extends AppCompatActivity {
    private int count = 0;

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void show_toast(View view){
        Toast.makeText(this,"Hello Constraint",Toast.LENGTH_SHORT).show();
    }
    public void showZero(View view) {
        count = 0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        mainBinding.buttonZero.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        getResources().getColor(R.color.gray)
                )
        );
    }
    public void increase_count(View view){
     count++;
     mainBinding.textDisplayCount.setText(String.valueOf(count));
        if (count % 2 == 0) {
            mainBinding.buttonCount.setBackgroundTintList(
                    android.content.res.ColorStateList.valueOf(
                            getResources().getColor(R.color.blue)
                    )
            );
        } else {
            mainBinding.buttonCount.setBackgroundTintList(
                    android.content.res.ColorStateList.valueOf(
                            getResources().getColor(R.color.green)
                    )
            );
        }
        mainBinding.buttonZero.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(
                        getResources().getColor(R.color.orange)
                )
        );
    }


}