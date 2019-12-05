package ishiicai.shohoku.ac.jp.necesary_tech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TranceActivityFourPer extends AppCompatActivity {

    public int points;
    public static final String SEND_POINT = "SendToOtherActivity.DATA";

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trance_tech_3);
        Intent intent = getIntent();
        int acceptpoints = intent.getIntExtra(TranceActivityTwoPer.SEND_POINT, 0);
        points = acceptpoints;
        //ボタンを押した際にカウントを増やし、一定値以上で切り替える
        final TextView textview = (TextView) findViewById(R.id.scoreText);
        Button button1 = (Button) findViewById(R.id.buttonThird);
        textview.setText(String.valueOf(points));

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //カウントを１増やす、その際一定値以上ならば画面を遷移する
                points++;
                textview.setText(String.valueOf(points));
                if(points >= 12){
                    Intent intent = new Intent(getApplication(), TranceActivitySixPer.class);
                    intent.putExtra(SEND_POINT, points);      //現在のカウントを次の画面へ受け渡す
                    startActivity(intent);
                }
            }
        });
    }
}