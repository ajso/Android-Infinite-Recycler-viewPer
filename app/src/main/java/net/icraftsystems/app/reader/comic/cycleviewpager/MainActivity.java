package net.icraftsystems.app.reader.comic.cycleviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import net.icraftsystems.app.reader.comic.cycleviewpager.Adapter.MyTVAdapter;
import net.icraftsystems.app.reader.comic.cycleviewpager.Model.MoviesModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    HorizontalInfiniteCycleViewPager viewPager;
    List<MoviesModel> moviesModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        viewPager = findViewById(R.id.view_pager);
        MyTVAdapter adapter = new MyTVAdapter(this, moviesModelList);
        viewPager.setAdapter(adapter);

    }

    private void initData() {

      moviesModelList.add(new MoviesModel("AQUAMAN", getString(R.string.long_text), R.drawable.adventuretime));
       moviesModelList.add(new MoviesModel("DEVORCE COURT", getString(R.string.long_text), R.drawable.doreamon));
      moviesModelList.add(new MoviesModel("ANDREW ECURUT", getString(R.string.long_text), R.drawable.dragonball));


    }
}

