package com.citytechinc.cq.component.dialog.impl;

import org.codehaus.plexus.util.StringUtils;

import com.citytechinc.cq.component.annotations.config.Widget;
import com.citytechinc.cq.component.dialog.AbstractWidget;

@Widget(annotationClass="com.citytechinc.cq.component.annotations.widgets.Html5SmartImage",makerClass="com.citytechinc.cq.component.dialog.maker.impl.Html5SmartImageWidgetMaker",xtypes=Html5SmartImageWidget.XTYPE)
public class Html5SmartImageWidget extends AbstractWidget {
	public static final String XTYPE="html5smartimage";
	private static final String PRIMARY_TYPE="cq:Widget";
	private String originalName;
	private final boolean disableFlush;
	private final boolean disableInfo;
	private final boolean disableZoom;
	private final String cropParameter;
	private final String fileNameParameter;
	private final String fileReferenceParameter;
	private final String mapParameter;
	private final String rotateParameter;
	private final String uploadUrl;
	private final String ddGroups;
	private final boolean allowUpload;
	private Integer height;
	private boolean tab;

	public Html5SmartImageWidget(String name, boolean disableFlush,
			boolean disableInfo, boolean disableZoom, String cropParameter,
			String fileNameParameter, String fileReferenceParameter,
			String mapParameter, String rotateParameter, String uploadUrl,
			String ddGroups, boolean allowUpload,boolean required,boolean hideLabel,String fieldLabel,
			String fieldName,
			String fieldDescription,
			Integer height,
			boolean tab) {
		super(XTYPE,fieldLabel,fieldDescription,!required,hideLabel,null,getNameAsPrefix(name),PRIMARY_TYPE, null, fieldName,null,null);
		originalName=name;
		this.disableFlush = disableFlush;
		this.disableInfo = disableInfo;
		this.disableZoom = disableZoom;
		this.cropParameter = cropParameter;
		this.fileNameParameter = fileNameParameter;
		this.fileReferenceParameter = fileReferenceParameter;
		this.mapParameter = mapParameter;
		this.rotateParameter = rotateParameter;
		this.uploadUrl = uploadUrl;
		this.ddGroups = ddGroups;
		this.allowUpload = allowUpload;
		this.height=height;
		this.tab=tab;
	}
	
	private static String getNameAsPrefix(String name){
		if(StringUtils.isEmpty(name)){
			return "./";
		}else{
			return "./"+name+"/";
		}
	}

	public String getTitle() {
		return getFieldLabel();
	}

	public boolean isDisableFlush() {
		return disableFlush;
	}

	public boolean isDisableInfo() {
		return disableInfo;
	}

	public boolean isDisableZoom() {
		return disableZoom;
	}

	public String getCropParameter() {
		return cropParameter;
	}

	public String getFileNameParameter() {
		if(!StringUtils.isEmpty(fileNameParameter)){
			return getNameAsPrefix(originalName)+fileNameParameter;
		}
		return fileNameParameter;
	}

	public String getFileReferenceParameter() {
		if(!StringUtils.isEmpty(fileReferenceParameter)){
			return getNameAsPrefix(originalName)+fileReferenceParameter;
		}
		return fileReferenceParameter;
	}

	public String getMapParameter() {
		if(!StringUtils.isEmpty(mapParameter)){
			return getNameAsPrefix(originalName)+mapParameter;
		}
		return mapParameter;
	}

	public String getRotateParameter() {
		if(!StringUtils.isEmpty(rotateParameter)){
			return getNameAsPrefix(originalName)+rotateParameter;
		}
		return rotateParameter;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public String getDdGroups() {
		return ddGroups;
	}

	public boolean isAllowUpload() {
		return allowUpload;
	}

	public boolean isTab() {
		return tab;
	}

	public String getLabel() {
		return getFieldLabel();
	}

	public Integer getHeight() {
		return height;
	}

	public String getRequestSuffix() {
		if(StringUtils.isEmpty(originalName)){
			return ".img.png";
		}else{
			return "/"+originalName+".img.png";
		}
	}
}
