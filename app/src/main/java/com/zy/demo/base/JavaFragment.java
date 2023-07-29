package com.zy.demo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zy.demo.R;
import com.zy.multistatepage.MultiStateContainer;
import com.zy.multistatepage.MultiStatePage;

/**
 * @author: yanz
 */
class JavaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_main, container, false);
        MultiStateContainer multiStateContainer = MultiStatePage.bindMultiState(root);
        return multiStateContainer;
    }
}
