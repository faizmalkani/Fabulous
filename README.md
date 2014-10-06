FloatingActionButton
====================

Library to use the Floating Action Button (FAB) from Android L on Jellybean and KitKat.

Use Drawables of size `24dp` as FabDrawables to get the desired look. Drawables can be generated via [Android Asset Studio](http://romannurik.github.io/AndroidAssetStudio/).

## Instructions

1. Place the FAB in a FrameLayout and add your layouts above the FAB view. For best results, keep the FAB height and width at 72dp and in the bottom right of the FrameLayout

    ```xml
    <FrameLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <!--
        Your layouts here. Do not put anything below the FAB layout
        -->


        <com.faizmalkani.floatingactionbutton.FloatingActionButton
            android:id="@+id/fabbutton"
            android:layout_width="72dp"
            android:layout_height="72dp"
            android:layout_gravity="bottom|right"
            android:layout_marginBottom="16dp"
            android:layout_marginRight="16dp"
            app:drawable="@drawable/ic_action_edit"
            app:color="@color/some_color"
            />

    </FrameLayout>
    ```


2. Initialize your FAB in your activity's `onCreate()`

    ```java
    Fab mFab = (Fab)findViewById(R.id.fabbutton);
    ```

3. Set the drawable and color of the FAB

    ```java
    mFab.setFabColor(int fabColor);
    mFab.setFabDrawable(Drawable fabDrawable);
    ```

4. If needed, call the other methods of the FAB

    ```java
    mFab.hideFab();
    mFab.showFab();
    mFab.setAlpha();
    mFab.setOnClickListener();
    ```








© 2014 Faiz Malkani



