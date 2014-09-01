package com.app.coco_bongo.models;

public class menuItem {
	private String item_name;
	private Integer item_picture;
	private String item_target;
	
	public menuItem(Integer item_picture){
		this.item_picture = item_picture;
	}
	public String getItemName(){
		return this.item_name;
	}
	public Integer getItemPicture(){
		return this.item_picture;
	}
	public void setItemName(String item_name){
		this.item_name=item_name;
	}
}
