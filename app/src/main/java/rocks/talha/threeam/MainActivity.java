package rocks.talha.threeam;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import rocks.talha.threeam.data.QuoteData;
import rocks.talha.threeam.data.QuoteListAsyncResponse;
import rocks.talha.threeam.data.QuoteViewPagerAdapter;
import rocks.talha.threeam.model.Quote;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);
    }

    private List<Fragment> getFragments(){
        final List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for(int i = 0; i < quotes.size(); i++){

                    /*
                      Getting the quote and  author from Json
                    */
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getAuthor());

                    fragmentList.add(quoteFragment);
                }

                /*
                    Notifying the adapter that things have changed. Very Important.
                */
                quoteViewPagerAdapter.notifyDataSetChanged();
            }
        });

        return fragmentList;
    }
}
