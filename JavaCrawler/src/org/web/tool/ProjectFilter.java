package org.web.tool;

public class ProjectFilter {
	private String minMoney="";
	private String maxMoney="";
	private String minDays="";
	private String maxDays="";
	private String minRate="";
	private String maxRate="";
	private String mode="";
	private String tradingMode="";
	private String isCx="";
	private String currentPage="1";
	private String orderCondition="";
	private String isShared="";
	private String canRealized="";
	private String productCategoryEnum="";
	
	
	public ProjectFilter() {
		// TODO Auto-generated constructor stub
	}
	
	public ProjectFilter(ProjectFilter o) {
		// TODO Auto-generated constructor stub
		minMoney=o.minMoney;
		maxMoney=o.maxMoney;
		minDays=o.minDays;
		maxDays=o.maxDays;
		minRate=o.minRate;
		maxRate=o.maxRate;
		mode=o.mode;
		tradingMode=o.tradingMode;
		isCx=o.isCx;
		currentPage=o.currentPage;
		orderCondition=o.orderCondition;
		isShared=o.isShared;
		canRealized=o.canRealized;
		productCategoryEnum=o.productCategoryEnum;
	}
	
	
	public void setPeriod(String min,String max){
		minDays=min;
		maxDays=max;
	}
	
	public void setAmount(String min,String max){
		minMoney=min;
		maxMoney=max;
	}
	
	public String getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(String minMoney) {
		this.minMoney = minMoney;
	}

	public String getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(String maxMoney) {
		this.maxMoney = maxMoney;
	}

	public String getMinDays() {
		return minDays;
	}

	public void setMinDays(String minDays) {
		this.minDays = minDays;
	}

	public String getMaxDays() {
		return maxDays;
	}

	public void setMaxDays(String maxDays) {
		this.maxDays = maxDays;
	}

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		this.minRate = minRate;
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		this.maxRate = maxRate;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTradingMode() {
		return tradingMode;
	}

	public void setTradingMode(String tradingMode) {
		this.tradingMode = tradingMode;
	}

	public String getIsCx() {
		return isCx;
	}

	public void setIsCx(String isCx) {
		this.isCx = isCx;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getOrderCondition() {
		return orderCondition;
	}

	public void setOrderCondition(String orderCondition) {
		this.orderCondition = orderCondition;
	}

	public String getIsShared() {
		return isShared;
	}

	public void setIsShared(String isShared) {
		this.isShared = isShared;
	}

	public String getCanRealized() {
		return canRealized;
	}

	public void setCanRealized(String canRealized) {
		this.canRealized = canRealized;
	}

	public String getProductCategoryEnum() {
		return productCategoryEnum;
	}

	public void setProductCategoryEnum(String productCategoryEnum) {
		this.productCategoryEnum = productCategoryEnum;
	}

	
	
	public String getURL(){
		return "https://list.lu.com/list/p2p?minMoney="+minMoney+"&maxMoney="+maxMoney
				+"&minDays="+minDays+"&maxDays="+maxDays+"&minRate="+minRate+"&maxRate="+maxRate
				+"&mode="+mode+"&tradingMode="+tradingMode+"&isCx="+isCx+"&currentPage="+currentPage
				+"&orderCondition="+orderCondition+"&isShared="+isShared+"&canRealized="+canRealized
				+"&productCategoryEnum="+productCategoryEnum;
		
	}

}
