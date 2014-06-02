package com.example.coursify.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.coursify.LecturesFragment;
import com.example.coursify.R;
import com.example.coursify.model.Lecture;

public class MyLecturesFragment extends LecturesFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_my_lectures, container,
				false);
		ListView mListView = (ListView) view
				.findViewById(R.id.my_lectures_list);

		ArrayList<String> values = new ArrayList<String>();

		for (Lecture lecture : mockLectures()) {
			values.add((String) lecture.getName());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getMain(),
				R.layout.course_list_item, R.id.course_name, values);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				getMain().setMTitle(mockLectures().get(position).getName());
				FragmentSwitcher.switchToFragment(new LectureFragment(),
						getMain());
				getMain().initializeComments();
			}

		});

		return view;
	}

	private ArrayList<Lecture> mockLectures() {
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		lectures.add(new Lecture("Vorlesung 1"));
		lectures.add(new Lecture("Vorlesung 2"));
		lectures.add(new Lecture("Vorlesung 3"));
		lectures.add(new Lecture("Vorlesung 4"));
		lectures.add(new Lecture("Vorlesung 5"));
		lectures.add(new Lecture("Vorlesung 6"));
		lectures.add(new Lecture("Vorlesung 7"));
		return lectures;
	}

	private class StableArrayAdapter extends ArrayAdapter<String> {

		HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

		public StableArrayAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			for (int i = 0; i < objects.size(); ++i) {
				mIdMap.put(objects.get(i), i);
			}
		}

		@Override
		public long getItemId(int position) {
			String item = getItem(position);
			return mIdMap.get(item);
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

	}

}
