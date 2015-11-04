package com.example.billmac1.actionbarnative;

/**
 * Created by billmac1 on 11/4/2015.
 */
import android.app.ListFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class ActionBarFragment extends ListFragment {
    private static final String[] items= { "lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi",
            "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam",
            "vel", "erat", "placerat", "ante", "porttitor", "sodales",
            "pellentesque", "augue", "purus" };

    private ArrayList<String> words=null;
    private ArrayAdapter<String> adapter=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (adapter == null) {
            adapter=
                    new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_list_item_1,
                            new ArrayList<String>());
            setListAdapter(adapter);
            initAdapter();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actions, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                addWord();

                return(true);

            case R.id.reset:
                initAdapter();

                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }

    private void initAdapter() {
        words=new ArrayList<String>();

        for (int i=0;i<5;i++) {
            words.add(items[i]);
        }

        adapter.clear();
        adapter.addAll(words);
    }

    private void addWord() {
        if (adapter.getCount()<items.length) {
            adapter.add(items[adapter.getCount()]);
        }
    }

}
