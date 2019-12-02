package vn.edu.usth.weather;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);


        InputStream is = getResources().openRawResource(R.raw.kiss);

        writeExternal();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.kiss);

        mp.start();





}
    private void writeExternal() {
        String filename = "humble.mp3";
        String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data";

        try {
            InputStream is = getApplicationContext().getResources().openRawResource(R.raw.kiss);
            File myFile = new File(filepath + filename);
            myFile.createNewFile();
            OutputStream fout = new FileOutputStream(myFile);
            fout.write(is.read());
            fout.close();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }








    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        @Override
        public Fragment getItem(int page) {

            switch (page) {
                case 0:
                    return new ForeCastAndWeatherFragment();
                case 1:
                    return new ForeCastAndWeatherFragment();
                case 2:
                    return new ForeCastAndWeatherFragment();
                default:
                    return new Fragment();
            }
        }
        @Override
        public CharSequence getPageTitle(int page) {
            return titles[page];
        }
    }


    }
