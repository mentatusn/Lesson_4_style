package calculator.calulation.lesson_4_style;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int MyTheme1 = 1;
    static final int MyTheme2 = 2;
    static final int MyTheme3 = 3;
    static final int MyTheme4 = 4;

    static final String KEY_SP = "sp";
    static final String KEY_CURRENT_THEME = "current_theme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getRealStyle(getCurrentTheme()));
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        RadioButton radioButton1 = findViewById(R.id.MyTheme1);
        RadioButton radioButton2 = findViewById(R.id.MyTheme2);
        RadioButton radioButton3 = findViewById(R.id.MyTheme3);
        RadioButton radioButton4 = findViewById(R.id.MyTheme4);
        radioButton1.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);
        switch (getCurrentTheme()) {
            case 1:
                radioButton1.setChecked(true);
                break;
            case 2:
                radioButton2.setChecked(true);
                break;
            case 3:
                radioButton3.setChecked(true);
                break;
            case 4:
                radioButton4.setChecked(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.MyTheme1:
                setCurrentTheme(MyTheme1);
                break;
            case R.id.MyTheme2:
                setCurrentTheme(MyTheme2);
                break;
            case R.id.MyTheme3:
                setCurrentTheme(MyTheme3);
                break;
            case R.id.MyTheme4:
                setCurrentTheme(MyTheme4);
                break;
        }
        recreate();
    }

    private void setCurrentTheme(int currentTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_CURRENT_THEME, currentTheme);
        editor.apply();
    }

    private int getCurrentTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE);
        return (sharedPreferences.getInt(KEY_CURRENT_THEME, -1));
    }

    private int getRealStyle(int currentTheme) {
        switch (currentTheme) {
            case MyTheme1:
                return R.style.My1;
            case MyTheme2:
                return R.style.My2;
            case MyTheme3:
                return R.style.My3;
            case MyTheme4:
                return R.style.My4;
            default:
                return 0;
        }
    }
}