package group7.tcss450.uw.edu.challengeapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFour extends Fragment {


    public FragmentFour() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_four, container, false);
    }

    public void updateContent(String user, String pass) {
        TextView tv1 = (TextView) getActivity().findViewById(R.id.userTextView);
        tv1.setText(getString(R.string.display_user) + user);

        TextView tv2 = (TextView) getActivity().findViewById(R.id.passTextView);
        tv2.setText(getString(R.string.display_pass) + pass);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            String user = getArguments().getString(getString(R.string.user_key));
            String pass = getArguments().getString(getString(R.string.pass_key));
            updateContent(user, pass);
        }
    }

}
