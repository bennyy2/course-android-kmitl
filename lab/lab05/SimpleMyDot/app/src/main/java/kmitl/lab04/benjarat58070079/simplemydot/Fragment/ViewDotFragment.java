package kmitl.lab04.benjarat58070079.simplemydot.Fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import kmitl.lab04.benjarat58070079.simplemydot.Model.Colors;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dot;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dots;
import kmitl.lab04.benjarat58070079.simplemydot.R;
import kmitl.lab04.benjarat58070079.simplemydot.View.DotView;



public class ViewDotFragment extends Fragment implements DotView.OnDotViewPressListener, Dots.OnDotsChangeListener, View.OnClickListener{

    private DotView dotView;
    private Dots dots;
    private static ViewDotListener listener;

    public static ViewDotFragment newInstance() {
        Bundle args = new Bundle();
        ViewDotFragment fragment = new ViewDotFragment();
        fragment.setListener(listener);
        fragment.setArguments(args);
        return fragment;
    }

    public void setListener(ViewDotListener listener){
        this.listener = listener;
    }

    private interface ViewDotListener {
    }



    public ViewDotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_view_dot, container, false);
        Button random = rootView.findViewById(R.id.btnrandom);
        Button reset = rootView.findViewById(R.id.btnreset);
        dotView = rootView.findViewById(R.id.dotview);
        dotView.setOnDotViewPressListener(this);
        dots = new Dots();
        dots.setListener(this);
        random.setOnClickListener(this);
        reset.setOnClickListener(this);
        return rootView;


    }

    @Override
    public void onDotViewPressed(int x, int y) {
        int dotPosition = dots.findDot(x, y);
        if (dotPosition == -1) {
            Dot newDot = new Dot(x, y, 30, new Colors().getColor());
            dots.addDot(newDot);

        } else {
            dots.removeBy(dotPosition);
        }

    }

    @Override
    public void onDotViewLongPressed(int x, int y) {
        final int dotPosition = dots.findDot(x, y);
        if(dotPosition != -1){
            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setItems(new CharSequence[]{"Edit Color", "Edit Size"}, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i){
                        case 0:
                            dots.changeColor(dotPosition, new Colors().getColor());
                            break;
                        case 1:
                            dots.changeSize(dotPosition);
                            break;
                    }
                }

            });
            builder.show();
        }
    }

    @Override
    public void onDotsChanged(Dots dots) {
        dotView.setDots(dots);
        dotView.invalidate();
    }

    public void onRandomDot() {
        Random random = new Random();
        int centerX = random.nextInt(dotView.getWidth());
        int centerY = random.nextInt(dotView.getHeight());
        Dot newDot = new Dot(centerX, centerY, 30, new Colors().getColor());
        dots.addDot(newDot);
    }



    @Override
    public void onClick(View view) {
        if (R.id.btnrandom == view.getId()) {
            onRandomDot();
        } else if (R.id.btnreset == view.getId()) {
            dots.clearAll();
        }
    }


}
