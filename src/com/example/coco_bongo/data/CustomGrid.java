package com.example.coco_bongo.data;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coco_bongo.R;

public class CustomGrid extends BaseAdapter{
    private Context mContext;

    private final int[] Imageid;
    private final String[] menuItem;
    private final boolean showSingleImage;
      public CustomGrid(Context c,String[] menuItem ,int[] Imageid ) {
          mContext = c;
          this.Imageid = Imageid;
          this.menuItem = menuItem;
          if (this.Imageid[0]==0){
        	  this.showSingleImage= true;
          }
          else{
        	  this.showSingleImage= false;  
          }
          
          
      }
	//ArrayList<menuItem> data;
	LayoutInflater inflater;
	
/*	public CustomAdapter(Context context, ArrayList<Integer> objects) {
		super(context, -1, objects);
		// TODO Auto-generated constructor stub
		this.data = objects;
		this.inflater=LayoutInflater.from(context);
	}*/
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View grid;
	     // al comentar el if los items ya salen sin repetirse
	      //if (convertView == null) {
	    	  LayoutInflater inflater = (LayoutInflater) mContext
	    		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	          grid = new View(mContext);
	          grid = inflater.inflate(R.layout.grid_element, null);
	          TextView textView = (TextView) grid.findViewById(R.id.txt_row_title);
	          ImageView imageView = (ImageView)grid.findViewById(R.id.img_row);
	          textView.setText(menuItem[position]);
	          if(showSingleImage){
	        	  imageView.setImageResource(Imageid[1]);
	          }
	          else{
	        	  imageView.setImageResource(Imageid[position]);
	          }
	     // } 
	     // else {
	     //       grid = (View) convertView;
	     // }
	      return grid;
		
		
		/*if(convertView==null){
			int list=R.layout.grid_element;
			
			convertView=inflater.inflate(list,null);
			holder=new ViewHolder();
			//holder.name=(TextView) convertView.findViewById(R.id.txt_row_title);
			holder.img=(ImageView) convertView.findViewById(R.id.img_row);
			
			convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder) convertView.getTag();
			
		}
		
		//holder.name.setText(current_item.getItemName());
		holder.img.setImageResource(img_resource);
		return convertView;*/
		
		
		
	}

	public class ViewHolder{
		public ImageView img;
		public TextView name;
		//public TextView link;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuItem.length;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
