package org.proverbio.android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.proverbio.android.material.R;

/**
 * @author Juan Pablo Proverbio <proverbio8@gmail.com>
 */
public abstract class BaseFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener
{
    /**
     * A reference to host activity
     */
    private AppCompatActivity appCompatActivity;

    /**
     * A swipe refresh layout
     */
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onAttach(Activity activity)
    {
        appCompatActivity = (AppCompatActivity)activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (swipeRefreshLayout == null)
        {
            //Gets {@see SwipeRefreshLayout} instance from inflated layout
            swipeRefreshLayout = ( SwipeRefreshLayout )inflater.inflate(R.layout.fragment_base, container, false);

            //---- SET SPINNING BACKGROUND COLOR

            //from a resource id
            //swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.dark_green);

            //from a color
            //swipeRefreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.dark_green));

            //---- SET SPINNING COLORS

            //Sets the spinning view colours from color resource ids
            swipeRefreshLayout.setColorSchemeResources( R.color.dark_green, R.color.light_green, R.color.dark_green, R.color.light_green );
            //It could also be: swipeRefreshLayout.setColorSchemeColors( new int[] { R.color.dark_green, R.color.light_green, R.color.dark_green, R.color.light_green } );

            //Sets the spinning view colours from color instances
            //swipeRefreshLayout.setColorSchemeColors( getResources().getColor( R.color.dark_green ), getResources().getColor( R.color.light_green ),
            //        getResources().getColor( R.color.dark_green ), getResources().getColor( R.color.light_green ) );

            //It could also be:
            //swipeRefreshLayout.setColorSchemeColors( new int[] { getResources().getColor( R.color.dark_green ), getResources().getColor( R.color.light_green ),
            //        getResources().getColor( R.color.dark_green ), getResources().getColor( R.color.light_green ) } );



            //Sets the {@see SwipeRefreshLayout.OnRefreshListener} to our SwipeRefreshLayout instance
            swipeRefreshLayout.setOnRefreshListener( this );


            //To check if the SwipeRefreshLayout is refreshing
            /*if (swipeRefreshLayout.isRefreshing())
            {
                //Execute logic
            }*/

            //To disable swipe
            //swipeRefreshLayout.setEnabled(false);

            //Sets distance to trigger SwipeRefreshLayout - It doesn't seem to change anything
            //swipeRefreshLayout.setDistanceToTriggerSync(200);

            //Set progress size, it must be one of {@see SwipeRefreshLayout.DEFAULT} or {@see SwipeRefreshLayout.LARGE}
            //swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);

            /**
             * @param scale Set to true if there is no view at a higher z-order than
             *            where the progress spinner is set to appear.
             * @param start The offset in pixels from the top of this view at which the
             *            progress spinner should appear.
             * @param end The offset in pixels from the top of this view at which the
             *            progress spinner should come to rest after a successful swipe
             *            gesture.
             */
            //Should be used only on required cases
            //swipeRefreshLayout.setProgressViewEndTarget(false, 300);
            //swipeRefreshLayout.setProgressViewOffset(false, 300, 350);
        }

        return swipeRefreshLayout;
    }

    @Override
    public void onRefresh()
    {
        // In a real case you will call here the method that retrieves updates from server.
        // That method should live in your GridAdapter or any other Adapter.

        getSwipeRefreshLayout().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //Stop the refresh animations
                getSwipeRefreshLayout().setRefreshing(false);
            }
        }, 2000);
    }

    public AppCompatActivity getAppCompatActivity()
    {
        return appCompatActivity;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout()
    {
        return swipeRefreshLayout;
    }
}