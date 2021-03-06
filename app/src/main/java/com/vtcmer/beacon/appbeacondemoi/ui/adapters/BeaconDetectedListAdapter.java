package com.vtcmer.beacon.appbeacondemoi.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vtcmer.beacon.appbeacondemoi.R;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vtcmer on 9/03/18.
 */

public class BeaconDetectedListAdapter extends RecyclerView.Adapter<BeaconDetectedListAdapter.ViewHolderBeacon> {



    private List<AppIBeaconDetail> iBeaconList = new ArrayList<AppIBeaconDetail>();
    private SelectBeaconItemCallBack onSelectBeaconItemCallBack;
    private Context context;


    public BeaconDetectedListAdapter(final SelectBeaconItemCallBack onSelectBeaconItemCallBack, final Context context) {
        this.onSelectBeaconItemCallBack = onSelectBeaconItemCallBack;
        this.context = context;
    }

    public void setIBeacons(final List<AppIBeaconDetail> appIBeacons) {
        this.iBeaconList.clear();
        this.iBeaconList.addAll(appIBeacons);
        this.notifyDataSetChanged();
    }

    public void addIBeaconItem(final AppIBeaconDetail iBeacon) {
        this.iBeaconList.add(iBeacon);
        this.notifyDataSetChanged();
    }

    public void clean() {
        this.iBeaconList.clear();
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolderBeacon onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ibeacon_item, parent, false);
        return new ViewHolderBeacon(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderBeacon holder, int position) {

        AppIBeaconDetail iBeacon = this.iBeaconList.get(position);
        holder.uuid.setText(iBeacon.getUuid());
        holder.major.setText(String.valueOf(iBeacon.getMajor()));
        holder.minor.setText(String.valueOf(iBeacon.getMinor()));
        holder.distance.setText(String.valueOf(iBeacon.getDistance()));
        holder.ubicacion.setText(iBeacon.getName());
        holder.descripcion.setText(iBeacon.getDescription());
        holder.setOnSelectBeaconItemCallBack(iBeacon, this.onSelectBeaconItemCallBack);

        if ((position % 2) != 0) {
            holder.containerDetail.setBackgroundResource(R.drawable.item_odd);
        }


        this.updatePositionImage(holder, iBeacon);

    }

    /**
     * Indicador de posición
     *
     * @param holder
     * @param iBeacon
     */
    private void updatePositionImage(ViewHolderBeacon holder, AppIBeaconDetail iBeacon) {

        double distante = iBeacon.getDistance();

        holder.position.setBackgroundResource(R.drawable.position_far);

        if ((distante >= 0) && (distante < 2)) {
            holder.position.setBackgroundResource(R.drawable.position_inmediate);
        } else if ((distante >= 2) && (distante < 6)) {
            holder.position.setBackgroundResource(R.drawable.position_near);
        } else if ((distante >= 6) && (distante < 10)) {
            holder.position.setBackgroundResource(R.drawable.position_far);
        } else if (distante >= 10) {
            holder.position.setBackgroundResource(R.drawable.position_undefined);
        }


    }

    @Override
    public int getItemCount() {
        return this.iBeaconList.size();
    }

    public static class ViewHolderBeacon extends RecyclerView.ViewHolder {

        @BindView(R.id.uuid)
        TextView uuid;
        @BindView(R.id.major)
        TextView major;
        @BindView(R.id.minor)
        TextView minor;
        @BindView(R.id.distance)
        TextView distance;
        @BindView(R.id.ubicacion)
        TextView ubicacion;
        @BindView(R.id.descripcion)
        TextView descripcion;
        @BindView(R.id.containerDetail)
        RelativeLayout containerDetail;
        @BindView(R.id.position)
        ImageButton position;

        private View view;

        public ViewHolderBeacon(View itemView) {

            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }

        public void setOnSelectBeaconItemCallBack(final AppIBeaconDetail appIBeacon, final SelectBeaconItemCallBack onSelectBeaconItemCallBack) {

            containerDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSelectBeaconItemCallBack.onSelectItem(appIBeacon);
                }
            });

        }

    }
}
