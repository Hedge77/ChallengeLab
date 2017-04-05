package group7.tcss450.uw.edu.challengeapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentThree.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentThree extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        Button b = (Button) v.findViewById(R.id.submitButton2);
        b.setOnClickListener(this);

        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        EditText userText = (EditText) this.getView().findViewById(R.id.userText2);
        String user = userText.getText().toString();

        EditText passText = (EditText) this.getView().findViewById(R.id.passText2);
        String pass = passText.getText().toString();

        EditText confText = (EditText) this.getView().findViewById(R.id.confirmPassText);
        String conf = confText.getText().toString();

        if (user == null || user.equals("")) {
            userText.setError("Must enter text!");
        } else if (pass == null || pass.equals("")) {
            passText.setError("Must enter text!");
        } else if (!conf.equals(pass)) {
            confText.setError("Passwords must match!");
        } else {
            mListener.onFragmentInteraction(user, pass);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String user, String pass);
    }
}
