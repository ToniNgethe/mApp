package app.feed.mercyapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbarLoanStatuses)
    Toolbar toolbarLoanStatuses;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbarLoanStatuses);
        getSupportActionBar().setTitle("");
        setUpVp();

    }


    private void setUpVp() {

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
                viewpagerAdapter.addFragment(new HomeFragment(), "Home");
                viewpagerAdapter.addFragment(new EventsFragment(), "Events");
                viewpagerAdapter.addFragment(new FeedBackFragment(), "Feedback");

                viewpager.setAdapter(viewpagerAdapter);

            }
        });

        tabs.setupWithViewPager(viewpager);
    }
}
