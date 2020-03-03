package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.Key;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{
private Context mContext;
private List<Upload> mUploads;
private OnItemClickListener mListener;

public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
        }

@Override
public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
        }

@Override
public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        holder.keterangan.setText(uploadCurrent.getDescription());
        Picasso.with(mContext)
        .load(uploadCurrent.getImageUrl())
        .placeholder(R.drawable.imagepreview)
        .fit()
        .centerCrop()
        .into(holder.imageView);
        }



@Override
public int getItemCount() {
        return mUploads.size();
        }

public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener {
    public TextView textViewName;
    public TextView keterangan;
    public ImageView imageView;
    public Button lihat;


    public ImageViewHolder(View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.img_description);
        keterangan = itemView.findViewById(R.id.keterangan);
        imageView = itemView.findViewById(R.id.image_view);
        lihat = itemView.findViewById(R.id.btn_lihat);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,MapsActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                mListener.onItemClick(position);
                Intent intent = new Intent(mContext,DetailActivity.class);
            }

        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Pilih Aksi");
        MenuItem dodelete = menu.add(Menu.NONE,2,2,"Hapus");
        dodelete.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (mListener !=null){
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION){

                switch (item.getItemId()){
                    case 2:
                        mListener.onHapusClick(position);
                        return true;

                }
            }
        }
        return false;
    }
}
public interface OnItemClickListener{
    void onItemClick(int position);



    void onHapusClick(int position);


}
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }
}
