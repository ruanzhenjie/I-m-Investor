package org.web.tool;


public class ProjectData
{
	private int id;
	/**
	 * ���ӵĵ�ַ
	 */
	private String linkHref;
	/**
	 * ���ӵı���
	 */
	private String linkText;
	/**
	 * ժҪ
	 */
	private String summary;
	/**
	 * ����
	 */
	private String content;
	
	//private String interestRate;
	
	private String interestRate;//����
	
	private String investPeriod;//Ͷ������
	
	private String collectionMode;//���淽ʽ
	
	private String productAmount;//Ͷ�ʽ��

	
	public String getInvestPeriod() {
		return investPeriod;
	}
	public void setInvestPeriod(String investPeriod) {
		this.investPeriod = investPeriod;
	}
	public String getCollectionMode() {
		return collectionMode;
	}
	public void setCollectionMode(String collectionMode) {
		this.collectionMode = collectionMode;
	}
	public String getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLinkHref()
	{
		return linkHref;
	}
	public void setLinkHref(String linkHref)
	{
		this.linkHref = linkHref;
	}
	public String getLinkText()
	{
		return linkText;
	}
	public void setLinkText(String linkText)
	{
		this.linkText = linkText;
	}
	public String getSummary()
	{
		return summary;
	}
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
}
