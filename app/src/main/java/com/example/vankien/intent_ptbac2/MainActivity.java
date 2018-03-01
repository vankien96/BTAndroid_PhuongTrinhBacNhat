package com.example.vankien.intent_ptbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txta,txtb;
    Button btnResult;
    float numberA = 0;
    float numberB = 0;
    Boolean isFirstLoad = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Giải phương trình bậc nhất");
        addControls();
        addActions();
    }

    private void addActions() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aString = txta.getText().toString();
                String bString = txtb.getText().toString();
                try{
                    float a = Float.parseFloat(aString);
                    float b = Float.parseFloat(bString);
                    numberA = a;
                    numberB = b;
                    isFirstLoad = false;
                    String result = "";

                    if(a == 0){
                        if(b == 0){
                            result = "Phương trình có vô số nghiệm";
                        }else{
                            result = "Phương trình vô nghiệm";
                        }
                    }else{
                        result = ""+(-b/a);
                    }
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("result",result);
                    intent.putExtra("Result",bundle);
                    startActivity(intent);
                }catch(Exception ex){
                    Toast.makeText(MainActivity.this,"Wrong number format",Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

            }
        });
    }

    private void addControls() {
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        btnResult = findViewById(R.id.btnResult);
    }

    @Override
    protected void onResume() {
        super.onResume();
        txta.setText("");
        txtb.setText("");
        if(!isFirstLoad){
            Toast.makeText(MainActivity.this,"Wellcome back to MainActivity ! Your last edit text : a="+numberA+", b="+numberB,Toast.LENGTH_LONG).show();
        }
    }
}
