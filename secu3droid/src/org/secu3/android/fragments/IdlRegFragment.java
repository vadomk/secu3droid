package org.secu3.android.fragments;

import org.secu3.android.R;
import org.secu3.android.api.io.Secu3Dat;
import org.secu3.android.api.io.Secu3Dat.IdlRegPar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

public class IdlRegFragment extends Fragment implements ISecu3Fragment{
	EditText ifac1;
	EditText ifac2;
	EditText minimalAngle;
	EditText maximalAngle;
	EditText targetRPM;
	EditText rpmSensitivity;
	CheckBox useIdleReg;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) return null;
		
		return inflater.inflate(R.layout.idlreg_params, null);
	}

	@Override
	public void setData(Secu3Dat packet) {
		if (packet != null && isAdded()) {
			ifac1 = (EditText)getView().findViewById(R.id.textview2);
			ifac2 = (EditText)getView().findViewById(R.id.idlRegIfac2EditText); 
			minimalAngle = (EditText)getView().findViewById(R.id.idlRegMinimalAngleEditText);
			maximalAngle = (EditText)getView().findViewById(R.id.idlRegMaximalAngleEditText);
			targetRPM = (EditText)getView().findViewById(R.id.idlRegTargetRPMEditText);
			rpmSensitivity = (EditText)getView().findViewById(R.id.idlRegRPMSensitivityEditText);
			useIdleReg = (CheckBox)getView().findViewById(R.id.idlRegUseIdleRegulatorCheckBox);
			
			ifac1.setText(String.valueOf(((IdlRegPar)packet).ifac1));
			ifac2.setText(String.valueOf(((IdlRegPar)packet).ifac2));
			minimalAngle.setText(String.valueOf(((IdlRegPar)packet).min_angle));
			maximalAngle.setText(String.valueOf(((IdlRegPar)packet).max_angle));
			targetRPM.setText(String.valueOf(((IdlRegPar)packet).idling_rpm));
			rpmSensitivity.setText(String.valueOf(((IdlRegPar)packet).MINEFR));
			useIdleReg.setChecked(((IdlRegPar)packet).idl_regul != 0);
		}
	}
}