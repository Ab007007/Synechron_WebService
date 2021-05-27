package com.synechron.ws.wstraining.basics.pojo;

import java.util.List;

public class Prefs {
	private String permissionLevel;
	private String bgImage;
	private List<ImageConfig> bgImageScaled;
	
	
	public String getPermissionLevel() {
		return permissionLevel;
	}
	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
	public String getBgImage() {
		return bgImage;
	}
	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}
	public List<ImageConfig> getBgImageScaled() {
		return bgImageScaled;
	}
	public void setBgImageScaled(List<ImageConfig> bgImageScaled) {
		this.bgImageScaled = bgImageScaled;
	}
	
	
}
