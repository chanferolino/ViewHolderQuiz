package sidespell.tech.viewholderquiz.fragments;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sidespell.tech.viewholderquiz.R;

/**
 * A placeholder fragment containing a {@link android.widget.ListView}.
 */
public class ListViewFragment extends Fragment {

    private static final String KEY_NAME     = "movie_name";
    private static final String KEY_COVER     = "movie_cover";
    private static final String KEY_GENRE = "movie_genre";
    private static final String KEY_DESCRIPTION = "movie_description";
    ListView mListView;
    private SimpleAdapter        mAdapter;
    private TypedArray mNameList;
    private TypedArray mCoverList;
    private TypedArray mGenreList;
    private TypedArray mDescriptionList;
    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        mNameList = getResources().obtainTypedArray(R.array.movies);
        mCoverList = getResources().obtainTypedArray(R.array.coverphoto);
        mGenreList = getResources().obtainTypedArray(R.array.genre);
        mDescriptionList = getResources().obtainTypedArray(R.array.description);

        mListView= (ListView) view.findViewById(R.id.listView);
        mListView = (ListView) inflater.inflate(R.layout.listview_item,container,false);
        List<HashMap<String, String>> dataMovies = new ArrayList<>();
        for (int i = 0; i < mNameList.length(); i++) {
            HashMap<String, String> data = new HashMap<>();
            data.put(KEY_NAME, mNameList.getString(i));
            data.put(KEY_COVER, Integer.toString(mCoverList.getResourceId(i, R.drawable.c1)));
            data.put(KEY_GENRE, mGenreList.getString(i));
            data.put(KEY_DESCRIPTION, mDescriptionList.getString(i));
            dataMovies.add(data);
        }
        String[] from = {KEY_NAME, KEY_COVER,KEY_GENRE,KEY_DESCRIPTION};

        // Ids of views in the list_item_country.xml layout
        int[] to = {R.id.imgViewCover,R.id.txtName, R.id.txtGenre,R.id.txtDescription};



        mAdapter = new SimpleAdapter(view.getContext(), dataMovies, R.layout.listview_item, from, to);
        mListView.setAdapter(mAdapter);


        return view;
    }
}
