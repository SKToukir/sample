package toukir.best.com.livecricscore.newupdate;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.newupdate.adapter.MainPagerAdapter;
import toukir.best.com.livecricscore.newupdate.adapter.TeamSquadAdapter;

public class SquadActivity extends AppCompatActivity {

    public static String unique_Id, team_one, team_two;
    private Toolbar toolbar;

    TeamSquadAdapter adapter;
    CharSequence Titles[];
    ViewPager pager;
    TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad);
        toolbar = (Toolbar) findViewById(R.id.tool_bar_squad);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        initUI();

    }

    private void initUI() {
        tabs = (TabLayout) findViewById(R.id.tabs_squad);
        Titles = new CharSequence[]{team_one, team_two};
        pager = (ViewPager) findViewById(R.id.pager_squad);
        setUpTabs();

    }

    void setUpTabs(){
        adapter =  new TeamSquadAdapter(this.getSupportFragmentManager(),Titles,Titles.length);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        //setupTabIcons();
    }

}
