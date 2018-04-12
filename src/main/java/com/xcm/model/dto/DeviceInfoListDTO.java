package com.xcm.model.dto;

/**
 * 终端列表DTO
 */
public class DeviceInfoListDTO {
	/** 终端信息主键 */
	private String deviceInfoId;
	/** 终端机器码 */
	private String deviceNum;
	/** 终端MAC地址 */
	private String deviceMac;
	/** 终端型号 */
	private String deviceModel;
	/** 终端IP */
	private String deviceIp;
	/** 0.在线; 1.离线 */
	private Integer deviceStatus;
	/** 终端软件版本 */
	private String deviceSoftVer;
	/** 音量设置 */
	private Integer deviceVolume;
	/** 1:启用 0:关闭 */
	private Integer useTimer;
	/** 开机时间 */
	private String bootTime;
	/** 关机时间 */
	private String offTime;
	/** 当前播放 */
	private String playJson;

	public String getDeviceInfoId() {
		return deviceInfoId;
	}

	public void setDeviceInfoId(String deviceInfoId) {
		this.deviceInfoId = deviceInfoId;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public Integer getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getDeviceSoftVer() {
		return deviceSoftVer;
	}

	public void setDeviceSoftVer(String deviceSoftVer) {
		this.deviceSoftVer = deviceSoftVer;
	}

	public Integer getDeviceVolume() {
		return deviceVolume;
	}

	public void setDeviceVolume(Integer deviceVolume) {
		this.deviceVolume = deviceVolume;
	}

	public Integer getUseTimer() {
		return useTimer;
	}

	public void setUseTimer(Integer useTimer) {
		this.useTimer = useTimer;
	}

	public String getBootTime() {
		return bootTime;
	}

	public void setBootTime(String bootTime) {
		this.bootTime = bootTime;
	}

	public String getOffTime() {
		return offTime;
	}

	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}

	public String getPlayJson() {
		return playJson;
	}

	public void setPlayJson(String playJson) {
		this.playJson = playJson;
	}
}
