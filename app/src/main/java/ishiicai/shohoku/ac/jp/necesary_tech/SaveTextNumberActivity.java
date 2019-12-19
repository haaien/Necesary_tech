package ishiicai.shohoku.ac.jp.necesary_tech;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaveTextNumberActivity extends AppCompatActivity {

    public String writtenData;          //書き込まれた文章
    public int textNum;                 //書き込まれた文章の文字数
    public int sumTextNum;              //総文字数
    private TestOpenHelper helper;
    private SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_text_number);

        //各オブジェクトの操作用変数を作成
        final TextView textView1 = (TextView)findViewById(R.id.StrNumText);
        final EditText editText = (EditText)findViewById(R.id.InputTextEditor);
        Button button1 = (Button)findViewById(R.id.button);

        //これまでの総文字数をDBから呼び出す
        readData();
        Log.d("Debug","readDataまで動いたよ");
        textView1.setText(String.valueOf(sumTextNum));

        //COUNTボタンが押されたときの処理 -> 書き込まれた文字数のカウント
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //データベースを認識させる（初回のみ）
                if(helper == null){
                    helper = new TestOpenHelper(getApplicationContext());
                }
                if(db == null){
                    db = helper.getWritableDatabase();
                }

                //文字列の格納と文字数の割り出し
                writtenData = editText.getText().toString();
                textNum = writtenData.length();
                sumTextNum += textNum;

                //文字数の表示
                textView1.setText(String.valueOf(sumTextNum));

                //総文字数の更新
                saveData(db, sumTextNum);
            }
        });

    }

    /**
     * 総文字数をDBに保存する（関数を呼び出すための）関数
     * @param db    保存するデータベースの情報
     * @param score 保存する値
     */
    public void saveData(SQLiteDatabase db, int score){
        ContentValues values = new ContentValues();
        values.put("StrNumber", score);

        db.insert("strNumdb", null, values);
    }

    public void readData(){
        //データベースを認識させる（初回のみ）
        if(helper == null){
            helper = new TestOpenHelper(getApplicationContext());
        }
        if(db == null){
            db = helper.getReadableDatabase();
        }

        Log.d("Debug","nullチェックまで動いたよ");

        //データベースに格納された数値すべてを呼び出す
        Cursor cursor = db.query(
                "strNumdb",
                new String[] {"StrNumber"},
                null,
                null,
                null,
                null,
                null
        );

        Log.d("Debug","queryまで動いたよ");

        //integer型の値として、直近に更新された数値を（上書きする形で）呼び出す
        if(cursor.moveToFirst()){
            do{
                sumTextNum = cursor.getInt(cursor.getColumnIndex("StrNumber"));
            }while (cursor.moveToNext());
        }
    }
}
