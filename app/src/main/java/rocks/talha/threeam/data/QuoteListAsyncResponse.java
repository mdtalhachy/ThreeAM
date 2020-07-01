package rocks.talha.threeam.data;

import java.util.ArrayList;

import rocks.talha.threeam.model.Quote;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);

}
