package vn.edu.usth.weather;


import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.widget.LinearLayout;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather", "It's Cold");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("onCreate","Weather activity is being created");

        BlankFragment firstFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, firstFragment).commit();

    }


    }
