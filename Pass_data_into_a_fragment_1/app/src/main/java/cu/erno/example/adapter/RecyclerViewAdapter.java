package cu.erno.example.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import cu.erno.example.R;

public class RecyclerViewAdapter extends ListAdapter<Integer, RecyclerViewAdapter.RecyclerViewViewHolder> {

    OnItemClickListener onItemClickListener = null;

    public RecyclerViewAdapter() {
        super(new IntegerDiffCallBack());
    }

    @NonNull
    @SuppressLint("InflateParams")
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new RecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, int position) {
        holder.bind(getCurrentList().get(position));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public RecyclerViewViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public void bind(int num) {
            String text = "Item " + num;
            textView.setText(text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) onItemClickListener.onItemClick(num);
                }
            });
        }
    }

    static class IntegerDiffCallBack extends DiffUtil.ItemCallback<Integer> {

        @Override
        public boolean areItemsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
            return oldItem.equals(newItem);
        }
    }
}
