package com.example.coursify.view;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.coursify.R;

public class MainMenuFragment extends ListFragment {
	private View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		ListView menuItemsList = (ListView) view
				.findViewById(R.id.menu_items_list);
		// String[] listItems = getResources()
		// .getStringArray(R.id.menu_items_list);
		String[] listItems = { "bla1", "bla2", "bla3" };
		for (int i = 0; i < listItems.length; i++) {
			Log.d("bla", listItems[i]);
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this.getActivity(), R.layout.list_item_course,
				R.id.list_content, listItems);

		menuItemsList.setAdapter(adapter);
		menuItemsList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = inflater.inflate(R.layout.fragment_main_menu, container, false);
		// Für Testzwecke erstmal ohne Absicherung
		// try {
		ListView menuItemsList = (ListView) view
				.findViewById(R.id.menu_items_list);

		initializeMenuItemsList(menuItemsList);
		// } finally {
		return view;
		// }
	}

	@Override
	public void onAttach(Activity activity) {
		ListView menuItemsList = (ListView) activity
				.findViewById(R.id.menu_items_list);

		initializeMenuItemsList(menuItemsList);
	}

	private void initializeMenuItemsList(ListView menuItemsList) {
		menuItemsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MainActivity main = (MainActivity) view.getContext();

				// Da diese Liste statisch ist, werden hier bekannte Positonen
				// verwendet

				for (int i = 0; i < parent.getChildCount(); i++) {
					parent.getChildAt(i).setBackgroundColor(0xFF333333);
				}
				switch (position) {
				case 0:
					view.setBackgroundColor(0xFF666666);
					main.setMTitle("Meine Vorlesungen");
					FragmentSwitcher.switchToFragment(new MyCoursesFragment(),
							main);

					break;
				case 1:
					view.setBackgroundColor(0xFF666666);
					FragmentSwitcher.switchToFragment(new CourseFragment(),
							main);
					break;
				case 2:
					view.setBackgroundColor(0xFF666666);

					break;
				default:

					break;
				}

				DrawerLayout drawer = (DrawerLayout) main
						.findViewById(R.id.drawer_layout); // if (drawer !=
															// null) {
				drawer.closeDrawers(); // } main.initializeComments();

			}

		});

	}
}
