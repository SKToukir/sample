package toukir.best.com.livecricscore.newupdate;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
=======
>>>>>>> ceb6613ed793ee4cc273e6ab525759a850a94344

import butterknife.Bind;
import butterknife.ButterKnife;
import toukir.best.com.livecricscore.R;
import toukir.best.com.livecricscore.newupdate.adapter.MainPagerAdapter;
import toukir.best.com.livecricscore.utils.NetworkChangeReceiver;

import static android.R.attr.button;

public class HomeActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;
    private NetworkChangeReceiver receiver;
    MainPagerAdapter adapter;
    CharSequence Titles[]={"Matches","Upcoming Mathces","Match Calender"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("");
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);



        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
//        registerReceiver(receiver, filter);

            setUpTabs();
            setUpClick();


    }


    void setUpClick(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    void setUpTabs(){
        adapter =  new MainPagerAdapter(this.getSupportFragmentManager(),Titles,Titles.length);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        //setupTabIcons();
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabs.getTabAt(1).setIcon(R.mipmap.ic_launcher);
    }
}