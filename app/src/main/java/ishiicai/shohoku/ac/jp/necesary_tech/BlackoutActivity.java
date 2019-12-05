package ishiicai.shohoku.ac.jp.necesary_tech;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class BlackoutActivity extends AppCompatActivity {
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blackout_tech);
    }

    public boolean viewWhite_flag = true;

    public boolean onTouchEvent(MotionEvent T_Event) {
        final View view = (View)findViewById(R.id.view);
        view.setBackgroundColor(Color.BLACK);
        view.setVisibility(View.GONE);
        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        if (T_Event.getAction() == MotionEvent.ACTION_UP) {
            if(viewWhite_flag == true) {
                view.setVisibility(View.VISIBLE);
                viewWhite_flag = !viewWhite_flag;
            }else{
                view.setVisibility(View.GONE);
                viewWhite_flag = !viewWhite_flag;
            }
        }

        return true;
    }
}
