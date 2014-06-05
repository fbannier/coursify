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

public class MyCoursesFragment extends Fragment {
	private ListView mListView = null;
	private int _toDelete = -1;

	public void setItemToDelete(int i) {
		_toDelete = i;
	}

	public void deleteItem() {
		User user = Connection.getInstance().getUser();
		Server server = Connection.getInstance().getServer();
		server.removeUserLecture(user,
				server.getUserLectures(user).get(_toDelete));
		refreshCourses();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_my_courses, container,
				false);
		mListView = (ListView) view.findViewById(R.id.my_lectures_list);
		refreshCourses();
		mListView
				.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {

						setItemToDelete(position);
						new AlertDialog.Builder(parent.getContext())
								.setIcon(android.R.drawable.ic_dialog_alert)
								.setTitle("Vorlesung löschen")
								.setMessage(
										"Möchten Sie die Vorlesung wirklich löschen?")
								.setPositiveButton("Ja",
										new DialogInterface.OnClickListener() {

											@Override
											public void onClick(
													DialogInterface dialog,
													int which) {
												deleteItem();
											}

										}).setNegativeButton("Nope", null)
								.show();

						return true;
					}
				});
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MainActivity main = (MainActivity) view.getContext();
				main.setMTitle(getLectures().get(position).getName());
				FragmentSwitcher.switchToFragment(new CourseFragment(), main);
				main.initializeComments();
			}

		});

		return view;
	}

	private ArrayList<Course> getLectures() {
		Server server = Connection.getInstance().getServer();
		User user = Connection.getInstance().getUser();

		return server.getUserLectures(user);
	}

	private void refreshCourses() {
		CourseAdapter adapter = new CourseAdapter(getLectures());
		mListView.setAdapter(adapter);
	}

	private class CourseAdapter extends BaseAdapter {

		ArrayList<Course> courseList;

		@SuppressWarnings("unchecked")
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
