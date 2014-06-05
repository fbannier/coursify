package com.example.coursify.view;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.coursify.Connection;
import com.example.coursify.R;
import com.example.coursify.Server;
import com.example.coursify.model.Course;
import com.example.coursify.model.User;

public class AddCoursesFragment extends Fragment {
	private ListView mListView = null;
	private int _toAdd = -1;

	public void setItemToAdd(int i) {
		_toAdd = i;
	}

	public void addItem() {
		User user = Connection.getInstance().getUser();
		Server server = Connection.getInstance().getServer();
		server.addUserLecture(user,
				server.getAvailableLectures(user).get(_toAdd));
		refreshCourses();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_add_courses, container,
				false);
		mListView = (ListView) view.findViewById(R.id.add_lectures_list);
		refreshCourses();

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				setItemToAdd(position);
				new AlertDialog.Builder(parent.getContext())
						.setIcon(android.R.drawable.ic_dialog_alert)
						.setTitle("Vorlesung hinzufügen?")
						.setMessage(
								"Möchten Sie die Vorlesung: "
										+ getLectures().get(position).getName()
										+ " wirklich hinzufügen?")
						.setPositiveButton("Ja",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										addItem();
									}

								}).setNegativeButton("Nope", null).show();
			}

		});

		return view;
	}

	private ArrayList<Course> getLectures() {
		Server server = Connection.getInstance().getServer();
		User user = Connection.getInstance().getUser();

		return server.getAvailableLectures(user);
	}

	private void refreshCourses() {
		CourseAdapter adapter = new CourseAdapter(getLectures());
		mListView.setAdapter(adapter);
	}

	private class CourseAdapter extends BaseAdapter {

		ArrayList<Course> courseList;

		public CourseAdapter(ArrayList<Course> items) {
			courseList = (ArrayList<Course>) items.clone();
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public Object getItem(int position) {
			return courseList.get(position);
		}

		@Override
		public int getCount() {
			return courseList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View out = convertView;

			if (out == null) {
				LayoutInflater vi = LayoutInflater.from(parent.getContext());
				out = vi.inflate(R.layout.list_item_course, null);
			}

			Course lecture = courseList.get(position);
			TextView name = (TextView) out.findViewById(R.id.item_course_name);
			TextView prof = (TextView) out.findViewById(R.id.item_course_prof);
			name.setText(lecture.getName());
			prof.setText(lecture.getProf());

			return out;
		}
	}

}
