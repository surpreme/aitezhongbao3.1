package com.aite.mainlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aite.mainlibrary.Mainbean.BinderSosUserListBean;
import com.aite.mainlibrary.R;
import com.aite.mainlibrary.R2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lzy.basemodule.OnClickLstenerInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BinSosderUserRecyAdapter extends RecyclerView.Adapter<BinSosderUserRecyAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<BinderSosUserListBean.ListBean> listBean;

    public BinSosderUserRecyAdapter(Context context, List<BinderSosUserListBean.ListBean> listBean) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.listBean = listBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recy_item_binding_sosuser, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public interface OnClickThingInterface {
        void onDelete(String position);

        void onedit(String position);
    }

    public void setOnClickThingInterface(OnClickThingInterface onClickThingInterface) {
        this.onClickThingInterface = onClickThingInterface;
    }

    private OnClickThingInterface onClickThingInterface;
    private OnClickLstenerInterface.OnRecyClickInterface clickInterface;

    public OnClickLstenerInterface.OnRecyClickInterface getClickInterface() {
        return clickInterface;
    }

    public void setClickInterface(OnClickLstenerInterface.OnRecyClickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    /**
     * "id": 1,
     * "title": "父亲"
     * },
     * {
     * "id": 2,
     * "title": "母亲"
     * },
     * {
     * "id": 3,
     * "title": "子女"
     * },
     * {
     * "id": 4,
     * "title": "爱人"
     * },
     * {
     * "id": 5,
     * "title": "其他"
     * }
     *
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String isDefault = listBean.get(position).getIs_default().equals("1") ? " 默认" : "";
        switch (listBean.get(position).getRelation()) {
            case "1":
            case "父亲":
                holder.nameTv.setText(String.format("%s%s", String.format(" %s 父亲  ",
                        listBean.get(position).getRealname()), isDefault));
                holder.phoneTv.setText(listBean.get(position).getMobile());
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;
            case "2":
            case "母亲":
                holder.nameTv.setText(String.format("%s%s", String.format(" %s 母亲  ",
                        listBean.get(position).getRealname()), isDefault));
                holder.phoneTv.setText(listBean.get(position).getMobile());
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;
            case "3":
            case "子女":
                holder.nameTv.setText(String.format("%s%s", String.format(" %s 子女  ",
                        listBean.get(position).getRealname()), isDefault));
                holder.phoneTv.setText(listBean.get(position).getMobile());
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;
            case "4":
            case "爱人":
                holder.nameTv.setText(String.format("%s%s", String.format(" %s 爱人  ",
                        listBean.get(position).getRealname()), isDefault));
                holder.phoneTv.setText(listBean.get(position).getMobile());
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;
            case "5":
            case "其他":
                holder.nameTv.setText(String.format("%s%s", String.format(" %s 其他  ",
                        listBean.get(position).getRealname()), isDefault));
                holder.phoneTv.setText(listBean.get(position).getMobile());
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;
            default:
                holder.nameTv.setText(String.format(" %s 未知 ", listBean.get(position).getRealname()));
                holder.phoneTv.setText("未知手机号");
                Glide.with(context).load(listBean.get(position).getAvatar()).apply(RequestOptions.circleCropTransform()).into(holder.userIconIv);
                break;

        }

        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickThingInterface != null)
                    onClickThingInterface.onDelete(String.valueOf(position));
            }
        });
        holder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickThingInterface != null)
                    onClickThingInterface.onedit(String.valueOf(position));
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickInterface != null)
                    clickInterface.getPosition(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBean == null ? 0 : listBean.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.user_icon_iv)
        ImageView userIconIv;
        @BindView(R2.id.name_tv)
        TextView nameTv;
        @BindView(R2.id.phone_tv)
        TextView phoneTv;
        @BindView(R2.id.tv_edit)
        TextView tvEdit;
        @BindView(R2.id.tv_delete)
        TextView tvDelete;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
