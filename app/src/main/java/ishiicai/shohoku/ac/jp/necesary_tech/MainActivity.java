package ishiicai.shohoku.ac.jp.necesary_tech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_tech);

        //ボタンを押したときに各テストへ遷移する

        Button button1 = (Button) findViewById(R.id.button_trance_act);     //画面遷移ボタン
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //インテントに、この画面と、遷移する別の画面を指定する
                Intent intent = new Intent(getApplication(), TranceActivity.class);
                //インテントで指定した別の画面に遷移する
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_blackout);       //画面暗転ボタン
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //インテントに、この画面と、遷移する別の画面を指定する
                Intent intent = new Intent(getApplication(), BlackoutActivity.class);
                //インテントで指定した別の画面に遷移する
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_save_points);    //文字数計算テストボタン
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //インテントに、この画面と、遷移する別の画面を指定する
                Intent intent = new Intent(getApplication(), SaveTextNumberActivity.class);
                //インテントで指定した別の画面に遷移する
                startActivity(intent);
            }
        });
    }
}
