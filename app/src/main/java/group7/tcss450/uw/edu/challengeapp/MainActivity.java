package group7.tcss450.uw.edu.challengeapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentInteractionListener,
        FragmentTwo.OnFragmentInteractionListener, FragmentThree.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.fragmentContainer) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new FragmentOne())
                        .commit();
            }
        }
    }

    @Override
    public void onFragmentInteraction(int nextFrag) {

        if (nextFrag == 2) {
            FragmentTwo f2;
            f2 = new FragmentTwo();
            Bundle args = new Bundle();
//            args.putSerializable(getString(R.string.color_key), color);
//            colorFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, f2)
                    .addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        } else if (nextFrag == 3) {
            FragmentThree f3;
            f3 = new FragmentThree();
            Bundle args = new Bundle();
//            args.putSerializable(getString(R.string.color_key), color);
//            colorFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, f3)
                    .addToBackStack(null);
            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(String user, String pass) {
        FragmentFour f4;
        f4 = new FragmentFour();
        Bundle args = new Bundle();
        args.putSerializable(getString(R.string.user_key), user);
        args.putSerializable(getString(R.string.pass_key), pass);
        f4.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, f4)
                .addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}
