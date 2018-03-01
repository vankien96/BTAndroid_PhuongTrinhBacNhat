package com.example.vankien.intent_ptbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button btnBack;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.setTitle("Kết quả giải phương trình bậc nhất");

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControls() {
        txtResult = findViewById(R.id.txtResult);
        btnBack = findViewById(R.id.btnBack);

        Intent callerIntent = getIntent();
        Bundle bundle = callerIntent.getBundleExtra("Result");

        txtResult.setText(bundle.getString("result"));
    }
}
