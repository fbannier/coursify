package com.example.coursify.view;

import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;

public class FragmentSwitcher {

	public static void switchToFragment(Fragment destination, MainActivity main) {
		if (main != null) {
			DrawerLayout drawer = main.getDrawerLayout();
			if (drawer != null) {
				drawer.removeViewAt(0);
				drawer.addView(
						destination.onCreateView(main.getLayoutInflater(),
								main.getDrawerLayout(), null), 0);
			}
		}
	}
}
