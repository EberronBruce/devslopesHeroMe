package com.redravencomputing.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.redravencomputing.herome.Activites.MainActivity;
import com.redravencomputing.herome.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackstoryFragment.BackstoryInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackstoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackstoryFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button startOverBtn;
    private Button primaryPowerBtn;
    private Button secodaryPowerBtn;

    private String howPower;
    private String secondPower;
    private int secondPowerId;

    private TextView heroTxtView;
    private TextView backstoryTxtView;

    private BackstoryInteractionListener mListener;

    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        startOverBtn = (Button)view.findViewById(R.id.startOverBtn);
        primaryPowerBtn = (Button)view.findViewById(R.id.primaryPowerBtn);
        secodaryPowerBtn = (Button)view.findViewById(R.id.secondaryPowerBtn);

        heroTxtView = (TextView)view.findViewById(R.id.heroTxtView);
        backstoryTxtView = (TextView)view.findViewById(R.id.backstoryTxtView);

        setUpScreen(heroTxtView, backstoryTxtView, primaryPowerBtn, secodaryPowerBtn);


        startOverBtn.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.reloadMainScreen();
    }

    private void setUpScreen(TextView heroTxtView, TextView backstoryTxtView, Button primaryPowerBtn, Button secodaryPowerBtn){

        String primary = howPower;

        switch (primary) {
            case "accident":
                System.out.println("This is accidental power");
                heroTxtView.setText("The Freak");
                primaryPowerBtn.setText("Web Slinging");
                primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb,0,0,0);
                break;
            case "genetic":
                System.out.println("This is genetic power");
                heroTxtView.setText("The Mutant");
                primaryPowerBtn.setText("Turtle Power");
                primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower,0,0,0);
                break;
            case "born":
                System.out.println("This is born power");
                heroTxtView.setText("Super Human");
                primaryPowerBtn.setText("Flight");
                primaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.supermancrest,0,0,0);
                break;

        }

        getBackStory(primary, backstoryTxtView);

        arrangeSecondaryPowerImage(secodaryPowerBtn);

    }

    private void getBackStory(String primary, TextView backstoryTxtView) {

        switch (primary) {
            case "accident":
                backstoryTxtView.setText("Attending a demonstration on radiation, Peter is bitten by a glowing, radioactive spider that promptly dies. Feeling ill, Peter wanders out onto the street and narrowly avoids an oncoming car by making a superhuman leap into the air. On instinct, he lands on the side of a building and clings to it. Peter discovers he has gained the proportionate speed, strength and agility of a spider.");
                break;
            case "genetic":
                backstoryTxtView.setText("Dr. Brian Banner was an atomic physicist who worked on producing clean nuclear power as an energy source, but he was afraid his exposure to it mutated his son's genes. \n");
                break;
            case "born":
                backstoryTxtView.setText("Superman is born Kal-El on the alien planet Krypton. His parents, Jor-El and Lara become aware of Krypton's impending destruction and Jor-El begins constructing a spacecraft that would carry Kal-El to Earth. During Krypton's last moments, Jor-El places young Kal-El in the spacecraft and launches it. Jor-El and Lara die as the spacecraft barely escapes Krypton's fate. The explosion transforms planetary debris into kryptonite, a radioactive substance that is lethal to superpowered (as by Earth's yellow sun) Kryptonians.\n"+
                        "The spacecraft lands in the rural United States, where it is found by a passing motorist. Jonathan and Martha Kent adopt Kal-El and name him Clark Kent. As Clark grows up on Earth, he and his adoptive parents discover that he has superhuman powers. The Kents teach Clark to use these powers responsibly to help others and fight crime.");
                break;
        }
    }


    private void arrangeSecondaryPowerImage(Button secondaryPowerBtn) {
        secondaryPowerBtn.setText(secondPower);
        secondaryPowerBtn.setCompoundDrawablesWithIntrinsicBounds(secondPowerId,0,0,0);
    }

    public void setHowPower(String power) {
        howPower = power;
    }

    public void setSecondPower(String second) {
        secondPower = second;
    }

    public void setSecondPowerId(int id) {
        secondPowerId = id;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackstoryInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackstoryInteractionListener) {
            mListener = (BackstoryInteractionListener) context;
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
    public interface BackstoryInteractionListener {
        // TODO: Update argument type and name
        void onBackstoryInteraction(Uri uri);
    }
}
