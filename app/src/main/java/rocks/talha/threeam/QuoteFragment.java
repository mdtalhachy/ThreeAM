package rocks.talha.threeam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {R.color.blue_500, R.color.pink_900, R.color.yellow_800, R.color.green_600,
        R.color.lime_700, R.color.orange_400, R.color.amber_800, R.color.grey_600, R.color.pink_800};

        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        cardView.setBackgroundResource(getRandomQuoteColor(colors));

        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author){
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();

        bundle.putString("quote", quote);
        bundle.putString("author", author);

        fragment.setArguments(bundle);

        return fragment;
    }

    /*
        Getting different colors for quotes card
    */
    int getRandomQuoteColor(int colorArray[]){

        int color;
        int quotesArrayLen = colorArray.length;

        int rand = ThreadLocalRandom.current().nextInt(quotesArrayLen);

        color = colorArray[rand];

        return color;
    }

}
