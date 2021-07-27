package calculator.calulation.lesson_4_style;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
        setTheme(getRealId(getCurrentTheme()));
        setContentView(R.layout.activity_main);
        Log.d("mylogs", getRealId(getCurrentTheme()) + "");
        Log.d("mylogs", (getCurrentTheme()) + "");
        Log.d("mylogs", R.style.My1 + " fsdfg");
        init();
    }

    private void init() {
        (findViewById(R.id.MyTheme1)).setOnClickListener(this);
        (findViewById(R.id.MyTheme2)).setOnClickListener(this);
        (findViewById(R.id.MyTheme3)).setOnClickListener(this);
        (findViewById(R.id.MyTheme4)).setOnClickListener(this);
        switch (getCurrentTheme()) {
            case 1:
                ((RadioButton) findViewById(R.id.MyTheme1)).setChecked(true);
                break;
            case 2:
                ((RadioButton) findViewById(R.id.MyTheme2)).setChecked(true);
                break;
            case 3:
                ((RadioButton) findViewById(R.id.MyTheme3)).setChecked(true);
                break;
            case 4:
                ((RadioButton) findViewById(R.id.MyTheme4)).setChecked(true);
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

    private int getRealId(int currentTheme) {
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